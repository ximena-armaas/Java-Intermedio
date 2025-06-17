public abstract class OrdenProduccion {
    public String codigo;
    public int cantidad;

    public OrdenProduccion(String codigo, int cantidad){
        this.codigo=codigo;
        this.cantidad=cantidad;
    }

    public abstract void mostrarResumen();
}
