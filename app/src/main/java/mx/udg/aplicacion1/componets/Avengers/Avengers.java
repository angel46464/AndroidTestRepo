package mx.udg.aplicacion1.componets.Avengers;

import android.graphics.PorterDuff;
import android.support.design.widget.TextInputEditText;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.CircularProgressDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;

import com.bumptech.glide.Glide;

import mx.udg.aplicacion1.R;
import mx.udg.aplicacion1.componets.Util.Util;


public class Avengers extends AppCompatActivity implements View.OnClickListener {

    private String TAG = Avengers.class.getSimpleName();
    private Spinner spinnerNombreAvenger;
    private TextInputEditText textInputLayoutAvenger;
    private Switch vivo;
    private RadioGroup radioGroupSiNo;
    private Button mostrar;
    private ImageView imagenPrincipalAvengers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avengers);
        spinnerNombreAvenger = findViewById(R.id.spinnerNombreAvenger);
        textInputLayoutAvenger = findViewById(R.id.textInputLayoutAvenger);
        vivo = findViewById(R.id.vivo);
        radioGroupSiNo = findViewById(R.id.radioGroupSiNo);
        imagenPrincipalAvengers = findViewById(R.id.imagenPrincipalAvengers);
        mostrar = findViewById(R.id.mostar);
        mostrar.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        switch (String.valueOf(spinnerNombreAvenger.getSelectedItem())){
            case "SpinnerSpiderman":
                CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(this);
                circularProgressDrawable.setStrokeWidth(20f);
                circularProgressDrawable.setCenterRadius(60f);
                circularProgressDrawable.setColorFilter(ContextCompat.getColor(this,R.color.colorAccent), PorterDuff.Mode.SRC_ATOP);
                circularProgressDrawable.start();
                Glide.with( this)
                        .load("https://emptylighthouse-production.s3-us-west-2.amazonaws.com/s3fs-public/styles/728x_hero/public/field/image/30740878_10155432528682344_9083589659031764992_n.jpg?itok=-Jn0xdbw")
                        .fitCenter()
                        .crossFade(5000)
                        .into(imagenPrincipalAvengers);
                break;
            case "SpinnerIron Man":
                break;
            case "SpinnerThor":
                break;
            case "SpinnerCapitan America":
                break;
        }
        Util.showLog(TAG,"Spinner"+String.valueOf(spinnerNombreAvenger.getSelectedItem()));
    }
}
