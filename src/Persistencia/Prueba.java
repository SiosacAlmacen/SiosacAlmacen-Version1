/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.util.List;

/**
 *
 * @author ander
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
            MaterialDao s = new MaterialDaoImp();
        
            for (int i = 0; i < s.Read().size(); i++) {
                Object[]fil = (Object[]) s.Read().get(i);
                System.out.println(fil[0]+" "+fil[1]+" "+fil[2]+" "+fil[3]+" "+fil[4]+" "+fil[5]+" "+fil[6]+" "+fil[7]);
            }
        
        
    }
    
}
