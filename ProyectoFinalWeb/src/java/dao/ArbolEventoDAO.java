/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.ArbolEventoDto;
import dto.ArbolFallaDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author SChaves
 */
public class ArbolEventoDAO {

  private boolean error;
  private String errorS;

  public ArbolEventoDAO() {
    error = false;
    errorS = "";
  }

  //public boolean agregaArbol(ArbolFallaDto arbol) {
  public boolean agregaArbolEvento(String arbol, String nombre) {
    Connection unaConexion = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    try {
      unaConexion = UnidadConexion.getConexion();
      String sentenciaSQL = "INSERT INTO arbolevento(id,nombre) VALUES(?,?)";
      pstm = unaConexion.prepareStatement(sentenciaSQL);
      pstm.setString(1, arbol);
      pstm.setString(2, nombre);
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

  public boolean agregaArbolEventoGrafico(String arbol, String estructura) {
    Connection unaConexion = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    try {
      unaConexion = UnidadConexion.getConexion();
      String sentenciaSQL = "INSERT INTO arbolgraficoevento(id,estructura) VALUES(?,?)";
      pstm = unaConexion.prepareStatement(sentenciaSQL);
      pstm.setString(1, arbol);
      pstm.setString(2, estructura);
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

  public boolean agregaArbolEventoLogico(ArbolEventoDto arbol) {
    Connection unaConexion = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    try {
      unaConexion = UnidadConexion.getConexion();
      String sentenciaSQL = "INSERT INTO arbollogicoevento(id,ideventoini,idsistema) VALUES(?,?,?)";
      pstm = unaConexion.prepareStatement(sentenciaSQL);
      pstm.setString(1, arbol.getId());
      pstm.setString(2, arbol.getEventoIniciador().getId());
      pstm.setString(3, arbol.getSistema().getId());
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

  public boolean getArbolEvento(String arbol) {
    Connection unaConexion = null;
    Statement stm = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    boolean exit = false;

    try {
      unaConexion = UnidadConexion.getConexion();
      String sentenciaSQL = "SELECT * FROM arbolevento where id=?";
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

  public boolean getArbolEventoLogico(String arbol) {
    Connection unaConexion = null;
    Statement stm = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    boolean exit = false;

    try {
      unaConexion = UnidadConexion.getConexion();
      String sentenciaSQL = "SELECT * FROM arbollogicoevento where id=?";
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

  public String getInfoArbolEvento(String arbol, int opc) {
    Connection unaConexion = null;
    Statement stm = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    String exit = "";

    try {
      String sentenciaSQL = "";
      unaConexion = UnidadConexion.getConexion();
      switch (opc) {
        case 1:
          sentenciaSQL = "SELECT ideventoini FROM arbollogicoevento where id=?";
          break;
        case 2:
          sentenciaSQL = "SELECT idsistema FROM arbollogicoevento where id=?";
          break;
      }

      pstm = unaConexion.prepareStatement(sentenciaSQL);
      pstm.setString(1, arbol);
      rs = pstm.executeQuery();
      while (rs.next()) {
        switch (opc) {
          case 1:
            exit = rs.getString("ideventoini");
            break;
          case 2:
            exit = rs.getString("idsistema");
            break;
        }        
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
    return exit;
  }

  public String getEstructuraArbolEvento(String arbol) {
    Connection unaConexion = null;
    Statement stm = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    String exit = null;

    try {
      unaConexion = UnidadConexion.getConexion();
      String sentenciaSQL = "SELECT estructura FROM arbolgraficoevento where id=?";
      pstm = unaConexion.prepareStatement(sentenciaSQL);
      pstm.setString(1, arbol);
      rs = pstm.executeQuery();
      while (rs.next()) {
        exit = rs.getString("estructura");
      }
      error = false;
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

  public int deleteArbolEvento(String arbol) {
    Connection unaConexion = null;
    PreparedStatement pstm = null;
    int rows = -1;

    try {
      unaConexion = UnidadConexion.getConexion();
      String sentenciaSQL = "DELETE from arbolevento where id=?";
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

  public int deleteArbolEventoLogico(String arbol) {
    Connection unaConexion = null;
    PreparedStatement pstm = null;
    int rows = -1;

    try {
      unaConexion = UnidadConexion.getConexion();
      String sentenciaSQL = "DELETE from arbollogicoevento where id=?";
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

  public int deleteArbolEventoGrafico(String arbol) {
    Connection unaConexion = null;
    PreparedStatement pstm = null;
    int rows = -1;

    try {
      unaConexion = UnidadConexion.getConexion();
      String sentenciaSQL = "DELETE from arbolgraficoevento where id=?";
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

  public int updateArbolEvento(String arbol, String nombre) {
    Connection unaConexion = null;
    PreparedStatement pstm = null;
    int rows = -1;

    try {
      unaConexion = UnidadConexion.getConexion();
      String sentenciaSQL = "UPDATE arbolevento SET nombre=?  where id=?";
      pstm = unaConexion.prepareStatement(sentenciaSQL);
      pstm.setString(1, nombre);
      pstm.setString(5, arbol);
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
