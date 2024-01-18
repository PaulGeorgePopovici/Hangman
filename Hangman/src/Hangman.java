import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Hangman {

    public static void main(String[] args) {

        ArrayList<String> cuvinte = new ArrayList<>(Arrays.asList("masina" , "programare" , "java" , "academie" , "tastatura"));
        Random generator = new Random();

        Scanner cititor = new Scanner(System.in);
        String cuvant = cuvinte.get(generator.nextInt(cuvinte.size()));
        int vietiRamase = 6;

        char[] litere = cuvant.toCharArray();
        char[] cuvantAfisat = new char[litere.length];
        Arrays.fill(cuvantAfisat, '_');

        afiseazaCuvantul(cuvantAfisat);

        while (true) {
            System.out.println("Introduceti o litera: / VIETI RAMASE: " + vietiRamase);
            char literaIntrodusa = cititor.next().charAt(0);
            boolean cuvantulContineLitera = false;
            for (int i = 0; i < litere.length; i++) {
                if (literaIntrodusa == litere[i]) {
                    cuvantAfisat[i] = literaIntrodusa;
                    cuvantulContineLitera = true;
                }
            }
            if (!cuvantulContineLitera){
                vietiRamase --;
            }
            if (vietiRamase <= 0){
                System.out.println("AI PIERDUT JOCUL!");
                break;
            }
            if (Arrays.equals(litere,cuvantAfisat)){
                System.out.println("AI CASTIGAT!");
                afiseazaCuvantul(cuvantAfisat);
                break;
            }

            afiseazaCuvantul(cuvantAfisat);
        }
    }

    private static void afiseazaCuvantul(char[] cuvantAfisat) {
        for (char c : cuvantAfisat) {
            System.out.print(c + " ");
        }
        System.out.println(" ");
    }
}