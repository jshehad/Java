import static org.junit.Assert.*; 

import java.io.BufferedReader; 
import java.io.FileReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.ArrayList; 
import java.util.Arrays; 
import java.util.List; 

import org.junit.Test; 


public class UnitTests { 
    private static int passed = 0; 
     
    @Test 
    public void testEntity() { 
        Entity.setEntity(10); 
        assertEquals(10,Entity.bloodstream.length); 
        assertNotEquals(0,++passed); 
    }     
     
    @Test 
    public void testBacteria1() { 
        Bacteria b = new Bacteria(Strength.MEDIUM); 
        assertEquals(Strength.MEDIUM,b.getStrength()); 
        assertEquals("bacteria",b.getDNA());     
        b.setStrength(Strength.HIGH); 
        assertEquals(Strength.HIGH,b.getStrength());     
        b.kill(); 
        assertEquals(Strength.DEAD,b.getStrength());     
        b.setDNA("staph"); 
        assertEquals("staph",b.getDNA()); 
        assertNotEquals(0,++passed); 
    }     
     
    @Test 
    public void testBacteria2() { 
        Entity.setEntity(5); 
        Bacteria b = new Bacteria(Strength.DEAD); 
        Bacteria neighbor = new Bacteria(Strength.HIGH); 
        b.touchNeighbor(neighbor); 
        assertEquals(null,Entity.bloodstream[0]); 
         
        b.setStrength(Strength.LOW); 
        b.touchNeighbor(neighbor);         
        assertEquals("bacteria",Entity.bloodstream[0].getDNA());         

        b.setStrength(Strength.MEDIUM); 
        b.touchNeighbor(neighbor);         
        assertEquals("bacteria",Entity.bloodstream[1].getDNA());         
         
        b.setStrength(Strength.HIGH); 
        b.touchNeighbor(neighbor);         
        assertEquals("bacteria",Entity.bloodstream[2].getDNA()); 
         
        b.touchNeighbor(null); 
        assertNotEquals(0,++passed);         
    }     

    @Test 
    public void testBacteria3() { 
        Entity.setEntity(5); 
        Bacteria b = new Bacteria(Strength.DEAD); 
        Cytokine neighbor = new Cytokine(); 
        b.touchNeighbor(neighbor); 
        assertEquals(null,Entity.bloodstream[0]); 
         
        b.setStrength(Strength.LOW); 
        b.touchNeighbor(neighbor);         
        assertEquals("bacteria",Entity.bloodstream[0].getDNA());         

        b.setStrength(Strength.MEDIUM); 
        b.touchNeighbor(neighbor);         
        assertEquals("bacteria",Entity.bloodstream[1].getDNA());         
         
        b.setStrength(Strength.HIGH); 
        b.touchNeighbor(neighbor);         
        assertEquals("bacteria",Entity.bloodstream[2].getDNA()); 
        assertNotEquals(0,++passed);         
    } 
     
    @Test 
    public void testBacteria4() { 
        Entity.setEntity(5); 
        Bacteria b = new Bacteria(Strength.DEAD); 
        Entity[] targets = {}; 
        Lymphocyte neighbor = new Lymphocyte("medium",targets); 
        b.touchNeighbor(neighbor); 
        assertEquals(null,Entity.bloodstream[0]); 
         
        b.setStrength(Strength.LOW); 
        b.touchNeighbor(neighbor);         
        assertEquals("bacteria",Entity.bloodstream[0].getDNA());         

        b.setStrength(Strength.MEDIUM); 
        b.touchNeighbor(neighbor);         
        assertEquals("bacteria",Entity.bloodstream[1].getDNA());         
         
        b.setStrength(Strength.HIGH); 
        b.touchNeighbor(neighbor);         
        assertEquals("bacteria",Entity.bloodstream[2].getDNA());         
        assertNotEquals(0,++passed);         
    }     
     
    @Test 
    public void testBacteria5() { 
        Entity.setEntity(5); 
        Bacteria b = new Bacteria(Strength.DEAD); 
        Entity[] targets = {}; 
        Macrophage neighbor = new Macrophage("medium",targets); 
        b.touchNeighbor(neighbor); 
        assertEquals(null,Entity.bloodstream[0]); 
         
        b.setStrength(Strength.LOW); 
        b.touchNeighbor(neighbor);         
        assertEquals("bacteria",Entity.bloodstream[0].getDNA());         

        b.setStrength(Strength.MEDIUM); 
        b.touchNeighbor(neighbor);         
        assertEquals("bacteria",Entity.bloodstream[1].getDNA());         
         
        b.setStrength(Strength.HIGH); 
        b.touchNeighbor(neighbor);         
        assertEquals("bacteria",Entity.bloodstream[2].getDNA());     
        assertNotEquals(0,++passed);         
    }     
     
    @Test 
    public void testBacteria6() { 
        Entity.setEntity(5); 
        Bacteria b = new Bacteria(Strength.DEAD); 
        Entity[] targets = {}; 
        Neutrophil neighbor = new Neutrophil("medium",targets,false); 
        b.touchNeighbor(neighbor); 
        assertEquals(null,Entity.bloodstream[0]); 
         
        b.setStrength(Strength.LOW); 
        b.touchNeighbor(neighbor);         
        assertEquals("bacteria",Entity.bloodstream[0].getDNA());         

        b.setStrength(Strength.MEDIUM); 
        b.touchNeighbor(neighbor);         
        assertEquals("bacteria",Entity.bloodstream[1].getDNA());         
         
        b.setStrength(Strength.HIGH); 
        b.touchNeighbor(neighbor);         
        assertEquals("bacteria",Entity.bloodstream[2].getDNA());     
        assertNotEquals(0,++passed);         
    }     
     
