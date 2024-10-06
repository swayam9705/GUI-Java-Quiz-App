import javax.swing.*;
import java.awt.*;

public class QuizOver extends Frame {

    JPanel container;
    JLabel quizOver;
    JLabel score;
    JButton retake;

    QuizOver(int points) {

        container = new JPanel();
        container.setLayout(null);
        container.setBounds((Var.FRAME_WIDTH - Var.QUE_CONTAINER_WIDTH) / 2, (Var.FRAME_HEIGHT - Var.QUE_CONTAINER_HEIGHT) / 2, Var.QUE_CONTAINER_WIDTH, Var.QUE_CONTAINER_HEIGHT / 2);
        container.setBackground(new Color(70, 122, 207));
        this.add(container);


        quizOver = new JLabel("Quiz finished.");
        quizOver.setForeground(Color.WHITE);
        quizOver.setFont(new Font("Arial", Font.BOLD, 32));
        quizOver.setBounds(240, 50, 400, 100);
        container.add(quizOver);

        score = new JLabel("Your score: " + points + " / 10");
        score.setForeground(Color.WHITE);
        score.setBounds(220, 100, 400, 100);
        score.setFont(new Font("Arial", Font.BOLD, 28));
        container.add(score);

        retake = new JButton("Retake test");
        retake.setBounds(260, 200, 150, 40);
        retake.setFont(new Font("Arial", Font.PLAIN, 16));
        container.add(retake);

        retake.addActionListener(e -> {
            retakeTest();
        });
    }

    public void retakeTest() {
        new Questions();
    }
}
