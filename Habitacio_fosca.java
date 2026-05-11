import java.util.HashMap;

public class Habitacio_fosca extends Habitacio {

    private Jugador jugador;
    private String nom;
    private String descripcio;
    private HashMap<Direccio, Habitacio_fosca> sortides;
    boolean tiveus = false;


    public Habitacio_fosca(String nom, String descripcio, Jugador jugador){
        super("Habitacio fosca", "No t'hi veus. Tens po...");
        this.jugador = jugador;
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



    public void IluminarHabitacio(){

    };
}
