public class HabitacioFosca extends Habitacio {
    private boolean illuminada = false;
    private Item itemAmagat;


    public HabitacioFosca(String nom, String descripcio, Item itemAmagat){
        super(nom, descripcio);
        this.itemAmagat = itemAmagat;
    }

    // TO DO: canviar per utilitzarItem()
    public String iluminarHabitacio(Jugador jugador){
        if (jugador.getItemInventari("Llanterna")){
            return super.toString();
        } else {
            return "---" + "---\n" +
                    "No veus res. Necessites una llanterna!\n" +
                    "Sortides visibles: cap";
        }
    }

    @Override
    public String toString() {
        if (!illuminada) {
            return "L'habitació és a les fosques, no es veu res.";
        }
        else {
            return super.toString();
        }
    }
}
