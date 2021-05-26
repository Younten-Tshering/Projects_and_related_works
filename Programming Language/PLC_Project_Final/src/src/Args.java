/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

/**
 * Consists of the Args class, it's used to represent the arguments of an expression,
 * it is passed to the constructor of the Aexp class when applicable.
 * @author Younten
 */
public class Args {
    
    private Aexp firstExp, secondExp;
    
    Args(Aexp x, Aexp y){
        firstExp = x;
        secondExp =y;
    }

    public Aexp getFirstExp() {
        return firstExp;
    }

    public Aexp getSecondExp() {
        return secondExp;
    }
    
}
