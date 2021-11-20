#include "DawalProtocolo.h"
#include <string.h>

String DawalProtocolo::protocol = "";

String DawalProtocolo::getProtocol(){
  return protocol;
}


void DawalProtocolo::setProtocol(String protocolo){
      protocol = protocol + protocolo;
}

void DawalProtocolo::limparProtocol(){
    protocol = "";
}
