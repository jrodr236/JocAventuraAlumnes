public class HabitacioFosca extends Habitacio {
    private boolean illuminada = false;

    public HabitacioFosca(String nom, String descripcio){
        super(nom, descripcio);
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

    @Override
    public Item getItem(){
        if (!illuminada) {
            return null;
        }
        else {
            return super.getItem();
        }
    }
}
