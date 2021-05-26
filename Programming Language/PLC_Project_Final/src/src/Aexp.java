/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

/**
 * Consists of the Aexp class which is used to represents an expression.
 * @author Younten
 */
public class Aexp {

    private boolean[] tag = new boolean[6];
    private Integer NUMBER_INTEGER;
    private Float NUMBER_FLOAT;
    private String TEXT_LITERAL;
    private String ID;
    private Args Operands;
    private int Operator;
    private Boolean BOOL_LITERAL;
    //type is determined from the constructor
    private Type type = new Type();
    //A variable to check if identifier hold boolean or not. If false, its integer.
    private boolean isBool;

    Aexp(Integer x)
    {
        int i;
        for (i = 0; i <= 5; i++)
        {
            if (i == 0)
            {
                tag[i] = true;
            } else
            {
                tag[i] = false;
            }
        }
        
        NUMBER_INTEGER = x;
        type = Type.integer();
        isBool = false;
    }
    
     Aexp(Float x)
    {
        int i;
        for (i = 0; i <= 5; i++)
        {
            if (i == 1)
            {
                tag[i] = true;
            } else
            {
                tag[i] = false;
            }
        }
        
        NUMBER_FLOAT = x;
        type = Type.floating_point();
        isBool = false;        
    }

     
    Aexp(String a, String x)
    {
          int i;
        for (i = 0; i <= 5; i++)
        {
            if (i == 2)
            {
                tag[i] = true;
            } else
            {
                tag[i] = false;
            }
        }
        
        TEXT_LITERAL = x;
        type = Type.string();
        isBool = false;        
    }
    
    Aexp(String x)
    {
        
        int i;

        for (i = 0; i <= 5; i++)
        {
            if (i == 3)
            {
                tag[i] = true;
            } else
            {
                tag[i] = false;
            }
        }
        
        //System.out.println("IN X constructor");
        if (Environment.table.get(x).getType().isInteger())
        {
            type = Type.integer();
            isBool = false;
            //System.out.println("ID test(integer): "+x+" "+type.isInteger());
        } else if (Environment.table.get(x).getType().isFloating_point())
        {
            type = Type.floating_point();
            isBool = false;
        } else if (Environment.table.get(x).getType().isString())
        {
            type = Type.string();
            isBool = false;
        } 
        else if (Environment.table.get(x).getType().isBool())
        {
            //System.out.println(x+" is boolean "+ Environment.table.get(x));
            type = Type.bool();
            isBool = true;
        } else
        {
          type = Type.errortype();
        }

        ID = x;
    }

    Aexp(Args x, int op)
    {
        int i;
        for (i = 0; i <= 5; i++)
        {
            if (i == 4)
            {
                tag[i] = true;
            } else
            {
                tag[i] = false;
            }
        }
       
        //set type here
        if (op == sym.PLUS || op == sym.MINUS || op == sym.TIMES || op == sym.DIVIDE || op == sym.MOD)
        {
            
             if (x.getSecondExp().getType().isFloating_point()){
                type = Type.floating_point();
            } else if (x.getSecondExp().getType().isInteger() ){
                type = Type.integer();
            }else if (x.getSecondExp().getType().isString()){
                type = Type.string();
            }             
              
            isBool = false;
        } else if (op == sym.GT || op == sym.LT || op == sym.ET || op == sym.GTE || op == sym.LTE || op == sym.NET)
        {
            type = Type.bool();
            isBool = true;
        }else if (op == sym.OR || op == sym.AND )
        {
            type = Type.bool();
            isBool = true;
        }
        else
        {
            type = Type.errortype();
        }

        Operands = x;
        Operator = op;
    }

