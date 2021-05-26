/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.util.ArrayList;
/**
 *
 * @author csim
 */
public class ParseTree {
    private ArrayList<ParseTree> nodes = new ArrayList<>();
    private String token;
    private int lexeme;
    private int level;
    private String type;
    public ParseTree(){
        
    }
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return type;
    }
    public ArrayList<ParseTree> getNodes(){
        return nodes;
    }
    public void setToken(String token){
        this.token = token;
    }
    public void setLexeme(int lexeme){
        this.lexeme = lexeme;
    }
    public void setNodes(ArrayList<ParseTree> nodes){
        this.nodes = nodes;
    }
    public void setLevel(int level){
        this.level = level;
    }
    public String getToken(){
        return token;
    }
    public int getLexeme(){
        return lexeme;
    }
    public int getLevel(){
        return level;
    }
}
