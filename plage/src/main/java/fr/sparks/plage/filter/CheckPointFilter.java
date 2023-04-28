package fr.sparks.plage.filter;

import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.Date;

@Component
public class CheckPointFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        // On enrichit l'objet request en ajoutant un attribut dateHeureDebut
        Date dateHeureDebut = new Date();
        servletRequest.setAttribute("msDepart", dateHeureDebut.getTime());
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
