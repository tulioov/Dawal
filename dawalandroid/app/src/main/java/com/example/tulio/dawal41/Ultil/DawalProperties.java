package com.example.tulio.dawal41.Ultil;


import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class DawalProperties {

    private java.util.Properties properties;
    private final String FILE = Environment.getExternalStorageDirectory() + "/Dawal";

    public DawalProperties() {

        properties = new java.util.Properties();
    }

    public void criarPropertie() {

        try {
            File folder = new File(Environment.getExternalStorageDirectory() + "/Dawal");
            if (!folder.exists()) {
                folder.mkdir();
                FileOutputStream fos = new FileOutputStream(FILE + "/Config.properties");
                String teste = "cofAngularFluxo1 = 1;";
                fos.write(teste.getBytes());
                fos.flush();
                fos.close();

                setProperties("cofAngularFluxo1", "1");
                setProperties("ajusteFluxo1", "0");

                setProperties("cofAngularFluxo2", "1");
                setProperties("ajusteFluxo2", "0");

                setProperties("cofAngularTempBB", "1");
                setProperties("ajusteTempBB", "0");

                setProperties("cofAngularPressMBB", "1");
                setProperties("ajustePressMBB", "0");

                setProperties("cofAngularPressCxBB", "1");
                setProperties("ajustePressCxBB", "0");

                setProperties("cofAngularVoltBB", "1");
                setProperties("ajusteVoltBB", "0");

                //---------------------------------------------------------------------------

                setProperties("cofAngularFluxo3", "1");
                setProperties("ajusteFluxo3", "0");

                setProperties("cofAngularFluxo4", "1");
                setProperties("ajusteFluxo4", "0");

                setProperties("cofAngularTempBE", "1");
                setProperties("ajusteTempBE", "0");

                setProperties("cofAngularPressMBE", "1");
                setProperties("ajustePressMBE", "0");

                setProperties("cofAngularPressCxBE", "1");
                setProperties("ajustePressCxBE", "0");

                setProperties("cofAngularVoltBE", "1");
                setProperties("ajusteVoltBE", "0");

                //---------------------------------------------------------------------------

                setProperties("cofAngularPressD", "1");
                setProperties("ajustePressD", "0");

                setProperties("cofAngularPressA", "1");
                setProperties("ajustePressA", "0");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public String getProperties(String property) {

        try {
            File file = new File(FILE + "/Config.properties");
            FileInputStream fis = new FileInputStream(file);
            properties.load(fis);
        } catch (Exception e) {
            Log.e("DawalProperties", e.toString());
        }
        return properties.getProperty(property);
    }

    public void setProperties(String property, String value) {
        try {

            File file = new File(FILE + "/Config.properties");
            FileInputStream fis = new FileInputStream(file);
            properties.load(fis);
            properties.setProperty(property, value);

            FileOutputStream fr = new FileOutputStream(FILE + "/Config.properties");
            properties.store(fr, "Properties");
            fr.close();
        } catch (IOException e) {
            Log.e("DawalProperties", e.toString());
        }
    }

}
