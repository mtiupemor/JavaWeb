/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.EventoTopeDto;
import dto.SistemaDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rubcer
 */
public class SistemaDAO {
     public boolean agregaEventoIniciador(SistemaDto evento){
    Connection unaConexion = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    try{
      unaConexion = UnidadConexion.getConexion();
      String sentenciaSQL = "INSERT INTO sistema(id,idarbol,nombre,idarbolfalla) VALUES(?,?,?,?)";
      pstm = unaConexion.prepareStatement(sentenciaSQL);
      pstm.setString(1,evento.getId());
      pstm.setString(2,evento.getIdarbol());
      pstm.setString(3,evento.getNombre());
      pstm.setString(4, evento.getArbolFalla().getNombre());
      if (pstm.executeUpdate()>0)
        return true;
      return false;
    }catch (SQLException e){
      Logger.getLogger(SistemaDto.class.getName()).log(Level.SEVERE, null, e);
        throw new RuntimeException(SistemaDto.class.getName() + " Error al obtener los datos>",e);
    }finally{
      try{
        if (rs != null)
          rs.close();
        if (pstm != null)
          pstm.close();
      }catch(Exception e){
        Logger.getLogger(SistemaDto.class.getName()).log(Level.SEVERE, null, e.getMessage());
        throw new RuntimeException(SistemaDto.class.getName() + " Error al cerrar la conexion>",e);
      }
    }
  }
     public Collection<SistemaDto> obtenerSistemas(String idPadre){
    Connection unaConexion = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
     

    try{
      unaConexion = UnidadConexion.getConexion();
      String sentenciaSQL = "SELECT * FROM sistema  WHERE idpadre=?";
      pstm = unaConexion.prepareStatement(sentenciaSQL);
      pstm.setString(1, idPadre);
      rs = pstm.executeQuery();
      ArrayList<SistemaDto> listaSistemas = new ArrayList<SistemaDto>();

      while (rs.next()){
        SistemaDto sistema = new SistemaDto();
        sistema.setId(rs.getString("id"));
        sistema.setNombre(rs.getString("nombre"));
        sistema.setidarbolfalla(rs.getString("idarbolfalla"));
     
        
        

        listaSistemas.add(sistema);
      }
      return listaSistemas;
    }catch (SQLException e) {
        Logger.getLogger(SistemaDAO.class.getName()).log(Level.SEVERE, null, e);
        throw new RuntimeException(SistemaDAO.class.getName() + " Error al obtener los datos>",e);
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
  
}
    

