package politictalk.dsm.Meeting;

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

import java.util.ArrayList;

import politictalk.dsm.R;
import politictalk.dsm.Report.FactionActivity;
import politictalk.dsm.Report.ReportAdapter;
import politictalk.dsm.Report.ReportData;

public class MeetingChoiceActivity extends AppCompatActivity {
    ArrayList<ChoiceData> politicsModels = new ArrayList<>();
    Context context = MeetingChoiceActivity.this;
    RecyclerView recyclerView;
    ChoiceAdapter adapter;
    Drawable image;
    ImageView backImg;
    ImageView application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_choice);

        recyclerView = findViewById(R.id.recycler);
        backImg = findViewById(R.id.place);
        application = findViewById(R.id.apply);

        application.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), WriteMeetingActivity.class);
                startActivity(intent);
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_two:
                        Intent intent = new Intent(getApplicationContext(), FactionActivity.class);
                        startActivity(intent);
                        break;
                }
                return false;
            }
        });

        backImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        setData();

        setRecyclerView();

    }

    void setRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ChoiceAdapter(getApplicationContext(), politicsModels);
        recyclerView.setAdapter(adapter);
    }

    void setData(){
        politicsModels.add(new ChoiceData(R.drawable.scenery, "만나길 원합니다.", "박진영", "D-30", 3000));
    }
}
