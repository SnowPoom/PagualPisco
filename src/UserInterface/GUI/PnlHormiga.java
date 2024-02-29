/*
|-------------------------------------|
| © 2024 EPN-FIS, All rights reserved |
| kevin.calles@epn.edu.ec             |
|-------------------------------------|
Autor: Kevin Calles
Fecha: 28 - 02 - 2024
Script: Panel de presentación de datos y CRUD para Clasificacion
*/

package UserInterface.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import BusinessLogic.HormigaBL;
import DataAccess.DTO.ClasificacionDTO;
import DataAccess.DTO.HormigaDTO;
import UserInterface.CustomerControl.AntButton;
import UserInterface.CustomerControl.AntLabel;

public class PnlHormiga extends JPanel implements  ActionListener {
    private Integer idHormiga, idMaxHormiga,
                    nroPagina = 1, totalPaginas;
    private HormigaBL  hormigaBL  = null;
    private HormigaDTO hormigaDTO = null;

    public PnlHormiga() throws Exception{
        customerSizeControl();
        loadData();
        showData();
        showTable();

        btnIni.addActionListener(this);
        btnAnt.addActionListener(this);
        btnSig.addActionListener(this);
        btnFin.addActionListener(this);
    }

    private void showTable() throws Exception{
        int tamanoPagina = 10,
            startIndex = ((nroPagina - 1)* tamanoPagina) +1,
            endIndex = startIndex + 9;
        
        String[] header = {"Id", "Nombre", "Estado", "FechaCrea"};
        Object[][] data = new Object[endIndex - startIndex + 1][4];
        int index = 0;
        ClasificacionDTO cl;
        for(int i = startIndex; i <= endIndex; i++){
            cl = clasificacionBL.getBy(i);
            if(cl!=null){
            data[index][0] = cl.getIdClasificacion()==0 ? "" :  cl.getIdClasificacion();
            data[index][1] = cl.getNombre();
            data[index][2] = cl.getEstado();
            data[index][3] = cl.getFechaCrea();
            }
            index++;
        }

        JTable table  = new JTable(data, header);
        table.setShowHorizontalLines(true);
        table.setGridColor(Color.lightGray);
        table.setRowSelectionAllowed(true);
        table.setColumnSelectionAllowed(false);

        table.setPreferredScrollableViewportSize(new Dimension(670, 160));
        table.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(table);

        pnlTabla.removeAll();
        pnlTabla.add(scrollPane);
        pnlTabla.revalidate();
        pnlTabla.repaint();

        table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){ 
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int col = 0;
                int row = table.getSelectedRow();
                String strIdClasificacion = table.getModel().getValueAt(row, col).toString();

                idClasificacion = Integer.parseInt(strIdClasificacion);
                try {
                    clasificacionDTO = clasificacionBL.getBy(idClasificacion);
                    showData(); 
                } catch (Exception e1) { }  
                System.out.println("Tabla.Selected: " + strIdClasificacion);
            }
        });
    }

    private void showData() {
        totalPaginas = (idMaxClasificacion -1)/10+1;
        lblTotalReg.setText("Página "+nroPagina+ " de "+totalPaginas);
    }

    private void loadData() throws Exception {
        idClasificacion    = 1;
        clasificacionBL    = new ClasificacionBL();
        clasificacionDTO   = clasificacionBL.getBy(idClasificacion);
        idMaxClasificacion = clasificacionBL.getMaxId();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnIni)
            nroPagina = 1;
        if(e.getSource() == btnAnt  &&  (nroPagina > 1) )
            nroPagina--;
        if(e.getSource() == btnSig  &&  (nroPagina < totalPaginas))
            nroPagina++;
        if(e.getSource() == btnFin)
            nroPagina = totalPaginas;

        try {
            loadData();
            showData();
            showTable();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
//**********************************************
    private AntLabel 
        lblTitulo     = new AntLabel("CLASIFICACIÓN"),
        lblTotalReg   = new AntLabel("  0 de 0  ");
    private AntButton  
        btnIni     = new AntButton(" |< "), 
        btnAnt     = new AntButton(" << "),            
        btnSig     = new AntButton(" >> "),
        btnFin     = new AntButton(" >| ");
    private JPanel 
        pnlTabla   = new JPanel(),
        pnlBtnPage = new JPanel(new FlowLayout());
    private Border  
        line       = new LineBorder(Color.lightGray),
        margin     = new EmptyBorder(5, 5, 5, 5),
        border     = new CompoundBorder(line, margin);

//**********************************************************************

    private void customerSizeControl() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Panel.Paginacion.Tabla
        pnlBtnPage.add(btnIni);       
        pnlBtnPage.add(btnAnt);  
        pnlBtnPage.add(lblTotalReg);        
        pnlBtnPage.add(btnSig);
        pnlBtnPage.add(btnFin);

        // Restricciones generales
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Titulo
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        add(lblTitulo, gbc);

        // Separador
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add(new JLabel("■ Sección de datos: "), gbc);

        // Sección de datos (Tabla)
        gbc.gridy = 2;
        gbc.weighty = 0;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.BOTH;
        add(pnlTabla, gbc);

        // Sección de paginación
        gbc.gridy = 3;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(pnlBtnPage, gbc);

        // Separador
        gbc.gridy = 4;
        gbc.gridwidth = 3;
        add(new JLabel("■ Sección de registro: "), gbc);

    }
}

