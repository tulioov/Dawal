package com.example.tulio.dawal41.Tabs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tulio.dawal41.Ultil.DawalBluetoothObserver;
import com.example.tulio.dawal41.R;

import java.util.Map;

/**
 * Created by Tulio on 06/12/2016.
 */

public class Proa extends AbaPai implements DawalBluetoothObserver {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.proa, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    public Fragment getFragment() {
        return this;
    }


    @Override
    public void notifyUpdate(Map<Integer, Float> pinosValores) {
        try {

        } catch (NullPointerException e) {
            Log.e("ERRO","Erro na tela Proa: "+e);
        }
    }
}
