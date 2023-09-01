package domen;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class KompanijaTest {

    private Kompanija kompanija;

    @BeforeEach
    public void setUp() throws Exception {
        Long kompanijaID = 1L;
        String PIB = "123456789";
        String nazivKompanije = "ABC Company";
        String adresa = "123 Main St";
        String granaPrivrede = "Technology";
        ClanCRTima clanCRTima = new ClanCRTima(1L, "John", "Doe", "john@example.com", "1234567890");

        kompanija = new Kompanija(kompanijaID, PIB, nazivKompanije, adresa, granaPrivrede, clanCRTima);
    }

    @AfterEach
    public void tearDown() {
        kompanija = null;
    }

    @Test
    public void testGetKompanijaID() {
        assertEquals(1L, kompanija.getKompanijaID());
    }

    @Test
    public void testSetKompanijaID() {
        kompanija.setKompanijaID(2L);
        assertEquals(2L, kompanija.getKompanijaID());
    }

    @Test
    public void testGetPIB() {
        assertEquals("123456789", kompanija.getPIB());
    }

    @Test
    public void testSetPIB() {
        kompanija.setPIB("987654321");
        assertEquals("987654321", kompanija.getPIB());
    }

    @Test
    public void testSetPIBWithNull() {
        assertThrows(IllegalArgumentException.class, () -> kompanija.setPIB(null));
    }

    @Test
    public void testSetPIBWithBlank() {
        assertThrows(IllegalArgumentException.class, () -> kompanija.setPIB(""));
    }

    @Test
    public void testGetNazivKompanije() {
        assertEquals("ABC Company", kompanija.getNazivKompanije());
    }

    @Test
    public void testSetNazivKompanije() {
        kompanija.setNazivKompanije("XYZ Corporation");
        assertEquals("XYZ Corporation", kompanija.getNazivKompanije());
    }

    @Test
    public void testSetNazivKompanijeWithNull() {
        assertThrows(IllegalArgumentException.class, () -> kompanija.setNazivKompanije(null));
    }

    @Test
    public void testSetNazivKompanijeWithBlank() {
        assertThrows(IllegalArgumentException.class, () -> kompanija.setNazivKompanije(""));
    }

    @Test
    public void testGetAdresa() {
        assertEquals("123 Main St", kompanija.getAdresa());
    }

    @Test
    public void testSetAdresa() {
        kompanija.setAdresa("456 Oak Ave");
        assertEquals("456 Oak Ave", kompanija.getAdresa());
    }

    @Test
    public void testSetAdresaWithNull() {
        assertThrows(IllegalArgumentException.class, () -> kompanija.setAdresa(null));
    }

    @Test
    public void testSetAdresaWithBlank() {
        assertThrows(IllegalArgumentException.class, () -> kompanija.setAdresa(""));
    }

    @Test
    public void testGetGranaPrivrede() {
        assertEquals("Technology", kompanija.getGranaPrivrede());
    }

    @Test
    public void testSetGranaPrivrede() {
        kompanija.setGranaPrivrede("Finance");
        assertEquals("Finance", kompanija.getGranaPrivrede());
    }

    @Test
    public void testSetGranaPrivredeWithNull() {
        assertThrows(IllegalArgumentException.class, () -> kompanija.setGranaPrivrede(null));
    }

    @Test
    public void testSetGranaPrivredeWithBlank() {
        assertThrows(IllegalArgumentException.class, () -> kompanija.setGranaPrivrede(""));
    }

    @Test
    public void testGetClanCRTima() {
        ClanCRTima clanCRTima = kompanija.getClanCRTima();
        assertEquals(1L, clanCRTima.getClanID());
        assertEquals("John", clanCRTima.getImeClana());
        assertEquals("Doe", clanCRTima.getPrezimeClana());
        assertEquals("john@example.com", clanCRTima.getEmail());
        assertEquals("1234567890", clanCRTima.getTelefon());
    }

    @Test
    public void testSetClanCRTima() {
        ClanCRTima newClanCRTima = new ClanCRTima(2L, "Jane", "Smith", "jane@example.com", "9876543210");
        kompanija.setClanCRTima(newClanCRTima);

        ClanCRTima clanCRTima = kompanija.getClanCRTima();
        assertEquals(2L, clanCRTima.getClanID());
        assertEquals("Jane", clanCRTima.getImeClana());
        assertEquals("Smith", clanCRTima.getPrezimeClana());
        assertEquals("jane@example.com", clanCRTima.getEmail());
        assertEquals("9876543210", clanCRTima.getTelefon());
    }

    @Test
    public void testToString() {
        String s = kompanija.toString();
        assertTrue(s.contains("ABC Company"));
        assertTrue(s.contains("John"));
    }
}