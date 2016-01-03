package com.zup.testeTecnico.controller;

import java.util.List;

import com.zup.testeTecnico.entities.*;

public class XYInc {
	
	public boolean insertPOI(String name, int x, int y) throws Exception
	{
		
		boolean success = true;
		
		try 
		{			
			if (validateInsert(name, x, y))
			{
				POI poi = new POI(name, x, y);
				
				poi.insert();
				
				poi = null;
			}
			
		} catch (Exception e) {			
			throw e;
		}
		
		return success;
	}

	private boolean validateInsert(String name, int x, int y) throws Exception {

		if (name.trim().length() < 1)
			throw new Exception("O ponto de interesse necessita de um nome!");
		else if (name.trim().length() > 200) 
			throw new Exception("O ponto de interesse não pode ter mais de 200 caracteres!");
		else if (x < 0)
			throw new Exception("A coordenada X não pode ser menor que zero!");
		else if (y < 0)
			throw new Exception("A coordenada Y não pode ser menor que zero!");	
		
		return true;
	}
	
	public List<POI> selectAll()
	{
		return new POI().selectAll();		
	}
	
	public List<POI> listProximity(int x, int y, float maxDistance) throws Exception
	{
		List<POI> li = null;
		
		if (validateListProximity(x, y, maxDistance))
			li = new POI().listProximity(x, y, maxDistance);
		
		return li;
	}

	private boolean validateListProximity(int x, int y, float maxDistance) throws Exception {

		if (x < 0)
			throw new Exception("A coordenada X não pode ser menor que zero!");
		else if (y < 0)
			throw new Exception("A coordenada Y não pode ser menor que zero!");
		else if (maxDistance < 0)
			throw new Exception("A distância máxima não pode ser menor que zero!");
		
		return true;
	}
}
