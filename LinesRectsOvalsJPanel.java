// Fig. 13.18: LinesRectsOvalsJPanel.java
// Drawing lines, rectangles and ovals.
import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class LinesRectsOvalsJPanel extends JPanel 
{
   // display various lines, rectangles and ovals
   @Override
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g); 
      this.setBackground(Color.WHITE);

      g.setColor(Color.RED);
      g.drawLine(5, 30, 380, 20);
      g.setColor(new Color(255, 0, 0));
      g.setFont(new Font("Arial", Font.ITALIC, 22));
      g.drawString("Line", 20, 20);

      g.setColor(Color.BLUE);
      g.drawRect(5, 40, 90, 55);
      g.fillRect(100, 40, 90, 55);
      g.setColor(new Color(255, 0, 0));
      g.setFont(new Font("Arial", Font.ITALIC, 15));
      g.drawString("Rect Filled", 105, 75);
      g.setColor(new Color(255, 0, 0));
      g.setFont(new Font("Arial", Font.ITALIC, 15));
      g.drawString("Not filled", 20, 75);

      g.setColor(Color.BLACK);
      g.fillRoundRect(195, 40, 90, 55, 50, 50);
      g.drawRoundRect(290, 40, 90, 55, 20, 20);
      g.setColor(new Color(255, 0, 0));
      g.setFont(new Font("Arial", Font.ITALIC, 12));
      g.drawString("Arround not filled", 288, 75);
      g.setColor(new Color(255, 0, 0));
      g.setFont(new Font("Arial", Font.ITALIC, 13));
      g.drawString("Arround filled", 205, 75);

      g.setColor(Color.GREEN);   
      g.draw3DRect(5, 100, 90, 55, false);
      g.fill3DRect(100, 100, 90, 55, true);
      g.setColor(new Color(255, 0, 0));
      g.setFont(new Font("Arial", Font.ITALIC, 15));
      g.drawString("3D Rect not fill", 97, 130);
      g.setColor(new Color(255, 0, 0));
      g.setFont(new Font("Arial", Font.ITALIC, 15));
      g.drawString("3D Rect fill", 13, 130);

      g.setColor(Color.MAGENTA);
      g.drawOval(195, 100, 90, 55);
      g.fillOval(290, 100, 90, 55);
      g.setColor(new Color(255, 0, 0));
      g.setFont(new Font("Arial", Font.ITALIC, 15));
      g.drawString("Oval fill", 310, 130);
      g.setColor(new Color(255, 0, 0));
      g.setFont(new Font("Arial", Font.ITALIC, 15));
      g.drawString("Oval not fill", 205, 130);
   }
} // end class LinesRectsOvalsJPanel