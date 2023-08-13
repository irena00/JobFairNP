package domen;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class UgovorTest {
    private Ugovor ugovor;

    @BeforeEach
    void setUp() {
        ArrayList<StavkaUgovora> stavkeUgovora = new ArrayList<>();
        ugovor = new Ugovor(1L, "Example Udruzenje", 1000.0, new Date(), new Sastanak(), new Paket(), stavkeUgovora);
    }

    @AfterEach
    void tearDown() {
        ugovor = null;
    }

    @Test
    void testValidUgovorID() {
        ugovor.setUgovorID(2L);

        assertEquals(2L, ugovor.getUgovorID());
    }

    @Test
    void testInvalidUgovorID() {
        assertThrows(IllegalArgumentException.class, () -> ugovor.setUgovorID(null));
        assertThrows(IllegalArgumentException.class, () -> ugovor.setUgovorID(-1L));
    }

    @Test
    void testValidUdruzenje() {
        ugovor.setUdruzenje("Updated Udruzenje");

        assertEquals("Updated Udruzenje", ugovor.getUdruzenje());
    }

    @Test
    void testInvalidUdruzenje() {
        assertThrows(IllegalArgumentException.class, () -> ugovor.setUdruzenje(null));
        assertThrows(IllegalArgumentException.class, () -> ugovor.setUdruzenje(""));
    }

    @Test
    void testValidUkupnaCena() {
        ugovor.setUkupnaCena(1500.0);

        assertEquals(1500.0, ugovor.getUkupnaCena());
    }

    @Test
    void testInvalidUkupnaCena() {
        assertThrows(IllegalArgumentException.class, () -> ugovor.setUkupnaCena(-100.0));
    }

    @Test
    void testValidDatumZakljucenja() {
        Date newDate = new Date();

        ugovor.setDatumZakljucenja(newDate);

        assertEquals(newDate, ugovor.getDatumZakljucenja());
    }

    @Test
    void testInvalidDatumZakljucenja() {
        assertThrows(IllegalArgumentException.class, () -> ugovor.setDatumZakljucenja(null));
    }

    @Test
    void testValidSastanak() {
        Sastanak sastanak = new Sastanak();

        ugovor.setSastanak(sastanak);

        assertEquals(sastanak, ugovor.getSastanak());
    }

    @Test
    void testInvalidSastanak() {
        assertThrows(IllegalArgumentException.class, () -> ugovor.setSastanak(null));
    }

    @Test
    void testValidPaket() {
        Paket paket = new Paket();

        ugovor.setPaket(paket);

        assertEquals(paket, ugovor.getPaket());
    }

    @Test
    void testInvalidPaket() {
        assertThrows(IllegalArgumentException.class, () -> ugovor.setPaket(null));
    }

    @Test
    void testValidStavkeUgovora() {
        ArrayList<StavkaUgovora> stavkeUgovora = new ArrayList<>();
        stavkeUgovora.add(new StavkaUgovora());

        ugovor.setStavkeUgovora(stavkeUgovora);

        assertEquals(stavkeUgovora, ugovor.getStavkeUgovora());
    }

    @Test
    void testInvalidStavkeUgovora() {
        ugovor.setStavkeUgovora(null);

        assertNull(ugovor.getStavkeUgovora());
    }
}