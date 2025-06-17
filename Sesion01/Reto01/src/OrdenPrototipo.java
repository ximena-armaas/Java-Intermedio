public class OrdenPrototipo extends OrdenProduccion {

        public String faseDesarrollo;

        public OrdenPrototipo(String codigo, int cantidad, String faseDesarrollo){
            super(codigo, cantidad);
            this.faseDesarrollo=faseDesarrollo;
        }

        @Override
        public void mostrarResumen(){
            System.out.println("Orden prototipo, fase de desarrollo: "+faseDesarrollo+" | Código: "+codigo+" | Cantidad: "+cantidad);
        }
}
