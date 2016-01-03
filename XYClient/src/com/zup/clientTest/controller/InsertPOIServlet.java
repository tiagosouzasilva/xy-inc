package com.zup.clientTest.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.zup.clientTest.ws.*;
import com.zup.clientTest.ws.XYIncStub.InsertPOI;


/**
 * Servlet implementation class InsertPOI
 */
public class InsertPOIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertPOIServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
					
		XYIncStub xy = new XYIncStub();
		
		InsertPOI ins = new InsertPOI();
		ins.setName(request.getParameter("name"));
		ins.setX((Integer.valueOf(request.getParameter("x"))));
		ins.setY((Integer.valueOf(request.getParameter("y"))));
		
		try {
			
			if (xy.insertPOI(ins).get_return())
				response.getWriter().append("POI cadastrado com sucesso!");
			
		} catch (XYIncExceptionException e) {
							
			response.getWriter().append("Erro ao cadastrar POI.\n" + e.getMessage());
		}
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
