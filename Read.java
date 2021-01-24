
public class Read extends Instruction {

    protected Expression destination;


    public Read(Expression e, String fl, int line, int col){
        super(fl, line, col);
        this.destination = e;
    }

    public Expression getDestination() {
        return this.destination;
    }

    /**
     * Accepts a AST visitor
     */
    Object accept(ASTVisitor visitor){
        return visitor.visit(this);
    }
}