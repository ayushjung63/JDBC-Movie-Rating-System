public class Movie {
    private Integer id;
    private String name;
    private String genre;
    private int rating;
    private boolean watchedStatus;

    public Movie(){}

    public Movie(String name, String genre, int rating, boolean watchedStatus) {
        this.name = name;
        this.genre = genre;
        this.rating = rating;
        this.watchedStatus = watchedStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean isWatchedStatus() {
        return watchedStatus;
    }

    public void setWatchedStatus(boolean watchedStatus) {
        this.watchedStatus = watchedStatus;
    }
}
