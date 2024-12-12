package it.unisa.diem.softeng.gruppo1;
import java.util.ArrayList;
import java.util.List;

/**
 * @brief La classe 'GestioneRubrica' fornisce funzionalità per ordinare, cercare,
 * aggiungere.
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
     * 
     * @post La lista sarà ordinata secondo un criterio alfabetico per cognome.
     */
     public List<Contatto> sort() {
     }
    
    
    /**
     * @brief Cerca contatti nella rubrica.
     * 
     * @post Non modifica la lista esistente.
     * 
     * @return Una lista di contatti che soddisfano i criteri di ricerca.
     * Se non ci sono risultati, la lista restituita sarà vuota.
     */
    public List<Contatto> search(String s) {
       
    }


    /**
     * @brief Aggiunge un contatto alla rubrica e quindi alla lista dei contatti.
     * 
     * @post Il nuovo contatto viene aggiunto alla lista, incrementando la sua 
     * dimensione di uno.
     */
    public void add(Contatto nuovoContatto) {
        if ((nuovoContatto.getCognome() != null && !nuovoContatto.getCognome().isEmpty()) ||
             (nuovoContatto.getNome() != null && !nuovoContatto.getNome().isEmpty())) {
                  listaContatti.add(nuovoContatto); // Se i campi non sono vuoti aggiunge il contatto.
       // System.out.println("Contatto aggiunto: " + nuovoContatto);
    }
}


    /**
     * @brief Rimuove un contatto dalla dalla lista.
     * 
     * @pre Il contatto che deve essere rimosso deve esistere in rubrica.
     * @post Se il contatto esiste, allora viene rimosso. La dimensione della
     * lista viene decrementata.
     */
    public void remove(Contatto c) {
        
    }

    public List<Contatto> getListaContatti() {
        return listaContatti;
    }
    
    
}