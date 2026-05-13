import java.util.HashMap;

public class HabitacioFosca extends Habitacio {

    private Jugador jugador;
    private String nom;
    private String descripcio;
    private HashMap<Direccio, HabitacioFosca> sortides;
    boolean tiveus = false;


    public HabitacioFosca(String nom, String descripcio, Jugador jugador){
        super("Habitacio fosca", "No t'hi veus. Tens po...");
        this.jugador = jugador;
    }

    public String iluminarHabitacio(Jugador jugador){
        if (jugador.GetIteminventari("Llanterna")){
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
