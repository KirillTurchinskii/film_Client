import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;

import org.json.JSONArray;
import org.json.JSONObject;

import entities.Film;

public class JsonParser {

  public static HashMap<Integer, String> parseGenes(String json) {
    JSONObject obj = new JSONObject(json);
    HashMap<Integer, String> genres = new HashMap<Integer, String>();
    int genreId;// = obj.getJSONObject("genres").getInt("id");
    String genreName;// = obj.getJSONObject("genres").getString("name");

//    System.out.println(genreId);
//    System.out.println(genreName);

    JSONArray arr = obj.getJSONArray("genres");
    for (int i = 0; i < arr.length(); i++) {
      genreId = arr.getJSONObject(i).getInt("id");
      genreName = arr.getJSONObject(i).getString("name");
      System.out.println("id: " + genreId + " name: " + genreName);
      // genres.add(new Genre(genreId, genreName));
      genres.put(genreId, genreName);
    }

    return genres;
  }

  public static JSONArray getFilmsArray(String json) {
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

    float averageSum = 0;

    return obj.getJSONArray("results");
//    for (int i = 0; i < arr.length(); i++) {
//      id = arr.getJSONObject(i).getInt("id");
//      title = arr.getJSONObject(i).getString("title");
//      voteAverage = arr.getJSONObject(i).getFloat("vote_average");
//      genreIds = arr.getJSONObject(i).getJSONArray("genre_ids");
//      if (isJSONArrayContains(arr,genreId)){
//        averageSum +=voteAverage;
//      }
//      //System.out.println("id: " + id + " title: " + title + " voteAvarage: " + voteAverage + " genreIds: " +
//      // genreIds);
//      {
//        count++;
//      }
//      //genres.add(new Genre(genreId,genreName));
//    }
//
//    return count;
  }

  public static int getCurrentPageNumber(String json) {
    JSONObject obj = new JSONObject(json);
    return obj.getInt("page");
  }

  public static int getTotalPagesNumber(String json) {
    JSONObject obj = new JSONObject(json);
    return obj.getInt("total_pages");
  }

  public static boolean isJSONArrayContains(JSONArray jsonArray, int idNeeded) {
    for (int i = 1; i < jsonArray.length(); i++) {
      int id = jsonArray.getInt(i);
      if (id == idNeeded) {
        return true;
      }
    }
    return false;
  }

}


