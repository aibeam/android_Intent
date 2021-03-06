package com.example.sampleintent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_MENU = 101;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void callMenu(View view) {
        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
        startActivityForResult(intent, REQUEST_CODE_MENU);
        //startActivityForResult = 돌아올때 씀. 걍 가는건 startActivity
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_MENU) {
            Toast.makeText(this, "요청코드: "+REQUEST_CODE_MENU+
                    " / 결과코드: "+resultCode, Toast.LENGTH_SHORT).show();
        }
        if (resultCode == RESULT_OK) {
            String name = data.getStringExtra("name");
            Toast.makeText(this, "전달된 name: " + name, Toast.LENGTH_SHORT).show();
        }
    }
}