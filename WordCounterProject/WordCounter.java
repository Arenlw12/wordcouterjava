package WordCounterProject;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class WordCounter extends JFrame {

    private JTextArea textArea;
    private JLabel wordCountLabel;
    private JLabel charCountLabel;

    public WordCounter() {
        createView();

        setTitle("Word Counter");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        setIcon();
    }

    private void createView() {
        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateCounts();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateCounts();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateCounts();
            }
        });
        JPanel resultPanel = new JPanel();
        panel.add(resultPanel, BorderLayout.SOUTH);

        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        wordCountLabel = new JLabel("Word count: 0");
        resultPanel.add(wordCountLabel);

        charCountLabel = new JLabel("Character count: 0");
        resultPanel.add(charCountLabel);
    }

    private void updateCounts() {
        String text = textArea.getText();
        int wordCount = WordCounterConsole.wordCount(text);
        int charCount = WordCounterConsole.characterCount(text);
        wordCountLabel.setText("Word count: " + wordCount);
        charCountLabel.setText("Character count: " + charCount);
    }

    private void setIcon() {
        ImageIcon icon = new ImageIcon(getClass().getResource("189816.jpg"));
        Image image = icon.getImage();
        setIconImage(image);
    }
}
