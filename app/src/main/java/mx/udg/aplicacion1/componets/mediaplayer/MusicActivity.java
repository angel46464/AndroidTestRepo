package mx.udg.aplicacion1.componets.mediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mx.udg.aplicacion1.R;

public class MusicActivity extends AppCompatActivity {

    private MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.play) public void play(View view){
        if(player == null){
            player = MediaPlayer.create(this,R.raw.song);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            });
        }
        player.start();
    }

    @OnClick(R.id.pause) public void pause(View view){
        if(player != null){
            player.pause();
        }
    }

    @OnClick(R.id.stop) public void stop(){
        stopPlayer();
    }

    private void stopPlayer(){
        if(player!=null){
            player.release();
            player = null;
            Toast.makeText(this,"MediaPlayerRelease",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStop(){
        super.onStop();
        stopPlayer();
    }

}
