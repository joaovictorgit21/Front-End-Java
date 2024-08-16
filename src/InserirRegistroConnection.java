import java.sql.*;

public class InserirRegistroConnection {
    public static String cadastrar(String db, String tbl, String campo1, String campo2, String campo3, String nome, String email, String senha) {
        String retorno = "Nada aconteceu ainda...";
        try {
            Connection connection = MySQLConnector.connection();
            String strSqlInsereRegistro = "INSERT INTO `" + db + "`.`" + tbl + "` (`" + campo1 + "`, `" + campo2 + "`, `" + campo3 + "`)  VALUES ('" + nome + "', '" + email + "', '" + senha + "');";
            Statement stmSqlInsereRegistro = connection.createStatement(); 

            stmSqlInsereRegistro.addBatch(strSqlInsereRegistro);
            stmSqlInsereRegistro.executeBatch();
            stmSqlInsereRegistro.close();

            retorno = "Registro inserido com sucesso";
            System.out.println(retorno);
            
        } catch (Exception e) {
            retorno = "Opsss!! Ocorreu um erro"+ e;
            System.out.println(retorno);
        }
        return retorno;
    }
}
