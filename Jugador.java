import java.util.ArrayList;
import java.util.List;
public class Jugador {
    private Habitacio posicioActual;
    private List<Item> inventari;

    public Jugador(Habitacio inici) {

        this.posicioActual = inici;
        this.inventari = new ArrayList<>();
    }

    public Habitacio getPosicioActual() { return posicioActual; }

    public void agafarItem(Item item) {
        inventari.add(item);
        System.out.println("Has guardat '" + item.getNom() + "' a l'inventari.");
    }

    public void mostrarInventari() {
        if (inventari.isEmpty()) {
            System.out.println("L'inventari està buit.");
        } else {
            System.out.println("Portes a sobre:");
            for (Item i : inventari) {
                System.out.println("- " + i.getNom());
            }
        }
    }

    public Item getItemInventari(String nomItem) {
        for (Item i : inventari) {
            if (i.getNom().equalsIgnoreCase(nomItem)) {
                return i;
            }
        }
        return null;
    }

    public void moureA(Direccio direccio) {
        Habitacio seguent = posicioActual.getSortida(direccio);
        if (seguent != null) {
            posicioActual = seguent;
            System.out.println("T'has mogut cap al " + direccio.toString().toLowerCase() + ".");
            System.out.println(posicioActual);
        } else {
            System.out.println("No hi ha cap sortida en aquesta direcció!");
        }
    }
}