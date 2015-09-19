/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.CompuertaLogicaDto;
import dto.EventoDto;
import dto.EventoIniciadorDto;
import dto.EventoTopeDto;
import dto.ValorFueraDeRango;
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
public class EventoDao {

  private boolean error;
  private String errorS;

  public EventoDao() {
    error = false;
    errorS = "";
  }

  public boolean agregaEvento(EventoDto evento) {
    Connection unaConexion = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    try {
      unaConexion = UnidadConexion.getConexion();
      //unaConexion = Conexion.getConexion();
      //System.out.println(evento.getId());      

      String sentenciaSQL = "INSERT INTO evento(idarbol,id,nombre,valor,hijo,padre,editable,idnomenclatura) VALUES(?,?,?,?,?,?,?,?)";
      pstm = unaConexion.prepareStatement(sentenciaSQL);
      pstm.setString(1, evento.getIdarbol());
      pstm.setString(2, evento.getId());
      pstm.setString(3, evento.getNombre());
      pstm.setDouble(4, evento.getValor());
      pstm.setString(5, evento.getHijoBIS());
      pstm.setString(6, evento.getPadreBIS());
      pstm.setBoolean(7, evento.isEditable());
      pstm.setString(8, evento.getIdNomenclatura());
      //System.out.println(pstm);
      if (pstm.executeUpdate() > 0) {
        error = false;
      }
    } catch (SQLException e) {
      error = true;
      errorS = e.getMessage();
    } finally {
      try {
        if (rs != null) {
          rs.close();
        }
        if (pstm != null) {
          pstm.close();
        }
      } catch (Exception e) {
        error = true;
        errorS = e.getMessage();
      }
    }
    return error;
  }

  public Collection<EventoDto> obtenerEventos(String idPadre) {
    ArrayList<EventoDto> listaEventos = new ArrayList<EventoDto>();
    Connection unaConexion = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;

    try {
      unaConexion = UnidadConexion.getConexion();
      String sentenciaSQL = "SELECT * FROM evento WHERE padre=?";
      pstm = unaConexion.prepareStatement(sentenciaSQL);
      pstm.setString(1, idPadre);
      //System.out.println(pstm);
      rs = pstm.executeQuery();
      
      while (rs.next()) {
        EventoDto evento = new EventoDto();
        evento.setId(rs.getString("id"));
        evento.setNombre(rs.getString("nombre"));
        //evento.setValor(rs.getDouble("valor"));       
        //eventos.setPadre(rs.getString("compuerta"));
        //eventos.setPadre(rs.getBoolean("editable"));
        evento.setEditable(rs.getBoolean("editable"));
        evento.setIdNomenclatura(rs.getString("idnomenclatura"));

        listaEventos.add(evento);
      }
      return listaEventos;
    } catch (SQLException e) {
        error = true;
        errorS = e.getMessage();  
        return listaEventos;
    } finally {
      try {
        if (rs != null) {
          rs.close();
        }
        if (pstm != null) {
          pstm.close();
        }
      } catch (Exception e) {
        error = true;
        errorS = e.getMessage();
      }
    }
  }

  public int deleteEventos(String arbol) {
    Connection unaConexion = null;
    PreparedStatement pstm = null;
    int rows = -1;

    try {
      unaConexion = UnidadConexion.getConexion();
      String sentenciaSQL = "DELETE from evento where idarbol=?";
      pstm = unaConexion.prepareStatement(sentenciaSQL);
      pstm.setString(1, arbol);
      rows = pstm.executeUpdate();
      error=false;
    } catch (SQLException e) {
        error = true;
        errorS = e.getMessage();      
    } finally {
      try {
        if (pstm != null) {
          pstm.close();
        }
      } catch (Exception e) {
        error = true;
        errorS = e.getMessage();        
      }
    }
    return rows;
  }
  /**
   * @return the error
   */
  public boolean getError() {
    return error;
  }

  /**
   * @return the errorS
   */
  public String getErrorS() {
    return errorS;
  }  

}
