package com.ayush.ball2ball;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Ball1 {
	private static final int Y = 330;
	private static final int DIAMETER = 30;
	int x = 0;
	int y = 0;
	int xa = 1;
	int ya = 1;
	
	private Game game;

	public Ball1(Game game) {
		this.game = game;
	}

	void move() {
		
			
				if (x + xa < 0)
					xa = 1;
				if (x + xa > game.getWidth() - DIAMETER)
					xa = -1;
				if (y + ya < 0)
					ya = -1;
				if (y + ya > game.getHeight() - DIAMETER)
					ya = -1;
					//game.gameOver();
				if (collision()){
					y = y + ya;
					// y = game.ball1.getTopY() - DIAMETER;
				}
				
				if (x + xa > 0 && x + xa < game.getWidth() - DIAMETER)
				{
					x = x + xa; 
				}
				if (y + ya > 0 && y + ya < game.getHeight() - DIAMETER)
				{
					y = y + ya;
				}
			}
		
	// Some comments here //

	
	public void keyReleased(KeyEvent e) {
		xa = 0;
	}
	
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			xa = -1;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			xa = 1;
		if(e.getKeyCode() == KeyEvent.VK_UP)
	        ya = 1;         
	    if(e.getKeyCode() == KeyEvent.VK_DOWN)
	        ya = -1;
	}

	private boolean collision() {
		return game.ball2.getBounds().intersects(getBounds());
	}

	public void paint(Graphics2D g) {
		g.fillOval(x, y, DIAMETER, DIAMETER);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, DIAMETER, DIAMETER);
	}
	
	public int getTopY() {
		return Y;
	}
}