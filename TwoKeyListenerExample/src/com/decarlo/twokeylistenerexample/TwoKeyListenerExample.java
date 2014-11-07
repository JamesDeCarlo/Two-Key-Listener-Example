package com.decarlo.twokeylistenerexample;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * This Class is an example of two keys being pressed. In this example we use
 * shift+enter. But can be modified for any key combinations including 3 key
 * combinations or more.
 *
 * @author James DeCarlo
 */
public class TwoKeyListenerExample extends JFrame implements KeyListener {

    private static boolean shiftPressed = false;
    private final JLabel label;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TwoKeyListenerExample tb = new TwoKeyListenerExample();
        tb.setVisible(true);
    }

    @SuppressWarnings("LeakingThisInConstructor")
    public TwoKeyListenerExample() {
        super("Two Button Listener Example");

        this.setSize(300, 200);
        this.setLocation(100, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label = new JLabel("  Press enter or shift+enter");
        this.addKeyListener(this);

        this.add(label, BorderLayout.CENTER);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
            shiftPressed = true;
        } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (shiftPressed) {
                this.label.setText("  Shift + Enter Pressed");
            } else {
                this.label.setText("  Enter Pressed");
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
            shiftPressed = false;
        } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            this.label.setText("  Press enter or shift+enter");
        }
    }

}
