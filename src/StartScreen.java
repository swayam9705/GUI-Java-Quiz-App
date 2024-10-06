import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class StartScreen extends Frame {

    JLabel title;
    JButton button;

    StartScreen() {
        // title label
        title = new JLabel("OOP Mini Project:- A Quiz App");
        title.setBounds(230, 200, 700, 150);
        title.setFont(new Font("Arial", Font.BOLD, 32));
        this.add(title);

        // start quiz butotn
        button = new JButton("START QUIZ");
        button.setBounds((Var.FRAME_WIDTH - Var.START_BUTTON_WIDTH) / 2, (Var.FRAME_HEIGHT - Var.START_BUTTON_HEIGHT) / 2, Var.START_BUTTON_WIDTH, Var.START_BUTTON_HEIGHT);
        button.addActionListener(e -> {
            this.dispose();
            new Questions();
        });
        button.setBackground(new Color(0x85a9f9));
        button.setFont(new Font("Arial", Font.PLAIN, 24));
        button.setBorder(BorderFactory.createEtchedBorder());
        button.setForeground(Color.white);
        this.add(button);
    }
}
