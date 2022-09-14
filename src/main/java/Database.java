import java.util.ArrayList;

public class Database {

    private ArrayList<helteinfo> superhelte = new ArrayList<>();

    public void createHelt(String kaldeNavn, String rigtigNavn, String superkræfter, boolean menneske, int skabelsesår, double styrkeniveau) {
        helteinfo hero = new helteinfo(kaldeNavn, rigtigNavn, superkræfter, menneske, skabelsesår, styrkeniveau);
        superhelte.add(hero);

        System.out.println("\n"+"Indberettede superhelte:"+"\n"+"-".repeat(24));
        for(helteinfo helt : superhelte) {
            System.out.println(helt);

        }

    }
    public ArrayList<helteinfo> getSuperhelte() {
        return superhelte;
    }
}

