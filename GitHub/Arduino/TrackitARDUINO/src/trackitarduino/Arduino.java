package trackitarduino;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Enumeration;
import org.json.JSONObject;

public class Arduino implements SerialPortEventListener {

  private String puerto;
  private String lugar;
  SerialPort serialPort;
  private BufferedReader input;
  private OutputStream output;
  private static final int TIME_OUT = 2000;
  private static final int DATA_RATE = 9600;

  public Arduino(String puerto, String lugar) {
    this.setPuerto(puerto);
    this.setLugar(lugar);
  }

  public void initialize() {

    CommPortIdentifier portId = null;
    Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();
    while (portEnum.hasMoreElements()) {
      CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();

      if (currPortId.getName().equals(getPuerto())) {
        portId = currPortId;
        break;
      }
    }

    if (portId == null) {
      System.out.println("No se encontro Arduino en el puerto " + getPuerto() + " de " + getLugar());
      return;
    }

    try {
      serialPort = (SerialPort) portId.open(this.getClass().getName(),
              TIME_OUT);

      serialPort.setSerialPortParams(DATA_RATE,
              SerialPort.DATABITS_8,
              SerialPort.STOPBITS_1,
              SerialPort.PARITY_NONE);

      // open the streams
      input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
      output = serialPort.getOutputStream();

      // add event listeners
      serialPort.addEventListener(this);
      serialPort.notifyOnDataAvailable(true);
      serialPort.notifyOnBreakInterrupt(true);
      System.out.println("Se inicio el Arduino " + getLugar() + " en el puerto " + getPuerto());
    } catch (Exception e) {
      System.err.println(e.toString());
    }
  }

  public synchronized void close() throws IOException {
    if (serialPort != null) {
      input.close();
      output.close();
      serialPort.removeEventListener();
      serialPort.close();
    }
  }

  public synchronized void serialEvent(SerialPortEvent oEvent) {

    if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
      try {
        String inputLine = input.readLine();
        System.out.println("Enviando información: " + inputLine + " de " + getLugar());

        RegistrarUbicacion ru = new RegistrarUbicacion();
        String respuesta = ru.enviarUbicacion(getLugar(), inputLine);
        
        JSONObject jObj = new JSONObject(respuesta);
        boolean error = jObj.getBoolean("err");
        String mensaje = jObj.getString("mensaje").trim();
        
        System.out.println("Respuesta Obtenida: " + mensaje);

      } catch (Exception e) {
        System.err.println(e.toString());
      }
    }
  }

  public String getPuerto() {
    return puerto;
  }

  public void setPuerto(String puerto) {
    this.puerto = puerto;
  }

  public String getLugar() {
    return lugar;
  }

  public void setLugar(String lugar) {
    this.lugar = lugar;
  }

}
