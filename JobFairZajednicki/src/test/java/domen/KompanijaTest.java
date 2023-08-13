package domen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class KompanijaTest {

    @Test
    void testValidConstructor() {
        Long kompanijaID = 1L;
        String PIB = "123456789";
        String nazivKompanije = "ABC Company";
        String adresa = "123 Main St";
        String granaPrivrede = "Technology";
        ClanCRTima clanCRTima = new ClanCRTima(1L, "John", "Doe", "john@example.com", "1234567890");
        
        Kompanija kompanija = new Kompanija(kompanijaID, PIB, nazivKompanije, adresa, granaPrivrede, clanCRTima);
        
        assertEquals(kompanijaID, kompanija.getKompanijaID());
        assertEquals(PIB, kompanija.getPIB());
        assertEquals(nazivKompanije, kompanija.getNazivKompanije());
        assertEquals(adresa, kompanija.getAdresa());
        assertEquals(granaPrivrede, kompanija.getGranaPrivrede());
        assertEquals(clanCRTima, kompanija.getClanCRTima());
    }
    
    @Test
    void testConstructorWithNullValues() {
        assertThrows(IllegalArgumentException.class, () -> new Kompanija(null, "123", "Name", "Address", "Industry", new ClanCRTima()));
        assertThrows(IllegalArgumentException.class, () -> new Kompanija(1L, null, "Name", "Address", "Industry", new ClanCRTima()));
        assertThrows(IllegalArgumentException.class, () -> new Kompanija(1L, "123", null, "Address", "Industry", new ClanCRTima()));
        assertThrows(IllegalArgumentException.class, () -> new Kompanija(1L, "123", "Name", null, "Industry", new ClanCRTima()));
        assertThrows(IllegalArgumentException.class, () -> new Kompanija(1L, "123", "Name", "Address", null, new ClanCRTima()));
        assertThrows(IllegalArgumentException.class, () -> new Kompanija(1L, "123", "Name", "Address", "Industry", null));
    }
    
    @Test
    void testSettersWithNullValues() {
        Kompanija kompanija = new Kompanija(1L, "123", "Name", "Address", "Industry", new ClanCRTima());

        assertThrows(IllegalArgumentException.class, () -> kompanija.setPIB(null));
        assertThrows(IllegalArgumentException.class, () -> kompanija.setNazivKompanije(null));
        assertThrows(IllegalArgumentException.class, () -> kompanija.setAdresa(null));
        assertThrows(IllegalArgumentException.class, () -> kompanija.setGranaPrivrede(null));
    }

    @Test
    void testSettersWithBlankValues() {
        Kompanija kompanija = new Kompanija(1L, "123", "Name", "Address", "Industry", new ClanCRTima());

        assertThrows(IllegalArgumentException.class, () -> kompanija.setPIB(""));
        assertThrows(IllegalArgumentException.class, () -> kompanija.setNazivKompanije(""));
        assertThrows(IllegalArgumentException.class, () -> kompanija.setAdresa(""));
        assertThrows(IllegalArgumentException.class, () -> kompanija.setGranaPrivrede(""));
    }
    
}
