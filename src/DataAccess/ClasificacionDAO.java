/*
|-------------------------------------|
| © 2024 EPN-FIS, All rights reserved |
| antony.cobos@epn.edu.ec             |
|-------------------------------------|
Autor: Antony Cobos
Fecha: 28 - 02 - 2024
Script: DAO de Clasificacion
*/

package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import DataAccess.DTO.ClasificacionDTO;
import Framework.AntException;

public class ClasificacionDAO extends SQLiteDataHelper implements IDAO<ClasificacionDTO> {

    @Override
    public boolean create(ClasificacionDTO entity) throws Exception {
        String query = "INSERT INTO Clasificacion(Nombre) VALUES(?) ";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            throw new AntException(e.getMessage(), getClass().getName(), "create()");
        }

    }

    @Override
    public ArrayList<ClasificacionDTO> readAll() throws Exception {
        ArrayList<ClasificacionDTO> lst = new ArrayList<>();
        String query = "SELECT * FROM Clasificacion WHERE  Estado = 'A'";

        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                ClasificacionDTO oClasificacionDTO = new ClasificacionDTO(rs.getInt(1),
                                                                          rs.getString(2),
                                                                          rs.getString(3),
                                                                          rs.getString(4),
                                                                          rs.getString(5));
                lst.add(oClasificacionDTO);
            }
        } catch (SQLException e) {
            throw new AntException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst;
    }

    @Override
    public ClasificacionDTO readBy(Integer id) throws Exception {
        ClasificacionDTO oClasificacionDTO = new ClasificacionDTO();
        String query = "SELECT * FROM Clasificacion WHERE  Estado = 'A' AND IdClasificacion = "+id.toString();

        try {
            Connection conn = openConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                oClasificacionDTO = new ClasificacionDTO(rs.getInt(1),
                                                         rs.getString(2),
                                                         rs.getString(3),
                                                         rs.getString(4),
                                                         rs.getString(5));
            }
        } catch (SQLException e) {
            throw new AntException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return oClasificacionDTO;
    }

    @Override
    public boolean update(ClasificacionDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        
        String query = "UPDATE Clasificacion SET    "
                + "  IdClasificacion=?"
                + " ,Nombre=?"
                + " ,FechaModifica=?"
                + " FROM   Clasificacion             "
                + " WHERE  Estado = 'A'  ";

        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getIdClasificacion());
            pstmt.setString(2, entity.getNombre());
            pstmt.setString(3, dtf.format(now).toString());

            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new AntException(e.getMessage(), getClass().getName(), "readAll()");
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = "UPDATE Clasificacion SET Estado = ?"
        + "WHERE IdClasificacion = ?          ";
        try {
            Connection         conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new AntException(e.getMessage(), getClass().getName(), "delete()");
        }    }

    @Override
    public int getMaxId() throws Exception {
        int maxId = 0;
        String query = "SELECT MAX(IdClasificacion) FROM Clasificacion WHERE Estado = 'A'";
        try {
            Connection conn = openConnection();
            Statement  stmt = conn.createStatement();
            ResultSet  rs   = stmt.executeQuery(query);
            if (rs.next())
                maxId = rs.getInt(1);
        } catch (SQLException e) {
            throw new AntException(e.getMessage(), getClass().getName(), "getMaxId()");
        }
        return maxId;    }

}
