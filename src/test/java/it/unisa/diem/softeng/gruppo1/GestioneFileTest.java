/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.gruppo1;

import java.io.File;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


public class GestioneFileTest {
   
    @Test
    public void testCostruttore(){
        GestioneRubrica gr=new GestioneRubrica();
        String[] num={"2344554","36576",""};
        String[] ind={"adadaa@gmail.com","",""};
        Contatto c=new Contatto("Antonio","Bianchi",num,ind);
        String[] num1={"2344554","",""};
        String[] ind1={"adadaa@gmail.com","dsef@gmail.it",""};
        Contatto c1=new Contatto("Marco","Verdi",num1,ind1);
        String[] num2={"2344554","36576","3523634"};
        String[] ind2={"adadaa@gmail.com","","hrfs@gmail.com"};
        Contatto c2=new Contatto("Antonio","Rossi",num2,ind2);
        gr.add(c);
        gr.add(c1);
        gr.add(c2);
        GestioneFile gf=new GestioneFile(gr);
        assertEquals(gf.getGestioneRubrica().getListaContatti().get(0),c);
        assertEquals(gf.getGestioneRubrica().getListaContatti().get(1),c1);
        assertEquals(gf.getGestioneRubrica().getListaContatti().get(2),c2);
    }
    
    public void testSaveRubricaOnFile(){
        GestioneRubrica gr=new GestioneRubrica();
           GestioneFile gf=new GestioneFile(gr);
           String[] num1={"33","",""};
           String[] ind1={"ciao@gmail.com","",""};
           Contatto c1=new Contatto("mario","rossi",num1,ind1);
           String[] num2={"33","55","66"};
           String[] ind2={"ciao@gmail.com","hey@gmail.com","aiuto@gmail.com"};
           Contatto c2=new Contatto("mario","rossi",num2,ind2);
           String[] num3={"","",""};
           String[] ind3={"","",""};
           Contatto c3=new Contatto("mario","",num3,ind3);
           gr.add(c1);
           gr.add(c2);
           gr.add(c3);
           File f=new File("test.csv");
           assertTrue(gf.saveRubricaOnFile(f));
           File f1=new File("test.pdf");
           assertFalse(gf.saveRubricaOnFile(f1));
           GestioneRubrica gr1=new GestioneRubrica();
           GestioneFile gf1=new GestioneFile(gr);
           gf1.loadRubricaFromFile(f);
           /*
           assertEquals("mario",gr1.getListaContatti().get(0).getNome());
           assertEquals("rossi",gr1.getListaContatti().get(1).getCognome());
           assertEquals("",gr1.getListaContatti().get(2).getIndirizzoEmail()[0]);
           */
           f.delete();
           f1.delete();
    }
}
