import java.util.Scanner;

public class superhero1 {
    public static void main(String[] args) {

        Database database = new Database();
        Scanner keyboard = new Scanner(System.in);
        database.createTestData();



        do {
            System.out.println("MENU"+"\n"+"-".repeat(21)+"\n" + "1. Opret en superhelt" +"\n"
                    +"(...)"+ "\n"+"3. Søg efter superhelt" +"\n"
                    +"(...)"+ "\n"+"5. Superhelteliste "+"\n"
                    +"(...)"+ "\n" + "9. Luk programmet");
            int menu = keyboard.nextInt();
            keyboard.nextLine();

            if (menu == 1) {
                keyboard.nextLine();
                System.out.println(".: OPRET EN SUPERHELT :.");
                System.out.println("-".repeat(24));
                System.out.println("Hvad bliver din superhelt kaldt?");
                String kaldeNavn = keyboard.nextLine();
                System.out.println("Hvad hedder din superhelt rigtigt?");
                String rigtigNavn = keyboard.nextLine();
                System.out.println("Hvad kan din superhelt?");
                String superkræfter = keyboard.nextLine();
                System.out.println("Er din superhelt et menneske? Ja eller Nej");
                String svar = keyboard.nextLine();

                boolean menneske=true;
                if (svar.equals("Ja")) {
                    menneske=true;
                } else if(svar.equals("Nej")) {
                    menneske=false;
                }

                System.out.println("Hvornår fik din superhelt sine kræfter?");
                int skabelsesår = keyboard.nextInt();
                System.out.println("Hvad er din superhelts styrkeniveau?");
                double styrkeniveau = keyboard.nextDouble();
                database.createHelt(kaldeNavn, rigtigNavn, superkræfter, menneske, skabelsesår, styrkeniveau);

                System.out.println("\n"+"Indberettede superhelte:"+"\n"+"-".repeat(24));
                for(helteinfo helt : database.getSuperhelte())
                    System.out.println(helt);

            } else if (menu == 9) {
                System.out.println("Lukker programmet...");
                System.exit(9);
            } else if (menu == 5) {
                System.out.println("Liste over helte: "+"\n");
                System.out.println(database.getSuperhelte());

            } else if (menu ==3) {
                System.out.println("Indtast superheltenavn:");
                String search = keyboard.nextLine();
                helteinfo søgtesuperhelt = database.searchFor(search);
                System.out.println(søgtesuperhelt);

            }


        }while(true);

    }
}
