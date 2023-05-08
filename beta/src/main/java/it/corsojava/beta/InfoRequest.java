package it.corsojava.beta;

import java.io.IOException;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InfoRequest extends HttpServlet {

	private static final long serialVersionUID = 7251714439722605562L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StringBuilder sb=new StringBuilder();
		
		sb.append(req.getMethod());
		sb.append(" ");
		sb.append(req.getProtocol());
		sb.append("\r\n");
		sb.append("\r\n");
		sb.append("\r\n");
			
		Enumeration<String> hNames = req.getHeaderNames();
		while(hNames.hasMoreElements()) {
			String name=hNames.nextElement();
			sb.append(name);
			sb.append(": ");
			sb.append(req.getHeader(name));
			sb.append("\r\n");	
		}
		
		resp.getOutputStream().println(sb.toString());
	}
	
}
