import java.util.concurrent.Callable;

public class SistemaSoporteVial implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(1100);
        return "Sistema de soporte vial monitoreando oxigeno";
    }
}
