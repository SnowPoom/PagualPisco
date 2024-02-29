/*
|-------------------------------------|
| © 2024 EPN-FIS, All rights reserved |
| kevin.calles@epn.edu.ec             |
|-------------------------------------|
Autor: Kevin Calles
Fecha: 28 - 02 - 2024
Script: LabelText
*/

package UserInterface.CustomerControl;

import javax.swing.*;
import java.awt.*;

public class AntLabelText extends JPanel {

    private AntLabel lblEtiqueta = new AntLabel();
    private JLabel txtContenido = new JLabel();

    public AntLabelText(String etiqueta) {
        setLayout(new BorderLayout());
        lblEtiqueta.setCustomizeComponent(
                etiqueta,
                AntStyle.FONT,
                AntStyle.COLOR_FONT,
                AntStyle.ALIGNMENT_CENTER);

        add(lblEtiqueta, BorderLayout.NORTH);
        add(txtContenido, BorderLayout.CENTER);
    }
}