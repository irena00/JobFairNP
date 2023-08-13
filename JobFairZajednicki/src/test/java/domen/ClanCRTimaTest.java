package domen;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClanCRTimaTest {

    private ClanCRTima clanCRTima;

    @BeforeEach
    public void setUp() throws Exception {
        clanCRTima = new ClanCRTima(1L, "John", "Doe", "john.doe@example.com", "123456789");
    }

    @Test
    public void testGetClanID() {
        assertEquals(1L, clanCRTima.getClanID());
    }

    @Test
    public void testSetClanID() {
        clanCRTima.setClanID(2L);
        assertEquals(2L, clanCRTima.getClanID());
    }

    @Test
    public void testGetImeClana() {
        assertEquals("John", clanCRTima.getImeClana());
    }

    @Test
    public void testSetImeClana() {
        clanCRTima.setImeClana("Jane");
        assertEquals("Jane", clanCRTima.getImeClana());
    }

    @Test
    public void testGetPrezimeClana() {
        assertEquals("Doe", clanCRTima.getPrezimeClana());
    }

    @Test
    public void testSetPrezimeClana() {
        clanCRTima.setPrezimeClana("Smith");
        assertEquals("Smith", clanCRTima.getPrezimeClana());
    }

    @Test
    public void testGetEmail() {
        assertEquals("john.doe@example.com", clanCRTima.getEmail());
    }

    @Test
    public void testSetEmail() {
        clanCRTima.setEmail("jane.smith@example.com");
        assertEquals("jane.smith@example.com", clanCRTima.getEmail());
    }

    @Test
    public void testGetTelefon() {
        assertEquals("123456789", clanCRTima.getTelefon());
    }

    @Test
    public void testSetTelefon() {
        clanCRTima.setTelefon("987654321");
        assertEquals("987654321", clanCRTima.getTelefon());
    }

    @Test
    public void testToString() {
        String s = clanCRTima.toString();
        assertTrue(s.contains("John"));
        assertTrue(s.contains("Doe"));
    }

    
}
