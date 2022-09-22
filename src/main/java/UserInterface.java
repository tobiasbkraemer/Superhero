import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {

    Scanner keyboard = new Scanner(System.in);
    Database database = new Database();

    public void startProgram() {
        
        boolean writingError;
        do {
            do {
                menu();

                try {
                    int menu = keyboard.nextInt();
                    keyboard.nextLine();

                    if (menu == 1) {
                        createHero();
                    } else if (menu == 2) {
                        searchHero();
                    } else if (menu == 3) {
                        readHero();
                    } else if (menu == 4) {
                        updateHero();
                    } else if (menu == 5) {
                        deleteHero();
                    } else if (menu == 9) {
                        endProgram();
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

    public void menu() {

        System.out.println("MENU" + "\n" + "-".repeat(21) + "\n"
                + "1. Opret en superhelt" + "\n"
                + "2. Søg efter superhelt" + "\n"
                + "3. Superhelteliste " + "\n"
                + "4. Rediger superhelt " + "\n"
                + "5. Slet superhelt" + "\n"
                + "9. Luk programmet");

    }

    public void createHero() {


        boolean writingError;

        System.out.println(".: OPRET EN SUPERHELT :.");
        System.out.println("-".repeat(24));

        System.out.println("Hvad bliver superhelten kaldt? (Eks. \"Captain America\")");
        String heroName = keyboard.nextLine();

        System.out.println("Hvad er superheltens rigtige navn? (Eks. \"Steve Rogers\")");
        String realName = keyboard.nextLine();

        System.out.println("Hvilke superheltekræfter har din superhelt? (Eks. \"Lederskab og styrke\")");
        String powers = keyboard.nextLine();

        System.out.println("Er din superhelt et menneske? j/n");
        String svar = keyboard.nextLine();
        while (!svar.equals("j") && !svar.equals("n")) {
            System.out.println("Fejl. Tast \"j\" eller \"n\". ");
            svar = keyboard.nextLine();
        }
        boolean human;
        if (svar.equals("j")) {
            human = true;
        } else {
            human = false;
        }


        System.out.println("Hvornår fik din superhelt sine kræfter?");
        int creationYear = 0;
        do {
            try {
                creationYear = keyboard.nextInt();
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
        double powerlevel = 0;
        do {
            try {
                powerlevel = keyboard.nextDouble();
                keyboard.nextLine();
                writingError = false;
            } catch (InputMismatchException nfe) {
                System.out.println("Fejl opstået");
                System.out.println("Indtast styrkeniveau i tal");
                keyboard.nextLine();
                writingError = true;
            }
        } while (writingError == true);

        database.createHelt(heroName, realName, powers, human, creationYear, powerlevel);

        System.out.println("\n" + "Indberettede superhelte:" + "\n" + "-".repeat(24));
        for (Superhero hero : database.getAllSuperheroes())
            System.out.println(hero);
    }

    public void searchHero() {

        System.out.println("Indtast superheltenavn:");
        String search = keyboard.nextLine();
        ArrayList<Superhero> searchResult = database.searchForHero(search);
        if (searchResult.isEmpty()) {
            System.out.println("Ingen helte fundet");
        } else {
            System.out.println("Helte fundet: ");
            for (Superhero hero : searchResult) {
                System.out.println("-".repeat(24));
                System.out.println("Superheltenavn: " + hero.getHeroName());
                System.out.println("Rigtige navn: " + hero.getRealName());
                System.out.println("Superkræfter: " + hero.getSuperpowers());
                System.out.println("Menneske: " + hero.getHuman());
                System.out.println("Skabelsesår: " + hero.getCreationYear());
                System.out.println("Styrkeniveau: " + hero.getPowerlevel() + "\n");
            }
        }
    }

    public void readHero() {
        System.out.println("Liste over helte: " + "\n"+"-".repeat(21));
        System.out.println(database.getAllSuperheroes());

    }

    public void updateHero() {

        boolean writingError;
        {
            System.out.println("Superheroes");
            for (int i = 0; i < database.getAllSuperheroes().size(); i++) {
                System.out.println(i + 1 + ": " + database.getAllSuperheroes().get(i));
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

            Superhero updateHero = database.getAllSuperheroes().get(number - 1);
            System.out.println("Redigere superhelt information: " + updateHero);

            System.out.println("Indskriv ny data. Vil du ikke ændre noget, så tryk Enter.");
            System.out.println("Kaldenavn: " + updateHero.getHeroName());
            String newHeroName = keyboard.nextLine();
            keyboard.nextLine();
            if (!newHeroName.isEmpty())
                updateHero.setHeroName(newHeroName);

            System.out.println("Rigtige navn: " + updateHero.getRealName());
            String newRealName = keyboard.nextLine();
            if (!newRealName.isEmpty())
                updateHero.setRealName(newRealName);

            System.out.println("Superkræft: " + updateHero.getSuperpowers());
            String newPowers = keyboard.nextLine();
            if (!newPowers.isEmpty())
                updateHero.setSuperpowers(newPowers);

            System.out.println("Menneske: " + updateHero.getHuman());
            String newHuman = keyboard.nextLine();

            if (!newHuman.isEmpty()) {
                while (!newHuman.equals("j") && !newHuman.equals("n")) {
                    System.out.println("Fejl. Tast \"j\" eller \"n\". ");
                    newHuman = keyboard.nextLine();
                }

                boolean menneske;
                if (newHuman.equals("j")) {
                    menneske = true;
                } else {
                    menneske = false;
                }
                updateHero.setHuman(menneske);
            }

            System.out.println("Skabelsesår: " + updateHero.getCreationYear());
            do {
                String newCreationYear = keyboard.nextLine();
                if (!newCreationYear.isEmpty()) {
                    try {
                        updateHero.setCreationYear(Integer.parseInt(newCreationYear));
                        writingError = false;

                    } catch (NumberFormatException nfe) {
                        System.out.println("Fejl opstået");
                        System.out.println("Indtast skabelsesår i tal");
                        writingError = true;
                    }
                }
            } while (writingError == true);

            System.out.println("Styrkeniveau: " + updateHero.getPowerlevel());
            do {
                String newPowerlevel = keyboard.nextLine();
                if (!newPowerlevel.isEmpty()) {
                    try {
                        updateHero.setPowerlevel(Double.parseDouble(newPowerlevel));
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

    public void deleteHero() {

        System.out.println("------------------------------------");
        System.out.println("Søg efter helte: ");
        String searchTerm = keyboard.nextLine();

        ArrayList<Superhero> searchResults = database.searchForHero(searchTerm);

        if (searchResults.isEmpty()) {
            System.out.println("Ingen helte fundet");
        } else {
            int index = 1;
            for (Superhero searchResult : searchResults) {
                System.out.println(index++ + ": " + searchResult.getHeroName());
            }

            System.out.println("Vælg en superhelt, som du vil slette: ");
            int hero;
            boolean writingError;
            do {
                try {
                    hero = Integer.parseInt(keyboard.nextLine());
                    Superhero deleteSuperhero = searchResults.get(hero - 1);

                    database.deleteSuperhero(deleteSuperhero);
                    System.out.println(deleteSuperhero.getHeroName() + " er slettet fra databasen");
                    writingError = false;

                } catch (NumberFormatException e) {
                    System.out.println("Fejl. Indtast tallet på superhelten, som du vil slette.");
                    writingError = true;
                }
            } while (writingError);
        }
    }

    public void endProgram() {

        System.out.println("Lukker programmet...");
        System.exit(9);

    }
}