package practicaltest01.eim.systems.cs.pub.ro.practicaltest01;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class PracticalTestVar02Service extends Service {
    private ProcessingThread processingThread = null;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int firstNumber = intent.getIntExtra("firstNumber", -1);
        int secondNumber = intent.getIntExtra("secondNumber", -1);
        processingThread = new ProcessingThread(this, firstNumber, secondNumber);
        processingThread.start();
        return Service.START_REDELIVER_INTENT;
    }
}
