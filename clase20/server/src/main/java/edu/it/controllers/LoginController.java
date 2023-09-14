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
	private Boolean validarPassword(String password) {
		String palabraSecreta = "684681fFSazzsdfasfsdfsdfsdfsdlfnnnxnxskjliyes";
		
		String source = String.join("__", palabraSecreta, password, palabraSecreta);
		String encriptado = org.apache.commons.codec.digest.DigestUtils.sha256Hex(source);
		
		if (encriptado.equals("6ad6459da0ef80c82000153a875f6b51add548828db04d36925720a8e3a24ce3")) {
			System.out.println("La clave es correcta");
			return true;
		}
		else {
			System.out.println("La clave NO correcta");
			return false;
		}		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws IOException, ServletException {
	
		response.setContentType("application/json");
		
		String strDatosUsuario = Utiles.leerInputStreamReader(request.getInputStream());
		
		var datosLogin = new Gson().fromJson(strDatosUsuario, DatosLogin.class);
		
        PrintWriter out = response.getWriter();
        
        if (validarPassword(datosLogin.password) == false) {
        	var strResp = Utiles.claveValorToJson("mensaje", "La combinacion de usuario y password es incorrecta");
        	out.println(strResp);        
            response.setStatus(200);
            return;
        }
        
        var jwt = JWTUtil.crearJWT(datosLogin.usuario);        
        var strResp = Utiles.claveValorToJson("token", jwt);
        
        out.println(strResp);        
        response.setStatus(200);
        
        out.close();
	}
}
