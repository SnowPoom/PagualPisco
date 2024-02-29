/*
|-------------------------------------|
| © 2024 EPN-FIS, All rights reserved |
| antony.cobos@epn.edu.ec             |
|-------------------------------------|
Autor: Jonathan Pagual && Christian Pisco
Fecha: 28 - 02 - 2024
Script: Clase Hormiga
*/

package BusinessLogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import DataAccess.HormigaDAO;
import DataAccess.DTO.ClasificacionDTO;
import DataAccess.DTO.HormigaDTO;

public class HormigaBL {
    private ClasificacionBL clasificacionBL = null;
    private HormigaDTO hormigaDTO;
    private HormigaDAO hormigaDAO = new HormigaDAO();
    public HormigaBL(){
    }
    public boolean add(HormigaDTO hormigaDTO) throws Exception{
        return hormigaDAO.create(hormigaDTO);
    }
    public List<HormigaDTO> getAll()  throws Exception{
        return hormigaDAO.readAll();
    }
    public HormigaDTO getBy(Integer id) throws Exception{
        hormigaDTO = hormigaDAO.readBy(id);
        return hormigaDTO;
    }
    public boolean update(HormigaDTO hormigaDTO) throws Exception {
        return hormigaDAO.update(hormigaDTO);
    }

    public boolean delete(Integer id) throws Exception{
        return hormigaDAO.delete(id);
    }
    public int getMaxId() throws Exception{
        return hormigaDAO.getMaxId();
    }

    public Integer getIdClasificacionRandom() throws Exception {
        // clasificacionBL = new ClasificacionBL();
        // ArrayList<ClasificacionDTO> clasificaciones = clasificacionBL.getAll();
        // Random random = new Random();
        // int randomIndex = random.nextInt(clasificaciones.size());
        // ClasificacionDTO clasificacionRandom = clasificaciones.get(randomIndex);
        // return clasificacionRandom.getIdClasificacion();
    
        Random random = new Random();
        int randomIndex = random.nextInt(5) + 1;
        return randomIndex;
    }
    

    public String getCodigoRandom() throws Exception {
        Random random = new Random();
        int codigo = random.nextInt(9000) + 1000;
        return String.valueOf(codigo);
    }

    public boolean tieneAntBot(Integer idClasificacion) {
        if (idClasificacion == 1 || idClasificacion == 2 || idClasificacion == 5)
            return true;
        return false;
    }
}
