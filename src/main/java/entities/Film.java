package entities;

import java.util.Date;
import java.util.List;

public class Film {

  private int id;
  private int voteCount;
  private boolean video;
  private float voteAverage;
  private String title;
  private float popularity;
  private String originalLanguage;
  private String originalTitle;
  private List<Integer> genreIds;
  private boolean adult;
  private String overview;
  private Date releaseDate;

  public Film(
    int id, int voteCount, boolean video, float voteAverage, String title, float popularity,
    String originalLanguage, String originalTitle, List<Integer> genreIds, boolean adult, String overview,
    Date releaseDate) {
    this.id = id;
    this.voteCount = voteCount;
    this.video = video;
    this.voteAverage = voteAverage;
    this.title = title;
    this.popularity = popularity;
    this.originalLanguage = originalLanguage;
    this.originalTitle = originalTitle;
    this.genreIds = genreIds;
    this.adult = adult;
    this.overview = overview;
    this.releaseDate = releaseDate;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getVoteCount() {
    return voteCount;
  }

  public void setVoteCount(int voteCount) {
    this.voteCount = voteCount;
  }

  public boolean isVideo() {
    return video;
  }

  public void setVideo(boolean video) {
    this.video = video;
  }

  public float getVoteAverage() {
    return voteAverage;
  }

  public void setVoteAverage(float voteAverage) {
    this.voteAverage = voteAverage;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public float getPopularity() {
    return popularity;
  }

  public void setPopularity(float popularity) {
    this.popularity = popularity;
  }

  public String getOriginalLanguage() {
    return originalLanguage;
  }

  public void setOriginalLanguage(String originalLanguage) {
    this.originalLanguage = originalLanguage;
  }

  public String getOriginalTitle() {
    return originalTitle;
  }

  public void setOriginalTitle(String originalTitle) {
    this.originalTitle = originalTitle;
  }

  public List<Integer> getGenreIds() {
    return genreIds;
  }

  public void setGenreIds(List<Integer> genreIds) {
    this.genreIds = genreIds;
  }

  public boolean isAdult() {
    return adult;
  }

  public void setAdult(boolean adult) {
    this.adult = adult;
  }

  public String getOverview() {
    return overview;
  }

  public void setOverview(String overview) {
    this.overview = overview;
  }

  public Date getReleaseDate() {
    return releaseDate;
  }

  public void setReleaseDate(Date releaseDate) {
    this.releaseDate = releaseDate;
  }

}
