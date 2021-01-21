/*
 * Represent a string of characters node inside the AST.
*/

public class Chain extends Expression {
    /**
     * Value contained in this string node
     */
    private String valeur;

    /**
     * Constructor
     */
    public Chain(String val, String fl, int line, int col) {
        super(fl, line, col);
        this.valeur = val;
    }

    /**
     * Get the node value
     */
    public String getValeur() {
        return this.valeur;
    }

    /**
     * Accepts a AST visitor
     */
    Object accept(ASTVisitor visitor){
        return visitor.visit(this);
    }
}
