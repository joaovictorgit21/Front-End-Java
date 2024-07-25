import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.*;

// import java.awt.event.*;
import javax.swing.*;

public class MostrarCadastro extends JFrame {
    private final JTextField idJTextField = new JTextField();
    private final JTextField nomeJTextField = new JTextField();
    private final JTextField emailJTextField = new JTextField();
    private final JTextField senhalJTextField = new JTextField();
    private final JButton updateJButton = new JButton("^");
    private final JButton nextJButton = new JButton(">");
    private final JButton preveusJButton = new JButton("<");
    private final JButton firstJButton = new JButton("<<");
    private final JButton lastJButton = new JButton(">>");
    private final JLabel idJLabel = new JLabel("Id:");
    private final JLabel nomeJLabel = new JLabel("Digite um nome:");
    private final JLabel emailJLabel = new JLabel("Digite um email:");
    private final JLabel senhaJLabel = new JLabel("Digite uma senha:");
    private final JLabel notificacaoJLabel = new JLabel("Notificações...");
    private final JLabel espacadorLabel = new JLabel("");
    private final JLabel espacador2Label = new JLabel("");
    private final JLabel espacador3Label = new JLabel("");
    private final JLabel espacador4Label = new JLabel("");
    private final JLabel espacador5Label = new JLabel("");
    private final JLabel espacador6Label = new JLabel("");
    private final JLabel espacador7Label = new JLabel("");
    
    public MostrarCadastro()
    {
        super("Cadastrar");
        setLayout(new GridLayout(6, 4, 10, 10));

        nextJButton.addActionListener(
            new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               try {
            Connection connection = MySQLConnector.connection();
            String strSqlConsultaRegistro = "SELECT * FROM `db_teste`.`tbl_teste`";
            Statement stmSqlConsultaRegistro = connection.createStatement();
            ResultSet resultado = stmSqlConsultaRegistro.executeQuery(strSqlConsultaRegistro);

            while (resultado.next()) {
                System.out.println(resultado.getString("name"));
                System.out.println(resultado.getString("email"));
                System.out.println(resultado.getString("senha"));
            }

            System.out.println("Pesquisa realizada com sucesso!!");
        } catch (Exception e) {
            System.out.println("Opsss!! Ocorreu um erro"+ e);
        }
            }
         }
        );
        
            add(idJLabel);
            add(idJTextField);
            add(updateJButton);
            add(espacadorLabel);
            idJTextField.setEditable(false);
        
            add(nomeJLabel);
            add(nomeJTextField);
            add(espacador2Label);
            add(espacador3Label);
            
            add(emailJLabel);
            add(emailJTextField);
            add(espacador4Label);
            add(espacador5Label);
            
            add(senhaJLabel);
            add(senhalJTextField);
            add(espacador6Label);
            add(espacador7Label);

            add(firstJButton);
            add(preveusJButton);
            add(nextJButton);
            add(lastJButton);

            add(notificacaoJLabel);
            
            setSize(600, 300);
            setVisible(true);

    }
    public static void main(String[] args) {
        MostrarCadastro application = new MostrarCadastro();
        application.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}