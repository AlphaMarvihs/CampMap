import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;

public class CampMap {
    JFrame frame;
    int coordinates[][] = { { 275, 600 }, { 500, 350 }, { 610, 580 }, { 880, 360 }, { 605, 345 },{ 270, 160 },{ 410, 520 },{ 710, 430 },{ 485, 180 },{ 480, 640 },{ 440,450} }; 
    String places[] = { "Cricket Ground", "Library", "OAT", "Shopping", "Admin Block",
            "MBH", "Basketball Ground", "IT Building", "Yadav Canteen", "Sports Complex", "SAC" };
    BufferedImage image = null, image2;
    JPanel panel;
    JLabel label[], text[];
    JLayeredPane layeredPane;
    int points = places.length;

    public CampMap() {
        frame = new JFrame();
        frame.setSize(1200, 750);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            image = ImageIO.read(new File("./PNG/Map.png"));
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
        layeredPane.setSize(1200, 750);
        layeredPane.setOpaque(false);

        createComponents();
        frame.add(layeredPane);
        frame.add(panel);
        frame.revalidate();
        frame.repaint();
    }

    public void createComponents() {
        label = new JLabel[points];
        text = new JLabel[points];

        for (int i = 0; i < points; i++) {
            ImageIcon marker = new ImageIcon("./PNG/marker.png");
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
                    new Description(index, frame);
                }
            });

            layeredPane.add(label[i], Integer.valueOf(1));
            layeredPane.add(text[i], 1);
        }
    }

    public static void main(String[] args) {
        new CampMap();
    }
}
