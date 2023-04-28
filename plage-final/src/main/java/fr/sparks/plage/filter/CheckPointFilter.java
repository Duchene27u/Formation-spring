package fr.sparks.plage.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.stereotype.Component;

@Component
public class CheckPointFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// On enrichit l'objet request en ajoutant un attribut dateHeureDebut
		Date dateHeureDebut = new Date();
		request.setAttribute("msDepart", dateHeureDebut.getTime());
		chain.doFilter(request, response);

	}

}
