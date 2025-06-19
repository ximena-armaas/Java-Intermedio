package org.bedu.reto05;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;
import java.time.Duration;
import java.util.Random;
import java.lang.Thread;
import java.io.*;
@SpringBootApplication
public class Reto05Application {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(Reto05Application.class, args);

		Random random = new Random();

		// Flujo del sensor de tráfico
		Flux<Integer> trafico = Flux.interval(Duration.ofMillis(500))
				.map(i -> random.nextInt(101))
				.filter(congestion -> congestion > 70)
				.doOnNext(congestion -> System.out.println("Advertencia: Congestión de más del 70% con un " + congestion + "%"))
				.onBackpressureBuffer(5);

		// Flujo de contaminación del aire
		Flux<Integer> contaminacion = Flux.interval(Duration.ofMillis(600))
				.map(i -> random.nextInt(80))
				.filter(pm -> pm > 50)
				.doOnNext(pm -> System.out.println("Advertencia, la contaminación es muy alta con: PM2.5 "+pm+" ug/m3"));

		// Flujo de accidentes
		Flux<String> accidentes = Flux.interval(Duration.ofMillis(800))
				.map(i -> {
					String[] prioridades = {"Baja", "Media", "Alta"};
					return prioridades[random.nextInt(prioridades.length)];
				})
				.filter(prioridad -> prioridad.equals("Alta"))
				.doOnNext(prioridad -> System.out.println("Advertencia, accidente de prioridad: " + prioridad));

		// Flujo de trenes
		Flux<Integer> trenes = Flux.interval(Duration.ofMillis(700))
				.map(i -> random.nextInt(11))
				.filter(retraso -> retraso > 5)
				.doOnNext(retraso -> System.out.println("El retraso es mayor a 5 mins. Minutos de retraso totales: " + retraso + " minutos"))
				.onBackpressureBuffer(3); // Backpressure en trenes

		// Flujo de semaforos
		Flux<String> semaforos = Flux.interval(Duration.ofMillis(400))
				.map(i -> {
					String[] estados = {"Verde", "Amarillo", "Rojo"};
					return estados[random.nextInt(estados.length)];
				})
				.transform(Reto05Application::controlarSemaforos);


		Flux.merge(trafico, contaminacion, accidentes, trenes, semaforos)
				.bufferTimeout(5, Duration.ofSeconds(2)) //
				.filter(lista -> lista.size() >= 3)
				.doOnNext(lista -> System.out.println("Advertencia: Hay 3 o más eventos criticos sucediendo al mismo tiempo"))
				.subscribe();

		 Thread.sleep(15000);
	}


	private static Flux<String> controlarSemaforos(Flux<String> flujo) {
		final int[] contadorRojos = {0};
		return flujo
				.filter(estado -> {
					if (estado.equals("Rojo")) {
						contadorRojos[0]++;
						if (contadorRojos[0] >= 3) {
							contadorRojos[0] = 0;
							return true;
						}
					} else {
						contadorRojos[0] = 0;
					}
					return false;
				})
				.doOnNext(estado -> System.out.println("El semaforo ha estado más de 3 veces en rojo"));
	}

}
