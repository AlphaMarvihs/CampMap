import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Campus11 {
    JFrame frame;
    int coordinates[][] = { { 275, 600 }, { 500, 350 }, { 610, 580 } };
    String places[] = { "Cricket Ground", "Snackers", "OAT" };
    BufferedImage image = null, image2;
    JPanel panel;
    JLabel label[], text[];
    JLayeredPane layeredPane;

    public Campus11() {
        frame = new JFrame();
        frame.setSize(1200, 750);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            image = ImageIO.read(new File("Map.png"));
        } catch (Exception e) {
        }

        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };

        layeredPane = new JLayeredPane();
        layeredPane.setSize(1035, 710);
        layeredPane.setOpaque(false);

        createComponents();
        frame.add(layeredPane);
        frame.add(panel);
        frame.revalidate();
        frame.repaint();
    }

    public void createComponents() {
        label = new JLabel[3];
        text = new JLabel[3];

        for (int i = 0; i <= 2; i++) {
            ImageIcon marker = new ImageIcon("marker.png");
            Image mark = marker.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            marker = new ImageIcon(mark);
            label[i] = new JLabel(marker);
            label[i].setOpaque(false);
            label[i].setBounds(coordinates[i][0], coordinates[i][1], 20, 20);

            text[i] = new JLabel(places[i]);
            text[i].setForeground(Color.WHITE);
            text[i].setOpaque(false);
            text[i].setBounds(coordinates[i][0] + 20, coordinates[i][1], 100, 20);

            final int index = i;
            label[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    ImageShuffleGUI info = new ImageShuffleGUI(index , frame);
                }
            });

            layeredPane.add(label[i], Integer.valueOf(1));
            layeredPane.add(text[i], 1);
        }
    }

    public static void main(String[] args) {
        new Campus11();
    }
}
