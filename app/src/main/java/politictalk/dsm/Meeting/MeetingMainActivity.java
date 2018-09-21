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

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

import politictalk.dsm.R;
import politictalk.dsm.Report.FactionActivity;

public class MeetingMainActivity extends AppCompatActivity implements OnMapReadyCallback{
    ArrayList<MeetingMainData> RecyclerViewer = new ArrayList<>();
    Context context = MeetingMainActivity.this;
    RecyclerView recyclerView;
    MeetingMainAdapter adapter;
    Drawable image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_main);

        FragmentManager fragmentManager = getFragmentManager();
        MapFragment mapFragment = (MapFragment)fragmentManager
                .findFragmentById(R.id.map_meeting_main);
        mapFragment.getMapAsync(this);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        recyclerView = findViewById(R.id.recycler);

        setData();

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
    void setData(){
        for(int i = 0; i < 3; i++) {
            RecyclerViewer.add(new MeetingMainData(R.drawable.kangbyungwon,"강병원 의원","서울특별시 은평구 시의원", " 2016.05.30~2020.05.30"));
        }
    }


    @Override
    public void onMapReady(GoogleMap map) {
        LatLng SEOUL = new LatLng(37.56, 126.97);
        map.moveCamera(CameraUpdateFactory.newLatLng(SEOUL));
        map.animateCamera(CameraUpdateFactory.zoomTo(10));
    }
}
