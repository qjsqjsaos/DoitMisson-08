package org.techtown.doitmisson_08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ProductionManagerment extends AppCompatActivity {

    int GO_TO_MENU3 = 106;
    int GO_TO_MAIN4 = 107;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_production_managerment);

        Button button9 = findViewById(R.id.button9);
        Button button10 = findViewById(R.id.button10);

        Intent intent = getIntent();
        String text = intent.getStringExtra("menu");
        Toast.makeText(getApplicationContext(), text + "에서 왔습니다.", Toast.LENGTH_LONG).show();

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                setResult(GO_TO_MENU3);
                Toast.makeText(getApplicationContext(), "상품 -> 메뉴", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                setResult(GO_TO_MAIN4);
                Toast.makeText(getApplicationContext(), "상품 -> 메인", Toast.LENGTH_LONG).show();
                finish();
            }
        });

    }
}