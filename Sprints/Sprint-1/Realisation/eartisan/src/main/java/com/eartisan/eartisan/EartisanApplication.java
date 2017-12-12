package com.eartisan.eartisan;

import com.eartisan.eartisan.DAO.DomaineRepository;
import com.eartisan.eartisan.entities.Domaine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class EartisanApplication implements CommandLineRunner {
	@Autowired
	DomaineRepository domaineRepository;
	public static void main(String[] args) {
		SpringApplication.run(EartisanApplication.class, args);
		//ApplicationContext ctx=SpringApplication.run(EartisanApplication.class, args);

	}

	@Override
	public void run(String... strings) throws Exception {
		domaineRepository.save(new Domaine("Plomberie"));
		domaineRepository.save(new Domaine("Electricité"));
		domaineRepository.save(new Domaine("Électronique"));
		List<Domaine> domaines=domaineRepository.findAll();
		domaines.forEach(d->System.out.println(d.getName()));
	}
}
