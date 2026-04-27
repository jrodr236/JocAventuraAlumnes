import java.util.ArrayList;

public class Cofre {
    private ArrayList<Item> items = new ArrayList<>();
    private boolean obert = false;

    public void afegirItem(Item item) { items.add(item); }

    public String obrir() {
        obert = true;
        return items.isEmpty() ? "El cofre és buit." : "Contingut: " + items;
    }

    public Item agafarItem(String nom) {
        if (!obert) return null;
        for (Item item : items)
            if (item.getNom().equalsIgnoreCase(nom)) { items.remove(item); return item; }
        return null;
    }

    public boolean isObert() { return obert; }

    public String toString() {
        return obert ? "Cofre obert. Contingut: " + items : "Hi ha un cofre tancat.";
    }
}
