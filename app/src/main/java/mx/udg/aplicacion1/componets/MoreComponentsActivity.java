package mx.udg.aplicacion1.componets;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import mx.udg.aplicacion1.R;

public class MoreComponentsActivity extends AppCompatActivity {

    private Spinner spinner,spinner2;

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_components);
        spinner = findViewById(R.id.spinnerList);
        spinner2 = findViewById(R.id.spinnerCountry);
        button = findViewById(R.id.button3);
        addListenerOnSpinnerItemSelection();
        addItemOnSpinner2();
        addListenerOnButton();

    }

    private void addListenerOnButton() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createSimpleDialog(MoreComponentsActivity.this);
            }
        });
    }


    public void createSimpleDialog( Context context ){
        AlertDialog.Builder builder = new AlertDialog.Builder( context );
        builder.setTitle( "Seleccionaste" )
                .setMessage("\nSpinner Countries: "+String.valueOf(spinner.getSelectedItem())+
                        "\nSpinner List: "+String.valueOf(spinner2.getSelectedItem()))
                .setPositiveButton("Aceptar",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
        builder.show();
    }


    private void addItemOnSpinner2() {
        List<String> listNames = new ArrayList<>();
        listNames.add("Erick");
        listNames.add("Paulo");
        listNames.add("Diego");
        listNames.add("Moctezuma");
        listNames.add("Lewis");
        listNames.add("Mamaldo");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(MoreComponentsActivity.this,
                R.layout.spinner_item,listNames);
        dataAdapter.setDropDownViewResource(R.layout.spinner_item);
        spinner2.setAdapter(dataAdapter);
    }

    private void addListenerOnSpinnerItemSelection() {
        spinner2.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }
    
    

}
