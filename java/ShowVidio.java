package com.example.j14_moviekiosktaphostapp;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class ShowVidio extends AppCompatActivity {
    TextView title;
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showvidio);

        title = (TextView) findViewById(R.id.title);
        videoView = (VideoView) findViewById(R.id.teaser);

        Resources res = getResources();
        Intent it=getIntent();
        String tag=it.getStringExtra("it_tag");

        //제목
        int title_id=res.getIdentifier(
                "title"+tag, "string", getPackageName());
        String title_str=res.getString(title_id);
        title.setText(title_str);

        //비디오
        int id_video=res.getIdentifier(
                "teaser"+tag, "string",getPackageName());
        String str_video=res.getString(id_video);

        int id_raw = res.getIdentifier(str_video,"raw",getPackageName());

        Uri uri = Uri.parse("android.resource://com.example.j14_moviekiosktaphostapp/"+id_raw);
        videoView.setVideoURI(uri);
        videoView.setVisibility(View.VISIBLE);
        videoView.start();


    }//onCreate
}//class ShowMovie