/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.CompuertaLogicaDto;
import dto.EventoDto;
import dto.EventoIniciadorDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rubcer
 */
public class EventoIniciadorDAO {
    
    public boolean agregaEventoIniciador(EventoIniciadorDto evento){
    Connection unaConexion = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    try{
      unaConexion = UnidadConexion.getConexion();
      String sentenciaSQL = "INSERT INTO eventoiniciador(id,idarbol,nombre,valor) VALUES(?,?,?,?)";
      pstm = unaConexion.prepareStatement(sentenciaSQL);
      pstm.setString(1,evento.getId());
      pstm.setString(2,evento.getIdarbol());
      pstm.setString(3, evento.getNombre());
      pstm.setDouble(4, evento.getValor());
  
      if (pstm.executeUpdate()>0)
        return true;
      return false;
    }catch (SQLException e){
      Logger.getLogger(EventoIniciadorDto.class.getName()).log(Level.SEVERE, null, e);
        throw new RuntimeException(EventoIniciadorDto.class.getName() + " Error al obtener los datos>",e);
    }finally{
      try{
        if (rs != null)
          rs.close();
        if (pstm != null)
          pstm.close();
      }catch(Exception e){
        Logger.getLogger(EventoIniciadorDto.class.getName()).log(Level.SEVERE, null, e.getMessage());
        throw new RuntimeException(EventoIniciadorDto.class.getName() + " Error al cerrar la conexion>",e);
      }
    }
  }

     public Collection<EventoIniciadorDto> obtenerEventoIniciador(String idPadre){
    Connection unaConexion = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
     

    try{
      unaConexion = UnidadConexion.getConexion();
      String sentenciaSQL = "SELECT * FROM eventoiniciador WHERE idpadre=?";
      pstm = unaConexion.prepareStatement(sentenciaSQL);
      pstm.setString(1, idPadre);
      rs = pstm.executeQuery();
      ArrayList<EventoIniciadorDto> listaEventosIniciador = new ArrayList<EventoIniciadorDto>();

      while (rs.next()){
        EventoIniciadorDto evento = new EventoIniciadorDto();
        evento.setId(rs.getString("id"));
        evento.setNombre(rs.getString("nombre"));
        evento.setValor(rs.getDouble("valor"));
  

        listaEventosIniciador.add(evento);
      }
      return listaEventosIniciador;
    }catch (SQLException e) {
        Logger.getLogger(EventoIniciadorDAO.class.getName()).log(Level.SEVERE, null, e);
        throw new RuntimeException(EventoIniciadorDAO.class.getName() + " Error al obtener los datos>",e);
    }finally{
      try{
        if (rs != null)
          rs.close();
        if (pstm != null)
          pstm.close();
      }catch(Exception e){
        Logger.getLogger(CompuertaLogicaDAO.class.getName()).log(Level.SEVERE, null, e.getMessage());
        throw new RuntimeException(CompuertaLogicaDAO.class.getName() + " Error al cerrar la conexion>",e);
      }
    }
  }
    
public int deleteEventosIniciador(String arbol) {
    Connection unaConexion = null;
    PreparedStatement pstm = null;
    int rows = -1;

    try {
      unaConexion = UnidadConexion.getConexion();
      String sentenciaSQL = "DELETE from eventoiniciador where idarbol=?";
      pstm = unaConexion.prepareStatement(sentenciaSQL);
      pstm.setString(1, arbol);
      rows = pstm.executeUpdate();
    } catch (SQLException e) {
      Logger.getLogger(ArbolFallaDAO.class.getName()).log(Level.SEVERE, null, e);
      throw new RuntimeException(ArbolFallaDAO.class.getName() + " Error al obtener los datos>", e);
    } finally {
      try {
        if (pstm != null) {
          pstm.close();
        }
      } catch (Exception e) {
        Logger.getLogger(ArbolFallaDAO.class.getName()).log(Level.SEVERE, null, e.getMessage());
        throw new RuntimeException(ArbolFallaDAO.class.getName() + " Error al cerrar la conexion>", e);
      }
    }
    return rows;
  }    
    
}
    