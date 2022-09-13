import java.util.Scanner;

public class superhero1 {
    public static void main(String[] args) {

        Database database = new Database();
        Scanner keyboard = new Scanner(System.in);


        do {
            System.out.println("MENU"+"\n"+"-".repeat(21)+"\n" + "1. Opret en superhelt" + "\n" + "9. Luk programmet");
            int menu = keyboard.nextInt();

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
                System.out.println("Er din superhelt et menneske? true or false");
                boolean menneske = keyboard.nextBoolean();
                System.out.println("Hvornår fik din superhelt sine kræfter?");
                int skabelsesår = keyboard.nextInt();
                System.out.println("Hvad er din superhelts styrkeniveau?");
                double styrkeniveau = keyboard.nextDouble();
                database.createHelt(kaldeNavn, rigtigNavn, superkræfter, menneske, skabelsesår, styrkeniveau);

            } else if (menu == 9) {
                System.out.println("Lukker programmet...");
            }

        }while(true);

    }
}
