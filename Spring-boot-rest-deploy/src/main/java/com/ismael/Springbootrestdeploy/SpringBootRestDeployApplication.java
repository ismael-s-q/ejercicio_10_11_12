package com.ismael.Springbootrestdeploy;

import com.ismael.Springbootrestdeploy.entities.Laptop;
import com.ismael.Springbootrestdeploy.repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootRestDeployApplication {



	public static void main(String[] args) {
	ApplicationContext context =
			SpringApplication.run(SpringBootRestDeployApplication.class, args);


	LaptopRepository repository = context.getBean(LaptopRepository.class);



		Laptop laptop1 = new Laptop(null,"php",22,"white");

		Laptop laptop2 = new Laptop(null,"apple",25,"negro");

		Laptop laptop3 = new Laptop(null,"dell",30,"amarillo");


		repository.save(laptop1);
		repository.save(laptop2);
		repository.save(laptop3);


	}



}
