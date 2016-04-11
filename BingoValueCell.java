import java.awt.Color;

import edu.kzoo.grid.Grid;
import edu.kzoo.grid.TextCell;
import edu.kzoo.grid.Location;

// Class: BingoValueCell
//
// Author:  Alyce Brady
//
// Created on June 6, 2008
// Modifications:
//    Date      Name     Reason
//    ----      ----     ------
//    7 May 12  A Brady  Modified to extend TextCell so that recent versions
//                       of BlueJ will display Bingo cells.
//
// License Information:
//   This class is free software; you can redistribute it and/or modify
//   it under the terms of the GNU General Public License as published by
//   the Free Software Foundation.
//
//   This class is distributed in the hope that it will be useful,
//   but WITHOUT ANY WARRANTY; without even the implied warranty of
//   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//   GNU General Public License for more details.

/**
 *  Bingo Game:<br>
 *
 * A BingoValueCell is a cell containing text (a column heading or the string
 * version of a number that can be played);
 * NOTE: in this version of the class, the color CANNOT be changed when
 * the value in the cell is played -- the cell must be replaced by a new cell
 * with the new color.
 * 
 * @author Alyce Brady 
 * @version 7 May 2012
 */
public class BingoValueCell extends TextCell
{
    // Encapsulated data for each Bingo value cell object inherited from TextCell

    /** @return Returns a formatted string version of the number
     *          specified as <code>num</code> suitable for placing in
     *          a cell on a bingo card.
     */
    private static String formatNumForCard(int num)
    {
        return " " + num + " ";
    }

    /**
     * Constructs objects of class BingoValueCell with the given value
     * and the "unmarked value" color (see BingoGUI.getUnmarkedColor()).
     */
    public BingoValueCell(int value)
    {
        this(value, BingoGUI.getUnmarkedColor());
    }

    /**
     * Constructs objects of class BingoValueCell with the given
     * value and text color.
     */
    public BingoValueCell(int value, Color textColor)
    {
        super(formatNumForCard(value), textColor);
    }

    /**
     * Constructs objects of class BingoValueCell with the given
     * value and text color.
     */
    public BingoValueCell(String value, Color textColor)
    {
        super(value, textColor);
    }

    /** Returns the value in this cell as an integer (if it is an integer).
     **/
    public int value()
    {
        return Integer.parseInt(text().trim());
    }

    /** Returns <code>true</code> if the text in this cell is equivalent
     *  to the formatted string version of the given <code>value</code>;
     *  returns <code>false</code> otherwise.
     **/
    public boolean textEqualsValue(int value)
    {
        return text().equals(formatNumForCard(value));
    }

    /** Returns <code>true</code> if this cell has been marked;
     *          <code>false</code> otherwise.
     */
    public boolean isMarked()
    {
        return color().equals(BingoGUI.getMarkedColor());
    }
}
