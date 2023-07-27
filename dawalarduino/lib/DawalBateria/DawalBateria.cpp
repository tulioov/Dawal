#include "DawalBateria.h"
#include <string.h>

DawalBateria::DawalBateria(int voltageSensor)
{
  this->voltageSensor = voltageSensor;
}
float DawalBateria::getDado()
{
  this->value = analogRead(voltageSensor);
  DawalBateria::vOUT = (DawalBateria::value * 5.0) / 1024.0;
  DawalBateria::vIN = DawalBateria::vOUT / (DawalBateria::R2 / (DawalBateria::R1 + DawalBateria::R2));
  long result = DawalBateria::vIN / 1.53689;
  return result;
}
