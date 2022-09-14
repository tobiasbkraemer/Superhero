import java.util.ArrayList;

public class Database {
    private ArrayList<helteinfo> superhelte = new ArrayList<>();

    public void createTestData() {
        createHelt("Hulk", "Bruce Banner", "Styrke stiger med vrede", true, 1982, 198);
        createHelt("Thor", "Thor Odinson", "Torden", false, 452, 201);
        createHelt("Iron Man", "Tony Stark", "Klog og rig", true, 1984, 37);
    }

    public void createHelt(String kaldeNavn, String rigtigNavn, String superkræfter, boolean menneske, int skabelsesår, double styrkeniveau) {
        helteinfo hero = new helteinfo(kaldeNavn, rigtigNavn, superkræfter, menneske, skabelsesår, styrkeniveau);
        superhelte.add(hero);

    }

    public ArrayList<helteinfo> getSuperhelte() {
        return superhelte;
    }

    public helteinfo searchFor(String searchTerm) {
        for (helteinfo helt : superhelte) {
            if (searchTerm.contains(helt.getKaldeNavn())) {
                return helt;
            }
            if (searchTerm.equalsIgnoreCase(helt.getKaldeNavn())) {
                return helt;
            }
        }
        return null;
    }
}

