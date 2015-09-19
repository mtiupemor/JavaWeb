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

  private boolean error;
  private String errorS;

  public EventoTopeDAO() {
    error = false;
    errorS = "";
  }

  public boolean agregaEventoTope(EventoTopeDto evento) {
    Connection unaConexion = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;

    try {
      //System.out.println(evento.getId());
      //System.out.println(evento.getHijo().getId());
      unaConexion = UnidadConexion.getConexion();
      String sentenciaSQL = "INSERT INTO eventotope(id,idarbol,nombre,valor,idhijo) VALUES(?,?,?,?,?)";
      pstm = unaConexion.prepareStatement(sentenciaSQL);
      pstm.setString(1, evento.getId());
      pstm.setString(2, evento.getIdarbol());
      pstm.setString(3, evento.getNombre());
      pstm.setDouble(4, evento.getValor());
      pstm.setString(5, evento.getHijo().getId());
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

  public EventoTopeDto obtenerObjetoEventoTope(String idPadre) {
    EventoTopeDto evento = new EventoTopeDto();
    Connection unaConexion = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;

    try {
      unaConexion = UnidadConexion.getConexion();
      String sentenciaSQL = "SELECT * FROM eventotope WHERE id=?";
      pstm = unaConexion.prepareStatement(sentenciaSQL);
      pstm.setString(1, idPadre);
      //System.out.println("query: " + pstm);
      rs = pstm.executeQuery();

      while (rs.next()) {

        evento.setId(rs.getString("id"));
        evento.setNombre(rs.getString("nombre"));
        //evento.setValor(rs.getDouble("valor"));
        //eventos.setIdHijo(rs.getString("idhijo"));                
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
    return evento;
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
      error = false;
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
