package domen;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SastanakTest {

    private Sastanak sastanak;
    private Kompanija kompanija;
    private Administrator administrator;

    @BeforeEach
    void setUp() throws Exception {
        kompanija = new Kompanija(1L, "123456789", "Company", "Address", "IT", new ClanCRTima(1L, "John", "Doe", "john@example.com", "1234567890"));
        administrator = new Administrator(1L, "Admin", "User", "admin", "password");
        sastanak = new Sastanak(1L, new Date(), "Meeting Topic", "Meeting Room", kompanija, administrator);
    }

    @Test
    public void testGetSastanakID() {
        assertEquals(1L, sastanak.getSastanakID());
    }

    @Test
    public void testSetSastanakID() {
        Long newId = 2L;
        sastanak.setSastanakID(newId);
        assertEquals(newId, sastanak.getSastanakID());
    }

    @Test
    public void testGetDatumVreme() {
        assertNotNull(sastanak.getDatumVreme());
    }

    @Test
    public void testSetDatumVreme() {
        Date newDate = new Date();
        sastanak.setDatumVreme(newDate);
        assertEquals(newDate, sastanak.getDatumVreme());
    }

    @Test
    public void testSetDatumVreme_Null() {
        assertThrows(IllegalArgumentException.class, () -> sastanak.setDatumVreme(null));
    }

    @Test
    public void testGetTema() {
        assertEquals("Meeting Topic", sastanak.getTema());
    }

    @Test
    public void testSetTema() {
        String newTema = "Updated Topic";
        sastanak.setTema(newTema);
        assertEquals(newTema, sastanak.getTema());
    }

    @Test
    public void testSetTema_Null() {
        assertThrows(IllegalArgumentException.class, () -> sastanak.setTema(null));
    }

    @Test
    public void testSetTema_Blank() {
        assertThrows(IllegalArgumentException.class, () -> sastanak.setTema(""));
    }

    @Test
    public void testGetLokacija() {
        assertEquals("Meeting Room", sastanak.getLokacija());
    }

    @Test
    public void testSetLokacija() {
        String newLokacija = "Conference Hall";
        sastanak.setLokacija(newLokacija);
        assertEquals(newLokacija, sastanak.getLokacija());
    }

    @Test
    public void testSetLokacija_Null() {
        assertThrows(IllegalArgumentException.class, () -> sastanak.setLokacija(null));
    }

    @Test
    public void testSetLokacija_Blank() {
        assertThrows(IllegalArgumentException.class, () -> sastanak.setLokacija(""));
    }

    @Test
    public void testGetKompanija() {
        assertEquals(kompanija, sastanak.getKompanija());
    }

    @Test
    public void testSetKompanija() {
        Kompanija newKompanija = new Kompanija(2L, "987654321", "New Company", "New Address", "Finance", new ClanCRTima(2L, "Jane", "Smith", "jane@example.com", "9876543210"));
        sastanak.setKompanija(newKompanija);
        assertEquals(newKompanija, sastanak.getKompanija());
    }

    @Test
    public void testSetKompanija_Null() {
        assertThrows(IllegalArgumentException.class, () -> sastanak.setKompanija(null));
    }

    @Test
    public void testGetAdministrator() {
        assertEquals(administrator, sastanak.getAdministrator());
    }

    @Test
    public void testSetAdministrator() {
        Administrator newAdministrator = new Administrator(2L, "New Admin", "User", "newadmin", "newpassword");
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
        assertNotEquals(sastanak, "Some String");
    }

    @Test
    public void testEqualsSameId() {
        Sastanak other = new Sastanak(1L, new Date(), "Another Topic", "Another Room", kompanija, administrator);
        assertEquals(sastanak, other);
    }

    @Test
    public void testEqualsDifferentId() {
        Sastanak other = new Sastanak(2L, new Date(), "Another Topic", "Another Room", kompanija, administrator);
        assertNotEquals(sastanak, other);
    }
}