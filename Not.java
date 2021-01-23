
public class Not extends Unary {
    /**
     * Constructor
     */
    public Not(String fl, int line, int col) {
        super(fl, line, col);
    }

    /**
     * Get the binary operator
     */
    public String operateur() {
        return "!";
    }

    public int apply(int value) {
        return -value;
    }
    /**
     * Apply the operator on the two given values.
     */
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