import java.util.concurrent.CompletableFuture;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MovilidadApp {
    public static CompletableFuture<String> calcularRuta() throws InterruptedException {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Calculando la ruta más óptima...");
            try {
                Thread.sleep(300); // Simula latencia de 3 segundos
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Ruta: Centro -> Norte";
        });
    }
    public static CompletableFuture<Double> estimarTarifa() throws InterruptedException {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Calculando la tarifa...");
            try {
                Thread.sleep(300); // Simula latencia de 3 segundos
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 53.8;
        });
    }
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Iniciado simulación");
        CompletableFuture<String> rutaFuture = calcularRuta();
        CompletableFuture<Double> tarifaFuture = estimarTarifa();

        CompletableFuture<Void> viajeFinal = rutaFuture.thenCombine(tarifaFuture,
        (ruta,tarifa)->{
          return "Ruta calculada: "+ruta+" Gasto total: "+tarifa;
        })
                .thenAccept(System.out::println)
                .exceptionally(ex ->{
                    System.out.println("Error :(");
                    return null;
                });
        viajeFinal.join();

    }
}