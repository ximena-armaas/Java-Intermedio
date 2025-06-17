public class OrdenPersonalizada extends OrdenProduccion{
    public String cliente;
    public OrdenPersonalizada(String codigo, int cantidad, String cliente){
        super(codigo, cantidad);
        this.cliente=cliente;
    }
    @Override
    public void mostrarResumen(){
        System.out.println("Orden personalizada al cliente: "+cliente+" | Código: "+codigo+" | Cantidad: "+cantidad);
    }
}
