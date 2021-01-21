/*
 * Represent a function declaration instruction node inside the AST.
*/

public class VariableDeclaration extends Instruction {
    /**
     * The declared variable identifier
     */
    protected Idf identifier;
    protected Type type;

    /**
     * Constructor
     */
    public VariableDeclaration(Type t, Idf identifier, String fl, int line, int col){
        super(fl, line, col);
        this.identifier = identifier;
        this.type = t;
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

