#include <Arduino.h>


class DawalFluxo{
//static const int MAX_FLUXO = 4;
public:
  static void setup();
  static void loop();
  static DawalFluxo** getListaFluxo();
  float getVazao();
  int getWindRPM();
  float getWindMS();
  float getWindKMH();

  int id;
  static int lastId;
  int getId();
  DawalFluxo* getFluxo(int id);
  DawalFluxo(int pino);
  int contaPulso; //Variável para a quantidade de pulsos
  int pino; //pino de entrada


private:
  float vazao; //Variável para armazenar o valor em L/min
  void incpulso();

  // --- Constantes ---
  const float pi = 3.14159265;     //Número de pi
  int period = 5000;               //Tempo de medida(miliseconds)
  int delaytime = 2000;            //Invervalo entre as amostras (miliseconds)
  int radius = 147;                //Raio do anemometro(mm)

  // --- Variáveis Globais ---
  unsigned int RPM = 0;            //Rotações por minuto
  float speedwind = 0;             //Velocidade do vento (m/s)
  float windspeed = 0;             //Velocidade do vento (km/h)
};
