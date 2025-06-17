import java.util.concurrent.Callable;

public class SistemaComunicaciones implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(900);
        return "Sistema de comunicaciones estableciendo contacto";
    }
}
