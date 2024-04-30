package web.filters;
import bo.Message;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;

import java.io.IOException;
import java.util.*;

public class ExceptionFilter extends HttpFilter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            chain.doFilter(request, response);

        } catch (Exception e) {
            List<Message> list = new ArrayList<>();
            list.add(new Message("Une erreur est survenue veuillez consulter le fichier journal pour plus de détails",
                    Message.ERROR));
            request.setAttribute("messages", list);
            getServletContext().getRequestDispatcher("/WEB-INF/vues/pages/error.jsp").forward(request, response);

        }
    }
}
