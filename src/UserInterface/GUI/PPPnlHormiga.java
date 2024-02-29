package UserInterface.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import BusinessLogic.HormigaBL;
import DataAccess.DTO.HormigaDTO;
import UserInterface.CustomerControl.AntButton;
import UserInterface.CustomerControl.AntLabel;

public class PPPnlHormiga extends JPanel implements  ActionListener {
    private Integer idHormiga, idMaxHormiga,
                    nroPagina = 1, totalPaginas;
    private HormigaBL  hormigaBL  = null;
    private HormigaDTO hormigaDTO = null;

    public PPPnlHormiga() throws Exception{
        customerSizeControl();
        loadData();
        showData();
        showTable();

        ppBtnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {   try {
                ppBtnBuscar(e);
            } catch (Exception e1) {
                e1.printStackTrace();
            }    }
        });

        btnIni.addActionListener(this);
        btnAnt.addActionListener(this);
        btnSig.addActionListener(this);
        btnFin.addActionListener(this);
    }

    private void showTable() throws Exception{
        int tamanoPagina = 10,
            startIndex = ((nroPagina - 1)* tamanoPagina) +1,
            endIndex = startIndex + 9;
        
        String[] header = {"Id", "Código", "Clasificación", "Comió", "Estado", "Recogió"};
        Object[][] data = new Object[10][6];
        int index = 0;
        HormigaDTO h;
        for(int i = startIndex; i <= endIndex; i++){
            h = hormigaBL.ppReadLarvas(i);
            if(h!=null){
                data[index][0] = h.getIdHormiga();
                data[index][1] = h.getCodigo();
                data[index][2] = h.getIdClasificacion();
                data[index][3] = h.getComio();
                data[index][4] = h.getEstado();
                data[index][5] = h.getRecogio();
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
    }

    private void showData() {
        totalPaginas = (idMaxHormiga -1)/10+1;
        lblTotalReg.setText("Página "+nroPagina+ " de "+totalPaginas);
    }

    private void loadData() throws Exception {
        idHormiga    = 1;
        hormigaBL    = new HormigaBL();
        hormigaDTO   = hormigaBL.ppReadLarvas(idHormiga);
        idMaxHormiga = hormigaBL.getMaxId();
    }

    private void ppBtnBuscar(ActionEvent e)throws Exception{
               
            /* if(!personaBL.delete(personaDTO.getIdPersona()))
                JOptionPane.showMessageDialog(this, "Error al eliminar...!",
                                        "ERROR", JOptionPane.OK_OPTION); */

            loadData();
            showData();
            showTable();
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
        lblInfo     = new AntLabel("EXTRA EN LA ESQUINA SUPERIOR IZQ (PRESIONAR MENU)"),
        lblTitulo     = new AntLabel("INFO HORMIGAS"),
        lblTotalReg   = new AntLabel("  0 de 0  ");
    private AntButton  
        btnIni     = new AntButton(" |< "), 
        btnAnt     = new AntButton(" << "),            
        btnSig     = new AntButton(" >> "),
        btnFin     = new AntButton(" >| "),
        ppBtnBuscar = new AntButton("Buscar");
    private JPanel 
        pnlTabla   = new JPanel(),
        pnlBtnPage = new JPanel(new FlowLayout()),
        ppPnlBtnBuscar = new JPanel(new FlowLayout());
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

        ppPnlBtnBuscar.add(ppBtnBuscar);
        ppPnlBtnBuscar.setBorder(border);

        // Restricciones generales
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Info
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        add(lblInfo, gbc);

        // Titulo
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        add(lblTitulo, gbc);

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
        // Sección de paginación
        gbc.gridy = 4;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(ppPnlBtnBuscar, gbc);

    }
}

