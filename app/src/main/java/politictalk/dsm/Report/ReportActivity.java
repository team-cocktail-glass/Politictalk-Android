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
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import politictalk.dsm.Api;
import politictalk.dsm.Meeting.MeetingMainActivity;
import politictalk.dsm.Model.PoliListModel;
import politictalk.dsm.R;
import politictalk.dsm.ServiceGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReportActivity extends AppCompatActivity {

    ArrayList<ReportData> politicsModels = new ArrayList<>();
    Context context = ReportActivity.this;
    RecyclerView recyclerView;
    ReportAdapter adapter;
    Drawable image;
    ImageView backImg;
    String pId;
    TextView textName;
    String name;
    ImageView imagePicture;

    TextView textAdress;
    String address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        Intent intent = getIntent();
        pId = intent.getStringExtra("pId");
        recyclerView = findViewById(R.id.recycler);
        backImg = findViewById(R.id.place);
        textName = findViewById(R.id.title);
        textAdress = findViewById(R.id.address);
        imagePicture = findViewById(R.id.userprofile);

        get();
        Log.d("Debug","AFADSFADSF : "+ pId);

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
                intent.putExtra("pId", pId);
                startActivity(intent);
                finish();
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
        adapter = new ReportAdapter(getApplicationContext(), politicsModels);
        recyclerView.setAdapter(adapter);
    }

    void setData(){
        for(int i = 0; i < 3; i++)
            politicsModels.add(new ReportData(R.drawable.scenery, "박진영", "너무 이뻐요 누나아아", "2018.06.14~2022.06.01", "40"));
    }

    public void get() {
        Api retrofit = ServiceGenerator.getClient().create(Api.class);
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("politicianID", pId);
        Log.d("pid",pId+" ");
        retrofit.politician(pId).enqueue(new Callback<PoliListModel>() {
            @Override
            public void onResponse(Call<PoliListModel> call, Response<PoliListModel> response) {
                if(response.code() == 200) {
                    Toast.makeText(context, "조회 성공", Toast.LENGTH_SHORT).show();
                    name = response.body().getName().toString();
                    textName.setText(name + " 의원");
                    address = response.body().getAddress().toString();
                    Log.d("DEBUG", "asfadf" + address );
                    textAdress.setText(address);
                    Glide.with(context).load(response.body().getPhoto()).into(imagePicture);
                }
            }

            @Override
            public void onFailure(Call<PoliListModel> call, Throwable t) {

            }
        });

    }
}