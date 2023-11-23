import model.Vakken;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


/**
 * @author Marc Ledermann
 * <m.ledermann@st.hanze.nl>
 * Purpose of the program:
 * Tests the class Vakken
 **/
public class TestVakken {
    Vakken vakken = new Vakken();

    @Test
    void testForVakCS101() {
        //Arrange
        vakken.readFile("src/main/resources/vakcodes.txt");
        //Act
        int result = vakken.getOneVak("CS101");
        //Assert
        assertEquals(6, result);
    }

    @Test
    void testWithFakeVak() {
        //Arrange
        vakken.readFile("src/main/resources/vakcodes.txt");
        //Act
        boolean containsVak = vakken.containsVak("CS999");
        //Assert
        assertFalse(containsVak);
    }

    @Test
    void testIfVakHasMoreEctPointsThan() {
        //arrange
        vakken.readFile("src/main/resources/vakcodes.txt");
        int ectPointThreshold = 10;
        //Act
        boolean higherThan = false;
        for (Integer ectPoint : vakken.getAllECTPoints()) {
            if (ectPoint > ectPointThreshold) {
                higherThan = true;
            }
        }
        //Assert
        assertTrue(higherThan);
    }
}
