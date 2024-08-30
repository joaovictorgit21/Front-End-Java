import java.sql.*;

public class MySQLConnector {
    public static Connection connection() {
        String status = "Nada aconteceu ainda...";
        String mysqlHost = "localhost";
        String mysqlDb = "db_mysql_connector";
        String mysqlUser = "root";
        String mysqlPassword = "123456";
        String mysqlPort = "3306";
        String mysqlUrl = "jdbc:mysql://" + mysqlHost + ":" + mysqlPort + "/" + mysqlDb + "?user=" + mysqlUser + "&password=" + mysqlPassword;

        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(mysqlUrl);
            status = "Conexão realizada com Sucesso!!";
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            status = "Opeesssss!!! Algo de errado não está certo com a conexão com o banco de dados MySQL!! Mensagem do servidor: " + e;
        }

        System.out.println(status);
        return conn;
    }
}
