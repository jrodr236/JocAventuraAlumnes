import java.util.HashMap;

public class Habitacio_fosca extends Habitacio {

    private String nom;
    private String descripcio;
    private HashMap<Direccio, Habitacio_fosca> sortides;
    boolean tiveus = false;

    public Habitacio_fosca(String nom, String descripcio){
        super("Habitacio fosca", "No t'hi veus. Tens po...");
        this.sortides = new HashMap<>();
    }

    public void setSortida(Direccio direccio, Habitacio_fosca vei) {
        sortides.put(direccio, vei);
    }

    public Habitacio_fosca getSortida(Direccio direccio) {
        return sortides.get(direccio);
    }



    public void IluminarHabitacio(Item Llanterna){


    };
}
