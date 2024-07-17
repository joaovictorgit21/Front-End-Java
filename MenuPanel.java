import javax.swing.JFrame;

public class MenuPanel
{
   public static void main(String[] args)
   { 
      MenuFrame menuFrame = new MenuFrame();
      menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      menuFrame.setSize(700, 400);
      menuFrame.setVisible(true);
   } 
}