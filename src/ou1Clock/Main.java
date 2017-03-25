package ou1Clock;

import javax.swing.*;
import java.awt.*;

public class Main {

	public void paint(Graphics g){
		g.setColor(Color.black);
		g.drawString("Time", 0, 0);
	}

	public void update(Graphics g){
		paint(g);
	}
	public static void main(String[] args){
		Window window = new Window();
		window.init();
	}

}
