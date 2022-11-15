package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame();
    private final int PROPORTION = 5;

    public SimpleGUI() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        JTextArea jt = new JTextArea();
        JButton saveBtn = new JButton("Save");
        frame.setLayout(new BorderLayout());
        frame.add(saveBtn, BorderLayout.SOUTH);
        frame.add(jt, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*Handlers*/
        Controller c = new Controller("output.txt");
        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                int n = JOptionPane.showConfirmDialog(frame, "Do you want to save the file?", "Saving", JOptionPane.YES_NO_OPTION);
                if (n == JOptionPane.YES_OPTION) {
                    try {
                        c.writeOnFile(jt.getText());
                    } catch (IOException e) {
                        System.out.println("Errore: " + e.getMessage());
                    }
                }
            }
        });
    }

    private void Display() {
        frame.setVisible(true);
    }
}
