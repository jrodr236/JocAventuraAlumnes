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

    public void obrirCofre() {
        if (cofre != null) {
            System.out.println(cofre.obrir());
        } else {
            System.out.println("No hi ha cap cofre aquí.");
        }
    }

    public void agafarDelCofre(Jugador jugador, String nomItem) {
        if (cofre != null && cofre.isObert()) {
            Item item = cofre.agafarItem(nomItem);
            if (item != null) {
                jugador.agafarItem(item);
                System.out.println("Has agafat: " + item.getNom());
            } else {
                System.out.println("No hi ha cap item amb aquest nom al cofre.");
            }
        } else if (cofre != null && !cofre.isObert()) {
            System.out.println("Primer has d'obrir el cofre amb 'obrir cofre'.");
        } else {
            System.out.println("No hi ha cap cofre aquí.");
        }
    }

    @Override
    public String toString() {
        String text = super.toString();
        if (cofre != null) {
            text += "\n" + cofre.toString();
        }
        return text;
    }
}
