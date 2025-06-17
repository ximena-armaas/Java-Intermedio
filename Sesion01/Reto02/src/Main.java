import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void mostrarMateriales(List<? extends MaterialCurso> lista){
        System.out.println("Mostrando materiales");
        for(MaterialCurso material: lista){
            material.mostrarDetalle();
        }
    }

    public static void contarDuracion(List<? extends Video> lista){
        System.out.println("Contando la duración de los videos"); int duracion=0;
        for(Video video:lista){

            System.out.println("Duracioón del video: " + video.minutos);
            duracion+=video.minutos;

        }
        System.out.println("Duración total de los videos: "+duracion+" minutos");
    }

    public static void marcarEjercicio(List<? super Ejercicio> lista){
        System.out.println("Marcando ejercicio como revisado");
        for (Object obj : lista){
            if (obj instanceof Ejercicio){
                Ejercicio e = (Ejercicio) obj;
                e.revisado=true;
                System.out.println("Ejercicio: "+e.titulo+" marcado como revisado");
            }
        }
    }

    public static void filtrarAutor(List<? extends MaterialCurso> lista, Predicate<MaterialCurso> filtro){
        System.out.println("Filtar material por autor");
        for (MaterialCurso material : lista){
            if (filtro.test(material)){
                material.mostrarDetalle();
            }
        }
    }
    public static void main(String args[]){
        List<MaterialCurso> materiales = Arrays.asList(
                new Video("Video 1", "Ximena", 3),
                new Video("Video 2", "Juanito", 12),
                new Articulo("Articulo 1", "Juanito Per?z", 2500),
                new Articulo("Articulo 2","Pedrito Sola", 5000),
                new Ejercicio("Ejercicio 1","Fulanito",false),
                new Ejercicio("Ejercicio 2","Pereganita",false)
        );

        mostrarMateriales(materiales);
       // Filtrar para poder usar los otros métodos
        List<Video> videos = new ArrayList<>();
        List<Ejercicio> ejercicios = new ArrayList<>();
        for (MaterialCurso m : materiales) {
            if (m instanceof Video) {
                videos.add((Video) m);
            } else if (m instanceof Ejercicio) {
                ejercicios.add((Ejercicio) m);
            }
        }

        contarDuracion(videos);
        marcarEjercicio(ejercicios);
        filtrarAutor(materiales, m -> m.autor.equals("Ximena"));
    }}








