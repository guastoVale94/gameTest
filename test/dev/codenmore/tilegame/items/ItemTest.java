/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.codenmore.tilegame.items;

import avvio.Handler;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author valerio serino
 */
public class ItemTest {
    
    public ItemTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of tick method, of class Item.
     */
    @Test
    public void testTick() {
        System.out.println("tick");
        Item instance = null;
        instance.tick();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of render method, of class Item.
     */
    @Test
    public void testRender_Graphics() {
        System.out.println("render");
        Graphics g = null;
        Item instance = null;
        instance.render(g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of render method, of class Item.
     */
    @Test
    public void testRender_3args() {
        System.out.println("render");
        Graphics g = null;
        int x = 0;
        int y = 0;
        Item instance = null;
        instance.render(g, x, y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createNew method, of class Item.
     */
    @Test
    public void testCreateNew() {
        System.out.println("createNew");
        int x = 0;
        int y = 0;
        Item instance = null;
        Item expResult = null;
        Item result = instance.createNew(x, y);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPosition method, of class Item.
     */
    @Test
    public void testSetPosition() {
        System.out.println("setPosition");
        int x = 0;
        int y = 0;
        Item instance = null;
        instance.setPosition(x, y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHandler method, of class Item.
     */
    @Test
    public void testGetHandler() {
        System.out.println("getHandler");
        Item instance = null;
        Handler expResult = null;
        Handler result = instance.getHandler();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHandler method, of class Item.
     */
    @Test
    public void testSetHandler() {
        System.out.println("setHandler");
        Handler handler = null;
        Item instance = null;
        instance.setHandler(handler);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTexture method, of class Item.
     */
    @Test
    public void testGetTexture() {
        System.out.println("getTexture");
        Item instance = null;
        BufferedImage expResult = null;
        BufferedImage result = instance.getTexture();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTexture method, of class Item.
     */
    @Test
    public void testSetTexture() {
        System.out.println("setTexture");
        BufferedImage texture = null;
        Item instance = null;
        instance.setTexture(texture);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Item.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Item instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Item.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Item instance = null;
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getX method, of class Item.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        Item instance = null;
        int expResult = 0;
        int result = instance.getX();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setX method, of class Item.
     */
    @Test
    public void testSetX() {
        System.out.println("setX");
        int x = 0;
        Item instance = null;
        instance.setX(x);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getY method, of class Item.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        Item instance = null;
        int expResult = 0;
        int result = instance.getY();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setY method, of class Item.
     */
    @Test
    public void testSetY() {
        System.out.println("setY");
        int y = 0;
        Item instance = null;
        instance.setY(y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class Item.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Item instance = null;
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isPickedUp method, of class Item.
     */
    @Test
    public void testIsPickedUp() {
        System.out.println("isPickedUp");
        Item instance = null;
        boolean expResult = false;
        boolean result = instance.isPickedUp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
