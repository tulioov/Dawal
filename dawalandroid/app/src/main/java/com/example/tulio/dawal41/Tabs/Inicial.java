package com.example.tulio.dawal41.Tabs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.tulio.dawal41.Ultil.Dados;
import com.example.tulio.dawal41.Ultil.DawalBluetoothConect;
import com.example.tulio.dawal41.R;
import com.example.tulio.dawal41.Ultil.DawalBluetoothObserver;

import java.util.Map;

import app.akexorcist.bluetotohspp.library.BluetoothSPP;
import app.akexorcist.bluetotohspp.library.BluetoothState;
import app.akexorcist.bluetotohspp.library.DeviceList;

/**
 * Created by Tulio on 06/12/2016.
 */


public class Inicial extends AbaPai implements DawalBluetoothObserver {

    TextView textView_status;
    TextView consumoTotalBB;
    TextView consumoTotalBE;
    TextView tempoFuncionamentoBB;
    TextView tempoFuncionamentoBE;
    TextView velocMedia;
    TextView velocMax;
    TextView distPercorrida;
    TextView tempo;

    ToggleButton btnUnitVolumePorTempo;
    ToggleButton btnUnitVolume;
    ToggleButton btnUnitDistancia;
    ToggleButton btnUnitTempo;
    ToggleButton btnUnitVelocidade;

    Button btnconnect;
    Button btnReset;

    private BluetoothSPP spp;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.inicial, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        textView_status = getView().findViewById(R.id.textView_Status);

        btnUnitVolumePorTempo = getView().findViewById(R.id.btnUnitVolumePorTempo);
        btnUnitVolume = getView().findViewById(R.id.btnUnitVolume);
        btnUnitDistancia  = getView().findViewById(R.id.btnUnitDistancia);
        btnUnitTempo  = getView().findViewById(R.id.btnUnitTempo);
        btnUnitVelocidade = getView().findViewById(R.id.btnUnitVelocidade);


        consumoTotalBB = getView().findViewById(R.id.consumoTotalBB);
        consumoTotalBE = getView().findViewById(R.id.consumoTotalBE);
        tempoFuncionamentoBB = getView().findViewById(R.id.tempoFuncionamentoBB);
        tempoFuncionamentoBE = getView().findViewById(R.id.tempoFuncionamentoBE);
        velocMedia = getView().findViewById(R.id.velocMedia);
        velocMax = getView().findViewById(R.id.velocMax);
        distPercorrida = getView().findViewById(R.id.distPercorrida);
        tempo = getView().findViewById(R.id.tempo);
        btnconnect = getView().findViewById(R.id.btnconnect);
        btnReset = getView().findViewById(R.id.btnReset);
        spp = new BluetoothSPP(getActivity().getApplicationContext());

        DawalBluetoothConect dbc = new DawalBluetoothConect(spp, textView_status, btnconnect);


        btnconnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listarDispositivos();
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            try {
                consumoTotalBB.setText("");
                Dados.getDados().setConsumoTotalBB(0.0f);
                consumoTotalBE.setText("");
                Dados.getDados().setConsumoTotalBE(0.0f);
                tempoFuncionamentoBB.setText("");
                tempoFuncionamentoBE.setText("");
                velocMedia.setText("");
                Dados.getDados().setVelocMedia(0.0f);
                velocMax.setText("");
                Dados.getDados().setVelocMax(0.0f);
                distPercorrida.setText("");
                Dados.getDados().setDistPercorrida(0.0f);
                tempo.setText("");
            }catch (Exception e){
                Log.e("ERRO","Erro na tela Inicial reset: "+e);
            }

            }
        });


        btnUnitVolumePorTempo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(btnUnitVolumePorTempo.isChecked()){
                    Dados.getDados().setUnitLporH(false);
                }
                else {
                    Dados.getDados().setUnitLporH(true);
                }

            }
        });
        btnUnitVolume.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(btnUnitVolume.isChecked()){
                    Dados.getDados().setUnitLitro(false);
                }
                else {
                    Dados.getDados().setUnitLitro(true);
                }

            }
        });
        btnUnitDistancia.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(btnUnitDistancia.isChecked()){
                    Dados.getDados().setUnitMetros(true);
                }
                else {
                    Dados.getDados().setUnitMetros(false);
                }

            }
        });
        btnUnitTempo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(btnUnitTempo.isChecked()){
                    Dados.getDados().setUnitHora(false);
                }
                else {
                    Dados.getDados().setUnitHora(true);
                }

            }
        });
        btnUnitVelocidade.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(btnUnitVelocidade.isChecked()){
                    Dados.getDados().setUnitMporS(false);
                }
                else {
                    Dados.getDados().setUnitMporS(true);
                }

            }
        });

    }

    @Override
    public void notifyUpdate(Map<Integer, Float> pinosValores) {

        try {
            Log.e("Tela Inicial: ", "Dado: " +Dados.getDados().getConsumoTotalBB() + Dados.getDados().getSunitLitro());
            consumoTotalBB.setText(Dados.getDados().getConsumoTotalBB() + Dados.getDados().getSunitLitro());
            consumoTotalBE.setText(Dados.getDados().getConsumoTotalBE() + Dados.getDados().getSunitLitro());
            tempoFuncionamentoBB.setText(Dados.getDados().getTempoFuncionamentoBB() + Dados.getDados().getSunitHora());
            tempoFuncionamentoBE.setText(Dados.getDados().getTempoFuncionamentoBE() + Dados.getDados().getSunitHora());
            velocMedia.setText(Dados.getDados().getVelocMedia() + Dados.getDados().getSunitMetros());
            velocMax.setText(Dados.getDados().getVelocMax() + Dados.getDados().getSunitMetros());
            distPercorrida.setText(Dados.getDados().getDistPercorrida() + Dados.getDados().getSunitMetros());
            tempo.setText(Dados.getDados().getTempo() + Dados.getDados().getSunitHora());


        }catch (Exception e){
            Log.e("ERRO","Erro na tela Inicial: "+ e);
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    public void listarDispositivos() {
        Intent lista_dispositivos = new Intent(getActivity().getApplicationContext(), DeviceList.class);
        startActivityForResult(lista_dispositivos, BluetoothState.REQUEST_CONNECT_DEVICE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == BluetoothState.REQUEST_CONNECT_DEVICE) {
            if (resultCode == Activity.RESULT_OK) {
                String address = data.getStringExtra(BluetoothState.EXTRA_DEVICE_ADDRESS);
                spp.connect(address);
            }
        }
    }


    @Override
    public Fragment getFragment() {
        return this;
    }


}
