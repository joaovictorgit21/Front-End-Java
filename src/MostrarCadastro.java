import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MostrarCadastro extends JFrame {

    // private final JLabel espacadorInicialLabel = new JLabel("");
    // private final JLabel espacadorInicial2Label = new JLabel("");
    // private final JLabel espacadorFinal1Label = new JLabel("");
    private final JLabel searchJLabel = new JLabel("Pesquisar:", SwingConstants.CENTER);

    // private final JTextField seachbarJTextField = new JTextField();

    private final JTextField idJTextField = new JTextField();
    private final JTextField nameJTextField = new JTextField();
    private final JTextField emailJTextField = new JTextField();
    private final JPasswordField passwordJPasswordField = new JPasswordField();
    private final JButton updateJButton = new JButton("^");
    private final JButton deleteJButton = new JButton("Del");
    private final JButton searchJButton = new JButton("🔍");
    private final JTextField searchJText = new JTextField("");
    private final JButton newJButton = new JButton("+");
    private final JButton clearFields = new JButton("🗑️");
    // private final JButton editarJButton = new JButton("🖌️"); //
    // private final JCheckBox checkBox = new JCheckBox() ; //
    private final JButton nextJButton = new JButton(">");
    private final JButton previousJButton = new JButton("<");
    private final JButton firstJButton = new JButton("<<");
    private final JButton lastJButton = new JButton(">>");
    private final JLabel idJLabel = new JLabel("Id:");
    private final JLabel nomeJLabel = new JLabel("Digite um nome:");
    private final JLabel emailJLabel = new JLabel("Digite um email:");
    private final JLabel passwordJLabel = new JLabel("Digite uma Password:");
    private final JLabel notificacaoJLabel = new JLabel("Notificações...", SwingConstants.CENTER);
    private final JLabel espacador2Label = new JLabel("");
    private final JLabel espacador4Label = new JLabel("");
    private final JLabel espacador6Label = new JLabel("");
    private final JLabel espacador7Label = new JLabel("");
    private final JLabel espacador8Label = new JLabel("");
    private final String dbPadrao = "db_teste";
    private final String tblPadrao = "tbl_teste";
    
    public MostrarCadastro()
    
    {
        super("Cadastrar");
        setLayout(new GridLayout(8, 4, 5, 5));
        
        JPanel line0 = new JPanel(new GridLayout(1, 3, 5, 5));
        
        JPanel lineExtra = new JPanel(new GridLayout(1, 1, 5, 5));

        JPanel line1 = new JPanel(new GridLayout(1, 4, 5, 5));

        JPanel line2 = new JPanel(new GridLayout(1, 4, 5, 5));

        JPanel line3 = new JPanel(new GridLayout(1, 4, 5, 5));

        JPanel line4 = new JPanel(new GridLayout(1, 4, 5, 5));

        JPanel line5 = new JPanel(new GridLayout(1, 4, 5, 5));

        JPanel line6 = new JPanel(new GridLayout(1, 1, 5, 5));


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
                        updateJButton.setEnabled(true);
                        firstJButton.setEnabled(false);
                        previousJButton.setEnabled(false);
                        lastJButton.setEnabled(true);
                        nextJButton.setEnabled(true);
                        deleteJButton.setEnabled(true);

                        notificacaoJLabel.setText("Primeiro registro posicionado com sucesso!");
                    } catch (Exception e) {
                        System.out.println("Opsss!! Ocorreu um erro ao posicionar o primeiro registro. Erro: "+ e);
                        notificacaoJLabel.setText("Opsss!! Ocorreu um erro ao posicionar o primeiro registro");
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
                        updateJButton.setEnabled(true);
                        firstJButton.setEnabled(true);
                        previousJButton.setEnabled(true);
                        lastJButton.setEnabled(true);
                        nextJButton.setEnabled(true);
                        deleteJButton.setEnabled(true);
                        
                        notificacaoJLabel.setText("Próximo registro");
                    } catch (Exception e) {
                        System.out.println("Opsss!! Ocorreu um erro ao posicionar o próximo registro. Erro: "+ e);
                        notificacaoJLabel.setText("Opsss!! Parece que você já está no ultimo registro!!");
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
                        updateJButton.setEnabled(true);
                        firstJButton.setEnabled(true);
                        previousJButton.setEnabled(true);
                        lastJButton.setEnabled(true);
                        nextJButton.setEnabled(true);
                        deleteJButton.setEnabled(true);
                        
                        notificacaoJLabel.setText("Registro Anterior");
                    } catch (Exception e) {
                        System.out.println("Opsss!! Ocorreu um erro ao posicionar o registro anterior. Erro: "+ e);
                        notificacaoJLabel.setText("Opsss!! Parece que você já está no primeiro registro!!");
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
                        updateJButton.setEnabled(true);
                        firstJButton.setEnabled(true);
                        previousJButton.setEnabled(true);
                        lastJButton.setEnabled(false);
                        nextJButton.setEnabled(false);
                        deleteJButton.setEnabled(true);

                        notificacaoJLabel.setText("Ultimo registro posicionado com sucesso!!");
                    } catch (Exception e) {
                        System.out.println("Opsss!! Ocorreu um erro ao posicionar o último registro. Erro: "+ e);
                        notificacaoJLabel.setText("Opsss!! Ocorreu um erro ao posicionar o último registro.");
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
                    String id;
                    
                    try {
                        name = nameJTextField.getText();
                        email = emailJTextField.getText();
                        id = idJTextField.getText();
                        NavegadorDeRegistro.UpdateRegister(dbPadrao, tblPadrao, name, email, id);

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
                        password = passwordJPasswordField.getPassword().toString();
                        NavegadorDeRegistro.newResgister(dbPadrao, tblPadrao, "name", "email", "password", name, email, password);

                        nameJTextField.setText("");
                        emailJTextField.setText("");
                        passwordJPasswordField.setText("");
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
                    searchJText.setText("");

                    idJTextField.setText("");
                    nameJTextField.setText("");
                    emailJTextField.setText("");
                    passwordJPasswordField.setText("");

                    nextJButton.setEnabled(false);
                    previousJButton.setEnabled(false);
                    deleteJButton.setEnabled(false);
                    firstJButton.setEnabled(true);
                    firstJButton.setEnabled(true);
                    firstJButton.setEnabled(true);
                    newJButton.setEnabled(true);

                    firstJButton.setEnabled(true);
                    lastJButton.setEnabled(true);
                    
                    notificacaoJLabel.setText("Campos limpados com sucesso");
                }
            }
        );

        searchJButton.addActionListener(
            new ActionListener() {

                public void actionPerformed(ActionEvent event) 
                {
                    String search;
                    
                    String[] resultado;
                        try {
                            
                        firstJButton.setEnabled(true);
                        nextJButton.setEnabled(true);
                        previousJButton.setEnabled(true);
                        lastJButton.setEnabled(true);

                        search = searchJText.getText();
                            
                        resultado = NavegadorDeRegistro.searchRegister(dbPadrao, tblPadrao, "name","email", search);

                        idJTextField.setText(resultado[0]);
                        nameJTextField.setText(resultado[1]);
                        emailJTextField.setText(resultado[2]);
                        // passwordJPasswordField.setText(resultado[3]);
                        
                    } catch (Exception e) {
                        notificacaoJLabel.setText("Digite alguma coisa:");
                        return;
                    }
                }
            }
            );
            
            // add(espacadorInicialLabel);
            // add(seachbarJTextField);
            // add(espacadorInicial2Label);
            
            // add(espacadorInicial3Label);
            // add(espacadorInicial4Label);
            
        line0.add(searchJLabel);
        line0.add(searchJText);
        // line0.add(espacadorFinal1Label);
        line0.add(searchJButton);
        searchJButton.setToolTipText("Pesquisar");
        add(line0);

        lineExtra.add(espacador8Label);
        add(lineExtra);
        
        line1.add(idJLabel);
        line1.add(idJTextField);
        line1.add(updateJButton);
        updateJButton.setEnabled(false);
        updateJButton.setToolTipText("Atualizar");
        line1.add(deleteJButton);
        deleteJButton.setEnabled(false);
        deleteJButton.setToolTipText("Deletar");
        add(line1);
        
        line2.add(nomeJLabel);
        line2.add(nameJTextField);
        line2.add(espacador2Label);
        line2.add(newJButton);
        newJButton.setToolTipText("Novo Registro");
        add(line2);
        
        line3.add(emailJLabel);
        line3.add(emailJTextField);
        line3.add(espacador4Label);
        line3.add(espacador7Label);
        add(line3);
        
        line4.add(passwordJLabel);
        line4.add(passwordJPasswordField);
        line4.add(espacador6Label);
        line4.add(clearFields);
        clearFields.setToolTipText("Limpar Campos");
        add(line4);
        
        line5.add(firstJButton);
        line5.add(previousJButton);
        line5.add(nextJButton);
        line5.add(lastJButton);
        firstJButton.setEnabled(true);
        nextJButton.setEnabled(false);
        previousJButton.setEnabled(false);
        lastJButton.setEnabled(true);
        firstJButton.setToolTipText("Primeiro registro");
        nextJButton.setToolTipText("Proximo registro");
        previousJButton.setToolTipText("Registro anterior");
        lastJButton.setToolTipText("Ultimo registro");
        add(line5);
        
        line6.add(notificacaoJLabel);
        add(line6);
        
        idJTextField.setEditable(false);
        
        setSize(800, 300);
        setVisible(true);
    }
    public static void main(String[] args) {
        MostrarCadastro application = new MostrarCadastro();
        application.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
