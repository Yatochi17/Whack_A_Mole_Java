import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Time;
import java.util.Random;
import java.util.random.*;



public class WhackAMole {

    int boardWidth = 600;
    int boardHeight = 650;

    JFrame frame = new JFrame("Whack A Mole");
    JLabel txtLabel = new JLabel();
    JPanel txtPanel = new JPanel();
    JPanel boardPanel = new JPanel();

    JButton[] board = new JButton[9];
    ImageIcon mole;
    ImageIcon scorpio;

    JButton currentMoleTile;
    JButton currentScorpioTie;

    Random random = new Random();
    Timer setMoleTimer;
    Timer setScorpioTimer;

    WhackAMole() {
        //frame.setVisible(true);
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

        Image scorpioImg = new ImageIcon(getClass().getResource("Image/Scorpion.jpg")).getImage();
        scorpio = new ImageIcon(scorpioImg.getScaledInstance(150, 150, Image.SCALE_SMOOTH));

        Image moleImg = new ImageIcon(getClass().getResource("Image/mole.jpeg")).getImage();
        mole = new ImageIcon(moleImg.getScaledInstance(150, 150, Image.SCALE_SMOOTH));

        for (int i = 0; i < 9; i++){
            JButton tile = new JButton();
            board[i] = tile;
            boardPanel.add(tile);
            tile.setFocusable(false);
            //tile.setIcon(mole);
        }

        frame.setVisible(true);
    }
}