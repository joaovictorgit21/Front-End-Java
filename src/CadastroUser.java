import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class CadastroUser extends JFrame{

    private final JLabel JLabelEmail = new JLabel("Email", SwingConstants.CENTER);
    private final JTextField JTextFieldEmail = new JTextField();
    private final JLabel JLabelUser = new JLabel("Usuario", SwingConstants.CENTER);
    private final JTextField JTextFieldUser = new JTextField();
    private final JLabel JLabelPass = new JLabel("Senha", SwingConstants.CENTER);
    private final JPasswordField JPasswordFieldPass = new JPasswordField();
    private final JButton JButtonCadastrar = new JButton("Cadastrar");
    private final JButton JButtonEnterUser = new JButton("Logar >");
    private final JCheckBox JCheckBoxTerms = new JCheckBox("Aceite os Termos");
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
    private final JLabel espacador10 = new JLabel("");

    private final String dbPadrao = "db_teste";
    private final String tblPadrao = "tbl_teste";

    // private final JLabel    JLabelTerms = new JLabel("Aceite os Termos");

    public CadastroUser() {
        super("Tela de Cadastro");
        setLayout(new GridLayout(13, 1, 5, 5));

        JPanel line0 =  new JPanel(new GridLayout(1, 1, 10, 10));
        JPanel line1 =  new JPanel(new GridLayout(1, 1, 10, 10));
        JPanel line2 =  new JPanel(new GridLayout(1, 3, 10, 10));
        JPanel line3 =  new JPanel(new GridLayout(1, 1, 10, 10));
        JPanel line4 =  new JPanel(new GridLayout(1, 1, 10, 10));
        JPanel line5 =  new JPanel(new GridLayout(1, 2, 10, 10));
        JPanel line6 =  new JPanel(new GridLayout(1, 1, 10, 10));
        JPanel line7 =  new JPanel(new GridLayout(1, 3, 10, 10));
        JPanel line8 =  new JPanel(new GridLayout(1, 1, 10, 10));
        JPanel line9 =  new JPanel(new GridLayout(1, 3, 10, 10));
        JPanel line10 = new JPanel(new GridLayout(1, 1, 10, 10));
        JPanel line11 = new JPanel(new GridLayout(1, 1, 10, 10));
        JPanel line12 = new JPanel(new GridLayout(1, 1, 10, 10));

        //--------------------------------------------------- Events ---------------------------------------------------//

        JButtonCadastrar.addActionListener(
            new ActionListener()
            {
                public void actionPerformed(ActionEvent event)
                {

                    JTextFieldUser.requestFocus();
                    
                    String name = JTextFieldUser.getText();
                    String email = JTextFieldEmail.getText();
                    String password = JPasswordFieldPass.getPassword().toString();

                    if (JCheckBoxTerms.isSelected()) {
                        try {
                            Connection connection = MySQLConnector.connection();
                            String strSqlsearchEmail = "select email FROM `" + dbPadrao + "`.`" + tblPadrao + "` where `email` = '" + email + "' order by `id` asc";
                            Statement stmSqlsearchEmail = connection.createStatement();
                            ResultSet rstSearchEmail = stmSqlsearchEmail.executeQuery(strSqlsearchEmail);


                            if (rstSearchEmail.next()) {
                                JLabelNotification.setText("Email já cadastrado");
                                System.out.println("Email já cadastrado");
                            } else {
                                NavegadorDeRegistro.newResgister(dbPadrao, tblPadrao, "name", "email", "password", name, email, password);
                                JLabelNotification.setText("Cadastro realizado com sucesso");
                            }

                            stmSqlsearchEmail.close();
                            connection.close();
                        } catch (Exception e) {
                            JLabelNotification.setText("Digite alguma coisa:");
                        }
                    } else {
                        JLabelNotification.setText("Você deve aceitar os Termos");
                    }
                }
            });

            JButtonEnterUser.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        LoginUser appLogin = new LoginUser();
                        appLogin.setDefaultCloseOperation(EXIT_ON_CLOSE);
                    } 
                }
            );

        //--------------------------------------------------------------------------------------------------------------//
        
        //----------------------------------------------- Insert Elements ----------------------------------------------//
        
        add(line0);
        line0.add(espacador);

        add(line1);
        line1.add(JLabelUser);

        add(line2);
        line2.add(espacador2);
        line2.add(JTextFieldUser);
        line2.add(espacador3);
        
        add(line3);
        line3.add(espacador4);
        
        add(line4);
        line4.add(JLabelEmail);
        
        add(line5);
        line5.add(espacador5);
        line5.add(JTextFieldEmail);
        line5.add(espacador6);
        
        add(line6);
        line6.add(espacador7);
        
        add(line7);
        line7.add(JLabelPass);
        
        add(line8);
        line8.add(espacador8);
        line8.add(JPasswordFieldPass);
        line8.add(espacador9);
        
        add(line9);
        line9.add(espacador4);
        
        add(line10);
        line10.add(espacador10);
        line10.add(JButtonCadastrar);
        line10.add(JButtonEnterUser);
        
        add(line11);
        line11.add(JCheckBoxTerms);

        add(line12);
        line12.add(JLabelNotification);

        setSize(550, 600);
        setVisible(true);

        //----------------------------------------------    ----------------------------------------------------------------//

    }

    public static void main(String[] args) {
        CadastroUser appcadastro = new CadastroUser();
        appcadastro.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
