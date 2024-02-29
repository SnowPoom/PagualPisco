package BusinessLogic.Entities.IABot;

import BusinessLogic.Entities.ProcesoReina.PPAlimento;
import BusinessLogic.Entities.ProcesoReina.PPCarnivoro;

public  class IABot implements PPIIA {
    // Singleton Pattern
    private static IABot instance;
    private static String nombre;

    // hacer el constructor privado para evitar la inicializado
    public IABot() { }
    protected IABot(IABot iaBot) { 
        if (iaBot != null)
            instance = iaBot;
    }

    public static IABot getInstance(String nombre) {
        if (instance == null){
            instance = new IABot();
            instance.setNombre(nombre);
        }
        return instance;
    }

    public String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public boolean ppBuscar(PPCarnivoro ppAlimento) {
        if(ppAlimento.toString().equals("Carnivoro")){
            return true;
        }else{
            return false;
        }
    }
}
