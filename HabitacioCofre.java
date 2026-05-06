public class HabitacioCofre extends Habitacio {
    private Cofre cofre;

    public HabitacioCofre(String nom, String descripcio, Cofre cofre) {
        super(nom, descripcio);
        this.cofre = cofre;
    }

    public Cofre getCofre() {
        return cofre;
    }

    public void setCofre(Cofre cofre) {
        this.cofre = cofre;
    }

    public void obrirCofre(Jugador jugador) {
        if (cofre != null) {
            cofre.obrir(jugador);
        } else {
            System.out.println("No hi ha cap cofre aquí.");
        }
    }

    @Override
    public String toString() {
        String text = super.toString();
        if (cofre != null && !cofre.isObert()) {
            text += "\nHi ha un cofre tancat aquí.";
        } else if (cofre != null && cofre.isObert()) {
            text += "\nHi ha un cofre obert (buit).";
        }
        return text;
    }
}
