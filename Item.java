public class Item {
        private String nom;
        private String descripcio;
        private boolean agafar;

        public Item(String nom, String descripcio, boolean agafar) {
            this.nom = nom;
            this.descripcio = descripcio;
            this.agafar = agafar;
        }

        public String getNom() { return nom; }
        public String getDescripcio() { return descripcio; }
        public boolean isAgafable() { return agafar; }


        @Override
        public String toString() {
            return nom + ": " + descripcio;
        }
}

