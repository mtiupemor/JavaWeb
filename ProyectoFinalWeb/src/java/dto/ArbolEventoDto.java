/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author lirio
 */
public class ArbolEventoDto {
    private String id;
    private String nombre;
    private EventoIniciadorDto eventoIniciador;

    private SistemaDto sistema;

    public ArbolEventoDto(){
    sistema = new SistemaDto();
    }
    
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the eventoIniciador
     */
    public EventoIniciadorDto getEventoIniciador() {
        return eventoIniciador;
    }

    /**
     * @param eventoIniciador the eventoIniciador to set
     */
    public void setEventoIniciador(EventoIniciadorDto eventoIniciador) {
        this.eventoIniciador = eventoIniciador;
    }

    /**
     * @return the sistema
     */
    public SistemaDto getSistema() {
        return sistema;
    }

    /**
     * @param sistema the sistema to set
     */
    public void setSistema(SistemaDto sistema) {
        sistema.setFrecuencia(this.eventoIniciador.getValor()*sistema.getArbolFalla().getEventoTope().getValor());
        sistema.setValorExito(this.eventoIniciador.getValor()*(1-sistema.getArbolFalla().getEventoTope().getValor()));
        this.sistema = sistema;
    }
    
}
