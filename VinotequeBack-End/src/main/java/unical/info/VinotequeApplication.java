package unical.info;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import java.sql.SQLException;

@SpringBootApplication
@ServletComponentScan
public class VinotequeApplication {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(VinotequeApplication.class, args);
		//Utente u = new Utente("l","v","1","luigi@sss.c","ciaocome","via casa mia");

		//HashMap<Long, Integer> items = new HashMap<>();
		//Utente prova = DBManager.getInstance().getUtenteDao().findByEmail("luigi@sss.c");
		//items.put(1l,10);
		//items.put(2l,4);
		//Carrello carrello = new Carrello(items,prova);
		//DBManager.getInstance().getCarrelloDao().save(carrello);
	}

}
