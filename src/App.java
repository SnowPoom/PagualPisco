import BusinessLogic.Entities.AntBot.AntBot;
import BusinessLogic.Entities.Hormiga.Hormiga;
import BusinessLogic.Entities.ProcesoReina.PPCarnivoro;
import BusinessLogic.Entities.ProcesoReina.PPProcesoReina;
import UserInterface.Form.MainForm;

public class App {
    public static void main(String[] args) throws Exception {
        // new Hormiga();
        // MainForm oForm = new MainForm("XD");
    PPProcesoReina p1=new PPProcesoReina();
    p1.ppAlimentarLarvas();
    
    }
}
