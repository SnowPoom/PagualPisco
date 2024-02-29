package BusinessLogic.Entities.AntBot;

public class TenazaAgarre {
    private int fuerzaMovimiento;
    public TenazaAgarre(){
        this.fuerzaMovimiento =100;
    }
    public String apretar(){
        return  "Tenaza Agarre Apretada";
    }
    public String  desapretar(){
        return "Tenaza Agarre Desapretada";
    }
    public int getFuerzaMovimiento() {
        return fuerzaMovimiento;
    }
    public void setFuerzaMovimiento(int fuerzaMovimiento) {
        this.fuerzaMovimiento = fuerzaMovimiento;
    }
}
