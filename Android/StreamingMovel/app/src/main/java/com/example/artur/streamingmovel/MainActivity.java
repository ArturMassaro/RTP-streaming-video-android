package com.example.artur.streamingmovel;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btstreaming;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Streaming de Video");

        btstreaming = (Button) findViewById(R.id.btstreaming);


        btstreaming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //192.168.100.17
                String movieurl = "rtsp://192.168.43.237:1935/vod/video.mp4";

                if (movieurl.startsWith("rtsp://")) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(movieurl));
                    startActivity(intent);

                }
            }
        });
    }
}
