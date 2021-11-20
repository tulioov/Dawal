package com.example.tulio.dawal41.Ultil;

import android.util.Log;

public class Dados {

    private static Dados dados = new Dados();

    private boolean unitLporH;
    private boolean unitMetros;
    private boolean unitHora;
    private boolean unitLitro;
    private boolean unitMporS;
    private String sunitLporH;
    private String sunitMetros;
    private String sunitHora;
    private String sunitLitro;
    private String sunitMporS;
    private Float pressD = 0.0f;
    private Float pressA = 0.0f;
    private Float pressMBB = 0.0f;
    private Float pressMBE = 0.0f;
    private Float pressCxBB = 0.0f;
    private Float pressCxBE = 0.0f;
    private Float voltBB = 0.0f;
    private Float voltBE = 0.0f;
    private Float tempBB = 0.0f;
    private Float tempBE = 0.0f;
    private Float consmBB = 0.0f;
    private Float consmBE = 0.0f;
    private Float rPMBB = 0.0f;
    private Float rPMBE = 0.0f;
    private Float fluxoInBB = 0.0f;
    private Float fluxoOutBB = 0.0f;
    private Float fluxoInBE = 0.0f;
    private Float fluxoOutBE = 0.0f;
    private Float vento = 0.0f;
    private Float ventoRPM = 0.0f;
    private Float ventoMS = 0.0f;
    private Float ventoKMH = 0.0f;
    private Float lBombaProa = 0.0f;
    private Float lPopa1 = 0.0f;
    private Float lPopa2 = 0.0f;
    private Float lCortesia = 0.0f;
    private Float lAguaDoce = 0.0f;
    private Float lMotor = 0.0f;
    private Float lPainel = 0.0f;
    private Float lBussula = 0.0f;
    private Float lLimpador = 0.0f;
    private Float lStrobo = 0.0f;
    private Float lBuzina = 0.0f;
    private Float lFarolPopa = 0.0f;
    private Float lTopo = 0.0f;
    private Float lNavegação = 0.0f;
    private Float consumoTotalBB = 0.0F;
    private Float consumoTotalBE = 0.0F;
    private Float tempoFuncionamentoBB = 0.0f;
    private Float tempoFuncionamentoBE = 0.0f;
    private Float velocMedia = 0.0F;
    private Float velocMax = 0.0F;
    private Float distPercorrida = 0.0F;
    private Float tempo = 0.0f;


    public Dados() {

    }

    public static Dados getDados() {
        return dados;
    }

    public static void setDados(Dados dados) {
        Dados.dados = dados;
    }

    public Float getPressD() {
        return pressD;
    }

    public void setPressD(Float pressD) {
        this.pressD = pressD;
    }

    public Float getPressA() {
        return pressA;
    }

    public void setPressA(Float pressA) {
        this.pressA = pressA;
    }

    public Float getPressMBB() {
        return pressMBB;
    }

    public void setPressMBB(Float pressMBB) {
        this.pressMBB = pressMBB;
    }

    public Float getPressMBE() {
        return pressMBE;
    }

    public void setPressMBE(Float pressMBE) {
        this.pressMBE = pressMBE;
    }

    public Float getPressCxBB() {
        return pressCxBB;
    }

    public void setPressCxBB(Float pressCxBB) {
        this.pressCxBB = pressCxBB;
    }

    public Float getPressCxBE() {
        return pressCxBE;
    }

    public void setPressCxBE(Float pressCxBE) {
        this.pressCxBE = pressCxBE;
    }

    public Float getVoltBB() {
        return voltBB;
    }

    public void setVoltBB(Float voltBB) {
        this.voltBB = voltBB;
    }

    public Float getVoltBE() {
        return voltBE;
    }

    public void setVoltBE(Float voltBE) {
        this.voltBE = voltBE;
    }

    public Float getTempBB() {
        return tempBB;
    }

    public void setTempBB(Float tempBB) {
        this.tempBB = tempBB;
    }

    public Float getTempBE() {
        return tempBE;
    }

    public void setTempBE(Float tempBE) {
        this.tempBE = tempBE;
    }

    public Float getConsmBB() {

        float value = fluxoInBB - fluxoOutBB;
        return value;
    }

    public void setConsmBB(Float consmBB) {
        this.consmBB = consmBB;
    }

