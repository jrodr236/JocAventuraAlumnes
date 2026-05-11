public class Mapa {
    private Habitacio habitacioInicial;

    public Mapa() {
        Habitacio entrada = new Habitacio(
                "Entrada del Castell",
                "Una porta de ferro massís bloqueja el camí enrere. Està fosc."
        );
        habitacioInicial = entrada;

        Habitacio passadisLlarg = new Habitacio(
                "Passadís Llarg",
                "Un passadís ple de teranyines. Sents passes al fons."
        );
        Habitacio passadisCurt = new Habitacio(
                "Passadís Curt",
                "Un passadís ple de teranyines pero mes curt. Sents passes al fons, pero un fons que esta mes aprop."
        );
        Habitacio biblioteca = new Habitacio(
                "Biblioteca",
                "Milers de llibres vells agafen pols. Hi ha una olor dolça."
        );
        Habitacio fosca = new Habitacio(
                "Fosca",
                "Tinc po."
        );
        Habitacio tancada = new HabitacioTancada(
                "Tancada",
                "Et trobas davant una porta tancada mes gran que en ratatui, veig que no poseeixes l'objecta necessari per proseguir la teva aventura, dona mitja volta i marxa",
                "clau"
        );
        HabitacioCofre salaTresor = new HabitacioCofre(
                "Sala del Tresor",
                "Una habitació plena de joies i or."
        );

        Llanterna llanterna = new Llanterna();
        biblioteca.setItem(llanterna);

        Clau clau = new Clau("clau");
        passadisLlarg.setItem(clau);

        entrada.setSortida(Direccio.NORD, passadisLlarg);
        passadisLlarg.setSortida(Direccio.SUD, entrada);
        passadisLlarg.setSortida(Direccio.EST, biblioteca);
        passadisLlarg.setSortida(Direccio.OEST, fosca);
        passadisLlarg.setSortida(Direccio.NORD, tancada);
        passadisLlarg.setSortida(Direccio.OEST, fosca);
        tancada.setSortida(Direccio.SUD, passadisLlarg);
        tancada.setSortida(Direccio.NORD, passadisCurt);
        passadisCurt.setSortida(Direccio.NORD, salaTresor);
        passadisCurt.setSortida(Direccio.SUD, tancada);
        fosca.setSortida(Direccio.SUD, passadisLlarg);
        passadisLlarg.setSortida(Direccio.SUD, salaTresor);
        salaTresor.setSortida(Direccio.SUD, passadisCurt);
    }

    public Habitacio getHabitacioInicial() {
        return habitacioInicial;
    }
}
