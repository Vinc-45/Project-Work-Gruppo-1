
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
     * @brief Verifica se il contatto corrente è valido
     * @return Restituisce true se la verifica dei campi è andata a buon fine altrimenti false.
     */
    public boolean verifyContact(){
         Verifica ind=new VerificaMail();
        Verifica tel=new VerificaTelefono();
        if(this.nome.isEmpty() && this.cognome.isEmpty()) return false;
        if(ind.verify(this.indirizzoEmail) && tel.verify(this.numeroDiTelefono)) return true;
        else return false;
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
