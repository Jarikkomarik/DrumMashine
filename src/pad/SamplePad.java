//final
package pad;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
//import java.io.FileInputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class SamplePad implements KeyListener  {
   
    //PlaySound p;
    Clip clip;
    public static void main (String []args){
        new SamplePad().getGui();
    }
 
    
    public void getGui(){                                               //creates Gui WithBottons
       JFrame frame=new JFrame("TRAP_MAISHINE"); 
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       JPanel panel=new JPanel();
        panel.setBackground(Color.BLACK);
        JPanel stopB=new JPanel();
        stopB.setBackground(Color.BLACK);
        stopB.setSize(500,50);
        frame.addKeyListener(this);

        GridLayout grid=new GridLayout(3,2);

                
                                                                        //creating buttons
        JButton kick=new JButton("Kick (Q)");
        kick.setFocusable(false);
        kick.setPreferredSize(new Dimension(80, 80));
        kick.addActionListener(e -> getSound("SOUND_KICK"));

        JButton snare=new JButton("Snare (A)");
        snare.setFocusable(false);
        snare.addActionListener(e -> getSound("SNARE"));

        JButton clap=new JButton("Clap (Z)");
        clap.setFocusable(false);
        clap.addActionListener(e -> getSound("CLAP"));

        JButton ClosedHat=new JButton("C/Hi-Hat (W)");
        ClosedHat.setFocusable(false);
        ClosedHat.addActionListener(e -> getSound("CHAT"));

        JButton openHat=new JButton("O/Hi-Hat (S)");
        openHat.setFocusable(false);
        openHat.addActionListener(e -> getSound("OHAT"));

        JButton crash=new JButton("Crash (X)");
        crash.setFocusable(false);
        crash.addActionListener(e -> getSound("CRASH"));

        JButton base808=new JButton("808 (E)");
        base808.setFocusable(false);
        base808.addActionListener(e -> getSound("808"));

        JButton melody1=new JButton("melody1 (D)");
        melody1.setFocusable(false);
        melody1.addActionListener(e-> {try {clip.stop();} catch(NullPointerException exp){} getLoopedSound("MELODY1");});

        JButton melody2=new JButton("melody2 (C)");
        melody2.setFocusable(false);
        melody2.addActionListener(e-> {try {clip.stop();} catch(NullPointerException exp){} getLoopedSound("MELODY2");});

        JButton Stop=new JButton("Stop");
        Stop.setFocusable(false);
        Stop.setPreferredSize(new Dimension(500, 50));
        Stop.addActionListener(e-> {try {clip.stop();} catch(NullPointerException exp){} });

        //adding buttons to boxes
        panel.add(kick);
        panel.add(ClosedHat);
        panel.add(base808);

        panel.add(snare);
        panel.add(openHat);
        panel.add(melody1);

        panel.add(clap);
        panel.add(crash);
        panel.add(melody2);

        panel.setLayout(grid);
                                                                        //adding boxes to panel

       stopB.add(Stop);
        frame.add(panel,BorderLayout.CENTER);
       frame.add(stopB,BorderLayout.SOUTH);                                                                //running pannel
        //frame.add(new JSeparator(), BorderLayout.CENTER);

       frame.setSize(500, 500);
       frame.setVisible(true);
    }



        @Override
        public void keyTyped(KeyEvent e) {

            char charPressed = e.getKeyChar();
            switch (charPressed) {
                case 'q':
                    //System.out.println("Q is pressed");
                    getSound("SOUND_KICK");
                    break;
                case 'w':
                    //System.out.println("W is pressed");
                    getSound("CHAT");
                    break;
                case 'e':
                    //System.out.println("E is pressed");
                    getSound("808");
                    break;
                case 'a':
                    //System.out.println("A is pressed");
                    getSound("SNARE");
                    break;
                case 's':
                    //System.out.println("S is pressed");
                    getSound("OHAT");
                    break;
                case 'd':
                    //System.out.println("D is pressed");
                    try {clip.stop();} catch(NullPointerException exp){} getLoopedSound("MELODY1");
                    break;
                case 'z':
                    //System.out.println("Y is pressed");
                    getSound("Clap");
                    break;
                case 'x':
                    //System.out.println("X is pressed");
                    getSound("Crash");
                    break;
                case 'c':
                    //System.out.println("C is pressed");
                    try {clip.stop();} catch(NullPointerException exp){} getLoopedSound("MELODY2");
                    break;

            }
        }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    public static void getSound(String filename){
     
    try{
        File file=new File("sounds/"+filename+".wav");
        AudioInputStream audioStream= AudioSystem.getAudioInputStream(file);
        Clip clip1 = AudioSystem.getClip();
        clip1.open(audioStream);
        clip1.start();
        
        }
        catch(Exception e){
            System.out.println("Exception in GetSound Method");
        }
    }
    
    public void getLoopedSound(String filename){
     
    try{
        File file=new File("sounds/"+filename+".wav");
        AudioInputStream audioStream= AudioSystem.getAudioInputStream(file);
        clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
        catch(Exception e){
            System.out.println("Exception in GetLoopedSound Method");
        }
    }
    
   
   
}


