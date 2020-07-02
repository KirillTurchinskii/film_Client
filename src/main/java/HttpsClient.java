import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class HttpsClient {

  public String getContent(String urlString) {
    URL url;
    String input = "";
    try {

      url = new URL(urlString);
      HttpsURLConnection con = (HttpsURLConnection)url.openConnection();

      if (con != null) {
        try {
          BufferedReader br =
            new BufferedReader(
              new InputStreamReader(con.getInputStream()));

          input = br.readLine();
//        while ((input = br.readLine()) != null){
//          System.out.println(input);
//        }
          br.close();

        } catch (IOException e) {
          e.printStackTrace();
        }
      }

    } catch (IOException e) {
      e.printStackTrace();
    }

    return input;
  }

}