window.addEventListener("load", function() {
    console.log("sdbhas")
    var elForm = document.getElementsByTagName("form")[0];
    elForm.addEventListener("submit", function (event) {
        var txtNome = document.getElementById("nome");
        var txtCognome = document.getElementById("cognome");
        var txtDataDiNascita = document.getElementById("data");
        var txtEmail = document.getElementById("email");
        var txtPassword = document.getElementById("password");
        var txtCPassword = document.getElementById("Cpassword");
        validate(txtNome, txtCognome, txtDataDiNascita, txtEmail, txtPassword, txtCPassword, event);
    });
});
    function validate(txtNome, txtCognome, txtDatatDiNascita,txtEmail, txtPassword, txtCPassword, event) {
        var nome = txtNome.value.trim()
        var cognome = txtCognome.value.trim()
        var data_di_nascita = txtDatatDiNascita.value
        var email = txtEmail.value.trim()
        var password = txtPassword.value.trim()
        var Cpassword = txtCPassword.value.trim()

        var canSubmit = true;

        if (nome == "") {
            alert("Campo nome mancante");
            canSubmit = false;
        }

        if (cognome == "") {
            alert("Campo cognome mancante");
            canSubmit = false;
        }

        if (data_di_nascita == "") {
            alert("Campo data di nascita mancante");
            canSubmit = false;
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
            canSubmit = false;
        }


        if (email == "") {
            alert("Campo email mancante");
            canSubmit = false;
        }

        if (!validateEmail(email)) {
            console.log(email)
            alert("Il formato dell'email incorretto. Inserisci un'email valida: nome@esempio.xx");
            canSubmit = false;
        }

        if (password == "") {
            alert("Campo password mancante ");
            canSubmit = false;
        }

        if (password.length < 6) {
            alert("Campo password  deve avere una lunghezza di almeno 6 caratteri");
            canSubmit = false;
        }

        if (Cpassword == "") {
            alert("Campo conferma password mancante");
            canSubmit = false;
        }

        if (password != Cpassword) {
            console.log(password, Cpassword)
            alert("Password e Conferma Password non coincidono ");
            canSubmit = false;
        }

        function validateEmail(email) {
            var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
            return re.test(String(email).toLowerCase());
        }

        if(canSubmit){
            event.preventDefault();
            $.ajax({
                url: "/checkEmail",
                data: {email : email},
                type: "post",
                success : function (risp){
                    console.log("RISPOSTA:"+risp)
                    if(risp.trim() === 'true'){
                        alert("Email inserita gia' utilizzata da un altro utente!");
                    }else{
                        let form = document.querySelector("form");
                        form.submit();
                    }
                }
            });
        }
        if(!canSubmit){
            event.preventDefault();
    }
}





