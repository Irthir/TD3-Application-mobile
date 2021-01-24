package com.example.listepersonnalisedesplantes;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Planete> listePlanete = new ArrayList<Planete>();

        initListe(listePlanete);

        AdapterPlanet adapter = new AdapterPlanet(this, R.layout.planete,listePlanete);
        final ListView liste = (ListView) findViewById(R.id.listview);
        liste.setAdapter(adapter);

        liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Planete optionChoisie = (Planete) parent.getItemAtPosition(position);
                Log.v("Planete",optionChoisie.getNomPlanete());
                Log.v("Distance avec la terre ",optionChoisie.getDistancePlanete()+" millions de kms.");

                Toast.makeText(MainActivity.this,"Planete : "+optionChoisie.getNomPlanete()+".\n"+"Distance avec la terre : "+optionChoisie.getDistancePlanete()+" millions de kms.",Toast.LENGTH_SHORT).show();
            }
        });

        String videoPath = "android.resource://"+getPackageName() + "/"+R.raw.systeme_solaire;
        VideoView video = (VideoView)findViewById(R.id.videoView);
        Uri uri = Uri.parse(videoPath);
        video.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        video.setMediaController(mediaController);
        mediaController.setAnchorView(video);
    }

    private void initListe(ArrayList<Planete> listePlanete)
    {
        Planete planete = new Planete();
        planete.setNomPlanete("Mercure");
        planete.setDistancePlanete("92");
        planete.setImagePlanete(R.drawable.mercury);
        listePlanete.add(planete);

        planete = new Planete();
        planete.setNomPlanete("Vénus");
        planete.setDistancePlanete("42");
        planete.setImagePlanete(R.drawable.venus);
        listePlanete.add(planete);

        planete = new Planete();
        planete.setNomPlanete("Terre");
        planete.setDistancePlanete("0");
        planete.setImagePlanete(R.drawable.terre);
        listePlanete.add(planete);

        planete = new Planete();
        planete.setNomPlanete("Mars");
        planete.setDistancePlanete("78");
        planete.setImagePlanete(R.drawable.mars);
        listePlanete.add(planete);

        planete = new Planete();
        planete.setNomPlanete("Jupiter");
        planete.setDistancePlanete("628");
        planete.setImagePlanete(R.drawable.jupiter);
        listePlanete.add(planete);

        planete = new Planete();
        planete.setNomPlanete("Saturne");
        planete.setDistancePlanete("1 199");
        planete.setImagePlanete(R.drawable.saturn);
        listePlanete.add(planete);

        planete = new Planete();
        planete.setNomPlanete("Uranus");
        planete.setDistancePlanete("2 719");
        planete.setImagePlanete(R.drawable.uranus);
        listePlanete.add(planete);

        planete = new Planete();
        planete.setNomPlanete("Neptune");
        planete.setDistancePlanete("4 347");
        planete.setImagePlanete(R.drawable.neptune);
        listePlanete.add(planete);
    }
}