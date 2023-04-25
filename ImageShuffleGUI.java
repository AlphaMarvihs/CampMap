import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImageShuffleGUI extends JFrame implements ActionListener {
    private JLabel imageLabel;
    private JTextArea textLabel;
    private ImageIcon[] imageIcons;
    private int currentIndex;
    JFrame frame;

    public ImageShuffleGUI(int index , JFrame frame) {
        // Set the title of the window
        setTitle("Image Button Text GUI");
        
        this.frame = frame;
        setLocationRelativeTo(frame);

        // Create a JPanel to hold the image and text
        JPanel panel = new JPanel(new FlowLayout());

        // Load the images
        imageIcons = new ImageIcon[] {
                new ImageIcon("dot1.jpg"),
                new ImageIcon("dot2.jpg"),
                new ImageIcon("dot3.jpg")
        };

        // Create a JLabel to hold the first image
        imageLabel = new JLabel(imageIcons[0]);
        imageLabel.setHorizontalAlignment(JLabel.CENTER);

        // Create buttons to shuffle through the images
        JButton prevButton = new JButton("Prev");
        prevButton.addActionListener(this);
        prevButton.setPreferredSize(new Dimension(120, 40));
        JButton nextButton = new JButton("Next");
        nextButton.setPreferredSize(new Dimension(120, 10));
        nextButton.addActionListener(this);

        // Create a JPanel to hold the buttons
        GridLayout grid = new GridLayout(1 , 2);
        grid.setHgap(40);
        JPanel buttonPanel = new JPanel(grid);
        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);

        // Create a JPanel to hold the text
        JPanel textPanel = new JPanel();
        textLabel = new JTextArea("Some text here ffbdsfbksb b kfbsdfkjds b jbskfsjfdskb fks bbfksdfsdjbf bkjfbsd bsb jbfsb kfb bb bkfbsdfkj b jbjb ksdbf b bksfbdfk");
        textLabel.setLineWrap(true);
       // textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setPreferredSize(new Dimension(320, 160));
        textPanel.setPreferredSize(new Dimension(400, 200));
        textPanel.add(textLabel);

        // Add the image, button, and text panels to the main panel
        panel.add(imageLabel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.CENTER);
        panel.add(textPanel, BorderLayout.SOUTH);

        // Set the preferred size of the image panel
        imageLabel.setPreferredSize(new Dimension(400, 300));

        // Add the panel to the JFrame
        add(panel);

        // Set the size of the window and make it visible
        setSize(400, 540);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // Get the source of the event
        Object source = e.getSource();

        // Determine which button was clicked and update the image label
        if (source instanceof JButton) {
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
    }

    // public static void main(String[] args) {
    //     // Create an instance of the ImageShuffleGUI class
    //     ImageShuffleGUI gui = new ImageShuffleGUI();
    // }
}
