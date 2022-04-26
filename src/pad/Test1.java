package pad;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Test1 implements KeyListener {
    JFrame frame;

    void Test11(){
        frame=new JFrame();
        JPanel p= new JPanel();
        JButton b1=new JButton();
        JButton b2=new JButton();
        b1.setFocusable(false);
        b2.setFocusable(false);
        frame.addKeyListener(this);
        p.add(b2);
        p.add(b1);
        frame.add(p);
        frame.setSize(100,100);
        frame.setVisible(true);
    }
    public static void main(String []args){
        Test1 t =new Test1();
        t.Test11();
    }

    @Override
    public void keyTyped(KeyEvent e) {

        char charPressed=e.getKeyChar();
        switch(charPressed) {
            case 'q':
                System.out.println("Q is pressed");
                break;


        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
