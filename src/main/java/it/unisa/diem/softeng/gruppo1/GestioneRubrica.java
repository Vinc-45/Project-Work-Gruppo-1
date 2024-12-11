
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
    List<Contatto> listaContatti;
    
    /**
     * @brief Costruttore di default.
     */
    public GestioneRubrica(){
        this.listaContatti = new ArrayList<>();
    }
    
    /**
     * @brief Aggiunge un contatto alla rubrica e quindi alla lista dei contatti.
     * 
     * @post Il nuovo contatto viene aggiunto alla lista, incrementando la sua 
     * dimensione di uno.
     */
    public void add(Contatto c){
        
    }
    
    /**
     * @brief Rimuove un contatto dalla dalla lista.
     * 
     * @pre Il contatto che deve essere rimosso deve esistere in rubrica.
     * @post Se il contatto esiste, allora viene rimosso. La dimensione della
     * lista viene decrementata.
     */
    public void remove(Contatto c){
        
    }
    
    /**
     * @brief Cerca contatti nella rubrica.
     * 
     * @post Non modifica la lista esistente.
     * 
     * @return Una lista di contatti che soddisfano i criteri di ricerca.
     * Se non ci sono risultati, la lista restituita sarà vuota.
     */
    public List<Contatto> search(String s){
        List<Contatto> l = new ArrayList<>();
        return l;
    }
    
    /**
     * @brief Ordina i contatti della rubrica secondo un criterio alfabetico per cognome
     * e nome.
     * 
     * @post La lista sarà ordinata secondo un criterio alfabetico per cognome.
     */
    public void sort(){
        
    }
    
    public List<Contatto> getListaContatti() {
        return listaContatti;
    }
}
