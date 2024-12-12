package it.unisa.diem.softeng.gruppo1;
import it.unisa.diem.softeng.gruppo1.GestioneRubrica;
import it.unisa.diem.softeng.gruppo1.Contatto;
//import org.junit.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class GestioneRubricaTest {

    // TEST ADD
    @Test
    void testAdd() { 
        GestioneRubrica rubrica = new GestioneRubrica();
        String[] n1 = {"123456789","",""};
        String[] e1 = {"rossi.mario@example.com","",""};
        String[] n2 = {"987654321","",""};
        String[] e2 = {"bianchi.anna@example.com","",""};
        String[] n3 = {"","",""}; 
        String[] e3 = {"","",""}; 
        Contatto contatto1 = new Contatto("Mario", "Rossi", n1, e1);
        Contatto contatto2 = new Contatto("Anna", "Bianchi", n2, e2);
        Contatto contatto3 = new Contatto("", "", n3, e3);
        rubrica.add(contatto1);
        rubrica.add(contatto2);
        // Verifico che i contatti validi siano stati aggiunti.
        assertEquals(2, rubrica.getListaContatti().size());
        // Provo ad aggiungere un contatto vuoto.
        rubrica.add(contatto3);
        assertEquals(3, rubrica.getListaContatti().size()); // Non deve aggiungere il contatto vuoto.
    }


}
