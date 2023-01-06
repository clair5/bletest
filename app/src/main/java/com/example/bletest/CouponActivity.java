package com.example.bletest;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

public class CouponActivity extends AppCompatActivity {

    ImageView imageView;
    ImageButton imageButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupon);

        //CH 쿠폰 활성화/비활성화
        SharedPreferences sharedPreferences= getSharedPreferences("stamp", MODE_PRIVATE);    // test 이름의 기본모드 설정, 만약 test key값이 있다면 해당 값을 불러옴.
        int stamp1 = sharedPreferences.getInt("church",0); // 0번지에 church 스캔 결과 저장
        System.out.println("church : "+stamp1);
        int stamp2 = sharedPreferences.getInt("museum",0); // 1번지에 museum 스캔 결과 저장
        System.out.println("museum : "+stamp2);

        imageView = findViewById(R.id.imgCouponCH);
        if(stamp1 == 1) {
            imageView.setVisibility(View.VISIBLE);
        }
        else{
            imageView.setVisibility(View.INVISIBLE);
        }
        imageView = (ImageView) findViewById(R.id.imgCouponMU);
        if(stamp2 == 1) {
            imageView.setVisibility(View.VISIBLE);
        }
        else{
            imageView.setVisibility(View.INVISIBLE);
        }
        //CH 쿠폰 활성화/비활성화


        imageButton = (ImageButton) findViewById(R.id.btnX);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }

        });
    }
}