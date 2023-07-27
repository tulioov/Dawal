#include <Arduino.h>

class DawalInterruptor{

private:
  static String nome;
  static int status;


public:
  static String getNome();
  static void setNome(String nome);

  static int getStatus();
  static void setStatus(int nome);

};
