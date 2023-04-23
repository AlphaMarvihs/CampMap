import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
// import java.io.BufferedReader;
import java.io.File;
// import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Campus2 {
    public static void main(String args[]) {
        JFrame frame = new JFrame();
        frame.setSize(1075, 750);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int coordinates[][]={{143,223},{367,250},{465,391}};
        String places[]={"Cricket Ground","Snackers","OAT"};
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("NITJ_MAP.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        final BufferedImage image2=image;
        JPanel panel = new JPanel() {
           
            // Draw the image on the panel
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image2, 0, 0, getWidth(), getHeight(), this);
            }
        };


        panel.setPreferredSize(new Dimension(1035,710));
       
        JLabel label[] = new JLabel[3];
        // ImageIcon icon[]=new ImageIcon[3];
        TextArea text[]=new TextArea[3];

        for (int i = 0; i <=2; i++) {
            text[i] = new TextArea(""); // replace with your image file path
        }
        
        //  for (int i = 0; i <=2; i++) {
        //     icon[i] =  // replace with your image file path
        // }
          // Create a BufferedReader to read lines from the file
          
                        
          // Create a StringBuilder to store the contents of the file
        //   StringBuilder stringBuilder = new StringBuilder();
 
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setSize(1035, 710);
        
        for (int i = 0; i <=2; i++) {
            label[i]=new JLabel();
            label[i].setOpaque(true);
            label[i].setBackground(Color.RED);
            label[i].setBounds(coordinates[i][0],coordinates[i][1],20,20);
            final int index=i;
            label[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    ImageIcon imageIcon = new ImageIcon("dot"+index+".jpg"); 
                    
                    
                    JDialog popup = new JDialog(frame, places[index], true);
                    JLabel imageLabel = new JLabel(imageIcon);
                    popup.add(imageLabel);
                    // popup.add(text);
                    
                    popup.pack();
                    popup.setLocationRelativeTo(frame);
                    popup.setVisible(true);
                    System.out.println("Label clicked!");
                    
                }
            });
            layeredPane.add(label[i],Integer.valueOf(1));
        }
        layeredPane.setOpaque(false);
        frame.add(layeredPane);
        frame.add(panel);
        // Revalidate and repaint the JFrame to display the image panel
        frame.revalidate();
        frame.repaint();
    }
}
