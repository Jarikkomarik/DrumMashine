//now on github
package pad;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
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
                kick.addActionListener(new kickListener());
                
       JButton snare=new JButton("Snare");
                snare.setPreferredSize(new Dimension(80, 80));
                snare.addActionListener(new snareListener());
                
       JButton clap=new JButton("Clap");
                clap.setPreferredSize(new Dimension(80, 80));
                clap.addActionListener(new clapListener());
                
       JButton ClosedHat=new JButton("C/Hi-Hat");
                ClosedHat.setPreferredSize(new Dimension(80, 80));
                ClosedHat.addActionListener(new ClosedHatListener());
                
       JButton openHat=new JButton("O/Hi-Hat");
                openHat.setPreferredSize(new Dimension(80, 80));
                openHat.addActionListener(new openHatListener());
                
       JButton crash=new JButton("Crash");
                crash.setPreferredSize(new Dimension(80, 80));
                crash.addActionListener(new crashListener());
                
       JButton base808=new JButton("808");
                base808.setPreferredSize(new Dimension(80, 80));
                base808.addActionListener(new base808Listener());
                
       JButton melody1=new JButton("melody1");
                melody1.setPreferredSize(new Dimension(80, 80));
                melody1.addActionListener(new melody1Listener()); 
                
       JButton melody2=new JButton("melody2");
                melody2.setPreferredSize(new Dimension(80, 80));
                melody2.addActionListener(new melody2Listener());

       JButton Stop=new JButton("Stop");
                Stop.setPreferredSize(new Dimension(80, 80));
                Stop.addActionListener(new stopListener());
                
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
    
    
    class kickListener implements ActionListener{                      //run action for a button
        public void actionPerformed(ActionEvent event){
            
            getSound("SOUND_KICK");
        }
    }
    
    class snareListener implements ActionListener{                      //run action for a button
        public void actionPerformed(ActionEvent event){
            //System.out.println("kek");
            getSound("SNARE");
        }
    }
    class clapListener implements ActionListener{                      //run action for a button
        public void actionPerformed(ActionEvent event){
            //System.out.println("kek");
            getSound("CLAP");
        }
    }
    class ClosedHatListener implements ActionListener{                      //run action for a button
        public void actionPerformed(ActionEvent event){
            //System.out.println("kek");
            getSound("CHAT");
        }
    }
    class openHatListener implements ActionListener{                      //run action for a button
        public void actionPerformed(ActionEvent event){
            //System.out.println("kek");
            getSound("OHAT");
        }
    }
    class crashListener implements ActionListener{                      //run action for a button
        public void actionPerformed(ActionEvent event){
            
            getSound("CRASH");
        }
    }
    class base808Listener implements ActionListener{                      //run action for a button
        public void actionPerformed(ActionEvent event){
            
            getSound("808");
            
        }
    }
    class melody1Listener implements ActionListener{                      //run action for a button
        public void actionPerformed(ActionEvent event){
            //System.out.println("kek");
            try{clip.stop();}catch(Exception e){}
            getLoopedSound("MELODY1");
            
        }
    }
    class melody2Listener implements ActionListener{                      //run action for a button
        public void actionPerformed(ActionEvent event){
            //System.out.println("kek");
             try{clip.stop();}catch(Exception e){}
            getLoopedSound("MELODY2");
          
            //p=new PlaySound("sounds/MELODY1.wav");
            //System.out.println("kek");
            //p.play();
            //p.loop();
            
            
        }
    }
    class stopListener implements ActionListener{                      //run action for a button
        public void actionPerformed(ActionEvent event){
            
            
            clip.stop();
        }
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


