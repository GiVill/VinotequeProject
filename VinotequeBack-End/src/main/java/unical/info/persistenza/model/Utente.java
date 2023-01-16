package unical.info.persistenza.model;

import org.springframework.security.crypto.bcrypt.BCrypt;
import unical.info.controller.PasswordCrypt;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Utente{
    Long id;
    String nome;
    String cognome;
    String data_di_nascita;
    String email;
    String password;
    String ruolo;
    String indirizzo;
    PasswordCrypt p = new PasswordCrypt();

    public Utente( String nome, String cognome, String data_di_nascita, String email, String password, String indirizzo) {

        this.nome = nome;
        this.cognome = cognome;
        this.data_di_nascita = data_di_nascita;
        this.email = email;
        this.password = password;
        this.ruolo = "utente";
        this.indirizzo = indirizzo;
    }




    public Utente() {    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getData_di_nascita() {
        return data_di_nascita;
    }

    public void setData_di_nascita(String data_di_nascita) {
        this.data_di_nascita = data_di_nascita;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }



    public void setPassword(String password) {
        this.password = password;
    }

    public String getRuolo() {
        return ruolo;
    }
    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", data_di_nascita='" + data_di_nascita + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", ruolo='" + ruolo + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                '}';
    }


}