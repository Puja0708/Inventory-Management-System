/*
********************************************************************************
*																			   *
* Programmer: Philip V. Naparan                                                *
* Contact No.: 639186443161                                                    *
* E-mail Address: philipnaparan@yahoo.com                                      *
* Website: http://www.naparansoft.cjb.net                                      *
*    													   					   *
* "MABUHAY ANG MGA PINOY","PLEASE DON'T FORGET TO VOTE"                        *
*    													   					   *
* Note:																		   *
*      This is not intended to used in a big business because this system was  *
*      created for small business only. If you own a big business and planning *
*      to have a best software for your business then contact me. :-)          *
* 																			   *
********************************************************************************
*/


import javax.swing.plaf.*;
import javax.swing.plaf.metal.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class XPStyleTheme extends DefaultMetalTheme {

    public String getName() { return "XP Style Theme"; }

    private final ColorUIResource primary1 = new ColorUIResource( 119,  119,  187); //Frame Border Color
    private final ColorUIResource primary2 = new ColorUIResource( 153,  153,  204); //Barckground Color
    private final ColorUIResource primary3 = new ColorUIResource(225, 225, 255); // Title Color

    private final ColorUIResource secondary1 = new ColorUIResource( 172, 168, 153);  // Shadow color
    private final ColorUIResource secondary2 = new ColorUIResource(172, 168, 153); //Dark Shadow color 113, 111, 100
    private final ColorUIResource secondary3 = new ColorUIResource(236, 233,216); //Face Color

    protected ColorUIResource getPrimary1() { return primary1; }
    protected ColorUIResource getPrimary2() { return primary2; }
    protected ColorUIResource getPrimary3() { return primary3; }

    protected ColorUIResource getSecondary1() { return secondary1; }
    protected ColorUIResource getSecondary2() { return secondary2; }
    protected ColorUIResource getSecondary3() { return secondary3; }

}
