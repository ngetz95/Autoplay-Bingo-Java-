
/**
 * Write a description of class InclineStrategy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InclineStrategy implements WinningStrategy
{
    public String description()
    {
        return "all numbers diagonally from top right to bottom left";
    }

    public boolean isWinner(BingoCard card)
    {
        int k = 0;

        for(int i = BingoCard.NUMCOLS - 1; i >= 0; i--)
        {

            if(card.getCellAt(BingoCard.NUMCOLS - i, i).isMarked())
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
