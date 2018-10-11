package politictalk.dsm.Meeting;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import politictalk.dsm.Api;
import politictalk.dsm.Model.PoliListModel;
import politictalk.dsm.R;
import politictalk.dsm.Report.FactionActivity;
import politictalk.dsm.Report.FactionData;
import politictalk.dsm.Report.SearchActivity;
import politictalk.dsm.ServiceGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MeetingMainActivity extends AppCompatActivity implements OnMapReadyCallback{
    ArrayList<MeetingMainData> RecyclerViewer = new ArrayList<>();
    Context context = MeetingMainActivity.this;
    RecyclerView recyclerView;
    MeetingMainAdapter adapter;
    Drawable image;
    ImageView Search;
    String region;
    Random generator = new Random();
    TextView textAddress ;
    String address;
    int num;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_main);
        Search = findViewById(R.id.search);
        textAddress = findViewById(R.id.textView);
        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
                startActivityForResult(intent, 0);
            }
        });

        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
                startActivity(intent);
            }
        });



        FragmentManager fragmentManager = getFragmentManager();
        MapFragment mapFragment = (MapFragment)fragmentManager
                .findFragmentById(R.id.map_meeting_main);
        mapFragment.getMapAsync(this);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        recyclerView = findViewById(R.id.recycler);

//        setData();

        setRecyclerView();



        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_two:
                        Intent intent = new Intent(getApplicationContext(), FactionActivity.class);
                        startActivity(intent);
                        finish();
                        break;
                }
                return false;
            }
        });
    }
    void setRecyclerView(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MeetingMainAdapter(getApplicationContext(), RecyclerViewer);
        recyclerView.setAdapter(adapter);
    }
//    void setData(){
//        for(int i = 0; i < 3; i++) {
//            RecyclerViewer.add(new MeetingMainData(R.drawable.kangbyungwon,"강병원 의원","서울특별시 은평구 시의원", " 2016.05.30~2020.05.30"));
//        }
//    }


    @Override
    public void onMapReady(GoogleMap map) {
        LatLng SEOUL = new LatLng(37.56, 126.97);
        map.moveCamera(CameraUpdateFactory.newLatLng(SEOUL));
        map.animateCamera(CameraUpdateFactory.zoomTo(10));
    }

    public void get(String location) {
        Api retrofit = ServiceGenerator.getClient().create(Api.class);
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("region", region);
        String sibal = null;
        jsonObject.addProperty("position", sibal);
        jsonObject.addProperty("name", sibal);
        Call<List<PoliListModel>> call=retrofit.get_politician(location, "null","null");
        call.enqueue(new Callback<List<PoliListModel>>() {
            @Override
            public void onResponse(Call<List<PoliListModel>> call, Response<List<PoliListModel>> response) {
                if(response.code() == 200) {
                    Toast.makeText(context, "조회 성공", Toast.LENGTH_SHORT).show();
                    adapter.people.clear();
                    List<PoliListModel> poliModelsList = response.body();
                    for (PoliListModel model : poliModelsList) {
                        adapter.people.add(new MeetingMainData(model.getPhoto(),model.getName() + " 의원", model.getAddress(), model.getBirthDay(),model.getPoliticianId()));
                    }

                    adapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(context, "조회 실패", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<PoliListModel>> call, Throwable t) {
                Toast.makeText(context, "모델이 잘못됐을거야", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
