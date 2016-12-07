package com.example.joovinaud.projmobile;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import dataprovider.ExercicioDAOMock;
import dataprovider.IExercicioDAO;
import domain.Exercicio;

public class AtividadeActivity extends AppCompatActivity {

    private IExercicioDAO dao;
    private TextView titulo;
    private TextView desc;
    private Exercicio exer;

    private VideoView video;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atividade);

        video = (VideoView) findViewById(R.id.videoView);


        MediaController mc = new MediaController(this);
        mc.setAnchorView(video);
        mc.setMediaPlayer(video);
        video.setMediaController(mc);
        String uriPath = "android.resource://com.example.joovinaud.projmobile/"+R.raw.videoplayback;
        Uri uri = Uri.parse(uriPath);
        video.setVideoURI(uri);
        video.requestFocus();
       // video.start();

        titulo = (TextView) findViewById(R.id.apTitle);
        desc = (TextView) findViewById(R.id.apDesc);

        Intent intent = getIntent();
        dao = new ExercicioDAOMock();

        String param = intent.getStringExtra("id");

         exer = dao.getExercicio(param);
       // Toast.makeText(this, exer.getId(), Toast.LENGTH_LONG).show();

        titulo.setText(exer.getName());
        desc.setText(exer.getDesc());


    }
}
