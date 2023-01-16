package unical.info;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import unical.info.persistenza.DBManager;
import unical.info.persistenza.model.Utente;

@SpringBootApplication
@ServletComponentScan
public class VinotequeApplication {

	public static void main(String[] args) {
		SpringApplication.run(VinotequeApplication.class, args);

		//Utente u = new Utente("l","v","1","luigi@sss.c","ciaocome","via casa mia");
		//DBManager.getInstance().getUtenteDao().NewUtente(u);
	}

}
