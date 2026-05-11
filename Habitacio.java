import java.util.HashMap;

public class Habitacio {
    private String nom;
    private String descripcio;
    private HashMap<Direccio, Habitacio> sortides;
    private Item item;


    public Habitacio(String nom, String descripcio) {
        this.nom = nom;
        this.descripcio = descripcio;
        this.sortides = new HashMap<>();
        this.item = null;
    }

    public void setSortida(Direccio direccio, Habitacio vei) {
        sortides.put(direccio, vei);
    }

    public Habitacio getSortida(Direccio direccio) {
        return sortides.get(direccio);
    }

    // Mètodes per gestionar l'ítem
    public void setItem(Item item){
        this.item = item;
    }

    public Item getItem(){
        return item;
    }

    public void treureItem(){
        this.item = null;
    }

    @Override
    public String toString() {
        StringBuilder sortidesList = new StringBuilder();
        for (Direccio d : sortides.keySet()) {
            if (sortidesList.length() > 0) sortidesList.append(", ");
            sortidesList.append(d.toString().toLowerCase());
        }
        String textItem = (item != null) ? "\nHi ha un objecte aquí: " + item.getNom() : "";
        return "--- " + nom + " ---\n" +
                descripcio + textItem + "\n" +
                "Sortides visibles: " + (sortidesList.length() == 0 ? "cap" : sortidesList);
    }
}