

public class Parentheses extends Expression {

    private Expression expression;
    /**
     * Constructor
     */
    public Parentheses(Expression e, String fl, int line, int col) {
        super(fl, line, col);
        this.expression = e;
    }

    public Expression getExpression() {
        return this.expression;
    }

    /**
     * Accepts a AST visitor
     */
    Object accept(ASTVisitor visitor){
        return visitor.visit(this);
    }
}
