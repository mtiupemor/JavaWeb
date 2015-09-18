package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

/**
 * Clase que implementa la fucionalidad de crear una conexion a la base de datos
 * @author Alejandro López Mtz
 * @version 1.0
 */
public class UnidadConexion {
   private static Connection conexion=null;

    /**
     * Metodo que crea una conexion a la base de datos
     * @return Connection  regresa una  conexion
     */
   public static Connection getConexion(){
     try{
       if (conexion == null){
         Runtime.getRuntime().addShutdownHook(new MiClaseFinalizar());
         ResourceBundle archivoConfiguracion = ResourceBundle.getBundle("datosConexion");
         String manejador = archivoConfiguracion.getString("manejador");
         String cadenaConexion = archivoConfiguracion.getString("cadenaconexion");
         String clave = archivoConfiguracion.getString("clave");
         String usuario = archivoConfiguracion.getString("usuario");
         System.out.println(manejador);
         System.out.println(cadenaConexion);
         System.out.println(clave);
         System.out.println(usuario);

         Class.forName(manejador);
         conexion = DriverManager.getConnection(cadenaConexion,usuario,clave);
       }
       return conexion;
     }catch(Exception e){
       e.printStackTrace();
       throw new RuntimeException("Error al crear la conexión>",e);
     }
   }

  private static class MiClaseFinalizar extends Thread{
    @Override
    public void run(){
      try{
        Connection unaConexion = UnidadConexion.getConexion();
        unaConexion.close();
      }catch(Exception e){
        e.printStackTrace();
        throw new RuntimeException("Error al cerrar la conexión>",e);
      }
    }
  }
}
