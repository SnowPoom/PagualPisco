package BusinessLogic;

import java.util.ArrayList;

import DataAccess.PPHormigaClasificacionDAO;
import DataAccess.DTO.PPHormigaClasificacionDTO;

public class PPHormigaClasificacionBL {
        private PPHormigaClasificacionDAO ppHormigaClasificacionDAO = new PPHormigaClasificacionDAO();

        public PPHormigaClasificacionBL() {}
    
    public ArrayList<PPHormigaClasificacionDTO> ppReadAll() throws Exception {
        return ppHormigaClasificacionDAO.ppReadAll();
    }
}
