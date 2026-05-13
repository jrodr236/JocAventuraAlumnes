public class HabitacioAmbPortaTancada extends Habitacio {

    private boolean portaOberta;
    private String idClauRequerida;
    private Direccio direccioSortidaTancada;
    private Habitacio habitacioTancada;

    public HabitacioAmbPortaTancada(String nom, String descripcio, String idClauRequerida) {
        super(nom, descripcio);
        this.idClauRequerida = idClauRequerida;
        this.portaOberta = false;
    }

    public void setSortidaOculta(Direccio direccioSortidaTancada, Habitacio habitacioTancada) {
        this.direccioSortidaTancada = direccioSortidaTancada;
        this.habitacioTancada = habitacioTancada;

    }

    public boolean getPortaOberta() {
        return portaOberta;
    }

    // TO DO: canviar per utilitzarItem()
    public boolean intentarObrir(Clau clauJugador) {
        if (this.idClauRequerida.equals(clauJugador.getIdPany())) {
            this.portaOberta = true;
            Habitacio passadis2   = new Habitacio("Passadís Curt",      "Un passadís ple de teranyines pero mes curt. Sents passes al fons, pero un fons que esta mes aprop.");
            return true;
        }else {
            return false;
        }
    }

    // TO DO: afegir l'habitació tancada a les sortides "normals" un cop s'obri la porta
    @Override
    public Habitacio getSortida(Direccio direccio) {
        if (!portaOberta) {
            System.out.println("Et trobes davant una porta tancada més gran que en ratatui, veig que no posseeixes l'objecta necessari per prosseguir la teva aventura, toca el dos");
            return super.getSortida(direccio);
        }else {
            return super.getSortida(direccio);
        }
    }
}
