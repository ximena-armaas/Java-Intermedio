import java.util.List;

public class Sucursal {
    public String nombre;
    public List<Encuesta> encuestas;

    public Sucursal(String nombre, List<Encuesta> encuestas){
        this.encuestas=encuestas;
        this.nombre=nombre;
    }
}
