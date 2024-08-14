import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

public class Teste extends JFrame {
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

    private Connection connection;
    private ResultSet resultSet;

    public Teste() {
        super("Cadastrar");
        setLayout(new GridLayout(6, 5, 10, 10));

        add(idJLabel);
        add(idJTextField);
        add(updateJButton);
        add(espacadorLabel);

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

        setSize(600, 400);
        setVisible(true);

        // Desativar o campo de texto do ID
        idJTextField.setEditable(false);

        // Configurar a conexão com o banco de dados e carregar o primeiro registro
        try {
            connection = MySQLConnector.connection();
            carregarPrimeiroRegistro();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Adicionar ação aos botões
        nextJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    carregarProximoRegistro();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        preveusJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    carregarRegistroAnterior();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        firstJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    carregarPrimeiroRegistro();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        lastJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    carregarUltimoRegistro();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    private void carregarPrimeiroRegistro() throws SQLException {
        String sql = "SELECT * FROM `db_teste`.`tbl_teste` ORDER BY id LIMIT 1";
        PreparedStatement statement = connection.prepareStatement(sql);
        resultSet = statement.executeQuery();
        if (resultSet.next()) {
            exibirRegistroAtual();
        }
    }

    private void carregarUltimoRegistro() throws SQLException {
        String sql = "SELECT * FROM `db_teste`.`tbl_teste` ORDER BY id DESC LIMIT 1";
        PreparedStatement statement = connection.prepareStatement(sql);
        resultSet = statement.executeQuery();
        if (resultSet.next()) {
            exibirRegistroAtual();
        }
    }

    private void carregarProximoRegistro() throws SQLException {
        if (resultSet.next()) {
            exibirRegistroAtual();
        } else {
            notificacaoJLabel.setText("Não há mais registros.");
        }
    }

    private void carregarRegistroAnterior() throws SQLException {
        if (resultSet.previous()) {
            exibirRegistroAtual();
        } else {
            notificacaoJLabel.setText("Este é o primeiro registro.");
        }
    }

    private void exibirRegistroAtual() throws SQLException {
        idJTextField.setText(resultSet.getString("id"));
        nomeJTextField.setText(resultSet.getString("name"));
        emailJTextField.setText(resultSet.getString("email"));
        senhalJTextField.setText(resultSet.getString("senha"));

        // Log no terminal
        System.out.println("Id: " + resultSet.getString("id"));
        System.out.println("Nome: " + resultSet.getString("name"));
        System.out.println("Email: " + resultSet.getString("email"));
        System.out.println("Senha: " + resultSet.getString("senha"));
    }

    public static void main(String[] args) {
        MostrarCadastro application = new MostrarCadastro();
        application.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
