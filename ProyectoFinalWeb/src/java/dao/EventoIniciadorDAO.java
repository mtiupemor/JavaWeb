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

  private boolean error;
  private String errorS;

  public boolean agregaEventoIniciador(EventoIniciadorDto evento) {
    Connection unaConexion = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    try {
      unaConexion = UnidadConexion.getConexion();
      String sentenciaSQL = "INSERT INTO eventoiniciador(id,idarbol,nombre,valor) VALUES(?,?,?,?)";
      pstm = unaConexion.prepareStatement(sentenciaSQL);
      pstm.setString(1, evento.getId());
      pstm.setString(2, evento.getIdarbol());
      pstm.setString(3, evento.getNombre());
      pstm.setDouble(4, evento.getValor());

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

  public EventoIniciadorDto obtenerObjetoEventoIniciador(String idPadre) {
    EventoIniciadorDto evento = new EventoIniciadorDto();
    Connection unaConexion = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;

    try {
      unaConexion = UnidadConexion.getConexion();
      String sentenciaSQL = "SELECT * FROM eventoiniciador WHERE id=?";
      pstm = unaConexion.prepareStatement(sentenciaSQL);
      pstm.setString(1, idPadre);
      //System.out.println("query: " + pstm);
      rs = pstm.executeQuery();

      while (rs.next()) {
        evento.setId(rs.getString("id"));
        evento.setNombre(rs.getString("nombre"));
        evento.setValor(rs.getDouble("valor"));
        evento.setIdarbol(rs.getString("idarbol"));
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

  public Collection<EventoIniciadorDto> obtenerEventoIniciador(String idPadre) {
    Connection unaConexion = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;

    try {
      unaConexion = UnidadConexion.getConexion();
      String sentenciaSQL = "SELECT * FROM eventoiniciador WHERE idpadre=?";
      pstm = unaConexion.prepareStatement(sentenciaSQL);
      pstm.setString(1, idPadre);
      rs = pstm.executeQuery();
      ArrayList<EventoIniciadorDto> listaEventosIniciador = new ArrayList<EventoIniciadorDto>();

      while (rs.next()) {
        EventoIniciadorDto evento = new EventoIniciadorDto();
        evento.setId(rs.getString("id"));
        evento.setNombre(rs.getString("nombre"));
        evento.setValor(rs.getDouble("valor"));

        listaEventosIniciador.add(evento);
      }
      return listaEventosIniciador;
    } catch (SQLException e) {
      Logger.getLogger(EventoIniciadorDAO.class.getName()).log(Level.SEVERE, null, e);
      throw new RuntimeException(EventoIniciadorDAO.class.getName() + " Error al obtener los datos>", e);
    } finally {
      try {
        if (rs != null) {
          rs.close();
        }
        if (pstm != null) {
          pstm.close();
        }
      } catch (Exception e) {
        Logger.getLogger(CompuertaLogicaDAO.class.getName()).log(Level.SEVERE, null, e.getMessage());
        throw new RuntimeException(CompuertaLogicaDAO.class.getName() + " Error al cerrar la conexion>", e);
      }
    }
  }

  public int deleteEventoIniciador(String arbol) {
    Connection unaConexion = null;
    PreparedStatement pstm = null;
    int rows = -1;

    try {
      unaConexion = UnidadConexion.getConexion();
      String sentenciaSQL = "DELETE from eventoiniciador where idarbol=?";
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
