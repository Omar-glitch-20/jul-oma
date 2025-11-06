public class Autobus {
    private String name;
    private int plaetze;
    private int eigengewicht;
    private int gesamtgewicht;
    private int besetzteplaetze;
    private Person[] autobusplaetze;
    public Autobus(String name, int plaetze, int eigengewicht){
        this.setname(name);
        this.setplaetze(plaetze);
        this.seteigengewicht(eigengewicht);
    }
    public void setname(String name){
        if (name.length() > 35 || name.length() < 3) throw new IllegalArgumentException("String muss zwischen 35 und 3 Charaktere lang sein!");
        this.name = name;
    }
    public void setplaetze(int plaetze){
        if (plaetze > 100 || plaetze< 7 ) throw new IllegalArgumentException("Int muss zwischen 100 und 7 sein!");
        this.plaetze = plaetze;
        this.autobusplaetze = new Person[plaetze];
    }
    public void seteigengewicht(int eigengewicht){
        if (eigengewicht > 6000 || eigengewicht < 1000) throw new IllegalArgumentException ("Int muss zwischen 1000 und 6000 sein!");
        this.eigengewicht = eigengewicht;
    }
    public int getplaetze(){
        return this.plaetze;
    }
    public String getname(){
        return this.name;
    }
    public int geteigengewicht(){
        return this.eigengewicht;
    }
    public int getgesamtgewicht(){
        for (Person person : autobusplaetze){
            if (person != null)gesamtgewicht += person.getGewicht();
        }
        return this.gesamtgewicht + geteigengewicht();
    }
    public int getbesetzteplaetze(){
        for (Person person : autobusplaetze){
            if (person != null) besetzteplaetze += 1;
        }
        return this.besetzteplaetze;
    }
    public void einsteigen(Person person){
        if (person == null) throw new IllegalArgumentException("person darf nicht null sein!");
        for (int i = 0; i < plaetze -1; i++){
            if (autobusplaetze[i] == person){
                throw new IllegalStateException("person sitzt schon im Bus!");
            }
            if (autobusplaetze[i] == null){
                autobusplaetze[i] = person;
                return;
            }
            throw new IllegalStateException("Bus ist schon voll!");
            }
        }
    public void aussteigen(Person person){
        if (person == null) throw new IllegalArgumentException("person darf nicht null sein!");
        for (int i = 0; i< plaetze -1; i++){
            if (autobusplaetze[i] == person){ 
                autobusplaetze[i] = null;
                return;
            }
            throw new IllegalStateException("Person sitzt nicht im Bus!");
        }
    }
    public String BusInfo(Autobus autobus){
        String ausgabe = "";
        ausgabe += "\n Name vom Bus: " + getname();
        ausgabe += "\n Anzahl plätze: " + getplaetze();
        ausgabe += "\n Eigengewicht: " + geteigengewicht();
        ausgabe += "\n Gesamtgewicht: " + getgesamtgewicht();
        ausgabe += "\n Besetzte Plätze: " + getbesetzteplaetze();
        return ausgabe;
    }
}