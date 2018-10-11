package politictalk.dsm.Report;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.JsonObject;

import politictalk.dsm.Api;
import politictalk.dsm.Meeting.MeetingMainActivity;
import politictalk.dsm.Model.PoliListModel;
import politictalk.dsm.R;
import politictalk.dsm.ServiceGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WriteReportActivity extends AppCompatActivity {
   String pId;
   TextView textName;
   String name;
   TextView textAddress;
   String address;
   ImageView imagePicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        pId = intent.getStringExtra("pId");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_report);

        get();
        Log.d("DEBUG", "asdafs" + pId);

        textName = findViewById(R.id.title);
        textAddress = findViewById(R.id.address);
        imagePicture = findViewById(R.id.userprofile);

        ImageView backImg;
        Button done;

        backImg = findViewById(R.id.place);
        done = findViewById(R.id.done);

        backImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        done.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "완료되었습니다.", Toast.LENGTH_SHORT).show();
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

    public void get() {
        Api retrofit = ServiceGenerator.getClient().create(Api.class);
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("politicianID", pId);
        Log.d("DEBUG", pId + " ");
        retrofit.politician(pId).enqueue(new Callback<PoliListModel>() {
            @Override
            public void onResponse(Call<PoliListModel> call, Response<PoliListModel> response) {
                if(response.code() == 200) {
                    Toast.makeText(getApplicationContext(), "asdf", Toast.LENGTH_SHORT).show();
                    name = response.body().getName().toString();
                    textName.setText(name + " 의원");
                    address = response.body().getAddress().toString();
                    textAddress.setText(address);
                    Glide.with(getApplicationContext()).load(response.body().getPhoto()).into(imagePicture);
                }
            }

            @Override
            public void onFailure(Call<PoliListModel> call, Throwable t) {

            }
        });
    }
}
