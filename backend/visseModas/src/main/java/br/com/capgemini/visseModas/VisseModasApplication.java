package br.com.capgemini.visseModas;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport //dar suporte a paginacao
public class VisseModasApplication {

	public static void main(String[] args) {
		SpringApplication.run(VisseModasApplication.class, args);
	}

}
