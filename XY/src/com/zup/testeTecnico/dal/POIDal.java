package com.zup.testeTecnico.dal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.zup.testeTecnico.entities.*;

public class POIDal {

	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public boolean insert (String name, int x, int y) throws Exception
	{
		boolean success = true;
		
					
		if (exists(name)) {
			
			throw new Exception("Já existe um POI cadastrado com este nome!");
			
		}
		else {
			pst = connect().prepareStatement("insert into pois (name, x, y) values (?,?,?)");
			
			pst.setString(1, name);
			pst.setInt(2, x);
			pst.setInt(3, y);
			
			pst.executeUpdate();
			
			conn.close();
		}   				
				
		return success;
	}
	
	private boolean exists(String name) throws ClassNotFoundException, SQLException {
		boolean ret = false;
		
		pst = connect().prepareStatement("select name from pois where name = ?");
		
		pst.setString(1, name);
		
		rs = pst.executeQuery();
		
		if (rs.next())
			ret = true;
		
		return ret;
	}

	public Connection connect() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		conn = MySqlConnection.connect();
		conn = DriverManager.getConnection("jdbc:mysql://localhost/zup","root","admin");
		
		return conn;
	}
	
	public List<POI> selectAll()
	{
		List<POI> li;
		
		try {
			pst = connect().prepareStatement("select name, x, y from pois order by 1");
								
			rs = pst.executeQuery();
			
			li = new ArrayList<POI>();
			
			while (rs.next()) {		
				li.add(new POI(rs.getString("name"),rs.getInt("x"),rs.getInt("y")));
			}
		}
		catch (Exception e)
		{
			li = null;
		}
		
		return li;
	}

	public List<POI> listProximity(int x, int y, float maxDistance)
	{
		List<POI> li;
		
		try {					
			pst = connect().prepareStatement("SELECT P.NAME, P.X, P.Y,"+
											  "      ROUND(SQRT(POW(P.X - ?,2) + POW(P.Y- ?,2)),4) DISTANCE " +											  
											  "FROM POIS P " +	
											  "WHERE SQRT(POW(P.X - ?,2) + POW(P.Y- ?,2)) <= ? " + 
											  "ORDER BY DISTANCE");
			
			pst.setInt(1, x);
			pst.setInt(2, y);
			pst.setInt(3, x);
			pst.setInt(4, y);
			pst.setFloat(5, maxDistance);
						
			rs = pst.executeQuery();
			
			li = new ArrayList<POI>();
			
			POI poi;
			
			while (rs.next()) {
							
				poi = new POI(rs.getString("name"),rs.getInt("x"),rs.getInt("y"));
				poi.setDistance(rs.getFloat("distance"));
									
				li.add(poi);
				
			}
		}
		catch (Exception e)
		{
			li = null;
		}
		
		return li;
	}
}
