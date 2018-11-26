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


    public static int getRandomNumber(){

        return  (int)(Math.random()*((3-1)+1))+1;

    }


    public static String setRandomImage(){
        switch (Util.getRandomNumber()){
            case 1:
                return "http://weddingwoof.com/wp-content/uploads/2012/06/dogstore-1.jpg";
            case 2:
                return "https://barkpost.com/wp-content/uploads/2014/11/lavadogshawaii.jpg";
            case 3:
                return "https://barkpost.com/wp-content/uploads/2014/11/lavadogshawaii.jpg";
        }
        return "";
    }
}
