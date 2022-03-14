/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases.MenorTiempoRestante;

/**
 *
 * @author marcotulio
 */
public class Proceso {
    
    private int identificador;
    private String alias;
    private int tiempoLlegada;
    private int tiempoAQuemar;
    private int tiempoCompletacion;
    private int tiempoRespuesta;
    private int tiempoEsperado;
    private int tiempoQuemado;

    public Proceso(int identificador, String alias, int tiempoLlegada, int tiempoAQuemar) {
        this.identificador = identificador;
        this.alias = alias;
        this.tiempoLlegada = tiempoLlegada;
        this.tiempoAQuemar = tiempoAQuemar;
        this.tiempoQuemado = 0;
    }

    public String getIdentificador() {
        return alias;
    }

    public void setIdentificador(int Identificador) {
        this.identificador = Identificador;
    }

    public int getTiempoLlegada() {
        return tiempoLlegada;
    }

    public void setTiempoLlegada(int tiempoLlegada) {
        this.tiempoLlegada = tiempoLlegada;
    }

    public int getTiempoAQuemar() {
        return tiempoAQuemar;
    }

    public void setTiempoAQuemar(int tiempoAQuemar) {
        this.tiempoAQuemar = tiempoAQuemar;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getTiempoCompletacion() {
        return tiempoCompletacion;
    }

    public void setTiempoCompletacion(int tiempoCompletacion) {
        this.tiempoCompletacion = tiempoCompletacion;
    }

    public int getTiempoRespuesta() {
        return tiempoRespuesta;
    }

    public void setTiempoRespuesta(int tiempoRespuesta) {
        this.tiempoRespuesta = tiempoRespuesta;
    }

    public int getTiempoEsperado() {
        return tiempoEsperado;
    }

    public void setTiempoEsperado(int tiempoEsperado) {
        this.tiempoEsperado = tiempoEsperado;
    }

    public int getTiempoQuemado() {
        return tiempoQuemado;
    }

    public void setTiempoQuemado(int tiempoQuemado) {
        this.tiempoQuemado = tiempoQuemado;
    }
    
    public int getTiempoRestante(){
        return this.tiempoAQuemar - this.tiempoQuemado;
    }
    
    public void quemarTiempo(){
        this.tiempoQuemado = this.tiempoQuemado + 1;
    }
}
