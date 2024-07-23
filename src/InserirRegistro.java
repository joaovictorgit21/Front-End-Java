import java.sql.*;

public class InserirRegistro {
    public static void main(String[] args) {
        try {
            Connection connection = MySQLConnector.connection();
            String strSqlInsereRegistro = "INSERT INTO `db_teste`.`tbl_teste` (`name`, `email`, `senha`) VALUES ('Isa', 'isa@isamail.isa', 'senhaIsa');";
            Statement stmSqlInsereRegistro = connection.createStatement();

            stmSqlInsereRegistro.addBatch(strSqlInsereRegistro);
            stmSqlInsereRegistro.executeBatch();
            stmSqlInsereRegistro.close();

            System.out.println("Registro criado com sucesso!!");
        } catch (Exception e) {
            System.out.println("Opsss!! Ocorreu um erro"+ e);
        }
    }
}
