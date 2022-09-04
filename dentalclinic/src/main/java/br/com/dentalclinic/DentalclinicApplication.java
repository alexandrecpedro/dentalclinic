package br.com.dentalclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

@SpringBootApplication
public class DentalclinicApplication {

    public static void main(String[] args) {

        SpringApplication.run(DentalclinicApplication.class, args);

    }

}
