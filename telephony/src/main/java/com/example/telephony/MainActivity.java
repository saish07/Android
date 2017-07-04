package com.example.telephony;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TelephonyManager manager;
    public static final String Tag = MainActivity.class.getName();
    private SmsManager smsManager;
    private PendingIntent intentSent, intentDelivered;

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            if(intent.getAction().equals("com.example.sms.sent")){
                Toast.makeText(context,"msg sent",Toast.LENGTH_SHORT).show();
            }
            else if(intent.getAction().equals("com.example.sms.delivered")){
                Toast.makeText(context,"msg delivered",Toast.LENGTH_LONG).show();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
        smsManager = SmsManager.getDefault();
        Intent sent = new Intent("com.example.sms.sent");
        intentSent = PendingIntent.getBroadcast(this,1234,sent,PendingIntent.FLAG_UPDATE_CURRENT);
        Intent delivered = new Intent("com.example.sms.deliverd");
        intentDelivered = PendingIntent.getBroadcast(this,4567,delivered,PendingIntent.FLAG_UPDATE_CURRENT);
        IntentFilter filter = new IntentFilter();
        filter.addAction("com.example.sms.sent");
        filter.addAction("com.example.sms.delivered");
        registerReceiver(receiver, filter);

        info();
    }

    public void info(){

        int data =manager.getDataActivity();
        int callstate=manager.getCallState();
        String imei=manager.getDeviceId();
        Log.i(Tag,"Activitydata"+ " " +data);
        Log.i(Tag,"Callstate"+ " " +callstate);
        Log.i(Tag,"IMEI NO.-"+ " "+imei);
        String num=manager.getLine1Number();
        Log.i(Tag,"LineNumber"+ " " +num);
        String countryiso=manager.getSimCountryIso();
        Log.i(Tag,"countryISO" +" " +countryiso);
        String operator=manager.getSimOperatorName();
        Log.i(Tag,"SimcardOperater - "+" " +operator);
    }

    public void MsgSent(){
        smsManager.sendTextMessage("+918805325761", null, "Hi", intentSent, intentDelivered);
    }

}
