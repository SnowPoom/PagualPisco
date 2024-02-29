package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DataAccess.DTO.PPHormigaClasificacionDTO;
import Framework.AntException;

public class PPHormigaClasificacionDAO extends SQLiteDataHelper {
    public ArrayList<PPHormigaClasificacionDTO> ppReadAll() throws Exception {
        ArrayList<PPHormigaClasificacionDTO> ppLista = new ArrayList<>();
        String query = "SELECT h.IdHormiga, h.Codigo, c.Nombre "
                     + "FROM Hormiga h "
                     + "INNER JOIN Clasificacion c ON h.IdClasificacion = c.IdClasificacion "
                     + "WHERE h.Estado = 'A'";
        try {
            Connection conn            = openConnection();
            PreparedStatement  stmnt = conn.prepareStatement(query);
            ResultSet  rs = stmnt.executeQuery();
            while (rs.next()) {
                PPHormigaClasificacionDTO ppHormigaClasificacionDTO = new PPHormigaClasificacionDTO(rs.getInt(1),
                                                                                                    rs.getString(2),
                                                                                                    rs.getString(3));
                ppLista.add(ppHormigaClasificacionDTO);
            }
        } catch (SQLException e) {
            throw new AntException(e.getMessage(), getClass().getName(), "ppReadAll()");
        }
        return ppLista;
    }
}
