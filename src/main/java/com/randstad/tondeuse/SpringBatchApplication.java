package com.randstad.tondeuse;

import com.randstad.tondeuse.service.GlobalTraitement;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class SpringBatchApplication implements CommandLineRunner {

	protected static List<String> listResultats;
	public static void main(String[] args) {
		SpringApplication.run(SpringBatchApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
try {
	if (args.length >= 1) {
		File file = new File(args[0]);
		GlobalTraitement instance = new GlobalTraitement();
		instance.lancerTraitementsTondeuses(file).stream()
				.forEach(System.out::println);
	} else {
		throw new IllegalArgumentException();
	}
} catch (IllegalStateException e) {
	throw new IllegalStateException(" Failed to execute CommandLineRunnerrr ");
}
	}
}
