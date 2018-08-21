package politictalk.dsm.Report;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import politictalk.dsm.R;

public class ChoicePeopleActivity extends AppCompatActivity {

    ArrayList<ReportData> singleModels = new ArrayList<>();
    Context context = ChoicePeopleActivity.this;
    RecyclerView recyclerView;
    ReportAdapter adapter;
    Drawable image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_people);

        recyclerView = findViewById(R.id.recycler);

        setPeopleData();

        setRecyclerView();
    }

    void setRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ReportAdapter(getApplicationContext(), singleModels);
        recyclerView.setAdapter(adapter);
    }

    void setPeopleData() {
        for (int i = 0; i < 10; i++)
            singleModels.add(new ReportData(R.drawable.iu, "박진영", "이건 너무한거 아니오", 40, "2018.06.14~2022.06.01"));
    }
}