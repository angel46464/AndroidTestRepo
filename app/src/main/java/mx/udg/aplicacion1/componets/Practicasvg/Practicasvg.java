package mx.udg.aplicacion1.componets.Practicasvg;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mx.udg.aplicacion1.R;
import mx.udg.aplicacion1.componets.Util.KeysConstants;

public class Practicasvg extends AppCompatActivity {

    @BindView(R.id.textInputLayoutemail)
    TextInputLayout mtextInputLayoutemail;

    @BindView(R.id.textInputLayoutpassemail)
    TextInputLayout mtextInputLayoutpassemail;

    @BindView(R.id.email)
    EditText memail;

    @BindView(R.id.passwordemail)
    EditText mpasswordemail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practicasvg);
        ButterKnife.bind(this);
    }
    private void showToast(String message){
        Toast.makeText(this, message,
                Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.buttonLogin) public void logIn(View view){
        String emailPattern = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$";
        Boolean success = true;

        if(memail.getText().toString().length()==0 && mpasswordemail.getText().toString().length()==0){
            showToast("No ingresaste correo ni password");
            success=false;
        }
        else{
            if(memail.getText().toString().length()==0){
                memail.setError("No ingresaste correo");
                success=false;
            }else{
                Pattern pattern = Pattern.compile(emailPattern);
                Matcher matcher = pattern.matcher(memail.getText().toString());
                if(!matcher.matches()){
                    mtextInputLayoutemail.setError("Correo en formato incorrecto");
                    success=false;
                }

            }

            if(mpasswordemail.getText().toString().length()==0){
                mpasswordemail.setError("No ingresaste password");
                success=false;
            }else{
                if(mpasswordemail.getText().toString().length()<8){
                    mtextInputLayoutpassemail.setError("Error la longitud del password tiene que ser minimo 8 caracteres");
                    success=false;
                }
            }

        }
        success=true;
        if(success){
            mpasswordemail.setError(null);
            mtextInputLayoutpassemail.setError(null);
            showToast("SUCCESS LOGIN");
            Intent intent = new Intent(Practicasvg.this,Profile.class);
            intent.putExtra(KeysConstants.PROFILE,memail.getText().toString());
            startActivity(intent);

        }


    }
}
