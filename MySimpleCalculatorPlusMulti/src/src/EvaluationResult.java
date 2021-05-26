/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

/**
 *
 * @author csim
 */
public class EvaluationResult {
    public Integer value;
    public String prefix;
    public String postfix;
    public String infix;
    
    public EvaluationResult(Integer value, String prefix, String postfix, String infix){
        this.value = value;
        this.prefix = prefix;
        this.postfix = postfix;
        this.infix = infix;
    }
}
