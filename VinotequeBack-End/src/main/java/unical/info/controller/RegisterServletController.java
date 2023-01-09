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

@WebServlet("/doRegister")
public class RegisterServletController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String nome = req.getParameter("nome");
        String cognome = req.getParameter("cognome");
        String numero_telefono =req.getParameter("numero_telefono");
        String data_di_nascita = req.getParameter("data_di_nascita");

        String via =req.getParameter("via");;
        String cap = req.getParameter("cap");;
        String citta= req.getParameter("citta");;
        String nazione = req.getParameter("nazione");;

        String indirizzo = via+","+cap+","+citta+","+nazione;

        UtenteDao udao = DBManager.getInstance().getUtenteDao();
        Utente utente = udao.findByEmail(email);
        boolean logged;
        if (utente == null) {
            logged = true;
            //TODO save or update
            Utente utente1 = new Utente(nome,cognome,data_di_nascita,email,password,numero_telefono,indirizzo);
            udao.saveOrUpdate(utente1);
            HttpSession session = req.getSession();
            session.setAttribute("user", utente1);
        }else {

            logged = false;
        }
        if (logged) {
            resp.sendRedirect("/");
        }else {
            resp.sendRedirect("/notAuthorized.html");//email esistente
        }

    }
}
