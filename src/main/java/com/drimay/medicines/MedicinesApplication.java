package com.drimay.medicines;

import com.drimay.medicines.idexConfiguration.LuceneIndexConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(LuceneIndexConfig.class)
@SpringBootApplication
public class MedicinesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicinesApplication.class, args);
	}

}
