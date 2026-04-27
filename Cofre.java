import java.util.ArrayList;
import java.util.List;

public class Cofre {
    private String nom;
    private List<Item> items;
    private boolean obert;

    public Cofre(String nom) {
        this.nom = nom;
        this.items = new ArrayList<>();
        this.obert = false;
    }

    public void afegirItem(Item item) { items.add(item); }
    public String getNom() { return nom; }
    public boolean isObert() { return obert; }
    public List<Item> getItems() { return items; }

    public void obrir() {
        obert = true;
        System.out.println("Obres " + nom + ". Contingut: " + items);
    }

    public Item agafarItem(String nomItem) {
        if (!obert) { System.out.println("Primer has d'obrir el cofre!"); return null; }
        for (Item item : items) {
            if (item.getNom().equalsIgnoreCase(nomItem)) {
                items.remove(item);
                return item;
            }
        }
        System.out.println("No hi ha '" + nomItem + "' al cofre.");
        return null;
    }

    @Override
    public String toString() { return nom + (obert ? " [obert]" : " [tancat]"); }
}
