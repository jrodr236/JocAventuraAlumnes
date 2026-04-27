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

    public void afegirItem(Item item) {
        items.add(item);
    }

    public String getNom() { return nom; }
    public boolean isObert() { return obert; }

    public void obrir() {
        if (!obert) {
            obert = true;
            System.out.println("Has obert " + nom + ".");
            if (items.isEmpty()) {
                System.out.println("El cofre és buit.");
            } else {
                System.out.println("Contingut del cofre:");
                for (Item item : items) {
                    System.out.println("  - " + item);
                }
            }
        } else {
            System.out.println(nom + " ja està obert. Contingut:");
            if (items.isEmpty()) {
                System.out.println("  (buit)");
            } else {
                for (Item item : items) {
                    System.out.println("  - " + item);
                }
            }
        }
    }

    public Item agafarItem(String nomItem) {
        if (!obert) {
            System.out.println("Has d'obrir " + nom + " primer!");
            return null;
        }
        for (Item item : items) {
            if (item.getNom().equalsIgnoreCase(nomItem)) {
                if (item.isAgafable()) {
                    items.remove(item);
                    return item;
                } else {
                    System.out.println("No pots agafar " + item.getNom() + ".");
                    return null;
                }
            }
        }
        System.out.println("No hi ha cap '" + nomItem + "' al cofre.");
        return null;
    }

    public List<Item> getItems() { return items; }

    @Override
    public String toString() {
        return nom + (obert ? " [obert]" : " [tancat]");
    }
}
