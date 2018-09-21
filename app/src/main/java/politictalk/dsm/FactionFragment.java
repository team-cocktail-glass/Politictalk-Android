/*
package politictalk.dsm;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

import politictalk.dsm.Report.FactionActivity;
import politictalk.dsm.Report.FactionAdapter;
import politictalk.dsm.Report.FactionData;

public class FactionFragment extends Fragment implements OnMapReadyCallback{

    ArrayList<FactionData> singleModels = new ArrayList<>();
    RecyclerView recyclerView;
    FactionAdapter adapter;
    Drawable image;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedlnstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.activity_faction ,container, false);
        FragmentManager fragmentManager = getFragmentManager();
        MapFragment mapFragment = (MapFragment)fragmentManager
                .findFragmentById(R.id.map_facion);
        mapFragment.getMapAsync(this);

        recyclerView = viewGroup.findViewById(R.id.recycler);

        setData();

        setRecyclerView();


        return inflater.inflate(R.layout.activity_faction, container, false);
    }

    void setRecyclerView(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new FactionAdapter(getActivity(), singleModels);
        recyclerView.setAdapter(adapter);
    }
    void setData(){
        singleModels.add(new FactionData(R.drawable.kangbyungwon,"강병원 의원","서울특별시 은평구 시의원",3, 121, " 2016.05.30~2020.05.30"));
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng SEOUL = new LatLng(37.56, 126.97);
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(SEOUL));
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(10));
    }
}
*/