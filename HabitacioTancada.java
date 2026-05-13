import java.util.HashMap;

public class HabitacioTancada extends Habitacio {

    private boolean oberta;
    private String idClauRequerida;
    private Item item;
    private Clau clau;
    private Direccio direccioSortidaTancada;
    private Habitacio sortidaTancada;


    public HabitacioTancada(String nom, String descripcio, String idClauRequerida) {
        super(nom, descripcio);
        this.idClauRequerida = idClauRequerida;
        this.oberta = false;
    }

    public void setSortidaOculta(Direccio direccioSortidaTancada, Habitacio sortidaTancada) {
        this.direccioSortidaTancada = direccioSortidaTancada;
        this.sortidaTancada = sortidaTancada;

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
        if (this.idClauRequerida.equals(clauJugador.getIdPany())) {
            this.oberta = true;
            Habitacio passadis2   = new Habitacio("Passadís Curt",      "Un passadís ple de teranyines pero mes curt. Sents passes al fons, pero un fons que esta mes aprop.");
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Habitacio getSortida(Direccio direccio) {
        if (!oberta) {
            System.out.println("Et trobes davant una porta tancada més gran que en ratatui, veig que no posseeixes l'objecta necessari per prosseguir la teva aventura, toca el dos");
            return super.getSortida(direccio);
        }else {
            return super.getSortida(direccio);
        }
    }
}
