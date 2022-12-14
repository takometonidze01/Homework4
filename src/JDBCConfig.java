import java.lang.ref.PhantomReference;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public final  class JDBCConfig {

    public static final String  DB_URL = "jdbc:mysql://sql7.freesqldatabase.com:3306/sql7583730";
    public static final String USER = "sql7583730";
    public static final String PASSWORD = "uUiGiZ6CaZ";

    private static Connection connection;
    private static Statement statement;

    static {
        try {
            if (connection == null) {
                connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            }
        } catch (SQLException e){
            throw  new RuntimeException(e);
        }
    }

    public static Statement getStatement() throws SQLException {
        try {
            statement = connection.createStatement();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }

        return statement;
    }


}

