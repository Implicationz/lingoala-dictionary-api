package com.lingosphinx.dictionary;

import org.springframework.boot.SpringApplication;

public class TestDictionaryApplication {

	public static void main(String[] args) {
		SpringApplication.from(DictionaryApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
