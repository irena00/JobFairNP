package domen;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PaketTest {

    private Paket paket;

    @BeforeEach
    void setUp() throws Exception {
        paket = new Paket(1L, "Basic", 100.0);
    }

    @AfterEach
    void tearDown() throws Exception {
        paket = null;
    }

    @Test
    public void testGetPaketID() {
        assertEquals(1L, paket.getPaketID());
    }

    @Test
    public void testSetPaketID() {
        Long newID = 2L;
        paket.setPaketID(newID);
        assertEquals(newID, paket.getPaketID());
    }

    @Test
    public void testGetNazivPaketa() {
        assertEquals("Basic", paket.getNazivPaketa());
    }

    @Test
    public void testSetNazivPaketa() {
        assertThrows(IllegalArgumentException.class, () -> paket.setNazivPaketa(null));
        assertThrows(IllegalArgumentException.class, () -> paket.setNazivPaketa(""));
        assertThrows(IllegalArgumentException.class, () -> paket.setNazivPaketa("  "));
        
        String newName = "Advanced";
        paket.setNazivPaketa(newName);
        assertEquals(newName, paket.getNazivPaketa());
    }

    @Test
    public void testGetCenaPaketa() {
        assertEquals(100.0, paket.getCenaPaketa(), 0.001);
    }

    @Test
    public void testSetCenaPaketa() {
        assertThrows(IllegalArgumentException.class, () -> paket.setCenaPaketa(-50.0));
        
        double newPrice = 150.0;
        paket.setCenaPaketa(newPrice);
        assertEquals(newPrice, paket.getCenaPaketa(), 0.001);
    }
    
    @Test
    public void testSetCenaPaketaNegative() {
        assertThrows(IllegalArgumentException.class, () -> paket.setCenaPaketa(-50.0));
    }

    @Test
    public void testToString() {
        assertEquals("Basic (Cena: 100.0din)", paket.toString());
    }

    @Test
    public void testEqualsSameInstance() {
        assertEquals(paket, paket);
    }

    @Test
    public void testEqualsNull() {
        assertNotEquals(paket, null);
    }

    @Test
    public void testEqualsDifferentClass() {
        assertNotEquals(paket, "Basic");
    }


    @Test
    public void testEqualsDifferentId() {
        Paket other = new Paket(2L, "Basic", 100.0);
        assertNotEquals(paket, other);
    }
}