package KrydsordsGenerator;

public class Tid {

    //Lav tid-variabel
    long startTid;

    public Tid()
    {
        //overvej starttid her.
    }
    //Metode til at starte tid
    public void startTid()
    {
        startTid = System.nanoTime();

    }
    //Metode til at slutte og udskrive eksekveringstid i sekunder.
    public void slutTid()
    {
        long slutTid = (System.nanoTime() - startTid);
        System.out.println("Eksekveringen tog: " + slutTid/1000000000 + " sekunder");
    }
}
