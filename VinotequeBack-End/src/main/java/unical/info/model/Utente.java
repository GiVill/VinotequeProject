package unical.info.model;

public class Utente{
    Long id;
    String nome;
    String cognome;
    String data_di_nascita;
    String email;
    String password;
    String ruolo;
    String via;
    String civico;
    String cap;
    String telefono;
    String carrello;



    public Utente(Long id, String nome, String cognome, String data_di_nascita, String email, String password, String ruolo, String via, String civico, String cap, String telefono, String carrello) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.data_di_nascita = data_di_nascita;
        this.email = email;
        this.password = password;
        this.ruolo = ruolo;
        this.via = via;
        this.civico = civico;
        this.cap = cap;
        this.telefono = telefono;
        this.carrello = carrello;
    }

    public Utente() {    }



    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getCivico() {
        return civico;
    }

    public void setCivico(String civico) {
        this.civico = civico;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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


    public String getCarrello() {
        return carrello;
    }

    public void setCarrello(String carrello) {
        this.carrello = carrello;
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
                ", via='" + via + '\'' +
                ", civico='" + civico + '\'' +
                ", cap='" + cap + '\'' +
                ", telefono='" + telefono + '\'' +
                ", carrello='" + carrello + '\'' +
                '}';
    }
}