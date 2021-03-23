package com.example.halthlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText eName;
    private EditText ePassword;
    private Button eLogin;
    private TextView eAttemptsInfo;


    private String Username = "cmyk"; //  사용자 Id = : cmyk
    private String Password = "6666"; // 사용자 패스워드 : 6666

    boolean isValid = false;
    private  int counter = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        eName = findViewById(R.id.etName);
        ePassword = findViewById(R.id.etPassword);
        eLogin = findViewById(R.id.btnLogin);
        eAttemptsInfo = findViewById(R.id.tvAttemptsinfo);


        eLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String inputName = eName.getText().toString();
                String inputPassword = ePassword.getText().toString();

                if(inputName.isEmpty() || inputPassword.isEmpty()){
                    Toast.makeText( LoginActivity.this,  "세부사항 정보를 모두 입력해주세요.", Toast.LENGTH_SHORT).show(); // 로그인 똑바로 안치면 이따구로 뜸
                }else {
                    isValid = validate(inputName, inputPassword);


                    if (!isValid) {
                        counter--;
                        Toast.makeText(LoginActivity.this, "잘못된 입력입니다.\n ID PW 다시 확인해주세요.", Toast.LENGTH_SHORT).show(); // 틀리면 이거 출력

                        eAttemptsInfo.setText("로그인 남은 시도 횟수 : "+ counter); // ID, PW 틀리면 로그인 남은 시도 횟수 알려주는거

                        if (counter == 0) {
                            eLogin.setEnabled(false); // 5회 끝나면 로그인 막힘
                        }
                    } else {
                        Toast.makeText(LoginActivity.this, "로그인 성공 환영합니다.", Toast.LENGTH_SHORT).show();
                         Intent intent = new Intent(LoginActivity.this, Homepage .class); // Intent intent = new Intent(LoginActivity.this, 헬스 메인 이름.class); 변경해줘야지 헬스 메인 화면으로 넘어감
                        startActivity(intent);
                    }

                }



            }
        });

    }
    private  boolean validate(String name, String password){

        if(name.equals(Username) && password.equals(password)){
            return true;
        }
        return false;
    }
}