/*
 * Source code generator that walks the AST and generates code source from the AST
 *
 * @author Stephane Malandain 
 */

import java.util.*;

public class SourceCodeGenerator implements ASTVisitor{

    /**
     * Generated code
     */
    private String code = "";
    /**
     * Depth level (tabulations)
     */
    private int level = 0;
    /**
     * If we are currently declaring function parameters
     */
   //  private boolean isParameterDeclaration = false;

    /**
     * Adds tabulation with current level
     */
    private void addTabulation(){
        addTabulation(level);
    }

    /**
     * Adds tabulation with spacified level
     */
    private void addTabulation(int level){
        for (int i = 0;i < level; i++)
            code += "    ";
    }

    public Object visit(Addition node){
        node.getGauche().accept(this);
        code += " + ";
        node.getDroite().accept(this);
        return null;
    }

    public Object visit(Affectation node){
        node.getDestination().accept(this);
        code += " = ";
        node.getSource().accept(this);
        code += ";";
        return null;
    }

    public Object visit(Block node){
        for (Instruction inst: node.getInstructions()){
            code += "\n";
            addTabulation();
            inst.accept(this);
        }
        return null;
    }

    public Object visit(Chain node){
        code += node.getValeur();
        return null;
    }

    public Object visit(Condition node){
        code += "si ";
        node.getCondition().accept(this);
        code += " alors";
        level += 1;
        node.getThenInstruction().accept(this);
        if (node.hasElse()){
            code += "\n";
            addTabulation(level - 1);
            code += "sinon";
            node.getElseInstruction().accept(this);
        }
        level -= 1;
        code += "\n";
        addTabulation();
        code += "finsi";
        return null;
    }
/*
    public Object visit(DeclarationConstant node){
        Symbole sym = TDS.getInstance().identifier(new Entree(node.getIdentifier().getNom()));

        code += sym + " ";
        node.getIdentifier().accept(this);
        code += " = ";
        node.getConstantExpression().accept(this);
        code += ";";
        return null;
    }
*/
    public Object visit(ProgramDeclaration node){
        /* TDS.getInstance().resetBlocNumber();

        TDS.getInstance().entreeBloc();
        level += 1;
        */
        code += "programme ";
        // node.getIdentifier().accept(this);
        // node.getDeclaration().accept(this);
        code += "\ndebutprg";
        node.getInstructions().accept(this);
        code += "\nfinprg";

        /*
        TDS.getInstance().sortieBloc();
        level -= 1;
        */
        return null;
    }

    // public Object visit(DeclarationVariable node){
    //     Symbole sym = TDS.getInstance().identifier(new Entree(node.getIdentifier().getNom()));

    //     code += sym + " ";
    //     node.getIdentifier().accept(this);
    //     if (!isParameterDeclaration)
    //         code += ";";
    //     return null;
    // }

    public Object visit(Difference node){
        node.getGauche().accept(this);
        code += " <> ";
        node.getDroite().accept(this);
        return null;
    }

    public Object visit(Division node){
        node.getGauche().accept(this);
        code += " / ";
        node.getDroite().accept(this);
        return null;
    }

    // public Object visit(Ecrire node){
    //     code += "ecrire ";
    //     node.getSource().accept(this);
    //     code += ";";
    //     return null;
    // }

    public Object visit(Equals node) {
        node.getGauche().accept(this);
        code += " == ";
        node.getDroite().accept(this);
        return null;
    }

    /*
    public Object visit(Et node){
        node.getGauche().accept(this);
        code += " et ";
        node.getDroite().accept(this);
        return null;
    }

    public Object visit(Faux node){
        code += "faux";
        return null;
    }
*/
    public Object visit(Idf node){
        code += node.getNom();
        return null;
    }
/*
    public Object visit(InfEgal node){
        node.getGauche().accept(this);
        code += " <= ";
        node.getDroite().accept(this);
        return null;
    }

    public Object visit(Inferieur node){
        node.getGauche().accept(this);
        code += " < ";
        node.getDroite().accept(this);
        return null;
    }

    public Object visit(Lire node){
        code += "lire ";
        node.getDestination().accept(this);
        code += ";";
        return null;
    }

    public Object visit(Moins node){
        code += "-";
        node.getOperand().accept(this);
        return null;
    }
*/
    public Object visit(Number node){
        code += Integer.toString(node.getValeur());
        return null;
    }

    // public Object visit(Non node){
    //     code += "non ";
    //     node.getOperand().accept(this);
    //     return null;
    // }

    // public Object visit(Ou node){
    //     node.getGauche().accept(this);
    //     code += " ou ";
    //     node.getDroite().accept(this);
    //     return null;
    // }

    // public Object visit(Parentheses node){
    //     code += "(";
    //     node.getExpression().accept(this);
    //     code += ")";
    //     return null;
    // }

    public Object visit(Pour node){
        code += "pour ";
        node.getIteratorName().accept(this);
        code += " allantde ";
        node.getFrom().accept(this);
        code += " a ";
        node.getTo().accept(this);
        code+= " faire";
        level += 1;
        node.getInstruction().accept(this);
        level -= 1;
        code += "\n";
        addTabulation();
        code += "finpour";
        return null;
    }

    public Object visit(Product node){
        node.getGauche().accept(this);
        code += " * ";
        node.getDroite().accept(this);
        return null;
    }

    // public Object visit(Retour node){
    //     code += "retourne ";
    //     node.getSource().accept(this);
    //     code += ";";
    //     return null;
    // }

    public Object visit(Substraction node){
        node.getGauche().accept(this);
        code += " - ";
        node.getDroite().accept(this);
        return null;
    }

    // public Object visit(SupEgal node){
    //     node.getGauche().accept(this);
    //     code += " >= ";
    //     node.getDroite().accept(this);
    //     return null;
    // }

    // public Object visit(Superieur node){
    //     node.getGauche().accept(this);
    //     code += " > ";
    //     node.getDroite().accept(this);
    //     return null;
    // }

    public Object visit(While node){
        code += "tantque ";
        node.getCondition().accept(this);
        code += " faire";
        level += 1;
        node.getInstruction().accept(this);
        level -= 1;
        code += "\n";
        addTabulation();
        code += "fintantque";
        return null;
    }

    // public Object visit(Tilda node){
    //     code += "~";
    //     node.getOperand().accept(this);
    //     return null;
    // }

    // public Object visit(Vrai node){
    //     code += "vrai";
    //     return null;
    // }

    public String getCode(){
        return code;
    }
}
