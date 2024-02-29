package BusinessLogic;

import java.util.List;

import DataAccess.AntBotDAO;
import DataAccess.DTO.AntBotDTO;

public class AntBotBL {
    private AntBotDTO AntBotDTO;
    private AntBotDAO AntBotDAO = new AntBotDAO();
    public AntBotBL(){
    }
    public boolean add(AntBotDTO AntBotDTO) throws Exception{
        return AntBotDAO.create(AntBotDTO);
    }
    public List<AntBotDTO> getAll()  throws Exception{
        return AntBotDAO.readAll();
    }
    public AntBotDTO getBy(Integer id) throws Exception{
        AntBotDTO = AntBotDAO.readBy(id);
        return AntBotDTO;
    }
    public boolean update(AntBotDTO AntBotDTO) throws Exception {
        return AntBotDAO.update(AntBotDTO);
    }

    public boolean delete(Integer id) throws Exception{
        return AntBotDAO.delete(id);
    }
    public int getMaxId() throws Exception{
        return AntBotDAO.getMaxId();
    }
    
}
