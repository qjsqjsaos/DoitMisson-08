package org.techtown.doitmisson_08;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    public static final int MENU_CODE_FROM_MAIN = 101;
    public static final int CUSTOMER_CODE_FROM_MENU = 102;
    public static final int MAIN_CODE_FROM_CUSTOMER = 112;
    public static final int MENU_CODE_FROM_CUSTOMER = 122;
    public static final int SALES_CODE_FROM_MENU = 103;
    public static final int MAIN_CODE_FROM_SALES = 113;
    public static final int MENU_CODE_FROM_SALES = 123;
    public static final int PRODUCT_CODE_FROM_MENU = 104;
    public static final int MAIN_CODE_FROM_PRODUCT = 114;
    public static final int MENU_CODE_FROM_PRODUCT = 124;
    SimpleData data;


    protected void onActivityResult(int requestcode, int resultcode Intent data) { //받는 코드
        super.onActivityResult(requestcode,resultcode, data);
        if(resultcode == MENU_CODE_FROM_MAIN) {
            Toast.makeText(getApplicationContext(), "메인 -> 메뉴", Toast.LENGTH_LONG).show();
        }
        else if(resultcode == MENU_CODE_FROM_CUSTOMER) {
            Toast.makeText(getApplicationContext(), "고객관리 -> 메뉴", Toast.LENGTH_LONG).show();
        }
        else if(resultcode == MAIN_CODE_FROM_CUSTOMER) { //고객관리에서 메인
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            setResult(MAIN_CODE_FROM_CUSTOMER, intent); //메뉴를 거쳤다가 메인으로 가게 만들기 위함(코드를 메인으로 전달)
            finish(); //메인으로 돌아가면서 앞에 메뉴와 고객관리 창들은 닫힌다.
        }
        else if(resultcode == MENU_CODE_FROM_SALES) {
            Toast.makeText(getApplicationContext(), "매출관리 -> 메뉴", Toast.LENGTH_LONG).show();
        }
        else if(resultcode == MAIN_CODE_FROM_SALES) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            setResult(MAIN_CODE_FROM_SALES, intent);
            finish();
        }
        else if(resultcode == MENU_CODE_FROM_PRODUCT){
            Toast.makeText(getApplicationContext(), "상품관리 -> 메뉴", Toast.LENGTH_LONG).show();
        }
        else if(resultcode == MAIN_CODE_FROM_PRODUCT) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            setResult(MAIN_CODE_FROM_PRODUCT, intent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) { //보내는 코드
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        data = getData(getIntent());

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CustomerManagement.class);
                intent.putExtra("data", data);
                startActivityForResult(intent, CUSTOMER_CODE_FROM_MENU);
            }
        });

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SalesManagement.class);
                intent.putExtra("data", data);
                startActivityForResult(intent, SALES_CODE_FROM_MENU);
            }
        });

        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ProductionManagerment.class);
                intent.putExtra("data", data);
                startActivityForResult(intent, PRODUCT_CODE_FROM_MENU);
            }
        });
    }
    private SimpleData getData(Intent intent) { //데이터 전달은 putExtra 데이터를 받는 것은 getExtras이다.
        if(intent != null){
            Bundle bundle = intent.getExtras();
            SimpleData data = bundle.getParcelable("data");
            return data;
        }
        else {
            return null;
        }
    }
}