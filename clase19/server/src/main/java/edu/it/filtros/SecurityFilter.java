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

public class SecurityFilter implements Filter {
	private void dispachClient(HttpServletResponse resHTTP) throws IOException {
		PrintWriter out = resHTTP.getWriter();
		
		out.println(Utiles.claveValorToJson("mensaje", "El token enviado no es valido"));
		resHTTP.setStatus(401);
		out.close();
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest reqHTTP = (HttpServletRequest)request;
		HttpServletResponse resHTTP  = (HttpServletResponse)response;
		
		var token = reqHTTP.getHeader("x-token");
			
		if (token == null) {
			dispachClient(resHTTP);
			return;
		}
		
		if (token.equals("pepaPig")) {
			chain.doFilter(request, response);
			return;
		}
		
		dispachClient(resHTTP);
	}
}
