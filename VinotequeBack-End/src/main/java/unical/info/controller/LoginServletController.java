package unical.info.controller;


import unical.info.persistenza.DBManager;
import unical.info.persistenza.dao.UtenteDao;
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
    PasswordCrypt p = new PasswordCrypt();
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
            if (p.matches(password,utente.getPassword())) {
                logged = true;
                HttpSession session = req.getSession();
                session.setAttribute("user", utente);
                session.setAttribute("sessionId", session.getId());
                req.getServletContext().setAttribute(session.getId(), session);


            }else {
                logged = false;
            }
        }
        if (logged) {
            resp.sendRedirect("http://localhost:4200?jsessionid="+req.getSession().getId());
        }else {
            resp.sendRedirect("/notAuthorized.html");
        }

    }
}
