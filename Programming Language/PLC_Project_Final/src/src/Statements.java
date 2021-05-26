/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.util.ArrayList;

/**
 * Consists of the class Statements which is composed of an ArrayList<Statement> 
 * to store a list of related statements, and has a method execute() which 
 * in turn loops over the elements in the list of statements and calls
 * the execute() method of the individual statements.
 * @author Younten
 */
public class Statements {
     ArrayList<Statement> statementLists;

    public Statements(Statement s){
        statementLists  = new ArrayList<>();
        statementLists.add(s);
    }

    public Statements(Statements statements, Statement s){
        statementLists = statements.statementLists;
        statementLists.add(s);
    }

    public void execute(){

        for (Statement statement : statementLists) {
            statement.execute();
        }
    }

    public void showStatements()
    {
        for (int i = 0; i < statementLists.size(); i++)
        {
            System.out.println("****************");
            System.out.println(statementLists.get(i));
            System.out.println("****************");
            
        }
    }
       
}
