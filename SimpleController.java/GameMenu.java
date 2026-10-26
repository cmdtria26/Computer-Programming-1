import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Image;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.FlowLayout;

public class GameMenu {

  static JButton picButton(String file, int w, int h) {
    ImageIcon original = new ImageIcon(file);                                // load the picture
    Image resized = original.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);   // resize it
    JButton button = new JButton(new ImageIcon(resized));                    // put it on a button

    button.setContentAreaFilled(false);   // no gray box
    button.setBorderPainted(false);       // no border
    button.setFocusPainted(false);        // no outline after clicking

    return button;

}


    public static void main(String[] args) {
        // JFrame GUI

        JFrame frame = new JFrame();
        frame.setSize(1000, 1000);                          
        frame.setLocationRelativeTo(null);                  // centers the window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        JLabel gifLabel = new JLabel(new ImageIcon("download.gif"), JLabel.CENTER);  
        gifLabel.setLayout(new GridBagLayout());   
        frame.add(gifLabel, BorderLayout.CENTER);
        
 
        //title latur

       
        JButton startButton = picButton("play.png", 500, 300);          // play
        JButton helpButton = picButton("help.png", 40, 50);             // help
        JButton infoButton = picButton("i.png", 100, 80);             // info
        JButton settingsButton = picButton("settings.png", 50, 50);     // settings

        

    
        // text buttons (no pictures needed)
        JButton tutorialButton = new JButton("Tutorial");
        JButton menuButton = new JButton("Practice");
        JButton exitButton = new JButton("Exit");

        Font buttonFont = new Font("Jokerman", Font.BOLD, 26);
        Dimension buttonSize = new Dimension(160, 60);
        startButton.setForeground(new Color(0x4aa40c));   // gold
        menuButton.setFont(buttonFont);
        menuButton.setPreferredSize(buttonSize);
        menuButton.setForeground(new Color(0x4aa40c));
        tutorialButton.setFont(buttonFont);
        tutorialButton.setPreferredSize(buttonSize);
        tutorialButton.setForeground(new Color(0x4aa40c));
        exitButton.setFont(buttonFont);
        exitButton.setPreferredSize(buttonSize);
        exitButton.setForeground(new Color(0x4aa40c));


        // row of 3 big buttons
        JPanel buttonRow = new JPanel();
        buttonRow.setOpaque(false);
        buttonRow.add(tutorialButton);
        buttonRow.add(menuButton);
        buttonRow.add(exitButton);

        // row of 3 small buttons
        JPanel smallRow = new JPanel(new FlowLayout(FlowLayout.CENTER, -50, 0));   // 0 gap between buttons
        smallRow.setOpaque(false);
        smallRow.add(helpButton);
        smallRow.add(infoButton);
        smallRow.add(settingsButton);

        // everything top to bottom
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(300, 0, 75, 0));  
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        startButton.setAlignmentX(0.5f);     //  centers each item in the stack
        buttonRow.setAlignmentX(0.5f);      
        smallRow.setAlignmentX(0.5f);        

        startButton.setAlignmentY(-50.5f);   


        buttonPanel.add(startButton);       
        buttonPanel.add(buttonRow);         
        buttonPanel.add(smallRow);          

        gifLabel.add(buttonPanel);          
    
        // Back button 
        JButton backButton = new JButton("\u2190");
        backButton.setFont(new Font("Arial", Font.BOLD, 30));
        backButton.setForeground(new Color(0x4aa40c));
        backButton.setContentAreaFilled(false);
        backButton.setBorderPainted(false);

        backButton.addActionListener(e -> {
        frame.getContentPane().removeAll();
        frame.setLayout(new BorderLayout());
        frame.add(gifLabel, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
        });

        startButton.addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.setLayout(null);
            backButton.setBounds(10, 13, 120, 60);           // upper left corner
            frame.add(backButton);   // add the button FIRST so it shows on top of the picture

            frame.revalidate();
            frame.repaint();
        });

        exitButton.addActionListener(e -> System.exit(0));   // Exit closes the game

        frame.setVisible(true);   // once, at the end
    }
}