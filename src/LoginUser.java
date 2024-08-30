import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
// import java.awt.event;

public class LoginUser extends JFrame{

    private final JLabel JLabelUser = new JLabel("Usuario", SwingConstants.CENTER);
    private final JTextField JTextFieldUser = new JTextField();
    private final JLabel JLabelPass = new JLabel("Senha", SwingConstants.CENTER);
    private final JPasswordField JPasswordFieldPass = new JPasswordField();
    private final JButton JButtonLogin = new JButton("Entar");
    private final JButton JButtonNewUser = new JButton("Cadastrar >");
    private final JLabel JLabelNotification = new JLabel("Notificações...", SwingConstants.CENTER);

    private final JLabel espacador = new JLabel("");
    private final JLabel espacador2 = new JLabel("");
    private final JLabel espacador3 = new JLabel("");
    private final JLabel espacador4 = new JLabel("");
    private final JLabel espacador5 = new JLabel("");
    private final JLabel espacador6 = new JLabel("");
    private final JLabel espacador7 = new JLabel("");
    private final JLabel espacador8 = new JLabel("");
    private final JLabel espacador9 = new JLabel("");

    private final String dbPadrao = "db_teste";
    private final String tblPadrao = "tbl_teste";

    // private final JLabel    JLabelTerms = new JLabel("Aceite os Termos");

    public LoginUser() {
        super("Tela de Login");
        setLayout(new GridLayout(11, 1, 5, 5));

        JPanel line0 =  new JPanel(new GridLayout(1, 1, 10, 10));
        JPanel line1 =  new JPanel(new GridLayout(1, 1, 10, 10));
        JPanel line2 =  new JPanel(new GridLayout(1, 2, 10, 10));
        JPanel line3 =  new JPanel(new GridLayout(1, 1, 10, 10));
        JPanel line4 =  new JPanel(new GridLayout(1, 1, 10, 10));
        JPanel line5 =  new JPanel(new GridLayout(1, 2, 10, 10));
        JPanel line6 =  new JPanel(new GridLayout(1, 1, 10, 10));
        JPanel line7 =  new JPanel(new GridLayout(1, 3, 10, 10));
        JPanel line8 =  new JPanel(new GridLayout(1, 1, 10, 10));
        JPanel line10 = new JPanel(new GridLayout(1, 1, 10, 10));

        JButtonLogin.addActionListener(
            new ActionListener() {
                String user = JTextFieldUser.getText();
                String pass = JPasswordFieldPass.getPassword().toString();
                public void actionPerformed(ActionEvent event) {
                    try {
                        Connection connection = MySQLConnector.connection();
                        String strSqlsearchUser = "SELECT * FROM `" + dbPadrao + "`.`" + tblPadrao + "` where `name` = '" + user + "' AND `password` = '" + pass + "' ";
                        
                        PreparedStatement stmSqlsearchUser = connection.prepareStatement(strSqlsearchUser);
                        stmSqlsearchUser.setString(1, user);
                        stmSqlsearchUser.setString(2, pass);

                        ResultSet rstPesquisarUser = stmSqlsearchUser.executeQuery();

                        if (rstPesquisarUser.next()) {
                            MostrarCadastro mostrarCadastro = new MostrarCadastro();
                            mostrarCadastro.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                            mostrarCadastro.setVisible(true);
                            JLabelNotification.setText("Login bem-sucedido!");
                        } else {
                            JLabelNotification.setText("Usuário ou senha incorretos.");
                        }
    
                        stmSqlsearchUser.close();
                        connection.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JLabelNotification.setText("Ocorreu um erro ao logar. Por favor, tente novamente.");
                    }
                }
            }
        );

        JButtonNewUser.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        CadastroUser appcadastro = new CadastroUser();
                        appcadastro.setDefaultCloseOperation(EXIT_ON_CLOSE);
                    } 
                }
            );

        add(line0);
        line0.add(espacador);

        add(line1);
        line1.add(JLabelUser);
        
        add(line2);
        line2.add(espacador5);
        line2.add(JTextFieldUser);
        line2.add(espacador6);
        
        add(line3);
        line3.add(espacador2);
        
        add(line4);
        line4.add(JLabelPass);
        
        add(line5);
        line5.add(espacador7);
        line5.add(JPasswordFieldPass);
        line5.add(espacador8);
        
        add(line6);
        line6.add(espacador3);
        
        add(line7);
        line7.add(espacador9);
        line7.add(JButtonLogin);
        line7.add(JButtonNewUser);
        
        add(line8);
        line8.add(espacador4);
        
        add(line10);
        line10.add(JLabelNotification);

        setSize(600, 600);
        setVisible(true);
    }

    public static void main(String[] args) {
        LoginUser appLogin = new LoginUser();
        appLogin.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
