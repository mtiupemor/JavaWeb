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

  private boolean error;
  private String errorS;

  public ArbolFallaDAO() {
    error = false;
    errorS = "";
  }

  //public boolean agregaArbol(ArbolFallaDto arbol) {
  public boolean agregaArbolFalla(String arbol, String nombre) {
    Connection unaConexion = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    try {
      unaConexion = UnidadConexion.getConexion();
      String sentenciaSQL = "INSERT INTO arbolfalla(id,nombre) VALUES(?,?)";
      pstm = unaConexion.prepareStatement(sentenciaSQL);
      pstm.setString(1, arbol);
      pstm.setString(2, nombre);
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

  public boolean agregaArbolFallaGrafico(String arbol, String estructura) {
    Connection unaConexion = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    try {
      unaConexion = UnidadConexion.getConexion();
      String sentenciaSQL = "INSERT INTO arbolgraficofalla(id,estructura) VALUES(?,?)";
      pstm = unaConexion.prepareStatement(sentenciaSQL);
      pstm.setString(1, arbol);
      pstm.setString(2, estructura);
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

  public boolean agregaArbolFallaLogico(ArbolFallaDto arbol) {
    Connection unaConexion = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    try {
      unaConexion = UnidadConexion.getConexion();
      String sentenciaSQL = "INSERT INTO arbollogicofalla(id,ideventotop) VALUES(?,?)";
      pstm = unaConexion.prepareStatement(sentenciaSQL);
      pstm.setString(1, arbol.getId());
      pstm.setString(2, arbol.getEventoTope().getId());
      System.out.println(pstm);
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

  public boolean getArbolFalla(String arbol) {
    Connection unaConexion = null;
    Statement stm = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    boolean exit = false;

    try {
      unaConexion = UnidadConexion.getConexion();
      String sentenciaSQL = "SELECT * FROM arbolfalla where id=?";
      pstm = unaConexion.prepareStatement(sentenciaSQL);
      pstm.setString(1, arbol);
      rs = pstm.executeQuery();
      while (rs.next()) {
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

  public boolean getArbolFallaLogico(String arbol) {
    Connection unaConexion = null;
    Statement stm = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    boolean exit = false;

    try {
      unaConexion = UnidadConexion.getConexion();
      String sentenciaSQL = "SELECT * FROM arbollogicofalla where id=?";
      pstm = unaConexion.prepareStatement(sentenciaSQL);
      pstm.setString(1, arbol);
      rs = pstm.executeQuery();
      while (rs.next()) {
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

  public String getEstructuraArbolFalla(String arbol) {
    Connection unaConexion = null;
    Statement stm = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    String exit = null;

    try {
      unaConexion = UnidadConexion.getConexion();
      String sentenciaSQL = "SELECT estructura FROM arbolgraficofalla where id=?";
      pstm = unaConexion.prepareStatement(sentenciaSQL);
      pstm.setString(1, arbol);
      rs = pstm.executeQuery();
      while (rs.next()) {
        exit = rs.getString("estructura");
      }
      error=false;
      return exit;
    } catch (SQLException e) {
      error = true;
      errorS = e.getMessage();
      exit = "";
      return exit;
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

  public int deleteArbolFalla(String arbol) {
    Connection unaConexion = null;
    PreparedStatement pstm = null;
    int rows = -1;

    try {
      unaConexion = UnidadConexion.getConexion();
      String sentenciaSQL = "DELETE from arbolfalla where id=?";
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

  public int deleteArbolFallaLogico(String arbol) {
    Connection unaConexion = null;
    PreparedStatement pstm = null;
    int rows = -1;

    try {
      unaConexion = UnidadConexion.getConexion();
      String sentenciaSQL = "DELETE from arbollogicofalla where id=?";
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

  public int deleteArbolFallaGrafico(String arbol) {
    Connection unaConexion = null;
    PreparedStatement pstm = null;
    int rows = -1;

    try {
      unaConexion = UnidadConexion.getConexion();
      String sentenciaSQL = "DELETE from arbolgraficofalla where id=?";
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

  public int updateArbolFalla(String arbol, String nombre) {
    Connection unaConexion = null;
    PreparedStatement pstm = null;
    int rows = -1;

    try {
      unaConexion = UnidadConexion.getConexion();
      String sentenciaSQL = "UPDATE arbolfalla SET nombre=?  where id=?";
      pstm = unaConexion.prepareStatement(sentenciaSQL);
      pstm.setString(1, nombre);
      pstm.setString(5, arbol);
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
