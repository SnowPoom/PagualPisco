package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import DataAccess.DTO.HormigaDTO;
import Framework.AntException;

public class HormigaDAO extends SQLiteDataHelper implements IDAO<HormigaDTO> {

    @Override
    public boolean create(HormigaDTO entity) throws Exception {
        String query = "INSERT INTO Hormiga("
                + " Codigo,"
                + " IdClasificacion,"
                + " IdAntBot,"
                + " Comio"
                + " Recogio) VALUES(?, ?, ?, ?, ?) ";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getCodigo());
            pstmt.setInt(2, entity.getIdClasificacion());
            pstmt.setInt(3, entity.getIdAntBot());
            pstmt.setInt(4, entity.getComio());
            pstmt.setInt(5, entity.getRecogio());
            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            throw new AntException(e.getMessage(), getClass().getName(), "create()");
        }

    }

    @Override
    public List<HormigaDTO> readAll() throws Exception {
        List<HormigaDTO> lst = new ArrayList<>();
        String query = "SELECT    "
                + " IdHormiga"
                + " ,IdAntBot"
                + " ,Codigo"
                + " ,IdClasificacion"
                + " ,Comio"
                + " ,Recogio"
                + " ,Estado"
                + " ,FechaCrea"
                + " ,FechaModifica"
                + " FROM   Hormiga             "
                + " WHERE  Estado = 'A'        ";

        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                HormigaDTO oHormigaDTO = new HormigaDTO(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getInt(9));
                lst.add(oHormigaDTO);
            }
        } catch (SQLException e) {
            throw new AntException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst;
    }

    @Override
    public HormigaDTO readBy(Integer id) throws Exception {
        HormigaDTO oHormigaDTO = new HormigaDTO();
        String query = "SELECT    "
                + " IdHormiga"
                + " ,IdAntBot"
                + " ,Codigo"
                + " ,IdClasificacion"
                + " ,Comio"
                + " ,Recogio"
                + " ,Estado"
                + " ,FechaCrea,"
                + " FechaModifica"
                + " FROM   Hormiga             "
                + " WHERE  Estado = 'A'  AND  IdHormiga=?" + id.toString();

        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                oHormigaDTO = new HormigaDTO(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getInt(9));
            }
        } catch (SQLException e) {
            throw new AntException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return oHormigaDTO;
    }
    
    public HormigaDTO ppReadLarvas(Integer id) throws Exception {
        HormigaDTO oHormigaDTO = new HormigaDTO();
        String query = "SELECT    "
                + " IdHormiga"
                + " ,IdAntBot"
                + " ,Codigo"
                + " ,IdClasificacion"
                + " ,Comio"
                + " ,Recogio"
                + " ,Estado"
                + " ,FechaCrea,"
                + " FechaModifica"
                + " FROM   Hormiga             "
                + " WHERE Estado = 'A' AND IdClasificacion IN (1, 3) AND IdHormiga = ?" + id.toString();

        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                oHormigaDTO = new HormigaDTO(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getInt(9));
            }
        } catch (SQLException e) {
            throw new AntException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return oHormigaDTO;
    }

    @Override
    public boolean update(HormigaDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        
        String query = "UPDATE Hormiga SET    "
                + "  IdHormiga=?"
                + " ,IdAntBot=?"
                + " ,Codigo=?"
                + " ,IdClasificacion=?"
                + " ,Comio=?"
                + " ,Recogio=?"
                + " ,FechaModifica=?"
                + " FROM   Hormiga             "
                + " WHERE  Estado = 'A'  ";

        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getIdHormiga());
            pstmt.setInt(2, entity.getIdAntBot());
            pstmt.setString(3, entity.getCodigo());
            pstmt.setInt(4, entity.getIdClasificacion());
            pstmt.setInt(5, entity.getComio());
            pstmt.setInt(6, entity.getRecogio());
            pstmt.setString(7, dtf.format(now).toString());

            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new AntException(e.getMessage(), getClass().getName(), "readAll()");
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = "UPDATE Hormiga SET Estado = ?"
        + "WHERE IdHormiga = ?          ";
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
        String query = "SELECT MAX(IdHormiga) FROM Hormiga WHERE Estado = 'A'";
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
