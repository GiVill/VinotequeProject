package unical.info.RESTApi;

import org.springframework.web.bind.annotation.*;
import unical.info.persistenza.DBManager;
import unical.info.persistenza.model.Utente;


@RestController
@CrossOrigin("http://localhost:4200")
public class AuthenticationRESTController{
    @PostMapping ("/addUser")
    public Boolean register( @RequestBody Utente newUser){
        System.out.println(newUser.toString());
        //TODO: CONTROLLO EMAIL GIA PRESENTE NEL DB
       if(DBManager.getInstance().getUtenteDao().findByEmail(newUser.getEmail()) == null) {
           DBManager.getInstance().getUtenteDao().NewUtente(newUser);
           return true;
       }
       else {
           return false;
       }
    }


    @PostMapping ("/login")
    public String login( @RequestBody String email, String password){
        //TODO: CERCA CREDENZIALI NEL DB E RESTITUISCE L'ID come stringa o jsessionid
        return  "ciao";
    }
}
/*
 import javax.crypto.Cipher;
        import javax.crypto.spec.SecretKeySpec;
        import java.nio.charset.StandardCharsets;
        import java.security.Key;

@RestController
public class LoginController {

    @PostMapping("/api/login")
    public void login(@RequestBody Map<String, String> data) {
        String encryptedPassword = data.get("encryptedPassword");
        String key = data.get("key");

        // Decrypt the password
        Key secretKey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedPasswordBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedPassword));
        String decryptedPassword = new String(decryptedPasswordBytes);

        // Compare the decrypted password to the stored password hash
        // (assuming the stored password hash is in a variable called storedPasswordHash)
        if (BCrypt.checkpw(decryptedPassword, storedPasswordHash)) {
            // Password is correct, proceed with login
        } else {
            // Password is incorrect, return an error
        }
    }
}
*/

