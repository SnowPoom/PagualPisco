package UserInterface.Form;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import UserInterface.GUI.PPPnlHormiga;
import UserInterface.GUI.PPPnlHormigaClasificacion;

public class MainForm extends JFrame implements ActionListener {
    JPanel pnlMenu, pnlContainer;
    PPPnlHormiga ppPnlHormiga;
    PPPnlHormigaClasificacion ppPnlHormigaClasificacion;
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
          JMenuItem item1 = new JMenuItem("Panel Hormigas");
          JMenuItem item2 = new JMenuItem("Panel Extra 1");
          
          item1.addActionListener(this);
          item2.addActionListener(this);
          //si van a agregar mas opciones en el menu agregar nuevos JMenuItem en la parte de arriba y añadir al menu        
          // menu.add(item);
          menu.add(item1);
          menu.add(item2);
          menuBar.add(menu);
          setJMenuBar(menuBar);
  
          // Crear los paneles 
          ppPnlHormiga = new PPPnlHormiga();
          ppPnlHormiga.setBackground(Color.white);   
          
          ppPnlHormigaClasificacion = new PPPnlHormigaClasificacion();
          ppPnlHormigaClasificacion.setBackground(Color.white);   
  
          // Configurar el layout de los paneles
          cardLayout = new CardLayout();
          setLayout(cardLayout);
          // usar esta estructura para añadir los paneles  a la ventana
          add(ppPnlHormiga, "Panel Hormigas");
          add(ppPnlHormigaClasificacion, "Panel Extra 1");
          
          isVisible();
          setLocationRelativeTo(null);
          setVisible(true);
    }
  
      public void actionPerformed(ActionEvent e) {
          // Mostrar el panel correspondiente al item seleccionado
          //usar esto para poner la accion de cada boton
          if (e.getActionCommand().equals("Panel Hormigas")) {
              cardLayout.show(getContentPane(), "Panel Hormigas");
          }
          if (e.getActionCommand().equals("Panel Extra 1")) {
              cardLayout.show(getContentPane(), "Panel Extra 1");
          }
        }
}
