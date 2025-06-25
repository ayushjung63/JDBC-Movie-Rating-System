import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.Scanner;

public class JdbcMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice;
        MovieService movieService=new MovieService();

        do {
            printMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.println("Selected: Add a Movie");
                    // take movie from users using command line
                    Movie movie=new Movie("Tare Zammen Par","Drama",9,false);
                    movieService.saveMovie(movie);
                    break;
                case "2":
                    System.out.println("Selected: Show all Movies");
                    movieService.fetchAllMovies();
                    break;
                case "3":
                    System.out.println("Selected: Update Movie");
                    // take id and rating from user using command line scanner
                    int id=5;
                    int rating=10;
                    movieService.updateRating(id,rating);
                    break;
                case "4":
                    System.out.println("Selected: Delete Movie");
                    int movieToDeleteId=3;
                    movieService.deleteRating(movieToDeleteId);
                    break;
                case "q":
                case "Q":
                    System.out.println("Exiting the application...");
                    break;
                default:
                    System.out.println("Invalid choice! Please select from the menu.");
            }

            System.out.println(); // Print a blank line after each operation

        } while (!choice.equalsIgnoreCase("q"));

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("==== Movie Management ====");
        System.out.println("1. Add Movie");
        System.out.println("2. View All Movies");
        System.out.println("3. Update Movie Rating");
        System.out.println("4. Delete Movie");
        System.out.println("Press 'q' to Exit");
    }

//    public void fetchAllMovies() {
//        // Database connection info
//        String url = "jdbc:postgresql://localhost:5432/movie_db";
//        String user = "postgres";
//        String password = "postgres";
//
//        String query = "SELECT id, name, genre, rating, watched_status FROM movie";
//
//        try (
//                Connection conn = DriverManager.getConnection(url, user, password);
//                Statement stmt = conn.createStatement();
//                ResultSet rs = stmt.executeQuery(query);
//        ) {
//            System.out.println("==== Movies ====");
//            while (rs.next()) {
//                long id = rs.getLong("id");
//                String title = rs.getString("name");
//                String genre = rs.getString("genre");
//                double rating = rs.getDouble("rating");
//                boolean watched = rs.getBoolean("watched_status");
//
//                System.out.printf("ID: %d | Title: %s  | Genre: %s | Rating: %.1f | Watched: %b%n",
//                        id, title, genre, rating, watched);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

}
