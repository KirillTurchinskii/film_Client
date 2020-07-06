import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonParser {

  public static HashMap<Integer, String> parseGenes(String json) {
    JSONObject obj = new JSONObject(json);
    HashMap<Integer, String> genres = new HashMap<Integer, String>();
    int genreId;
    String genreName;

    JSONArray arr = obj.getJSONArray("genres");
    for (int i = 0; i < arr.length(); i++) {
      genreId = arr.getJSONObject(i).getInt("id");
      genreName = arr.getJSONObject(i).getString("name");
      System.out.println("id: " + genreId + " name: " + genreName);
      genres.put(genreId, genreName);
    }

    return genres;
  }

  public static JSONArray getFilmsArray(String json) {
    JSONObject obj = new JSONObject(json);
    return obj.getJSONArray("results");
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


