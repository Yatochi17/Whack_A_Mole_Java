import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;


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
    JButton currentScorpioTile;

    Random random = new Random();
    Timer setMoleTimer;
    Timer setScorpioTimer;
    int score = 0;

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

            tile.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                JButton tile = (JButton) e.getSource();
                if (tile == currentMoleTile){
                    score += 10;
                    txtLabel.setText("Score: " + Integer.toString(score));
                }
                else if (tile == currentScorpioTile){
                    txtLabel.setText("Final Score: " + Integer.toString(score));
                    setMoleTimer.stop();
                    setScorpioTimer.stop();

                for (int i = 0; i < 9; i++){
                    board[i].setEnabled(false);
                }
                }
                }
            });
        }

        setMoleTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //remove mole from current tile
                if (currentMoleTile != null){
                    currentMoleTile.setIcon(null);
                    currentMoleTile = null;
                }
                //random select another tile
                int num = random.nextInt(9); //0-8
                JButton tile = board[num];
                //if tile occupied, skip tile
                if (currentMoleTile == tile) return;
                //set tile to mole
                currentMoleTile = tile;
                currentMoleTile.setIcon(mole);
            }
        });

        setScorpioTimer = new Timer(1500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //remove scorpio from current tile
                if (currentScorpioTile != null){
                    currentScorpioTile.setIcon(null);
                    currentScorpioTile = null;
                }
                //random select another tile
                int num = random.nextInt(9); //0-8
                JButton tile = board[num];
                //if tile occupied, skip tile
                if (currentMoleTile == tile) return;
                //set tile to scorpio
                currentScorpioTile = tile;
                currentScorpioTile.setIcon(scorpio);
            }
        });

        setMoleTimer.start();
        setScorpioTimer.start();
        frame.setVisible(true);
    }
}