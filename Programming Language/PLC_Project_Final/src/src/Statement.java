/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;
import src.ConsoleOutput.OutputType;

/**
 * Consists of the Statement class which is used to represent statements of 
 * various types (variable declaration, variable assignment, if-else, while loop. 
 * It consists of factory methods which construct instances of Statement for 
 * each different type of statements. It also consists of a method execute() which
 * then runs the suitable code for the type of statement that the instance of Statement is.
 * @author Younten
 */
public class Statement {
    //parser parser = new parser();
    String statementType;
    String ID;
    Type type;
    Aexp e;
    Statement body;
    Statement elsebody;
    Statements statementList;
    int calculatorResult;
    float calculatorFloatResult;

    //for logical
    Aexp left,right;    
    

    public Statement(Type t, String ID, Aexp e)
    {
        this.ID = ID;
        this.e = e;
        this.type = t;
    }
    
    public Statement(Type t, String ID)
    {
        this.ID = ID;
        this.e = null;
        this.type = t;
        
        System.out.println("( " + t.getCode() + " " + ID + " )");
    }

    public Statement(Integer i)
    {
        this.calculatorResult = i;
    }
     public Statement (Float i)
    {
        this.calculatorFloatResult = i;
    }
     
    
    public Statement(String ID, Aexp e)
    {
        this.ID = ID;
        this.e = e;
    }
  

    public Statement(Aexp e, Statement body)
    {
        this.e = e;
        this.body = body;
    }
    
    public Statement(Aexp e, Statement body1, Statement body2) {
        this.e = e;

        this.body = body1;
        this.elsebody = body2;

    }

    public Statement(Aexp e)
    {
        this.e = e;
    }

    private Statement(Statements l)
    {
        statementList = l;
    }

    
    public static Statement logic (Aexp logical)
    {
        Statement logic = new Statement(logical);
        logic.statementType="logic";

        return logic;
    }
    
    public static Statement assignment(String ID, Aexp e)
    {
        Statement assignment = new Statement(ID, e);

        assignment.statementType = "assignment";

        return assignment;

    }

    public static Statement assignment(Type t, String ID, Aexp e)
    {
        Statement assignment = new Statement(t, ID, e);
        assignment.statementType = "instantiation";

        return assignment;

    }
    
    public static Statement assignment(Type t, String ID)
    {
        Statement assignment = new Statement(t, ID);
        assignment.statementType = "declaration";

        return assignment;

    }

    public static Statement whileloop(Aexp e, Statement whileBody)
    {
        Statement loop = new Statement(e, whileBody);
        loop.statementType = "whileloop";
        return loop;

    }

    public static Statement ifthen(Aexp e, Statement ifbody)
    {
        Statement ifthen = new Statement(e, ifbody);
        ifthen.statementType = "ifthen";
        return ifthen;
    }
    
    public static Statement ifthenelse(Aexp e, Statement ifbody, Statement elsebody) {

        Statement ifthenelse = new Statement(e, ifbody,elsebody);
        ifthenelse.statementType = "ifthenelse";
        return ifthenelse;
        
    }

    public static Statement print(Aexp e)
    {

        Statement p = new Statement(e);
        p.statementType = "print";
        return p;

    }
    
    public static Statement println()
    {
        Statement p = new Statement(0);
        p.statementType = "println";
        return p;
    }

    public static Statement list(Statements l)
    {

        Statement p = new Statement(l);
        p.statementType = "list";
        return p;

    }

    public String getstat() {
        System.out.println(statementType);

        if (statementType.equals("assignment")) {
            return ID + "=" + e.getexp();
        } else if (statementType.equals("instantiation")) {
            return type.getCode() + " " + ID + "=" + e.getexp();
        } else if (statementType.equals("ifthen")) {
            return "if " + e.getexp() + " " + body.getstat();
        } else if (statementType.equals("ifthenelse")) {
            return "else " + e.getexp() + " " + body.getstat();
        } else if (statementType.equals("print")) {
            return "print " + e.getexp();
        } else if (statementType.equals("whileloop")) {
            return "while " + e.getexp() + " do " + body.getstat();
        } else if (statementType.equals("list")) {
            return "list";
        } else if (statementType.equals("type-error")) {
            return "type-error";
        } else {
            return "unknown";
        }
    }

