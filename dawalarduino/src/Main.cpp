
#include <Arduino.h>
#include <Wire.h>
#include <LiquidCrystal_I2C.h>

#include "DawalBluetooth.h"
#include "DawalProtocolo.h"
#include "DawalFluxo.h"
#include "DawalInterruptores.h"
#include "DawalInterruptor.h"
#include "DawalBateria.h"
#include "DawalSIM808.h"
#include <ArduinoJson.h>

DawalBateria *bateriaBB;
// DawalFluxo *vento;
// DawalFluxo *fluxo1;
// DawalFluxo *fluxo2;
// DawalFluxo *fluxo3;
// DawalFluxo *fluxo4;
// DECLARAÇÃO
// LiquidCrystal_I2C lcd(0x27, 16, 2);
// int i = 0;

#define ESP8266 Serial3

const char *SSID = "SystemCall";
const char *PASSWORD = "SAV1949sav";
String BASE_URL = "http://192.168.0.65:8080";
boolean isEnviouDadosWifi = false;
String jsonSerializer;



void setup()
{
  // lcd.init(); // initialize the lcd
  // lcd.setBacklight(HIGH);

  // delay(1000);
  ESP8266.begin(9600);
  Serial.begin(9600);

  // vento = new DawalFluxo(49);
  // fluxo1 = new DawalFluxo(50);
  // fluxo2 = new DawalFluxo(51);
  // fluxo3 = new DawalFluxo(52);
  // fluxo4 = new DawalFluxo(53);
  // INICIALIZAÇÃO

  // Serial.write("\nTest Start\n");
  //  DawalFluxo::setup(); //OBS COLOCAR SEMPRE AO FINAL DA INICIALIZAÇÃO DOS OBJETOS
  //  DawalBluetooth::setup();
  // DawalInterruptores::setup();
  // DawalSIM808::setup();
   bateriaBB = new DawalBateria(A1);
}

