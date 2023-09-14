package edu.it.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class PruebaController extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws IOException, ServletException {
	
		response.setContentType("application/json");
		
        PrintWriter out = response.getWriter();
        
        int[] xs = new int[20]; 
        
        for (int x=0;x < 20;x++) {
        	xs[x] = (int)(Math.random() * 1500);
        }
        
        var pv = new com.calc.model.PrecioVolatilidad(4f, 20);
        System.out.println(new Gson().toJson(pv));
        
        out.println(new Gson().toJson(pv));
        
        response.setStatus(200);        
        out.close();
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws IOException, ServletException {
	
		response.setContentType("text/html");
		
        PrintWriter out = response.getWriter();
        
        out.println("<h1>HTTP POST Hora actual: ");
        out.println(System.currentTimeMillis());
        out.println("</h1>");
        
        response.setStatus(200);
        
        out.close();
	}
	
	public void doPut(HttpServletRequest request, HttpServletResponse response)
	        throws IOException, ServletException {
	
		response.setContentType("text/html");
		
        PrintWriter out = response.getWriter();
        
        out.println("<h1>HTTP PUT Hora actual: ");
        out.println(System.currentTimeMillis());
        out.println("</h1>");
        
        response.setStatus(200);
        
        out.close();
	}
	
	public void doDelete(HttpServletRequest request, HttpServletResponse response)
	        throws IOException, ServletException {
	
		response.setContentType("text/html");
		
        PrintWriter out = response.getWriter();
        
        out.println("<h1>HTTP DELETE Hora actual: ");
        out.println(System.currentTimeMillis());
        out.println("</h1>");
        
        response.setStatus(200);
        
        out.close();
	}
}
