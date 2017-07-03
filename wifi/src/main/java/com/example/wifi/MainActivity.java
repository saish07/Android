package com.example.wifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private WifiManager manager;
    private IntentFilter filter;

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            List<ScanResult> scanResults = manager.getScanResults();
            for (ScanResult sc : scanResults) {
                Log.i("@codekul", "SSID - " + sc.SSID + " BSSID - " + sc.BSSID);
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = (WifiManager) getApplicationContext()
                .getSystemService(WIFI_SERVICE);

        filter = new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION);
    }

    @Override
    protected void onStart() {
        super.onStart();
        registerReceiver(receiver, filter);
    }

    @Override
    protected void onStop() {
        unregisterReceiver(receiver);
        super.onStop();
    }

    public void onConnect(View view) {
        WifiConfiguration wifiConfig = new WifiConfiguration();
        wifiConfig.SSID = String.format("\"%s\"", "SonyExperia");
        wifiConfig.preSharedKey = String.format("\"%s\"", "1234");

        int netId = manager.addNetwork(wifiConfig);
        manager.disconnect();
        manager.enableNetwork(netId, true);
        manager.reconnect();
    }

    public void onConnected(View view) {
        List<WifiConfiguration> nws = manager.getConfiguredNetworks();
        for (WifiConfiguration nw : nws) {
            Log.i("@codekul", "SSID - " + nw.SSID + " BSSID - " + nw.BSSID);
        }
    }

    public void onScan(View view) {
        manager.startScan();
    }
}