    public Float getConsmBE() {

        float value = fluxoInBE - fluxoOutBE;
        return value;
    }

    public void setConsmBE(Float consmBE) {
        this.consmBE = consmBE;
    }

    public Float getrPMBB() {
        return rPMBB;
    }

    public void setrPMBB(Float rPMBB) {
        this.rPMBB = rPMBB;
    }

    public Float getrPMBE() {
        return rPMBE;
    }

    public void setrPMBE(Float rPMBE) {
        this.rPMBE = rPMBE;
    }

    public Float getVentoRPM() {
        return ventoRPM;
    }

    public void setVentoRPM(Float ventoRPM) {
        this.ventoRPM = ventoRPM;
    }

    public Float getVento() {

        if(isUnitMporS()){
            vento = getVentoMS();
        }else{
            vento = getVentoKMH();
        }

        return vento;
    }

    public void setVento(Float vento) {
        this.vento = vento;
    }

    public Float getVentoMS() {
        return ventoMS;
    }

    public void setVentoMS(Float ventoMS) {
        this.ventoMS = ventoMS;
    }

    public Float getVentoKMH() {
        return ventoKMH;
    }

    public void setVentoKMH(Float ventoKMH) {
        this.ventoKMH = ventoKMH;
    }

    public Float getFluxoInBB() {
        if(isUnitLporH()){
            fluxoInBB = fluxoInBB*360/1000;
        }else{
            fluxoInBB = fluxoInBB+60/1000;
        }
        return fluxoInBB;
    }

    public void setFluxoInBB(Float fluxoInBB) {
        this.fluxoInBB = fluxoInBB;
    }

    public Float getFluxoOutBB() {
        if(isUnitLporH()){
            fluxoOutBB = fluxoOutBB*360/1000;
        }else{
            fluxoOutBB = fluxoOutBB+60/1000;
        }
        return fluxoOutBB;
    }

    public void setFluxoOutBB(Float fluxoOutBB) {
        this.fluxoOutBB = fluxoOutBB;
    }

    public Float getFluxoInBE() {
        if(isUnitLporH()){
            fluxoInBE = fluxoInBE*360/1000;
        }else{
            fluxoInBE = fluxoInBE*60/1000;
        }
        return fluxoInBE;
    }

    public void setFluxoInBE(Float fluxoInBE) {
        this.fluxoInBE = fluxoInBE;
    }

    public Float getFluxoOutBE() {

        if(isUnitLporH()){
            fluxoOutBE = fluxoOutBE*360/1000;
        }else{
            fluxoOutBE = fluxoOutBE*60/1000;
        }
        return fluxoOutBE;
    }

    public void setFluxoOutBE(Float fluxoOutBE) {
        this.fluxoOutBE = fluxoOutBE;
    }

    public Float getlBombaProa() {
        return lBombaProa;
    }

    public void setlBombaProa(Float lBombaProa) {
        this.lBombaProa = lBombaProa;
    }

    public Float getlPopa1() {
        return lPopa1;
    }

    public void setlPopa1(Float lPopa1) {
        this.lPopa1 = lPopa1;
    }

    public Float getlPopa2() {
        return lPopa2;
    }

    public void setlPopa2(Float lPopa2) {
        this.lPopa2 = lPopa2;
    }

    public Float getlCortesia() {
        return lCortesia;
    }

    public void setlCortesia(Float lCortesia) {
        this.lCortesia = lCortesia;
    }

    public Float getlAguaDoce() {
        return lAguaDoce;
    }

    public void setlAguaDoce(Float lAguaDoce) {
        this.lAguaDoce = lAguaDoce;
    }

    public Float getlMotor() {
        return lMotor;
    }

    public void setlMotor(Float lMotor) {
        this.lMotor = lMotor;
    }

    public Float getlPainel() {
        return lPainel;
    }

    public void setlPainel(Float lPainel) {
        this.lPainel = lPainel;
    }

    public Float getlBussula() {
        return lBussula;
    }

    public void setlBussula(Float lBussula) {
        this.lBussula = lBussula;
    }

    public Float getlLimpador() {
        return lLimpador;
    }

    public void setlLimpador(Float lLimpador) {
        this.lLimpador = lLimpador;
    }

    public Float getlStrobo() {
        return lStrobo;
    }

    public void setlStrobo(Float lStrobo) {
        this.lStrobo = lStrobo;
    }

