public class Llanterna extends Item {
    private boolean encesa;

    public Llanterna() {
        super("Llanterna", "Una llanterna que illumina les habitacions fosques.", true);
        this.encesa = false;
    }

    public boolean isEncesa() { return encesa; }

    public void usar() {
        encesa = !encesa;
        if (encesa) {
            System.out.println("Has encès la llanterna.");
        } else {
            System.out.println("Has apagat la llanterna.");
        }
    }

    @Override
    public String toString() {
        String estat = encesa ? "encesa" : "apagada";
        return getNom() + " (" + estat + ") - " + getDescripcio();
    }
}