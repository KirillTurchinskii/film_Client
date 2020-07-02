import java.util.HashMap;

import org.json.JSONArray;

import utils.InputReaderUtils;

public class Main {

  static final String key = "72b56103e43843412a992a8d64bf96e9";

  public static void main(String[] args) {

    int pageNumber = 1;
    String genresURL = "https://easy.test-assignment-a.loyaltyplant.net/3/genre/movie/list?api_key=" + key;
    String filmUrlWithoutPageNum = "https://easy.test-assignment-a.loyaltyplant.net/3/discover/movie?api_key=" + key +
                                   "&page=";

    HttpsClient httpsClient = new HttpsClient();
    String input = httpsClient.getContent(genresURL);
    HashMap<Integer, String> genres = JsonParser.parseGenes(input);
    System.out.println(genres);
    input = httpsClient.getContent(filmUrlWithoutPageNum + pageNumber);
    int totalPages = JsonParser.getTotalPagesNumber(input);
    int count = 0;
    System.out.println("Input genre ID");
    int genreId = InputReaderUtils.nextInt();

    // Проверять на наличие такого id
    // Если нет - вводить снова
    // Если введено не число - завершить программу

    JSONArray films;
    float averageSum = 0;
    int countWithoutZeros = 0;
    float averageSumWithoutZeros = 0;

    while (pageNumber < totalPages) {
      System.out.println(pageNumber);
      input = httpsClient.getContent(filmUrlWithoutPageNum + pageNumber);
      films = JsonParser.getFilmsArray(input);
      for (int i = 0; i < films.length(); i++) {
        int id = films.getJSONObject(i).getInt("id");
        float voteAverage;
        String title = films.getJSONObject(i).getString("title");
        voteAverage = films.getJSONObject(i).getFloat("vote_average");
        JSONArray genreIds = films.getJSONObject(i).getJSONArray("genre_ids");
        if (JsonParser.isJSONArrayContains(genreIds, genreId)) {
          System.out.println("id: " + id + " title: " + title + " voteAvarage: " + voteAverage + " genreIds: " +
                             genreIds);
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
    System.out.println("count = " + count);
    System.out.println("averageSum = " + averageSum);
    System.out.println("average= " + averageSum / count);
    System.out.println("average without zeros = " + averageSumWithoutZeros / countWithoutZeros);
    //JsonParser.getFilmsArray(input);
  }

  private float calcAverage() {
    return 0;
  }

}
