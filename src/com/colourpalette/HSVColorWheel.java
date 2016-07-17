package com.colourpalette;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

@SuppressWarnings("serial")
class HSVColourWheel extends JPanel{

	// Settings
	public int width = 0;
	public int height = 0;

	int circle_radius = 300;
	int circle_pos_x = 10;
	int circle_pos_y = 10;
	
	// To be set on draw
	int center_x = 0;
	int center_y = 0;
	
	public HSVColourWheel() {
		this.setBackground(Color.white);	
	}

	public void setHeight(int height) {
		this.height = height;
		center_y = height / 2;
	}

	public void setWidth(int width){
		this.width = width;
		center_x = width / 2;
	}

	int square_size = circle_radius * 2;
	Point circle_center = new Point(circle_pos_x + circle_radius, circle_pos_y + circle_radius);
	private static final int DEGREES_IN_CIRCLE = 360;
	
	public void paint(Graphics g){
		super.paint(g);

		drawHSVColourWheel(g);
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		this.repaint();
	}
	
	// originally circle_radius
	float circrad = 0f;
	
	/**
	 * Draw a standard HSV color wheel
	 * https://en.wikipedia.org/wiki/HSL_and_HSV#/media/File:Hsl-hsv-colorpickers.svg
	 */
	private void drawHSVColourWheel(Graphics g){
		
		// draw a square point by point
		// define a circle within the square via a radius value
		// fill the square where the current point is within this radius
		
		// 
		
		
		// draw a square
		for (int i = 0; i < square_size; i++) {
			for (int j = 0; j < square_size; j++) {
				
				// define the centre point of the square (+ square position)
				Point pointInSquare = new Point(circle_pos_x + i, circle_pos_y + j);
						
				// get the distance between the current point and the centre
				float vectDist = getVectDist(circle_center, pointInSquare);
				
				// if the distance is less than the circle radius don't draw the point
				if (vectDist < circle_radius){	
					
					// get the angle between the current point and the centre
					float color =  getAngle(circle_center, pointInSquare) / DEGREES_IN_CIRCLE;
					
					// cool effects
					// vectDist/1
					// (vectDist/j-i)
					
					// set the colour and saturation
					g.setColor(Color.getHSBColor(color, (vectDist/j-i), 1));
					
					circrad += 0.0000001f;
					
//					System.out.println(circrad);
					
					// draw the point with it's new colour value
					drawPoint(g, pointInSquare.x, pointInSquare.y);
				}
			}
		}
	}
	
	/**
	 * Get angle between two points
	 */
	public final float getAngle(Point p1, Point p2){
		float angle = (float) Math.toDegrees(Math.atan2(p2.y - p1.y, p2.x - p1.x));

	    if(angle < 0){
	        angle += 360;
	    }

	    return angle;
	}
	
	/**
	 * Get vector distance between two points
	 */
	public final int getVectDist(Point center, Point p){
		return (int) Math.sqrt(Math.pow((p.getX() - center.getX()), 2) + Math.pow((p.getY() - center.getY()), 2)) ;
	}

	/**
	 * Draw a single point 
	 */
	public void drawPoint(Graphics g, int x, int y){
		g.drawLine(x, y, x, y);
	}
}
