#include <Arduino.h>
#define SIM808 Serial2
//SoftwareSerial SIM808 (17, 16); // Selecionamos os pinos 7 como Rx e 8 como Tx

void setup() {
  SIM808.begin (9600);
  Serial.begin(9600);
  delay(1000);
}

void loop() {

     //Enviando e recebendo dados 
   if (Serial.available() > 0)
    SIM808.write(Serial.read());
   if (SIM808.available() > 0)
    Serial.write(SIM808.read());

}
