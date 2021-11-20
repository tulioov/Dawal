#include "DawalSIM808.h"
#include <string.h>


#define sim808 Serial2


#define DEBUG true
String state;
String timegps;
String latitude;
String longitude;
String remetente;
String celulares[10];
boolean loc = false;

void DawalSIM808::setup(){

  sim808.begin(9600);
  Serial.begin(9600);
  delay(50);

  sendData("AT+CSMP=17,167,0,0",DEBUG);
  delay(100);
  sendData("AT+CMGF=1",DEBUG);
  delay(100);
  sendData("AT+CGNSPWR=1",DEBUG);
  delay(100);
  sendData("AT+CGNSSEQ=RMC",DEBUG);
  delay(100);
  sendData("",DEBUG);
  sim808.flush();


}
void DawalSIM808::loop(){
  if (loc){
    Serial.println("Remetente: " + remetente);
    DawalSIM808::sendMsgLocalizacao(celulares);
  }
}

void DawalSIM808::setEnvioLoc(boolean locc){
  loc = locc;
}
void DawalSIM808::setRemetente(String remetent){
  remetente = remetent;
}
String DawalSIM808::getRemetente(){
  return remetente;
}

String DawalSIM808::getMsg(){

  String data[11];
  String response, msg;

  //Status = “ALL”, “REC UNREAD” or “REC READ”
  response = sendData("AT+CMGL=\"REC UNREAD\"",false);
  delay(200);

  //Serial.println("response: ["+response+"]");

  int i = 0;

    for(int j=0 ; response.length() > j ; j++ ) {
      char c = response[j];
      if (c != '\"') {
        data[i] += c;
      } else {
        i++;
      }
      if (i == 11) {
        goto exitL;
      }
  } exitL:
    remetente = data[5];
    msg = data[10];

  msg = trim(msg);
  Serial.println("Remetente: ["+remetente+"]");
  Serial.println("msg: ["+msg+"]");

  if(remetente.length() != 0){
    for (int i=0;i<10;i++){
      Serial.print("celular [");
      Serial.println(celulares[i]+"]");
      if(celulares[i].length() == 0 ){
        celulares[i] = remetente;
        i = 11;
      }
    }
  }
  apagarMsg(50);

  return msg;

}

void DawalSIM808::apagarMsg(int n){

  int i = 0 ;
  while ( i < n ){
    sendData("AT+CMGD="+i, false);
    i++;
  }

}

void DawalSIM808::sendMsg(String nTelefone, String msg){


    Serial.println("Enviando Msg");

    //verificar sinal 0~31  31 é bom
    //sim808.println("AT+CSQ");

    delay(2000);

    sim808.print("AT+CMGS=\"");
    sim808.print(nTelefone);
    sim808.println("\"");

    delay(2000);

    //escrevendo msg que vai ser enviada.
    sim808.print("Dawal41 informa: "+ msg);
    sim808.println((char)26); // End AT command with a ^Z, ASCII code 26
    delay(30000);

    Serial.println("Msg Enviada");

}

void DawalSIM808::sendMsgLocalizacao(String celulares[10]){


  sendTabData("AT+CGNSINF", false);

  if(DEBUG){
    Serial.println("State  :" + state);
    Serial.println("Time  :" + timegps);
    Serial.println("Latitude  :" + latitude);
    Serial.println("Longitude  :" + longitude);
    for(int i=0;i<=10;i++){
      Serial.print("Celulares armazenados ");
      Serial.print(i);
      Serial.println(" : "+celulares[i]);
    }
  }

  // Só manda se tiver a localização
  if (state != 0 && latitude.length() > 6 && longitude.length() > 6 ) {

    String msg = "http://maps.google.com/maps?q=loc:"+latitude+","+longitude;

    Serial.println("Enviando msg: "+ msg);

    for(int i=0;i<10;i++){
      if(celulares[i].length() != 0){
        sendMsg(celulares[i],msg);
        celulares[i]="";
      }
    }


    loc = false;

  } else {
    Serial.println("GPS Initializing…");
  }


}

//**********************************************************************

void DawalSIM808::sendTabData(String command , boolean debug) {

  String response;
  String data[5];
  sim808.println(command);
  delay(200);

  while (sim808.available()) {
    char c = sim808.read();
    response += c;
  }

  Serial.println("response sendTabData: ["+response+"]");

  int i = 0;

    for(int j=0 ; response.length() > j ; j++ ) {
      char c = response[j];
      if (c != ',') {
        data[i] += c;
      } else {
        i++;
      }
      if (i == 5) {
        goto exitL;
      }
} exitL:
    state = data[1];
    timegps = data[2];
    latitude = data[3];
    longitude = data[4];


}

//**********************************************************************

String DawalSIM808::sendData (String command , boolean debug) {

  String response;
  sim808.println(command);
  delay(200);

  while (sim808.available()) {
    char c = sim808.read();
    response += c;
  }

  if (debug) {
    Serial.print(response);
  }
  return response;
}


String DawalSIM808::trim(String sText){

  String semEspaco = "";

  for(int i = 0 ; i<=sText.length() ; i++){
    if(sText[i] != ' ' && sText[i] != '\n' && sText[i] != '\r' ){
      semEspaco += sText[i];
    }
  }
  return semEspaco;

}
