import java.util.Scanner;

public class superhero1 {
    public static void main(String[]args){
        helteinfo hero1 = new helteinfo("Bobamok","Bob","Svæve",true,1992,13);

        Scanner keyboard = new Scanner(System.in);
        System.out.println(hero1.getKaldeNavn()+hero1.getRigtigNavn()+hero1.getSuperkræfter()+hero1.getMenneske()+hero1.getSkabelsesår()+hero1.getStyrkeniveau());
        String helteinfo = keyboard.nextLine();
    }



}
