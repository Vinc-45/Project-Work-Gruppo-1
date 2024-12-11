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
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import it.unisa.diem.softeng.gruppo1.VerificaMail;



public class VerificaMailTest {
    
    public VerificaMailTest() {
    }
    
    @Test
    public void testVerify(){
        
        String[] mail = {"mario@mail1.it", "mario@mail2.it", "mario@mail3.it"};
        VerificaMail vm = new VerificaMail();
        assertTrue(vm.verify(mail));
    }
    
    @Test
    public void testVerify2(){
        
        String[] mail = {"rossi@mario.it", "pinco@my.it", ""};
        VerificaMail vm = new VerificaMail();
        assertTrue(vm.verify(mail));
    }
    
    @Test
    public void testVerify3(){
        
        String[] mail = {"hello@world.it", "", ""};
        VerificaMail vm = new VerificaMail();
        assertTrue(vm.verify(mail));
    }
    
    @Test
    public void testVerify4(){
        
        String[] mail = {"", "", ""};
        VerificaMail vm = new VerificaMail();
        assertTrue(vm.verify(mail));
    }
    
    @Test
    public void testVerify5(){
        
        String[] mail = {"mario@mail1", "", ""};
        VerificaMail vm = new VerificaMail();
        assertFalse(vm.verify(mail));
    }
    
    @Test
    public void testVerify6(){
        
        String[] mail = {"mario@mail1.", "", ""};
        VerificaMail vm = new VerificaMail();
        assertFalse(vm.verify(mail));
    }
    
    @Test
    public void testVerify7(){
        
        String[] mail = {"mario@", "", ""};
        VerificaMail vm = new VerificaMail();
        assertFalse(vm.verify(mail));
    }
    
    @Test
    public void testVerify8(){
        
        String[] mail = {"@mail1", "", ""};
        VerificaMail vm = new VerificaMail();
        assertFalse(vm.verify(mail));
    }
    
    @Test
    public void testVerify9(){
        
        String[] mail = {"@", "", ""};
        VerificaMail vm = new VerificaMail();
        assertFalse(vm.verify(mail));
    }
    
    @Test
    public void testVerify10(){
        
        String[] mail = {"@.", "", ""};
        VerificaMail vm = new VerificaMail();
        assertFalse(vm.verify(mail));
    }
    
    @Test
    public void testVerify11(){
        
        String[] mail = {"mymail@verdi.", "myacc@ros", ""};
        VerificaMail vm = new VerificaMail();
        assertFalse(vm.verify(mail));
    }
    
    @Test
    public void testVerify12(){
        
        String[] mail = {"ing@", "@mail", "pref"};
        VerificaMail vm = new VerificaMail();
        assertFalse(vm.verify(mail));
    }
    
    @Test
    public void testVerify13(){
        
        String[] mail = {"ing@", "mario@mail1.it", "rossi@mail2.it"};
        VerificaMail vm = new VerificaMail();
        assertFalse(vm.verify(mail));
    }
    
    @Test
    public void testVerify14(){
        
        String[] mail = {"verdi@mail1.it", "hey@domain.", ""};
        VerificaMail vm = new VerificaMail();
        assertFalse(vm.verify(mail));
    }
    
   
}
