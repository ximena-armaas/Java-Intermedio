import java.util.concurrent.locks.ReentrantLock;

public class RecursoMedico {
    public String nombre;
    private final ReentrantLock lock = new ReentrantLock();

    public RecursoMedico(String nombre){
        this.nombre=nombre;
    }

    public void usar(String profesional) throws InterruptedException {
        lock.lock();
        try{
            System.out.println("Ingresa profesional: "+profesional+" al recurso médico");
            Thread.sleep(900);
            System.out.println("El personal a tardado 900ms en el recurso médico");
            System.out.println("El personal sale del recurso");
        } catch (InterruptedException e) {
            System.out.println("El recurso está ocupado");
        } finally {
            lock.unlock();
        }
    }
}
