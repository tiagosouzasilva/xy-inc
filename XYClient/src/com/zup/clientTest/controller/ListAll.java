package com.zup.clientTest.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.zup.clientTest.ws.*;
import com.zup.clientTest.ws.XYIncStub.POI;
import com.zup.clientTest.ws.XYIncStub.SelectAll;

/**
 * Servlet implementation class ListAll
 */
public class ListAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
						
		XYIncStub xy = new XYIncStub();
		
		POI[] li = xy.selectAll(new SelectAll()).get_return();
		
		
		StringBuilder str = new StringBuilder();
		
		str.append("<html><body>POIs cadastrados:<table><tr><th>Nome</th><th>X</th><th>Y</th></tr>");
		
		for (POI poi : li) {
			
			str.append("<tr>");
			str.append("<td>" + poi.getName() + "</td>");
			str.append("<td>" + String.valueOf(poi.getX()) + "</td>");
			str.append("<td>" + String.valueOf(poi.getY()) + "</td>");
			str.append("</tr>");
			
		}
		
		response.getWriter().append(str.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
