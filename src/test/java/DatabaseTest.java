import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {

    private Database database;

    @BeforeEach
    void prepareTest() {
        database = new Database();
        database.createHelt("Hulk", "Bruce Banner", "Styrke stiger med vrede", true, 1982, 198);
        database.createHelt("Thor", "Thor Odinson", "Torden", false, 452, 201);
        database.createHelt("Iron Man", "Tony Stark", "Klog og rig", true, 1984, 37);
        database.createHelt("Spider-man", "Peter Parker","Edderkoppeevner", true, 2000, 195);
    }

    @Test
    void createHelt() {
        //Arrange
        Database database = new Database();

        //Act
        database.createHelt("Bobamok", "Bob Andersen", "Kan svæve", true, 1988, 3.7);
        java.util.ArrayList<Superhero> results = database.getAllSuperheroes();

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
        List<Superhero> results = database.searchForHero("Iron Man");

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
        List<Superhero> results = database.searchForHero("Captain America");

        int actualSize = results.size();
        int expectedSize = 0;

        //Assert
        assertEquals(actualSize, expectedSize);
    }

    @Test
    void sletSuperhelt () {
        java.util.ArrayList<Superhero> results = database.getAllSuperheroes();
        Superhero superhero = results.get(0);
        boolean actualResult = database.deleteSuperhero (superhero);
        boolean expectedResult = true;
        assertEquals(actualResult, expectedResult);

        int expectedSize = results.size() - 1;
        ArrayList<Superhero> resultsAfterDelete = database.getAllSuperheroes();
        int actualSize = resultsAfterDelete.size();

        assertEquals(actualSize, expectedSize);

    }
}