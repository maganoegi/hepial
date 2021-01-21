/*
 * Base class that represent a binary arithmetique expression node inside the AST.
*/

public abstract class Arithmetic extends Binary {
    /**
     * Constructor
     */
    public Arithmetic(String fl, int line, int col) {
        super(fl, line, col);
    }
}
