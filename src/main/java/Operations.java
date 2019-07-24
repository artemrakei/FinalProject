import java.sql.*;


public class Operations {
    private String url = "jdbc:mysql://localhost:3306/mail_ru_data?useSSL=false&serverTimezone=UTC";
    private String user = "root";
    private String password = "1234";
    private Connection connection;


    public Operations() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public Connection getConnection() {
        return connection;
    }

    public String getLogin(int number) throws SQLException {
        String query = "select login from credentials where id = ?";
        PreparedStatement statement = getConnection().prepareStatement(query);
        statement.setInt(1,number);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getString(1);
        }
        return null;
    }

    public String getPassword(int number) throws SQLException {
        String query = "select password from credentials where id = ?";
        PreparedStatement statement = getConnection().prepareStatement(query);
        statement.setInt(1,number);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getString(1);
        }
        return null;
    }
}