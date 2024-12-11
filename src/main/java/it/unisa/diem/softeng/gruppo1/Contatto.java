
package it.unisa.diem.softeng.gruppo1;

/**
 * 
 * @brief Classe di riferimento per le informazioni sui singoli contatti.
 */
public class Contatto {
    
     
    private String nome;
    private String cognome;
    private String numeroDiTelefono[];
    private String indirizzoEmail[];
    
    /**
     * @brief Costruttore di default.
     */
    public Contatto(String nome, String cognome, String[] numeroDiTelefono, String[] indirizzoEmail){
         this.nome = nome;
        this.cognome = cognome;
        this.numeroDiTelefono = numeroDiTelefono;
        this.indirizzoEmail = indirizzoEmail;
    }
    
    /**
     * @param[in] Il contatto di cui si vuole verificare la validità.
     * @return Restituisce true se la verifica dei campi è andata a buon fine altrimenti false.
     */
    public boolean verifyContact(){
        return true;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String[] getNumeroDiTelefono() {
        return numeroDiTelefono;
    }

    public String[] getIndirizzoEmail() {
        return indirizzoEmail;
    }
    
     public String getTelString(){
        return this.numeroDiTelefono[0] + "\n" + this.numeroDiTelefono[1] + "\n" + this.numeroDiTelefono[2];
    }
    
    public String getMailString(){
        return this.indirizzoEmail[0] + "\n" + this.indirizzoEmail[1] + "\n" + this.indirizzoEmail[2];
    }
}