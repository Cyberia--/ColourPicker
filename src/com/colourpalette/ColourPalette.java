package com.colourpalette;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class ColourPalette extends JFrame {

	public static void main(String[] args) {

		ColourPalette art = new ColourPalette();
		art.setTitle("HSV ColourWheel");
		art.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		art.setSize(650, 670);

		HSVColourWheel artPanel = new HSVColourWheel();
		art.add(artPanel);

		art.addComponentListener(new ComponentListener() {

			public void componentResized(ComponentEvent e) {
				artPanel.setHeight(art.getContentPane().getHeight());
				artPanel.setWidth(art.getContentPane().getWidth());
			}

			public void componentHidden(ComponentEvent e) {}
			public void componentMoved(ComponentEvent e) {}
			public void componentShown(ComponentEvent e) {}
		});

		art.setVisible(true);

	}

}




/*
 * 	public Color getColor(int i, int j){

		Color c = new Color(0,0,0);


		int r = 0;
		int g = 0;
		int b = 0;


		r = (j - i);
		g =  (255-i) + (255-j);
		b = i;


		if (r > 255) r = 255;
		if (r < 0) r = 0;

		if (g > 255) g = 255;
		if (g < 0) g = 0;

		if (b > 255) b = 255;
		if (b < 0) b = 0;


		return new Color(r, g, b).getHSBColor(i, i, j);

	}

	public Color getCrazy(int i, int j){

		Color c = new Color(0,0,0);


		int r = 0;
		int g = 0;
		int b = 0;


		r = (j - i);
		g =  (255-i) + (255-j);
		b = i;


		if (r > 255) r = 255;
		if (r < 0) r = 0;

		if (g > 255) g = 255;
		if (g < 0) g = 0;

		if (b > 255) b = 255;
		if (b < 0) b = 0;


		return new Color(r, g, b).getHSBColor(i, i, j);

	}

	public Color getColorRedGreen(int i, int j){

		if (i > 255) i = 0;
		if (j > 255) j = 0;

		return new Color(j, 255-i, 0);

	}
 */

/*
 * public Color getColor(int x, int y){

		if (x > 255) x = 0;
		if (y > 255) y = 0;

		return new Color((264 % (y + 1) ), 0, y);
	}

 */