    @Test 
    public void testBacteria7() { 
        Entity.setEntity(5); 
        Bacteria b = new Bacteria(Strength.DEAD); 
        Virus neighbor = new Virus(Strength.MEDIUM); 
        b.touchNeighbor(neighbor); 
        assertEquals(null,Entity.bloodstream[0]); 
         
        b.setStrength(Strength.LOW); 
        b.touchNeighbor(neighbor);         
        assertEquals("bacteria",Entity.bloodstream[0].getDNA());         

        b.setStrength(Strength.MEDIUM); 
        b.touchNeighbor(neighbor);         
        assertEquals("bacteria",Entity.bloodstream[1].getDNA());         
         
        b.setStrength(Strength.HIGH); 
        b.touchNeighbor(neighbor);         
        assertEquals("bacteria",Entity.bloodstream[2].getDNA());     
        assertNotEquals(0,++passed);         
    } 
     
    @Test 
    public void testCytokine0() { 
        Cytokine b = new Cytokine(); 
        assertEquals(Strength.DEAD,b.getStrength()); 
        assertEquals("cytokine",b.getDNA());     
        b.setStrength(Strength.HIGH); 
        assertEquals(Strength.HIGH,b.getStrength());     
        b.kill(); 
        assertEquals(Strength.DEAD,b.getStrength());     
        b.setDNA("staph"); 
        assertEquals("staph",b.getDNA()); 
        assertNotEquals(0,++passed);         
    }     
     
    @Test 
    public void testCytokine1(){ 
        Entity.setEntity(5);         
        Cytokine c = new Cytokine(); 
        Bacteria neighbor = new Bacteria(Strength.HIGH); 
        c.touchNeighbor(neighbor); 
        assertEquals(null,Entity.bloodstream[0]); 
        assertEquals(Strength.HIGH,neighbor.getStrength()); 
         
        c.touchNeighbor(null);         
        assertNotEquals(0,++passed);         
    } 
     
    @Test 
    public void testCytokine2(){ 
        Entity.setEntity(5);         
        Cytokine c = new Cytokine(); 
        Cytokine neighbor = new Cytokine(); 
        c.touchNeighbor(neighbor); 
        assertEquals(null,Entity.bloodstream[0]); 
        assertEquals(Strength.DEAD,neighbor.getStrength()); 
        assertNotEquals(0,++passed);         
    }     
     
    @Test 
    public void testCytokine3(){ 
        Entity.setEntity(5);         
        Cytokine c = new Cytokine(); 
        Entity[] targets = {};         
        Lymphocyte neighbor = new Lymphocyte("medium",targets); 
        c.touchNeighbor(neighbor); 
        assertEquals(null,Entity.bloodstream[0]); 
        assertEquals(Strength.HIGH,neighbor.getStrength()); 
        assertNotEquals(0,++passed);         
    }     
     
    @Test 
    public void testCytokine4(){ 
        Entity.setEntity(5);         
        Cytokine c = new Cytokine(); 
        Entity[] targets = {};         
        Macrophage neighbor = new Macrophage("medium",targets); 
        c.touchNeighbor(neighbor); 
        assertEquals(null,Entity.bloodstream[0]); 
        assertEquals(Strength.HIGH,neighbor.getStrength()); 
        assertNotEquals(0,++passed);         
    }     
     
    @Test 
    public void testCytokine5(){ 
        Entity.setEntity(5);         
        Cytokine c = new Cytokine(); 
        Virus neighbor = new Virus(Strength.HIGH); 
        c.touchNeighbor(neighbor); 
        assertEquals(null,Entity.bloodstream[0]); 
        assertEquals(Strength.HIGH,neighbor.getStrength()); 
        assertNotEquals(0,++passed);         
    }     
     
    @Test 
    public void testCytokine6(){ 
        Entity.setEntity(5);         
        Cytokine c = new Cytokine(); 
        Entity[] targets = {};         
        Neutrophil neighbor = new Neutrophil("medium",targets,false); 
        c.touchNeighbor(neighbor); 
        assertEquals(null,Entity.bloodstream[0]); 
        assertEquals(Strength.HIGH,neighbor.getStrength()); 
        assertEquals(Strength.DEAD,c.getStrength());     
        assertNotEquals(0,++passed);         
    }     
     
    @Test 
    public void testMacrophage0() { 
        Entity[] targets = {new Bacteria(Strength.HIGH)};             
        Macrophage b = new Macrophage("medium",targets); 
        assertEquals(Strength.HIGH,b.getStrength()); 
        assertEquals("macrophage",b.getDNA());     
        b.setStrength(Strength.HIGH); 
        assertEquals(Strength.HIGH,b.getStrength());     
        b.kill(); 
        assertEquals(Strength.DEAD,b.getStrength());     
        b.setDNA("staph"); 
        assertEquals("staph",b.getDNA()); 
        assertNotEquals(0,++passed);         
    }         
     
