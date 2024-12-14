package it.unisa.diem.softeng.gruppo1;
/**
 * @brief Classe per la verifica della validità del numero di telefono
 */
public class VerificaTelefono implements Verifica {
    
    
     /**
     * @brief Controlla se l'attributo numeroDiTelefono è valido
     * @param[in] num I numeri di telefono di cui si vuole verificare la validità
     * @return Restituisce true se i numeri di telefono sono validi altrimenti false
    */
    @Override
    public boolean verify(String[] num) {
        if(!(num.length==3)) return false;
        if(num[0].isEmpty() && num[1].isEmpty() && num[2].isEmpty()) return true;//verifico se tutte e tre le stringhe sono vuote
        for(int i=0;i<num.length;i++){
            if(!num[i].isEmpty()){
            String cleanNum=num[i].replaceAll(" ", "");//tolgo gli eventuali spazi all'interno delle stringhe
            System.out.println(cleanNum);
            for(int j=0;j<cleanNum.length();j++)
            if(!cleanNum.matches("[0-9]+")) return false;//verifico che all'interno della stringa siano presenti solo numeri
            }
        }
        
        return true;
    }
}