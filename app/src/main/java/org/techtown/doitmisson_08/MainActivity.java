package org.techtown.doitmisson_08;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final int MENU_CODE_FROM_MAIN = 101; //요청코드
    public static final int MAIN_CODE_FROM_CUSTOMER = 112;
    public static final int MAIN_CODE_FROM_SALES = 113;
    public static final int MAIN_CODE_FROM_PRODUCT = 114;

    EditText editText;
    EditText editText2;
    String ID;
    String PW;

    @Override
    protected void onActivityResult(int requestCode, int resultcode, @Nullable Intent data) { //받는 코드
        super.onActivityResult(requestCode, resultcode, data);
        if(resultcode == MAIN_CODE_FROM_CUSTOMER){
            Toast.makeText(getApplicationContext(), "고객관리에서 응답", Toast.LENGTH_LONG).show();;
        }
        else if(resultcode == MAIN_CODE_FROM_SALES) {
            Toast.makeText(getApplicationContext(), "매출관리에서 응답", Toast.LENGTH_LONG).show();
        }
        else if(resultcode == MAIN_CODE_FROM_PRODUCT) {
            Toast.makeText(getApplicationContext(), "상품관리에서 응답", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);

        editText.getText().toString();
        editText2.getText().toString();

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() { //보내는 코드
            @Override
            public void onClick(View v) {
                if(checkID()){
                    Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                    SimpleData data = new SimpleData(ID, PW);
                    intent.putExtra("data", (Parcelable) data);
                    startActivityForResult(intent,MENU_CODE_FROM_MAIN); //요청코드
                }
                else{
                    Toast.makeText(getApplicationContext(), "ID/PW를 입력하세요", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private boolean checkID(){
        ID = editText.getText().toString();
        PW = editText2.getText().toString();

        if(ID.length() < 1 || PW.length() < 1) {
            return false;
        }
        else return true;
    }
}