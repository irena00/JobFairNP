package domen;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Test;

class AdministratorTest {

	private Administrator admin;

    @BeforeEach
    public void setUp() throws Exception {
        admin = new Administrator(1L, "john", "doe", "johndoe", "password123");
    }

    @AfterEach
    public void tearDown() {
        admin = null;
    }

    @Test
    public void testGetAdministratorID() {
        assertEquals(1L, admin.getAdministratorID());
    }

    @Test
    public void testSetAdministratorID() {
        admin.setAdministratorID(2L);
        assertEquals(2L, admin.getAdministratorID());
    }

    @Test
    public void testGetUsername() {
        assertEquals("johndoe", admin.getUsername());
    }

    @Test
    public void testSetUsername() {
        admin.setUsername("jane");
        assertEquals("jane", admin.getUsername());
    }

    @Test
    public void testSetUsernameWithNullUsername() {
        assertThrows(NullPointerException.class, () -> admin.setUsername(null));
    }

    @Test
    public void testSetUsernameWithBlankUsername() {
        assertThrows(IllegalArgumentException.class, () -> admin.setUsername(""));
    }

    @Test
    public void testGetPassword() {
        assertEquals("password123", admin.getPassword());
    }

    @Test
    public void testSetPassword() {
        admin.setPassword("newPassword");
        assertEquals("newPassword", admin.getPassword());
    }

    @Test
    public void testSetPasswordWithNullPassword() {
        assertThrows(NullPointerException.class, () -> admin.setPassword(null));
    }

    @Test
    public void testSetPasswordWithBlankPassword() {
        assertThrows(IllegalArgumentException.class, () -> admin.setPassword(""));
    }

    @Test
    public void testGetIme() {
        assertEquals("john", admin.getIme());
    }

    @Test
    public void testSetIme() {
        admin.setIme("jane");
        assertEquals("jane", admin.getIme());
    }

    @Test
    public void testGetPrezime() {
        assertEquals("doe", admin.getPrezime());
    }

    @Test
    public void testSetPrezime() {
        admin.setPrezime("smith");
        assertEquals("smith", admin.getPrezime());
    }

    @Test
    public void testToString() {
        String s = admin.toString();
        assertTrue(s.contains("john"));
        assertTrue(s.contains("doe"));
        assertTrue(s.contains("1"));
        assertTrue(s.contains("johndoe"));
        assertTrue(s.contains("password123"));
    }

    // Add more tests based on your specific requirements
}

