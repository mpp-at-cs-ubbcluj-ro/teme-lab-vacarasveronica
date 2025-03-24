

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ComputerRepairRequestTest {
    @Test
    @DisplayName("Test Adunare")
    public void testAddition() {
        int rezultat =2+3;
        assertEquals(5, rezultat, "Adunarea trebuie sa returneze 5!");
    }

    @Test
    @DisplayName("Test Scadere")
    public void testSubtraction() {
        int rezultat = 10-5;
        assertEquals(5, rezultat, "Scaderea trebuie sa returneze 5!");
    }
}
