


public class Minus extends Unary {
    /**
     * Constructor
     */
    public Minus(String fl, int line, int col) {
        super(fl, line, col);
    }

    /**
     * Get the binary operator
     */
    public String operateur() {
        return "-";
    }

    /**
     * Apply the operator on the two given values.
     */
    public int apply(int value) {
        return -value;
    }

    public boolean apply(boolean value) {
        return !value;
    }
    

    /**
     * Accepts a AST visitor
     */
    Object accept(ASTVisitor visitor){
        return visitor.visit(this);
    }
}