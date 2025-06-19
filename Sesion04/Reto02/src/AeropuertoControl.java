import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import static java.lang.Integer.parseInt;
import static java.lang.Math.random;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class AeropuertoControl {

    public static CompletableFuture<Boolean> verificarPista() throws InterruptedException {
        return CompletableFuture.supplyAsync(()->{
            System.out.println("Verificando pista");
            boolean resultado;
            try {
                esperar(2);
                resultado = calcularProbabilidad()>80.0;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return resultado;
        });
    }

    public static CompletableFuture<Boolean> verificarClima(){
        return CompletableFuture.supplyAsync(()->{
            System.out.println("Verificando clima");
            boolean resultado;
            try {
                esperar(3);
                resultado=calcularProbabilidad()>60.0;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return resultado;
        });
    }

    public static CompletableFuture<Boolean> verificarTraficoAereo(){
        return CompletableFuture.supplyAsync(()->{
            System.out.println("Verificando tráfico aereo");
            boolean resultado;
            try {
                esperar(2);
                resultado=calcularProbabilidad()>50.0;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return resultado;
        });
    }

    public static CompletableFuture<Boolean> verificarPersonalTierra(){
        return CompletableFuture.supplyAsync(()->{
            System.out.println("Verificando personal en tierra");
            boolean resultado;
            try {
                esperar(3);
                resultado=calcularProbabilidad()>65.0;

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return resultado;
        });
    }

    public static void esperar(int segundos) throws InterruptedException {
        TimeUnit.SECONDS.sleep(segundos);
    }


    public static double calcularProbabilidad(){
        double probabilidad =(random()*100);
        double finalTotal = Math.round(probabilidad);
        return finalTotal;
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Empieza proceso para verificar condiciones");
        CompletableFuture<Boolean> pistaFuture = verificarPista();
        CompletableFuture<Boolean> climaFuture = verificarClima();
        CompletableFuture<Boolean> traficoFuture = verificarTraficoAereo();
        CompletableFuture<Boolean> personalFuture = verificarPersonalTierra();

        CompletableFuture<Void> control = CompletableFuture.allOf(pistaFuture, climaFuture, traficoFuture, personalFuture)
                .thenAccept(v -> {
                    try {
                        boolean pistaRes = pistaFuture.get();
                        boolean climaRes = climaFuture.get();
                        boolean traficoRes = traficoFuture.get();
                        boolean personalRes = personalFuture.get();

                        if (pistaRes && climaRes && traficoRes && personalRes) {
                            System.out.println("Condiciones de aterrizaje adeacuadas. | Vuelo autorizado");
                        } else {
                            System.out.println("Las condiciones no son adecuadas para el aterrizaje");
                            System.out.println(pistaRes+" "+climaRes+" "+traficoRes+ " "+personalRes);
                        }
                    } catch (InterruptedException | ExecutionException e) {
                        System.out.println("Error en la evaluacion de las condiciones: " + e.getMessage());
                    }
                })
                .exceptionally(ex -> {
                    System.out.println("Error durante el aterrizaje");
                    return null;
                });
        control.join();


    }
}