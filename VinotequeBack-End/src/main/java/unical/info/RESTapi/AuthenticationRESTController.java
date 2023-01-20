package unical.info.RESTapi;

import org.springframework.web.bind.annotation.*;
import unical.info.persistenza.DBManager;
import unical.info.persistenza.model.Utente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


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

    @GetMapping ("/logout")
    public boolean logout(String jsessionid, HttpServletRequest req){
        if(jsessionid != null){
            HttpSession session = (HttpSession) req.getServletContext().getAttribute(jsessionid);
            if(session == null){
                return true;
            }
            session.removeAttribute("user");
            session.invalidate();
            return true;
        }

        return false;
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

