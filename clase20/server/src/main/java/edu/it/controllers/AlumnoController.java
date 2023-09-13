package edu.it.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import edu.it.components.Utiles;
import edu.it.errores.BadRequest;
import edu.it.errores.HttpError;
import edu.it.errores.InternalServerError;
import edu.it.model.Alumno;
import edu.it.repository.AlumnoDao;

public class AlumnoController extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws IOException, ServletException {
	
		response.setContentType("application/json");
		
        PrintWriter out = response.getWriter();
        
        out.println(new Gson().toJson(Utiles.generarAlumnoRandom()));
        
        response.setStatus(200);        
        out.close();
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws IOException, ServletException {
	
		response.setContentType("application/json");
		
		try {
			PrintWriter out = response.getWriter();
	        
	        String str = Utiles.leerInputStreamReader(request.getInputStream());        
	        System.out.println(str);
	        
	        Alumno alumno = null;
	        
	        try {
	        	alumno = new Gson().fromJson(str, Alumno.class);
	        }
	        catch (Exception ex) {
	        	throw new BadRequest();
	        }
	        
	        try {
	        	new AlumnoDao().insertar(alumno);
	        }
	        catch (Exception ex) {
	        	throw new InternalServerError();
	        }
	        response.setStatus(201);        
	        out.close();
		}
		catch (HttpError ex) {
			response.setStatus(ex.codigoError);
		}
		catch (Exception ex) {
			response.setStatus(500);
		}
	}
}
