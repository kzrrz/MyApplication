package com.example.lsc.perrerampal;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.IBinder;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class About extends AppCompatActivity {

    TextView tv1, tv2, tv3, tv4;
    String url = "https://github.com/kzrrz/PerreraUNLA";
    MediaPlayer player;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        tv1 = (TextView) findViewById(R.id.textViewabout1); tv2 = (TextView) findViewById(R.id.textViewabout2);
        tv3 = (TextView) findViewById(R.id.textViewabout3); tv4 = (TextView) findViewById(R.id.textViewLink);
        player = MediaPlayer.create(this, R.raw.yaheldnademo);
        //player.setLooping(true);
        player.start();
        //Ahora solo falta hacer que la música se detenga al salir del about.

    }

    public void onClick(View v){
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(this.isFinishing())
            player.stop();
    }

}
