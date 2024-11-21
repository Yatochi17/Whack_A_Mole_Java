import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.random.*;



public class WhackAMole {

    int boardWith = 600;
    int boardHeight = 650;

    JFrame frame = new JFrame("Whack A Mole");

    WhackAMole() {
        frame.setVisible(true);
        frame.setSize(boardWith, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
    }
}