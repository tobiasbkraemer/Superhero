public class Database {

    private helteinfo[] listen = new helteinfo[5];
    private int index = 0;

    public void createHelt(String kaldeNavn, String rigtigNavn, String superkræfter, boolean menneske, int skabelsesår, double styrkeniveau) {
        helteinfo hero = new helteinfo(kaldeNavn, rigtigNavn, superkræfter, menneske, skabelsesår, styrkeniveau);
        System.out.println(hero);
        listen[index] = hero;
        index++;
    }

}

