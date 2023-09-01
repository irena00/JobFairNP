package transferUtil;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ResponseStatusTest {

    @Test
    public void testEnumValues() {
        // Check if the enum values are as expected
        assertEquals("Success", ResponseStatus.Success.name());
        assertEquals("Error", ResponseStatus.Error.name());
    }
}