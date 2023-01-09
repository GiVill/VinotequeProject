package unical.info.controller;

import unical.info.DBManager;
import unical.info.dao.UtenteDao;
import unical.info.model.Utente;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/doLogin")
public class LoginServletController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        UtenteDao udao = DBManager.getInstance().getUtenteDao();
        Utente utente = udao.findByEmail(email);
        boolean logged;
        if (utente == null) {
            logged = false;
        }else {
            if (password.equals(utente.getPassword())) {
                logged = true;
                HttpSession session = req.getSession();
                session.setAttribute("user", utente);
            }else {
                logged = false;
            }
        }
        if (logged) {
            resp.sendRedirect("/");
        }else {
            resp.sendRedirect("/notAuthorized.html");
        }

    }
}
