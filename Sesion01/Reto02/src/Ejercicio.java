public class Ejercicio extends MaterialCurso{

    public boolean revisado;

    public Ejercicio(String titulo, String autor, boolean revisado){
        super(titulo, autor);
        this.revisado=revisado;
    }

    @Override
    public void mostrarDetalle(){
        System.out.println("Detalle del material | Tipo: Ejercicio | Titulo: "+titulo+" | Autor: "+autor+" | Revisado: "+(revisado ? "Si": "No"));
    }
}
