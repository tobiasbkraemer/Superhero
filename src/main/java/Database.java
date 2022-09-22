import java.util.ArrayList;

public class Database {
    private ArrayList<Superhero> superhelte = new ArrayList<>();

    public void createHelt(String kaldeNavn, String rigtigNavn, String superkræfter, boolean menneske, int skabelsesår, double styrkeniveau){
        Superhero hero = new Superhero(kaldeNavn, rigtigNavn, superkræfter, menneske, skabelsesår, styrkeniveau);
        superhelte.add(hero);
    }

    public ArrayList<Superhero> getAllSuperheroes() {
        return superhelte;
    }

    public ArrayList<Superhero> searchForHero(String searchTerm) {

        ArrayList<Superhero> searchResult = new ArrayList<>();

        for (Superhero helt : superhelte) {
            if (helt.getHeroName().toLowerCase().contains(searchTerm.toLowerCase())) {
                searchResult.add(helt);
            }
        }
        return searchResult;
    }

    public boolean deleteSuperhero (Superhero superhero){
        getAllSuperheroes().remove(superhero);
        boolean succes = true;
        return succes;
    }
}

