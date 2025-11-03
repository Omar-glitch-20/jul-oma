public class Person {
    private String name;
    private int gewicht;

    public Person(String name, int gewicht) {
        if (name == null || name == "") {
            throw new IllegalArgumentException("Name darf nicht leer sein!");
        }
        if (gewicht < 20 || gewicht > 300) {
            throw new IllegalArgumentException("Gewicht muss zwischen 20 und 300 kg liegen!");
        }
        this.name = name;
        this.gewicht = gewicht;
    }

    public String getName() {
        return name;
    }

    public int getGewicht() {
        return gewicht;
    }

    public void print() {
        System.out.println(name + " (" + gewicht + " kg)");
    }
}
