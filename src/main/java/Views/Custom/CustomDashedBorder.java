/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Views.Custom;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import javax.swing.border.AbstractBorder;
/**
 *
 * @author CailynRae
 */
public class CustomDashedBorder extends AbstractBorder{
    private Color color;
    private int thickness;
    private int dashLength;
    private int gapLength;

    public CustomDashedBorder(Color color, int thickness, int dashLength, int gapLength) {
        this.color = color;
        this.thickness = thickness;
        this.dashLength = dashLength;
        this.gapLength = gapLength;
    }

    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics g2d = (Graphics) g.create();

        // Set the border color
        g2d.setColor(color);

        // Set the border thickness
        ((Graphics2D) g2d).setStroke(new BasicStroke(thickness, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, new float[]{dashLength, gapLength}, 0.0f));

        // Draw the border
        g2d.drawRect(x, y, width - 1, height - 1);

        g2d.dispose();
    }

    public Insets getBorderInsets(Component c) {
        return new Insets(thickness, thickness, thickness, thickness);
    }

    public Insets getBorderInsets(Component c, Insets insets) {
        insets.left = insets.top = insets.right = insets.bottom = thickness;
        return insets;
    }
}
