
/**
 * Write a description of class ColumnStrategy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ColumnStrategy implements WinningStrategy
{
    public String description()
    {
        return "all numbers in a column";
    }

    public boolean isWinner(BingoCard card)
    {
        int k = 0;
       

        for(int i = 1; i < BingoCard.NUMCOLS; i++)
        {
            for(int j = 0; j < BingoCard.NUMCOLS; j++)
            {
                if(card.getCellAt(i, j).isMarked())
                {
                    k++;
                }                
            }
            if(k == BingoCard.NUMCOLS)
            {
                return true;
            }
            k = 0;
        }

        return false;
    }
}
