
import java.util.*;

public class SemanticAnalyzer implements ASTVisitor {

	private Map<String, Class> variables;
	private boolean declarationFinished; 

	public SemanticAnalyzer() {
		this.variables = new HashMap<>();
		this.declarationFinished = false;
	}

    public Object visit(ProgramDeclaration node){
        if(node.getIdentifier().getNom().length() > 0) {
        	node.getDeclaration().accept(this);
            this.declarationFinished = true;
	        node.getInstructions().accept(this);
        } else {
        	this.displayError(node, "A name for the program has been not defined!");
        }
        return null;
    }

    public Object visit(Addition node){
    	node.getGauche().accept(this);
        node.getDroite().accept(this);
    	if(node.getGauche().getClass().equals(node.getDroite().getClass())) {
    		return null;
    	}
    	this.displayError(node, "Not same class type to addition");
        return null;
    }

    public Object visit(Division node){
    	node.getGauche().accept(this);
        node.getDroite().accept(this);
        if(node.getGauche().getClass().equals(node.getDroite().getClass())) {
    		return null;
    	}
    	this.displayError(node, "Not same class type to divide");
        return null;
    }

    public Object visit(Product node){ //ancien Produit
    	node.getGauche().accept(this);
        node.getDroite().accept(this);
        if(node.getGauche().getClass().equals(node.getDroite().getClass())) {
    		return null;
    	}
    	this.displayError(node, "Not same class type to multiply");
        return null;
    }

    public Object visit(Substraction node){
    	node.getGauche().accept(this);
        node.getDroite().accept(this);
        if(node.getGauche().getClass().equals(node.getDroite().getClass())) {
    		return null;
    	}
    	this.displayError(node, "Not same class type to substrate");
        return null;
    }

    public Object visit(Difference node){
        node.getGauche().accept(this);
        node.getDroite().accept(this);
        return null;
    }

    public Object visit(Affectation node){
        node.getDestination().accept(this);
        node.getSource().accept(this);
        System.out.println(TDS.getInstance().identifier(((Idf)node.getDestination()).getNom()));
        System.out.println(node.getSource().getClass());
        if(TDS.getInstance().identifier(((Idf)node.getDestination()).getNom()).equals(node.getSource().getClass())) {
    		return null;
    	}
    	this.displayError(node, "Not same class type to affectation");
        return null;
    }

    public Object visit(Number node){
        return null;
    }

    public Object visit(Chain node){
        return null;
    }

    public Object visit(Bool node) {
        return null;
    }

    public Object visit(SuperiorEqual node){
    	node.getGauche().accept(this);
        node.getDroite().accept(this);
        if(node.getGauche().getClass().equals(node.getDroite().getClass())) {
    		return null;
    	}
    	this.displayError(node, "Type mismatch in >=");
        return null;
    }

    public Object visit(Superior node){
    	node.getGauche().accept(this);
        node.getDroite().accept(this);
        if(node.getGauche().getClass().equals(node.getDroite().getClass())) {
    		return null;
    	}
    	this.displayError(node, "Type mismatch in >");
        return null;
    }

    public Object visit(Block node){
    	node.getInstructions().forEach(i -> i.accept(this));
        return null;
    }

    public Object visit(Condition node){
        node.getCondition().accept(this);
        if(node.hasElse()) {
            node.getElseInstruction().accept(this);
        }
        return null;
    }


    public Object visit(Type node) {
        return null;
    }

    public Object visit(Equals node){
    	node.getGauche().accept(this);
        node.getDroite().accept(this);
        if(node.getGauche().getClass().equals(node.getDroite().getClass())) {
    		return null;
    	}
    	this.displayError(node, "Type mismatch in ==");
        return null;
    }

    
    public Object visit(And node){
    	node.getGauche().accept(this);
        node.getDroite().accept(this);
        if(node.getGauche().getClass().equals(node.getDroite().getClass())) {
    		return null;
    	}
    	this.displayError(node, "Type mismatch in AND");
        return null;
    }

    public Object visit(Or node){
    	node.getGauche().accept(this);
        node.getDroite().accept(this);
        if(node.getGauche().getClass().equals(node.getDroite().getClass())) {
    		return null;
    	}
    	this.displayError(node, "Type mismatch in Or");
        return null;
    }

    public Object visit(InferiorEqual node){
    	node.getGauche().accept(this);
        node.getDroite().accept(this);
        if(node.getGauche().getClass().equals(node.getDroite().getClass())) {
    		return null;
    	}
    	this.displayError(node, "Type mismatch in <=");
        return null;
    }

    public Object visit(Inferior node){
    	node.getGauche().accept(this);
        node.getDroite().accept(this);
        if(node.getGauche().getClass().equals(node.getDroite().getClass())) {
    		return null;
    	}
    	this.displayError(node, "Type mismatch in <");
        return null;
    }

    public Object visit(Write node){
        node.getSource().accept(this);
        return null;
    }

    public Object visit(Read node){
        node.getDestination().accept(this);
        return null;
    }

    public Object visit(For node){
        node.getIteratorName().accept(this);
        node.getFrom().accept(this);
        node.getTo().accept(this);
        node.getInstruction().accept(this);
        return null;
    }

    public Object visit(ConstantDeclaration node) {
        node.getIdentifier().accept(this);

        if(!this.variables.containsKey(node.getIdentifier().getNom())) {
     		this.variables.put(node.getIdentifier().getNom(), node.getType().getClass());
     		if(node.getIdentifier().getClass().equals(node.getConstantExpression().getClass())) {
     			return null;
     		}
     		this.displayError(node, "Not same class type in declaration constant");
     		return null;
        }
        this.displayError(node, node.getIdentifier().getNom() + " has already been declared");
        return null;
    }

    public Object visit(VariableDeclaration node) {
        node.getIdentifier().accept(this);

        if(!this.variables.containsKey(node.getIdentifier().getNom())) {
     		this.variables.put(node.getIdentifier().getNom(), node.getType().getClass());
     		return null;
        }
        this.displayError(node, node.getIdentifier().getNom() + " has already been declared");
        return null;
    }

    public Object visit(True node){
        return null;
    }

    public Object visit(False node){
        return null;
    }

    public Object visit(Idf node){
    	if(this.variables.containsKey(node.getNom())) {
    		return null;
    	}
    	if(this.declarationFinished) {
    		this.displayError(node, node.getNom() + " has not been declared in header!");
    	}
        return null;
    }

    public Object visit(Tilda node){
        node.getOperand().accept(this);
        if(node.getOperand().getClass().equals(Bool.class)) {
        	return null;
        }
        this.displayError(node, "Variable needs to be a boolean for Tilda operator");
        return null;
    }

    public Object visit(Minus node){
        node.getOperand().accept(this);
        if(node.getOperand().getClass().equals(Int.class)) {
        	return null;
        }
        this.displayError(node, "Variable needs to be a integer for Minus operator");
        return null;
    }

    public Object visit(Not node){
        node.getOperand().accept(this);
        if(node.getOperand().getClass().equals(Bool.class)) {
        	return null;
        }
        this.displayError(node, "Variable needs to be a boolean for Not operator");
        return null;
    }

    public Object visit(Parentheses node){
        node.getExpression().accept(this);
        return null;
    }

    public Object visit(While node){
        node.getCondition().accept(this);
        node.getInstruction().accept(this);
        return null;
    }

    public void displayError(ASTNode node, String message) {
    	System.out.println(message + "\n\tLine : " + (node.getLine() + 1) + " Col : " + node.getColumn());
        System.exit(0);
    }

}
