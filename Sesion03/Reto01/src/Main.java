import java.util.List;
import java.util.Optional;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Pedido> pedidos = List.of(
                new Pedido("Ximena", "Domicilio","555-3333"),
                new Pedido("David","Local","111-8888"),
                new Pedido("Reyna","Docimilio",null),
                new Pedido("Rogelio","Local",null)
        );
        List<String> mensajes = pedidos.stream()
                .filter(p ->p.tipoEntrega.equalsIgnoreCase("Domicilio"))
                .map(Pedido::getTelefono)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(tel -> "La confirmación se ha enviado al telefono: " + tel)
                .toList();
        System.out.println("Confirmación de pedido a domicilio");
        mensajes.forEach(System.out::println);
    }
}