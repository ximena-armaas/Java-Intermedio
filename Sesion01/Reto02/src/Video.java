public class Video extends MaterialCurso {

    public int minutos;

    public Video(String titulo, String autor, int minutos){
        super(titulo, autor);
        this.minutos=minutos;
    }

    @Override
    public void mostrarDetalle(){
        System.out.println("Detalle del material | Tipo: Video | Titulo: "+titulo+" | Autor: "+autor+" | Duración: "+minutos+" minutos");
    }
}
