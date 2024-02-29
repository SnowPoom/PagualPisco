/*
|-------------------------------------|
| © 2024 EPN-FIS, All rights reserved |
| antony.cobos@epn.edu.ec             |
|-------------------------------------|
Autor: Antony Cobos
Fecha: 28 - 02 - 2024
Script: Business Logic de Clasificacion
*/

package BusinessLogic;

import java.util.ArrayList;

import DataAccess.ClasificacionDAO;
import DataAccess.DTO.ClasificacionDTO;

public class ClasificacionBL {
    private ClasificacionDTO ClasificacionDTO;
    private ClasificacionDAO ClasificacionDAO = new ClasificacionDAO();
    public ClasificacionBL(){
    }
    public boolean add(ClasificacionDTO ClasificacionDTO) throws Exception{
        return ClasificacionDAO.create(ClasificacionDTO);
    }
    public ArrayList<ClasificacionDTO> getAll()  throws Exception{
        return ClasificacionDAO.readAll();
    }
    public ClasificacionDTO getBy(Integer id) throws Exception{
        ClasificacionDTO = ClasificacionDAO.readBy(id);
        return ClasificacionDTO;
    }
    public boolean update(ClasificacionDTO ClasificacionDTO) throws Exception {
        return ClasificacionDAO.update(ClasificacionDTO);
    }

    public boolean delete(Integer id) throws Exception{
        return ClasificacionDAO.delete(id);
    }
    public int getMaxId() throws Exception{
        return ClasificacionDAO.getMaxId();
    }
    
}
