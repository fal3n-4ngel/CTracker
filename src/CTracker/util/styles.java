package CTracker.util;

import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Component;


public class styles implements Border {
        
	int radius;
    int col;
	
	public styles(int radius,int col) {
		this.radius = radius;
        this.col=col;
	}
	@Override
	public Insets getBorderInsets(Component c) {
		return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
	}

	@Override
	public boolean isBorderOpaque() {
		return true;
	}

	@Override
	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.setColor(new Color(col));
		g.drawRoundRect(x,y,width-1,height-1,radius,radius);
        g.fillRoundRect(x,y,width-1,height-1,radius,radius);
	}
}