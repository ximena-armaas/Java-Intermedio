public class PersonalMedico implements Runnable {
    public String nombre;
    public RecursoMedico recuso;
    public PersonalMedico(String nombre, RecursoMedico recuso){
        this.recuso=recuso;
        this.nombre=nombre;
    }

    @Override
    public void run(){
        try {
            recuso.usar(nombre);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
