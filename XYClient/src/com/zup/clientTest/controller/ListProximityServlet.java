package com.zup.clientTest.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zup.clientTest.ws.XYIncExceptionException;
import com.zup.clientTest.ws.XYIncStub;
import com.zup.clientTest.ws.*;
import com.zup.clientTest.ws.XYIncStub.POI;
import com.zup.clientTest.ws.XYIncStub.SelectAll;
import com.zup.clientTest.ws.XYIncStub.ListProximity;
/**
 * Servlet implementation class ListProximityServlet
 */ 
public class ListProximityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListProximityServlet() {
        super();        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
																
		try {
								
			XYIncStub xy = new XYIncStub();
			
			ListProximity li = new ListProximity();
						
			li.setX(Integer.valueOf(request.getParameter("x")));
			li.setY(Integer.valueOf(request.getParameter("y")));
			li.setMaxDistance(Float.valueOf(request.getParameter("distance")));
			
			POI[] lp = xy.listProximity(li).get_return();
			
			StringBuilder str = new StringBuilder("<table><tr>"													
												+ "<th>Nome</th>"
												+ "<th>X</th>"
												+ "<th>Y</th>"
												+ "<th>Distância</th></tr>");
			
			if (lp != null && lp.length > 0){
				for (POI poi : lp) {					
					str.append("<tr>");
					str.append("<td>" + poi.getName() + "</td>");
					str.append("<td>" + poi.getX() + "</td>");
					str.append("<td>" + poi.getY() + "</td>");
					str.append("<td>" + poi.getDistance() + "</td>");
					str.append("</tr>");
								
				}
				str.append("</table></html>");
				
				response.getWriter().append("<html><body>Lista de POIs mais próximos:<br>" 
											+ str.toString() 
											+ "<br><br>Parâmetros: X=" + request.getParameter("x") + "  Y=" + request.getParameter("y") + " Distância: " + request.getParameter("distance")
											+ "</body></html>");
			}
			else
				response.getWriter().append("Não foram encontrados pontos de interesse num raio de " + request.getParameter("distance") + " metros a partir das coordenadas X=" + request.getParameter("x") + "  Y=" + request.getParameter("y") + ".");
			
		} catch (XYIncExceptionException e) {							
			response.getWriter().append("Erro ao listar os POI próximos.\n" + e.getMessage());
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		doGet(request, response);
	}

}
