package trackitarduino;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.util.Enumeration;

public class Main {

  public static void main(String[] args) throws Exception {
    String puertoCasa    = "COM3";
    String puertoEscuela = "COM4";
    String puertoExpreso = "COM5";
    ArduinoThread casa      = new ArduinoThread(puertoCasa,"Casa");
    ArduinoThread escuela   = new ArduinoThread(puertoEscuela,"Escuela");
    ArduinoThread expreso   = new ArduinoThread(puertoExpreso,"Expreso");
    
    casa.start();
    escuela.start();
    expreso.start();
  }
}
