import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;

import edu.kzoo.grid.display.DisplayMap;
import edu.kzoo.grid.display.TextCellDisplay;

import edu.kzoo.grid.gui.EnabledDisabledStates;
import edu.kzoo.grid.gui.GeneratedButtonList;
import edu.kzoo.grid.gui.GridAppFrame;
import edu.kzoo.grid.gui.nuggets.BasicHelpMenu;
import edu.kzoo.grid.gui.nuggets.MinimalFileMenu;
import edu.kzoo.grid.gui.nuggets.BGColorChoiceMenu;
import edu.kzoo.grid.gui.nuggets.ColorChoiceMenu;

// Class: BingoGUI
//
// Author:  Alyce Brady
//
// Created on Mar 18, 2008
// Modifications:
//    Date      Name     Reason
//    ----      ----     ------
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
 *  A BingoGUI object represents the graphical user interface for a
 *  game of bingo.
 *
 *  @author Alyce Brady
 *  @version April 21, 2009
 */
public class BingoGUI extends GridAppFrame
{
    // Specify dimensions of grid display and individual cell size.
    private static final int DISPLAY_WIDTH = 450;
    private static final int DISPLAY_HEIGHT = 540;
    private static final int MIN_CELL_SIZE = 10;

    // Define control buttons attributes.
    private static final boolean INCLUDE_ONLY_ON_BUTTONCLICK_METHODS = true;
    private static final boolean DISPLAY_GRID_AFTER_BUTTON_PRESSES = true;

    // Keep track of color chooser menus.
    private ColorChoiceMenu bgColorChooser;
    private static ColorChoiceMenu colHeadingColorChooser =
                               new ColorChoiceMenu("Column Heading Color:",
                               "White");
    private static ColorChoiceMenu markedValueColorChooser =
                               new ColorChoiceMenu("Marked Value Color:",
                               "Red");
    private static ColorChoiceMenu unmarkedValueColorChooser =
                               new ColorChoiceMenu("Unmarked Value Color:",
                               "Black");

    /** Returns the color to use for column headings. */
    public static Color getColHeadingColor()
    {
        return colHeadingColorChooser.currentColor();
    }

    /** Returns the color to use for unmarked Bingo values. */
    public static Color getMarkedColor()
    {
        return markedValueColorChooser.currentColor();
    }

    /** Returns the color to use for unmarked Bingo values. */
    public static Color getUnmarkedColor()
    {
        return unmarkedValueColorChooser.currentColor();
    }

    /** Constructs a graphical user interface to display the given
     *  Bingo card.
     *    @param card       the card to display
     *    @param game       the game controller
     *    @param author     the author(s) of the program
     *    @param assistance the names of anyone who provided assistance
     *                      to the author(s)
     *    @param versionOrDate  a number or date identifying the version of
     *                          the program being executed
     */
    public BingoGUI(BingoCard card, BingoGame game,
                    String author, String assistance,
                    String versionOrDate, String helpFile)
    {
        // Create graphical user interface capable of displaying a
        // bingo game.  Column headings and numbers on the bingo card
        // will be represented with text cells.
        DisplayMap.associate("edu.kzoo.grid.TextCell", new TextCellDisplay());
        includeMenu(new MinimalFileMenu());
        includeMenu(new BasicHelpMenu("Bingo Game", author, assistance,
                versionOrDate, helpFile));
        includeSpeedSlider();

        // Include a background color chooser component.
        bgColorChooser = new BGColorChoiceMenu(this, "Background Color",
                                               "Blue");
        includeControlComponent(bgColorChooser,
                               EnabledDisabledStates.NEEDS_APP_WAITING);

        // Include color chooser components for the column headings and
        // for marked and unmarked (called and not-yet called) Bingo values.
        includeControlComponent(colHeadingColorChooser,
                                EnabledDisabledStates.NEEDS_APP_WAITING);
        includeControlComponent(markedValueColorChooser,
                                EnabledDisabledStates.NEEDS_APP_WAITING);
        includeControlComponent(unmarkedValueColorChooser,
                                EnabledDisabledStates.NEEDS_APP_WAITING);

        // Generate control buttons derived from the methods of the target
        // BingoGame object and include them in the user interface.
        GeneratedButtonList generatedButtonList = 
            new GeneratedButtonList(this, game,
                                    INCLUDE_ONLY_ON_BUTTONCLICK_METHODS,
                                    DISPLAY_GRID_AFTER_BUTTON_PRESSES);
        includeControlComponents(generatedButtonList,
                            EnabledDisabledStates.NEEDS_GRID_AND_APP_WAITING);

        constructWindowContents("Bingo Game", bgColorChooser.currentColor(), 
                DISPLAY_WIDTH, DISPLAY_HEIGHT, MIN_CELL_SIZE);
        setGrid(card);
        showGrid();
    }

    /** Defines contents of main window panel. */
    protected JPanel defineContent()
    {
        JPanel content = new JPanel();
        content.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        content.setLayout(new BorderLayout());

        // Create a panel to display the grid and speed slider bar
        // and another for the control buttons (e.g., a Reset button),
        // and add them to the main panel. 
        JPanel gridAndSliderPanel = new JPanel();
        gridAndSliderPanel.setLayout(new BorderLayout());

        gridAndSliderPanel.add(makeDisplayPanel(), BorderLayout.CENTER);

        JComponent sliderPanel = makeSliderPanel();
        if ( sliderPanel != null )
            gridAndSliderPanel.add(sliderPanel, BorderLayout.SOUTH);

        content.add(gridAndSliderPanel, BorderLayout.CENTER);

        JComponent controlPanel = makeControlPanel(null);
        if ( controlPanel != null )
            content.add(controlPanel, BorderLayout.WEST);

        return content;
    }
}
