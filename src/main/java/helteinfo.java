public class helteinfo {
    private String kaldeNavn;
    private String rigtigNavn;
    private String superkræfter;
    private boolean menneske;
    private int skabelsesår;
    private double styrkeniveau;

    public helteinfo(String kaldeNavn, String rigtigNavn, String superkræfter, boolean menneske, int skabelsesår, double styrkeniveau) {
        this.kaldeNavn = kaldeNavn;
        this.rigtigNavn = rigtigNavn;
        this.superkræfter = superkræfter;
        this.menneske = menneske;
        this.skabelsesår = skabelsesår;
        this.styrkeniveau = styrkeniveau;
    }

    public String getKaldeNavn() {
        return kaldeNavn;
    }

    public String getRigtigNavn() {
        return rigtigNavn;
    }

    public String getSuperkræfter() {
        return superkræfter;
    }

    public boolean getMenneske() {
        return menneske;
    }

    public int getSkabelsesår() {
        return skabelsesår;
    }

    public double getStyrkeniveau() {
        return styrkeniveau;
    }

/*
    public void setMenneske(String svar) {
        if (svar.equals("Ja")) {
            this.menneske =true;
        } else if(svar.equals("Nej")) {
            this.menneske=false;
        }
    }
*/

    @Override
    public String toString() {
        return "\n"+"Superheltenavn: "+kaldeNavn + "\n"+"Oprindelige identitet: "+ rigtigNavn+ "\n"+"Superkræfter: "+superkræfter+ "\n"+"Menneskestatus: "+menneske+ "\n"+"Skabelsesår: "+skabelsesår+ "\n"+"Styrkeniveau: "+styrkeniveau+"\n";
    }
}
