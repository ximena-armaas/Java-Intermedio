import java.util.*;

public class GestionOrdenes {

    public static void mostrarOrdenes(List<? extends OrdenProduccion> lista) {
        //Mensaje que se mostrará
        System.out.println("\n📋 Órdenes registradas:");

        //Ciclo para recorrer cada item de la lista
        for (OrdenProduccion orden : lista) {
            //Cada item manda a mostrar el resumen
            orden.mostrarResumen();
        }
    }


    //Metodo para procesar las ordenes personalizadas
    public static void procesarPersonalizadas(List<? super OrdenPersonalizada> lista, int costoAdicional) {
        System.out.println("\n💰 Ordenes personalizadas:");

        //Ciclo para cada item de la lista
        for (Object obj : lista) {
            //Verifica si es de tipo orden personalizada
            if (obj instanceof OrdenPersonalizada) {
                OrdenPersonalizada op = (OrdenPersonalizada) obj;
                System.out.println("Orden con código: " + op.codigo + " con costo adicional de $" + costoAdicional);
            }
        }
    }

    //Desafio opcional
    public static void contarOrdenes(List<? extends OrdenProduccion> lista) {
        long masas = lista.stream().filter(o -> o instanceof OrdenMasa).count();
        long personalizadas = lista.stream().filter(o -> o instanceof OrdenPersonalizada).count();
        long prototipos = lista.stream().filter(o -> o instanceof OrdenPrototipo).count();

        System.out.println("\n Resumen de órdenes:");
        System.out.println("Ordenes en masa totales: " + masas);
        System.out.println("Ordenes personalizada totales: " + personalizadas);
        System.out.println("Prototipos: " + prototipos);
    }

    public static void main(String[] args) {
        List<OrdenProduccion> todasLasOrdenes = new ArrayList<>();

        //Lista de tipo orden masa
        List<OrdenMasa> masas = Arrays.asList(
                new OrdenMasa("AA1", 100),
                new OrdenMasa("AA2", 50)
        );

        //Lista de tipo personalizada
        List<OrdenPersonalizada> personalizadas = Arrays.asList(
                new OrdenPersonalizada("BB1", 10, "Cliente uno"),
                new OrdenPersonalizada("BB2", 50, "Cliente dos")
        );


        //Lista de tipo prototipo
        List<OrdenPrototipo> prototipos = Arrays.asList(
                new OrdenPrototipo("CC1", 1, "Diseño"),
                new OrdenPrototipo("CC2", 5, "Pruebas")
        );

        // Agregamos todas las órdenes a la lista combinada
        todasLasOrdenes.addAll(masas);
        todasLasOrdenes.addAll(personalizadas);
        todasLasOrdenes.addAll(prototipos);

        // Mostrar órdenes por tipo
        mostrarOrdenes(masas);
        mostrarOrdenes(personalizadas);
        mostrarOrdenes(prototipos);

        // Procesar órdenes personalizadas
        procesarPersonalizadas(personalizadas, 200);

        //Contar las ordenes de cada tipo
        contarOrdenes(todasLasOrdenes);
    }
}