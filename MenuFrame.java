import javax.swing.*;

public class MenuFrame extends JFrame 
{
    public MenuFrame()
    {
        super("Menu");    

        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic('F');

        JMenu editMenu = new JMenu("Edit");
        editMenu.setMnemonic('E');

        JMenuBar bar = new JMenuBar();
        setJMenuBar(bar);
        bar.add(fileMenu);
        bar.add(editMenu);
    }
}