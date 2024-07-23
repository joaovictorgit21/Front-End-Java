import java.sql.*;

public class ConsultaRegistro {
    public static void main(String[] args) {
        try {
            Connection connection = MySQLConnector.connection();
            String strSqlConsultaRegistro = "SELECT * FROM `db_teste`.`tbl_teste` WHERE `name`='Jao'";
            Statement stmSqlConsultaRegistro = connection.createStatement();
            ResultSet resultado = stmSqlConsultaRegistro.executeQuery(strSqlConsultaRegistro);

            while (resultado.next()) {
                System.out.println(resultado.getString("name"));
            }

            System.out.println("Pesquisa realizada com sucesso!!");
        } catch (Exception e) {
            System.out.println("Opsss!! Ocorreu um erro"+ e);
        }
    }
}
