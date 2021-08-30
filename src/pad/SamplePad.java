//now on github
package pad;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
//import java.io.FileInputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class SamplePad {
   
    //PlaySound p;
    Clip clip;
    public static void main (String []args){
        new SamplePad().getGui();
    }
 
    
    public void getGui(){                                               //creates Gui WithBottons
       JFrame frame=new JFrame("TRAP_MAISHINE"); 
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       JPanel panel=new JPanel();
                panel.setBackground(Color.gray);
                                                                        //creating boxes
       Box buttonBoxL = new Box(BoxLayout.Y_AXIS);
       Box buttonBoxC = new Box(BoxLayout.Y_AXIS);
       Box buttonBoxR = new Box(BoxLayout.Y_AXIS);
                
                
                                                                        //creating buttons
       JButton kick=new JButton("Kick");
                kick.setPreferredSize(new Dimension(80, 80));
                kick.addActionListener(e -> getSound("SOUND_KICK"));
                
       JButton snare=new JButton("Snare");
                snare.setPreferredSize(new Dimension(80, 80));
                snare.addActionListener(e -> getSound("SNARE"));
                
       JButton clap=new JButton("Clap");
                clap.setPreferredSize(new Dimension(80, 80));
                clap.addActionListener(e -> getSound("CLAP"));
                
       JButton ClosedHat=new JButton("C/Hi-Hat");
                ClosedHat.setPreferredSize(new Dimension(80, 80));
                ClosedHat.addActionListener(e -> getSound("CHAT"));
                
       JButton openHat=new JButton("O/Hi-Hat");
                openHat.setPreferredSize(new Dimension(80, 80));
                openHat.addActionListener(e -> getSound("OHAT"));
                
       JButton crash=new JButton("Crash");
                crash.setPreferredSize(new Dimension(80, 80));
                crash.addActionListener(e -> getSound("CRASH"));
                
       JButton base808=new JButton("808");
                base808.setPreferredSize(new Dimension(80, 80));
                base808.addActionListener(e -> getSound("808"));
                
       JButton melody1=new JButton("melody1");
                melody1.setPreferredSize(new Dimension(80, 80));
                melody1.addActionListener(e-> {try {clip.stop();} catch(NullPointerException exp){} getLoopedSound("MELODY1");});
                
       JButton melody2=new JButton("melody2");
                melody2.setPreferredSize(new Dimension(80, 80));
                melody2.addActionListener(e-> {try {clip.stop();} catch(NullPointerException exp){} getLoopedSound("MELODY2");});

        JButton Stop=new JButton("Stop");
                Stop.setPreferredSize(new Dimension(80, 80));
                Stop.addActionListener(e->clip.stop());
                
                                                                        //adding buttons to boxes
       
       buttonBoxL.add(kick);
       buttonBoxL.add(snare);
       buttonBoxL.add(clap);
       
       buttonBoxC.add(ClosedHat);
       buttonBoxC.add(openHat);
       buttonBoxC.add(crash);
       
       buttonBoxR.add(base808);
       buttonBoxR.add(melody1);
       buttonBoxR.add(melody2);
                                                                        //adding boxes to panel
       panel.add(BorderLayout.WEST,buttonBoxL);
       panel.add(BorderLayout.CENTER,buttonBoxC);
       panel.add(BorderLayout.EAST,buttonBoxR);
       panel.add(Stop);
       
                                                                        //running pannel
       frame.add(panel);
       frame.setSize(500, 500);
       frame.setVisible(true);
    }
 
    
   public void getSound(String filename){
     
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


