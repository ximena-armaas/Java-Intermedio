import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Sucursal> sucursales = List.of(
                new Sucursal("Sucursal 1", List.of(
                        new Encuesta("Paciente 1", "Pésimo servicio",1),
                        new Encuesta("Paciente  2", null,5)
                )),
                new Sucursal("Sucursal 2", List.of(
                        new Encuesta("Paciente 3", "El servicion es excelente",5),
                        new Encuesta("Paciente 4", null, 3)

                )),
                new Sucursal("Sucursal 3", List.of(
                        new Encuesta("Paciente 5", "Servicio Regular",3),
                        new Encuesta("Paciente 6", null,1)
                ))
        );
        System.out.println("Pacientes con quejas");
        sucursales.stream()
                .flatMap(sucursal ->
                        sucursal.encuestas.stream()
                                .filter(e -> e.calificacion <=3)
                                .map(encuesta -> new Seguimiento(encuesta, sucursal.nombre))
                )
                .filter(seg ->seg.encuesta().getComentario().isPresent())
                .map(seg ->{
                    String comentario = seg.encuesta.getComentario().get();
                    String paciente = seg.encuesta.paciente;
                    return "Sucursal: "+seg.sucursal+ " | Paciente: "+paciente+" | Comentario: "+comentario;
                })
                .forEach(System.out::println);



    }
    record Seguimiento(Encuesta encuesta, String sucursal) {}

}