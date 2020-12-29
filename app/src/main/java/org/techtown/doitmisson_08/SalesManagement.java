package org.techtown.doitmisson_08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SalesManagement extends AppCompatActivity {

    int GO_TO_MENU2 = 104;
    int GO_TO_MAIN2 = 105;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_management);

        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                setResult(GO_TO_MENU2);
                Toast.makeText(getApplicationContext(), "매출 -> 메뉴", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                setResult(GO_TO_MAIN2);
                Toast.makeText(getApplicationContext(), "매출 -> 메인", Toast.LENGTH_LONG).show();
                finish();
            }
        });

    }
}