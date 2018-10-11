package politictalk.dsm.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonObject;

import politictalk.dsm.Api;
import politictalk.dsm.R;
import politictalk.dsm.Report.FactionActivity;
import politictalk.dsm.ServiceGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    EditText editText2;
    EditText editText3;
    String id;
    String pw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextView signup;
        TextView login;

        signup = findViewById(R.id.signup);
        login = findViewById(R.id.button2);

        editText2=findViewById(R.id.editText2);
        editText3=findViewById(R.id.editText3);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), SignUpActivity.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id=editText2.getText().toString();
                pw=editText3.getText().toString();
                post();
            }
        });

    }
    public void post(){
        Api retrofit= ServiceGenerator.getClient().create(Api.class);
        JsonObject jsonObject=new JsonObject();
        jsonObject.addProperty("id",id);
        jsonObject.addProperty("password",pw);
        Call<Void> call=retrofit.post_login(jsonObject);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
             if (response.code()==200){
                 Toast.makeText(getApplicationContext(), "로그인에 성공했습니다.", Toast.LENGTH_SHORT).show();
                 Intent intent = new Intent(getBaseContext(), FactionActivity.class);
                 startActivity(intent);
             }else {
                 Toast.makeText(getApplicationContext(), "아이디와 비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show();
             }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }
}
