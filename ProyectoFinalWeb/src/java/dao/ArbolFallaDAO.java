/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.ArbolFallaDto;
import dto.CompuertaLogicaDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rubcer
 */
public class ArbolFallaDAO {

  public boolean agregaArbol(ArbolFallaDto arbol) {
    Connection unaConexion = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    try {
      unaConexion = UnidadConexion.getConexion();
      String sentenciaSQL = "INSERT INTO arbol(id,nombre) VALUES(?,?)";
      pstm = unaConexion.prepareStatement(sentenciaSQL);
      pstm.setString(1, arbol.getId());
      pstm.setString(2, arbol.getNombre());
      System.out.println(pstm);
      if (pstm.executeUpdate() > 0) {
        return true;
      }
      return false;
    } catch (SQLException e) {
      Logger.getLogger(ArbolFallaDto.class.getName()).log(Level.SEVERE, null, e);
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
        Logger.getLogger(ArbolFallaDto.class.getName()).log(Level.SEVERE, null, e.getMessage());
        throw new RuntimeException(ArbolFallaDto.class.getName() + " Error al cerrar la conexion>", e);
      }

    }
  }

  public boolean agregaArbolGrafico(ArbolFallaDto arbol) {
    Connection unaConexion = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    try {
      unaConexion = UnidadConexion.getConexion();
      String sentenciaSQL = "INSERT INTO arbolgrafico(id,estructura) VALUES(?,?)";
      pstm = unaConexion.prepareStatement(sentenciaSQL);
      pstm.setString(1, arbol.getId());
      pstm.setString(2, arbol.getEstructura());
      if (pstm.executeUpdate() > 0) {
        return true;
      }
      return false;
    } catch (SQLException e) {
      Logger.getLogger(ArbolFallaDto.class.getName()).log(Level.SEVERE, null, e);
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
        Logger.getLogger(ArbolFallaDto.class.getName()).log(Level.SEVERE, null, e.getMessage());
        throw new RuntimeException(ArbolFallaDto.class.getName() + " Error al cerrar la conexion>", e);
      }

    }
  }

  public boolean agregaArbolLogico(ArbolFallaDto arbol) {
    Connection unaConexion = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    try {
      unaConexion = UnidadConexion.getConexion();
      String sentenciaSQL = "INSERT INTO arbollogico(id,ideventoini) VALUES(?,?)";
      pstm = unaConexion.prepareStatement(sentenciaSQL);
      pstm.setString(1, arbol.getId());
      pstm.setString(2, arbol.getEventoTope().getId());
      if (pstm.executeUpdate() > 0) {
        return true;
      }
      return false;
    } catch (SQLException e) {
      Logger.getLogger(ArbolFallaDto.class.getName()).log(Level.SEVERE, null, e);
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
        Logger.getLogger(ArbolFallaDto.class.getName()).log(Level.SEVERE, null, e.getMessage());
        throw new RuntimeException(ArbolFallaDto.class.getName() + " Error al cerrar la conexion>", e);
      }

    }
  }

  public boolean getArbolFalla(String arbol) {
    Connection unaConexion = null;
    Statement stm = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    boolean exit = false;

    try {
      unaConexion = UnidadConexion.getConexion();
      String sentenciaSQL = "SELECT * FROM arbol where id=?";
      pstm = unaConexion.prepareStatement(sentenciaSQL);
      pstm.setString(1, arbol);
      rs = pstm.executeQuery();
      while (rs.next()) {
        exit = true;
      }
      return exit;
    } catch (SQLException e) {
      Logger.getLogger(ArbolFallaDAO.class.getName()).log(Level.SEVERE, null, e);
      throw new RuntimeException(ArbolFallaDAO.class.getName() + " Error al obtener los datos>", e);
    } finally {
      try {
        if (rs != null) {
          rs.close();
        }
        if (pstm != null) {
          pstm.close();
        }
      } catch (Exception e) {
        Logger.getLogger(ArbolFallaDAO.class.getName()).log(Level.SEVERE, null, e.getMessage());
        throw new RuntimeException(ArbolFallaDAO.class.getName() + " Error al cerrar la conexion>", e);
      }
    }
  }

  public String getEstructuraArbolFalla(String arbol) {
    Connection unaConexion = null;
    Statement stm = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    String exit = "";

    try {
      unaConexion = UnidadConexion.getConexion();
      String sentenciaSQL = "SELECT estructura FROM arbolgrafico where id=?";
      pstm = unaConexion.prepareStatement(sentenciaSQL);
      pstm.setString(1, arbol);
      rs = pstm.executeQuery();
      while (rs.next()) {
        exit = rs.getString("estructura");
      }
      return exit;
    } catch (SQLException e) {
      Logger.getLogger(ArbolFallaDAO.class.getName()).log(Level.SEVERE, null, e);
      throw new RuntimeException(ArbolFallaDAO.class.getName() + " Error al obtener los datos>", e);
    } finally {
      try {
        if (rs != null) {
          rs.close();
        }
        if (pstm != null) {
          pstm.close();
        }
      } catch (Exception e) {
        Logger.getLogger(ArbolFallaDAO.class.getName()).log(Level.SEVERE, null, e.getMessage());
        throw new RuntimeException(ArbolFallaDAO.class.getName() + " Error al cerrar la conexion>", e);
      }
    }
  }

  
    public int deleteArbolFalla(String arbol) {
    Connection unaConexion = null;
    PreparedStatement pstm = null;
    int rows = -1;

    try {
      unaConexion = UnidadConexion.getConexion();
      String sentenciaSQL = "DELETE from arbol where id=?";
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

  
  public int deleteArbolFallaLogico(String arbol) {
    Connection unaConexion = null;
    PreparedStatement pstm = null;
    int rows = -1;

    try {
      unaConexion = UnidadConexion.getConexion();
      String sentenciaSQL = "DELETE from arbollogico where id=?";
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

  public int deleteArbolFallaGrafico(String arbol) {
    Connection unaConexion = null;
    PreparedStatement pstm = null;
    int rows = -1;

    try {
      unaConexion = UnidadConexion.getConexion();
      String sentenciaSQL = "DELETE from arbolgrafico where id=?";
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
