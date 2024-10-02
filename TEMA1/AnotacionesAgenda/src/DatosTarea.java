public class DatosTarea {
    private String tituloTarea;
    private String descripcionTarea;
    private Integer diaSemana;
    private Integer hora;


    public DatosTarea(String tituloTarea, String descripcionTarea, Integer diaSemana, Integer hora) {
        this.tituloTarea = tituloTarea;
        this.descripcionTarea = descripcionTarea;
        this.diaSemana = diaSemana;
        this.hora = hora;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("DatosTarea{");
        sb.append("tituloTarea='").append(tituloTarea).append('\'');
        sb.append(", descripcionTarea='").append(descripcionTarea).append('\'');
        sb.append(", diaSemana='").append(diaSemana).append('\'');
        sb.append(", hora='").append(hora).append('\'');
        sb.append("\n}");
        return sb.toString();
    }
}
