package domen;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.*;

class SastanakTest {

    private Sastanak sastanak;
    private Kompanija kompanija;
    private Administrator administrator;

    @BeforeEach
    void setUp() throws Exception {
        administrator = new Administrator(1L, "Admin", "Adminovic", "admin", "password");
        kompanija = new Kompanija(1L, "1234567890", "Company", "123 Main St", "Tech", null);
        sastanak = new Sastanak(1L, new Date(), "Meeting", "Conference Room", kompanija, administrator);
    }

    @AfterEach
    void tearDown() throws Exception {
        sastanak = null;
        kompanija = null;
        administrator = null;
    }

    @Test
    public void testGetSastanakID() {
        assertEquals(1L, sastanak.getSastanakID());
    }

    @Test
    public void testSetSastanakID() {
        Long newID = 2L;
        sastanak.setSastanakID(newID);
        assertEquals(newID, sastanak.getSastanakID());
    }

    @Test
    public void testGetDatumVreme() {
        assertNotNull(sastanak.getDatumVreme());
    }

    @Test
    public void testSetDatumVreme() {
        Date newDatumVreme = new Date();
        sastanak.setDatumVreme(newDatumVreme);
        assertEquals(newDatumVreme, sastanak.getDatumVreme());
    }

    @Test
    public void testGetTema() {
        assertEquals("Meeting", sastanak.getTema());
    }

    @Test
    public void testSetTema() {
        String newTema = "Important Meeting";
        sastanak.setTema(newTema);
        assertEquals(newTema, sastanak.getTema());
    }

    @Test
    public void testGetLokacija() {
        assertEquals("Conference Room", sastanak.getLokacija());
    }

    @Test
    public void testSetLokacija() {
        String newLokacija = "Board Room";
        sastanak.setLokacija(newLokacija);
        assertEquals(newLokacija, sastanak.getLokacija());
    }

    @Test
    public void testGetKompanija() {
        assertEquals(kompanija, sastanak.getKompanija());
    }

    @Test
    public void testSetKompanija() {
        Kompanija newKompanija = new Kompanija(2L, "9876543210", "New Company", "456 Main St", "Finance", null);
        sastanak.setKompanija(newKompanija);
        assertEquals(newKompanija, sastanak.getKompanija());
    }

    @Test
    public void testGetAdministrator() {
        assertEquals(administrator, sastanak.getAdministrator());
    }

    @Test
    public void testSetAdministrator() {
        Administrator newAdministrator = new Administrator(2L, "NewAdmin", "NewAdminovic", "newadmin", "newpassword");
        sastanak.setAdministrator(newAdministrator);
        assertEquals(newAdministrator, sastanak.getAdministrator());
    }

    @Test
    public void testEqualsSameInstance() {
        assertEquals(sastanak, sastanak);
    }

    @Test
    public void testEqualsNull() {
        assertNotEquals(sastanak, null);
    }

    @Test
    public void testEqualsDifferentClass() {
        assertNotEquals(sastanak, "Meeting");
    }

    @Test
    public void testEqualsSameID() {
        Sastanak other = new Sastanak(1L, new Date(), "Meeting", "Conference Room", kompanija, administrator);
        assertEquals(sastanak, other);
    }

    @Test
    public void testEqualsDifferentID() {
        Sastanak other = new Sastanak(2L, new Date(), "Meeting", "Conference Room", kompanija, administrator);
        assertNotEquals(sastanak, other);
    }

    @Test
    public void testToString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String expectedToString = kompanija + " [Datum: " + sdf.format(sastanak.getDatumVreme()) + "]";
        assertEquals(expectedToString, sastanak.toString());
    }

    @Test
    public void testInvalidSastanakID() {
        assertThrows(IllegalArgumentException.class, () -> new Sastanak(-1L, new Date(), "Meeting", "Room", kompanija, administrator));
        assertThrows(IllegalArgumentException.class, () -> new Sastanak(null, new Date(), "Meeting", "Room", kompanija, administrator));
    }

    @Test
    public void testInvalidDatumVreme() {
        assertThrows(IllegalArgumentException.class, () -> new Sastanak(1L, null, "Meeting", "Room", kompanija, administrator));
    }

    @Test
    public void testInvalidTema() {
        assertThrows(IllegalArgumentException.class, () -> new Sastanak(1L, new Date(), null, "Room", kompanija, administrator));
        assertThrows(IllegalArgumentException.class, () -> new Sastanak(1L, new Date(), "", "Room", kompanija, administrator));
    }

    @Test
    public void testInvalidLokacija() {
        assertThrows(IllegalArgumentException.class, () -> new Sastanak(1L, new Date(), "Meeting", null, kompanija, administrator));
        assertThrows(IllegalArgumentException.class, () -> new Sastanak(1L, new Date(), "Meeting", "", kompanija, administrator));
    }

    @Test
    public void testInvalidKompanija() {
        assertThrows(IllegalArgumentException.class, () -> new Sastanak(1L, new Date(), "Meeting", "Room", null, administrator));
    }

    @Test
    public void testInvalidAdministrator() {
        assertThrows(IllegalArgumentException.class, () -> new Sastanak(1L, new Date(), "Meeting", "Room", kompanija, null));
    }
}
