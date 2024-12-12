package it.unisa.diem.softeng.gruppo1;

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
        assertEquals(2, rubrica.getListaContatti().size()); // Non deve aggiungere il contatto vuoto.
    }



    // TEST REMOVE
    @Test
    void testRemove_ContattoPresente() {
        GestioneRubrica rubrica = new GestioneRubrica();
        String[] n1 = {"", "", ""};
        String[] e1 = {"", "", ""};
        String[] n2 = {"", "", ""};
        String[] e2 = {"", "", ""};
        Contatto contatto1 = new Contatto("Mario", "Rossi",n1, e1);
        Contatto contatto2 = new Contatto("Luigi", "Verdi",n2, e2);
        rubrica.add(contatto1);
        rubrica.add(contatto2);
        // Verifica che la lista contenga inizialmente i contatti aggiunti.
        assertEquals(2, rubrica.getListaContatti().size());
        rubrica.remove(contatto1);
        // Verifica che il contatto sia stato rimosso.
        List<Contatto> contatti = rubrica.getListaContatti();
        assertEquals(1, contatti.size());
        assertFalse(contatti.contains(contatto1));
    }

    @Test
    void testRemove_ContattoNonPresente() {
        GestioneRubrica rubrica = new GestioneRubrica();
        String[] n1 = {"", "", ""};
        String[] e1 = {"", "", ""};
        // Crea un contatto che non aggiungeremo in rubrica.
        Contatto contattoNonPresente = new Contatto("Giulia", "Bianchi", n1, e1);
        // Verifica che il metodo lanci un'eccezione quando il contatto non è presente.
        assertThrows(IllegalArgumentException.class, () -> rubrica.remove(contattoNonPresente));
    }


}
