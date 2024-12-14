
package it.unisa.diem.softeng.gruppo1;

/**
 * 
 * @brief Interfaccia per la verifica di validità di un contatto comune a VerificaMail e VerficaTelefono
 * 
 */
public interface Verifica {
    
    /**
     * @brief Controlla se le stringhe sono valide.
     * @param[in] s Vettore di stringhe di cui verificare la validità.
     * @pre La dimensione del vettore deve essere 3.
     * @return Restituisce true se le stringhe del vettore sono valide altrimenti false.
    */
    public abstract boolean verify(String[] s);
    
}
