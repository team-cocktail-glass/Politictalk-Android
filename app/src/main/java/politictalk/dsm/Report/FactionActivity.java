package politictalk.dsm.Report;

import android.app.FragmentManager;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

import politictalk.dsm.R;

public class FactionActivity extends AppCompatActivity implements OnMapReadyCallback{

    ArrayList<FactionData> singleModels = new ArrayList<>();
    Context context = FactionActivity.this;
    RecyclerView recyclerView;
    FactionAdapter adapter;
    Drawable image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faction);

        FragmentManager fragmentManager = getFragmentManager();
        MapFragment mapFragment = (MapFragment)fragmentManager
                .findFragmentById(R.id.map_faction);
        mapFragment.getMapAsync(this);

        recyclerView = findViewById(R.id.recycler);

        setData();

        setRecyclerView();
    }
    void setRecyclerView(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new FactionAdapter(getApplicationContext(), singleModels);
        recyclerView.setAdapter(adapter);
    }
    void setData(){
        for(int i = 0; i < 10; i++)
            singleModels.add(new FactionData(R.drawable.iu,"아이유 의원","대전광역시 유성구 시의원",3, 121, "2018.06.14~2022.06.01"));
    }


    @Override
    public void onMapReady(GoogleMap map) {
        LatLng SEOUL = new LatLng(37.56, 126.97);
        map.moveCamera(CameraUpdateFactory.newLatLng(SEOUL));
        map.animateCamera(CameraUpdateFactory.zoomTo(10));
    }
}