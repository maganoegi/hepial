/*
 * Represent a function declaration instruction node inside the AST.
*/

public class ConstantDeclaration extends Instruction {
    /**
     * The declared variable identifier
     */
    protected Idf identifier;
    protected Type type;
    protected Expression expression;

    /**
     * Constructor
     */
    public ConstantDeclaration(Type t, Idf identifier, Expression expression, String fl, int line, int col){
        super(fl, line, col);
        this.identifier = identifier;
        this.type = t;
        this.expression = expression;
    }

    public Type getType() {
        return this.type;
    }

    /**
     * Get the declared variable identifier
     */
    public Idf getIdentifier() {
        return this.identifier;
    }

    public Expression getExpression() {
        return this.expression;
    }

    /**
     * Set the declared variable identifier
     */
    public void setIdentifier(Idf identifier) {
        this.identifier = identifier;
    }

    /**
     * Accepts a AST visitor
     */
    Object accept(ASTVisitor visitor){
        return visitor.visit(this);
    }
}

