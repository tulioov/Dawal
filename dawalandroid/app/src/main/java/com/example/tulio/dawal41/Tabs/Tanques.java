package com.example.tulio.dawal41.Tabs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tulio.dawal41.Ultil.Dados;
import com.example.tulio.dawal41.Ultil.DawalBluetoothObserver;
import com.example.tulio.dawal41.R;
import com.github.anastr.speedviewlib.AwesomeSpeedometer;

import java.util.Map;

/**
 * Created by Tulio on 06/12/2016.
 */

public class Tanques extends AbaPai implements DawalBluetoothObserver {

    AwesomeSpeedometer SpeedometerIOBB;
    AwesomeSpeedometer SpeedometerIOBE;
    TextView tvinBB;
    TextView tvoutBB;
    TextView tvinBE;
    TextView tvoutBE;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.tanques, container, false);
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
        /**/
        SpeedometerIOBB = getView().findViewById(R.id.SpeedometerIOBB);
        SpeedometerIOBE = getView().findViewById(R.id.SpeedometerIOBE);
        tvinBB = getView().findViewById(R.id.tvinBB);
        tvoutBB = getView().findViewById(R.id.tvoutBB);
        tvinBE = getView().findViewById(R.id.tvinBE);
        tvoutBE = getView().findViewById(R.id.tvoutBE);


        try {

            //Consumo motor BB
            Log.e("tvoutBB",Dados.getDados().getFluxoOutBB().toString());
            Log.e("tvinBB",Dados.getDados().getFluxoInBB().toString());

            tvoutBB.setText(Dados.getDados().getFluxoOutBB().toString() + Dados.getDados().getSunitLporH());
            tvinBB.setText(Dados.getDados().getFluxoInBB().toString() + Dados.getDados().getSunitLporH());
            SpeedometerIOBB.speedTo(Math.round(Dados.getDados().getFluxoInBB() - Dados.getDados().getFluxoOutBB()));
            SpeedometerIOBB.setUnit(Dados.getDados().getSunitLporH());

            //Consumo motor BE
            Log.e("tvoutBE",Dados.getDados().getFluxoOutBE().toString());
            Log.e("tvinBE",Dados.getDados().getFluxoInBE().toString());

            tvoutBE.setText(Dados.getDados().getFluxoOutBE().toString() + Dados.getDados().getSunitLporH());
            tvinBE.setText(Dados.getDados().getFluxoInBE().toString() + Dados.getDados().getSunitLporH());
            SpeedometerIOBE.speedTo(Math.round(Dados.getDados().getFluxoInBE() - Dados.getDados().getFluxoOutBE()));
            SpeedometerIOBE.setUnit(Dados.getDados().getSunitLporH());

        } catch (NullPointerException e) {
            Log.e("Tanque: ", "Erro: "+e);

        }
    }
}
