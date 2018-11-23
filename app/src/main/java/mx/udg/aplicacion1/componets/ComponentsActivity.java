package mx.udg.aplicacion1.componets;

import android.graphics.PorterDuff;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.CircularProgressDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import mx.udg.aplicacion1.componets.Util.Util;
import mx.udg.aplicacion1.R;

public class ComponentsActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = ComponentsActivity.class.getSimpleName();

    private LinearLayout mLinearLayout;

    private Button mBuTest;

    private ImageView imagen;

    private EditText editTextNombre;

    private CheckBox checkBoxTerminos;

    private RadioGroup radioGroupestatus;

    private Switch switch1;

    private ProgressBar progressBarCircular;

    private ProgressBar progressBarHorizontal;

    private ScrollView scroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_components);
        mLinearLayout = findViewById(R.id.linearLayout);
        mBuTest = findViewById(R.id.button2);
        mBuTest.setOnClickListener(this);
        mLinearLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Util.showLog(TAG,"Linear Layout");
            }
        });
        imagen = findViewById(R.id.imagen);
        editTextNombre = findViewById(R.id.editTextNombre);
        checkBoxTerminos = findViewById(R.id.checkBoxTerminos);
        radioGroupestatus = findViewById(R.id.radioGroupestatus);
        switch1 = findViewById(R.id.switch1);
        progressBarCircular = findViewById(R.id.progressBarCircular);
        progressBarHorizontal = findViewById(R.id.progressBarHorizontal);
        scroll = findViewById(R.id.scroll);
        setUpImageView();
        setUpCheckBox();
        setUpRadioGroup();
        setUpButtonOne();
        setUpSwitch();

    }

    public void clicked(View view){
        Util.showLog(TAG, "Click on the button");
    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.button2:
                Util.showLog(TAG,"Third button click");
                break;
        }
    }


    private void setUpImageView(){
        CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(this);
        circularProgressDrawable.setStrokeWidth(20f);
        circularProgressDrawable.setCenterRadius(60f);
        circularProgressDrawable.setColorFilter(ContextCompat.getColor(this,R.color.colorAccent), PorterDuff.Mode.SRC_ATOP);
        circularProgressDrawable.start();
        Glide.with( this)
                .load("http://k39.kn3.net/taringa/2/4/2/1/4/9/4/gingerlym/0CA.gif")
                .fitCenter()
                .crossFade(5000)
                .into(imagen);

    }

    public void setUpCheckBox(){
        checkBoxTerminos.setOnCheckedChangeListener(onCheckedChangeListener);
    }

    CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            //showSnackBar("Check the box" + isChecked);
            Util.showLog(TAG,"Checked");
            showSnackBar("Checked");
        }
    };

    private void showSnackBar(String message){
        Snackbar.make(scroll,message,Snackbar.LENGTH_LONG)
                .show();
    }

    private void showToast(String message){
        Toast.makeText(this, message,
                Toast.LENGTH_SHORT).show();
    }

    private void setUpRadioGroup(){
        radioGroupestatus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.chido:
                        showToast("chido");
                        break;
                    case R.id.muychido:
                        showToast("Muy chido");
                        break;
                }
            }
        });
    }

    private void setUpButtonOne(){
        mBuTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!editTextNombre.getText().toString().isEmpty()){
                    showSnackBar(editTextNombre.getText().toString());
                }
                showToast("Click in the button One ");
            }
        });
    }

    private void setUpSwitch(){
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    showToast("Switch has turn on");
                    progressBarCircular.setVisibility(View.VISIBLE);
                }else{
                    showToast("Switch has turn off");
                    progressBarCircular.setVisibility(View.GONE);
                }
            }
        });
    }


}
