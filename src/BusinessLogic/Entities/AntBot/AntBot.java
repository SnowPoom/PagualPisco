/*
|-------------------------------------|
| © 2024 EPN-FIS, All rights reserved |
| antony.cobos@epn.edu.ec             |
|-------------------------------------|
Autor: Jonathan Pagual && Christian Pisco
Fecha: 28 - 02 - 2024
Script: Clase Hormiga
*/

package BusinessLogic.Entities.AntBot;

import BusinessLogic.AntBotBL;
import DataAccess.AntBotDAO;
import DataAccess.DTO.AntBotDTO;
import DataAccess.DTO.HormigaDTO;

public class AntBot implements ITecnicoRuso, ITenicoIngles {
    private AntBotBL antBotBL = new AntBotBL();
    private Integer idAntBot;
    private AntenaContacto antenaIzq;
    private AntenaContacto antenaDer;
    private Camara camara;
    private SensorOptico sensorOptico;
    private TenazaAgarre tenazaIzq;
    private TenazaAgarre tenazaDer;
    private TransductorFlexion izqDelante;
    private TransductorFlexion izqMedio;
    private TransductorFlexion izqAtras;
    private TransductorFlexion derDelante;
    private TransductorFlexion derMedio;
    private TransductorFlexion derAtras;
    private Procesador procesador;
    private CircuitoCarga circuitoCarga;
    private RadioComunicacion radioComunicacion;
    private CircuitoAnillado circuitoAnillado;
    
    private Tronco tronco;
    AntBotDTO antBotDTO = null;
    
    public AntBot() {}

    public AntBot(Integer idClasificacion, HormigaDTO idHormigaDTO) throws Exception {
        setIdAntBot(idHormigaDTO.getIdHormiga());
        antenaIzq=      new AntenaContacto();
        antenaDer=      new AntenaContacto(); 
        camara=         new  Camara();
        sensorOptico=   new SensorOptico(); 
        tenazaIzq=      new TenazaAgarre();
        tenazaDer=      new TenazaAgarre();
        izqDelante=     new TransductorFlexion(); 
        izqMedio=       new TransductorFlexion();
        izqAtras=       new TransductorFlexion();
        derDelante=     new TransductorFlexion(); 
        derMedio=       new TransductorFlexion(); 
        derAtras=       new TransductorFlexion(); 
        procesador=     new Procesador();
        circuitoCarga=  new  CircuitoCarga();
        radioComunicacion=new RadioComunicacion();
        circuitoAnillado=new CircuitoAnillado();
        tronco=new Tronco();
        if(idClasificacion==5)
            tronco.agregarAlas(true);
        antBotBL.add(antBotDTO);
    }

    public Integer getIdAntBot() throws Exception {
        return idAntBot;
    }

    public void setIdAntBot(Integer idAntBot) throws Exception {
        idAntBot = antBotDTO.getIdAntBot();
    }

    @Override
    public void traducirRusoIngles() {
        System.out.println("Aprendiendo Ingles");
        ;
    }
    
    @Override
    public void traducirRusoTecnico() {
        System.out.println("Aprendiendo Ruso");
    }
    
    public AntenaContacto getAntenaIzq() {
        return antenaIzq;
    }

    public void setAntenaIzq(AntenaContacto antenaIzq) {
        this.antenaIzq = antenaIzq;
    }

    public AntenaContacto getAntenaDer() {
        return antenaDer;
    }

    public void setAntenaDer(AntenaContacto antenaDer) {
        this.antenaDer = antenaDer;
    }

    public Camara getCamara() {
        return camara;
    }

    public void setCamara(Camara camara) {
        this.camara = camara;
    }

    public SensorOptico getSensorOptico() {
        return sensorOptico;
    }

    public void setSensorOptico(SensorOptico sensorOptico) {
        this.sensorOptico = sensorOptico;
    }

    public TenazaAgarre getTenazaIzq() {
        return tenazaIzq;
    }

    public void setTenazaIzq(TenazaAgarre tenazaIzq) {
        this.tenazaIzq = tenazaIzq;
    }

    public TenazaAgarre getTenazaDer() {
        return tenazaDer;
    }

    public void setTenazaDer(TenazaAgarre tenazaDer) {
        this.tenazaDer = tenazaDer;
    }

    public TransductorFlexion getIzqDelante() {
        return izqDelante;
    }

    public void setIzqDelante(TransductorFlexion izqDelante) {
        this.izqDelante = izqDelante;
    }

    public TransductorFlexion getIzqMedio() {
        return izqMedio;
    }

    public void setIzqMedio(TransductorFlexion izqMedio) {
        this.izqMedio = izqMedio;
    }

    public TransductorFlexion getIzqAtras() {
        return izqAtras;
    }

    public void setIzqAtras(TransductorFlexion izqAtras) {
        this.izqAtras = izqAtras;
    }

    public TransductorFlexion getDerDelante() {
        return derDelante;
    }

    public void setDerDelante(TransductorFlexion derDelante) {
        this.derDelante = derDelante;
    }

    public TransductorFlexion getDerMedio() {
        return derMedio;
    }

    public void setDerMedio(TransductorFlexion derMedio) {
        this.derMedio = derMedio;
    }

    public TransductorFlexion getDerAtras() {
        return derAtras;
    }

    public void setDerAtras(TransductorFlexion derAtras) {
        this.derAtras = derAtras;
    }

    public Procesador getProcesador() {
        return procesador;
    }

    public void setProcesador(Procesador procesador) {
        this.procesador = procesador;
    }

    public CircuitoCarga getCircuitoCarga() {
        return circuitoCarga;
    }

    public void setCircuitoCarga(CircuitoCarga circuitoCarga) {
        this.circuitoCarga = circuitoCarga;
    }

    public RadioComunicacion getRadioComunicacion() {
        return radioComunicacion;
    }

    public void setRadioComunicacion(RadioComunicacion radioComunicacion) {
        this.radioComunicacion = radioComunicacion;
    }

    public CircuitoAnillado getCircuitoAnillado() {
        return circuitoAnillado;
    }

    public void setCircuitoAnillado(CircuitoAnillado circuitoAnillado) {
        this.circuitoAnillado = circuitoAnillado;
    }
}
