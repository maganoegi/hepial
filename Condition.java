

public class Condition extends Instruction {
    protected Expression condition;
    protected Block thenInstruction;
    protected Block elseInstruction;

    public Condition(Expression condition, Block then, Block els, String fl, int line, int col){
        super(fl, line, col);
        this.condition = condition;
        this.thenInstruction = then;
        this.elseInstruction = els;
    }

    public Condition(Expression condition, Block then, String fl, int line, int col){
        super(fl, line, col);
        this.condition = condition;
        this.thenInstruction = then;
    }

    public Expression getCondition() {
        return this.condition;
    }

    public Instruction getThenInstruction() {
        return this.thenInstruction;
    }

    public boolean hasElse() {
        return this.elseInstruction != null;
    }

    public Instruction getElseInstruction() {
        return this.elseInstruction;
    }


    /**
     * Accepts a AST visitor
     */
    Object accept(ASTVisitor visitor){
        return visitor.visit(this);
    }
}
