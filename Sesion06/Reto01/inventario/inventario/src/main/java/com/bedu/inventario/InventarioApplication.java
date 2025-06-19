package com.bedu.inventario;

import com.bedu.inventario.entity.Producto;
import com.bedu.inventario.repository.ProductoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventarioApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(ProductoRepository repository) {
		return (args) -> {
			// Guardar algunos productos
			repository.save(new Producto("Laptop", "Portátil de 16 pulgadas", 1200.00));
			repository.save(new Producto("Teclado mecánico", "Switch azul", 800.00));
			repository.save(new Producto("Mouse gamer", "Alta precisión", 600.00));
			repository.save(new Producto("Mouse normal","Mouse bonito",350.0));
			// Mostrar todos los productos
			System.out.println("📂 Productos disponibles:");
			repository.findAll().forEach(System.out::println);

			// Buscar por nombre parcial
			System.out.println("\n🔍 Productos que contienen 'Lap':");
			repository.findByNombreContaining("Lap").forEach(System.out::println);

			System.out.println("Productos con precio mayor a $500.00");
			repository.findByPrecioGreaterThan(500.00).forEach(System.out::println);

			System.out.println("Productos con precio entre los $400 y $1000");
			repository.findByPrecioBetween(400.00,1000.00).forEach(System.out::println);

			System.out.println("Productos cuyo nombre empieza con m o M");
			repository.findByNombreStartingWithIgnoreCase("m").forEach(System.out::println);

		};
	}

}
