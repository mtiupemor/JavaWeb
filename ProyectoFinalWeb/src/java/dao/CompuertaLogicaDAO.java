/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.CompuertaLogicaDto;
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
 * @author rubcer
 */
public class CompuertaLogicaDAO {

  public boolean agregaCompuertaLogica(CompuertaLogicaDto evento) {
    Connection unaConexion = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    try {
      unaConexion = UnidadConexion.getConexion();
      String sentenciaSQL = "INSERT INTO compuertalogica(id,idarbol,idpadre,tipo,valor,compuerta) VALUES(?,?,?,?,?,?)";
      pstm = unaConexion.prepareStatement(sentenciaSQL);
      pstm.setString(1, evento.getId());
      pstm.setString(2, evento.getIdarbol());
      pstm.setString(3, getIdObject(evento));
      pstm.setString(4, evento.getTipo().toString());
      pstm.setDouble(5, evento.getValor());
      pstm.setString(6, evento.getId());
      if (pstm.executeUpdate() > 0) {
        return true;
      }
      return false;
    } catch (SQLException e) {
      Logger.getLogger(CompuertaLogicaDto.class.getName()).log(Level.SEVERE, null, e);
      throw new RuntimeException(CompuertaLogicaDto.class.getName() + " Error al obtener los datos>", e);
    } finally {
      try {
        if (rs != null) {
          rs.close();
        }
        if (pstm != null) {
          pstm.close();
        }
      } catch (Exception e) {
        Logger.getLogger(CompuertaLogicaDto.class.getName()).log(Level.SEVERE, null, e.getMessage());
        throw new RuntimeException(CompuertaLogicaDto.class.getName() + " Error al cerrar la conexion>", e);
      }
    }
  }

  private String getIdObject(CompuertaLogicaDto evento) {
    String id = "";

    if (evento.getPadre() instanceof CompuertaLogicaDto) {
      id = ((CompuertaLogicaDto) evento.getPadre()).getId();
    }
    if (evento.getPadre() instanceof EventoDto) {
      id = ((EventoDto) evento.getPadre()).getId();
    }
    if (evento.getPadre() instanceof EventoTopeDto) {
      id = ((EventoTopeDto) evento.getPadre()).getId();
    }
    return id;
  }
  
  public Collection<CompuertaLogicaDto> obtenerCompuertasLogicas(String idPadre){
    Connection unaConexion = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;  
    //System.out.println(idPadre);
    try{
      unaConexion = UnidadConexion.getConexion();
      String sentenciaSQL = "SELECT * FROM compuertalogica WHERE idpadre=?";
      pstm = unaConexion.prepareStatement(sentenciaSQL);
      pstm.setString(1, idPadre);
      //System.out.println(pstm);
      rs = pstm.executeQuery();
      ArrayList<CompuertaLogicaDto> listasCompuertaLogicas = new ArrayList<CompuertaLogicaDto>();

      while (rs.next()){
        CompuertaLogicaDto compuerta = new CompuertaLogicaDto();
        compuerta.setId(rs.getString("id"));
        //compuerta.setIdPadre(rs.getString("idpadre"));
        compuerta.setTipo(rs.getString("tipo"));
        compuerta.setValor(rs.getDouble("valor"));
        //compuerta.setCompuerta(rs.getString("compuerta"));

        listasCompuertaLogicas.add(compuerta);
      }
      return listasCompuertaLogicas;
    }catch (SQLException e) {
        Logger.getLogger(CompuertaLogicaDAO.class.getName()).log(Level.SEVERE, null, e);
        throw new RuntimeException(CompuertaLogicaDAO.class.getName() + " Error al obtener los datos>",e);
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
  
public int deleteCompuertasLogicas(String arbol) {
    Connection unaConexion = null;
    PreparedStatement pstm = null;
    int rows = -1;

    try {
      unaConexion = UnidadConexion.getConexion();
      String sentenciaSQL = "DELETE from compuertalogica where idarbol=?";
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

