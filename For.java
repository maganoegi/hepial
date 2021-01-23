




public class For extends Instruction {
    protected Idf iterator;
    protected Expression from;
    protected Expression to;
    protected Block instruction;

    public For(Idf id, Expression from, Expression to, Block instruction, String fl, int line, int col){
        super(fl, line, col);
        this.iterator = id;
        this.from = from;
        this.to = to;
        this.instruction = instruction;
    }

    public String getIteratorName() {
        return this.iterator.getNom();
    }

    public Expression getFrom() {
        return this.from;
    }

    public Expression getTo() {
        return this.to;
    }

    public Instruction getInstruction() {
        return this.instruction;
    }


    /**
     * Accepts a AST visitor
     */
    Object accept(ASTVisitor visitor){
        return visitor.visit(this);
    }
}
