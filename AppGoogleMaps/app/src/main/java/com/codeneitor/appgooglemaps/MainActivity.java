package com.codeneitor.appgooglemaps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button bt1, bt2, bt3, bt4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        bt3 = findViewById(R.id.bt3);
        bt4 = findViewById(R.id.bt4);

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        Intent intent;
        switch (view.getId()){
            case R.id.bt1:
                intent = new Intent(MainActivity.this, MapsActivity.class);
                intent.putExtra("lugar",0);
                startActivity(intent);
                break;
            case R.id.bt2:
                intent = new Intent(MainActivity.this, MapsActivity.class);
                intent.putExtra("lugar",1);
                startActivity(intent);
                break;
            case R.id.bt3:
                intent = new Intent(MainActivity.this, MapsActivity.class);
                intent.putExtra("lugar",2);
                startActivity(intent);
                break;
            case R.id.bt4:
                intent = new Intent(MainActivity.this, MapsActivity.class);
                intent.putExtra("lugar",3);
                startActivity(intent);
                break;
        }

    }

}
