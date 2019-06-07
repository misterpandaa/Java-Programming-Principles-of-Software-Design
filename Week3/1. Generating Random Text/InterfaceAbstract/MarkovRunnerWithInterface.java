
/**
 * Programming Exercise: Interface and Abstract Class
 * 
 * @author Duke Software
 * @version 1.0
 */

import edu.duke.*; 

public class MarkovRunnerWithInterface {
    public void runModel(IMarkovModel markov, String text, int size, int seed) {
        markov.setTraining(text);
        markov.setRandom(seed);
        System.out.println("running with " + markov);
        long startTime = System.nanoTime();
        for(int k=0; k < 3; k++){
            String st= markov.getRandomText(size);
            printOut(st);
        }
        long endTime = System.nanoTime();
        System.out.println("Finished in " + (endTime - startTime) + " nanoseconds");
    }
    
    public void runMarkov() {
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        int size = 200;
        int seed = 25;
        
        MarkovZero mz = new MarkovZero();
        runModel(mz, st, size, seed);
    
        MarkovOne mOne = new MarkovOne();
        runModel(mOne, st, size, seed);
        
        MarkovModel mThree = new MarkovModel(3);
        runModel(mThree, st, size, seed);
        
        MarkovFour mFour = new MarkovFour();
        runModel(mFour, st, size, seed);
    }
    
    public void compareMethods() {
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        int size = 1000;
        int seed = 42;
        
        MarkovModel mm = new MarkovModel(2);
        runModel(mm, st, size, seed);
        
        EfficientMarkovModel emm = new EfficientMarkovModel(2);
        runModel(emm, st, size, seed);
    }
    
    public void testHashMap() {
        int seed = 42;
        int size = 50;
        String text = "yes-this-is-a-thin-pretty-pink-thistle";
        
        EfficientMarkovModel markov = new EfficientMarkovModel(2);
        markov.setTraining(text);
        markov.setRandom(seed);
        
        String st= markov.getRandomText(size);
        printOut(st);
    }

    private void printOut(String s){
        String[] words = s.split("\\s+");
        int psize = 0;
        System.out.println("----------------------------------");
        for(int k=0; k < words.length; k++){
            System.out.print(words[k]+ " ");
            psize += words[k].length() + 1;
            if (psize > 60) {
                System.out.println();
                psize = 0;
            }
        }
        System.out.println("\n----------------------------------");
    }
    
}
