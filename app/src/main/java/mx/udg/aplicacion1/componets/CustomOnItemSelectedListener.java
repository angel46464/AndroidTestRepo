package mx.udg.aplicacion1.componets;

import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;

public class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Log.e("Select" , "Select" + parent.getItemAtPosition(position).toString( ) );
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
