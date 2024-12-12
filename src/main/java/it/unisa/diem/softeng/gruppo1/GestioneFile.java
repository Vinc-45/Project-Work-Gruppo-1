
package it.unisa.diem.softeng.gruppo1;

/**
 * @brief classe di utilità per le operazioni su file
*/
public class GestioneFile {
    
    private GestioneRubrica gr;
    
    /**
     * @brief Costruttore di default
     */
    public GestioneFile(GestioneRubrica gr){
        this.gr=gr;
    }
    
    /**
     * @brief Salva la rubrica su file
     * @pre Il file è nel formato corretto
     * @param[in] Il file selezionato dall'utente
     * @return Restituisce true se il file è stato salvato correttamente altrimenti false
     */
    public boolean saveRubricaOnFile(){
        return true;
    }
    
    /**
     * @brief Carica la rubrica da file
     * @pre il file esiste ed è nel formato corretto
     * @param[in] Il file selezionato dall'utente
     * @return Restituisce true se il file è stato caricato correttamente altrimenti false
     */
    public boolean loadRubricaOnFile(){
        return true;
    }

    public GestioneRubrica getGestioneRubrica() {
        return gr;
    }
}