    @Test 
    public void testMacrophage1(){ 
        Entity.setEntity(5);         
        Entity[] targets = {new Bacteria(Strength.HIGH)};             
        Macrophage m = new Macrophage("medium",targets); 
        Bacteria neighbor = new Bacteria(Strength.HIGH); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor);         
        assertEquals(Strength.DEAD,neighbor.getStrength()); 
         
        m.touchNeighbor(null);         
        assertNotEquals(0,++passed);         
    }     
     
    @Test 
    public void testMacrophage2(){ 
        Entity.setEntity(5);         
        Entity[] targets = {new Bacteria(Strength.HIGH)};             
        Macrophage m = new Macrophage("medium",targets); 
        Virus neighbor = new Virus(Strength.HIGH); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor);         
        assertEquals(Strength.HIGH,neighbor.getStrength()); 
        assertNotEquals(0,++passed);         
    }     
     
    @Test 
    public void testMacrophage3(){ 
        Entity.setEntity(5);         
        Entity[] targets = {new Bacteria(Strength.HIGH)};             
        Macrophage m = new Macrophage("medium",targets); 
        Neutrophil neighbor = new Neutrophil("large",targets,false); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor);         
        assertEquals(Strength.HIGH,neighbor.getStrength()); 
        assertNotEquals(0,++passed);         
    }         
     
    @Test 
    public void testMacrophage4(){ 
        Entity.setEntity(5);         
        Entity[] targets = {new Bacteria(Strength.HIGH)};             
        Macrophage m = new Macrophage("medium",targets); 
        Neutrophil neighbor = new Neutrophil("large",targets,false); 
        neighbor.setStrength(Strength.LOW); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor);         
        assertEquals(Strength.DEAD,neighbor.getStrength()); 
        assertNotEquals(0,++passed);         
    }     
     
    @Test 
    public void testMacrophage5(){ 
        Entity.setEntity(5);         
        Entity[] targets = {new Bacteria(Strength.HIGH)};             
        Macrophage m = new Macrophage("medium",targets); 
        Neutrophil neighbor = new Neutrophil("large",targets,false); 
         
        for (int i = 0; i < 99; i++){ 
            neighbor.setStrength(Strength.LOW); 
            m.touchNeighbor(neighbor); 
        } 
        assertEquals(Strength.HIGH,m.getStrength()); 
        assertNotEquals(0,++passed);         
    }         
     
    @Test 
    public void testMacrophage6(){ 
        Entity.setEntity(5);         
        Entity[] targets = {new Bacteria(Strength.HIGH)};             
        Macrophage m = new Macrophage("medium",targets); 
        Neutrophil neighbor = new Neutrophil("large",targets,false); 
         
        for (int i = 0; i < 105; i++){ 
            neighbor.setStrength(Strength.LOW); 
            m.touchNeighbor(neighbor); 
        } 
        assertEquals(Strength.DEAD,m.getStrength()); 
        assertNotEquals(0,++passed);         
    }     
     
    @Test 
    public void testMacrophage7(){ 
        Entity.setEntity(5);         
        Entity[] targets = {new Bacteria(Strength.HIGH)};             
        Macrophage m = new Macrophage("medium",targets); 
        Neutrophil neighbor = new Neutrophil("large",targets,false); 
        neighbor.setStrength(Strength.LOW); 
        m.setStrength(Strength.DEAD); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor);         
        assertEquals(Strength.LOW,neighbor.getStrength()); 
        assertNotEquals(0,++passed);         
    }     
     
    @Test 
    public void testNeutrophil0() { 
        Entity[] targets = {new Virus(Strength.HIGH)};     
        Neutrophil b = new Neutrophil("medium",targets,false);     
        assertEquals(Strength.HIGH,b.getStrength()); 
        assertEquals("neutrophil",b.getDNA());     
        b.setStrength(Strength.HIGH); 
        assertEquals(Strength.HIGH,b.getStrength());     
        b.kill(); 
        assertEquals(Strength.DEAD,b.getStrength());     
        b.setDNA("staph"); 
        assertEquals("staph",b.getDNA()); 
        assertNotEquals(0,++passed);         
    }         
     
    @Test 
    public void testNeutrophil1(){ 
        Entity.setEntity(5);         
        Entity[] targets = {new Virus(Strength.HIGH)};     
        Neutrophil n = new Neutrophil("medium",targets,false);         
        Cytokine neighbor = new Cytokine(); 
        n.setStrength(Strength.LOW); 
        n.touchNeighbor(neighbor); 
        assertEquals(Strength.DEAD,neighbor.getStrength()); 
        assertEquals(Strength.LOW,n.getStrength());     
         
        n.touchNeighbor(null);     
        assertNotEquals(0,++passed);         
    }     
     
    @Test 
    public void testNeutrophil2(){ 
        Entity.setEntity(5);         
        Entity[] targets = {new Virus(Strength.HIGH)};     
        Neutrophil n = new Neutrophil("medium",targets,true);         
        Cytokine neighbor = new Cytokine(); 
        n.setStrength(Strength.LOW);         
        n.touchNeighbor(neighbor); 
        assertEquals(Strength.DEAD,neighbor.getStrength()); 
        assertEquals(Strength.MEDIUM,n.getStrength());     
        assertNotEquals(0,++passed);         
    }     
     
    @Test 
    public void testNeutrophil3(){ 
        Entity.setEntity(5);         
        Entity[] targets = {new Virus(Strength.HIGH)};     
        Neutrophil n = new Neutrophil("medium",targets,true);         
        Virus neighbor = new Virus(Strength.HIGH);     
        n.touchNeighbor(neighbor); 
        n.touchNeighbor(neighbor); 
        n.touchNeighbor(neighbor); 
        n.touchNeighbor(neighbor); 
        n.touchNeighbor(neighbor); 
        n.touchNeighbor(neighbor); 
        n.touchNeighbor(neighbor); 
        n.touchNeighbor(neighbor); 
        n.touchNeighbor(neighbor); 
        n.touchNeighbor(neighbor);         
        assertEquals(Strength.DEAD,neighbor.getStrength()); 
        assertNotEquals(Strength.HIGH,n.getStrength());     
        assertEquals("cytokine",Entity.bloodstream[0].getDNA()); 
        assertEquals("cytokine",Entity.bloodstream[1].getDNA()); 
        assertEquals("cytokine",Entity.bloodstream[2].getDNA()); 
        assertNotEquals(0,++passed);         
    }     
     
    @Test 
    public void testNeutrophil4(){ 
        Entity.setEntity(5);         
        Entity[] targets = {new Virus(Strength.HIGH)};     
        Neutrophil n = new Neutrophil("medium",targets,true);         
        Virus neighbor = new Virus(Strength.HIGH);     
        n.setDNA("virus"); 
        n.touchNeighbor(neighbor); 
        n.touchNeighbor(neighbor); 
        n.touchNeighbor(neighbor); 
        n.touchNeighbor(neighbor); 
        n.touchNeighbor(neighbor); 
        n.touchNeighbor(neighbor); 
        n.touchNeighbor(neighbor); 
        n.touchNeighbor(neighbor); 
        n.touchNeighbor(neighbor); 
        n.touchNeighbor(neighbor);         
        assertEquals(Strength.DEAD,neighbor.getStrength()); 
        assertNotEquals(Strength.HIGH,n.getStrength());     
        assertEquals("virus",Entity.bloodstream[0].getDNA()); 
        assertEquals("virus",Entity.bloodstream[1].getDNA()); 
        assertEquals("virus",Entity.bloodstream[2].getDNA());         
        assertNotEquals(0,++passed);         
    }     
     
    @Test 
    public void testNeutrophil5(){ 
        Entity.setEntity(5);         
        Entity[] targets = {new Bacteria(Strength.HIGH)};     
        Neutrophil n = new Neutrophil("medium",targets,true);         
        Virus neighbor = new Virus(Strength.HIGH);     
        n.setDNA("virus"); 
        n.touchNeighbor(neighbor); 
        n.touchNeighbor(neighbor); 
        n.touchNeighbor(neighbor); 
        n.touchNeighbor(neighbor); 
        n.touchNeighbor(neighbor); 
        n.touchNeighbor(neighbor); 
        n.touchNeighbor(neighbor); 
        n.touchNeighbor(neighbor); 
        n.touchNeighbor(neighbor); 
        n.touchNeighbor(neighbor);         
        assertEquals(Strength.HIGH,neighbor.getStrength()); 
        assertEquals(Strength.HIGH,n.getStrength());     
        assertEquals(null,Entity.bloodstream[0]);         
        assertNotEquals(0,++passed);         
    }     
     
    @Test 
    public void testVirus0() { 
        Virus b = new Virus(Strength.HIGH);     
        assertEquals(Strength.HIGH,b.getStrength()); 
        assertEquals("virus",b.getDNA());     
        b.setStrength(Strength.HIGH); 
        assertEquals(Strength.HIGH,b.getStrength());     
        b.kill(); 
        assertEquals(Strength.DEAD,b.getStrength());     
        b.setDNA("staph"); 
        assertEquals("staph",b.getDNA()); 
        assertNotEquals(0,++passed);         
    } 
     
    @Test 
    public void testVirus1(){         
        Virus v = new Virus(Strength.HIGH);     
        Bacteria neighbor = new Bacteria(Strength.HIGH); 
        v.touchNeighbor(neighbor);     
        assertEquals(Strength.HIGH,neighbor.getStrength()); 
         
        v.touchNeighbor(null);         
        assertNotEquals(0,++passed);         
    } 
     
    @Test 
    public void testVirus2(){         
        Virus v = new Virus(Strength.HIGH);     
        Entity[] targets = {new Virus(Strength.HIGH)};     
        Neutrophil neighbor = new Neutrophil("medium",targets,true);     
        v.touchNeighbor(neighbor);     
        assertEquals("virus",neighbor.getDNA()); 
        assertNotEquals(0,++passed);         
    } 
     
    @Test 
    public void testVirus3(){         
        Virus v = new Virus(Strength.DEAD);     
        Entity[] targets = {new Virus(Strength.HIGH)};     
        Neutrophil neighbor = new Neutrophil("medium",targets,true);     
        v.touchNeighbor(neighbor);     
        assertEquals("neutrophil",neighbor.getDNA()); 
        assertNotEquals(0,++passed);         
    }     
     
    @Test 
    public void testLymphocyte0() { 
        Entity[] targets = {new Virus(Strength.HIGH)};             
        Lymphocyte b = new Lymphocyte("small",targets);     
        assertEquals(Strength.HIGH,b.getStrength()); 
        assertEquals("lymphocyte",b.getDNA());     
        b.setStrength(Strength.HIGH); 
        assertEquals(Strength.HIGH,b.getStrength());     
        b.kill(); 
        assertEquals(Strength.DEAD,b.getStrength());     
        b.setDNA("staph"); 
        assertEquals("staph",b.getDNA()); 
        assertNotEquals(0,++passed);         
    }     
     
    @Test 
    public void testLymphocyte1(){         
        Entity[] targets = {new Virus(Strength.HIGH)};             
        Lymphocyte l = new Lymphocyte("small",targets);     
        Virus neighbor = new Virus(Strength.HIGH);     
        l.touchNeighbor(neighbor);         
        l.touchNeighbor(neighbor); 
        l.touchNeighbor(neighbor); 
        l.touchNeighbor(neighbor); 
        l.touchNeighbor(neighbor); 
        l.touchNeighbor(neighbor); 
        l.touchNeighbor(neighbor); 
        l.touchNeighbor(neighbor); 
        l.touchNeighbor(neighbor);         
        l.touchNeighbor(neighbor);         
        assertEquals(Strength.DEAD,neighbor.getStrength()); 
         
        l.touchNeighbor(null);         
        assertNotEquals(0,++passed);         
    }     
     
    @Test 
    public void testLymphocyte2(){         
        Entity[] targets = {new Virus(Strength.HIGH)};             
        Lymphocyte l = new Lymphocyte("small",targets);     
        Virus neighbor = new Virus(Strength.HIGH);     
        for (int i = 0; i < 1000; i++) 
            l.touchNeighbor(neighbor);     
        assertEquals(Strength.DEAD,neighbor.getStrength()); 
        assertEquals(Strength.DEAD,l.getStrength());     
        assertNotEquals(0,++passed);             
    }     
     
     
    /* 
     *     WhiteBloodCell should implement the parent's touchNeighbor method. 
        WhiteBloodCell's touchNeighbor method should call its absorb method. 
        absorb and release should be abstract methods in WhiteBloodCell. 
     */     
    @Test 
    public void testStyleAbstract() { 
        assertEquals("passed",checkAbstractTouchNeighbor());     
        assertEquals("passed",checkTouchNeighborCallsAbsorb());             
        assertEquals("passed",checkAbstract("absorb", "absorb should be abstract methods in WhiteBloodCell."));         
        assertEquals("passed",checkAbstract("release", "release should be abstract methods in WhiteBloodCell."));         
    } 
     
    /* 
     *     Neutrophil should override the parent's touchNeighbor method. 
        Macrophage should override the parent's touchNeighbor method. 
     */ 
    @Test 
    public void testStyleOverride(){ 
        assertEquals("passed",checkOverride("Neutrophil.java","touchNeighbor","Neutrophil should override the parent's touchNeighbor method."));     
        assertEquals("passed",checkOverride("Macrophage.java","touchNeighbor","Macrophage should override the parent's touchNeighbor method."));     
    } 
     
    /* 
     *     Neutrophil's touchNeighbor method should call the parent method. 
        Macrophage's touchNeighbor method should call the parent method. 
        Avoid attribute shadowing in any of the child classes. 
     */ 
     
    @Test 
    public void testStyleInheritanceReuse(){ 
        assertEquals("passed",checkParentCall("Neutrophil.java","touchNeighbor","Neutrophil's touchNeighbor method should call the parent method."));     
        assertEquals("passed",checkParentCall("Macrophage.java","touchNeighbor","Macrophage's touchNeighbor method should call the parent method."));     
        assertEquals("passed",checkShadowing("WhiteBloodCell.java","String","DNA", "WhiteBloodCell: Avoid attribute shadowing in any of the child classes.")); 
        assertEquals("passed",checkShadowing("WhiteBloodCell.java","Strength","strength","WhiteBloodCell: Avoid attribute shadowing in any of the child classes.")); 
        assertEquals("passed",checkShadowing("WhiteBloodCell.java","Entity[]","bloodstream","WhiteBloodCell: Avoid attribute shadowing in any of the child classes.")); 

        assertEquals("passed",checkShadowing("Neutrophil.java","String","DNA", "Neutrophil: Avoid attribute shadowing in any of the child classes.")); 
        assertEquals("passed",checkShadowing("Neutrophil.java","Strength","strength","Neutrophil: Avoid attribute shadowing in any of the child classes.")); 
        assertEquals("passed",checkShadowing("Neutrophil.java","Entity[]","bloodstream","Neutrophil: Avoid attribute shadowing in any of the child classes.")); 
        assertEquals("passed",checkShadowing("Neutrophil.java","String","nucleusType","Neutrophil: Avoid attribute shadowing in any of the child classes.")); 
        assertEquals("passed",checkShadowing("Neutrophil.java","Entity[]","targets","Neutrophil: Avoid attribute shadowing in any of the child classes.")); 

        assertEquals("passed",checkShadowing("Lymphocyte.java","String","DNA", "Lymphocyte: Avoid attribute shadowing in any of the child classes.")); 
        assertEquals("passed",checkShadowing("Lymphocyte.java","Strength","strength","Lymphocyte: Avoid attribute shadowing in any of the child classes.")); 
        assertEquals("passed",checkShadowing("Lymphocyte.java","Entity[]","bloodstream","Lymphocyte: Avoid attribute shadowing in any of the child classes.")); 
        assertEquals("passed",checkShadowing("Lymphocyte.java","String","nucleusType","Lymphocyte: Avoid attribute shadowing in any of the child classes.")); 
        assertEquals("passed",checkShadowing("Lymphocyte.java","Entity[]","targets","Lymphocyte: Avoid attribute shadowing in any of the child classes.")); 

        assertEquals("passed",checkShadowing("Macrophage.java","String","DNA", "Macrophage: Avoid attribute shadowing in any of the child classes.")); 
        assertEquals("passed",checkShadowing("Macrophage.java","Strength","strength","Macrophage: Avoid attribute shadowing in any of the child classes.")); 
        assertEquals("passed",checkShadowing("Macrophage.java","Entity[]","bloodstream","Macrophage: Avoid attribute shadowing in any of the child classes.")); 
        assertEquals("passed",checkShadowing("Macrophage.java","String","nucleusType","Macrophage: Avoid attribute shadowing in any of the child classes.")); 
        assertEquals("passed",checkShadowing("Macrophage.java","Entity[]","targets","Macrophage: Avoid attribute shadowing in any of the child classes.")); 
         
        assertEquals("passed",checkShadowing("Virus.java","String","DNA", "Virus: Avoid attribute shadowing in any of the child classes.")); 
        assertEquals("passed",checkShadowing("Virus.java","Strength","strength","Virus: Avoid attribute shadowing in any of the child classes.")); 
        assertEquals("passed",checkShadowing("Virus.java","Entity[]","bloodstream","Virus: Avoid attribute shadowing in any of the child classes.")); 

        assertEquals("passed",checkShadowing("Cytokine.java","String","DNA", "Cytokine: Avoid attribute shadowing in any of the child classes.")); 
        assertEquals("passed",checkShadowing("Cytokine.java","Strength","strength","Cytokine: Avoid attribute shadowing in any of the child classes.")); 
        assertEquals("passed",checkShadowing("Cytokine.java","Entity[]","bloodstream","Cytokine: Avoid attribute shadowing in any of the child classes.")); 
         
        assertEquals("passed",checkShadowing("Bacteria.java","String","DNA", "Bacteria: Avoid attribute shadowing in any of the child classes.")); 
        assertEquals("passed",checkShadowing("Bacteria.java","Strength","strength","Bacteria: Avoid attribute shadowing in any of the child classes.")); 
        assertEquals("passed",checkShadowing("Bacteria.java","Entity[]","bloodstream","Bacteria: Avoid attribute shadowing in any of the child classes."));     
    } 
     
    /* 
     *     All child classes appropriately use the parent class' constructors. 
        The @Override tag is used in all the appropriate places. 
        All appropriate attributes are private. 
     */ 
     
    @Test 
    public void testStyleInheritanceCorrectness(){ 
        assertEquals("passed", checkSuperCtor("WhiteBloodCell","WhiteBloodCell: All child classes appropriately use the parent class' constructors.")); 
        assertEquals("passed", checkSuperCtor("Neutrophil","Neutrophil: All child classes appropriately use the parent class' constructors.")); 
        assertEquals("passed", checkSuperCtor("Lymphocyte","Lymphocyte: All child classes appropriately use the parent class' constructors.")); 
        assertEquals("passed", checkSuperCtor("Macrophage","Macrophage: All child classes appropriately use the parent class' constructors.")); 
        assertEquals("passed", checkSuperCtor("Virus","Virus: All child classes appropriately use the parent class' constructors.")); 
        assertEquals("passed", checkSuperCtor("Cytokine","Cytokine: All child classes appropriately use the parent class' constructors.")); 
        assertEquals("passed", checkSuperCtor("Bacteria","Bacteria: All child classes appropriately use the parent class' constructors.")); 

        assertEquals("passed", checkOverride("WhiteBloodCell.java", "touchNeighbor", "WhiteBloodCell: The @Override tag is used in all the appropriate places.")); 
         
        assertEquals("passed", checkOverride("Neutrophil.java", "absorb", "Neutrophil: The @Override tag is used in all the appropriate places.")); 
        assertEquals("passed", checkOverride("Neutrophil.java", "release", "Neutrophil: The @Override tag is used in all the appropriate places.")); 
        assertEquals("passed", checkOverride("Neutrophil.java", "touchNeighbor", "Neutrophil: The @Override tag is used in all the appropriate places.")); 

        assertEquals("passed", checkOverride("Lymphocyte.java", "absorb", "Lymphocyte: The @Override tag is used in all the appropriate places.")); 
        assertEquals("passed", checkOverride("Lymphocyte.java", "release", "Lymphocyte: The @Override tag is used in all the appropriate places.")); 

        assertEquals("passed", checkOverride("Macrophage.java", "absorb", "Macrophage: The @Override tag is used in all the appropriate places.")); 
        assertEquals("passed", checkOverride("Macrophage.java", "release", "Macrophage: The @Override tag is used in all the appropriate places.")); 
        assertEquals("passed", checkOverride("Macrophage.java", "touchNeighbor", "Macrophage: The @Override tag is used in all the appropriate places.")); 
         
        assertEquals("passed", checkOverride("Cytokine.java", "touchNeighbor", "Cytokine: The @Override tag is used in all the appropriate places.")); 

        assertEquals("passed", checkOverride("Bacteria.java", "touchNeighbor", "Bacteria: The @Override tag is used in all the appropriate places.")); 

        assertEquals("passed", checkOverride("Virus.java", "touchNeighbor", "Virus: The @Override tag is used in all the appropriate places.")); 
         
        assertEquals("passed", checkPrivacy("Entity.java", "String", "DNA", "Entity: All appropriate attributes are private and commented.")); 
        assertEquals("passed", checkPrivacy("Entity.java", "Strength", "strength", "Entity: All appropriate attributes are private and commented."));         
//        assertEquals("passed", checkPrivacy("Entity.java", "Entity[]", "bloodstream", "Entity: All appropriate attributes are private.")); 
        assertEquals("passed", checkPrivacy("WhiteBloodCell.java", "String", "nucleusType", "WhiteBloodCell: All appropriate attributes are private and commented.")); 
        assertEquals("passed", checkPrivacy("WhiteBloodCell.java", "Entity[]", "targets", "WhiteBloodCell: All appropriate attributes are private and commented.")); 
        assertEquals("passed", checkPrivacy("Neutrophil.java", "boolean", "sniffCytokines", "Neutrophil: All appropriate attributes are private and commented.")); 
        assertEquals("passed", checkPrivacy("Macrophage.java", "int", "count", "Macrophage: All appropriate attributes are private and commented.")); 
    } 
     
    //@Test 
    public void testStyle(){ 
        assertEquals("passed", checkStyle("WhiteBloodCell.java", "Please check the following errors in your style:" )); 
    } 
     
    private String checkStyle(String filename, String errorMsg){ 
        String result = systemCall("java -jar checkstyle-7.1-all.jar -c src/main/resources/google_checks.xml").toString(); 
        if (!result.trim().equals("Starting audit...\nAudit done.")) 
            return filename + " " + errorMsg + " " + result; 
         
        return "passed"; 
    } 
     
    private String checkPrivacy(String filename, String type, String attribute, String errorMsg){ 
        String line = null; 
        try{ 
            FileReader fReader = new FileReader(filename); 
            BufferedReader bReader = new BufferedReader(fReader); 

            while((line = bReader.readLine()) != null){ 
                //System.out.println("(line.contains (//) || line.contains(/*))" + (line.contains ("//") || line.contains("/*"))); 
                line = line.trim(); 
                if(!line.isEmpty()) 
                    if (line.contains("private") && line.contains(type) && 
                            line.contains(attribute) && line.contains(";") && 
                            (line.contains ("//") || line.contains("/*"))) 
                            return "passed"; 
            } 
            bReader.close(); 
        }catch (Exception e){ 
            return "NOT MET: Couldn't open "+ filename; 
        } 
        return errorMsg; 
    } 
     
    private String checkSuperCtor(String className, String errorMsg){ 
        ArrayList<String> body = pullMethodBody(className+".java", "(\\s*)public(\\s*)"+className+"(\\s*)\\([a-zA-Z0-9 ,\\[\\]]*\\)(\\s*)\\{(.*)"); 
        for (int i = 0; i < body.size() ; i++){ 
            System.out.println(body.get(i)); 
            if (body.get(i).matches("(\\s*)super\\((.*);")) 
                return "passed"; 
        } 
        return errorMsg;         
    } 
     
    private String checkShadowing(String filename,String type, String variable, String errorMsg){ 
        String line = null; 
        try{ 
            FileReader fReader = new FileReader(filename); 
            BufferedReader bReader = new BufferedReader(fReader); 

            while((line = bReader.readLine()) != null){ 
                line = line.trim(); 
                if(!line.isEmpty()) 
                    if (line.contains(type) && line.contains(variable) && line.trim().endsWith(";")) 
                            return errorMsg; 
            } 
            bReader.close(); 
        }catch (Exception e){ 
            return "NOT MET: Couldn't open "+ filename; 
        } 
        return "passed";         
    } 
     
    private String checkParentCall(String filename, String method, String errorMsg){ 
        ArrayList<String> body = pullMethodBody(filename, "(\\s*)public(\\s*)void(\\s*)touchNeighbor(\\s*)\\([a-zA-Z ]+\\)(\\s*)\\{(.*)"); 
        for (int i = 0; i < body.size() ; i++){ 
            System.out.println(body.get(i)); 
            if (body.get(i).matches("(\\s*)super\\."+method+"\\((.*)")) 
                return "passed"; 
        } 
        return errorMsg;         
    } 
     
    private String checkOverride(String filename, String method, String errorMsg){ 
        String line = null; 
        try{ 
            FileReader fReader = new FileReader(filename); 
            BufferedReader bReader = new BufferedReader(fReader); 

            while((line = bReader.readLine()) != null){ 
                line = line.trim(); 
                if(!line.isEmpty()){ 
                    if (line.contains("@Override")){ 
                        while((line = bReader.readLine()).trim().isEmpty()){ 
                            //spin until next line found 
                        } 
                        if (line.contains("public") && line.contains("void") && line.contains(method) && !line.contains("abstract")) 
                            return "passed"; 
                    } 
                } 
            } 
            bReader.close(); 
        }catch (Exception e){ 
            return "NOT MET: Couldn't open "+ filename; 
        } 
        return errorMsg;             
    } 
         
    private String checkAbstractTouchNeighbor () { 
        String line = null; 
        try{ 
            FileReader fReader = new FileReader("WhiteBloodCell.java"); 
            BufferedReader bReader = new BufferedReader(fReader); 

            while((line = bReader.readLine()) != null){ 
                line = line.trim(); 
                if(!line.isEmpty()){ 
                    if (line.contains("public") && line.contains("void") && line.contains("touchNeighbor") && line.contains("Entity")) 
                        return "passed"; 
                } 
            } 
            bReader.close(); 
        }catch (Exception e){ 
            return "NOT MET: Couldn't open WhiteBloodCell.java"; 
        } 
        return "NOT MET: WhiteBloodCell should implement the parent's touchNeighbor method.";     
    } 
     
    private String checkAbstract(String method, String errorMsg){ 
        String line = null; 
        try{ 
            FileReader fReader = new FileReader("WhiteBloodCell.java"); 
            BufferedReader bReader = new BufferedReader(fReader); 

            while((line = bReader.readLine()) != null){ 
                line = line.trim(); 
                if(!line.isEmpty()){ 
                    if (line.contains("public") && line.contains("void") && line.contains(method) && line.contains("abstract")) 
                        return "passed"; 
                } 
            } 
            bReader.close(); 
        }catch (Exception e){ 
            return "NOT MET: Couldn't open WhiteBloodCell.java"; 
        } 
        return errorMsg;             
    } 
     
    public String checkTouchNeighborCallsAbsorb () { 
        ArrayList<String> body = pullMethodBody("WhiteBloodCell.java", "(\\s*)public(\\s*)void(\\s*)touchNeighbor(\\s*)\\([a-zA-Z ]+\\)(\\s*)\\{(.*)"); 
        for (int i = 0; i < body.size() ; i++){ 
            System.out.println(body.get(i)); 
            if (body.get(i).matches("(\\s*)absorb(\\s*)\\([a-zA-Z]+\\)(\\s*);(.*)")) 
                return "passed"; 
        } 
        return "NOT MET: WhiteBloodCell's touchNeighbor method should call its absorb method."; 
    }     
     
    //@Test 
    public void countPassed(){ 
        System.out.println(systemCall("curl -k https://cs.gmu.edu/~kdobolyi/sparc/process.php?user=sparc_JZZj_lqcWAv5N7VB-project1_0-PROGRESS"));             
        assertEquals(36,passed); 
        if (passed == 36) 
            System.out.println(systemCall("curl -k https://cs.gmu.edu/~kdobolyi/sparc/process.php?user=sparc_JZZj_lqcWAv5N7VB-project1_0-COMPLETED"));             
             
    } 
     
    public static StringBuffer systemCall(String cmd){ 
        StringBuffer result = new StringBuffer(); 
        try 
        { 
            System.err.println("doing "+ cmd); 
            Runtime run = Runtime.getRuntime(); 
            Process pr = run.exec(cmd); 
            pr.waitFor(); 
            BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getErrorStream())); 
            String line = null; 
             
            while ((line=buf.readLine())!=null) 
                result.append(line+"\n"); 
            buf.close(); 
            buf = new BufferedReader(new InputStreamReader(pr.getInputStream())); 
            while ((line=buf.readLine())!=null) 
                result.append(line+"\n");     
            buf.close(); 
            pr.getOutputStream().close(); 
            pr.destroy(); 
        } 
        catch (Exception e) 
        { 
            StackTraceElement[] elts = e.getStackTrace(); 
            for(int i=0; i < elts.length; i++) 
                result.append(elts[i].toString()+"\n"); 
        } 
        return result; 
    } 
     
    private ArrayList pullMethodBody(String filename, String methodRegex){ 
        ArrayList body = new ArrayList(); 
        String line = null; 
        int brackets = 0; 
        boolean found = false; 
        int bodyBrackets = 0; 
        try{ 
            FileReader fReader = new FileReader(filename); 
            BufferedReader bReader = new BufferedReader(fReader); 

            while((line = bReader.readLine()) != null){ 
                System.out.println(line); 
                line = line.trim(); 
                if(!line.isEmpty()){ 
                    if (line.matches(methodRegex) && line.contains("{")){ 
                        //System.out.println("FOUND METHOD*************"); 
                        bodyBrackets = brackets;                         
                        brackets++; 
                        found = true; 
                    } 
                    else if (line.contains("{")) 
                        brackets++; 
                     
                    if (line.contains("}")) 
                        brackets--;         
                     
                    if (found){ 
                        body.add(line); 
                        //System.out.println("BRACKETS************* " + brackets); 
                        //System.out.println("BODYBRACKETS************* " + bodyBrackets); 
                    }                     
                     
                    if (found && brackets == bodyBrackets ) 
                        return body; 
                } 
            } 
            bReader.close(); 
        }catch (Exception e){ 
            return null; 
        } 
        return null;             
    } 
} 