    public void execute() {
        /*
         * Retreive identifier from table, check its type, then assign
         */
        if (statementType.equals("assignment") || statementType.equals("instantiation")) {
            if (Environment.table.get(ID).getType().isInteger()) {
                Environment.table.put(ID, new TypeValue((Integer) e.getTypeValue().getValue()));
            }
            if (Environment.table.get(ID).getType().isString()) {
                Environment.table.put(ID, new TypeValue((String) e.getTypeValue().getValue()));
            }
            if (Environment.table.get(ID).getType().isFloating_point()) {
                Environment.table.put(ID, new TypeValue((Float) e.getTypeValue().getValue()));
            }
            if (Environment.table.get(ID).getType().isBool()) {
                Environment.table.put(ID, new TypeValue((Boolean) e.getTypeValue().getValue()));
            }
        } else if (statementType.equals("instantiation")) {

            if (type.isInteger()) {
                Environment.table.put(ID, new TypeValue((Integer) e.getTypeValue().getValue()));
            }

            if (type.isFloating_point()) {
                Environment.table.put(ID, new TypeValue((Float) e.getTypeValue().getValue()));
            }
            if (type.isString()) {

                Environment.table.put(ID, new TypeValue((String) e.getTypeValue().getValue()));
            }
            if (type.isBool()) {
                Environment.table.put(ID, new TypeValue((Boolean) e.getTypeValue().getValue()));
            }

        } else if (statementType.equals("ifthen")) {
            if (e.getTypeValue().getType().isBool()) //expr must be boolean
            {
                boolean b = (Boolean) e.getTypeValue().getValue();
                if ((Boolean) e.getTypeValue().getValue()) {
                    body.execute();
                }
            } else {
                //parser.type_error("", "if expression must be boolean.");
            }
        } else if (statementType.equals("ifthenelse")) {
            if (e.getTypeValue().getType().isBool()) //expr must be boolean
            {
                if ((Boolean) e.getTypeValue().getValue()) {
                    body.execute();
                } else {
                    elsebody.execute();
                }
            } else {
                //parser.type_error("", "if expression must be boolean.");
            }
        } else if (statementType.equals("whileloop")) {
            if (e.getTypeValue().getType().isBool()) {
                for (;;) {
                    if ((Boolean) e.getTypeValue().getValue()) {
                        body.execute();
                    } else {
                        break;
                    }
                }
            } else {
                //type error
                //parser.type_error("", "while expression must be boolean.");
            }
        } else if (statementType.equals("print")) {
            //need to check type for casting from TypeValue
            if (e.getType().isInteger()) {
                Integer result = ((Integer) e.getTypeValue().getValue());
                System.out.println(result);
                ConsoleOutput.getInstance().setText(result.toString(), OutputType.OUTPUT);
            }
            if (e.getType().isFloating_point()) {
                Float result = (Float) e.getTypeValue().getValue();
                System.out.println(result);
                ConsoleOutput.getInstance().setText(result.toString(), OutputType.OUTPUT);
            }
            if (e.getType().isString()) {
                String result = (String) e.getTypeValue().getValue();
                System.out.println(result);
                ConsoleOutput.getInstance().setText(result.toString().substring(1, result.length() - 1), OutputType.OUTPUT);
            }
            if (e.getType().isBool()) {
                Boolean result = (Boolean) e.getTypeValue().getValue();
                System.out.println(result);
                ConsoleOutput.getInstance().setText(result.toString(), OutputType.OUTPUT);
            }

        } else if (statementType.equals("println")) {
            ConsoleOutput.getInstance().setText("\n", OutputType.OUTPUT);
            
        } else if (statementType.equals("list")) {
            for (Statement s : statementList.statementLists) {
                s.execute();
            }
        } else if (statementType.equals("calculator")) {
            if (type.isInteger()) {
                System.out.println(calculatorResult);
                ConsoleOutput.getInstance().setText("" + calculatorResult, OutputType.OUTPUT);
            }
            if (type.isFloating_point()) {
                System.out.println(calculatorFloatResult);
                ConsoleOutput.getInstance().setText("" + calculatorFloatResult, OutputType.OUTPUT);
            }

        }
    }
}
