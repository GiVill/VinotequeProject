function validate(){
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;

    if (email == "") {
        alert("Campo email mancante");
        return false;
    }

    if (!validateEmail(email)) {
        alert("Il formato dell'email incorretto. Inserisci un'email valida: nome@esempio.xx");
        return false;
    }
    if (password == "") {
        alert("Campo password mancante");
        return false;
    }
    function validateEmail(email) {
        var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        return re.test(String(email).toLowerCase());
    }




}