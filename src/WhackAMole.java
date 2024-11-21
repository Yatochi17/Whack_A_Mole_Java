import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.random.*;



public class WhackAMole {

    int boardWidth = 600;
    int boardHeight = 650;

    JFrame frame = new JFrame("Whack A Mole");
    JLabel txtLabel = new JLabel();
    JPanel txtPanel = new JPanel();
    JPanel boardPanel = new JPanel();

    WhackAMole() {
        frame.setVisible(true);
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        txtLabel.setFont(new Font("Monospaced", Font.BOLD, 50));
        txtLabel.setHorizontalAlignment(JLabel.CENTER);
        txtLabel.setText("Score: 0");
        txtLabel.setOpaque(true);

        txtPanel.setLayout(new BorderLayout());
        txtPanel.add(txtLabel);
        frame.add(txtPanel, BorderLayout.NORTH);

        boardPanel.setLayout(new GridLayout(3,3) );
        boardPanel.setBackground(Color.ORANGE);
        frame.add(boardPanel);

    }
}