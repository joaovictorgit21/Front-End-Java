import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MostrarCadastro extends JFrame {
    private final JTextField idJTextField = new JTextField();
    private final JTextField nameJTextField = new JTextField();
    private final JTextField emailJTextField = new JTextField();
    private final JTextField passwordJPasswordField = new JTextField();
    private final JButton updateJButton = new JButton("^");
    private final JButton deleteJButton = new JButton("Del");
    private final JButton searchJButton = new JButton("🔍");
    // private final JButton editarJButton = new JButton("🖌️"); //
    private final JButton clearFields = new JButton("🗑️");
    // private final JCheckBox checkBox = new JCheckBox() ; //
    private final JButton nextJButton = new JButton(">");
    private final JButton previousJButton = new JButton("<");
    private final JButton firstJButton = new JButton("<<");
    private final JButton lastJButton = new JButton(">>");
    private final JLabel idJLabel = new JLabel("Id:");
    private final JLabel nomeJLabel = new JLabel("Digite um nome:");
    private final JLabel emailJLabel = new JLabel("Digite um email:");
    private final JLabel passwordJLabel = new JLabel("Digite uma Password:");
    private final JButton newJButton = new JButton("+");
    private final JLabel notificacaoJLabel = new JLabel("Notificações...");
    private final JLabel espacador2Label = new JLabel("");
    private final JLabel espacador4Label = new JLabel("");
    private final JLabel espacador6Label = new JLabel("");
    private final String dbPadrao = "db_teste";
    private final String tblPadrao = "tbl_teste";


    
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
                        resultado = NavegadorDeRegistro.FirstRegister(dbPadrao, tblPadrao);
                        idJTextField.setText(resultado[0]);
                        nameJTextField.setText(resultado[1]);
                        emailJTextField.setText(resultado[2]);
                        passwordJPasswordField.setText(resultado[3]);
                        updateJButton.setEnabled(true);
                        firstJButton.setEnabled(false);
                        previousJButton.setEnabled(false);
                        lastJButton.setEnabled(true);
                        nextJButton.setEnabled(true);
                        deleteJButton.setEnabled(true);

                        notificacaoJLabel.setText("Primeiro registro posicionado com sucesso!");
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
                        resultado = NavegadorDeRegistro.NextRegister(dbPadrao, tblPadrao, idJTextField.getText());
                        idJTextField.setText(resultado[0]);
                        nameJTextField.setText(resultado[1]);
                        emailJTextField.setText(resultado[2]);
                        passwordJPasswordField.setText(resultado[3]);
                        updateJButton.setEnabled(true);
                        firstJButton.setEnabled(true);
                        previousJButton.setEnabled(true);
                        lastJButton.setEnabled(true);
                        nextJButton.setEnabled(true);
                        deleteJButton.setEnabled(true);
                        
                        notificacaoJLabel.setText("Próximo registro");
                    } catch (Exception e) {
                        System.out.println("Opsss!! Ocorreu um erro ao posicionar o próximo registro. Erro: "+ e);
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
                        resultado = NavegadorDeRegistro.PreviousRegister(dbPadrao, tblPadrao, idJTextField.getText());
                        idJTextField.setText(resultado[0]);
                        nameJTextField.setText(resultado[1]);
                        emailJTextField.setText(resultado[2]);
                        passwordJPasswordField.setText(resultado[3]);
                        updateJButton.setEnabled(true);
                        firstJButton.setEnabled(true);
                        previousJButton.setEnabled(true);
                        lastJButton.setEnabled(true);
                        nextJButton.setEnabled(true);
                        deleteJButton.setEnabled(true);
                        
                        notificacaoJLabel.setText("Registro Anterior");
                    } catch (Exception e) {
                        System.out.println("Opsss!! Ocorreu um erro ao posicionar o registro anterior. Erro: "+ e);
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
                        resultado = NavegadorDeRegistro.LastRegister(dbPadrao, tblPadrao);
                        idJTextField.setText(resultado[0]);
                        nameJTextField.setText(resultado[1]);
                        emailJTextField.setText(resultado[2]);
                        passwordJPasswordField.setText(resultado[3]);
                        updateJButton.setEnabled(true);
                        firstJButton.setEnabled(true);
                        previousJButton.setEnabled(true);
                        lastJButton.setEnabled(false);
                        nextJButton.setEnabled(false);
                        deleteJButton.setEnabled(true);

                        notificacaoJLabel.setText("Ultimo registro posicionado com sucesso!!");
                    } catch (Exception e) {
                        System.out.println("Opsss!! Ocorreu um erro ao posicionar o último registro. Erro: "+ e);
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
                        name = nameJTextField.getText();
                        email = emailJTextField.getText();
                        password = passwordJPasswordField.getText();
                        id = idJTextField.getText();
                        NavegadorDeRegistro.UpdateRegister(dbPadrao, tblPadrao, name, email, password, id);

                        notificacaoJLabel.setText("Atualização realizada com sucesso");
                    } catch(Exception e) {
                        notificacaoJLabel.setText("Digite alguma coisa:");
                        return;
                    }
                }
            }
        );

        deleteJButton.addActionListener(
            new ActionListener()
            {
                public void actionPerformed(ActionEvent event)
                {
                    String id;
                    try {
                        id = idJTextField.getText();
                        NavegadorDeRegistro.DeleteRegister(dbPadrao, tblPadrao, "id", id);
                        notificacaoJLabel.setText("Exclusão realizada com sucesso");
                    } catch(Exception e) {
                        notificacaoJLabel.setText("Digite alguma coisa:");
                        return;
                    }
                }
            }
        );

        
        newJButton.addActionListener(
            new ActionListener() 
            {
                public void actionPerformed(ActionEvent event)
                {
                    String name;
                    String email;
                    String password;
                    try {   
                        newJButton.setEnabled(false);
                        searchJButton.setEnabled(false);
                        deleteJButton.setEnabled(true);
                        
                        firstJButton.setEnabled(false);
                        nextJButton.setEnabled(false);
                        previousJButton.setEnabled(false);
                        lastJButton.setEnabled(false);
                        
                        nameJTextField.requestFocus();
                        
                        name = nameJTextField.getText();
                        email = emailJTextField.getText();
                        password = passwordJPasswordField.getText();
                        NavegadorDeRegistro.newResgister(dbPadrao, tblPadrao, "name", "email", "password", name, email, password);
                        notificacaoJLabel.setText("Registro adicionado com sucesso");
                    } catch (Exception e) {
                        notificacaoJLabel.setText("Digite alguma coisa:");
                        return;
                    }
                }
            }
            );

        clearFields.addActionListener(
            new ActionListener() {

                public void actionPerformed(ActionEvent event)
                {
                    idJTextField.setText("");
                    nameJTextField.setText("");
                    emailJTextField.setText("");
                    passwordJPasswordField.setText("");
                    
                    notificacaoJLabel.setText("Exclusão de campos com sucesso");
                }
            }
        );

        searchJButton.addActionListener(
            new ActionListener() {

                public void actionPerformed(ActionEvent event) 
                {
                    String name;
                    String email;
                    
                    String[] resultado;
                    try {
                        
                        firstJButton.setEnabled(true);
                        nextJButton.setEnabled(true);
                        previousJButton.setEnabled(true);
                        lastJButton.setEnabled(true);

                        name = nameJTextField.getText();
                        email = emailJTextField.getText();
                        
                        resultado = NavegadorDeRegistro.searchRegister(dbPadrao, tblPadrao, "name", "email", name, email);

                        // idJTextField.setText(resultado[0]);
                        nameJTextField.setText(resultado[0]);
                        emailJTextField.setText(resultado[1]);
                        // passwordJPasswordField.setText(resultado[3]);

                    } catch (Exception e) {
                        notificacaoJLabel.setText("Digite alguma coisa:");
                        return;
                    }
                }
            }
        );

        add(idJLabel);
        add(idJTextField);
        add(updateJButton);
        updateJButton.setEnabled(false);

        add(deleteJButton);
        deleteJButton.setEnabled(false);
        
        add(nomeJLabel);
        add(nameJTextField);
        add(espacador2Label);
        add(newJButton);
        
        add(emailJLabel);
        add(emailJTextField);
        add(espacador4Label);
        add(searchJButton);
        
        add(passwordJLabel);
        add(passwordJPasswordField);
        add(espacador6Label);
        add(clearFields);
        
        add(firstJButton);
        add(previousJButton);
        add(nextJButton);
        add(lastJButton);
        firstJButton.setEnabled(true);
        nextJButton.setEnabled(false);
        previousJButton.setEnabled(false);
        lastJButton.setEnabled(true);
        
        add(notificacaoJLabel);
        
        idJTextField.setEditable(false);

        setSize(800, 300);
        setVisible(true);
    }
    public static void main(String[] args) {
        MostrarCadastro application = new MostrarCadastro();
        application.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
