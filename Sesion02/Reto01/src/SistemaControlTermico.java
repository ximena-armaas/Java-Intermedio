import java.util.concurrent.Callable;

public class SistemaControlTermico implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(1200);
        return "Sistema de control térmico suspervisando temperatura exterior";
    }
}
