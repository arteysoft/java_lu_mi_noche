package edu.it.filtros;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import edu.it.components.Utiles;
import edu.it.utiles.JWTUtil;

public class SecurityFilter implements Filter {
	private void dispachClient(HttpServletResponse resHTTP, int codigoError) throws IOException {
		PrintWriter out = resHTTP.getWriter();
		
		out.println(Utiles.claveValorToJson("mensaje", "No se autentico correctamente por token"));
		resHTTP.setStatus(codigoError);
		out.close();
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest reqHTTP = (HttpServletRequest)request;
		HttpServletResponse resHTTP  = (HttpServletResponse)response;
		
		var path = reqHTTP.getServletPath();
		if (path.equals("/login")) {
			chain.doFilter(request, response);
			return;
		}
		
		var token = reqHTTP.getHeader("x-token");
		
		if (token == null) {
			System.out.println("No llego ningun x-token");
			dispachClient(resHTTP, 401);
			return;
		}
		
		try {
			JWTUtil.validarToken(token);
			chain.doFilter(request, response);			
		}
		catch (io.jsonwebtoken.MalformedJwtException ex) {
			System.out.println("io.jsonwebtoken.MalformedJwtException");
			dispachClient(resHTTP, 400);
		}
		catch (io.jsonwebtoken.SignatureException ex) {
			System.out.println("io.jsonwebtoken.SignatureException");
			dispachClient(resHTTP, 401);
		}
		catch (io.jsonwebtoken.ExpiredJwtException ex) {
			System.out.println("io.jsonwebtoken.ExpiredJwtException");
			dispachClient(resHTTP, 401);
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			dispachClient(resHTTP, 500);
		}
	}
}
