








public class Write extends Instruction {

    protected Expression expression;



    public Write(Expression e, String fl, int line, int col){
        super(fl, line, col);
        this.expression = e;
    }

    public Expression getSource() {
        return this.expression;
    }

    /**
     * Accepts a AST visitor
     */
    Object accept(ASTVisitor visitor){
        return visitor.visit(this);
    }
}
