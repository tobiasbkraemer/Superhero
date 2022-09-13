import java.util.Scanner;

public class superhero1 {
    public static void main(String[]args){

        Database database = new Database();
        Scanner keyboard = new Scanner(System.in);

        /*for (helteinfo helt : database.getHelteinfos()) {
            System.out.println(helt.getKaldeNavn()+"\n"+helt.getRigtigNavn()+"\n"+ helt.getSuperkræfter()+"\n"+ helt.getMenneske()+"\n"+ helt.getSkabelsesår()+"\n"+ helt.getStyrkeniveau());
        }*/

        System.out.println("MENU"+"\n"+"1. Opret en superhelt"+ "\n"+"9. Luk programmet");
        int menu = keyboard.nextInt();
        keyboard.nextLine();



        do {
            if (menu == 1) {
                int count = 1;
                System.out.println("Opret en superhelt (" + count + ")");
                count++;
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
                database.createHelt(kaldeNavn, rigtigNavn, superkræfter, menneske, skabelsesår, styrkeniveau, index);

            }
            while (menu ==9) ;

            if (menu == 9) {
                System.out.println("Lukker programmet...");
            }

        }while (menu !=9);

        /*helteinfo hero2 = 1new helteinfo(kaldeNavn,rigtigNavn,superkræfter,menneske,skabelsesår,styrkeniveau);
        System.out.println("Her er din superhelts informationer: "+"\n"+kaldeNavn+"\n"+rigtigNavn+"\n"+superkræfter+"\n"+menneske+"\n"+skabelsesår+"\n"+styrkeniveau);*/



    }

}
