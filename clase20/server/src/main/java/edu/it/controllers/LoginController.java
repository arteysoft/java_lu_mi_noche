package edu.it.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import edu.it.components.Utiles;
import edu.it.model.DatosLogin;
import edu.it.utiles.JWTUtil;

public class LoginController extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws IOException, ServletException {
	
		response.setContentType("application/json");
		
		String strDatosUsuario = Utiles.leerInputStreamReader(request.getInputStream());
		
		var datosLogin = new Gson().fromJson(strDatosUsuario, DatosLogin.class);
		
        PrintWriter out = response.getWriter();
        
        var jwt = JWTUtil.crearJWT(datosLogin.usuario);        
        var strResp = Utiles.claveValorToJson("token", jwt);
        
        out.println(strResp);        
        response.setStatus(200);
        
        out.close();
	}
}
