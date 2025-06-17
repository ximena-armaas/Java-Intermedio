import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando simulación");
        RecursoMedico salaUrgencias = new RecursoMedico("Sala de urgencias");

        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.submit(new PersonalMedico("Dra. Armas",salaUrgencias));
        executor.submit(new PersonalMedico("Dr. Juan", salaUrgencias));
        executor.submit(new PersonalMedico("Dr. Pedrito", salaUrgencias));

        executor.shutdown();
    }
}