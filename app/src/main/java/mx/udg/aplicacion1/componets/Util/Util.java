package mx.udg.aplicacion1.componets.Util;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

public class Util {

    public static void showLog( String TAG, String message ){
        Log.e(TAG,":::.."+message+"..::");
    }

    public static void changeActivityAndFinish(Activity activity,Class aClass){
        Intent intent = new Intent(activity,aClass);
        activity.startActivity(intent);
        activity.finish();
    }
}
