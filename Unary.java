
public abstract class Unary extends Expression {
    /**
     * The expression at its left
     */
    protected Expression operand;
    /**
     * Constructor
     */
    public Unary(String fl, int line, int col) {
        super(fl, line, col);
    }

    /**
     * Get the left expression
     */
    public Expression getOperand() {
        return this.operand;
    }

    /**
     * Get the binary operator.
     * Must be implemented by the child class.
     */
    public abstract String operateur();

    /**
     * Set the left expression
     */
    public void lier(Expression exp) {
        this.operand = exp;
    }

    public abstract int apply(int value);
    /**
     * Apply the operator on the two given values.
     * Must be implemented by the child class.
     */
    public abstract boolean apply(boolean value);

    /**
     * Transform this node into a visualisable string
     */
    public String toString() {
        return this.operateur() + " " + this.operand;
    }
}

