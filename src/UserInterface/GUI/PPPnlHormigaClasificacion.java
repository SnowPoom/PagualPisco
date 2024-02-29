package UserInterface.GUI;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import BusinessLogic.PPHormigaClasificacionBL;
import DataAccess.DTO.PPHormigaClasificacionDTO;
import UserInterface.CustomerControl.Estilo;

public class PPPnlHormigaClasificacion extends JPanel implements ActionListener {
    private Integer idHC, idMaxHC,
            nroPagina = 1, totalPaginas;
    private PPHormigaClasificacionDTO usuarioDTOLogeado = null;
    ArrayList<PPHormigaClasificacionDTO> ppHormigaClasificacionDTO = null;
    private PPHormigaClasificacionBL hormigaClasificacionBL = null;
    JTable tabla = null;

    public PPPnlHormigaClasificacion() {
        customerSizeControl();
        try {
            cargarDatos();
            mostrarDatos();
            mostrarTabla();
        } catch (Exception e) {
        }
        btnIni.addActionListener(this);
        btnAnt.addActionListener(this);
        btnSig.addActionListener(this);
        btnFin.addActionListener(this);
    }

    private void cargarDatos() throws Exception {
        idHC = 1;
        hormigaClasificacionBL = new PPHormigaClasificacionBL();
        ppHormigaClasificacionDTO = hormigaClasificacionBL.ppReadAll();
        idMaxHC = ppHormigaClasificacionDTO.size();
    }

    private void mostrarDatos() {
        totalPaginas = (idMaxHC - 1) / 10 + 1;
        lblTotalReg.setText("Página " + nroPagina + " de " + totalPaginas);
    }

    private void mostrarTabla() throws Exception {
        int tamanoPagina = 10,
                startIndex = ((nroPagina - 1) * tamanoPagina) + 1,
                endIndex = startIndex + 9;

        String[] encabezado = { "IdHormiga", "Código Hormiga", "Clasificación"};
        Object[][] data = new Object[tamanoPagina][3];
        int index = 0;
        for (int i = startIndex; i <= endIndex; i++) {
            try {
                PPHormigaClasificacionDTO hc = ppHormigaClasificacionDTO.get(i - 1);
                data[index][0] = hc.getIdHormiga();
                data[index][1] = hc.getCodigo();
                data[index][2] = hc.getClasificaion();
                index++;
            } catch (Exception e) {
                break;
            }
        }

        tabla = new JTable(data, encabezado);
        tabla.setShowHorizontalLines(true);
        tabla.getTableHeader().setBackground(Estilo.COLOR_BORDER);
        tabla.setGridColor(Estilo.COLOR_BORDER);
        tabla.setRowSelectionAllowed(true);
        tabla.setColumnSelectionAllowed(false);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tabla.getColumnModel().getColumn(0).setPreferredWidth(120);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(120);
        for (int i = 0; i < tabla.getColumnCount(); i++)
            tabla.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);

        ((DefaultTableCellRenderer) tabla.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

        tabla.setPreferredScrollableViewportSize(new Dimension(530, 160));
        tabla.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(tabla);

        pnlTabla.removeAll();
        pnlTabla.add(scrollPane);
        pnlTabla.revalidate();
        pnlTabla.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnIni)
            nroPagina = 1;
        if (e.getSource() == btnAnt && (nroPagina > 1))
            nroPagina--;
        if (e.getSource() == btnSig && (nroPagina < totalPaginas))
            nroPagina++;
        if (e.getSource() == btnFin)
            nroPagina = totalPaginas;

        try {
            cargarDatos();
            mostrarDatos();
            mostrarTabla();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /********************************
     * FormDesing
     ********************************/
    private Label lblTitulo = new Label("EXTRA 1"),
            lblTotalReg = new Label("  0 de 0  ");
    private Button btnIni = new Button(" |< "),
            btnAnt = new Button(" << "),
            btnSig = new Button(" >> "),
            btnFin = new Button(" >| ");
    private JPanel pnlTabla = new JPanel(),
            pnlBtnPagina = new JPanel(new FlowLayout());

    /************************
     * Customize : Form
     ************************/
    public void customerSizeControl() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Panel.Paginacion.Tabla
        pnlBtnPagina.add(btnIni);
        pnlBtnPagina.add(btnAnt);
        pnlBtnPagina.add(lblTotalReg);
        pnlBtnPagina.add(btnSig);
        pnlBtnPagina.add(btnFin);

        // Restricciones generales
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Titulo
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 6;
        add(lblTitulo, gbc);

        // Sección de datos (Tabla)
        gbc.gridy = 1;
        gbc.weighty = 0;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.BOTH;
        add(pnlTabla, gbc);

        // Sección de paginación
        gbc.gridy = 2;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(pnlBtnPagina, gbc);
    }
}
