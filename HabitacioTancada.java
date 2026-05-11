

public class HabitacioTancada extends Habitacio {

    private boolean oberta;
    private String idClauRequerida;
    private Item item;
    private Clau clau;

    public HabitacioTancada(String nom, String descripcio, String idClauRequerida) {
        super(nom, descripcio);
        this.idClauRequerida = idClauRequerida;
        this.oberta = false;

    }

    public Clau getClau(){
        boolean tenirclau = false;

        return clau;
    }


    public void setItem(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public boolean estaOberta() {
        return oberta;
    }


    public String getIdClauRequerida() {
        return idClauRequerida;
    }

    public boolean intentarObrir(Clau clauJugador) {
        if (this.idClauRequerida.equals(clauJugador.getidPany())) {
            this.oberta = true;
            return true;
        }
        return false;
    }

    @Override
    public Habitacio getSortida(Direccio direccio) {
        if (!oberta) {
            System.out.println("Et trobes davant una porta tancada més gran que en ratatui, veig que no posseeixes l'objecta necessari per prosseguir la teva aventura, toca el dos");
            return null;
        }
        return super.getSortida(direccio);
    }

    @Override
    public String toString() {
        if (!oberta) {
            return "--- " + getItem() + " ---\nLa porta està tancada amb pany i clau.";
        }
        return super.toString() + "\n[Estat: Oberta]";
    }
}
