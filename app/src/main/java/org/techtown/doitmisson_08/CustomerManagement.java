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
    public static final int CUSTOMER_CODE_FROM_MENU = 102;
    public static final int MAIN_CODE_FROM_CUSTOMER = 112;
    public static final int MENU_CODE_FROM_CUSTOMER = 122;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_management);
        Toast.makeText(getApplicationContext(), "메뉴 -> 고객분석", Toast.LENGTH_LONG).show();

        textView = findViewById(R.id.textView6);
        Intent intent = getIntent();
        getData(intent);

        Button main = findViewById(R.id.button6);
        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                setResult(MAIN_CODE_FROM_CUSTOMER, intent);
                finish();
            }
        });

        Button menu = findViewById(R.id.button5);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                setResult(MENU_CODE_FROM_CUSTOMER, intent);
                finish();
            }
        });

    }
    private void getData(Intent intent){
        if(intent != null){
            Bundle bundle = intent.getExtras();
            SimpleData data = bundle.getParcelable("data");
            if(intent != null){
                textView.setText("ID : " + data.ID + "\nPW : " + data.PW);
            }
        }
    }
}