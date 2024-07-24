import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FrameNome extends JFrame {
    private final JTextField nomeJTextField = new JTextField();
    private final JTextField emailJTextField = new JTextField();
    private final JTextField senhalJTextField = new JTextField();
    private final JButton cadastrarJButton = new JButton("Cadastrar");
    private final JLabel nomeJLabel = new JLabel("Digite seu nome:");
    private final JLabel emailJLabel = new JLabel("Digite seu email:");
    private final JLabel senhaJLabel = new JLabel("Digite seu senha:");
    private final JLabel notificacaoJLabel = new JLabel("Notificações...");

    public FrameNome()
    {
        super("Cadastrar");
        setLayout(new GridLayout(4, 5, 5, 5));

        cadastrarJButton.addActionListener(
            new ActionListener()
            {
                public void actionPerformed(ActionEvent event)
                {
                    String nome;
                    String email;
                    String senha;

                    try {
                        nome = nomeJTextField.getText();
                        email = emailJTextField.getText();
                        senha = senhalJTextField.getText();
                        InserirRegistro.cadastrar("db_teste", "tbl_teste", "name", "email", "senha", nome, email, senha);

                        notificacaoJLabel.setText("Cadastro realizado com sucesso");
                    } catch(NumberFormatException ex) {
                        notificacaoJLabel.setText("Digite alguma coisa:");
                        return;
                    }
                }
            });

            add(nomeJLabel);
            setSize(100, 500);
            setVisible(true);
            
            
            add(nomeJTextField);
            setSize(200, 200);
            setVisible(true);
            
            add(emailJLabel);
            setSize(200, 500);
            setVisible(true);
            
            add(emailJTextField);
            setSize(200, 200);
            setVisible(true);
            
            
            add(senhaJLabel);
            setSize(100, 500);
            setVisible(true);


            add(senhalJTextField);
            setSize(400, 200);
            setVisible(true);

            add(cadastrarJButton);
            setSize(400, 200);
            setVisible(true);

            add(notificacaoJLabel);
            setSize(400, 200);
            setVisible(true);
    }
    public static void main(String[] args) {
        FrameNome application = new FrameNome();
        application.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}