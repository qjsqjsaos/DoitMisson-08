package org.techtown.doitmisson_08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class CustomerManagement extends AppCompatActivity {

    int GO_TO_MENU = 102;
    int GO_TO_MAIN = 103;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_management);

        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);

        Intent intent = getIntent();
        String text = intent.getStringExtra("menu");
        Toast.makeText(getApplicationContext(), text + "에서 왔습니다.", Toast.LENGTH_LONG).show();

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                setResult(GO_TO_MENU);
                Toast.makeText(getApplicationContext(), "고객 -> 메뉴", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                setResult(GO_TO_MAIN);
                Toast.makeText(getApplicationContext(), "고객 -> 메인", Toast.LENGTH_LONG).show();
                finish();
            }
        });

    }
}