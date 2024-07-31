import java.sql.*;

public class CriarDB {
    public static void main(String[] args) {
        try {
            Connection connection = MySQLConnector.connection();
            String strSqlCriarDB = "create database `db_teste`;";
            Statement stmSqlCriarDB = connection.createStatement();

            stmSqlCriarDB.addBatch(strSqlCriarDB);
            stmSqlCriarDB.executeBatch();
            stmSqlCriarDB.close();

            System.out.println("Banco de dados criado com sucesso!!");
        } catch (Exception e) {
            System.out.println("Opsss!! Ocorreu um erro"+ e);
        }
    }
}
