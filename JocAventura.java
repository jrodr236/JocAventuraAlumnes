import java.util.Scanner;
public class JocAventura {
    private Jugador jugador;
    public JocAventura() {
        Habitacio entrada    = new Habitacio("Entrada del Castell", "Una porta de ferro massís bloqueja el camí enrere. Està fosc.");
        Habitacio passadis   = new Habitacio("Passadís Llarg",      "Un passadís ple de teranyines. Sents passes al fons.");
        Habitacio biblioteca = new Habitacio("Biblioteca",           "Milers de llibres vells agafen pols. Hi ha una olor dolça.");
        Habitacio fosca = new Habitacio("Fosca",           "Timc po.");
        Habitacio tencada= new Habitacio("Tencada","Et trobas davant una porta tencada mes gran que en ratatui, veig que no poseeixes l'objecta necessari per proseguir la teva aventura, dona mitja volta i marxa");

        // Creem l'ítem i el posem a la biblioteca
        Llanterna llanterna = new Llanterna();
        biblioteca.setItem(llanterna);

        entrada.setSortida(Direccio.NORD, passadis);
        passadis.setSortida(Direccio.SUD, entrada);
        passadis.setSortida(Direccio.EST, biblioteca);
        biblioteca.setSortida(Direccio.OEST, passadis);
        passadis.setSortida(Direccio.NORD, tencada);
        passadis.setSortida(Direccio.OEST,fosca);
        tencada.setSortida(Direccio.SUD,passadis);
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
        boolean actiu = true;
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

                // NOUS CASOS PER ALS ITEMS

            case "agafar":
                Item itemHabitacio = jugador.getPosicioActual().getItem();
                if (itemHabitacio != null) {
                    if (itemHabitacio.isAgafable()) {
                        jugador.agafarItem(itemHabitacio);
                        jugador.getPosicioActual().treureItem();
                    } else {
                        System.out.println("No pots agafar això, no es pot moure.");
                    }
                } else {
                    System.out.println("No hi ha res aquí per agafar.");
                }
                break;

            case "inventari":
                jugador.mostrarInventari();
                break;

            case "ajuda":
                System.out.println("Comandes disponibles:");
                System.out.println("  anar [direcció] - Mou-te en una direcció (nord, sud, est, oest)");
                System.out.println("  mirar           - Observa l'habitació actual");
                System.out.println("  ajuda           - Mostra aquesta llista de comandes");
                System.out.println("  sortir          - Acaba la partida");
                System.out.println("  agafar          - Agafar l'Ítem que trobis");
                System.out.println("  inventari       - Mostrar el teu inventari d'Ítems");
                break;
            case "sortir":
                System.out.println("Fins la pròxima!");
                actiu = false;
                break;
            default:
                System.out.println("No sé com fer això.");
                break;
        }
        return actiu;
    }
}