    public Float getlBuzina() {
        return lBuzina;
    }

    public void setlBuzina(Float lBuzina) {
        this.lBuzina = lBuzina;
    }

    public Float getlFarolPopa() {
        return lFarolPopa;
    }

    public void setlFarolPopa(Float lFarolPopa) {
        this.lFarolPopa = lFarolPopa;
    }

    public Float getlTopo() {
        return lTopo;
    }

    public void setlTopo(Float lTopo) {
        this.lTopo = lTopo;
    }

    public Float getlNavegação() {
        return lNavegação;
    }

    public void setlNavegação(Float lNavegação) {
        this.lNavegação = lNavegação;
    }

    public boolean isUnitLporH() {
        return unitLporH;
    }

    public void setUnitLporH(boolean unitLporH) {
        this.unitLporH = unitLporH;
    }

    public boolean isUnitMetros() {
        return unitMetros;
    }

    public void setUnitMetros(boolean unitMetros) {
        this.unitMetros = unitMetros;
    }

    public boolean isUnitHora() {
        return unitHora;
    }

    public void setUnitHora(boolean unitHora) {
        this.unitHora = unitHora;
    }

    public boolean isUnitLitro() {
        return unitLitro;
    }

    public boolean isUnitMporS() {
        return unitMporS;
    }

    public void setUnitMporS(boolean unitMporS) {
        this.unitMporS = unitMporS;
    }

    public void setUnitLitro(boolean unitLitro) {
        this.unitLitro = unitLitro;
    }

    public String getSunitMporS() {

        if(isUnitMporS()){
            sunitMporS = "m/s";
        }else{
            sunitMporS = "km/h";
        }

        return sunitMporS;
    }

    public String getSunitLporH() {
        if(unitLporH){
            sunitLporH = "L/H";
        }
        else
            sunitLporH = "L/M";
        return sunitLporH;
    }

    public String getSunitMetros() {

        if(unitMetros){
            sunitMetros = "M";
        }
        else
            sunitMetros = "KM";
        return sunitMetros;
    }

    public String getSunitHora() {
        if(unitHora){
            sunitHora = "H";
        }
        else
            sunitHora = "M";
        return sunitHora;
    }

    public String getSunitLitro() {
        if(unitLitro){
            sunitLitro = "L";
        }
        else
            sunitLitro = "ML";
        return sunitLitro;
    }

    public Float getConsumoTotalBB() {
        consumoTotalBB = consumoTotalBB + getConsmBB();
        if (unitLitro){
            return (consumoTotalBB*4)/1000;
        }else{
            return consumoTotalBB*4;
        }

    }

    public void setConsumoTotalBB(Float consumoTotalBB) {
        this.consumoTotalBB = consumoTotalBB;
    }

    public Float getConsumoTotalBE() {
        consumoTotalBE = consumoTotalBE + getConsmBE();
        if (unitLitro){
            return (consumoTotalBE*4)/1000;
        }else{
            return consumoTotalBE*4;
        }
    }

    public void setConsumoTotalBE(Float consumoTotalBE) {
        this.consumoTotalBE = consumoTotalBE;
    }

    public Float getTempoFuncionamentoBB() {
        return tempoFuncionamentoBB;
    }

    public void setTempoFuncionamentoBB(Float tempoFuncionamentoBB) {
        this.tempoFuncionamentoBB = tempoFuncionamentoBB;
    }

    public Float getTempoFuncionamentoBE() {
        return tempoFuncionamentoBE;
    }

    public void setTempoFuncionamentoBE(Float tempoFuncionamentoBE) {
        this.tempoFuncionamentoBE = tempoFuncionamentoBE;
    }

    public Float getVelocMedia() {
        return velocMedia;
    }

    public void setVelocMedia(Float velocMedia) {
        this.velocMedia = velocMedia;
    }

    public Float getVelocMax() {
        return velocMax;
    }

    public void setVelocMax(Float velocMax) {
        this.velocMax = velocMax;
    }

    public Float getDistPercorrida() {
        return distPercorrida;
    }

    public void setDistPercorrida(Float distPercorrida) {
        this.distPercorrida = distPercorrida;
    }

    public Float getTempo() {
        return tempo;
    }

    public void setTempo(Float tempo) {
        this.tempo = tempo;
    }
}
