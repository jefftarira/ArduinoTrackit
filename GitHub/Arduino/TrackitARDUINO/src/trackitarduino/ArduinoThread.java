package trackitarduino;

public class ArduinoThread extends Thread {
  
  private String port;
  private String lugar;
  
  public ArduinoThread(String port, String lugar){
    this.setPort(port);
    this.setLugar(lugar);
  }
  
  @Override
  public void run() {
    Arduino ard = new Arduino(getPort(), getLugar());
    ard.initialize();
  } 
  
  
  public String getPort() {
    return port;
  }
  
  public void setPort(String port) {
    this.port = port;
  }

  public String getLugar() {
    return lugar;
  }

  public void setLugar(String lugar) {
    this.lugar = lugar;
  }

}
