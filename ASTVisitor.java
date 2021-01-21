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
    // Object visit(Condition node);
    // Object visit(DeclarationConstant node);
    // Object visit(DeclarationFonction node);
    Object visit(ProgramDeclaration node);
    // Object visit(DeclarationVariable node);
    Object visit(Difference node);
    Object visit(Division node);
    // Object visit(Ecrire node);
    Object visit(Equals node);
    Object visit(And node);
    // Object visit(Faux node);
    Object visit(Idf node);
    // Object visit(Indice node);
    Object visit(InferiorEqual node);
    Object visit(Inferior node);
    // Object visit(Lire node);
    // Object visit(Moins node);
    Object visit(Number node);
    // Object visit(Non node);
    Object visit(Or node);
    // Object visit(Parentheses node);
    // Object visit(Pour node);
    Object visit(Product node);
    Object visit(Substraction node);
    Object visit(SuperiorEqual node);
    Object visit(Superior node);
    // Object visit(Tantque node);
    // Object visit(Tilda node);
    // Object visit(Vrai node);
}

















































































