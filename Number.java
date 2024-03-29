/*
 * Represent a number node inside the AST.
*/

public class Number extends Expression {
    /**
     * Value contained in this number node
     */
    private int valeur;

    /**
     * Constructor
     */
    public Number(int val, String fl, int line, int col) {
        super(fl, line, col);
        this.valeur = val;
    }

    /**
     * Get the node value
     */
    public int getValeur() {
        return this.valeur;
    }

    /**
     * Accepts a AST visitor
     */
    Object accept(ASTVisitor visitor){
        return visitor.visit(this);
    }
}
