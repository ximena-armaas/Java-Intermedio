import java.util.concurrent.Callable;

public class SistemaNavegacion implements Callable<String> {
    public String call() throws Exception{
        Thread.sleep(1000);
        return "Sistema de navegación: Calculando trayectoria";
    }
}
