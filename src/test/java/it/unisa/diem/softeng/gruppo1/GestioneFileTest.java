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

/**
 *
 * @author bello
 */
public class GestioneFileTest {
   
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
}
