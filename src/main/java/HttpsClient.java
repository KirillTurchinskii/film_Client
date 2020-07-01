import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.cert.Certificate;

import javax.net.ssl.HttpsURLConnection;

public class HttpsClient {

  static final String key = "72b56103e43843412a992a8d64bf96e9";

  public static void main(String[] args) {
    new HttpsClient().testIt();
  }

  private void testIt() {

    String https_url =
      //"https://easy.test-assignment-a.loyaltyplant.net/3/genre/movie/list?api_key="+key;
      "https://easy.test-assignment-a.loyaltyplant.net/3/discover/movie?api_key=" + key + "&page" +
      "=20";
    URL url;
    try {

      url = new URL(https_url);
      HttpsURLConnection con = (HttpsURLConnection)url.openConnection();

      //dumpl all cert info
      print_https_cert(con);

      //dump all the content
      print_content(con);

    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  private void print_https_cert(HttpsURLConnection con) {

    if (con != null) {

      try {

        System.out.println("Response Code : " + con.getResponseCode());
        System.out.println("Cipher Suite : " + con.getCipherSuite());
        System.out.println("\n");

        Certificate[] certs = con.getServerCertificates();
        for (Certificate cert : certs) {
          System.out.println("Cert Type : " + cert.getType());
          System.out.println("Cert Hash Code : " + cert.hashCode());
          System.out.println("Cert Public Key Algorithm : "
                             + cert.getPublicKey().getAlgorithm());
          System.out.println("Cert Public Key Format : "
                             + cert.getPublicKey().getFormat());
          System.out.println("\n");
        }

      } catch (IOException e) {
        e.printStackTrace();
      }

    }

  }

  private void print_content(HttpsURLConnection con) {
    String input;
    if (con != null) {

      try {

        System.out.println("****** Content of the URL ********");
        BufferedReader br =
          new BufferedReader(
            new InputStreamReader(con.getInputStream()));

        input = br.readLine();
//        while ((input = br.readLine()) != null){
//          System.out.println(input);
//        }
        br.close();
        //JsonParser.parseGenes(input);
        JsonParser.parseFilms(input);
      } catch (IOException e) {
        e.printStackTrace();
      }

    }

  }

}