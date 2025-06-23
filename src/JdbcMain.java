public class JdbcMain {
    public static void main(String[] args) {
            String host = "localhost";
            String port = "5432";
            String username = "postgres";
            String password = "postgres";
            String myDatabaseName = "movie_db";

            String url="jdbc:postgresql://"+host+":"+port+"/"+myDatabaseName;

        System.out.println("Hello World");
    }
}
