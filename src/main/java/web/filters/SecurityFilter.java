package web.filters;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class SecurityFilter implements Filter {
    private static final String CONNEXION_PAGE = "/WEB-INF/vues/pages/loginForm.jsp";
@Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {



        HttpServletRequest rq = (HttpServletRequest) request;

        
        HttpSession session = rq.getSession();

        
        if (session.getAttribute("user") == null) {

            // Si non il faut interdir l'accès
            rq.getRequestDispatcher(CONNEXION_PAGE).forward(request, response);

            return;

        } else {

            // Si oui, alors continuer vers la resource suivante dans la chaine
            // (filtre suivant, servlet suivante ou jsp suivante..)
            chain.doFilter(request, response);

        }

    }}
