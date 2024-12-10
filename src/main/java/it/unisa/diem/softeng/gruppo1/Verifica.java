
package it.unisa.diem.softeng.gruppo1;

/**
 * 
 * @brief Interfaccia per la verifica di validità di un contatto comune a VerificaMail e VerficaTelefono
 * 
 */
public interface Verifica {
    
    /**
     * @brief Controlla se il contatto è valido.
     * @param[in] contact Il contatto di cui si vuole verificare la validità.
     * @return Restituisce true se il contatto è valido altrimenti false.
    */
    public abstract boolean verify(String[] s);
    
}
