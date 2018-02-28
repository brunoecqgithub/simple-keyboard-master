package rkr.simplekeyboard.inputmethod.latin;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;

public class InitService extends Service {
    private static Context contextOfApplication;

    public InitService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        //throw new UnsupportedOperationException("Not yet implemented");
        return null;
    }


    @Override
    public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
    {

        //startService(new Intent(this, InitService.class));

        Intent myIntent = new Intent(this, MainService.class);
        PendingIntent pendingIntent = PendingIntent.getService(this,0,myIntent,0);
        AlarmManager manager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);

        manager.setInexactRepeating
                (
                        AlarmManager.ELAPSED_REALTIME_WAKEUP,
                        SystemClock.elapsedRealtime(),
                        2*60*1000,
                        pendingIntent
                );

        return START_STICKY;
    }


    public static Context getContextOfApplication()
    {
        return contextOfApplication;
    }


}
