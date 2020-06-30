import java.util.LinkedList;

import org.json.JSONArray;
import org.json.JSONObject;

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
      System.out.println("id: "+genreId + " name: "  + genreName);
      genres.add(new Genre(genreId,genreName));
    }

    return genres;
  }

  public static void parseFilms() {

  }

}


