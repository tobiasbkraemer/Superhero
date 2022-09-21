import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {

    private Database database;

    @BeforeEach
    void prepareTest() {
        database = new Database();
        database.createTestData();
    }

    @Test
    void createHelt() {
        //Arrange
        Database database = new Database();

        //Act
        database.createHelt("Bobamok", "Bob Andersen", "Kan svæve", true, 1988, 3.7);
        java.util.ArrayList<helteinfo> results = database.getSuperhelte();

        int actualSize = results.size();
        int expectedSize = 1;

        //Assert
        assertEquals(actualSize, expectedSize);
    }

    @Test
    void seatchForOneResult() {
        //Arrange
        Database database = new Database();

        //Act
        database.createTestData();
        List<helteinfo> results = database.searchFor("Iron Man");

        int actualSize = results.size();
        int expectedSize = 1;

        //Assert
        assertEquals(actualSize, expectedSize);
    }

    @Test
    void searchForNoResults() {
        //Arrange
        Database database = new Database();

        //Act
        database.createTestData();
        List<helteinfo> results = database.searchFor("Captain America");

        int actualSize = results.size();
        int expectedSize = 0;

        //Assert
        assertEquals(actualSize, expectedSize);
    }

    @Test
    void sletSuperhelt () {
        java.util.ArrayList<helteinfo> results = database.getSuperhelte();
        helteinfo superhero = results.get(0);
        boolean actualResult = database.deleteSuperhero (superhero);
        boolean expectedResult = true;
        assertEquals(actualResult, expectedResult);

        int expectedSize = results.size() - 1;
        ArrayList<helteinfo> resultsAfterDelete = database.getSuperhelte();
        int actualSize = resultsAfterDelete.size();

        assertEquals(actualSize, expectedSize);

    }
}