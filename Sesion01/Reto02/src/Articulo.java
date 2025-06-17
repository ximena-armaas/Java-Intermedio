public class Articulo extends MaterialCurso{

    public int palabras;

    public Articulo(String titulo, String autor, int palabras){
        super(titulo, autor);
        this.palabras=palabras;
    }

    @Override
    public void mostrarDetalle(){
        System.out.println("Detalle del material | Tipo: Articulo | Titulo: "+titulo+" | Autor: "+autor+" | Palabras: "+palabras+" palabras totales");
    }
}
