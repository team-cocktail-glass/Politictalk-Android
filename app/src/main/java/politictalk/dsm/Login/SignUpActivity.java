package politictalk.dsm.Login;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.common.images.ImageRequest;
import com.google.gson.JsonObject;

import politictalk.dsm.Api;
import politictalk.dsm.R;
import politictalk.dsm.Report.FactionActivity;
import politictalk.dsm.Report.ViewReportActivity;
import politictalk.dsm.ServiceGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {
    EditText email;
    EditText password;
    EditText passwordCheck;
    String id;
    String pw;
    String pwcheck;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Button done = findViewById(R.id.done);
        ImageView backImg = findViewById(R.id.back);
        email=findViewById(R.id.email);
        password = findViewById(R.id.password);
        passwordCheck = findViewById(R.id.checkpassword);

        backImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = email.getText().toString();
                pw = password.getText().toString();
                pwcheck = passwordCheck.getText().toString();
                if (!pw.equals(pwcheck)) {
                    Toast.makeText(getApplicationContext(), "비밀번호를 확인하세요.", Toast.LENGTH_SHORT).show();
                } else if(pw.equals(pwcheck)) {
                    signup();
                }

//                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        switch (which){
//                            case DialogInterface.BUTTON_POSITIVE:
//                                Toast.makeText(getApplicationContext(), "회원가입이 완료되었습니다!.", Toast.LENGTH_SHORT).show();
//                                finish();
//                                break;
//
//                            case DialogInterface.BUTTON_NEGATIVE:
//                                Toast.makeText(getApplicationContext(), "취소되었습니다.", Toast.LENGTH_SHORT).show();
//                                break;
//                        }
//                    }
//                };
//
//                AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
//                builder.setMessage("회원가입을 하시겠습니까?").setPositiveButton("네", dialogClickListener)
//                        .setNegativeButton("취소", dialogClickListener).show();
//            }
//        });
            }

            public void signup() {
                Api retrofit = ServiceGenerator.getClient().create(Api.class);
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("birthDay", "2018-10-09T08:27:39.280Z");
                jsonObject.addProperty("email", id);
                jsonObject.addProperty("name", "haru");
                jsonObject.addProperty("password", pw);
                jsonObject.addProperty("region","haru");
                jsonObject.addProperty("userId", id);
                Call<Void> call = retrofit.post_signup(jsonObject);
                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if (response.code() == 201) {
                            Toast.makeText(getApplicationContext(), "회원가입이 완료되었습니다.", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getBaseContext(), LoginActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(getApplicationContext(), "이미 아이디가 있습니다.", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                    }
                });
            }
        });
    }
}