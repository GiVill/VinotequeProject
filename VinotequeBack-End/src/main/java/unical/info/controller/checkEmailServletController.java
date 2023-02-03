package unical.info.controller;

import unical.info.model.Utente;
import unical.info.persistenza.DBManager;
import unical.info.persistenza.dao.UtenteDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/checkEmail")
public class checkEmailServletController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("entro dentro la servelet email");
        String email = req.getParameter("email");
        UtenteDao udao = DBManager.getInstance().getUtenteDao();
        Utente utente = udao.findByEmail(email);
        boolean esiste;
        if (utente == null){
            esiste = false;
        }else {
            esiste = true;
        }
        resp.getWriter().println(esiste);
    }
}
