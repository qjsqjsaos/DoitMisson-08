package org.techtown.doitmisson_08;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    int RESULT_CODE_MENU = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent intent = getIntent();
        String userid = intent.getStringExtra("userid"); //메인에 putExtra로 넣어 놨던 userid를 가져온다.
        Toast.makeText(getApplicationContext(), userid + "님이 로그인 하셨습니다.(Main)", Toast.LENGTH_LONG).show();

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goSub("고객");
            }
        });

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goSub("매출");
            }
        });

        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goSub("상품");
            }
        });

    }

    private void goSub(String menu) {
        String menuName = menu;
        if(menuName == "고객"){
            Intent intent = new Intent(getApplicationContext(), CustomerManagement.class);
            intent.putExtra("menu", menuName);
            startActivityForResult(intent, RESULT_CODE_MENU);
        }
        else if(menuName == "매출"){
            Intent intent = new Intent(getApplicationContext(), SalesManagement.class);
            intent.putExtra("menu", menuName);
            startActivityForResult(intent, RESULT_CODE_MENU);
        }
        else if(menuName == "상품") {
            Intent intent = new Intent(getApplicationContext(), ProductionManagerment.class);
            intent.putExtra("menu", menuName);
            startActivityForResult(intent, RESULT_CODE_MENU);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode != 102) //만약 서브 액티비티에서 로그인으로 이동하려면 메뉴를 거처야 하는데, 거칠때 메뉴가 꺼지는 코드
            finish();

    }
}

