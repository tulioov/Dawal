#include <Arduino.h>

class DawalProtocolo{
private:
   static String protocol;

public:
  static String getProtocol();
  static  void setProtocol(String protocolo);
  static void limparProtocol();
};
