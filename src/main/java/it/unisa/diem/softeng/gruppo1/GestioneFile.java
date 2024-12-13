
package it.unisa.diem.softeng.gruppo1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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
    public boolean saveRubricaOnFile(File f){
         String nomeFile=f.getName();
       if(!this.checkExtension(nomeFile)) return false;        
        try( PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter(f))) ){ //try with resources ci permette di definire dei paramentri dopo il try in modo tale che chiude gli stream al termine del try
            pw.println("NOME;COGNOME;NUMERO DI TELEFONO;;;INDIRIZZO EMAIL");
            
            for(Contatto c:this.gr.getListaContatti()){//inserisco i contatti presenti nella rubrica all'interno del file
                pw.print(c.getNome());
                pw.append(';');
                 pw.print(c.getCognome());
                pw.append(';');
                String[] num=c.getNumeroDiTelefono();
                for(int i=0;i<3;i++){
                   pw.print(num[i]);
                   pw.append(';'); 
                }
                String[] ind=c.getIndirizzoEmail();
                for(int i=0;i<3;i++){
                   pw.print(ind[i]);
                   pw.append(';'); 
                } 
                 pw.append('\n');
            }
            return true;
            }   catch (FileNotFoundException ex) {
            System.out.println("File non trovato");
            return false;
        } catch (IOException ex) {
            System.out.println("IO Exception");
            return false;
        }
    }
    
    /**
     * @brief Carica la rubrica da file
     * @pre il file esiste ed è nel formato corretto
     * @param[in] Il file selezionato dall'utente
     * @return Restituisce true se il file è stato caricato correttamente altrimenti false
     */
    public boolean loadRubricaFromFile(File f){
        return true;
    }

    public GestioneRubrica getGestioneRubrica() {
        return gr;
    }
    
    private boolean checkExtension(String nomeFile){
        if(nomeFile.contains(".")) {//controllo se il file contiene il . e quindi ha un estensione
            String estensione = nomeFile.substring(nomeFile.lastIndexOf(".") + 1);
            if(!(estensione.contentEquals("csv"))){//controllo se il file ha estensione csv
               System.out.println("file non nel formato corretto");
               return false;
            }
            else{
                return true;
            }
       }
        else{
            return false;
        } 
    }
}
