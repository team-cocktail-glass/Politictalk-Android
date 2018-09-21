package politictalk.dsm.Report;

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
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

import politictalk.dsm.Meeting.MeetingMainActivity;
import politictalk.dsm.R;

public class ReportActivity extends AppCompatActivity {
    
    ArrayList<ReportData> politicsModels = new ArrayList<>();
    Context context = ReportActivity.this;
    RecyclerView recyclerView;
    ReportAdapter adapter;
    Drawable image;
    ImageView backImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        
        recyclerView = findViewById(R.id.recycler);
        backImg = findViewById(R.id.place);

        backImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        setData();
        
        setRecyclerView();
        ImageView writeButton = findViewById(R.id.create);
        writeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), WriteReportActivity.class);
                startActivity(intent);
            }
        });

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
        adapter = new ReportAdapter(getApplicationContext(), politicsModels);
        recyclerView.setAdapter(adapter);
    }
    void setData(){
        for(int i = 0; i < 3; i++)
            politicsModels.add(new ReportData(R.drawable.scenery, "박진영", "너무 이뻐요 누나아아", "2018.06.14~2022.06.01", "40"));
    }
}