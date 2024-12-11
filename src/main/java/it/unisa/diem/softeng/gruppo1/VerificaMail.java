
package it.unisa.diem.softeng.gruppo1;

/**
 * 
 * @brief Classe per la verifica della validità dell'indirizzo email
 */
public class VerificaMail implements Verifica {

    /**
     * @brief Controlla se l'attributo indirizzoEmail è valido
     * @param[in] contact Il contatto di cui si vuole verificare la validità
     * @return Restituisce true se l'indirizzo email è valido altrimenti false
     */
    @Override
    public boolean verify(String[] ind) {
       boolean[] flag1 = {false,false,false};
        boolean[] flag2 = {false,false,false};
        boolean flag3=true;
        if(ind[0].isEmpty() && ind[1].isEmpty() && ind[2].isEmpty()) return true; //verifico se tutte e tre le stringhe email sono vuote
        for(int i=0;i<ind.length;i++){
            if(!ind[i].isEmpty()){
            for(int j=0;j<ind[i].length();j++){
                if(Character.compare(ind[i].charAt(j), '@')==0) flag1[i]=true;//verifico se all'interno di ogni stringa email è presente il carattere @
                if(Character.compare(ind[i].charAt(j), '.')==0) flag2[i]=true;//verifico se all'interno di ogni stringa email è presente il carattere .
                }
            if(!(ind[i].indexOf("@")==ind[i].lastIndexOf("@"))) return false;//verifica se all'interno della mail è presente una sola @
            if(flag1[i]==false || flag2[i]==false) return false;
            if(ind[i].lastIndexOf(".")<ind[i].lastIndexOf("@")) return false; //verifico che il carattere . sia presente anche dopo la @ 
            String before = ind[i].substring(0,ind[i].indexOf("@"));
            String between = ind[i].substring(ind[i].indexOf("@")+1,ind[i].lastIndexOf("."));
            String after = ind[i].substring(ind[i].lastIndexOf(".")+1);
            if(before.length()<1 || between.length()<1 || after.length()<1) return false;
            /*verifico che sia presente almeno un carattere prima della @
              verifico che sia presente almeno un carattere dopo la @ e prima dell' ultimo .
             verifico che sia presente almeno un carattere dopo l'ultimo punto
            */
            }
            else{
                flag1[i]=true;
                flag2[i]=true;
            }
           flag3=flag3 && flag1[i] && flag2[i];
        }
        return flag3;
    }
}
