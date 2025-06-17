public class OrdenMasa extends OrdenProduccion{
    public OrdenMasa(String codigo, int cantidad){
        super(codigo, cantidad);
    }

    @Override
    public void mostrarResumen() {
        System.out.println("Orden de masa código: "+codigo+" | cantidad: "+cantidad);
    }
}
