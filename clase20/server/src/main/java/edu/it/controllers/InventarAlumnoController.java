package edu.it.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import edu.it.components.Utiles;
import edu.it.model.Alumno;

public class InventarAlumnoController extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws IOException, ServletException {
	
		response.setContentType("application/json");
		
        PrintWriter out = response.getWriter();
        
        Alumno[] alumnos = new Alumno[] {
        		Utiles.generarAlumnoRandom(),
        		Utiles.generarAlumnoRandom(),
        		Utiles.generarAlumnoRandom(),
        		Utiles.generarAlumnoRandom(),
        		Utiles.generarAlumnoRandom(),
        		Utiles.generarAlumnoRandom()
        };
        
        out.println(new Gson().toJson(alumnos));
        
        response.setStatus(200);        
        out.close();
	}
}
