#include <Arduino.h>
#include <ESP8266WiFi.h>
#include <ESP8266HTTPClient.h>
#include <ArduinoJson.h>

#define DUE Serial

String BASE_URL;
String SSID;
String PASSWORD;

boolean isConectado;
String msgDUE;

WiFiClient client;
HTTPClient http;

String httpRequest(String BASE_URL, String msgDUE)
{
  http.begin(client, BASE_URL);
  http.addHeader("Content-Type", "application/json");
  DUE.println("request POST  " + BASE_URL);
  int httpCode = http.POST(msgDUE);

  if (httpCode < 0)
  {
    DUE.println("request error - " + httpCode);
    return "";
  }
  if (httpCode != HTTP_CODE_OK)
  {
    return "";
  }
  String response = http.getString();
  http.end();

  DUE.println("resposta: " + response);
  return response;
}

void initWiFi(String SSID, String PASSWORD)
{

  delay(10);
  DUE.println("Conectando-se em: " + String(SSID));

  WiFi.begin(SSID, PASSWORD);
  while (WiFi.status() != WL_CONNECTED)
  {
    delay(100);
    DUE.print(".");
  }
  DUE.print("Conectado na Rede " + String(SSID) + " | IP => ");
  DUE.println(WiFi.localIP());
}

void conectandoWIFI(String dadosWifi)
{
  DUE.println(dadosWifi);
  DynamicJsonBuffer jb;
  JsonObject &obj = jb.parseObject(dadosWifi);
  
  if (!obj.success())
    return;
  
  if (!isConectado)
  {

    String SSIDOb = obj["SSID"];
    String PASSWORDOb = obj["PASSWORD"];
    String BASE_URLOb = obj["BASE_URL"];

    SSID = SSIDOb;
    PASSWORD = PASSWORDOb;
    BASE_URL = BASE_URLOb;

    DUE.println("SSID: " + SSID);
    DUE.println("PASSWORD: " + PASSWORD);
    DUE.println("BASE_URL: " + BASE_URL);
    isConectado = true;

    initWiFi(SSID, PASSWORD);
    delay(5000);
  }
}

// ############## SETUP ################# //
void setup()
{
  DUE.begin(9600);
  BASE_URL = NULL;
  msgDUE = NULL;
  isConectado = false;
}

// ############### LOOP ################# //
void loop()
{

  if (DUE.available()) // check if the esp is sending a message
  {
    DUE.println("Recebido:");
    // Efetua a leitura da mensagem vinda do ESP8266
    msgDUE = DUE.readString();

    httpRequest(BASE_URL, msgDUE);
    delay(1000);

    if (msgDUE.indexOf("SSID") != -1)
    {
      conectandoWIFI(msgDUE);
    }
  }
}