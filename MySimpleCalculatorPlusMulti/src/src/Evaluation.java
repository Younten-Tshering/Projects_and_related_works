/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author Younten
 */
public class Evaluation {
    private static ArrayList<String> results = new ArrayList<String>();
    
    public static ArrayList evaluate(String input){
        ArrayList<String> ans = new ArrayList<>();
        try {
            InputStream stream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
            Lexer l = new Lexer(stream);
            parser p = new parser(l);
            ParseTree resultTree = (ParseTree)p.parse().value;
            System.out.println(resultTree.getType());
            EvaluationResult result = evaluateParseTree(resultTree);
            
            if(result.prefix.equals("")){
                ans.add(result.postfix + "<Postfix>");
                ans.add(result.infix + "<Infix>");
            }
            else if (result.postfix.equals("")){
                ans.add(result.prefix + "<Prefix>");
                ans.add(result.infix + "<Infix>");                
            }
            else{
                ans.add(result.prefix + "<Prefix>");
                ans.add(result.postfix + "<Postfix>");
            }
            int i=0;
            for(String a: ans){
            	ans.set(i, a.replace(".0", ""));
                System.out.println(a);
                i++;
            }
            ans.add(Double.toString(result.value));
            printDerivation(resultTree);
        } 
        catch (Exception e) {
            ans.add("Syntax error");
            ans.add("Syntax error");
            ans.add(e.getMessage());
            
            e.printStackTrace();
        }
        
        results=ans;
        return results;
    } 
    
    public  static EvaluationResult evaluateParseTree(ParseTree parseTree){
        int operationIndex = 1;
        int leftOp = 1;
        int rightOp = 2;
        String type = parseTree.getType();
        //System.out.println(type);
        if(type.equals("Infix")){
            operationIndex = 1;
            leftOp = 0;
            rightOp = 2;
        }
        else if(type.equals("Postfix")){
            operationIndex = 2;
            leftOp = 0;
            rightOp = 1;
        }
        else if(type.equals("Prefix")){
            operationIndex = 0;
            leftOp = 1;
            rightOp = 2;
        }
        ArrayList<ParseTree> pts = parseTree.getNodes();
        if (pts.size() == 3){
            String operation = pts.get(operationIndex).getToken();
            EvaluationResult result = null;
            if(operation.contains("PLUS")){
                EvaluationResult resultLeft = evaluateParseTree(pts.get(leftOp));
                EvaluationResult resultRight = evaluateParseTree(pts.get(rightOp));
                //System.out.println("DO");
                if(type.equals("Infix")){
                result = new EvaluationResult(resultLeft.value+resultRight.value,
                "+ "+resultLeft.prefix +" "+resultRight.prefix, ""+resultLeft.postfix+" "+resultRight.postfix+" +","" );
                }
                else if(type.equals("Postfix")){
                result = new EvaluationResult(resultLeft.value+resultRight.value,
                "+ "+resultLeft.prefix +" "+resultRight.prefix,"", "( "+resultLeft.infix+" + "+resultRight.infix+" )");
                }
                if(type.equals("Prefix")){
                result = new EvaluationResult(resultLeft.value+resultRight.value,
                "", ""+resultLeft.postfix+" "+resultRight.postfix+" +", "( "+resultLeft.infix+" + "+resultRight.infix+" )");
                }
                return result;
            }
            else if(operation.contains("MULT")){
                EvaluationResult resultLeft = evaluateParseTree(pts.get(leftOp));
                EvaluationResult resultRight = evaluateParseTree(pts.get(rightOp));
                if(type.equals("Infix")){
                result = new EvaluationResult(resultLeft.value*resultRight.value,
                "* "+resultLeft.prefix +" "+resultRight.prefix, ""+resultLeft.postfix+" "+resultRight.postfix+" *","" );
                }
                else if(type.equals("Postfix")){
                result = new EvaluationResult(resultLeft.value*resultRight.value,
                "* "+resultLeft.prefix +" "+resultRight.prefix,"", "( "+resultLeft.infix+" * "+resultRight.infix+" )");
                }
                if(type.equals("Prefix")){
                result = new EvaluationResult(resultLeft.value*resultRight.value,
                "", ""+resultLeft.postfix+" "+resultRight.postfix+" *", "( "+resultLeft.infix+" * "+resultRight.infix+ " )");
                }
                return result;
            }
            else{
                return evaluateParseTree(pts.get(1));
            }
        }
        else if(pts.size() == 1){   
            return evaluateParseTree(pts.get(0));
        }
        else {
            //System.out.println("DO0000");
            if(type.equals("Infix")){
                
            
            return new EvaluationResult(parseTree.getLexeme(),""+parseTree.getLexeme(),""+parseTree.getLexeme(),"");
            }
            else if(type.equals("Prefix")){
            return new EvaluationResult(parseTree.getLexeme(),"",""+parseTree.getLexeme(),""+parseTree.getLexeme());
            }
            else {
            return new EvaluationResult(parseTree.getLexeme(),""+parseTree.getLexeme(),"",""+parseTree.getLexeme());    
            }
        }
    }
    
    public  static void printDerivation(ParseTree parseTree){
        if(parseTree != null){
            ArrayList<ParseTree> parseTrees = parseTree.getNodes();
            if(!parseTree.getToken().contains("PLUS") 
                    && !parseTree.getToken().contains("MULT")
                    && !parseTree.getToken().contains("NUMBER")){
            System.out.println();
            System.out.print(parseTree.getToken() + " -> ");
        }
            for(ParseTree pt: parseTrees){
                System.out.print(pt.getToken());
                printIndent(1);
            }
            
            for(ParseTree pt: parseTrees){
                printDerivation(pt);
            }
        }
    }
    
    public static void printIndent(int num){
        for(int i = 0; i<num; i++){
            System.out.print("         ");
        }
    }
}

