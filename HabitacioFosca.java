public class HabitacioFosca extends Habitacio {
    boolean tiveus = false;
    private Item itemAmagat;


    public HabitacioFosca(String nom, String descripcio, Item itemAmagat){
        super("Habitacio fosca", "No t'hi veus. Tens po...");
        this.itemAmagat = itemAmagat;
    }

    public String iluminarHabitacio(Jugador jugador){
        if (jugador.getItemInventari("Llanterna")){
            return super.toString();
        } else {
            return "---" + "---\n" +
                    "No veus res. Necessites una llanterna!\n" +
                    "Sortides visibles: cap";
        }
    }
}
