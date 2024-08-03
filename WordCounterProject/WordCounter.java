package WordCounterProject;

import javax.swing.*;
import java.awt.*;

public class WordCounter extends JFrame {

    private JTextArea textArea;
    private JButton countCharactersButton;
    private JLabel resultLabel;

    public WordCounter() {
        createView();

        setTitle("Text Counter");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void createView() {
        JPanel panel = new JPanel();
        getContentPane().add(panel);

        panel.setLayout(new BorderLayout());

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        panel.add(buttonPanel, BorderLayout.SOUTH);

        JButton countWordsButton = new JButton("Count Words");
        countWordsButton.addActionListener(e -> {
            int wordCount = WordCounterConsole.wordCount(textArea.getText());
            resultLabel.setText("Word count: " + wordCount);
        });
        buttonPanel.add(countWordsButton);

        countCharactersButton = new JButton("Count Characters");
        countCharactersButton.addActionListener(e -> {
            int charCount = WordCounterConsole.characterCount(textArea.getText());
            resultLabel.setText("Character count: " + charCount);
        });
        buttonPanel.add(countCharactersButton);

        resultLabel = new JLabel(" ");
        panel.add(resultLabel, BorderLayout.NORTH);
    }
}
