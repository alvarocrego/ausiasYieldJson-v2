/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author al037877
 */
public class Contexto {
    private HashMap<String, String> parameters;

    //private ArrayList<FilterBean> alFilter;
    //private HashMap<String, String> hmOrder;

    private String vista;

    private Object parametro;

    //private Boolean haySesion;
    //private UsuarioBean userBeanSession;

    private Enum.Connection enumTipoConexion;
    
    private void set(String strParam, String strValue) {
        Boolean entrado = false;
        for (Map.Entry<String, String> entry : this.parameters.entrySet()) {
            if (entry.getKey().equals(strParam)) {
                entry.setValue(strValue);
                entrado = true;
            }
        }
        if (!entrado) {
            this.parameters.put(strParam, strValue);
        }
    }

    private String get(String defaultValue, String strParam) {
        String resultado = defaultValue;
        for (Map.Entry<String, String> entry : this.parameters.entrySet()) {
            if (entry.getKey().equals(strParam)) {
                resultado = entry.getValue();
            }
        }
        return resultado;
    }

    private String getExceptParams(ArrayList<String> alExcept) {
        String resultado = "";
        for (Map.Entry<String, String> entry : this.parameters.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (!value.equalsIgnoreCase("")) {
                String strParam;
                Iterator<String> iterator = alExcept.iterator();
                Boolean encontrado = false;
                while (iterator.hasNext()) {
                    strParam = iterator.next();
                    if (key.equals(strParam)) {
                        encontrado = true;
                    }
                }
                if (!encontrado) {
                    resultado += key + "=" + value + "&";
                }
            }
        }
        return resultado;
    }

    private String getExcept(String strParam1, String strParam2) {
        String resultado = "";
        for (Map.Entry<String, String> entry : this.parameters.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (!value.equalsIgnoreCase("")) {
                if (key.equals(strParam1) || key.equals(strParam2)) {
                } else {
                    resultado += key + "=" + value + "&";
                }
            }
        }
        return resultado.substring(0, resultado.length() - 1);
    }

    private String getExceptForm(String strParam1, String strParam2, String strParam3) {
        String resultado = "";
        for (Map.Entry<String, String> entry : this.parameters.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (!value.equalsIgnoreCase("")) {
                if (key.equals(strParam1) || key.equals(strParam2) || key.equals(strParam3)) {
                } else {
                    resultado += "<input type=\"hidden\" name=\"" + key + "\" value=\"" + value + "\"/>";
                }
            }
        }
        return resultado;
    }
    
    public void removeParam(String strParam) {
        this.parameters.remove(strParam);
    }

    public String getClase() {
        return get("usuario", "class");
    }

    public void setClase(String strClase) {
        this.set("class", strClase);
    }

    public String getMetodo() {
        return get("ocioso", "method");
    }

    public void setMetodo(String strMetodo) {
        this.set("method", strMetodo);
    }
    
    public String getEncapsulado() {
        return get(null, "capsulated");
    }

    public void setEncapsulado(String strEncapsulado) {
        this.set("capsulated", strEncapsulado);
    }

    public String getFase() {
        return get("1", "phase");
    }

    public void setFase(String strFase) {
        this.set("phase", strFase);
    }
    
    public String getVista() {
        return vista;
    }

    public void setVista(String vista) {
        this.vista = vista;
    }

    public String getClaseRetorno() {
        return get("", "returnclass");
    }

    public void setClaseRetorno(String strClase) {
        this.set("returnclass", strClase);
    }

    public String getMetodoRetorno() {
        return get("", "returnmethod");
    }

    public void setMetodoRetorno(String strClase) {
        this.set("returnmethod", strClase);
    }

    public String getFaseRetorno() {
        return get("1", "returnphase");
    }

    public void setFaseRetorno(String strClase) {
        this.set("returnphase", strClase);
    }

    public Object getParametro() {
        return parametro;
    }

    public void setParametro(Object parametro) {
        this.parametro = parametro;
    }
    
    public Enum.Connection getEnumTipoConexion() {
        return enumTipoConexion;
    }

    public void setEnumTipoConexion(Enum.Connection enumTipoConexion) {
        this.enumTipoConexion = enumTipoConexion;
    }
    
    public String getOperacion() {
        String strOperation = "";
        strOperation += Character.toUpperCase(this.getClase().charAt(0)) + this.getClase().substring(1);
        strOperation += Character.toUpperCase(this.getMetodo().charAt(0)) + this.getMetodo().substring(1);
        strOperation += this.getFase();
        return strOperation;
    }
    
    public void setParameters(HashMap<String, String> parameters) {
        this.parameters = parameters;
    }
}
