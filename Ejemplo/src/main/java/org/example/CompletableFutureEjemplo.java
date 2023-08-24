package org.example;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
public class CompletableFutureEjemplo {
    public void ejecutarAsincronas() {
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

        CompletableFuture<Void> terminar = CompletableFuture.allOf(futuro1, futuro2, futuro3, futuro4);

        try {
            terminar.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


        int suma = futuro1.join() + futuro2.join() + futuro3.join() + futuro4.join();


        System.out.println("Suma de los valores generados: " + suma);
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
