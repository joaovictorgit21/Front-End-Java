// Fig. 12.21: ComboBoxFrame.java
// JComboBox that displays a list of image names.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ComboBoxFrame extends JFrame 
{
   private final JComboBox<String> imagesJComboBox; // hold icon names
   private final JLabel label; // displays selected icon

   private static final String[] names = 
   { 
      "Gustavo",
      "Gabriel",
      "Lucas",
      "Matheus",
      "Daniel",
      "Julio",
      "Angelo",
      "Enrique",
      "Germano",
      "Farias",
      "Douglas",
      "Rafael",
      "Felipe"
   };
   // ComboBoxFrame constructor adds JComboBox to JFrame
   public ComboBoxFrame()
   {
      super("Testing JComboBox");
      setLayout(new FlowLayout()); // set frame layout     

      imagesJComboBox = new JComboBox<String>(names); // set up JComboBox
      imagesJComboBox.setMaximumRowCount(3); // display three rows

      add(imagesJComboBox); // add combobox to JFrame
      label = new JLabel(names[0]); // display first icon
      add(label); // add label to JFrame
      imagesJComboBox.addItemListener(event -> { 
           if (event.getStateChange() == ItemEvent.SELECTED) {}
           label.setText(names[imagesJComboBox.getSelectedIndex()]);
         }); // end call to addItemListener
   } // end ComboBoxFrame constructor
} // end class ComboBoxFrame