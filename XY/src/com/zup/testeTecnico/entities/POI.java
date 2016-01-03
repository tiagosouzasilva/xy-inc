package com.zup.testeTecnico.entities;

import java.util.List;

import com.zup.testeTecnico.dal.*;

public class POI {
	
	private String name;
	private int x;
	private int y;
	private float distance;
	
	public String getName() {
		return name;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public float getDistance()
	{
		return distance;
	}
	
	public void setDistance(float distance)
	{
		this.distance = distance;
	}

	public POI (){}
	
	public POI(String name, int x, int y)
	{
		this.name = name;
		this.x = x;
		this.y = y;
	}
	
	public void insert() throws Exception
	{
		new POIDal().insert(name, x, y);		
	}	
	
	public List<POI> selectAll()
	{
		return new POIDal().selectAll();
	}

	public List<POI> listProximity(int x, int y, float maxDistance) 
	{
		return new POIDal().listProximity(x, y, maxDistance);
	}
}
