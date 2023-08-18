package domen;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StavkaUgovoraTest {
	private StavkaUgovora stavkaUgovora;
	private Ugovor ugovor;
	private Paket paket;
    private Sastanak sastanak;
    private Kompanija kompanija;
    private Administrator administrator;
    
    @BeforeEach
    public void setUp() throws Exception {
    	kompanija = new Kompanija(1L, "123456789", "Company", "Address", "IT", new ClanCRTima(1L, "John", "Doe", "john@example.com", "1234567890"));
        administrator = new Administrator(1L, "Admin", "User", "admin", "password");
        sastanak = new Sastanak(1L, new Date(), "Meeting Topic", "Meeting Room", kompanija, administrator);
        ugovor = new Ugovor(2L, "BEST", 0, new Date(), sastanak, paket, null);
        stavkaUgovora = new StavkaUgovora(ugovor, 1, "Stavka", 30000.00);
    }

    @AfterEach
    public void tearDown() {
        stavkaUgovora = null;
    }
    
    @Test
    public void testGetStavkaUgovoraID() {
        assertEquals(1, stavkaUgovora.getRbStavke());
    }
    
    @Test
    public void testGetStavkaUgovoraNazivStavke() {
        assertEquals("Stavka", stavkaUgovora.getNazivStavke());
    }
    
    @Test
    public void testGetStavkaUgovoraCena() {
        assertEquals(30000.00, stavkaUgovora.getCenaStavke());
    }
    
    @Test
    public void testGetStavkaUgovoraUgovor() {
        assertEquals(ugovor, stavkaUgovora.getUgovor());
    }
    
    @Test
    public void testGetStavkaUgovoraUgovorNull() {
    	assertThrows(IllegalArgumentException.class, () -> stavkaUgovora.setUgovor(null));
    }
    
    @Test
    public void testGetStavkaUgovoraNazivStavkeNUll() {
    	assertThrows(IllegalArgumentException.class, () -> stavkaUgovora.setNazivStavke(""));
    }
    
    @Test
    public void testGetStavkaUgovoraCenaStavkeNegative() {
    	assertThrows(IllegalArgumentException.class, () -> stavkaUgovora.setCenaStavke(-100));
    }
}
