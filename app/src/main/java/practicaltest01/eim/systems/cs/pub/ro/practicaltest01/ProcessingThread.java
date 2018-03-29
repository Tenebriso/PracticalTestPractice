package practicaltest01.eim.systems.cs.pub.ro.practicaltest01;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.lang.Thread;
import java.util.Random;

public class ProcessingThread extends Thread {
    private Context context = null;
    private boolean isRunning = true;

    private Random random = new Random();

    private double suma;
    private double diferenta;

    public ProcessingThread(Context context, int firstNumber, int secondNumber) {
        this.context = context;

        suma = firstNumber + secondNumber;
        diferenta = firstNumber - secondNumber;
    }

    @Override
    public void run() {
        Log.d("[ProcessingThread]", "Thread has started!");
        while (isRunning) {
            sendMessage();
            sleep();
        }
        Log.d("[ProcessingThread]", "Thread has stopped!");
    }

    private void sendMessage() {
        Intent intent = new Intent();
       // intent.setAction(SyncStateContract.Constants.actionTypes[random.nextInt(SyncStateContract.Constants.actionTypes.length)]);
        intent.putExtra("message",   suma + " " + diferenta);
        context.sendBroadcast(intent);
    }

    private void sleep() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    public void stopThread() {
        isRunning = false;
    }
}

}
