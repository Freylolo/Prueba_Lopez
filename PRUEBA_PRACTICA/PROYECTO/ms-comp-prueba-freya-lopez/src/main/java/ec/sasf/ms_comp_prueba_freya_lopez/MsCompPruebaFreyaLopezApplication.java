package ec.sasf.ms_comp_prueba_freya_lopez;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@EnableJpaAuditing
@SpringBootApplication
public class MsCompPruebaFreyaLopezApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsCompPruebaFreyaLopezApplication.class, args);
	}

}
