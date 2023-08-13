package domen;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class StavkaUgovoraTest {
    private StavkaUgovora stavka;

    @BeforeEach
    void setUp() {
        Ugovor ugovor = new Ugovor(1L, "Test Udruzenje", 1000.0, null, null, null, null);
        stavka = new StavkaUgovora(ugovor, 1, "Test Stavka", 500.0);
    }

    @AfterEach
    void tearDown() {
        stavka = null;
    }

    @Test
    void testGetUgovor() {
        assertNotNull(stavka.getUgovor());
    }

    @Test
    void testSetUgovor() {
        Ugovor newUgovor = new Ugovor(2L, "New Udruzenje", 1500.0, null, null, null, null);

        stavka.setUgovor(newUgovor);

        assertEquals(newUgovor, stavka.getUgovor());
    }

    @Test
    void testGetRbStavke() {
        assertEquals(1, stavka.getRbStavke());
    }

    @Test
    void testSetRbStavke() {
        stavka.setRbStavke(2);

        assertEquals(2, stavka.getRbStavke());
    }

    @Test
    void testGetNazivStavke() {
        assertEquals("Test Stavka", stavka.getNazivStavke());
    }

    @Test
    void testSetNazivStavke() {
        String newNazivStavke = "New Stavka";

        stavka.setNazivStavke(newNazivStavke);

        assertEquals(newNazivStavke, stavka.getNazivStavke());
    }

    @Test
    void testGetCenaStavke() {
        assertEquals(500.0, stavka.getCenaStavke());
    }

    @Test
    void testSetCenaStavke() {
        stavka.setCenaStavke(700.0);

        assertEquals(700.0, stavka.getCenaStavke());
    }
}
