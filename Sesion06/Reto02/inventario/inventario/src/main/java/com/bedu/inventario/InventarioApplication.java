package com.bedu.inventario;

import com.bedu.inventario.entity.Categoria;
import com.bedu.inventario.entity.Marca;
import com.bedu.inventario.entity.Producto;
import com.bedu.inventario.repository.CategoriaRepository;
import com.bedu.inventario.repository.MarcaRepository;
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
	public CommandLineRunner demo(ProductoRepository productoRepo, CategoriaRepository categoriaRepo, MarcaRepository marcaRepo) {
		return (args) -> {
			Categoria tecnologia = new Categoria("Tecnología");
			categoriaRepo.save(tecnologia);

			Marca dell = new Marca("Dell");
			Marca asus = new Marca("Asus");
			marcaRepo.save(dell);
			marcaRepo.save(asus);


			productoRepo.save(new Producto("Laptop ASUS ROG Strix SCAR 18", "Intel Core i9, RTX 5090", 90000.00, tecnologia, asus));
			productoRepo.save(new Producto("Laptop MSI Titan 18 HX", "Intel Core i9, RTX 4090", 140000.00, tecnologia, dell));

			System.out.println("📂 Productos registrados:");
			productoRepo.findAll().forEach(p -> System.out.println(p.getNombre() + " - " + p.getCategoria().getNombre()));
			System.out.println("📚 Productos por marca:");
			marcaRepo.findAll().forEach(marca -> {
				System.out.println("🏷️ " + marca.getNombreMarca() + ":");
				productoRepo.findAll().stream()
						.filter(p -> p.getMarca().getIdMarca().equals(marca.getIdMarca()))
						.forEach(p -> System.out.println("   - " + p.getNombre()));
			});

		};
	}

}
