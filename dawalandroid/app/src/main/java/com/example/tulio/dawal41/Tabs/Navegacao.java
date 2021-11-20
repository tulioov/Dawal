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

public class Navegacao extends AbaPai implements DawalBluetoothObserver {

    AwesomeSpeedometer speedometerPressD;
    AwesomeSpeedometer speedometerPressA;
    AwesomeSpeedometer speedometerPressMBB;
    AwesomeSpeedometer speedometerPressMBE;
    AwesomeSpeedometer speedometerPressCxBB;
    AwesomeSpeedometer speedometerPressCxBE;
    AwesomeSpeedometer speedometerVoltBB;
    AwesomeSpeedometer speedometerVoltBE;
    AwesomeSpeedometer speedometerTempBB;
    AwesomeSpeedometer speedometerTempBE;
    AwesomeSpeedometer speedometerConsmBB;
    AwesomeSpeedometer speedometerConsmBE;
    AwesomeSpeedometer speedometerRPMBB;
    AwesomeSpeedometer speedometerRPMBE;

    TextView vento;
    TextView unitVento;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.navegacao, container, false);
    }

    public Fragment getFragment() {
        return this;
    }

    @Override
    public void notifyUpdate(Map<Integer, Float> pinosValores) {

        speedometerPressD = getView().findViewById(R.id.SpeedometerPressD);
        speedometerPressA = getView().findViewById(R.id.SpeedometerPressA);
        speedometerPressMBB = getView().findViewById(R.id.SpeedometerPressMBB);
        speedometerPressMBE = getView().findViewById(R.id.SpeedometerPressMBE);
        speedometerPressCxBB = getView().findViewById(R.id.SpeedometerPressCxBB);
        speedometerPressCxBE = getView().findViewById(R.id.SpeedometerPressCxBE);
        speedometerVoltBB = getView().findViewById(R.id.SpeedometerVoltBB);
        speedometerVoltBE = getView().findViewById(R.id.SpeedometerVoltBE);
        speedometerTempBB = getView().findViewById(R.id.SpeedometerTempBB);
        speedometerTempBE = getView().findViewById(R.id.SpeedometerTempBE);
        speedometerConsmBB = getView().findViewById(R.id.SpeedometerConsmBB);
        speedometerConsmBE = getView().findViewById(R.id.SpeedometerConsmBE);
        speedometerRPMBB = getView().findViewById(R.id.SpeedometerRPMBB);
        speedometerRPMBE = getView().findViewById(R.id.SpeedometerRPMBE);

        vento = getView().findViewById(R.id.vento);
        unitVento = getView().findViewById(R.id.unitVento);


        try {
            //Consumo motor BB -------------------------------------------------------------

            Log.e("ConsmBB",Dados.getDados().getConsmBB().toString());
            speedometerConsmBB.speedTo(Math.round(Dados.getDados().getConsmBB()));
            speedometerConsmBB.setUnit(Dados.getDados().getSunitLporH());

            //Consumo motor BE -------------------------------------------------------------

            Log.e("ConsmBE",Dados.getDados().getConsmBE().toString());
            speedometerConsmBE.speedTo(Math.round(Dados.getDados().getConsmBE()));
            speedometerConsmBE.setUnit(Dados.getDados().getSunitLporH());

            //PressD -------------------------------------------------------------

            Log.e("pressD",Dados.getDados().getPressD().toString());
            int pressD = Math.round(Dados.getDados().getPressD());
            speedometerPressD.speedTo(pressD);


            if(pressD > 0 && pressD < 80){
                //vermelho
                speedometerPressD.setTrianglesColor(0xffff0000);
                speedometerPressD.setBackgroundCircleColor(0xffff0000);
            }else if (pressD >= 80 && pressD < 150){
                //amarelo
                speedometerPressD.setTrianglesColor(0xfff7ff00);
                speedometerPressD.setBackgroundCircleColor(0xfff7ff00);
            }else{
                //preto
                speedometerPressD.setTrianglesColor(0xff111111);
                speedometerPressD.setBackgroundCircleColor(0xff111111);
            }

            //PressA -------------------------------------------------------------

            Log.e("pressA",Dados.getDados().getPressA().toString());
            int pressA = Math.round(Dados.getDados().getPressA());
            speedometerPressA.speedTo(pressA);

            if(pressA > 0 && pressA < 80){
                //vermelho
                speedometerPressA.setTrianglesColor(0xffff0000);
                speedometerPressA.setBackgroundCircleColor(0xffff0000);
            }else if (pressA >= 80 && pressA < 150){
                //amarelo
                speedometerPressA.setTrianglesColor(0xfff7ff00);
                speedometerPressA.setBackgroundCircleColor(0xfff7ff00);
            }else{
                //preto
                speedometerPressA.setTrianglesColor(0xff111111);
                speedometerPressA.setBackgroundCircleColor(0xff111111);
            }

            //PressMBB -------------------------------------------------------------

            Log.e("pressMBB",Dados.getDados().getPressMBB().toString());
            int pressMBB = Math.round(Dados.getDados().getPressMBB());
            speedometerPressMBB.speedTo(pressMBB);

            if(pressMBB > 0 && pressMBB < 80){
                //vermelho
                speedometerPressMBB.setTrianglesColor(0xffff0000);
                speedometerPressMBB.setBackgroundCircleColor(0xffff0000);
            }else if (pressMBB >= 80 && pressMBB < 150){
                //amarelo
                speedometerPressMBB.setTrianglesColor(0xfff7ff00);
                speedometerPressMBB.setBackgroundCircleColor(0xfff7ff00);
            }else{
                //preto
                speedometerPressMBB.setTrianglesColor(0xff111111);
                speedometerPressMBB.setBackgroundCircleColor(0xff111111);
            }

            //PressMBE -------------------------------------------------------------

            Log.e("pressMBE",Dados.getDados().getPressMBE().toString());
            int pressMBE = Math.round(Dados.getDados().getPressMBE());
            speedometerPressMBE.speedTo(pressMBE);

            if(pressMBE > 0 && pressMBE < 80){
                //vermelho
                speedometerPressMBE.setTrianglesColor(0xffff0000);
                speedometerPressMBE.setBackgroundCircleColor(0xffff0000);
            }else if (pressMBE >= 80 && pressMBE < 150){
                //amarelo
                speedometerPressMBE.setTrianglesColor(0xfff7ff00);
                speedometerPressMBE.setBackgroundCircleColor(0xfff7ff00);
            }else{
                //preto
                speedometerPressMBE.setTrianglesColor(0xff111111);
                speedometerPressMBE.setBackgroundCircleColor(0xff111111);
            }

            //PressCxBB -------------------------------------------------------------

            Log.e("PressCxBB",Dados.getDados().getPressCxBB().toString());
            int pressCxBB = Math.round(Dados.getDados().getPressCxBB());
            speedometerPressCxBB.speedTo(pressCxBB);

            if(pressCxBB > 0 && pressCxBB < 80){
                //vermelho
                speedometerPressCxBB.setTrianglesColor(0xffff0000);
                speedometerPressCxBB.setBackgroundCircleColor(0xffff0000);
            }else if (pressCxBB >= 80 && pressCxBB < 150){
                //amarelo
                speedometerPressCxBB.setTrianglesColor(0xfff7ff00);
                speedometerPressCxBB.setBackgroundCircleColor(0xfff7ff00);
            }else{
                //preto
                speedometerPressCxBB.setTrianglesColor(0xff111111);
                speedometerPressCxBB.setBackgroundCircleColor(0xff111111);
            }

            //PressCxBE -------------------------------------------------------------

            Log.e("pressCxBE",Dados.getDados().getPressCxBE().toString());
            int pressCxBE = Math.round(Dados.getDados().getPressCxBE());
            speedometerPressCxBE.speedTo(pressCxBE);

            if(pressCxBE > 0 && pressCxBE < 80){
                //vermelho
                speedometerPressCxBE.setTrianglesColor(0xffff0000);
                speedometerPressCxBE.setBackgroundCircleColor(0xffff0000);
            }else if (pressCxBE >= 80 && pressCxBE < 150){
                //amarelo
                speedometerPressCxBE.setTrianglesColor(0xfff7ff00);
                speedometerPressCxBE.setBackgroundCircleColor(0xfff7ff00);
            }else{
                //preto
                speedometerPressCxBE.setTrianglesColor(0xff111111);
                speedometerPressCxBE.setBackgroundCircleColor(0xff111111);
            }

            //VoltBB -------------------------------------------------------------

            Log.e("voltBB",Dados.getDados().getVoltBB().toString());
            int voltBB = Math.round(Dados.getDados().getVoltBB());
            speedometerVoltBB.speedTo(voltBB);

            if(voltBB > 0 && voltBB < 80){
                //vermelho
                speedometerVoltBB.setTrianglesColor(0xffff0000);
                speedometerVoltBB.setBackgroundCircleColor(0xffff0000);
            }else if (voltBB >= 80 && voltBB < 150){
                //amarelo
                speedometerVoltBB.setTrianglesColor(0xfff7ff00);
                speedometerVoltBB.setBackgroundCircleColor(0xfff7ff00);
            }else{
                //preto
                speedometerVoltBB.setTrianglesColor(0xff111111);
                speedometerVoltBB.setBackgroundCircleColor(0xff111111);
            }

            //VoltBE -------------------------------------------------------------

            Log.e("voltBE",Dados.getDados().getVoltBE().toString());
            int voltBE = Math.round(Dados.getDados().getVoltBE());
            speedometerVoltBE.speedTo(voltBE);

            if(voltBE > 0 && voltBE < 80){
                //vermelho
                speedometerVoltBE.setTrianglesColor(0xffff0000);
                speedometerVoltBE.setBackgroundCircleColor(0xffff0000);
            }else if (voltBE >= 80 && voltBE < 150){
                //amarelo
                speedometerVoltBE.setTrianglesColor(0xfff7ff00);
                speedometerVoltBE.setBackgroundCircleColor(0xfff7ff00);
            }else{
                //preto
                speedometerVoltBE.setTrianglesColor(0xff111111);
                speedometerVoltBE.setBackgroundCircleColor(0xff111111);
            }

            //TempBB -------------------------------------------------------------

            Log.e("tempBB",Dados.getDados().getTempBB().toString());
            int tempBB = Math.round(Dados.getDados().getTempBB());
            speedometerTempBB.speedTo(tempBB);

            if(tempBB > 0 && tempBB < 80){
                //vermelho
                speedometerTempBB.setTrianglesColor(0xffff0000);
                speedometerTempBB.setBackgroundCircleColor(0xffff0000);
            }else if (tempBB >= 80 && tempBB < 150){
                //amarelo
                speedometerTempBB.setTrianglesColor(0xfff7ff00);
                speedometerTempBB.setBackgroundCircleColor(0xfff7ff00);
            }else{
                //preto
                speedometerTempBB.setTrianglesColor(0xff111111);
                speedometerTempBB.setBackgroundCircleColor(0xff111111);
            }

            //TempBE -------------------------------------------------------------

            Log.e("tempBE",Dados.getDados().getTempBE().toString());
            int tempBE = Math.round(Dados.getDados().getTempBE());
            speedometerTempBE.speedTo(tempBE);

            if(tempBE > 0 && tempBE < 80){
                //vermelho
                speedometerTempBE.setTrianglesColor(0xffff0000);
                speedometerTempBE.setBackgroundCircleColor(0xffff0000);
            }else if (tempBE >= 80 && tempBE < 150){
                //amarelo
                speedometerTempBE.setTrianglesColor(0xfff7ff00);
                speedometerTempBE.setBackgroundCircleColor(0xfff7ff00);
            }else{
                //preto
                speedometerTempBE.setTrianglesColor(0xff111111);
                speedometerTempBE.setBackgroundCircleColor(0xff111111);
            }

            //Vento -------------------------------------------------------------

            vento.setText(Dados.getDados().getVento().toString());
            unitVento.setText(Dados.getDados().getSunitMporS());

        }catch (Exception e){
            Log.e("ERRO","Erro na tela navegacao: "+e);
        }
    }
}