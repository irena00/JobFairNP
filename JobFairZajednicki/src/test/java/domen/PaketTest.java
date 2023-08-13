package domen;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class PaketTest {

    @Test
    void testValidConstructorAndGetters() {
        Long paketID = 1L;
        String nazivPaketa = "Basic Package";
        double cenaPaketa = 1000.0;

        Paket paket = new Paket(paketID, nazivPaketa, cenaPaketa);

        assertEquals(paketID, paket.getPaketID());
        assertEquals(nazivPaketa, paket.getNazivPaketa());
        assertEquals(cenaPaketa, paket.getCenaPaketa());
    }

    @Test
    void testConstructorWithNullValues() {
        assertDoesNotThrow(() -> new Paket(null, null, 0.0));
    }

    @Test
    void testBlankNazivPaketa() {
        assertThrows(IllegalArgumentException.class, () -> new Paket(1L, "", 1000.0));
    }

    @Test
    void testNegativeCenaPaketa() {
        assertThrows(IllegalArgumentException.class, () -> new Paket(1L, "Basic Package", -100.0));
    }

    @Test
    void testSetters() {
        Paket paket = new Paket(1L, "Basic Package", 1000.0);

        assertDoesNotThrow(() -> paket.setPaketID(2L));
        assertDoesNotThrow(() -> paket.setNazivPaketa("Advanced Package"));
        assertDoesNotThrow(() -> paket.setCenaPaketa(1500.0));

        assertDoesNotThrow(() -> paket.setPaketID(null));
        assertDoesNotThrow(() -> paket.setNazivPaketa(null));

        assertThrows(IllegalArgumentException.class, () -> paket.setNazivPaketa(""));

        assertThrows(IllegalArgumentException.class, () -> paket.setCenaPaketa(-200.0));
    }

    @Test
    void testToString() {
       
        Paket paket = new Paket(1L, "Advanced Package", 2000.0);

        
        assertEquals("Advanced Package (Cena: 2000.0din)", paket.toString());
    }

    @Test
    void testAbstractMethods() {
       
        Paket paket = new Paket();

        
        assertEquals(" Paket ", paket.nazivTabele());
        assertEquals(" p ", paket.alijas());
        assertEquals("", paket.join());
        assertEquals("", paket.koloneZaInsert());
        assertEquals("", paket.vrednostZaPrimarniKljuc());
        assertEquals("", paket.vrednostiZaInsert());
        assertEquals("", paket.vrednostiZaUpdate());
        assertEquals("", paket.uslov());
    }
}