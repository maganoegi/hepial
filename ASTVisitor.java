/*
 * AST visiteur interface
*/

import java.util.*;

public interface ASTVisitor {
    Object visit(Addition node);
    Object visit(Affectation node);
    // Object visit(Call node);
    Object visit(Block node);
    Object visit(Chain node);
    Object visit(Condition node);
    Object visit(ConstantDeclaration node);
    // Object visit(DeclarationFonction node);
    Object visit(ProgramDeclaration node);
    Object visit(VariableDeclaration node);
    Object visit(Difference node);
    Object visit(Division node);
    Object visit(Write node); //TODO
    Object visit(Equals node);
    Object visit(And node);
    Object visit(False node);
    Object visit(Idf node);
    // Object visit(Indice node);
    Object visit(InferiorEqual node);
    Object visit(Inferior node);
    Object visit(Read node);
    Object visit(Minus node);
    Object visit(Number node);
    Object visit(Not node);
    Object visit(Or node);
    Object visit(Parentheses node);
    Object visit(For node);
    Object visit(Product node);
    Object visit(Substraction node);
    Object visit(SuperiorEqual node);
    Object visit(Superior node);
    Object visit(While node);
    Object visit(Tilda node);
    Object visit(True node);
}

















































































