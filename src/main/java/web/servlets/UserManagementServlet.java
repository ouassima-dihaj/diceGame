package web.servlets;

import bo.Message;
import bo.User;
import web.helpers.GameContextManagement;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/UserManagementServlet")
public class UserManagementServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

 
        String createUserFormPage = "/WEB-INF/vues/pages/formInscription.jsp";

        ServletContext cntx = getServletContext();

        // On affiche le formulaire d'ajout
        if (request.getParameter("create") != null) {
            cntx.getRequestDispatcher(createUserFormPage).forward(request, response);
            // fin
            return;
        }

    }
    protected  void doPost(HttpServletRequest request,HttpServletResponse response) throws  ServletException,IOException{
        String errorPage = "/WEB-INF/vues/pages/error.jsp";
        String loginForm = "/WEB-INF/vues/pages/loginForm.jsp";
        ServletContext context= request.getServletContext();;
        String nom=request.getParameter("nom");
        String prenom=request.getParameter("prenom");
        String login =request.getParameter("login");
        String password=request.getParameter("password");
        User user = new User(nom, prenom, login, password, 0, 0);
        GameContextManagement gameContextManagement=GameContextManagement.getInstance(request.getServletContext());
        List<Message> messages = new ArrayList<Message>();
        if (gameContextManagement.getUserByLogin(login) != null) {

            // Ajouter des message d'erreur dans la requete
            messages.add(new Message("Login existe déjà", Message.WARN));
            request.setAttribute("messages", messages);

            context.getRequestDispatcher(errorPage).forward(request, response);
            return;

        }
        gameContextManagement.insertUser(user);
        messages.add(new Message("Utilisateur correctement ajouté", Message.INFO));
        request.setAttribute("messages", messages);
        context.getRequestDispatcher(loginForm).forward(request, response);
    }
}
