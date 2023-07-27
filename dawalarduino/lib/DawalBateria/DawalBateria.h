#include <Arduino.h>

class DawalBateria
{
private:
  float vOUT = 0.0;
  float vIN = 0.0;
  float R1 = 30000.0;
  float R2 = 7500.0;
  int value = 0;

  static float dado;

public:
  DawalBateria(int voltageSensor);
  int voltageSensor;
  float getDado();
};