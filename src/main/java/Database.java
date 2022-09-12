public class Database {
    helteinfo[] helteinfos;


    public Database(){

        helteinfo hero1 = new helteinfo("Bobamok","Bob","Svæve",true,1992,13);
        helteinfos = new helteinfo[]{hero1};
    }

    public helteinfo[] getHelteinfos() {
        return helteinfos;
    }
}

