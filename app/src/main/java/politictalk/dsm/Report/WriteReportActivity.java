package politictalk.dsm.Report;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import politictalk.dsm.Meeting.MeetingMainActivity;
import politictalk.dsm.R;

public class WriteReportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_report);

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
                        break;
                }
                return false;
            }
        });
    }
}
