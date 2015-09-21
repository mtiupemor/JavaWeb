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

  private boolean error;
  private String errorS;

  public CompuertaLogicaDAO() {
    error = false;
    errorS = "";
  }

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
        error = false;
      } else {
        error = true;
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

  public Collection<CompuertaLogicaDto> obtenerCompuertasLogicas(String idPadre) {
    Connection unaConexion = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    ArrayList<CompuertaLogicaDto> listasCompuertaLogicas = new ArrayList<CompuertaLogicaDto>();
    //System.out.println(idPadre);
    try {
      unaConexion = UnidadConexion.getConexion();
      String sentenciaSQL = "SELECT * FROM compuertalogica WHERE idpadre=?";
      pstm = unaConexion.prepareStatement(sentenciaSQL);
      pstm.setString(1, idPadre);
      //System.out.println(pstm);
      rs = pstm.executeQuery();
      

      while (rs.next()) {
        CompuertaLogicaDto compuerta = new CompuertaLogicaDto();
        compuerta.setId(rs.getString("id"));
        //compuerta.setIdPadre(rs.getString("idpadre"));
        compuerta.setTipo(rs.getString("tipo"));
        compuerta.setValor(rs.getDouble("valor"));
        //compuerta.setCompuerta(rs.getString("compuerta"));
        listasCompuertaLogicas.add(compuerta);
        error=false;
      }
      return listasCompuertaLogicas;
    } catch (SQLException e) {
        error = true;
        errorS = e.getMessage();
        return listasCompuertaLogicas;
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

  /*
  public CompuertaLogicaDto getObjetoCompuertasLogicas(String id) {
    Connection unaConexion = null;
    PreparedStatement pstm = null;
    //CompuertaLogicaDto cl= new CompuertaLogicaDto();
    ResultSet rs = null;    
    //System.out.println(idPadre);
    try {
      unaConexion = UnidadConexion.getConexion();
      String sentenciaSQL = "SELECT * FROM compuertalogica WHERE id=?";
      pstm = unaConexion.prepareStatement(sentenciaSQL);
      pstm.setString(1, id);
      //System.out.println(pstm);
      rs = pstm.executeQuery();
      

      while (rs.next()) {
        CompuertaLogicaDto compuerta = new CompuertaLogicaDto();
        
        compuerta.setId(rs.getString("id"));
        //compuerta.setIdPadre(rs.getString("idpadre"));
        compuerta.setTipo(rs.getString("tipo"));
        compuerta.setValor(rs.getDouble("valor"));
        //compuerta.setCompuerta(rs.getString("compuerta"));
        listasCompuertaLogicas.add(compuerta);
        error=false;
      }
      return listasCompuertaLogicas;
    } catch (SQLException e) {
        error = true;
        errorS = e.getMessage();
        return listasCompuertaLogicas;
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
  */
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
