package KrydsordsGenerator;

import DBUtil.Queries.selectOrdListeRedigeret;
import UI.Input;

import java.util.*;


public class KrydsordsGeneratorV1 {
    private Set<String> wordList = new TreeSet<>();
    Tid tid;

    public KrydsordsGeneratorV1() {
        tid = new Tid();

        wordList.addAll(new selectOrdListeRedigeret().execute()); //execute query samt tilføjj til wordlist.

    }

    public void countSolutions() {
        tid.startTid();
        int solutionsCount = 0;
        for (String ord1 : wordList) {
            for (String ord2 : wordList) {
                if(allLettersUnique(ord1, ord2, ".,-")){
                    for (String ord3 : wordList) {
                        if (allLettersUnique(ord1, ord2, ord3)) {
                            if(crossWordsExist(ord1, ord2, ord3)) {
                                solutionsCount++;
                                //System.out.println(solutionsCount);
                            }
                        }
                    }
                }

            }
        }
        tid.slutTid();
        //tider:
        //277 sekunder.
        System.out.println("Solution count: " + solutionsCount);

    }
    public void printKrydsord()
    {
        String stop = "";
        for (String ord1 : wordList) {
            if(!stop.equals("x")){
                for (String ord2 : wordList) {
                    if(!stop.equals("x")) {
                        for (String ord3 : wordList) {
                            if(!stop.equals("x")) {
                                if (allLettersUnique(ord1, ord2, ord3)) {
                                    if (crossWordsExist(ord1, ord2, ord3)) {
                                        System.out.println("krydsord = " + "\n" + ord1 + "\n" + ord2 + "\n" + ord3);
                                        stop = Input.readString();

                                        //System.out.println(solutionsCount);
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }

    }
    private boolean crossWordsExist(String ord1, String ord2, String ord3) {
        if(wordList.contains(Character.toString(ord1.charAt(0)) + ord2.charAt(0) + ord3.charAt(0))){
            if(wordList.contains(Character.toString(ord1.charAt(1)) + ord2.charAt(1) + ord3.charAt(1))){
                if(wordList.contains(Character.toString(ord1.charAt(2)) + ord2.charAt(2) + ord3.charAt(2))){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean allLettersUnique(String ord1, String ord2, String ord3) {
        Set<Character> unique = new HashSet<>();
        for(char ch : (ord1+ord2+ord3).toCharArray()){
            unique.add(ch);
        }
        return (unique.size() == 9);
    }


}