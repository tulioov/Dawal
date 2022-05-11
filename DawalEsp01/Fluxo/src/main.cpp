#include <Arduino.h>
#include <ESP8266WiFi.h>
#include <ESP8266HTTPClient.h>

const char *SSID = "SystemCall";
const char *PASSWORD = "SAV1949sav";

String BASE_URL = "http://192.168.0.65:8080";

WiFiClient client;
HTTPClient http;

const int InterruptPIN = 2;
void IRAM_ATTR contadorPulsoFn();

unsigned long contador = 0;
const float FATOR_CALIBRACAO = 4.5;

float fluxo = 0;
float volume = 0;
float volume_total = 0;
unsigned long tempo_antes = 0;

String httpRequest(String path)
{
  http.begin(client, BASE_URL + path);
  int httpCode = http.POST(path);

  if (httpCode < 0)
  {
    Serial.println("request error - " + httpCode);
    return "";
  }
  if (httpCode != HTTP_CODE_OK)
  {
    return "";
  }
  String response = http.getString();
  http.end();

  Serial.println("resposta: " + response);
  return response;
}

void initWiFi()
{

  delay(10);
  Serial.println("Conectando-se em: " + String(SSID));

  WiFi.begin(SSID, PASSWORD);
  while (WiFi.status() != WL_CONNECTED)
  {
    delay(100);
    Serial.print(".");
  }
  Serial.println();
  Serial.print("Conectado na Rede " + String(SSID) + " | IP => ");
  Serial.println(WiFi.localIP());
}

void contadorPulsoFn()
{
  contador++;
}
// ############## SETUP ################# //
void setup()
{
  Serial.begin(9600);
  initWiFi();
  pinMode(InterruptPIN, INPUT_PULLUP);
}

// ############### LOOP ################# //
void loop()
{
  if ((millis() - tempo_antes) > 1000)
  {
    detachInterrupt(digitalPinToInterrupt(InterruptPIN));

    // conversao do valor de pulsos para L/min
    fluxo = ((1000.0 / (millis() - tempo_antes)) * contador) / FATOR_CALIBRACAO;

    httpRequest("/fluxo1/" + String(fluxo));

    contador = 0;

    tempo_antes = millis();
    attachInterrupt(digitalPinToInterrupt(InterruptPIN), contadorPulsoFn, CHANGE);
  }
}