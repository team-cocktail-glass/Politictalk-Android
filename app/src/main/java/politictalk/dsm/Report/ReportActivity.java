package politictalk.dsm.Report;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import politictalk.dsm.R;

public class ReportActivity extends AppCompatActivity {
    
    ArrayList<ReportData> politicsModels = new ArrayList<>();
    Context context = ReportActivity.this;
    RecyclerView recyclerView;
    ReportAdapter adapter;
    Drawable image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        
        recyclerView = findViewById(R.id.recycler);
        
        setData();
        
        setRecyclerView();
    }
    void setRecyclerView(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ReportAdapter(getApplicationContext(), politicsModels);
        recyclerView.setAdapter(adapter);
    }
    void setData(){
        for(int i = 0; i < 10; i++)
            politicsModels.add(new ReportData(R.drawable.scenery, "박진영", "너무 이뻐요 누나아아", "2018.06.14~2022.06.01", "40"));
    }
}
