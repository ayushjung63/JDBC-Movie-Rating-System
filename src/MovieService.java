import java.sql.*;

public class MovieService {
    String url = "jdbc:postgresql://localhost:5432/movie_db";
    String username="postgres";
    String password="postgres";
    String selectQuery="select * from movie";
    String insertQuery="insert into movie(name, genre, rating, watched_status) values (?,?,?,?)";
    String updateRatingQuery="update movie set rating= ? where id=?";
    String deleteQuery="delete from  movie where id=?;";

    public void fetchAllMovies(){
        try {
            Connection connection= DriverManager.getConnection(url,username,password);
            Statement statement=connection.createStatement();
            ResultSet result=statement.executeQuery(selectQuery);
            System.out.println("==== Movies ====");
            while (result.next()){ // processing single row at a time
                int id = result.getInt("id");
                String name = result.getString("name");
                String genre = result.getString("genre");
                int rating = result.getInt("rating");
                boolean watchedStatus = result.getBoolean("watched_status");
                System.out.printf("ID: %d | Name: %s  | Genre: %s | Rating: %d | Watched: %b%n",
                        id, name, genre, rating, watchedStatus);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error connecting to the database");;
        }
    }

    public void saveMovie(Movie movie){
        try {
            Connection connection= DriverManager.getConnection(url,username,password);
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1,movie.getName());
            preparedStatement.setString(2,movie.getGenre());
            preparedStatement.setInt(3,movie.getRating());
            preparedStatement.setBoolean(4,movie.isWatchedStatus());
            preparedStatement.execute();
            System.out.println("Movie Saved to database successfully");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error connecting to the database");;
        }
    }

    public void updateRating(int id,int rating){
        try {
            Connection connection= DriverManager.getConnection(url,username,password);
            PreparedStatement preparedStatement = connection.prepareStatement(updateRatingQuery);
            preparedStatement.setInt(1,rating);
            preparedStatement.setInt(2,id);
            preparedStatement.execute();
            System.out.println("Movie Rating updated successfully");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error connecting to the database");;
        }
    }

    public void deleteRating(int id){
        try {
            Connection connection= DriverManager.getConnection(url,username,password);
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1,id);
            preparedStatement.execute();
            System.out.println("Movie Deleted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error connecting to the database");;
        }
    }
}
