/*
|-------------------------------------|
| © 2024 EPN-FIS, All rights reserved |
| kevin.calles@epn.edu.ec             |
|-------------------------------------|
Autor: Kevin Calles
Fecha: 28 - 02 - 2024
Script: MainForm
*/

package UserInterface.Form;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import UserInterface.GUI.PnlHormiga;

public class MainForm extends JFrame implements ActionListener {
    JPanel pnlMenu, pnlContainer;
    PnlHormiga pnlClasificacion;
    CardLayout cardLayout;

    public MainForm(String titleApp) throws Exception {
        // Configurar la ventana
          setTitle("Interfaz con Menú y Paneles");
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          setSize(900, 800);
  
          // Crear el menú
          JMenuBar menuBar = new JMenuBar();
          JMenu menu = new JMenu("Menú");
          //Nombres de los botones del menu 
          JMenuItem item1 = new JMenuItem("Panel Clasificacion");
          
          item1.addActionListener(this);
          //si van a agregar mas opciones en el menu agregar nuevos JMenuItem en la parte de arriba y añadir al menu        
          // menu.add(item);
          menuBar.add(menu);
          setJMenuBar(menuBar);
  
          // Crear los paneles 
          pnlClasificacion = new PnlHormiga();
          pnlClasificacion.setBackground(Color.white);   
  
          // Configurar el layout de los paneles
          cardLayout = new CardLayout();
          setLayout(cardLayout);
          // usar esta estructura para añadir los paneles  a la ventana
          add(pnlClasificacion, "Panel Clasificacion");
          
          isVisible();
          setLocationRelativeTo(null);
          setVisible(true);
    }
  
      public void actionPerformed(ActionEvent e) {
          // Mostrar el panel correspondiente al item seleccionado
          //usar esto para poner la accion de cada boton
          if (e.getActionCommand().equals("Panel Clasificacion")) {
              cardLayout.show(getContentPane(), "Panel Clasificacion");
          }
          
  
          //.. seguir añadiendo
        }
}
