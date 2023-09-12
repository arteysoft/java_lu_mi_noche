package edu.it.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.it.components.Utiles;

public class LoginController extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws IOException, ServletException {
	
		response.setContentType("application/json");
		
        PrintWriter out = response.getWriter();
        
        var strResp = Utiles.claveValorToJson("token", "pepaPig");
        
        out.println(strResp);        
        response.setStatus(200);
        
        out.close();
	}
}
