/*
|-------------------------------------|
| © 2024 EPN-FIS, All rights reserved |
| kevin.calles@epn.edu.ec             |
|-------------------------------------|
Autor: Kevin Calles
Fecha: 28 - 02 - 2024
Script: TextBox
*/

package UserInterface.CustomerControl;

import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class AntTextBox extends JTextField {
    public AntTextBox() {
        customizeComponent();
    }

    private void customizeComponent() {
        setFont(AntStyle.FONT);
        setForeground(AntStyle.COLOR_FONT);
        setBorder(createBorderRect());
        setCaretColor(AntStyle.COLOR_CURSOR);
        setMargin(new Insets(10, 10, 10, 10));
        setOpaque(false);
        // setUI(new BasicTextFieldUI()); // Para deshabilitar el subrayado por defecto
        setColumns(10); // Ajustar el tamaño para 10 caracteres
    }

    private Border createBorderRect() {
        Border lineBorder = BorderFactory.createLineBorder(AntStyle.COLOR_BORDER);
        Border emptyBorder = new EmptyBorder(5, 5, 5, 5); // Margenes internos
        return new CompoundBorder(lineBorder, emptyBorder);
    }

    public Border createBorderLine() {
        int thickness = 1;
        return BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(0, 0, thickness, 0),
                BorderFactory.createMatteBorder(0, 0, thickness, 0, AntStyle.COLOR_BORDER));
    }
}
