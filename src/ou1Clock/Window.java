package ou1Clock;

import javax.swing.*;
import java.awt.*;

/**
 * Created by jocke on 3/23/2017.
 */
public class Window extends JFrame{
    AlarmClock alarm;
    Graphics g;


    public void init(){
        //  set Layout to whatever Layout Manager
        //  flowLayout, GridLayout, etc...
        try {
            alarm = new AlarmClock();
            alarm.setAlarm(0, 15);
        } catch (Exception e) {
            e.printStackTrace();
        }
        alarm.turnOn();


        //1. Create the frame.
        JFrame frame = new JFrame("FrameDemo");
        frame.getContentPane().setLayout(new FlowLayout());
        JLabel label = new JLabel("Text-Only Label");
        label.setFont(new Font("Serif", Font.PLAIN, 36));
        //frame.getContentPane().add(label);
        frame.setSize(230, 230);  //  or whatever size you want
        //  Place Frame in middle of Screen
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        g = frame.getGraphics();

        run();
    }


    public void run(){
        //Clock clock = new Clock();

        for(int i = 0; true ; i++){
            try{
                Thread.sleep(500);
                repaint();
                update(g);
            }catch(Exception e){

            }
        }
    }

    @Override
    public void update(Graphics g) {
        alarm.timeTick();
        paint(g);
    }

    @Override
    public void paint(Graphics g) {
        g.clearRect(0,0,1560,2460);
        g.setColor(Color.black);
        g.drawString(alarm.getTime(), 100, 100);
        g.drawRect(100, 100, 100, 100);
    }
}
