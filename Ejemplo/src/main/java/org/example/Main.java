package org.example;

public class Main {
    public static void main(String[] args) {
        CompletableFutureEjemplo ejemplo = new CompletableFutureEjemplo();
        ejemplo.ejecutarAsincronas();

        CompletableFutureEjemplo2 ejemplo2 = new CompletableFutureEjemplo2();
        ejemplo2.esperaTareaRapida();
    }
}