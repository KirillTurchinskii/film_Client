import java.util.Date;
import java.util.LinkedList;

import org.json.JSONArray;
import org.json.JSONObject;

import entities.Film;
import entities.Genre;

public class JsonParser {

  public static LinkedList<Genre> parseGenes(String json) {
    JSONObject obj = new JSONObject(json);
    LinkedList<Genre> genres = new LinkedList<Genre>();
    int genreId;// = obj.getJSONObject("genres").getInt("id");
    String genreName;// = obj.getJSONObject("genres").getString("name");

//    System.out.println(genreId);
//    System.out.println(genreName);

    JSONArray arr = obj.getJSONArray("genres");
    for (int i = 0; i < arr.length(); i++) {
      genreId = arr.getJSONObject(i).getInt("id");
      genreName = arr.getJSONObject(i).getString("name");
      System.out.println("id: " + genreId + " name: " + genreName);
      genres.add(new Genre(genreId, genreName));
    }

    return genres;
  }

  public static void parseFilms(String json) {
    JSONObject obj = new JSONObject(json);
    LinkedList<Film> genres = new LinkedList<Film>();
    int id;// = obj.getJSONObject("genres").getInt("id");
    int voteCount;
    boolean video;
    float voteAverage;
    String title;
    float popularity;
    String originalLanguage;
    String originalTitle;
    JSONArray genreIds;
    boolean adult;
    String overview;
    Date releaseDate;

    JSONArray arr = obj.getJSONArray("results");
    for (int i = 0; i < arr.length(); i++) {
      id = arr.getJSONObject(i).getInt("id");
      title = arr.getJSONObject(i).getString("title");
      voteAverage = arr.getJSONObject(i).getFloat("vote_average");
      genreIds = arr.getJSONObject(i).getJSONArray("genre_ids");
      System.out.println("id: " + id + " title: " + title + " voteAvarage: " + voteAverage + " genreIds: " + genreIds);
      //genres.add(new Genre(genreId,genreName));
    }

    //return genres;
  }

  public static int getCurrentPageNumber(String json) {
    JSONObject obj = new JSONObject(json);
    return obj.getInt("page");
  }

  public static int getTotalPagesNumber(String json) {
    JSONObject obj = new JSONObject(json);
    return obj.getInt("total_pages");
  }

}


