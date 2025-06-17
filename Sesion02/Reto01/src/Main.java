import java.util.concurrent.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor= Executors.newFixedThreadPool(4);
        Future<String> navegacion = executor.submit(new SistemaNavegacion());
        Future<String> comunicaciones = executor.submit(new SistemaComunicaciones());
        Future<String> controlTermico = executor.submit(new SistemaControlTermico());
        Future<String> soporteVial = executor.submit(new SistemaSoporteVial());

        System.out.println(navegacion.get());
        System.out.println(comunicaciones.get());
        System.out.println(controlTermico.get());
        System.out.println(soporteVial.get());

        executor.shutdown();

        System.out.println("Todos los sistemas reportaron estado operativo");

    }
}