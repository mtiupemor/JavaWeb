/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.EventoIniciadorDto;
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

  private boolean error;
  private String errorS;

  public SistemaDAO() {
    error = false;
    errorS = "";
  }

  public boolean agregaSistema(SistemaDto sistema) {
    Connection unaConexion = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    try {
      unaConexion = UnidadConexion.getConexion();
      String sentenciaSQL = "INSERT INTO sistema(id,idarbol,idpadre,nombre,arbolfalla,frecuencia,valorexito,falla,exito) VALUES(?,?,?,?,?,?,?,?,?)";
      pstm = unaConexion.prepareStatement(sentenciaSQL);
      pstm.setString(1, sistema.getId());
      pstm.setString(2, sistema.getIdarbol());
      pstm.setString(3, sistema.getIdpadre());
      pstm.setString(4, sistema.getNombre());
      pstm.setString(5, sistema.getArbolFallaBIS());
      pstm.setDouble(6, sistema.getFrecuencia());
      pstm.setDouble(7, sistema.getValorExito());
      pstm.setString(8, sistema.getFallaBIS());
      pstm.setString(9, sistema.getExitoBIS());
      //pstm.setInt(10,sistema.getFlag());
      System.out.println(pstm);
      if (pstm.executeUpdate() > 0) {
        error=false;
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

  public Collection<SistemaDto> obtenerSistemas(String idPadre) {
    ArrayList<SistemaDto> listaSistemas = new ArrayList<SistemaDto>();
    Connection unaConexion = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;

    try {
      unaConexion = UnidadConexion.getConexion();
      String sentenciaSQL = "SELECT * FROM sistema  WHERE idpadre=?";
      pstm = unaConexion.prepareStatement(sentenciaSQL);
      pstm.setString(1, idPadre);
      rs = pstm.executeQuery();
      
      while (rs.next()) {
        SistemaDto sistema = new SistemaDto();
        sistema.setId(rs.getString("id"));
        sistema.setNombre(rs.getString("nombre"));
        //sistema.setidarbolfalla(rs.getString("idarbolfalla"));

        listaSistemas.add(sistema);
      }
      return listaSistemas;
    } catch (SQLException e) {
        error = true;
        errorS = e.getMessage(); 
        return listaSistemas;
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
        errorS = e.getMessage();        }
    }    
  }

  public SistemaDto obtenerObjetoSistema(String id, String arbol) {
    SistemaDto sistema = new SistemaDto();
    Connection unaConexion = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;

    try {
      unaConexion = UnidadConexion.getConexion();
      String sentenciaSQL = "SELECT * FROM sistema WHERE id=? and idarbol=?";
      pstm = unaConexion.prepareStatement(sentenciaSQL);
      pstm.setString(1, id);
      pstm.setString(2, arbol);
      //System.out.println("query: " + pstm);
      rs = pstm.executeQuery();

      while (rs.next()) {
        sistema.setId(rs.getString("id"));
        sistema.setIdarbol(rs.getString("idarbol"));
        sistema.setNombre(rs.getString("nombre"));
        sistema.setFrecuencia(rs.getDouble("freceuncia"));
        sistema.setValorExito(rs.getDouble("valorexito"));
       // sistema.setFlag(rs.getInt("flag"));
        sistema.setTmparbol(rs.getString("arbolfalla"));
        sistema.setTmpexito(rs.getString("exito"));
        sistema.setTmpfalla(rs.getString("falla"));
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
    return sistema;
  }
  
  
  
  public int deleteSistemas(String arbol) {
    Connection unaConexion = null;
    PreparedStatement pstm = null;
    int rows = -1;

    try {
      unaConexion = UnidadConexion.getConexion();
      String sentenciaSQL = "DELETE from sistema where idarbol=?";
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
