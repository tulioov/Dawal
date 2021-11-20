package com.example.tulio.dawal41.Ultil;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tulio on 10/01/2017.
 */

public class DawalBluetoothObservable {

    private static List<DawalBluetoothObserver> observers = new ArrayList<>();
    private static String bluetoothData;
    private static Map<Integer, Float> pinosValores = new HashMap<>();


    public static void newData(String newBluetoothData) {
        bluetoothData = newBluetoothData;
        pinosValores.put(52, (float) 0);
        notifyObservers();
    }

    public static void registerObserver(DawalBluetoothObserver obs) {
        observers.add(obs);
    }

    public static float getPinosValores(int pino) {


        if (pinosValores.get(pino).equals(null))
            return 0;
        else
            return pinosValores.get(pino);
    }

    private static void notifyObservers() {

        String[] comandos = bluetoothData.split("@");

        for (String comando : comandos) {
            String[] pinoValor = comando.split(";");
            if (pinoValor.length == 2) {
                try {
                    int pino = Integer.parseInt(pinoValor[0]);
                    float valor = Float.parseFloat(pinoValor[1]);
                    pinosValores.put(pino, valor);
                }catch (Exception e){
                    Log.e("Erro nos Pinos: ", "Erro: " + e);
                }
            }
        }
        /**/
        Dados.getDados().setPressA(getPinosValores(0));
        Dados.getDados().setPressD(getPinosValores(1));
        Dados.getDados().setPressMBB(getPinosValores(2));
        Dados.getDados().setPressMBE(getPinosValores(3));
        Dados.getDados().setPressCxBB(getPinosValores(4));
        Dados.getDados().setPressCxBE(getPinosValores(5));
        Dados.getDados().setVoltBB(getPinosValores(6));
        Dados.getDados().setVoltBE(getPinosValores(7));
        Dados.getDados().setTempBB(getPinosValores(8));
        Dados.getDados().setTempBE(getPinosValores(9));
        Dados.getDados().setlAguaDoce(getPinosValores(22));
        Dados.getDados().setlAguaDoce(getPinosValores(23));
        Dados.getDados().setlAguaDoce(getPinosValores(24));
        Dados.getDados().setlAguaDoce(getPinosValores(25));
        Dados.getDados().setlAguaDoce(getPinosValores(26));
        Dados.getDados().setlAguaDoce(getPinosValores(27));
        Dados.getDados().setlAguaDoce(getPinosValores(28));
        Dados.getDados().setlAguaDoce(getPinosValores(29));
        Dados.getDados().setlAguaDoce(getPinosValores(30));
        Dados.getDados().setlAguaDoce(getPinosValores(31));
        Dados.getDados().setlAguaDoce(getPinosValores(32));
        Dados.getDados().setlAguaDoce(getPinosValores(33));
        Dados.getDados().setlAguaDoce(getPinosValores(34));
        Dados.getDados().setlAguaDoce(getPinosValores(35));
        Dados.getDados().setlAguaDoce(getPinosValores(36));
        Dados.getDados().setVentoRPM(getPinosValores(47));
        Dados.getDados().setVentoMS(getPinosValores(48));
        Dados.getDados().setVentoKMH(getPinosValores(49));
        Dados.getDados().setFluxoInBB(getPinosValores(50));
        Dados.getDados().setFluxoOutBB(getPinosValores(51));
        Dados.getDados().setFluxoInBE(getPinosValores(52));
        Dados.getDados().setFluxoOutBE(getPinosValores(53));

        /**/
        for (DawalBluetoothObserver obs : observers) {
            try {
                Log.e("Tamanho da lista: ", "numero: " + observers.size());
                observers.size();
                obs.notifyUpdate(pinosValores);
            }catch (Exception e){
                Log.e("Erro na lista: ", "Erro: " + e);
                Log.e("Erro na lista: ", "Erro: " + e.getStackTrace());
            }
        }


    }


}
