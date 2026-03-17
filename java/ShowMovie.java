package com.example.j14_moviekiosktaphostapp;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ShowMovie extends AppCompatActivity {
    TextView title,director,actor,synopsys;
    ImageView poster;
    Button teaserShow;
    String tag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showmovie);

        title=(TextView) findViewById(R.id.title);
        director=(TextView) findViewById(R.id.director);
        actor=(TextView) findViewById(R.id.actor);
        synopsys=(TextView) findViewById(R.id.synopsys);
        poster=(ImageView) findViewById(R.id.poster);
        teaserShow=(Button) findViewById(R.id.teaserShow);

        Resources res = getResources();
        Intent it=getIntent();
        tag=it.getStringExtra("it_tag");

        //Toast.makeText(getApplicationContext(),tag,Toast.LENGTH_SHORT).show();
        //제목
        int title_id=res.getIdentifier(
                "title"+tag, "string", getPackageName());
        String title_str=res.getString(title_id);
        title.setText(title_str);

        //감독
        int director_id=res.getIdentifier(
                "director"+tag, "string", getPackageName());
        String director_str=res.getString(director_id);
        director.setText(director_str);


        //배우
        int actor_id=res.getIdentifier(
                "actor"+tag, "string", getPackageName());
        String actor_str=res.getString(actor_id);
        actor.setText(actor_str);


        //시놉시스
        int synopsys_id=res.getIdentifier(
                "synopsys"+tag, "string", getPackageName());
        String synopsys_str=res.getString(synopsys_id);
        synopsys.setText(synopsys_str);

        //포스터
        int poster_id=res.getIdentifier(
                "poster"+tag, "string",getPackageName());
        String poster_str=res.getString(poster_id);

        int poster_drawId=res.getIdentifier(
                poster_str,"drawable",getPackageName());
        Drawable draw=getDrawable(poster_drawId);
        poster.setBackground(draw);

        //티저 보러가기 버튼
        teaserShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent teaserIT= new Intent(ShowMovie.this,ShowVidio.class);
                teaserIT.putExtra("it_tag",tag);
                startActivity(teaserIT);
            }
        });




    }//onCreate
}//class ShowMovie