void loop()
{
  // lcd.clear();
  // lcd.setCursor(0, 0);
  // lcd.print("<- " +  (String)i);
  // lcd.setCursor(0, 1);
  // lcd.print( (String)(i+1)+" ->");
  // i++;

  Serial.println("************************INICIO*******************************");

  // DawalBluetooth::loop();
  // DawalFluxo::loop();
  // DawalInterruptores::loop();
  // DawalSIM808::loop();

  // if (DawalSIM808::getMsg() == "GPSOK")
  // {
  //   DawalSIM808::setEnvioLoc(true);
  // }

  // if (DawalBluetooth::hasData())
  // {
  //   Serial.println(DawalBluetooth::getData());
  // }

  // if (Serial.available() > 0)
  // {
  // String dados = Serial.readString();
  // DawalBluetooth::sendData(dados);
  // Serial.println(dados);
  // Serial.flush();
  // }
  // delay(1000);

  // Serial.println("1 " + (String)fluxo1->getVazao());
  // Serial.println("2 " + (String)fluxo2->getVazao());
  // Serial.println("3 " + (String)fluxo3->getVazao());
  // Serial.println("4 " + (String)fluxo4->getVazao());
  // Serial.println("Vento: " + (String)vento->getWindRPM());
  // Serial.println("Vento M/s: " + (String)vento->getWindMS());

  //  Serial.println(analogRead(A0));

 
  jsonSerializer = "";
  DynamicJsonBuffer jb;
  JsonObject &obj = jb.createObject();
  obj["luzNavegacao"] = 0;
  obj["bateriaBB"] = (bateriaBB->getDado());
  obj.printTo(jsonSerializer);

  // PressA;
  // DawalProtocolo::setProtocol("@0;" + (String)(((analogRead(A0) * 0.00489) * 5) - 3));
  // PressMBB;
  // DawalProtocolo::setProtocol("@1;" + (String)(((analogRead(A1) * 0.00489) * 5) - 3));
  // PressMBE;
  // DawalProtocolo::setProtocol("@2;" + (String)(((analogRead(A2) * 0.00489) * 5) - 3));
  // PressCxBB;
  // DawalProtocolo::setProtocol("@3;" + (String)(((analogRead(A3) * 0.00489) * 5) - 3));
  // PressCxBE;
  // DawalProtocolo::setProtocol("@4;" + (String)(((analogRead(A4) * 0.00489) * 5) - 3));
  // VoltBB;
  // DawalProtocolo::setProtocol("@5;" + (String)(((analogRead(A5) * 0.00489) * 5) - 3));
  // VoltBE;
  // DawalProtocolo::setProtocol("@6;" + (String)(((analogRead(A6) * 0.00489) * 5) - 3));
  // TempBB;
  // DawalProtocolo::setProtocol("@7;" + (String)(((analogRead(A7) * 0.00489) * 5) - 3));
  // TempBE;
  // DawalProtocolo::setProtocol("@8;" + (String)(((analogRead(A8) * 0.00489) * 5) - 3));

  // DawalProtocolo::setProtocol("@9;" + (String)(((analogRead(A9) * 0.00489) * 5) - 3));
  // Luz Navegação
  // DawalProtocolo::setProtocol("@22;" + (String)digitalRead(22));
  // Luz Painel
  // DawalProtocolo::setProtocol("@23;" + (String)digitalRead(23));
  // Strobo
  // DawalProtocolo::setProtocol("@24;" + (String)digitalRead(24));
  // Bussola
  // DawalProtocolo::setProtocol("@25;" + (String)digitalRead(25));
  // Farol de Popa
  // DawalProtocolo::setProtocol("@26;" + (String)digitalRead(26));
  // Limpador
  // DawalProtocolo::setProtocol("@27;" + (String)digitalRead(27));
  // Luz do topo
  // DawalProtocolo::setProtocol("@28;" + (String)digitalRead(28));
  // Buzina
  // DawalProtocolo::setProtocol("@29;" + (String)digitalRead(29));
  // DawalProtocolo::setProtocol("@30;" + (String)digitalRead(30));
  // DawalProtocolo::setProtocol("@31;" + (String)digitalRead(31));
  // DawalProtocolo::setProtocol("@32;" + (String)digitalRead(32));
  // DawalProtocolo::setProtocol("@33;" + (String)digitalRead(33));
  // DawalProtocolo::setProtocol("@34;" + (String)digitalRead(34));
  // DawalProtocolo::setProtocol("@35;" + (String)digitalRead(35));
  // DawalProtocolo::setProtocol("@36;" + (String)digitalRead(36));
  // Vento
  //  DawalProtocolo::setProtocol("@47;" + (String)vento->getWindRPM());
  // Vento
  //  DawalProtocolo::setProtocol("@48;" + (String)vento->getWindMS());
  //  //Vento
  //  DawalProtocolo::setProtocol("@49;" + (String)vento->getWindKMH());
  // fluxo in BB
  //  DawalProtocolo::setProtocol("@50;" + (String)fluxo1->getVazao()); //em ml
  //  //fluxo out BB
  //  DawalProtocolo::setProtocol("@51;" + (String)fluxo2->getVazao()); //em ml
  //  //fluxo in BE
  //  DawalProtocolo::setProtocol("@52;" + (String)fluxo3->getVazao()); //em ml
  //  //fluxo out BE
  //  DawalProtocolo::setProtocol("@53;" + (String)fluxo4->getVazao()); //em ml

  // DawalBluetooth::sendData(DawalProtocolo::getProtocol());

  if (!isEnviouDadosWifi)
  {
    String dadosWifi = "{\"SSID\":\"SystemCall\",\"PASSWORD\":SAV1949sav,\"BASE_URL\":\"http://192.168.0.12:8080/teste\"}";
    Serial.println(dadosWifi);
    ESP8266.println(dadosWifi);
    isEnviouDadosWifi = true;
  }

  DawalProtocolo::limparProtocol();

  Serial.println("*******************************************************");

  if (ESP8266.available())
  {
    String msg = ESP8266.readString();
    Serial.println(msg);
  }

  delay(5000);

  Serial.println(jsonSerializer);
  ESP8266.println(jsonSerializer);
}
