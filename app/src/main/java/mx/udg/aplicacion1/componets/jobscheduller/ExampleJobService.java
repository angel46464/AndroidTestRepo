package mx.udg.aplicacion1.componets.jobscheduller;

import android.annotation.SuppressLint;
import android.app.job.JobParameters;
import android.app.job.JobService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import mx.udg.aplicacion1.componets.Util.Util;

@SuppressLint("NewApi")
public class ExampleJobService extends JobService {

    private static String TAG = ExampleJobService.class.getSimpleName();

    private boolean jobHasCancel = false;

    @Override
    public boolean onStartJob(JobParameters params) {
        Util.showLog(TAG,"Entra a un start job");
        backGroundWork(params);
        return true;
    }
    private void backGroundWork(JobParameters jobParameters){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i<15;i++){
                    DateFormat df = new SimpleDateFormat("HH:mm:ss");
                    String date = df.format(Calendar.getInstance().getTime());
                    Date currentTime = Calendar.getInstance().getTime();
                    Util.showLog(TAG,"Valor hell yeah "+ i +" Date "+ date + " currentTime "+ currentTime);
                    //oreoNotification("Hora "+ date + "numero " +i);
                    if(jobHasCancel){
                        return;
                    }
                    try{
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                Util.showLog(TAG,"Job Finished");
                jobFinished(jobParameters,false);
            }
        }).start();
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        Util.showLog(TAG,"On JOb cancelled");
        jobHasCancel=true;
        return false;
    }
}
