/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.gruppo1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import it.unisa.diem.softeng.gruppo1.Contatto;



public class ContattoTest {
    
    @Test
    public void testCostruttore() {
         String[] num = {"12649875", "65891472", "32864791"};
        String[] mail = {"mario@mail1.it", "mario@mail2.it", "mario@mail3.it"};
        Contatto c = new Contatto("Mario", "Rossi", num, mail);
        assertEquals("12649875", c.getNumeroDiTelefono()[0]);
        assertEquals("65891472", c.getNumeroDiTelefono()[1]);
        assertEquals("32864791", c.getNumeroDiTelefono()[2]);
        assertEquals("mario@mail1.it", c.getIndirizzoEmail()[0]);
        assertEquals("mario@mail2.it", c.getIndirizzoEmail()[1]);
        assertEquals("mario@mail3.it", c.getIndirizzoEmail()[2]);
        assertEquals("Mario", c.getNome());
        assertEquals("Rossi", c.getCognome());
    }
    
    @Test
    public void testVerifyContact(){
        String[] num = {"12649875", "65891472", "32864791"};
        String[] mail = {"mario@mail1.it", "mario@mail2.it", "mario@mail3.it"};
        Contatto c = new Contatto("", "", num, mail);
        assertFalse(c.verifyContact());
    }
    
    @Test
    public void testVerifyContact2(){
        String[] num = {"12649875", "65891472", "32864791"};
        String[] mail = {"mario@mail1.it", "mario@mail2.it", "mario@mail3.it"};
        Contatto c = new Contatto("Giacomo", "", num, mail);
        assertTrue(c.verifyContact());
    }
    
    @Test
    public void testVerifyContact3(){
        String[] num = {"12649875", "65891472", "32864791"};
        String[] mail = {"mario@mail1.it", "mario@mail2.it", "mario@mail3.it"};
        Contatto c = new Contatto("", "Verdi", num, mail);
        assertTrue(c.verifyContact());
    }
    
    @Test
    public void testVerifyContact4(){
        String[] num = {"12649875", "65891472", "32864791"};
        String[] mail = {"mario@mail1.it", "mario@mail2.it", "mario@mail3.it"};
        Contatto c = new Contatto("Giacomo", "Verdi", num, mail);
        assertTrue(c.verifyContact());
    }
    
}
