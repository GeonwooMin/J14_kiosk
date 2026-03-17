package com.example.j14_moviekiosktaphostapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends TabActivity {

    RadioButton rb1, rb2, rb3, rb4, rb5, rb6;
    EditText count;
    Button orderBtn;
    TextView result;

    Integer totalaMoney=0;
    int c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabHost=getTabHost();

        TabHost.TabSpec movie = tabHost.newTabSpec("movie").setIndicator("JA MOVIE");
        movie.setContent(R.id.contentMovie);
        tabHost.addTab(movie);

        TabHost.TabSpec kiosk=tabHost.newTabSpec("kiosk").setIndicator("디저트 ORDER");
        kiosk.setContent(R.id.contentKiosk);
        tabHost.addTab(kiosk);
        tabHost.setCurrentTab(0); // 앱 실행 시 먼저 보여지는 순서 - 이 앱에서는 위의 'JA MOVIE'가 먼저 보임

        ImageView movie01,movie02,movie03,movie04;
        movie01=(ImageView) findViewById(R.id.movie01);
        movie02=(ImageView) findViewById(R.id.movie02);
        movie03=(ImageView) findViewById(R.id.movie03);
        movie04=(ImageView) findViewById(R.id.movie04);

        Intent it = new Intent(this,ShowMovie.class);

        movie01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tag=(String)view.getTag();
                it.putExtra("it_tag",tag);
                startActivity(it);
            }
        });

        movie02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tag=(String)view.getTag();
                it.putExtra("it_tag",tag);
                startActivity(it);
            }
        });

        movie03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tag=(String)view.getTag();
                it.putExtra("it_tag",tag);
                startActivity(it);
            }
        });

        movie04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tag=(String)view.getTag();
                it.putExtra("it_tag",tag);
                startActivity(it);
            }
        });

        //키오스크
        rb1=(RadioButton) findViewById(R.id.m1);
        rb2=(RadioButton) findViewById(R.id.m2);
        rb3=(RadioButton) findViewById(R.id.m3);
        rb4=(RadioButton) findViewById(R.id.m4);
        rb5=(RadioButton) findViewById(R.id.m5);
        rb6=(RadioButton) findViewById(R.id.m6);

        count=(EditText) findViewById(R.id.count);
        orderBtn=(Button)findViewById(R.id.orderBtn);
        result=(TextView) findViewById(R.id.result);

        orderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c = Integer.parseInt(count.getText().toString());
                //String cc=count.getText().toString().trim();

                if (rb1.isChecked() == true) {
                    totalaMoney = c * 500;
                }
                if (rb2.isChecked() == true) {
                    totalaMoney = c * 600;
                }
                if (rb3.isChecked() == true) {
                    totalaMoney = c * 700;
                }
                if (rb4.isChecked() == true) {
                    totalaMoney = c * 800;
                }
                if (rb5.isChecked() == true) {
                    totalaMoney = c * 900;
                }
                if (rb6.isChecked() == true) {
                    totalaMoney = c * 1000;
                }

                result.setText("총금액: " + totalaMoney.toString());

            }


        });

    }//onCreate
}//MainActivity