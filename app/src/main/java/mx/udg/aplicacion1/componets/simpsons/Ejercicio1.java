package mx.udg.aplicacion1.componets.simpsons;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import mx.udg.aplicacion1.componets.Util.Util;
import mx.udg.aplicacion1.R;

public class Ejercicio1 extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = Ejercicio1.class.getSimpleName();

    private TextView texto;
    private LinearLayout lisa;
    private LinearLayout moe;
    private Button homero;
    private Button bart;
    private ImageView imagenPrincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1);
        texto = findViewById(R.id.texto);
        lisa = findViewById(R.id.lisa);
        lisa.setOnClickListener(this);
        homero = findViewById(R.id.homero);
        homero.setOnClickListener(this);
        moe = findViewById(R.id.moe);
        moe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Util.showLog(TAG,"Has elegido a Moe");
                texto.setText(getString(R.string.moe));
            }
        });

    }

    public void clicked(View view){
        Util.showLog(TAG,"Has elegido a Bart");
        texto.setText(getString(R.string.bart));
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.lisa:
                Util.showLog(TAG,"Has elegido a lisa");
                texto.setText(getString(R.string.lisa));
                break;
            case R.id.homero:
                Util.showLog(TAG,"Has elegido a Homero");
                texto.setText(getString(R.string.homero));
                break;
        }
    }
}
