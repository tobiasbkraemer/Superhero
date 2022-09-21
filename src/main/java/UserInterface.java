import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {

    Scanner keyboard = new Scanner(System.in);
    Database database = new Database();

    public void startProgram() {

        database.createTestData();
        boolean writingError;
        do {
            do {
                startside();

                try {
                    int menu = keyboard.nextInt();
                    keyboard.nextLine();

                    if (menu == 1) {
                        opretEnHelt();
                    } else if (menu == 3) {
                        søgEfterHelt();
                    } else if (menu == 5) {
                        listeOverhelte();
                    } else if (menu == 7) {
                        redigerHelte();
                    } else if (menu == 9) {
                        lukProgrammet();
                    }
                    writingError = false;
                } catch (InputMismatchException ime) {
                    System.out.println("Fejl opstået");
                    System.out.println("Indtast MENU i tal");
                    keyboard.nextLine();
                    writingError = true;
                }

            } while (writingError == true);
        } while (true);
    }

    public void startside() {

        System.out.println("MENU" + "\n" + "-".repeat(21) + "\n" + "1. Opret en superhelt" + "\n"
                + "(...)" + "\n" + "3. Søg efter superhelt" + "\n"
                + "(...)" + "\n" + "5. Superhelteliste " + "\n"
                + "(...)" + "\n" + "7. Rediger superhelt " + "\n"
                + "(...)" + "\n" + "9. Luk programmet");

    }

    public void opretEnHelt() {


        boolean writingError;

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
        while (!svar.equals("j") && !svar.equals("n")) {
            System.out.println("Fejl. Tast \"j\" eller \"n\". ");
            svar = keyboard.nextLine();
        }
        boolean menneske;
        if (svar.equals("j")) {
            menneske = true;
        } else {
            menneske = false;
        }


        System.out.println("Hvornår fik din superhelt sine kræfter?");
        int skabelsesår = 0;
        do {
            try {
                skabelsesår = keyboard.nextInt();
                keyboard.nextLine();
                writingError = false;

            } catch (InputMismatchException nfe) {
                System.out.println("Fejl opstået");
                System.out.println("Indtast skabelsesår i tal");
                keyboard.nextLine();
                writingError = true;
            }
        } while (writingError == true);

        System.out.println("Hvad er din superhelts styrkeniveau?");
        double styrkeniveau = 0;
        do {
            try {
                styrkeniveau = keyboard.nextDouble();
                keyboard.nextLine();
                writingError = false;
            } catch (InputMismatchException nfe) {
                System.out.println("Fejl opstået");
                System.out.println("Indtast styrkeniveau i tal");
                keyboard.nextLine();
                writingError = true;
            }
        } while (writingError == true);

        database.createHelt(kaldeNavn, rigtigNavn, superkræfter, menneske, skabelsesår, styrkeniveau);

        System.out.println("\n" + "Indberettede superhelte:" + "\n" + "-".repeat(24));
        for (helteinfo helt : database.getSuperhelte())
            System.out.println(helt);
    }

    public void søgEfterHelt() {

        System.out.println("Indtast superheltenavn:");
        String search = keyboard.nextLine();
        ArrayList<helteinfo> searchResult = database.searchFor(search);
        if (searchResult.isEmpty()) {
            System.out.println("Ingen helte fundet");
        } else {
            System.out.println("Helte fundet: ");
            for (helteinfo helt : searchResult) {
                System.out.println("-".repeat(24));
                System.out.println("Superheltenavn: " + helt.getKaldeNavn());
                System.out.println("Rigtige navn: " + helt.getRigtigNavn());
                System.out.println("Superkræfter: " + helt.getSuperkræfter());
                System.out.println("Menneske: " + helt.getMenneske());
                System.out.println("Skabelsesår: " + helt.getSkabelsesår());
                System.out.println("Styrkeniveau: " + helt.getStyrkeniveau() + "\n");
            }
        }
    }

    public void listeOverhelte() {
        System.out.println("Liste over helte: " + "\n");
        System.out.println(database.getSuperhelte());

    }

    public void redigerHelte() {

        boolean writingError;
        {
            System.out.println("Superheroes");
            for (int i = 0; i < database.getSuperhelte().size(); i++) {
                System.out.println(i + 1 + ": " + database.getSuperhelte().get(i));
            }

            System.out.print("Indtast nummer for superhelt: ");
            int number = 0;
            do {
                try {
                    number = keyboard.nextInt();
                    writingError = false;

                } catch (InputMismatchException nfe) {
                    System.out.println("Fejl opstået");
                    System.out.println("Indtast nummeret i tal");
                    keyboard.nextLine();
                    writingError = true;
                }
            } while (writingError == true);

            helteinfo edithelt = database.getSuperhelte().get(number - 1);
            System.out.println("Redigere superhelt information: " + edithelt);

            System.out.println("Indskriv ny data. Vil du ikke ændre noget, så tryk Enter.");
            System.out.println("Kaldenavn: " + edithelt.getKaldeNavn());
            String newNavn = keyboard.nextLine();
            if (!newNavn.isEmpty())
                edithelt.setKaldeNavn(newNavn);

            System.out.println("Rigtige navn: " + edithelt.getRigtigNavn());
            String newAlias = keyboard.nextLine();
            if (!newAlias.isEmpty())
                edithelt.setRigtigeNavn(newAlias);

            System.out.println("Superkræft: " + edithelt.getSuperkræfter());
            String newSuperkræft = keyboard.nextLine();
            if (!newSuperkræft.isEmpty())
                edithelt.setSuperkræfter(newSuperkræft);

            System.out.println("Menneske: " + edithelt.getMenneske());
            String newMenneske = keyboard.nextLine();

            if (!newMenneske.isEmpty()) {
                while (!newMenneske.equals("j") && !newMenneske.equals("n")) {
                    System.out.println("Fejl. Tast \"j\" eller \"n\". ");
                    newMenneske = keyboard.nextLine();
                }

                boolean menneske;
                if (newMenneske.equals("j")) {
                    menneske = true;
                } else {
                    menneske = false;
                }
                edithelt.setMenneske(menneske);
            }

            System.out.println("Skabelsesår: " + edithelt.getSkabelsesår());
            do {
                String newSkabelsesår = keyboard.nextLine();
                if (!newSkabelsesår.isEmpty()) {
                    try {
                        edithelt.setSkabelsesår(Integer.parseInt(newSkabelsesår));
                        writingError = false;

                    } catch (NumberFormatException nfe) {
                        System.out.println("Fejl opstået");
                        System.out.println("Indtast skabelsesår i tal");
                        writingError = true;
                    }
                }
            } while (writingError == true);

            System.out.println("Styrkeniveau: " + edithelt.getStyrkeniveau());
            do {
                String newstyrkeniveau = keyboard.nextLine();
                if (!newstyrkeniveau.isEmpty()) {
                    try {
                        edithelt.setStyrkeniveau(Double.parseDouble(newstyrkeniveau));
                        writingError = false;
                    } catch (NumberFormatException nfe) {
                        System.out.println("Fejl opstået");
                        System.out.println("Indtast styrkeniveau i tal");
                        writingError = true;
                    }
                }
            } while (writingError == true);

        }
    }

    public void lukProgrammet() {

        System.out.println("Lukker programmet...");
        System.exit(9);

    }
}