import java.util.HashMap;

import org.json.JSONArray;

import utils.InputReaderUtils;

public class Statistics extends Thread {

  static final String key = "72b56103e43843412a992a8d64bf96e9";

  @Override public void run() {
    int pageNumber = 1;
    String genresURL = "https://easy.test-assignment-a.loyaltyplant.net/3/genre/movie/list?api_key=" + key;
    String filmUrlWithoutPageNum = "https://easy.test-assignment-a.loyaltyplant.net/3/discover/movie?api_key=" + key +
                                   "&page=";

    HttpsClient httpsClient = new HttpsClient();
    String input = httpsClient.getContent(genresURL);
    HashMap<Integer, String> genres = JsonParser.parseGenes(input);
    input = httpsClient.getContent(filmUrlWithoutPageNum + pageNumber);
    int totalPages = JsonParser.getTotalPagesNumber(input);
    int count = 0;
    System.out.println("Input genre ID");
    int genreId = InputReaderUtils.nextInt();
    // notify();

    if (!genres.containsKey(genreId)) {
      System.out.println("Wrong ID");
      return;
    }
    JSONArray films;
    float averageSum = 0;
    int countWithoutZeros = 0;
    float averageSumWithoutZeros = 0;
    Data.isParsing = true;
    Interrupter interrupter = new Interrupter();
    interrupter.start();
    while (pageNumber < totalPages && !Data.isKeyPressed) {
      System.out.println("Processed pages: " + pageNumber + "/" + totalPages);
      input = httpsClient.getContent(filmUrlWithoutPageNum + pageNumber);
      films = JsonParser.getFilmsArray(input);
      for (int i = 0; i < films.length(); i++) {
        float voteAverage;
        voteAverage = films.getJSONObject(i).getFloat("vote_average");
        JSONArray genreIds = films.getJSONObject(i).getJSONArray("genre_ids");
        if (JsonParser.isJSONArrayContains(genreIds, genreId)) {
          averageSum += voteAverage;
          if (voteAverage != 0.0) {
            averageSumWithoutZeros += voteAverage;
            countWithoutZeros++;
          }
          count++;
        }

      }
      pageNumber++;
    }
    Data.isParsing = false;
    interrupter.interrupt();
    System.out.println("average= " + averageSum / count);
    System.out.println("average without zeros = " + averageSumWithoutZeros / countWithoutZeros);
  }

}
