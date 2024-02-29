import BusinessLogic.Entities.AntBot.AntBot;
import BusinessLogic.Entities.Hormiga.Hormiga;
import BusinessLogic.Entities.ProcesoReina.PPCarnivoro;
import BusinessLogic.Entities.ProcesoReina.PPProcesoReina;
import UserInterface.Form.MainForm;

public class App {
    public static void main(String[] args) throws Exception {
        MainForm oForm = new MainForm("ANT APP");
        PPProcesoReina p1=new PPProcesoReina();
        p1.ppAlimentarLarvas();
    }
}
