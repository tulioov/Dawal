package com.example.tulio.dawal41.Ultil;

import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.util.Map;

import app.akexorcist.bluetotohspp.library.BluetoothSPP;


public class DawalBluetoothConect implements DawalBluetoothObserver,BluetoothSPP.BluetoothConnectionListener, BluetoothSPP.OnDataReceivedListener {

    private BluetoothSPP spp;
    private TextView textView_status;
    Button btnconnect;

    public DawalBluetoothConect(BluetoothSPP spp, TextView textView_status, Button btnconnect) {
        this.textView_status = textView_status;
        this.spp = spp;
        this.btnconnect = btnconnect;
        spp.setBluetoothConnectionListener(this);
        if (spp.isBluetoothAvailable()) {
            if (spp.isBluetoothEnabled()) {
                spp.setupService();
                spp.startService(false);
            }

        }
    }


    @Override
    public void onDeviceConnected(String name, String address) {
        Log.e("spp", "conectou");
        textView_status.setText("Conectado");
        //Toast.makeText(getActivity().getApplicationContext(), "Conectou!", Toast.LENGTH_SHORT).show();
        btnconnect.setEnabled(false);
        spp.setOnDataReceivedListener(this);


    }

    @Override
    public void onDeviceDisconnected() {
        btnconnect.setEnabled(true);
    }

    @Override
    public void onDeviceConnectionFailed() {

    }

    @Override
    public void onDataReceived(byte[] data, String message) {
        try{
            Log.e("Recebendo msg", message);
            DawalBluetoothObservable.newData(message);
            mudarMensagem(message);
        }catch (Exception e){
            Log.e("onDataReceived", "Aba");
        }

    }

    public void mudarMensagem(String mensagem) {
        //textView_status.setText(mensagem);
        //textView_status.scrollTo(0, Integer.MAX_VALUE);

    }

    @Override
    public void notifyUpdate(Map<Integer, Float> pinosValores) {

    }
}
