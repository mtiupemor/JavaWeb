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
        return true;
      }
      return false;
    } catch (SQLException e) {
      Logger.getLogger(EventoTopeDto.class.getName()).log(Level.SEVERE, null, e);
      throw new RuntimeException(EventoTopeDto.class.getName() + " Error al obtener los datos>", e);
    } finally {
      try {
        if (rs != null) {
          rs.close();
        }
        if (pstm != null) {
          pstm.close();
        }
      } catch (Exception e) {
        Logger.getLogger(EventoTopeDto.class.getName()).log(Level.SEVERE, null, e.getMessage());
        throw new RuntimeException(EventoTopeDto.class.getName() + " Error al cerrar la conexion>", e);
      }
    }
  }

  public Collection<EventoDto> obtenerEventos(String idPadre) {
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
      ArrayList<EventoDto> listaEventos = new ArrayList<EventoDto>();

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
      Logger.getLogger(EventoDao.class.getName()).log(Level.SEVERE, null, e);
      throw new RuntimeException(EventoDao.class.getName() + " Error al obtener los datos>", e);
    } finally {
      try {
        if (rs != null) {
          rs.close();
        }
        if (pstm != null) {
          pstm.close();
        }
      } catch (Exception e) {
        Logger.getLogger(EventoDao.class.getName()).log(Level.SEVERE, null, e.getMessage());
        throw new RuntimeException(EventoDao.class.getName() + " Error al cerrar la conexion>", e);
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
