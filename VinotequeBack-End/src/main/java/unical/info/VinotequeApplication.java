package unical.info;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import unical.info.model.Utente;
import unical.info.model.Vino;
import unical.info.persistenza.DBManager;

import java.sql.SQLException;
import java.util.List;

@SpringBootApplication
@ServletComponentScan
public class VinotequeApplication {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(VinotequeApplication.class, args);
	}

}
