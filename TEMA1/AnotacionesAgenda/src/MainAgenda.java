public class MainAgenda {
    public static void main(String[] args) {
        AgendaSemana ag = new AgendaSemana("AgendaDavid");

        AgendaSemana.cargadorTarea(ag);

        System.out.println(ag);
    }
}