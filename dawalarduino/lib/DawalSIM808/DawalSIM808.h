#include <Arduino.h>

class DawalSIM808{
public:

  static void setup();
  static void loop();
  void setRemetente(String remetent);
  String getRemetente();
  static void setEnvioLoc(boolean locc);
  static void sendMsgLocalizacao(String celulares[10]);
  static void sendTabData(String command ,boolean debug);
  static String sendData(String command ,boolean debug);
  static void sendMsg(String nTelefone, String msg);
  static String getMsg();
  static String trim(String sText);
  static void apagarMsg(int n);


};