    Aexp(Boolean bool_literal)
    {
        int i;
        for (i = 0; i <= 5; i++)
        {
            if (i == 5)
            {
                tag[i] = true;
            } else
            {
                tag[i] = false;
            }
        }

        type = Type.bool();
        this.BOOL_LITERAL = bool_literal;
        isBool = true;
    }
    
   
    public String getexp()
    {

        String s = "";
        if (tag[0])
        {
            s = "" + NUMBER_INTEGER;
        } else if (tag[1])                
        {
            s = "" + NUMBER_FLOAT;
        } else if (tag[2])                
        {
            s = "" + TEXT_LITERAL;
        } else if (tag[3])
        {
            s = ID;
        } else if (tag[4])
        {
            if (Operator == sym.PLUS)
            {
                s = "PLUS ( " + Operands.getFirstExp().getexp() + ", " + Operands.getSecondExp().getexp() + " )";
            } else if (Operator == sym.MINUS)
            {
                s = "MINUS ( " + Operands.getFirstExp().getexp() + ", " + Operands.getSecondExp().getexp() + " )";
            }
            if (Operator == sym.TIMES)
            {
                s = "TIMES ( " + Operands.getFirstExp().getexp() + ", " + Operands.getSecondExp().getexp() + " )";
            }
            if (Operator == sym.DIVIDE)
            {
                s = "DIVIDE ( " + Operands.getFirstExp().getexp() + ", " + Operands.getSecondExp().getexp() + " )";
            }
            if (Operator == sym.MOD)
            {
                s = "MOD ( " + Operands.getFirstExp().getexp() + ", " + Operands.getSecondExp().getexp() + " )";
            }
        } else if (tag[5])
        {
            s = "" + BOOL_LITERAL;
        }
        return s;
    }

    
    //Evaluation of expressions
    public TypeValue getTypeValue()
    {
        TypeValue typeVal = null;
        if (tag[0]) //number integer
        {
              typeVal = new TypeValue(NUMBER_INTEGER);
        }else if (tag[1]) //number float
        {
              typeVal = new TypeValue(NUMBER_FLOAT);
        }
        else if (tag[2]) //String
        {
              typeVal = new TypeValue(TEXT_LITERAL);
        }
        else if (tag[3]) //identifier
        {
            if (isBool)
            {
                typeVal = Environment.table.get(ID);
            }
            else
            {
                 typeVal = Environment.table.get(ID);
            }
        }
        else if (tag[4])//operation on two expressions first and second
        {
            /*
             * Typecasts will throw a exception from java itself, when there
             * is a type error in the language
             */
                if (Operator == sym.PLUS)
                {
                  
                    if ( Operands.getFirstExp().getType().isInteger() )
                    {
                        int val = (Integer) Operands.getFirstExp().getTypeValue().getValue();
                        val = val + (Integer)Operands.getSecondExp().getTypeValue().getValue();
                        typeVal = new TypeValue(val);
                    } else if ( Operands.getFirstExp().getType().isFloating_point())
                    {
                        float val = (Float) Operands.getFirstExp().getTypeValue().getValue();
                        val = val + (Float)Operands.getSecondExp().getTypeValue().getValue();
                        typeVal = new TypeValue(val);
                    }
                }
                else if (Operator == sym.MINUS)
                {
                    if ( Operands.getFirstExp().getType().isInteger() )
                    {
                        int val = (Integer) Operands.getFirstExp().getTypeValue().getValue();
                        val = val - (Integer)Operands.getSecondExp().getTypeValue().getValue();
                        typeVal = new TypeValue(val);
                    } else if ( Operands.getFirstExp().getType().isFloating_point()){
                        float val = (Float) Operands.getFirstExp().getTypeValue().getValue();
                        val = val - (Float)Operands.getSecondExp().getTypeValue().getValue();
                        typeVal = new TypeValue(val);
                    }
                        
                }
                else if (Operator == sym.TIMES)
                {
                    if ( Operands.getFirstExp().getType().isInteger() )
                    {
                        int val = (Integer) Operands.getFirstExp().getTypeValue().getValue();
                        val = val * (Integer)Operands.getSecondExp().getTypeValue().getValue();
                        typeVal = new TypeValue(val);
                    } else if ( Operands.getFirstExp().getType().isFloating_point()){
                        float val = (Float) Operands.getFirstExp().getTypeValue().getValue();
                        val = val * (Float)Operands.getSecondExp().getTypeValue().getValue();
                        typeVal = new TypeValue(val);
                    }
                }
                else if (Operator == sym.DIVIDE)
                {
                    if ( Operands.getFirstExp().getType().isInteger() )
                    {
                        int val = (Integer) Operands.getFirstExp().getTypeValue().getValue();
                        val = val / (Integer)Operands.getSecondExp().getTypeValue().getValue();
                        typeVal = new TypeValue(val);
                        
                    } else if ( Operands.getFirstExp().getType().isFloating_point())
                    {
                        float val = (Float) Operands.getFirstExp().getTypeValue().getValue();
                        val = val / (Float)Operands.getSecondExp().getTypeValue().getValue();
                        typeVal = new TypeValue(val);
                    }
                }
                else if (Operator == sym.MOD)
                {
                    if ( Operands.getFirstExp().getType().isInteger() )
                    {
                        int val = (Integer) Operands.getFirstExp().getTypeValue().getValue();
                        val = val % (Integer)Operands.getSecondExp().getTypeValue().getValue();
                        typeVal = new TypeValue(val);
                        
                    } else if ( Operands.getFirstExp().getType().isFloating_point())
                    {
                        float val = (Float) Operands.getFirstExp().getTypeValue().getValue();
                        val = val % (Float)Operands.getSecondExp().getTypeValue().getValue();
                        typeVal = new TypeValue(val);
                    }
                }
                else if (Operator == sym.GT)
                {
                   
                     if ( Operands.getFirstExp().getType().isInteger() )
                    {
                         boolean val = (Integer) Operands.getFirstExp().getTypeValue().getValue() > (Integer)Operands.getSecondExp().getTypeValue().getValue();
                         typeVal = new TypeValue(val);
                        
                    } else if ( Operands.getFirstExp().getType().isFloating_point())
                    {
                        boolean val = (Float) Operands.getFirstExp().getTypeValue().getValue() > (Float)Operands.getSecondExp().getTypeValue().getValue();
                        typeVal = new TypeValue(val);
                    }
                }
                else if (Operator == sym.LT)
                {
                    if ( Operands.getFirstExp().getType().isInteger() )
                    {
                         boolean val = (Integer) Operands.getFirstExp().getTypeValue().getValue() < (Integer)Operands.getSecondExp().getTypeValue().getValue();
                         typeVal = new TypeValue(val);
                        
                    } else if ( Operands.getFirstExp().getType().isFloating_point())
                    {
                        boolean val = (Float) Operands.getFirstExp().getTypeValue().getValue() < (Float)Operands.getSecondExp().getTypeValue().getValue();
                        typeVal = new TypeValue(val);
                    }
                }
                else if (Operator == sym.GTE)
                {
                    if ( Operands.getFirstExp().getType().isInteger() )
                    {
                         boolean val = (Integer) Operands.getFirstExp().getTypeValue().getValue() >= (Integer)Operands.getSecondExp().getTypeValue().getValue();
                         typeVal = new TypeValue(val);
                        
                    } else if ( Operands.getFirstExp().getType().isFloating_point())
                    {
                        boolean val = (Float) Operands.getFirstExp().getTypeValue().getValue() >= (Float)Operands.getSecondExp().getTypeValue().getValue();
                        typeVal = new TypeValue(val);
                    }
                }
                else if (Operator == sym.LTE)
                {
                    if ( Operands.getFirstExp().getType().isInteger() )
                    {
                         boolean val = (Integer) Operands.getFirstExp().getTypeValue().getValue() <= (Integer)Operands.getSecondExp().getTypeValue().getValue();
                         typeVal = new TypeValue(val);
                        
                    } else if ( Operands.getFirstExp().getType().isFloating_point())
                    {
                        boolean val = (Float) Operands.getFirstExp().getTypeValue().getValue() <= (Float)Operands.getSecondExp().getTypeValue().getValue();
                        typeVal = new TypeValue(val);
                    }
                }
                else if (Operator == sym.ET)
                {
                    if ( Operands.getFirstExp().getType().isInteger() )
                    {
                         boolean val = (Integer) Operands.getFirstExp().getTypeValue().getValue() == (Integer)Operands.getSecondExp().getTypeValue().getValue();
                         typeVal = new TypeValue(val);
                        
                    } else if ( Operands.getFirstExp().getType().isFloating_point())
                    {
                        boolean val = (Float) Operands.getFirstExp().getTypeValue().getValue() == (Float)Operands.getSecondExp().getTypeValue().getValue();
                        typeVal = new TypeValue(val);
                        
                    }else if ( Operands.getFirstExp().getType().isBool())
                    {
                        boolean val = (Boolean) Operands.getFirstExp().getTypeValue().getValue() == (Boolean)Operands.getSecondExp().getTypeValue().getValue();
                        typeVal = new TypeValue(val);
                    }
                }
                else if (Operator == sym.NET)
                {
                    if ( Operands.getFirstExp().getType().isInteger() )
                    {
                         boolean val = (Integer) Operands.getFirstExp().getTypeValue().getValue() != (Integer)Operands.getSecondExp().getTypeValue().getValue();
                         typeVal = new TypeValue(val);
                        
                    } else if ( Operands.getFirstExp().getType().isFloating_point())
                    {
                        boolean val = (Float) Operands.getFirstExp().getTypeValue().getValue() != (Float)Operands.getSecondExp().getTypeValue().getValue();
                        typeVal = new TypeValue(val);
                        
                    }else if ( Operands.getFirstExp().getType().isBool())
                    {
                        boolean val = (Boolean) Operands.getFirstExp().getTypeValue().getValue() != (Boolean)Operands.getSecondExp().getTypeValue().getValue();
                        typeVal = new TypeValue(val);
                    }
                }
                else if (Operator == sym.OR)
                {
                    boolean val = (Boolean) Operands.getFirstExp().getTypeValue().getValue() || (Boolean) Operands.getSecondExp().getTypeValue().getValue();
                    typeVal = new TypeValue(val);
                }
                else if (Operator == sym.AND)
                {
                    boolean val = (Boolean) Operands.getFirstExp().getTypeValue().getValue() && (Boolean) Operands.getSecondExp().getTypeValue().getValue();
                    typeVal = new TypeValue(val);
                }
        }
        if (tag[5]) //for boolean expression (from constructor)
        {           
            typeVal = new TypeValue(BOOL_LITERAL);
        }
        return typeVal;
    }
    
    public Type getType()
    {
        return type;
    }
}
