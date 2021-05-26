/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.util.Hashtable;

/**
 *
 * @author Younten
 */
public class Environment {
    public static Hashtable<String,TypeValue> table = new Hashtable<>();
    
    public static void printEnvTable() {
        System.out.println("\n***** ENV TABLE VALUES *****");
        for(TypeValue value: table.values()) {
            System.out.println(value.getType().getCode() + value.getValue() + "\n");
        }
        System.out.println("***** ENV TABLE VALUES *****");
    }
    
    public void a() {
        Environment.printEnvTable();
        
        
    }
}
