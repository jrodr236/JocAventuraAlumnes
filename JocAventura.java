import java.util.Scanner;

public class JocAventura {
    private Jugador jugador;

    public JocAventura() {
        Habitacio entrada    = new Habitacio("Entrada del Castell", "Una porta de ferro massís bloqueja el camí enrere. Està fosc.");
        Habitacio passadis   = new Habitacio("Passadís Llarg",      "Un passadís ple de teranyines. Sents passes al fons.");
        Habitacio biblioteca = new Habitacio("Biblioteca",           "Milers de llibres vells agafen pols. Hi ha una olor dolça.");
        Habitacio fosca = new Habitacio("Fosc",           "Timc po.");

        entrada.setSortida(Direccio.NORD, passadis);
        passadis.setSortida(Direccio.SUD, entrada);
        passadis.setSortida(Direccio.EST, biblioteca);
        biblioteca.setSortida(Direccio.OEST, passadis);
        passadis.setSortida(Direccio.OEST, fosca);
        fosca.setSortida(Direccio.EST, passadis);

        this.jugador = new Jugador(entrada);
    }

    public void executar() {
        System.out.println("BENVINGUT A L'AVENTURA TEXTUAL");
        System.out.println("Escriu 'ajuda' per veure les comandes disponibles.");
        System.out.println(jugador.getPosicioActual());

        try (Scanner teclat = new Scanner(System.in)) {
            boolean actiu = true;
            while (actiu) {
                System.out.print("\n> ");
                String[] parts = teclat.nextLine().toLowerCase().trim().split("\\s+");
                if (parts.length == 0 || parts[0].isEmpty()) continue;
                actiu = executarComanda(parts);
            }
        }
    }

    private boolean executarComanda(String[] parts) {
        switch (parts[0]) {
            case "anar":
                if (parts.length > 1) {
                    Direccio dir = Direccio.desDeString(parts[1]);
                    if (dir != null) {
                        jugador.moureA(dir);
                    } else {
                        System.out.println("Aquesta direcció no existeix.");
                    }
                } else {
                    System.out.println("Anar on?");
                }
                break;

            case "mirar":
                System.out.println(jugador.getPosicioActual());
                break;

            case "ajuda":
                System.out.println("Comandes disponibles:");
                System.out.println("  anar [direcció] - Mou-te en una direcció (nord, sud, est, oest)");
                System.out.println("  mirar           - Observa l'habitació actual");
                System.out.println("  ajuda           - Mostra aquesta llista de comandes");
                System.out.println("  sortir          - Acaba la partida");
                break;

            case "sortir":
                System.out.println("Fins la pròxima!");
                return false;

            default:
                System.out.println("No sé com fer això.");
                break;
        }
        return true;
    }
}