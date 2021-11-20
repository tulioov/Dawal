
#include "DawalFluxo.h"


int DawalFluxo::lastId = 0;
DawalFluxo* listFluxo[5];

DawalFluxo** DawalFluxo::getListaFluxo(){
  return listFluxo;
}
DawalFluxo* DawalFluxo::getFluxo(int id){
  return listFluxo[id];
}
void incpulso0(){
  listFluxo[0]->contaPulso++;
}
void incpulso1(){
  listFluxo[1]->contaPulso++;
}
void incpulso2(){
  listFluxo[2]->contaPulso++;
}
void incpulso3(){
  listFluxo[3]->contaPulso++;
}
void incpulso4(){
  listFluxo[4]->contaPulso++;
}
void DawalFluxo::incpulso(){
   this->contaPulso++; //Incrementa a variável de contagem dos pulsos
}
DawalFluxo::DawalFluxo(int pino){
  this->pino = pino;
  this->id = DawalFluxo::lastId++;
  this->contaPulso = 0;
  listFluxo[this->id] = this;
}
void DawalFluxo::setup(){
}
void DawalFluxo::loop(){
  listFluxo[0]->contaPulso=0;
  listFluxo[1]->contaPulso=0;
  listFluxo[2]->contaPulso=0;
  listFluxo[3]->contaPulso=0;
  listFluxo[4]->contaPulso=0;


  //Configura para trabalhar com 1 fluxos
  if (DawalFluxo::lastId==1){
      //Serial.write("\n Configura para trabalhar com 1 fluxos \n");
      pinMode(listFluxo[0]->pino, INPUT);
      attachInterrupt(digitalPinToInterrupt(listFluxo[0]->pino), incpulso0, RISING);
      delay(1000);
      detachInterrupt(digitalPinToInterrupt(listFluxo[0]->pino));
      //detachInterrupt(listFluxo[0]->pino);
  }

     //Configura para trabalhar com 2 fluxos
  if (DawalFluxo::lastId==2){
      //Serial.write("\n Configura para trabalhar com 2 fluxos \n");
      pinMode(listFluxo[1]->pino, INPUT);
      attachInterrupt(digitalPinToInterrupt(listFluxo[0]->pino), incpulso0, RISING);
      delay(1000);
      detachInterrupt(digitalPinToInterrupt(listFluxo[0]->pino));
      attachInterrupt(digitalPinToInterrupt(listFluxo[1]->pino), incpulso1, RISING);
      delay(1000);
      detachInterrupt(digitalPinToInterrupt(listFluxo[1]->pino));

  }
  //Configura para trabalhar com 3 fluxos
  if (DawalFluxo::lastId==3){
      //Serial.write("\n Configura para trabalhar com 3 fluxos \n");
      pinMode(listFluxo[2]->pino, INPUT);
      attachInterrupt(digitalPinToInterrupt(listFluxo[0]->pino), incpulso0, RISING);
      delay(1000);
      detachInterrupt(digitalPinToInterrupt(listFluxo[0]->pino));
      attachInterrupt(digitalPinToInterrupt(listFluxo[1]->pino), incpulso1, RISING);
      delay(1000);
      detachInterrupt(digitalPinToInterrupt(listFluxo[1]->pino));
      attachInterrupt(digitalPinToInterrupt(listFluxo[2]->pino), incpulso2, RISING);
      delay(1000);
      detachInterrupt(digitalPinToInterrupt(listFluxo[2]->pino));
    }
  //Configura para trabalhar com 4 fluxos
  if (DawalFluxo::lastId==4){
      //Serial.write("\n Configura para trabalhar com 4 fluxos \n");
      pinMode(listFluxo[3]->pino, INPUT);
      attachInterrupt(digitalPinToInterrupt(listFluxo[0]->pino), incpulso0, RISING);
      delay(1000);
      detachInterrupt(digitalPinToInterrupt(listFluxo[0]->pino));
      attachInterrupt(digitalPinToInterrupt(listFluxo[1]->pino), incpulso1, RISING);
      delay(1000);
      detachInterrupt(digitalPinToInterrupt(listFluxo[1]->pino));
      attachInterrupt(digitalPinToInterrupt(listFluxo[2]->pino), incpulso2, RISING);
      delay(1000);
      detachInterrupt(digitalPinToInterrupt(listFluxo[2]->pino));
      attachInterrupt(digitalPinToInterrupt(listFluxo[3]->pino), incpulso3, RISING);
      delay(1000);
      detachInterrupt(digitalPinToInterrupt(listFluxo[3]->pino));
    }
    if (DawalFluxo::lastId==5){
        //Serial.write("\n Configura para trabalhar com 5 fluxos \n");
        pinMode(listFluxo[4]->pino, INPUT);
        attachInterrupt(digitalPinToInterrupt(listFluxo[0]->pino), incpulso0, RISING);
        delay(1000);
        detachInterrupt(digitalPinToInterrupt(listFluxo[0]->pino));
        attachInterrupt(digitalPinToInterrupt(listFluxo[1]->pino), incpulso1, RISING);
        delay(1000);
        detachInterrupt(digitalPinToInterrupt(listFluxo[1]->pino));
        attachInterrupt(digitalPinToInterrupt(listFluxo[2]->pino), incpulso2, RISING);
        delay(1000);
        detachInterrupt(digitalPinToInterrupt(listFluxo[2]->pino));
        attachInterrupt(digitalPinToInterrupt(listFluxo[3]->pino), incpulso3, RISING);
        delay(1000);
        detachInterrupt(digitalPinToInterrupt(listFluxo[3]->pino));
        attachInterrupt(digitalPinToInterrupt(listFluxo[4]->pino), incpulso4, RISING);
        delay(1000);
        detachInterrupt(digitalPinToInterrupt(listFluxo[4]->pino));
      }
}
float DawalFluxo::getVazao(){
  this->vazao = this-> contaPulso*6.66667; //Converte para ml
  return (this->vazao);
}
int DawalFluxo::getId(){
  return this->id;
}

//Função para calcular o RPM
int DawalFluxo::getWindRPM()
{
  this->RPM=((this-> contaPulso)*60)/(period/1000);  // Calculate revolutions per minute (RPM)
  return this->RPM;

}


//Velocidade do vento em m/s
float DawalFluxo::getWindMS()
{
  this->windspeed = ((4 * this->pi * this->radius * RPM)/60) / 1000;  //Calcula a velocidade do vento em m/s
  return this->windspeed;

} //end WindSpeed


//Velocidade do vento em km/h
float DawalFluxo::getWindKMH()
{
  this->speedwind = (((4 * this->pi * this->radius * this->RPM)/60) / 1000)*3.6;  //Calcula velocidade do vento em km/h
  return this->speedwind;

} //end SpeedWind
