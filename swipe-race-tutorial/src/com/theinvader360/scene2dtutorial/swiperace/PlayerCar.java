package com.theinvader360.scene2dtutorial.swiperace;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class PlayerCar extends Actor {
	private TrafficGame trafficGame;
	private Rectangle bounds = new Rectangle();
	private int lane;
	
	public PlayerCar(TrafficGame trafficGame) {
		this.trafficGame = trafficGame;
		setWidth(160);
		setHeight(85);
		lane = 1;
		setPosition(100, trafficGame.lane1 - getHeight()/2);
		setColor(Color.YELLOW);
	}
	
	@Override
	public void act(float delta){
		super.act(delta);
		updateBounds();
	}

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		batch.setColor(getColor().r, getColor().g, getColor().b, getColor().a);		
		batch.draw(Assets.car, getX(), getY(), getWidth()/2, getHeight()/2, getWidth(), getHeight(), 1, 1, getRotation());
	}
	
	private void updateBounds() {
		bounds.set(getX(), getY(), getWidth(), getHeight());
	}

	public void tryMoveUp() {
		if ((getActions().size == 0) && (lane != 2)) moveToLane(lane+1);
	}

	public void tryMoveDown() {
		if ((getActions().size == 0) && (lane != 0)) moveToLane(lane-1);
	}
	
	private void moveToLane(int lane) {
		this.lane = lane;
		
		switch (lane) {
			case 0:
				addAction(moveTo(getX(), trafficGame.lane0 - getHeight()/2, 0.5f));
				break;
			case 1:
				addAction(moveTo(getX(), trafficGame.lane1 - getHeight()/2, 0.5f));
				break;
			case 2:
				addAction(moveTo(getX(), trafficGame.lane2 - getHeight()/2, 0.5f));
				break;
		}
	}

	public Rectangle getBounds() {
		return bounds;
	}
}
