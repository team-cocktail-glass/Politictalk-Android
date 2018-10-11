package politictalk.dsm.Report;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
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

import com.bumptech.glide.Glide;
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
import politictalk.dsm.Meeting.MeetingMainActivity;
import politictalk.dsm.Model.PoliListModel;
import politictalk.dsm.R;
import politictalk.dsm.ServiceGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FactionActivity extends AppCompatActivity implements OnMapReadyCallback{

    ArrayList<FactionData> singleModels = new ArrayList<>();
    Context context = FactionActivity.this;
    RecyclerView recyclerView;
    FactionAdapter adapter;
    Drawable image;
    ImageView Search;
    String region;
    Random generator = new Random();
    TextView textAddress;
    String address;
    int num;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faction);
        textAddress = findViewById(R.id.textView);
        Search = findViewById(R.id.search);
        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
                startActivityForResult(intent,0);
            }
        });
        FragmentManager fragmentManager = getFragmentManager();
        MapFragment mapFragment = (MapFragment)fragmentManager
                .findFragmentById(R.id.map_facion);
        mapFragment.getMapAsync(this);

        recyclerView = findViewById(R.id.recycler);

//        setData();

        setRecyclerView();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_three:
                        Intent intent = new Intent(getApplicationContext(), MeetingMainActivity.class);
                        startActivity(intent);
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
        adapter = new FactionAdapter(getApplicationContext(), singleModels);
        recyclerView.setAdapter(adapter);
    }
//    void setData(){
//        singleModels.add(new FactionData(R.drawable.kangbyungwon,"강병원 의원","서울특별시 은평구 시의원",3, 121, " 2016.05.30~2020.05.30"));
//    }


    @Override
    public void onMapReady(GoogleMap map) {
        LatLng SEOUL = new LatLng(37.56, 126.97);
        map.moveCamera(CameraUpdateFactory.newLatLng(SEOUL));
        map.animateCamera(CameraUpdateFactory.zoomTo(10));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK){
            Toast.makeText(context, data.getStringExtra("location"), Toast.LENGTH_SHORT).show();
            get(data.getStringExtra("location"));
            address = data.getStringExtra("location");
            textAddress.setText(address);
//            Toast.makeText(context, "TEST", Toast.LENGTH_SHORT).show();
        }
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
                        adapter.people.add(new FactionData(model.getPhoto(),model.getName() + " 의원", model.getAddress(), num=generator.nextInt(50), num=generator.nextInt(100), model.getBirthDay(),model.getPoliticianId()));
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