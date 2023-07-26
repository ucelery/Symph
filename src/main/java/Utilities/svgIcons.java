/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import javax.swing.JLabel;

/**
 * currently not working, im cri
 * @author nappi
 */
public class svgIcons extends JLabel{
    
    private FlatSVGIcon svgIcon;
    
    public void setSvgIcon(String image, int width, int height) {
        svgIcon = new FlatSVGIcon(image, width, height);
        setIcon(svgIcon);
    }

}
