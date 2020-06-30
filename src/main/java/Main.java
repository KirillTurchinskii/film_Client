import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class Main {

  public static void main(String[] args) throws Exception {
    /////////
//    String httpsURL =
//      "https://easy.test-assignment-a.loyaltyplant.net/3/genre/movie/list?api_key=72b56103e43843412a992a8d64bf96e9";
//    URL myUrl = new URL(httpsURL);
//    HttpsURLConnection conn = (HttpsURLConnection)myUrl.openConnection();
//    InputStream is = conn.getInputStream();
//    InputStreamReader isr = new InputStreamReader(is);
//    BufferedReader br = new BufferedReader(isr);
//
//    String inputLine;
//
//    while ((inputLine = br.readLine()) != null) {
//      System.out.println(inputLine);
//    }
//
//    br.close();

    ////////////

    String uri =
      "https://easy.test-assignment-a.loyaltyplant.net/3/genre/movie/list?api_key=72b56103e43843412a992a8d64bf96e9";

    URL url = new URL(uri);
    HttpsURLConnection connection =
      (HttpsURLConnection) url.openConnection();
    connection.setRequestMethod("GET");
    connection.setRequestProperty("Accept", "application/xml");

    InputStream is = connection.getInputStream();
    InputStreamReader isr = new InputStreamReader(is);
    BufferedReader br = new BufferedReader(isr);

    String inputLine;

    while ((inputLine = br.readLine()) != null) {
      System.out.println(inputLine);
    }
    //////////
  }

}
