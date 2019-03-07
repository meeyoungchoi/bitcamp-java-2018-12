package ch26.a;


import java.util.ArrayList;

import design_pattern.builder.Engine;

public class Car {
	Body body;
	Engine engine;
	ArrayList<Door> doors = new ArrayList<>();
	
	public Car(Body body, Engine engine) {
		this.body = body;
		this.engine = engine;
	}
	
	public void addDoor(Door door) {
		doors.add(door);
	}
	
}
