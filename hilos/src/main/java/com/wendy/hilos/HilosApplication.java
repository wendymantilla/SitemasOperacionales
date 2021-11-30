package com.wendy.hilos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@SpringBootApplication
public class HilosApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(HilosApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Ejemplo de ejecucion de Hilos en Java");
        ExecutorService executor = Executors.newFixedThreadPool(10);
        executor.submit(() -> methodOne(100));
        executor.submit(() -> methodTwo(200));
    }


    private void methodOne(int times) {
        Long time = System.currentTimeMillis();
        IntStream.range(0, times).forEach(value -> {
            try {
                System.out.println("Ejecutando el metodo [methodOne] : 1 Segundo");
                Thread.sleep(1000);
            } catch (Exception ex) {
                System.out.print(ex.getMessage());
            }
        });
    }

    private void methodTwo(int times) {
        Long time = System.currentTimeMillis();
        IntStream.range(0, times).forEach(value -> {
            try {
                System.out.println("Ejecutando el metodo [methodTwo] : 2 segundos");
                Thread.sleep(2000);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        });

    }

}
