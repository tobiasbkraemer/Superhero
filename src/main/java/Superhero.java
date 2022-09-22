public class Superhero {
    private String heroName;
    private String realName;
    private String superpowers;
    private boolean human;
    private int creationYear;
    private double powerlevel;

    public Superhero(String heroName, String realName, String superpowers, boolean human, int creationYear, double powerlevel) {
        this.heroName = heroName;
        this.realName = realName;
        this.superpowers = superpowers;
        this.human = human;
        this.creationYear = creationYear;
        this.powerlevel = powerlevel;
    }

    public String getHeroName() {
        return heroName;
    }

    public String getRealName() {
        return realName;
    }

    public String getSuperpowers() {
        return superpowers;
    }

    public boolean getHuman() {
        return human;
    }

    public int getCreationYear() {
        return creationYear;
    }

    public double getPowerlevel() {
        return powerlevel;
    }

    @Override
    public String toString() {
        return "\n"+"Superheltenavn: "+ heroName +
                "\n" +"Oprindelige identitet: "+ realName +
                "\n"+"Superkræfter: "+ superpowers +
                "\n"+"Menneskestatus: "+ human +
                "\n"+"Skabelsesår: "+ creationYear +
                "\n"+"Styrkeniveau: "+ powerlevel +"\n";
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public void setRealName(String rigtigNavn) {
        this.realName = rigtigNavn;
    }

    public void setSuperpowers(String superpowers){
        this.superpowers = superpowers;
    }

    public void setHuman(boolean human){
        this.human = human;
    }

    public void setCreationYear(int creationYear){
        this.creationYear = creationYear;
    }

    public void setPowerlevel(double powerlevel) {
        this.powerlevel = powerlevel;
    }

}
