/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.logica;

import dao.CompuertaLogicaDAO;
import dto.CompuertaLogicaDto;
import dto.EventoDto;
import dto.EventoTopeDto;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author SChaves
 */
public class AnalizaObjetoJSON {

  public void analizaJSON(Object nodo, JSONObject obj, String raiz) {
    System.out.println("raiz: " + raiz);
    if (obj != null) {
      String r;
      System.out.println("inicio:" + obj);
      if (raiz =="EventoDto"){
        r=raiz;
      }else{
        r = obj.getJSONObject(raiz).getString("class");
      }
      System.out.println(r);
      if (!(r.isEmpty())) {
        //System.out.println("objeto:" + r);
        switch (r) {
          case "EventoTope":
            //System.out.println(obj.toString());
            EventoTopeDto et = new EventoTopeDto();
            et.setId(obj.getJSONObject(raiz).getString("id"));
            //cLog.setIdarbol(obj.getJSONObject(raiz).getString("padre"));
            et.setValor(obj.getJSONObject(raiz).getDouble("valor"));
            //et.se((EventoTopeDto) nodo);          

            String m = obj.getJSONObject(raiz).toString();
            //JSONObject jet = new JSONObject("{\"CompuertaLogica\":" +m + "}");
            JSONObject jet = new JSONObject(m);
            analizaJSON(et, jet, "Compuerta");
            /*
             System.out.println(obj.getJSONObject(raiz).getString("id"));
             JSONArray arrE = obj.getJSONObject(raiz).getJSONArray("EventoDto");          
             if (arrE.length() > 0) {
             for (int i = 0; i < arrE.length(); i++) {
             //String vE = arrE.getJSONObject(i).getString("id");
             String vE = arrE.getJSONObject(i).toString();
             //System.out.println(vE);
             System.out.println(vE);
             JSONObject jvE = new JSONObject("{\"EventoDto\":" + vE + "}");
             //JSONObject x = new JSONObject(vE);
             analizaJSON(et, jvE, "EventoDto");
             }
             }
             */
            /*
             System.out.println("my compuertas");
             JSONArray arrC = obj.getJSONObject(raiz).getJSONArray("Compuerta");
             System.out.println(arrC);
             for (int i = 0; i < arrC.length(); i++) {
             //String vC = arrC.getJSONObject(i).getString("id");
             String vC = arrC.getJSONObject(i).toString();
             System.out.println(vC);
             System.out.println(vC);
             JSONObject jvC = new JSONObject("{\"Compuerta\":" + vC + "}");
             analizaJSON(et, jvC, "Compuerta");
             }
             */
            break;

          case "EventoDto":
            //System.out.println(obj.toString());
            //System.out.println(obj.toString());
            System.out.println("panda");
            EventoDto eve = new EventoDto();
            eve.setId(obj.getJSONObject(raiz).getString("id"));
            eve.setIdarbol(obj.getJSONObject(raiz).getString("padre"));
            //eve.setValor(obj.getJSONObject(raiz).getDouble("valor"));
            eve.setPadre((CompuertaLogicaDto) nodo);
            //System.out.println("panda");
            JSONArray arrC2 = obj.getJSONObject(raiz).getJSONArray("Compuerta");
            
            //System.out.println(arrC2);
            if (arrC2.length() > 0) {
              System.out.println("panda compuerta");
              for (int i = 0; i < arrC2.length(); i++) {
                String he = arrC2.getJSONObject(i).toString();
              //System.out.println(vC);
                //System.out.println(he);
                //JSONObject jvE = new JSONObject("{\"CompuertaLogica\":" + he + "}");
                JSONObject jvE = new JSONObject(he);
                //JSONObject x = new JSONObject(vE);
                analizaJSON(eve, jvE, "Compuerta");
              }
            }

            /*
             JSONArray arrE2 = obj.getJSONObject(raiz).getJSONArray("hijosEventos");
             if (arrE2.length() > 0) {
             for (int i = 0; i < arrE2.length(); i++) {
             //String vE = arrE.getJSONObject(i).getString("id");
             String vE2 = arrE2.getJSONObject(i).toString();
             //System.out.println(vE);
             System.out.println(vE2);
             JSONObject jvE2 = new JSONObject("{\"hijosEventos\":" + vE2 + "}");
             //JSONObject x = new JSONObject(vE);
             analizaJSON(cLog, jvE2, "hijosEventos");
             }
             }          
             */
            break;

          case "Compuerta":

            //System.out.println(obj.toString());
            CompuertaLogicaDto cLog3 = new CompuertaLogicaDto();
            cLog3.setId(obj.getJSONObject(raiz).getString("id"));
            cLog3.setIdarbol(obj.getJSONObject(raiz).getString("padre"));
            cLog3.setValor(obj.getJSONObject(raiz).getDouble("valor"));

            if (nodo instanceof CompuertaLogicaDto) {
              cLog3.setPadre((CompuertaLogicaDto) nodo);
            }
            if (nodo instanceof EventoDto) {
              cLog3.setPadre((EventoDto) nodo);
            }
            if (nodo instanceof EventoTopeDto) {
              cLog3.setPadre((EventoTopeDto) nodo);
            }

            JSONArray arrE3 = obj.getJSONObject(raiz).getJSONArray("EventoDto");
            //System.out.println("eve: " + arrE3);
            if (arrE3.length() > 0) {
              
              for (int i = 0; i < arrE3.length(); i++) {
                System.out.println("my eventos");
                //String vE = arrE.getJSONObject(i).getString("id");
                String vE3 = arrE3.getJSONObject(i).toString();
                //System.out.println(vE);
                //System.out.println(vE3);
                //JSONObject jvE3 = new JSONObject("{\"EventoDto\":" + vE3 + "}");
                JSONObject jvE3 = new JSONObject(vE3);
                //JSONObject x = new JSONObject(vE);
                analizaJSON(cLog3, jvE3, "EventoDto");
              }
            }

            JSONArray arrC3 = obj.getJSONObject(raiz).getJSONArray("Compuerta");
            //System.out.println("comp: " + arrC3);
            if (arrC3.length() > 0) {
              System.out.println("my compuertas");
              for (int i = 0; i < arrC3.length(); i++) {
                //String vC = arrC.getJSONObject(i).getString("id");
                String vC3 = arrC3.getJSONObject(i).toString();
                //System.out.println(vC);
                //System.out.println(vC3);
                //JSONObject jvC3 = new JSONObject("{\"Compuerta\":" + vC3 + "}");
                JSONObject jvC3 = new JSONObject(vC3);
                analizaJSON(cLog3, jvC3, "Compuerta");
              }
            }
            break;
        }
      }
    }
  }

}
