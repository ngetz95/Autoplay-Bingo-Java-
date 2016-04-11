
/**
 * Write a description of class DeclineStrategy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DeclineStrategy implements WinningStrategy
{
    public String description()
    {
        return "all numbers diagonally from top left to bottom right";
    }

    public boolean isWinner(BingoCard card)
    {
        int k = 0;

        for(int i = 0; i < BingoCard.NUMCOLS; i++)
        {

            if(card.getCellAt(i + 1, i).isMarked())
            {
                k++;
            }                

            if(k == BingoCard.NUMCOLS)
            {
                return true;
            }
            
        }

        return false;
    }
}
