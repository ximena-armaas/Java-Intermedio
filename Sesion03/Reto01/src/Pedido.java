import java.util.Optional;

public class Pedido {
    public String cliente;
    public String tipoEntrega;
    private String telefono;

    public Pedido(String cliente, String tipoEntrega, String telefono){
        this.cliente=cliente;
        this.tipoEntrega=tipoEntrega;
        this.telefono=telefono;
    }

    public Optional<String> getTelefono() {
        return Optional.ofNullable(telefono);
    }
}
