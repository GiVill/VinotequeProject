
window.addEventListener("load", function(){
    var canSubmit = false;

    var elForm = document.getElementsByTagName("form")[0];

    elForm.addEventListener("submit", function(event){

        var txtEmail= document.getElementById("email");
        var txtPassword = document.getElementById("password");
        validateLogin(txtEmail,txtPassword);
    });

    function validateLogin(txtEmail, txtPassword, e) {
        if (txtEmail.value == "") {
            window.location.href = "http://localhost:4200/";
        } else {
            elForm.append(txtEmail);
            elForm.append(txtPassword);

            fetch("/doLogin", {
                method: "POST",
                body: elForm
            })
                .then(response => {
                    if (response.ok) {
                        return response.json();
                    } else {
                        throw new Error("Errore durante il login");
                    }
                })
                .then(data => {
                    if (data.success) {
                        // reindirizzare l'utente alla home page
                        window.location.href = "http://localhost:4200/";
                    } else {
                        // mostrare un messaggio di errore
                        alert("Email o password errati!");
                    }
                })
                .catch(error => {
                    console.log(error);
                });
        }
    }
});


$(document).ready(function() {
    $("#show_hide_password a").on('click', function(event) {
        event.preventDefault();
        if($('#show_hide_password input').attr("type") == "text"){
            $('#show_hide_password input').attr('type', 'password');
            $('#show_hide_password i').addClass( "fa-eye-slash" );
            $('#show_hide_password i').removeClass( "fa-eye" );
        }else if($('#show_hide_password input').attr("type") == "password"){
            $('#show_hide_password input').attr('type', 'text');
            $('#show_hide_password i').removeClass( "fa-eye-slash" );
            $('#show_hide_password i').addClass( "fa-eye" );
        }
    });
});