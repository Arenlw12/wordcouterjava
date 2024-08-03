package WordCounterProject;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new WordCounter().setVisible(true));
    }
}
