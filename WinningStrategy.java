
/**
 * Write a description of interface WinningStrategy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface WinningStrategy
{
    /**
     * An example of a method header - replace this comment with your own
     * 
     * @param  y    a sample parameter for a method
     * @return        the result produced by sampleMethod 
     */
    //int sampleMethod(int y);
    
    
    String description();
    
    boolean isWinner(BingoCard card);
    
    
}
