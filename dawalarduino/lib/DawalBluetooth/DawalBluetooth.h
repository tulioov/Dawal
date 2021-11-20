#include <Arduino.h>

class DawalBluetooth{
public:
  static void loop(); //loop
  static void setup(); //setup
  static bool hasData();
  static String getData();
  static void sendData(String data);
  static bool available;

private:
  static String lastData;

};
