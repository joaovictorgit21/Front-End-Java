import java.sql.*;

public class CriarTBL {
    public static void main(String[] args) {
        try {
            Connection connection = MySQLConnector.connection();
            String strSqlCriarTBL = "create table `db_teste`.`tbl_teste` (`id` INT NOT NULL AUTO_INCREMENT, `name` VARCHAR(255) NOT NULL, `email` VARCHAR(255) NOT NULL, `senha` VARCHAR(255) NOT NULL, PRIMARY KEY(`id`));";
            Statement stmSqlCriarTBL = connection.createStatement();

            stmSqlCriarTBL.addBatch(strSqlCriarTBL);
            stmSqlCriarTBL.executeBatch();
            stmSqlCriarTBL.close();

            System.out.println("Tabela criada com sucesso!!");
        } catch (Exception e) {
            System.out.println("Opsss!! Ocorreu um erro"+ e);
        }
    }
}
