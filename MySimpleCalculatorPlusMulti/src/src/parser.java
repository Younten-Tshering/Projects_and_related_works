
//----------------------------------------------------
// The following code was generated by CUP v0.11a beta 20060608
// Thu Apr 15 16:30:23 BTT 2021
//----------------------------------------------------

package src;

import java.util.ArrayList;

/** CUP v0.11a beta 20060608 generated parser.
  * @version Thu Apr 15 16:30:23 BTT 2021
  */
public class parser extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public parser() {super();}

  /** Constructor which sets the default scanner. */
  public parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\022\000\002\002\003\000\002\002\004\000\002\003" +
    "\005\000\002\003\003\000\002\004\005\000\002\004\003" +
    "\000\002\005\005\000\002\005\003\000\002\002\003\000" +
    "\002\007\005\000\002\007\005\000\002\006\003\000\002" +
    "\006\003\000\002\002\003\000\002\011\005\000\002\011" +
    "\005\000\002\010\003\000\002\010\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\037\000\012\004\010\005\004\006\014\010\005\001" +
    "\002\000\010\004\010\005\004\010\034\001\002\000\012" +
    "\002\ufffa\004\ufffa\005\ufffa\010\ufff5\001\002\000\012\002" +
    "\ufffe\004\ufffe\005\022\007\ufffe\001\002\000\004\002\037" +
    "\001\002\000\010\004\010\005\004\010\034\001\002\000" +
    "\004\002\ufff4\001\002\000\006\002\ufff9\010\ufff6\001\002" +
    "\000\004\010\030\001\002\000\006\006\014\010\021\001" +
    "\002\000\012\002\ufffc\004\ufffc\005\ufffc\007\ufffc\001\002" +
    "\000\006\002\001\004\017\001\002\000\006\006\014\010" +
    "\021\001\002\000\012\002\uffff\004\uffff\005\022\007\uffff" +
    "\001\002\000\012\002\ufffa\004\ufffa\005\ufffa\007\ufffa\001" +
    "\002\000\006\006\014\010\021\001\002\000\012\002\ufffd" +
    "\004\ufffd\005\ufffd\007\ufffd\001\002\000\006\004\017\007" +
    "\025\001\002\000\012\002\ufffb\004\ufffb\005\ufffb\007\ufffb" +
    "\001\002\000\010\004\ufff6\005\ufff6\010\ufff6\001\002\000" +
    "\010\004\032\005\031\010\030\001\002\000\010\004\ufff5" +
    "\005\ufff5\010\ufff5\001\002\000\012\002\ufff7\004\ufff7\005" +
    "\ufff7\010\ufff7\001\002\000\012\002\ufff8\004\ufff8\005\ufff8" +
    "\010\ufff8\001\002\000\010\004\010\005\004\010\034\001" +
    "\002\000\012\002\ufff0\004\ufff0\005\ufff0\010\ufff0\001\002" +
    "\000\012\002\ufff1\004\ufff1\005\ufff1\010\ufff1\001\002\000" +
    "\012\002\ufff3\004\ufff3\005\ufff3\010\ufff3\001\002\000\004" +
    "\002\000\001\002\000\010\004\010\005\004\010\034\001" +
    "\002\000\012\002\ufff2\004\ufff2\005\ufff2\010\ufff2\001\002" +
    "" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\037\000\020\002\006\003\015\004\005\005\014\006" +
    "\012\007\011\011\010\001\001\000\006\010\037\011\034" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\006\010\032\011\034\001\001\000\002\001\001" +
    "\000\002\001\001\000\006\006\026\007\025\001\001\000" +
    "\010\003\023\004\005\005\014\001\001\000\002\001\001" +
    "\000\002\001\001\000\006\004\017\005\014\001\001\000" +
    "\002\001\001\000\002\001\001\000\004\005\022\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\006\006\026\007\025\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\006\010" +
    "\035\011\034\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\006\010\040\011" +
    "\034\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}

}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$parser$actions {
  private final parser parser;

  /** Constructor */
  CUP$parser$actions(parser parser) {
    this.parser = parser;
  }

  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$parser$do_action(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$parser$result;

      /* select the action based on the action number */
      switch (CUP$parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // J ::= NUMBER 
            {
              ParseTree RESULT =null;
		int nleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int nright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Integer n = (Integer)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		  
          ParseTree pt = new ParseTree();
          pt.setType("Prefix");
          pt.setToken("   J   ");
          ArrayList<ParseTree> pts = pt.getNodes();
          ParseTree number = new ParseTree();
          number.setToken("NUMBER");
          number.setType("Prefix");
          number.setLexeme(n);
          pts.add(number);
          RESULT = pt;
        
              CUP$parser$result = parser.getSymbolFactory().newSymbol("J",6, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // J ::= M 
            {
              ParseTree RESULT =null;
		int mleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int mright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		ParseTree m = (ParseTree)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		
          RESULT = m;
        
              CUP$parser$result = parser.getSymbolFactory().newSymbol("J",6, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // M ::= MULT J J 
            {
              ParseTree RESULT =null;
		int j1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int j1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		ParseTree j1 = (ParseTree)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int j2left = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int j2right = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		ParseTree j2 = (ParseTree)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		
          ParseTree pt = new ParseTree();
          pt.setType("Prefix");
          pt.setToken("   M   ");
          ArrayList<ParseTree> pts = pt.getNodes();
          ParseTree mult = new ParseTree();
          mult.setToken(" MULT");
          mult.setType("Prefix");
          pts.add(mult);
          pts.add(j1);
          pts.add(j2);
          RESULT = pt;
        
              CUP$parser$result = parser.getSymbolFactory().newSymbol("M",7, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // M ::= PLUS J J 
            {
              ParseTree RESULT =null;
		int j1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int j1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		ParseTree j1 = (ParseTree)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int j2left = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int j2right = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		ParseTree j2 = (ParseTree)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		  
          ParseTree pt = new ParseTree();
          pt.setType("Prefix");
          pt.setToken("   M   ");
          ArrayList<ParseTree> pts = pt.getNodes();
          ParseTree plus = new ParseTree();
          plus.setType("Prefix");
          plus.setToken(" PLUS ");
          pts.add(plus);
          pts.add(j1);
          pts.add(j2);
          RESULT = pt;
        
              CUP$parser$result = parser.getSymbolFactory().newSymbol("M",7, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // S ::= M 
            {
              ParseTree RESULT =null;
		int mleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int mright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		ParseTree m = (ParseTree)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		
            RESULT = m;
        
              CUP$parser$result = parser.getSymbolFactory().newSymbol("S",0, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // K ::= NUMBER 
            {
              ParseTree RESULT =null;
		int nleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int nright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Integer n = (Integer)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		  
          ParseTree pt = new ParseTree();
          pt.setType("Postfix");
          pt.setToken("   K   ");
          ArrayList<ParseTree> pts = pt.getNodes();
          ParseTree number = new ParseTree();
          number.setToken("NUMBER");
          number.setType("Postfix");
          number.setLexeme(n);
          pts.add(number);
          RESULT = pt;
        
              CUP$parser$result = parser.getSymbolFactory().newSymbol("K",4, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // K ::= L 
            {
              ParseTree RESULT =null;
		int lleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int lright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		ParseTree l = (ParseTree)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		
          RESULT = l;
        
              CUP$parser$result = parser.getSymbolFactory().newSymbol("K",4, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // L ::= K K MULT 
            {
              ParseTree RESULT =null;
		int k1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int k1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		ParseTree k1 = (ParseTree)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int k2left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int k2right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		ParseTree k2 = (ParseTree)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		
          ParseTree pt = new ParseTree();
          pt.setType("Postfix");
          pt.setToken("   L   ");
          ArrayList<ParseTree> pts = pt.getNodes();
          ParseTree mult = new ParseTree();
          mult.setToken(" MULT ");
          pts.add(k1);
          pts.add(k2);
          pts.add(mult);
          RESULT = pt;
        
              CUP$parser$result = parser.getSymbolFactory().newSymbol("L",5, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // L ::= K K PLUS 
            {
              ParseTree RESULT =null;
		int k1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int k1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		ParseTree k1 = (ParseTree)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int k2left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int k2right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		ParseTree k2 = (ParseTree)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		  
          ParseTree pt = new ParseTree();
          pt.setType("Postfix");
          pt.setToken("   L   ");
          ArrayList<ParseTree> pts = pt.getNodes();
          ParseTree plus = new ParseTree();
          plus.setToken(" PLUS ");
          pts.add(k1);
          pts.add(k2);
          pts.add(plus);
          RESULT = pt;
        
              CUP$parser$result = parser.getSymbolFactory().newSymbol("L",5, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // S ::= L 
            {
              ParseTree RESULT =null;
		int lleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int lright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		ParseTree l = (ParseTree)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		
            RESULT = l;
        
              CUP$parser$result = parser.getSymbolFactory().newSymbol("S",0, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // F ::= NUMBER 
            {
              ParseTree RESULT =null;
		int nleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int nright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Integer n = (Integer)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		  
          ParseTree pt = new ParseTree();
          pt.setType("Infix");
          pt.setToken("   F   ");
          ArrayList<ParseTree> pts = pt.getNodes();
          ParseTree number = new ParseTree();
          number.setToken("NUMBER");
          number.setType("Infix");
          number.setLexeme(n);
          pts.add(number);
          RESULT = pt;
        
              CUP$parser$result = parser.getSymbolFactory().newSymbol("F",3, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // F ::= OPAREN E CPAREN 
            {
              ParseTree RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		ParseTree e = (ParseTree)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		
          ParseTree pt = new ParseTree();
          pt.setType("Infix");
          pt.setToken("   F   ");
          ArrayList<ParseTree> pts = pt.getNodes();
          ParseTree oparen = new ParseTree();
          oparen.setToken("OPAREN");
          oparen.setType("Infix");
          pts.add(oparen);
          pts.add(e);
          ParseTree cparen = new ParseTree();
          cparen.setType("Infix");
          cparen.setToken("CPAREN");
          pts.add(cparen);
          RESULT = pt;
        
              CUP$parser$result = parser.getSymbolFactory().newSymbol("F",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // T ::= F 
            {
              ParseTree RESULT =null;
		int fleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int fright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		ParseTree f = (ParseTree)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		
          ParseTree pt = new ParseTree();
          pt.setType("Infix");
          pt.setToken("   T   ");
          ArrayList<ParseTree> pts = pt.getNodes();
          pts.add(f);
          RESULT = pt;
        
              CUP$parser$result = parser.getSymbolFactory().newSymbol("T",2, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // T ::= T MULT F 
            {
              ParseTree RESULT =null;
		int tleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int tright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		ParseTree t = (ParseTree)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int fleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int fright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		ParseTree f = (ParseTree)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		
          ParseTree pt = new ParseTree();
          pt.setType("Infix");
          pt.setToken("   T   ");
          ArrayList<ParseTree> pts = pt.getNodes();
          ParseTree mult = new ParseTree();
          mult.setToken(" MULT ");
          mult.setType("Infix");
          pts.add(t);
          pts.add(mult);
          pts.add(f);
          RESULT = pt;
        
              CUP$parser$result = parser.getSymbolFactory().newSymbol("T",2, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // E ::= T 
            {
              ParseTree RESULT =null;
		int tleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int tright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		ParseTree t = (ParseTree)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		  
          ParseTree pt = new ParseTree();
          pt.setType("Infix");
          pt.setToken("   E   ");
          ArrayList<ParseTree> pts = pt.getNodes();
          pts.add(t);
          RESULT = pt;
        
              CUP$parser$result = parser.getSymbolFactory().newSymbol("E",1, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // E ::= E PLUS T 
            {
              ParseTree RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		ParseTree e = (ParseTree)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int tleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int tright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		ParseTree t = (ParseTree)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		
          ParseTree pt = new ParseTree();
          pt.setType("Infix");
          pt.setToken("   E   ");
          ArrayList<ParseTree> pts = pt.getNodes();
          ParseTree plus = new ParseTree();
          plus.setToken("PLUS");
          plus.setType("Infix");
          pts.add(e);
          pts.add(plus);
          pts.add(t);
          RESULT = pt;
        
              CUP$parser$result = parser.getSymbolFactory().newSymbol("E",1, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= S EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		ParseTree start_val = (ParseTree)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT = start_val;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$parser$parser.done_parsing();
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // S ::= E 
            {
              ParseTree RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		ParseTree e = (ParseTree)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		
            RESULT = e;
        
              CUP$parser$result = parser.getSymbolFactory().newSymbol("S",0, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}

