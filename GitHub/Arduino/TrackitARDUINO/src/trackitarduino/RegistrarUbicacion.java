package trackitarduino;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.StringTokenizer;
import org.json.JSONException;
import org.json.JSONObject;

public class RegistrarUbicacion {

  public String enviarUbicacion(String lugar, String codigo) throws JSONException, UnsupportedEncodingException, MalformedURLException, IOException {
    String respuesta = "";
    String dispositivo = "";

    StringTokenizer st = new StringTokenizer(codigo);
    while (st.hasMoreTokens()) {
      dispositivo += st.nextToken().trim();
    }

    JSONObject jsonD = new JSONObject();
    jsonD.put("lugar", lugar);
    jsonD.put("codigo", dispositivo);
    String userAgent = "Mozilla/5.0 (X11; Linux x86_64; rv:26.0) Gecko/20100101 Firefox/26.0";
    String address = "http://localhost:8084/control/service_jsp/guardarUbicacion.jsp";
    String charset = "UTF-8";
    
    String stringToSend = URLEncoder.encode(jsonD.toString(), charset);

    URL URL = new URL(address);
    URLConnection connection = URL.openConnection();
    connection.addRequestProperty("User-Agent", userAgent);
    connection.setDoOutput(true);
    OutputStreamWriter out = new OutputStreamWriter(
            connection.getOutputStream());
    out.write(jsonD.toString());
    out.close();
    BufferedReader in = new BufferedReader(
            new InputStreamReader(
                    connection.getInputStream()));
    String response;
    while ((response = in.readLine()) != null) {
      respuesta += response;
    }
    
    in.close();   
    
    return respuesta;
  }

}
