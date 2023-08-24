package org.example;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
public class CompletableFutureEjemplo2 {
    public void esperaTareaRapida() {
        CompletableFuture<Integer> futuro1 = CompletableFuture.supplyAsync(() -> {
            int numero = numeroRandom();
            simularEspera(1000);
            return numero;
        });

        CompletableFuture<Integer> futuro2 = CompletableFuture.supplyAsync(() -> {
            int numero = numeroRandom();
            simularEspera(1500);
            return numero;
        });

        CompletableFuture<Integer> futuro3 = CompletableFuture.supplyAsync(() -> {
            int numero = numeroRandom();
            simularEspera(2000);
            return numero;
        });

        CompletableFuture<Integer> futuro4 = CompletableFuture.supplyAsync(() -> {
            int numero = numeroRandom();
            simularEspera(500);
            return numero;
        });

        CompletableFuture<Object> futuroRapido = CompletableFuture.anyOf(futuro1, futuro2, futuro3, futuro4);

        try {
            Integer resultado = (Integer) futuroRapido.get();
            System.out.println("El valor de la tarea más rápida es: " + resultado);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    private int numeroRandom() {
        return (int) (Math.random() * 401) + 100;
    }

    private void simularEspera(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
