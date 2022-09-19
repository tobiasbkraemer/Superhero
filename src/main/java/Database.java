import java.lang.reflect.Array;
import java.util.ArrayList;

public class Database {
    private ArrayList<helteinfo> superhelte = new ArrayList<>();

    public void createTestData() {
        createHelt("Hulk", "Bruce Banner", "Styrke stiger med vrede", true, 1982, 198);
        createHelt("Thorman", "Thor Odinson", "Torden", false, 452, 201);
        createHelt("Iron Man", "Tony Stark", "Klog og rig", true, 1984, 37);
    }

    public void createHelt(String kaldeNavn, String rigtigNavn, String superkræfter, boolean menneske, int skabelsesår, double styrkeniveau) {
        helteinfo hero = new helteinfo(kaldeNavn, rigtigNavn, superkræfter, menneske, skabelsesår, styrkeniveau);
        superhelte.add(hero);

    }

    public ArrayList<helteinfo> getSuperhelte() {
        return superhelte;
    }

    public ArrayList<helteinfo> searchFor(String searchTerm) {

        ArrayList<helteinfo> searchResult = new ArrayList<>();

        for (helteinfo helt : superhelte) {
            if (helt.getKaldeNavn().toLowerCase().contains(searchTerm.toLowerCase())) {
                searchResult.add(helt);
            }
        }
        return searchResult;
    }
}

