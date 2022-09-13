import java.util.ArrayList;

public class Database {

    ArrayList<helteinfo> superhelte = new ArrayList<>();

    public void createHelt(String kaldeNavn, String rigtigNavn, String superkræfter, boolean menneske, int skabelsesår, double styrkeniveau) {
        helteinfo hero = new helteinfo(kaldeNavn, rigtigNavn, superkræfter, menneske, skabelsesår, styrkeniveau);
        superhelte.add(hero);

        System.out.println("\n"+"Indberettede superhelte:"+"\n"+"-".repeat(24));
        for(helteinfo helt : superhelte) {
            System.out.println(helt);

            /*System.out.println("Superheltenavn: "+helt.getKaldeNavn());
            System.out.println("Oprindelige identitet: "+helt.getRigtigNavn());
            System.out.println("Superkræfter: "+helt.getSuperkræfter());
            System.out.println("Menneskestatus: "+helt.getMenneske());
            System.out.println("Skabelsesår: "+helt.getSkabelsesår());
            System.out.println("Styrkeniveau: "+helt.getStyrkeniveau()+"\n");*/

        }

    }
}

