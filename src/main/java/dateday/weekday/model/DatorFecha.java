/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dateday.weekday.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Cesar Ed Lanos Dico
 */
public class DatorFecha {

    //Para año 1987
    Map<Integer, ArrayList<Integer>> anos = new HashMap<Integer, ArrayList<Integer>>();
    private List<Integer> CurrentNumerosClave = new ArrayList<Integer>();
    
    public DatorFecha() {
        ArrayList<Integer> dDias = new ArrayList<Integer>();
        dDias.add(3);dDias.add(6);dDias.add(6);dDias.add(2);dDias.add(4);dDias.add(7);
        dDias.add(2);dDias.add(5);dDias.add(1);dDias.add(3);dDias.add(4);dDias.add(1);
        anos.put(1987, dDias);
    }

    public DatorFecha(Integer ano) {
        List<Integer> numerosClave = new ArrayList<Integer>();
        if (anos.containsKey(ano)) {
            numerosClave = anos.get(ano);
        } else {
            numerosClave = anos.get(1987);
        }
        
        if (ano < 1987) {
            int anosC = 1987 - ano;
            for (int i = 0; i < numerosClave.size(); i++) {
                numerosClave.set(i, aritmeticBase7(numerosClave.get(i), anosC, 2));
            }
        }
        if (ano > 1987) {
            int anosC = ano - 1987;
            for (int i = 0; i < numerosClave.size(); i++) {
                numerosClave.set(i, aritmeticBase7(numerosClave.get(i), anosC, 1));
            }
        }
        setCurrentNumerosClave(numerosClave);
    }

    public Integer aritmeticBase7(Integer numX, Integer numY, Integer operando) {
        //El numero x se le resta el numero Y.
        // 1 para sumar, 2 para restar.
        int temp = 0;

        while (temp < numY) {
            if (operando == 1) {
                if (numX <= 7) {
                    numX = 0;
                    temp++;
                }
                numX++;
                temp++;
            }
            if (operando == 2) {
                if (numX == 0) {
                    numX = 7;
                    temp++;
                }
                numX--;
                temp++;
            }
        }
        return numX;
    }

    public Map<Integer, ArrayList<Integer>> getAnos() {
        return anos;
    }

    public void setAnos(Map<Integer, ArrayList<Integer>> anos) {
        this.anos = anos;
    }

    public List<Integer> getCurrentNumerosClave() {
        return CurrentNumerosClave;
    }

    public void setCurrentNumerosClave(List<Integer> CurrentNumerosClave) {
        this.CurrentNumerosClave = CurrentNumerosClave;
    }

}
