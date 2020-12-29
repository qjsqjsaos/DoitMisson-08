package org.techtown.doitmisson_08;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int RESULT_CODE_MAIN = 100; //메뉴로 보낸뒤 다시 메뉴에서 이 값을 보냄

    TextView textView;
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userid = textView.getText().toString(); //입력값 가져와서 변수에 넣기
                String userpw = textView2.getText().toString();

                if(textView.length() != 0 && textView2.length() != 0) { //둘다 참이 되어야 성립되는 연산자 &&, ~이 아닐때 => "!="
                    Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                    intent.putExtra("userid",userid);
                    intent.putExtra("userpw", userpw);
                    startActivityForResult(intent, RESULT_CODE_MAIN);
                    Toast.makeText(getApplicationContext(), "로그인 되었습니다.", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "아이디와 비밀번호를 확인해주세요", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}

