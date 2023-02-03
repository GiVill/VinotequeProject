package unical.info.controller;

import unical.info.model.Utente;
import unical.info.persistenza.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/doRegister")
public class RegistrationServletController extends HttpServlet  {
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String nome = req.getParameter("nome");
            String cognome = req.getParameter("cognome");
            String data = req.getParameter("data");
            String email = req.getParameter("email");
            String password = req.getParameter("password");

            Utente utente = new Utente(nome,cognome,data,email,password);
            if(DBManager.getInstance().getUtenteDao().findByEmail(utente.getEmail()) == null) {
                DBManager.getInstance().getUtenteDao().NewUtente(utente);
                //resp.sendError(0,"Registrazione avvenuta con successo");
                //resp.sendRedirect("/login.html");
            }
            else {
                //resp.sendError(0,"email già in uso");
            }
        }
    }


