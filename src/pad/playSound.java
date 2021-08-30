/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pad;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class playSound {
    private Clip clip;
    public playSound(String fileName) {
        // specify the sound to play
        // (assuming the sound can be played by the audio system)
        // from a wave File
        try {
            File file = new File(fileName);
            if (file.exists()) {
                AudioInputStream sound = AudioSystem.getAudioInputStream(file);
             // load the sound into memory (a Clip)
                clip = AudioSystem.getClip();
                clip.open(sound);
            }
            else {
                throw new RuntimeException("Sound: file not found: " + fileName);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Sound: Malformed URL: " + e);
        }
        

    // play, stop, loop the sound clip
    }
    public void play(){
        clip.setFramePosition(0);  // Must always rewind!
        clip.start();
    }
    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop(){
            clip.stop();
        }
    }

    class testRun {
        public static void main(String []args){

            playSound ter=new playSound("sounds/MELODY1.wav");
            ter.play();
            System.out.println(":EE");
            ter.loop();

            JFrame frame=new JFrame();
            JButton stop=new JButton("stop");
            stop.addActionListener(e -> {
                // whatever you need to do
                ter.stop();
                System.out.println("The button was pressed!");
            });

            frame.add(stop);
            frame.setSize(100, 100);
            frame.setVisible(true);
        }
        class stopListener implements ActionListener{                      //run action for a button
            public void actionPerformed(ActionEvent event){
                //System.out.println("kek");
                  
            }
        }
    }

