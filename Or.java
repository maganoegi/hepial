/*
 * Represent an addition expression node inside the AST.
*/

public class Or extends Arithmetic {
    /**
     * Constructor
     */
    public Or(String fl, int line, int col) {
        super(fl, line, col);
    }

    /**
     * Get the binary operator
     */
    public String operateur() {
        return "||";
    }

    /**
     * Apply the operator on the two given values.
     */
    public int apply(int gauche, int droite) {
        return gauche * droite;
    }
    /**
     * Apply the operator on the two given values.
     */
    public boolean apply(boolean gauche, boolean droite) {
        return ((gauche ? 1 : 0) * (droite ? 1 : 0)) != 0;
    }

    /**
     * Accepts a AST visitor
     */
    Object accept(ASTVisitor visitor){
        return visitor.visit(this);
    }
}