import java.sql.*;

public class NavegadorDeRegistro {
    public static String[] FirstRegister(String db, String tbl) throws Exception {
        Connection connection = MySQLConnector.connection();
        String strSqlFirstRegister = "select * from `" + db + "`.`" + tbl + "` order by `id` asc limit 1;";
        Statement stmFirstRegister = connection.createStatement();
        ResultSet rstSqlFirstRegiter = stmFirstRegister.executeQuery(strSqlFirstRegister);
        rstSqlFirstRegiter.next();
        String[] result = {
            rstSqlFirstRegiter.getString("id"),
            rstSqlFirstRegiter.getString("name"),
            rstSqlFirstRegiter.getString("email"),
            rstSqlFirstRegiter.getString("senha")
        };
        stmFirstRegister.close();
        return result;
    }

    public static String[] NextRegister(String db, String tbl, String id) throws Exception {
        Connection connection = MySQLConnector.connection();
        int idPerson = Integer.parseInt(id);
        int nextID = idPerson + 1;
        if (nextID >= 1) {
                String strSqlLastRegister = "select * from `" + db + "`.`" + tbl + "` order by `id` asc;";
                Statement stmNextRegister = connection.createStatement();
                ResultSet rstSqlNextRegister = stmNextRegister.executeQuery(strSqlLastRegister);
                String[] result = {"", "", "", ""};

                while (rstSqlNextRegister.next()) {
                    if (id.equals(rstSqlNextRegister.getString("id"))) {
                        rstSqlNextRegister.next();
                        result[0] = rstSqlNextRegister.getString("id");
                        result[1] = rstSqlNextRegister.getString("name");
                        result[2] = rstSqlNextRegister.getString("email");
                        result[3] = rstSqlNextRegister.getString("senha");
                        break;
                    }
                }
                rstSqlNextRegister.close();
                if (result[0] == "") {
                    return null;
                } else {
                    return result;
                }
        } else {
            return null;
        }
    }
    
    public static String[] PreviousRegister(String db, String tbl, String id) throws Exception {
        Connection connection = MySQLConnector.connection();
        int idPerson = Integer.parseInt(id);
        int nextID = idPerson - 1;
        if (nextID >= 1) {
                String strSqlLastRegister = "select * from `" + db + "`.`" + tbl + "` order by `id` desc;";
                Statement stmNextRegister = connection.createStatement();
                ResultSet rstSqlNextRegister = stmNextRegister.executeQuery(strSqlLastRegister);
                String[] result = {"", "", "", ""};

                while (rstSqlNextRegister.next()) {
                    if (id.equals(rstSqlNextRegister.getString("id"))) {
                        rstSqlNextRegister.next();
                        result[0] = rstSqlNextRegister.getString("id");
                        result[1] = rstSqlNextRegister.getString("name");
                        result[2] = rstSqlNextRegister.getString("email");
                        result[3] = rstSqlNextRegister.getString("senha");
                        break;

                    }
                }
                rstSqlNextRegister.close();
                if (result[0] == "") {
                    return null;
                } else {
                    return result;
                }
        } else {
            return null;
        }
    }

    public static String[] LastRegister(String db, String tbl) throws Exception {
        Connection connection = MySQLConnector.connection();
        try {
            String strSqlLastRegister = "select * from `" + db + "`.`" + tbl + "` order by `id` desc limit 1;";
            Statement stmLastRegister = connection.createStatement();
            ResultSet rstSqlLastRegiter = stmLastRegister.executeQuery(strSqlLastRegister);
            rstSqlLastRegiter.next();
            String[] result = {
                rstSqlLastRegiter.getString("id"),
                rstSqlLastRegiter.getString("name"),
                rstSqlLastRegiter.getString("email"),
                rstSqlLastRegiter.getString("senha")
            };
            rstSqlLastRegiter.close();
            return result;
        } catch (Exception e) {
            return null;
        }
    }

    public static String[] DeleteRegister(String db, String tbl, String id) throws Exception {
        Connection connection = MySQLConnector.connection();
        try {
            String strSqlLastRegister = "delete from `" + db + "`.`"+ tbl + "` where (`id` = '" + id + "');";
            Statement stmLastRegister = connection.createStatement();
            ResultSet rstSqlLastRegiter = stmLastRegister.executeQuery(strSqlLastRegister);
            rstSqlLastRegiter.next();
            String[] result = {
                rstSqlLastRegiter.getString("id"),
                rstSqlLastRegiter.getString("name"),
                rstSqlLastRegiter.getString("email"),
                rstSqlLastRegiter.getString("senha")
            };
            rstSqlLastRegiter.close();
            return result;
        } catch (Exception e) {
            return null;
        }
    }
}