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
        getContentPane().setLayout(new FlowLayout());
        JLabel label = new JLabel("Text-Only Label");
        label.setFont(new Font("Serif", Font.PLAIN, 36));
        getContentPane().add(label);
        setSize(230, 230);  //  or whatever size you want
        //  Place Frame in middle of Screen
        setLocationRelativeTo(null);
        setVisible(true);
        g = getGraphics();

        run();
    }


    public void run(){
        //Clock clock = new Clock();
        alarm = new AlarmClock();
        alarm.setAlarm(0, 10);
        alarm.turnOn();

        for(int i = 0; true ; i++){
            try{
                Thread.sleep(500);
            }catch(Exception e){

            }
            repaint();
            update(g);
        }
    }

    @Override
    public void update(Graphics g) {
        alarm.timeTick();
        if(alarm.isTriggered())
            alarm.turnOff();
        paint(g);
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(alarm.getTime(), 0, 0);
    }
}
