/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.EventoDto;
import dto.EventoTopeDto;
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
 * @author SChaves
 */
public class EventoTopeDAO {

  
    public boolean agregaEventoTope(EventoTopeDto evento){
    Connection unaConexion = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;

    try{
      //System.out.println(evento.getId());
      //System.out.println(evento.getHijo().getId());
      unaConexion = UnidadConexion.getConexion();
      String sentenciaSQL = "INSERT INTO eventotope(id,idarbol,nombre,valor,idhijo) VALUES(?,?,?,?,?)";
      pstm = unaConexion.prepareStatement(sentenciaSQL);
      pstm.setString(1,evento.getId());
      pstm.setString(2,evento.getIdarbol());
      pstm.setString(3, evento.getNombre());
      pstm.setDouble(4, evento.getValor());
      pstm.setString(5, evento.getHijo().getId());
      //System.out.println(pstm);
      if (pstm.executeUpdate()>0)
        return true;
      return false;
    }catch (SQLException e){
      Logger.getLogger(EventoTopeDto.class.getName()).log(Level.SEVERE, null, e);
        throw new RuntimeException(EventoTopeDto.class.getName() + " Error al obtener los datos>",e);
    }finally{
      try{
        if (rs != null)
          rs.close();
        if (pstm != null)
          pstm.close();
      }catch(Exception e){
        Logger.getLogger(EventoTopeDto.class.getName()).log(Level.SEVERE, null, e.getMessage());
        throw new RuntimeException(EventoTopeDto.class.getName() + " Error al cerrar la conexion>",e);
      }
    }
  }
    
  public EventoTopeDto obtenerObjetoEventoTope(String idPadre){
    Connection unaConexion = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
     
    try{
      unaConexion = UnidadConexion.getConexion();
      String sentenciaSQL = "SELECT * FROM eventotope WHERE id=?";
      pstm = unaConexion.prepareStatement(sentenciaSQL);
      pstm.setString(1, idPadre);
      //System.out.println("query: " + pstm);
      rs = pstm.executeQuery();
      EventoTopeDto evento = new EventoTopeDto();
      while (rs.next()){      
        
        evento.setId(rs.getString("id"));
        evento.setNombre(rs.getString("nombre"));
        //evento.setValor(rs.getDouble("valor"));
        //eventos.setIdHijo(rs.getString("idhijo"));                
      }      
      return evento;
    }catch (SQLException e) {
        Logger.getLogger(EventoTopeDAO.class.getName()).log(Level.SEVERE, null, e);
        throw new RuntimeException(EventoTopeDAO.class.getName() + " Error al obtener los datos>",e);
    }finally{
      try{
        if (rs != null)
          rs.close();
        if (pstm != null)
          pstm.close();
      }catch(Exception e){
        Logger.getLogger(EventoTopeDAO.class.getName()).log(Level.SEVERE, null, e.getMessage());
        throw new RuntimeException(EventoTopeDAO.class.getName() + " Error al cerrar la conexion>",e);
      }
    }
  }
  
  
  public int deleteEventoTope(String arbol) {
    Connection unaConexion = null;
    PreparedStatement pstm = null;
    int rows = -1;

    try {
      unaConexion = UnidadConexion.getConexion();
      String sentenciaSQL = "DELETE from eventotope where idarbol=?";
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
