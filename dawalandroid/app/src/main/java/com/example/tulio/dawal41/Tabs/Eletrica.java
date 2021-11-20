package com.example.tulio.dawal41.Tabs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ToggleButton;

import com.example.tulio.dawal41.Ultil.DawalBluetoothObserver;
import com.example.tulio.dawal41.R;

import java.util.Map;

/**
 * Created by Tulio on 06/12/2016.
 */

public class Eletrica extends AbaPai implements DawalBluetoothObserver {

    ToggleButton btnluztopo;
    ToggleButton btnluzdenavegacao;
    ToggleButton btnluzpainel;
    ToggleButton btnbussola;
    ToggleButton btnbuzina;
    ToggleButton btnlimpador;
    ToggleButton btnstrobo;
    ToggleButton btnfarolpopa;
    ToggleButton btnluzmotor;
    ToggleButton btncortesia;
    ToggleButton btnbombaproa1;
    ToggleButton btnbombaproa2;
    ToggleButton btnbombapopa;
    ToggleButton btnaguadoce;
    ImageView luzboreste;
    ImageView luztopo;
    ImageView strobo1;
    ImageView strobo2;
    ImageView luzbombordo;
    ImageView luzalcado;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.eletrica, container, false);


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        btnluztopo = (ToggleButton) getView().findViewById(R.id.btnluzdetopo);
        btnluzdenavegacao = (ToggleButton) getView().findViewById(R.id.btnluzdenavegacao);
        btnluzpainel = (ToggleButton) getView().findViewById(R.id.btnluzpainel);
        btnbussola = (ToggleButton) getView().findViewById(R.id.btnbussola);
        btnbuzina = (ToggleButton) getView().findViewById(R.id.btnbuzina);
        btnlimpador = (ToggleButton) getView().findViewById(R.id.btnlimpador);
        btnstrobo = (ToggleButton) getView().findViewById(R.id.btnstrobo);
        btnfarolpopa = (ToggleButton) getView().findViewById(R.id.btnfarolpopa);
        btnluzmotor = (ToggleButton) getView().findViewById(R.id.btnluzmotor);
        btnbombaproa1 = (ToggleButton) getView().findViewById(R.id.btnbombaproa1);
        btnbombaproa2 = (ToggleButton) getView().findViewById(R.id.btnbombaproa2);
        btnbombapopa = (ToggleButton) getView().findViewById(R.id.btnbombapopa);
        btnaguadoce = (ToggleButton) getView().findViewById(R.id.btnaguadoce);
        luzboreste = (ImageView) getView().findViewById(R.id.luzboreste);
        luztopo = (ImageView) getView().findViewById(R.id.luztopo);
        strobo1 = (ImageView) getView().findViewById(R.id.strobo1);
        strobo2 = (ImageView) getView().findViewById(R.id.strobo2);
        luzbombordo = (ImageView) getView().findViewById(R.id.luzbombordo);
        luzalcado = (ImageView) getView().findViewById(R.id.luzalcado);

        btnluztopo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    luztopo.setVisibility(View.VISIBLE);
                } else {
                    // The toggle is disabled
                    luztopo.setVisibility(View.INVISIBLE);
                }
            }
        });
        btnluzdenavegacao.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    luzalcado.setVisibility(View.VISIBLE);
                    luzboreste.setVisibility(View.VISIBLE);
                    luzbombordo.setVisibility(View.VISIBLE);
                } else {
                    // The toggle is disabled
                    luzalcado.setVisibility(View.INVISIBLE);
                    luzboreste.setVisibility(View.INVISIBLE);
                    luzbombordo.setVisibility(View.INVISIBLE);
                }
            }
        });
        btnstrobo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    strobo1.setVisibility(View.VISIBLE);
                    strobo2.setVisibility(View.VISIBLE);
                } else {
                    // The toggle is disabled
                    strobo1.setVisibility(View.INVISIBLE);
                    strobo2.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    public Fragment getFragment() {
        return this;
    }


    @Override
    public void notifyUpdate(Map<Integer, Float> pinosValores) {

        try {

        } catch (NullPointerException e) {
            Log.e("ERRO","Erro na tela Eletrica: "+e);
        }

    }
}
