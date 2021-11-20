#include "DawalBluetooth.h"
#define HC06 Serial1

bool DawalBluetooth::available = false;
String DawalBluetooth::lastData = "";

void DawalBluetooth::setup(){
    HC06.begin(9600);
}

bool DawalBluetooth::hasData(){
  return DawalBluetooth::available;
}
void DawalBluetooth::loop(){
  if(HC06.available()>0){
    DawalBluetooth::lastData = HC06.readString();
    DawalBluetooth::available = true;
  }
}
String DawalBluetooth::getData(){
  DawalBluetooth::available = false;
  return DawalBluetooth::lastData;
}

void DawalBluetooth::sendData(String data){
  HC06.println(data);
}
