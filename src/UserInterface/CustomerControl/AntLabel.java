/*
|-------------------------------------|
| © 2024 EPN-FIS, All rights reserved |
| kevin.calles@epn.edu.ec             |
|-------------------------------------|
Autor: Kevin Calles
Fecha: 28 - 02 - 2024
Script: Label
*/

package UserInterface.CustomerControl;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

public class AntLabel extends JLabel{

    public AntLabel() {
        customizeComponent();
    }

    public AntLabel(String text) {
        setText(text);
        customizeComponent();
    }

    private void customizeComponent() {
        setCustomizeComponent(getText(), AntStyle.FONT, AntStyle.COLOR_FONT_LIGHT, AntStyle.ALIGNMENT_LEFT);
    }

    public void setCustomizeComponent(String text, Font font, Color color, int alignment) {
        setText(text);
        setFont(font);
        setOpaque(false);
        setBackground(null);
        setForeground(color);
        setHorizontalAlignment(alignment);
    }
}