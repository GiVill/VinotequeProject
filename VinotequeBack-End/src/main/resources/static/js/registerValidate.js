//da pulire
window.addEventListener("load", function(){
        var elForm = document.getElementsByTagName("form")[0];
        elForm.addEventListener("submit", function(event){
            var nome = document.getElementById("nome").value;
            var cognome = document.getElementById("cognome").value;
            var data_di_nascita = document.getElementById("data").value;
            var email = document.getElementById("email").value;
            var password = document.getElementById("password").value;
            var Cpassword = document.getElementById("Cpassword").value;
            validate(nome,cognome,data_di_nascita,email,password,Cpassword, event);
        });

});

function validate(nome,cognome,data_di_nascita,email,password,Cpassword, event){

    if (nome == "") {
        alert("Campo nome mancante");
        return false;
    }

    if (cognome == "") {
        alert("Campo cognome mancante");
        return false;
    }

    if (data_di_nascita == "") {
        alert("Campo data di nascita mancante");
        return false;
    }

    var today = new Date();
    var birthDate = new Date(data_di_nascita);
    var age = today.getFullYear() - birthDate.getFullYear();
    var m = today.getMonth() - birthDate.getMonth();
    if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) {
        age--;
    }
    if (age < 18) {
        alert("Devi essere maggiorenne per registrarti!!!");
        return false;
    }


    if (email == "") {
        alert("Campo email mancante");
        return false;
    }

    if (!validateEmail(email)) {
        alert("Il formato dell'email incorretto. Inserisci un'email valida: nome@esempio.xx");
        return false;
    }

    if (password == "" || password.length < 6) {
        alert("Campo password mancante deve avere una lunghezza di almeno 6 caratteri");
        return false;
    }

    if (password.length < 6) {
        alert("Campo password  deve avere una lunghezza di almeno 6 caratteri");
        return false;
    }

    if (Cpassword == "") {
        alert("Campo conferma password mancante");
        return false;
    }

    if (password != Cpassword) {
        console.log(password, Cpassword)
        alert("Password e Conferma Password non coincidono ");
        return false;
    }


    var canSubmit = true;
    if (canSubmit) {
        let textEmail = email.value.trim();
        event.preventDefault();
        $.ajax({
            url: "/checkEmail",
            data: {"email": textEmail},
            type: "post",
            success: function (risposta) {
                if (risposta.trim() === 'true') {
                    console.log("entratoin true")
                    console.log(risposta)
                    alert("Mi dispiace questa email appartiene ad un account esistente");
                } else {
                    console.log("entratoin else")
                    let form = document.querySelector("form");
                    form.submit();
                }
            }
        });

    }


        function validateEmail(email) {
            var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
            return re.test(String(email).toLowerCase());
        }

    }


