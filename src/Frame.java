import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Frame extends JFrame {
    JButton button;
    JLabel title;

    Frame() {
        this.setTitle("OOP Mini Project:- A Quiz App");
        this.setSize(Var.FRAME_WIDTH, Var.FRAME_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setVisible(true);
        this.setLayout(null);
    }
}
