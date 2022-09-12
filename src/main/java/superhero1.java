import java.util.Scanner;

public class superhero1 {
    public static void main(String[]args){
        helteinfo hero1 = new helteinfo("Bobamok","Bob","Svæve",true,1992,13);

        Scanner keyboard = new Scanner(System.in);
        System.out.println(hero1.getKaldeNavn()+"\n"+hero1.getRigtigNavn()+"\n"+hero1.getSuperkræfter()+"\n"+hero1.getMenneske()+"\n"+hero1.getSkabelsesår()+"\n"+hero1.getStyrkeniveau());

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

        helteinfo hero2 = new helteinfo(kaldeNavn,rigtigNavn,superkræfter,menneske,skabelsesår,styrkeniveau);

        System.out.println("Her er din superhelts informationer: "+"\n"+kaldeNavn+"\n"+rigtigNavn+"\n"+superkræfter+"\n"+menneske+"\n"+skabelsesår+"\n"+styrkeniveau);

        Database database = new Database();
        for (helteinfo helt : database.getHelteinfos()) {
            System.out.println(helt.getKaldeNavn()+"\n"+helt.getRigtigNavn()+"\n"+ helt.getSuperkræfter()+"\n"+ helt.getMenneske()+"\n"+ helt.getSkabelsesår()+"\n"+ helt.getStyrkeniveau());
        }



    }

}
