import model.StudentResult;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Marc Ledermann
 * <m.ledermann@st.hanze.nl>
 * Purpose of the program:
 * Tests the class StudentResult
 **/
public class TestStudentResults {
    private StudentResult studentResult = new StudentResult();

    @Test
    void studentTakesManyClasses() {
        //Arrange
        studentResult.readFile("src/main/resources/studentresults.txt");

        //Act


        //Assert
    }
}
