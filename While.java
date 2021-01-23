

public class While extends Instruction {
    protected Expression condition;
    protected Block instructions;

    public While(Expression condition, Block then, String fl, int line, int col){
        super(fl, line, col);
        this.condition = condition;
        this.instructions = then;
    }

    public Expression getCondition() {
        return this.condition;
    }

    public Instruction getInstruction() {
        return this.instructions;
    }

    /**
     * Accepts a AST visitor
     */
    Object accept(ASTVisitor visitor){
        return visitor.visit(this);
    }
}
