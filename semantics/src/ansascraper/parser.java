
//----------------------------------------------------
// The following code was generated by CUP v0.11a beta 20060608
// Wed Feb 27 14:08:30 CET 2008
//----------------------------------------------------
package ansascraper;

/** CUP v0.11a beta 20060608 generated parser.
 * @version Wed Feb 27 14:08:30 CET 2008
 */
public class parser extends java_cup.runtime.lr_parser {

    /** Default constructor. */
    public parser() {
        super();
    }

    /** Constructor which sets the default scanner. */
    public parser(java_cup.runtime.Scanner s) {
        super(s);
    }

    /** Constructor which sets the default scanner. */
    public parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {
        super(s, sf);
    }
    /** Production table. */
    protected static final short _production_table[][] =
            unpackFromStrings(new String[]{
                "\000\002\000\002\002\004\000\002\002\004"
            });

    /** Access to production table. */
    public short[][] production_table() {
        return _production_table;
    }
    /** Parse-action table. */
    protected static final short[][] _action_table =
            unpackFromStrings(new String[]{
                "\000\005\000\004\004\004\001\002\000\004\005\007\001" +
                "\002\000\004\002\006\001\002\000\004\002\000\001\002" +
                "\000\004\002\001\001\002"
            });

    /** Access to parse-action table. */
    public short[][] action_table() {
        return _action_table;
    }
    /** <code>reduce_goto</code> table. */
    protected static final short[][] _reduce_table =
            unpackFromStrings(new String[]{
                "\000\005\000\004\002\004\001\001\000\002\001\001\000" +
                "\002\001\001\000\002\001\001\000\002\001\001"
            });

    /** Access to <code>reduce_goto</code> table. */
    public short[][] reduce_table() {
        return _reduce_table;
    }
    /** Instance of action encapsulation class. */
    protected CUP$parser$actions action_obj;

    /** Action encapsulation object initializer. */
    protected void init_actions() {
        action_obj = new CUP$parser$actions(this);
    }

    /** Invoke a user supplied parse action. */
    public java_cup.runtime.Symbol do_action(
            int act_num,
            java_cup.runtime.lr_parser parser,
            java.util.Stack stack,
            int top)
            throws java.lang.Exception {
        /* call code in generated class */
        return action_obj.CUP$parser$do_action(act_num, parser, stack, top);
    }

    /** Indicates start state. */
    public int start_state() {
        return 0;
    }

    /** Indicates start production. */
    public int start_production() {
        return 1;
    }

    /** <code>EOF</code> Symbol index. */
    public int EOF_sym() {
        return 0;
    }

    /** <code>error</code> Symbol index. */
    public int error_sym() {
        return 1;
    }
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
            int CUP$parser$act_num,
            java_cup.runtime.lr_parser CUP$parser$parser,
            java.util.Stack CUP$parser$stack,
            int CUP$parser$top)
            throws java.lang.Exception {
        /* Symbol object for return from actions */
        java_cup.runtime.Symbol CUP$parser$result;

        /* select the action based on the action number */
        switch (CUP$parser$act_num) {
            /*. . . . . . . . . . . . . . . . . . . .*/
            case 1: // $START ::= NEWS EOF 
                 {
                    Object RESULT = null;
                    int start_valleft = ((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top - 1)).left;
                    int start_valright = ((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top - 1)).right;
                    Object start_val = (Object) ((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top - 1)).value;
                    RESULT = start_val;
                    CUP$parser$result = parser.getSymbolFactory().newSymbol("$START", 0, ((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top - 1)), ((java_cup.runtime.Symbol) CUP$parser$stack.peek()), RESULT);
                }
                /* ACCEPT */
                CUP$parser$parser.done_parsing();
                return CUP$parser$result;

            /*. . . . . . . . . . . . . . . . . . . .*/
            case 0: // NEWS ::= TITLE TEXT 
                 {
                    Object RESULT = null;
                    int Tleft = ((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top - 1)).left;
                    int Tright = ((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top - 1)).right;
                    String T = (String) ((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top - 1)).value;
                    int TXleft = ((java_cup.runtime.Symbol) CUP$parser$stack.peek()).left;
                    int TXright = ((java_cup.runtime.Symbol) CUP$parser$stack.peek()).right;
                    String TX = (String) ((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;

                    try {
                        RESULT = T + System.getProperty("line.separator") + TX;
                    } catch (Exception e) {
                        System.out.println(e);
                    }

                    CUP$parser$result = parser.getSymbolFactory().newSymbol("NEWS", 0, ((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top - 1)), ((java_cup.runtime.Symbol) CUP$parser$stack.peek()), RESULT);
                }
                return CUP$parser$result;

            /* . . . . . .*/
            default:
                throw new Exception(
                        "Invalid action number found in internal parse table");

        }
    }
}
