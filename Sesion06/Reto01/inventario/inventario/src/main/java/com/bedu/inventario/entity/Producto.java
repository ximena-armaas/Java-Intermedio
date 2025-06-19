package com.bedu.inventario.entity;
import jakarta.persistence.*;


@Entity

public class Producto {
    @Id // Campo que funcionará como clave primaria de la tabla
    @GeneratedValue(strategy = GenerationType.IDENTITY) // El ID se generará automáticamente (autoincremental)
    private Long id;

    // Campos que serán columnas en la tabla 'producto'

    private String nombre;
    private String descripcion;
    private double precio;

    protected Producto() {} // Constructor por defecto requerido por JPA

    // Constructor público para crear objetos de tipo Producto con los campos necesarios
    public Producto(String nombre, String descripcion, double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    // Getters para acceder a los atributos (necesarios para el funcionamiento de JPA y buenas prácticas)
    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public double getPrecio() { return precio; }

    // Método que permite imprimir el objeto de forma legible (útil para logs o consola)
    @Override
    public String toString() {
        return String.format("Producto[id=%d, nombre='%s', precio=%.2f]",
                id, nombre, precio);
    }
}
