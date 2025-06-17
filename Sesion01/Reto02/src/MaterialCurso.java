public abstract class MaterialCurso {
    public String titulo;
    public String autor;

    public MaterialCurso(String titulo, String autor){
        this.titulo=titulo;
        this.autor=autor;
    }
    public abstract void mostrarDetalle();
}
