
/**
 * Programming Exercise: Interface and Abstract Class
 * 
 * @author Deny Kiantono
 * @version 1.0
 */

public interface IMarkovModel {
    public void setTraining(String text);
    
    public void setRandom(int seed);
        
    public String getRandomText(int numChars);
}
