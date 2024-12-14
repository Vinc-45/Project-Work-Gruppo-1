package it.unisa.diem.softeng.gruppo1;
import java.util.ArrayList;
import java.util.List;

/**
 * @brief Classe che fornisce funzionalità per ordinare, cercare,
 * aggiungere e rimuovere un contatto.
 */
public class GestioneRubrica {


    /**
     * @brief Lista di contatti nella rubrica.
     */
    private List<Contatto> listaContatti;

    
    /**
     * @brief Costruttore di default.
    */
    public GestioneRubrica(){
        this.listaContatti = new ArrayList<>();
    }


    /**
     * @brief Ordina i contatti della rubrica secondo un criterio alfabetico per cognome
     * e nome.
     * @post La lista è ordinata
     */
     public void sort() {
	 listaContatti.sort((c1, c2) -> {
            String cognome1 = c1.getCognome();
            String nome1 = c1.getNome();
            String cognome2 = c2.getCognome();
            String nome2 = c2.getNome();
    
            // Gestione dei casi di COGNOME VUOTO.
            if (isNullOrEmpty(cognome1) && isNullOrEmpty(cognome2)) {

                // Entrambi i cognomi vuoti, confronta solo i nomi.
                return compareStrings(nome1, nome2);

            } else if (isNullOrEmpty(cognome1)) {
                // Se il cognome del primo è vuoto, viene dopo.
                return 1;

            } else if (isNullOrEmpty(cognome2)) {
                // Se il cognome del secondo è vuoto, viene dopo.
                return -1;
            }
    
            // Confronto COGNOMI presenti.
            int cognomeComparison = compareStrings(cognome1, cognome2);
            if (cognomeComparison != 0) {
                return cognomeComparison;
            }
    
            // se i cognomi sono uguali, confronta i nomi
            return compareStrings(nome1, nome2);
        });
    }
    
    private boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }
    
    private int compareStrings(String s1, String s2) {
        if (s1 == null && s2 == null) {
            return 0; // Se entrambi sono null, sono uguali.

        } else if (s1 == null) {
            return 1; // Se il primo è null, viene dopo.

        } else if (s2 == null) {
            return -1; // Se il secondo è null, viene dopo.
        }
        return s1.compareToIgnoreCase(s2); // Confronto case-insensitive.
    
     }
    
    
    /**
     * @brief Cerca contatti nella rubrica.
     * @param[in] s La stringa da cercare.
     * @post Non modifica la lista esistente.
     * @return Una lista di contatti che soddisfano i criteri di ricerca.
     * Se non ci sono risultati, la lista restituita sarà vuota.
     */
    public List<Contatto> search(String s) {
       List<Contatto> risultatoRicerca = new ArrayList<>();
        String a=s.toLowerCase();//Pongo tutte le stringhe a lowerCase per non fare distinzioni tra caratteri maiuscoli e minuscoli
        for(Contatto contatto: listaContatti){
            String nome= contatto.getNome().toLowerCase();
            String cognome= contatto.getCognome().toLowerCase();
             /*
                verifico se la lunghezza del nome e cognome di ogni contatto è superiore alla stringa passata in input
                per evitare eccezioni del tipo ArrayIndexOutOfBoundException
             */
            if(nome.length()>=a.length() && cognome.length()>=a.length()){ //nome e cognome hanno entrambi dimensione maggiore della stringa
                nome=nome.substring(0, a.length());
                cognome=cognome.substring(0, a.length());
                if( cognome.contentEquals(a) || nome.contentEquals(a)) {//controllo se la stringa è contenuta all'interno del nome o del cognome
                    risultatoRicerca.add(contatto);
                }
            }
            else if(nome.length()<a.length() && cognome.length()>=a.length() ){ //Solo il cognome ha dimensione maggiore della stringa
                cognome=cognome.substring(0, a.length());
                if( cognome.contentEquals(a)) {//controllo se la stringa è contenuta nel cognome
                    risultatoRicerca.add(contatto);
                }
            }
            else if(nome.length()>=a.length() && cognome.length()<a.length()){//Solo il nome ha dimensione maggiore della stringa
                nome=nome.substring(0, a.length());
                if(nome.contentEquals(a)) {//controllo se la stringa è contenuta nel nome
                    risultatoRicerca.add(contatto);
                }
            }    
        }
        return risultatoRicerca;
    }


    /**
     * @brief Aggiunge un contatto alla rubrica e quindi alla lista dei contatti.
     * @param[in] nuovoContatto Il contatto da aggiungere alla rubrica.
     * @pre Il contatto deve essere valido.
     * @post Il nuovo contatto viene aggiunto alla lista, incrementando la sua 
     * dimensione di uno.
     */
    public void add(Contatto nuovoContatto) {
        if ((nuovoContatto.getCognome() != null && !nuovoContatto.getCognome().isEmpty()) ||
             (nuovoContatto.getNome() != null && !nuovoContatto.getNome().isEmpty())) {
                  listaContatti.add(nuovoContatto); // Se i campi non sono vuoti aggiunge il contatto.
    }
}


    /**
     * @brief Rimuove un contatto dalla dalla lista.
     * @param[in] contatto Il contatto da rimuovere.
     * @pre Il contatto che deve essere rimosso deve esistere in rubrica.
     * @post Se il contatto esiste, allora viene rimosso. La dimensione della
     * lista viene decrementata.
     */
    public void remove(Contatto contatto) {
        if (!listaContatti.remove(contatto)){
            throw new IllegalArgumentException("Il contatto non è presente nella rubrica.");
        }
    }

    public List<Contatto> getListaContatti() {
        return listaContatti;
    }
    
    
}