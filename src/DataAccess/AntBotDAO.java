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

import DataAccess.DTO.AntBotDTO;
import Framework.AntException;

public class AntBotDAO extends SQLiteDataHelper implements IDAO<AntBotDTO> {

    @Override
    public boolean create(AntBotDTO entity) throws Exception {
        String query="INSERT INTO AntBot DEFAULT VALUES";
        try {
            Connection conn=openConnection();
            Statement stmt= conn.createStatement();
            stmt.executeUpdate(query);
            return true;
        } catch (Exception e) {
            throw new AntException(e.getMessage(),getClass().getName(), "create()");
        }
        
    }

    @Override
    public List<AntBotDTO> readAll() throws Exception {
        List<AntBotDTO> lst = new ArrayList<>();
        String query = "SELECT IdAntBot,              "
                        + " Estado,                   "
                        + " FechaCrea,                "
                        + " FechaModifica            "
                        + " FROM   AntBot             "
                        + " WHERE  Estado = 'A'        ";

        try {
            Connection conn = openConnection();
            Statement  stmt = conn.createStatement();
            ResultSet    rs =  stmt.executeQuery(query);
            while (rs.next()) {
                AntBotDTO oAntBotDTO = new AntBotDTO(rs.getInt(1),
                rs.getString(2),                         
                rs.getString(3),                         
                rs.getString(4));
                lst.add(oAntBotDTO);
            }
        } catch (SQLException e) {
            throw new AntException(e.getMessage(),getClass().getName(), "readAll()");
        }
        return lst;
    }    
    

    @Override
    public AntBotDTO readBy(Integer id) throws Exception {
        AntBotDTO oAntBotDTO = new AntBotDTO();
        String query = "SELECT IdAntBot,           "
                     + " FechaCrea,                "
                     + " Estado,                   "
                     + " FechaModifica            "
                     + " FROM   AntBot             "
                     + " WHERE  Estado = 'A' AND IdAntBot="+id.toString();

        try {
            Connection conn = openConnection();
            Statement  stmt = conn.createStatement();
            ResultSet    rs =  stmt.executeQuery(query);
            while (rs.next()) {
                oAntBotDTO = new AntBotDTO(rs.getInt(1),
                                           rs.getString(2),                         
                                           rs.getString(3),                         
                                           rs.getString(4)                    );
            }
        } catch (SQLException e) {
            throw new AntException(e.getMessage(),getClass().getName(), "readAll()");
        }
        return oAntBotDTO;
    }

    @Override
    public boolean update(AntBotDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query =  "UPDATE AntBot SET IdAntBot=?"
                        + " ,FechaModifica=? "
                        + " FROM   AntBot             "
                        + " WHERE  Estado = 'A' ";
        try {
            Connection         conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getIdAntBot());
            pstmt.setString(2, dtf.format(now).toString());

            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new AntException(e.getMessage(),getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = "UPDATE AntBot SET Estado = ?"
        + "WHERE IdAntBot = ?          ";
        try {
            Connection         conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new AntException(e.getMessage(), getClass().getName(), "delete()");
        }
        }

    @Override
    public int getMaxId() throws Exception {
        int maxId = 0;
        String query = "SELECT MAX(IdAntBot) FROM AntBot WHERE Estado = 'A'";
        try {
            Connection conn = openConnection();
            Statement  stmt = conn.createStatement();
            ResultSet  rs   = stmt.executeQuery(query);
            if (rs.next())
                maxId = rs.getInt(1);
        } catch (SQLException e) {
            throw new AntException(e.getMessage(), getClass().getName(), "getMaxId()");
        }
        return maxId;
    }

}
