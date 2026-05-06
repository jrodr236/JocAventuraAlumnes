public class Llanterna extends Item {
    private boolean encesa;

    public Llanterna() {
        super("Llanterna", "Una llanterna que illumina les habitacions fosques.", true);
        this.encesa = false;
    }

    @Override
    public String toString() {
        String estat = encesa ? "encesa" : "apagada";
        return getNom() + " (" + estat + ") - " + getDescripcio();
    }
}
