import java.util.Scanner;

public class UserInterface {

    Scanner keyboard = new Scanner(System.in);
    Database database = new Database();

    public void startProgram() {

        database.createTestData();

        do {
            startside();

            int menu = keyboard.nextInt();
            if (menu == 1) {
                opretEnHelt1();
            }
            else if (menu == 3) {
                søgEfterHelt3();
            }
            else if (menu==5) {
                listeOverhelte5();
            }
            else if (menu==9) {
                lukProgrammet9();
            }

        } while (true);


    }
    public void startside () {

        System.out.println("MENU" + "\n" + "-".repeat(21) + "\n" + "1. Opret en superhelt" + "\n"
                    + "(...)" + "\n" + "3. Søg efter superhelt" + "\n"
                    + "(...)" + "\n" + "5. Superhelteliste " + "\n"
                    + "(...)" + "\n" + "9. Luk programmet");

    }
    public void opretEnHelt1 () {

                keyboard.nextLine();
                System.out.println(".: OPRET EN SUPERHELT :.");
                System.out.println("-".repeat(24));
                System.out.println("Hvad bliver din superhelt kaldt?");
                String kaldeNavn = keyboard.nextLine();
                System.out.println("Hvad hedder din superhelt rigtigt?");
                String rigtigNavn = keyboard.nextLine();
                System.out.println("Hvad kan din superhelt?");
                String superkræfter = keyboard.nextLine();
                System.out.println("Er din superhelt et menneske? j/n");
                String svar = keyboard.nextLine();

                boolean menneske = true;
                if (svar.equals("j")) {
                    menneske = true;
                } else if (svar.equals("n")) {
                    menneske = false;
                }

                System.out.println("Hvornår fik din superhelt sine kræfter?");
                int skabelsesår = keyboard.nextInt();
                System.out.println("Hvad er din superhelts styrkeniveau?");
                double styrkeniveau = keyboard.nextDouble();
                database.createHelt(kaldeNavn, rigtigNavn, superkræfter, menneske, skabelsesår, styrkeniveau);

                System.out.println("\n" + "Indberettede superhelte:" + "\n" + "-".repeat(24));
                for (helteinfo helt : database.getSuperhelte())
                    System.out.println(helt);
    }
    public void søgEfterHelt3 () {

        keyboard.nextLine();
        System.out.println("Indtast superheltenavn:");
        String search = keyboard.nextLine();
        helteinfo søgtesuperhelt = database.searchFor(search);
        System.out.println(søgtesuperhelt);

    }
    public void listeOverhelte5 () {
        System.out.println("Liste over helte: " + "\n");
        System.out.println(database.getSuperhelte());

    }
    public void lukProgrammet9 () {

        System.out.println("Lukker programmet...");
        System.exit(9);

    }
}


