package unical.info.controller;

import unical.info.model.Utente;
import unical.info.persistenza.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/checkEmail")
public class ControllaMail extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        boolean trovato = true;
        if(DBManager.getInstance().getUtenteDao().findByEmail(email) == null) {
            trovato = false;
        }
        resp.getWriter().println(trovato);
    }
}
