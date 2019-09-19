package KrydsordsGenerator;

import DBUtil.DBQuery;
import DBUtil.Queries.selectOrdListeRedigeret;
import UI.Input;
import com.sun.jdi.event.ThreadStartEvent;

import java.util.*;


public class KrydsordsGeneratorV2 {
    private List<String> wordList = new ArrayList<>();
    private List<String> partOne = new ArrayList<>();
    private List<String> partTwo= new ArrayList<>();
    private List<String> partThree = new ArrayList<>();

    Tid tid;

    public KrydsordsGeneratorV2() {
        tid = new Tid();
        tid.startTid();

        wordList.addAll(new selectOrdListeRedigeret().execute()); //execute query samt tilføjj til wordlist.

        //wordList size = 1077.

        partOne = wordList.subList(0, 538);
        partTwo = wordList.subList(538, 1077);
        //partThree = wordList.subList(718, 1077);

        CountSolutions t1 = new CountSolutions(partOne, wordList);
        CountSolutions t2 = new CountSolutions(partTwo, wordList);
        //CountSolutions t3 = new CountSolutions(partThree, wordList);

        t1.setDaemon(true);
        t2.setDaemon(true);
        //t3.setDaemon(true);

        t1.start();
        t2.start();
        //t3.start();

        try{
            t1.join();
            t2.join();
          //t3.join();
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }

        int sum = (t1.getCount() + t2.getCount()); // + t3.getCount());
        System.out.println("Counts: " + sum);
        tid.slutTid();
        //tider set:
        //718 sekunder (3 threads)
        //861 sekunder (2 threads)


    }

    private static class CountSolutions extends Thread {
        int count = 0;
        List<String> fullWordList;
        List<String> partWordList;
        public CountSolutions(List<String> partWordList, List<String> fullWordList){
            this.fullWordList = fullWordList;
            this.partWordList = partWordList;
        }

        @Override
        public void run() {
            int solutionsCount = 0;
            for (String ord1 : partWordList) {
                for (String ord2 : fullWordList) {
                    if(allLettersUnique(ord1, ord2, ".,-")){
                        for (String ord3 : fullWordList) {
                            if (allLettersUnique(ord1, ord2, ord3)) {
                                if(crossWordsExist(ord1, ord2, ord3)) {
                                    solutionsCount++;
                                }
                            }
                        }
                    }

                }
            }
            this.count = solutionsCount;

        }
        public int getCount() {
            return count;
        }
        private boolean crossWordsExist(String ord1, String ord2, String ord3) {
            if(fullWordList.contains(Character.toString(ord1.charAt(0)) + ord2.charAt(0) + ord3.charAt(0))){
                if(fullWordList.contains(Character.toString(ord1.charAt(1)) + ord2.charAt(1) + ord3.charAt(1))){
                    if(fullWordList.contains(Character.toString(ord1.charAt(2)) + ord2.charAt(2) + ord3.charAt(2))){
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
}