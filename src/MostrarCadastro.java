import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MostrarCadastro extends JFrame {
    private final JTextField idJTextField = new JTextField();
    private final JTextField nomeJTextField = new JTextField();
    private final JTextField emailJTextField = new JTextField();
    private final JTextField senhaJPasswordField = new JTextField();
    private final JButton updateJButton = new JButton("^");
    private final JButton deleteJButton = new JButton("Del");
    private final JButton nextJButton = new JButton(">");
    private final JButton previousJButton = new JButton("<");
    private final JButton firstJButton = new JButton("<<");
    private final JButton lastJButton = new JButton(">>");
    private final JLabel idJLabel = new JLabel("Id:");
    private final JLabel nomeJLabel = new JLabel("Digite um nome:");
    private final JLabel emailJLabel = new JLabel("Digite um email:");
    private final JLabel senhaJLabel = new JLabel("Digite uma senha:");
    private final JLabel notificacaoJLabel = new JLabel("Notificações...");
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

        firstJButton.addActionListener(
            new ActionListener()
            {
                public void actionPerformed(ActionEvent event)
                {
                    String[] resultado;
                    try {
                        resultado = NavegadorDeRegistro.FirstRegister("db_teste", "tbl_teste");
                        idJTextField.setText(resultado[0]);
                        nomeJTextField.setText(resultado[1]);
                        emailJTextField.setText(resultado[2]);
                        senhaJPasswordField.setText(resultado[3]);
                        updateJButton.setEnabled(true);
                        firstJButton.setEnabled(false);
                        previousJButton.setEnabled(false);
                        lastJButton.setEnabled(true);
                        nextJButton.setEnabled(true);

                        notificacaoJLabel.setText("Primeiro regostro posicionado com sucesso!");
                    } catch (Exception e) {
                        System.out.println("Opsss!! Ocorreu um erro ao posicionar o primeiro registro. Erro: "+ e);
                    }
                }
            }
        );

        nextJButton.addActionListener(
            new ActionListener()
            {
                public void actionPerformed(ActionEvent event)
                {
                    String[] resultado;
                    try {
                        resultado = NavegadorDeRegistro.NextRegister("db_teste", "tbl_teste", idJTextField.getText());
                        idJTextField.setText(resultado[0]);
                        nomeJTextField.setText(resultado[1]);
                        emailJTextField.setText(resultado[2]);
                        senhaJPasswordField.setText(resultado[3]);
                        updateJButton.setEnabled(true);
                        firstJButton.setEnabled(true);
                        previousJButton.setEnabled(true);
                        lastJButton.setEnabled(true);
                        nextJButton.setEnabled(true);
                        
                        notificacaoJLabel.setText("Próximo registro");
                    } catch (Exception e) {
                        System.out.println("Opsss!! Ocorreu um erro ao posicionar o primeiro registro. Erro: "+ e);
                    }
                }
            }
        );

        previousJButton.addActionListener(
            new ActionListener()
            {
                public void actionPerformed(ActionEvent event)
                {
                    String[] resultado;
                    try {
                        resultado = NavegadorDeRegistro.PreviousRegister("db_teste", "tbl_teste", idJTextField.getText());
                        idJTextField.setText(resultado[0]);
                        nomeJTextField.setText(resultado[1]);
                        emailJTextField.setText(resultado[2]);
                        senhaJPasswordField.setText(resultado[3]);
                        updateJButton.setEnabled(true);
                        firstJButton.setEnabled(true);
                        previousJButton.setEnabled(true);
                        lastJButton.setEnabled(true);
                        nextJButton.setEnabled(true);
                        
                        notificacaoJLabel.setText("Registro Anterior");
                    } catch (Exception e) {
                        System.out.println("Opsss!! Ocorreu um erro ao posicionar o primeiro registro. Erro: "+ e);
                    }
                }
            }
            );
            
        lastJButton.addActionListener(
            new ActionListener()
            {
                public void actionPerformed(ActionEvent event)
                {
                    String[] resultado;
                    try {
                        resultado = NavegadorDeRegistro.LastRegister("db_teste", "tbl_teste");
                        idJTextField.setText(resultado[0]);
                        nomeJTextField.setText(resultado[1]);
                        emailJTextField.setText(resultado[2]);
                        senhaJPasswordField.setText(resultado[3]);
                        updateJButton.setEnabled(true);
                        firstJButton.setEnabled(true);
                        previousJButton.setEnabled(true);
                        lastJButton.setEnabled(false);
                        nextJButton.setEnabled(false);

                        notificacaoJLabel.setText("Ultimo registro posicionado com sucesso!!");
                    } catch (Exception e) {
                        System.out.println("Opsss!! Ocorreu um erro ao posicionar o primeiro registro. Erro: "+ e);
                    }
                }
            }
        );

        updateJButton.addActionListener(
            new ActionListener()
            {
                public void actionPerformed(ActionEvent event)
                {
                    String name;
                    String email;
                    String password;
                    String id;
                    
                    try {
                        name = nomeJTextField.getText();
                        email = emailJTextField.getText();
                        password = senhaJPasswordField.getText();
                        id = idJTextField.getText();
                        NavegadorDeRegistro.UpdateRegister("db_teste", "tbl_teste", name, email, password, id);

                        notificacaoJLabel.setText("Cadastro realizado com sucesso");
                    } catch(Exception e) {
                        notificacaoJLabel.setText("Digite alguma coisa:");
                        return;
                    }
                }
            }
        );


        
        add(idJLabel);
        add(idJTextField);
        add(updateJButton);
        add(deleteJButton);
        
        add(nomeJLabel);
        add(nomeJTextField);
        add(espacador2Label);
        add(espacador3Label);
        
        add(emailJLabel);
        add(emailJTextField);
        add(espacador4Label);
        add(espacador5Label);
        
        add(senhaJLabel);
        add(senhaJPasswordField);
        add(espacador6Label);
        add(espacador7Label);
        
        add(firstJButton);
        add(previousJButton);
        add(nextJButton);
        add(lastJButton);
        
        add(notificacaoJLabel);
        
        idJTextField.setEditable(false);

        setSize(600, 300);
        setVisible(true);
    }
    public static void main(String[] args) {
        MostrarCadastro application = new MostrarCadastro();
        application.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
