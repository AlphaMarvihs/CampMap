package Class;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

public class Description extends JFrame implements ActionListener {
    private JLabel imageLabel;
    private JTextArea textLabel;
    private ImageIcon[] imageIcons;
    private int currentIndex;
    String places[] = { "Cricket Ground", "Library", "OAT", "Shopping", "Admin Block",
            "MBH", "Basketball Ground", "IT Building", "Yadav Canteen", "Sports Complex", "SAC" };
    JFrame frame;

    public Description(int index, JFrame frame) {
        setTitle(places[index]);

        this.frame = frame;
        setLocationRelativeTo(frame);
        setLocation(this.getLocation().x - 160, this.getLocation().y - 200);

        JPanel panel = new JPanel(new FlowLayout());

        int imageCount = new File("./Img/" + places[index]).listFiles().length - 1;
        imageIcons = new ImageIcon[imageCount];
        for (int i = 0; i < imageCount; i++) {
            imageIcons[i] = new ImageIcon("./Img/" + places[index] + "/" + (i + 1) + ".jpg");
        }

        imageLabel = new JLabel(imageIcons[0]);
        imageLabel.setHorizontalAlignment(JLabel.CENTER);

        JButton prevButton = new JButton("Prev");
        prevButton.addActionListener(this);
        prevButton.setPreferredSize(new Dimension(120, 40));
        prevButton.setBackground(Color.white);
        prevButton.setFocusable(false);
        JButton nextButton = new JButton("Next");
        nextButton.setBackground(Color.white);
        nextButton.setPreferredSize(new Dimension(120, 10));
        nextButton.setFocusable(false);
        nextButton.addActionListener(this);

        GridLayout grid = new GridLayout(1, 2);
        JPanel buttonPanel = new JPanel(grid);
        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);

        JPanel textPanel = new JPanel();
        textLabel = new JTextArea(getDescription(index));
        textLabel.setEditable(false);
        textLabel.setLineWrap(true);
        textLabel.setWrapStyleWord(true);
        textLabel.setFont(new Font("Arial", Font.BOLD, 16));
        textLabel.setForeground(new Color(60, 60, 60));
        textLabel.setPreferredSize(new Dimension(320, 160));
        textPanel.setPreferredSize(new Dimension(400, 200));
        textPanel.add(textLabel, BorderLayout.CENTER);

        panel.add(imageLabel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.CENTER);
        panel.add(textPanel, BorderLayout.SOUTH);

        imageLabel.setPreferredSize(new Dimension(400, 300));

        panel.setBackground(new Color(190, 190, 190));
        buttonPanel.setBackground(new Color(140, 140, 140));
        textPanel.setBackground(new Color(190, 190, 190));
        textLabel.setBackground(new Color(190, 190, 190));
        ;

        add(panel);

        setSize(400, 540);
        setResizable(false);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        JButton button = (JButton) source;
        if (button.getText().equals("Prev")) {
            currentIndex--;
            if (currentIndex < 0) {
                currentIndex = imageIcons.length - 1;
            }
        } else if (button.getText().equals("Next")) {
            currentIndex++;
            if (currentIndex >= imageIcons.length) {
                currentIndex = 0;
            }
        }
        imageLabel.setIcon(imageIcons[currentIndex]);
    }

    public String getDescription(int index) {
        String description = "";
        Scanner fileReader;
        File file;
        file = new File("./Img/" + places[index] + "/description.txt");
        try {
            fileReader = new Scanner(file);
            description = fileReader.nextLine();
            fileReader.close();
        } catch (Exception e) {
        }
        ;

        return description;

    }

}
