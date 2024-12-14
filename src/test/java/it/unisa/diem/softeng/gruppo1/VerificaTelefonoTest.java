package it.unisa.diem.softeng.gruppo1;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class VerificaTelefonoTest {
    
    @Test
    public void testVerify(){
        
        String[] num = {"12649875", "65891472", "32864791"};
        VerificaTelefono vt = new VerificaTelefono();
        assertTrue(vt.verify(num));
        
    }
    
    @Test
    public void testVerify2(){
        
        String[] num = {"85473294", "45971234", ""};
        VerificaTelefono vt = new VerificaTelefono();
        assertTrue(vt.verify(num));
        
    }
    
    @Test
    public void testVerify3(){
        
        String[] num = {"95327146", "", ""};
        VerificaTelefono vt = new VerificaTelefono();
        assertTrue(vt.verify(num));
        
    }
    
    @Test
    public void testVerify4(){
        
        String[] num = {"3256", "74", "785641"};
        VerificaTelefono vt = new VerificaTelefono();
        assertTrue(vt.verify(num));
        
    }
    
    @Test
    public void testVerify5(){
        
        String[] num = {"7", "", "64"};
        VerificaTelefono vt = new VerificaTelefono();
        assertTrue(vt.verify(num));
        
    }
    
    @Test
    public void testVerify6(){
        
        String[] num = {"adyhec", "564782", ""};
        VerificaTelefono vt = new VerificaTelefono();
        assertFalse(vt.verify(num));
        
    }
    
    @Test
    public void testVerify7(){
        
        String[] num = {"a.!@_/963", "", ""};
        VerificaTelefono vt = new VerificaTelefono();
        assertFalse(vt.verify(num));
        
    }
    
    @Test
    public void testVerify8(){
        
        String[] num = {"7859", "", ".,*?658"};
        VerificaTelefono vt = new VerificaTelefono();
        assertFalse(vt.verify(num));
        
    }
    
    @Test
    public void testVerify9(){
        
        String[] num = {"7859", ".,*?658"};
        VerificaTelefono vt = new VerificaTelefono();
        assertFalse(vt.verify(num));
        
    }
    
    @Test
    public void testVerify10(){
        
        String[] num = {"7859", "", ".,*?658",""};
        VerificaTelefono vt = new VerificaTelefono();
        assertFalse(vt.verify(num));
        
    }
}
