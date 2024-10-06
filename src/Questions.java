import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Questions extends Frame {

    String[] questions = {
        "What is the capital of India?",
        "Who painted the Mona Lisa?",
        "Which planet is known as the Red Planet?",
        "What is the largest mammal on Earth?",
        "Whos is the author of the Harry Potter series?",
        "What is the chemical symbol for gold?",
        "Which country won the 2022 FIFA World Cup?",
        "What is the largest ocean in the world?",
        "Which animal is known as the king of the jungle?",
        "Who wrote the play 'Romeo and Juliet'?"
    };

    String[][] options = {
        {"Delhi", "Mumbai", "Kolkata", "Chennai"},
        {"Leonardo da Vinci", "Michelangelo", "Raphael", "Rembrandt"},
        {"Earth", "Mars", "Jupiter", "Saturn"},
        {"Elephant", "Blue Whale", "Giraffe", "Hippopotamus"},
        {"J. K. Rowling", "Stephen King", "Dan Brown", "George Orwell"},
        {"Au", "Ag", "Fe", "Cu"},
        {"Atlantic", "Pacific", "Indian", "Arctic"},
        {"Argentina", "France", "Brazil", "Germany"},
        {"Lion", "Tiger", "Elephant", "Gorilla"},
        {"William Shakespeare", "Jane Austen", "Charles Dickens", "Mark Twain"}
    };

    String[] answers = {
        "Delhi",
        "Leonardo da Vinci",
        "Mars",
        "Blue Whale",
        "J.K. Rowling",
        "Au",
        "Argentina",
        "Pacific",
        "Lion",
        "William Shakespeare"
    };

    String[] usersAnswers;

    int questionIndex = 0;

    JPanel container;
    JPanel qContainer;
    JLabel question;
    JPanel optionsContainer;
    ButtonGroup radioGroup;
    JRadioButton op1, op2, op3, op4;
    JRadioButton selected;
    JPanel navContainer;
    JButton prev, next;
    JButton submit;

    Questions() {
        // container
        container = new JPanel();
        container.setLayout(null);
        container.setBounds((Var.FRAME_WIDTH - Var.QUE_CONTAINER_WIDTH) / 2, (Var.FRAME_HEIGHT - Var.QUE_CONTAINER_HEIGHT) / 2, Var.QUE_CONTAINER_WIDTH, Var.QUE_CONTAINER_HEIGHT);
        container.setBackground(new Color(139, 170, 220));
        this.add(container);

        // question container
        qContainer = new JPanel();
        qContainer.setLayout(null);
        qContainer.setBounds(0, 0, Var.QUE_CONTAINER_WIDTH, Var.QUE_HEIGHT);
        qContainer.setBackground(new Color(70, 122, 207));
        container.add(qContainer);

        // question
        question = new JLabel("Q" + (questionIndex + (int)1) + ". " + questions[questionIndex]);
        question.setFont(new Font("Arial", Font.PLAIN, 20));
        question.setAlignmentX(JLabel.CENTER);
        question.setAlignmentY(JLabel.CENTER);
        question.setBounds(40, 0, Var.QUE_CONTAINER_WIDTH, Var.QUE_HEIGHT);
        question.setForeground(Color.WHITE);
        qContainer.add(question);

        // options container
        optionsContainer = new JPanel();
        optionsContainer.setLayout(new GridLayout(4, 1));
        optionsContainer.setBackground(new Color(139, 170, 220));
        optionsContainer.setBounds((Var.QUE_CONTAINER_WIDTH - Var.OPTION_CONTAINER_WIDTH) / 2, (Var.QUE_HEIGHT + 10), Var.OPTION_CONTAINER_WIDTH, Var.OPTION_CONTAINER_HEIGHT);
        container.add(optionsContainer);

        // options

        radioGroup = new ButtonGroup();

        ////////////////////////
        op1 = new JRadioButton(options[questionIndex][0]);
        this.styleOptionButton(op1);

        op2 = new JRadioButton(options[questionIndex][1]);
        this.styleOptionButton(op2);

        op3 = new JRadioButton(options[questionIndex][1]);
        this.styleOptionButton(op3);

        op4 = new JRadioButton(options[questionIndex][2]);
        this.styleOptionButton(op4);

        optionsContainer.add(op1);
        optionsContainer.add(op2);
        optionsContainer.add(op3);
        optionsContainer.add(op4);
        ////////////////////////

        ////////////////////////
        // Navigations container
        navContainer = new JPanel();
        navContainer.setLayout(new GridLayout(1, 2));
        navContainer.setBounds((Var.QUE_CONTAINER_WIDTH - 2 * Var.NAV_BUTTON_DIM) / 2, (Var.QUE_HEIGHT + Var.OPTION_CONTAINER_HEIGHT + 20), 2 * Var.NAV_BUTTON_DIM, Var.NAV_BUTTON_DIM);
        navContainer.setBackground(Color.WHITE);
        container.add(navContainer);

        // prev button
        prev = new JButton("<");
        prev.setFont(new Font("Arial", Font.PLAIN, 25));
        prev.setEnabled(false);
        navContainer.add(prev);

        prev.addActionListener(e -> {
            displayPrev();
        });

        // next button
        next = new JButton(">");
        next.setFont(new Font("Arial", Font.PLAIN, 25));
        navContainer.add(next);

        next.addActionListener(e -> {
            displayNext();
        });

        ///////////////////////

        // submit button
        submit = new JButton("Submit");
        submit.setBounds((Var.QUE_CONTAINER_WIDTH - Var.SUBMIT_BUTTON_WIDTH) / 2, (Var.QUE_HEIGHT + Var.OPTION_CONTAINER_HEIGHT + Var.SUBMIT_BUTTON_HEIGHT + 50), Var.SUBMIT_BUTTON_WIDTH, Var.SUBMIT_BUTTON_HEIGHT);
        submit.setEnabled(false);
        container.add(submit);
    }


    // ---- methods ---- //

    public void styleOptionButton(JRadioButton btn) {
        btn.setBackground(new Color(139, 170, 220));
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Arial", Font.PLAIN, 20));
        btn.setBorder(BorderFactory.createEtchedBorder());
        radioGroup.add(btn);
    }

    public void displayNext() {

        if (questionIndex < questions.length - 1) {

            if (op1.isSelected()) {
                usersAnswers[questionIndex] = op1.getText();
            }
            else if (op2.isSelected()) {
                usersAnswers[questionIndex] = op2.getText();
            }
            else if (op2.isSelected()) {
                usersAnswers[questionIndex] = op3.getText();
            }
            else if (op3.isSelected()) {
                usersAnswers[questionIndex] = op4.getText();
            }

            questionIndex++;
            question.setText("Q" + (questionIndex + (int)1) + ". " + questions[questionIndex]);
            op1.setText(options[questionIndex][0]);
            op2.setText(options[questionIndex][1]);
            op3.setText(options[questionIndex][2]);
            op4.setText(options[questionIndex][3]);
            prev.setEnabled(true);

            if (questionIndex == questions.length - 1) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
        }
    }

    public void displayPrev() {
        if (questionIndex > 0) {
            questionIndex--;
            question.setText("Q" + (questionIndex + (int)1) + ". " + questions[questionIndex]);
            op1.setText(options[questionIndex][0]);
            op2.setText(options[questionIndex][1]);
            op3.setText(options[questionIndex][2]);
            op4.setText(options[questionIndex][3]);
            next.setEnabled(true);
            
            if (questionIndex == 0) {
                prev.setEnabled(false);
            }
        }
    }
}

