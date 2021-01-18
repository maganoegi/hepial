


class SemanticAnalyzer implements ASTVisitor {
    private static String ncf = "Source et dest. non conformes";
    private static String eb = "Expression booléenne attendue";
    private static String nd = "Identificateur non déclaré";
    private static String ti = "Typage incorrect";
    private static TDS tds = TDS.getInstance();
    

    
    public Object visiter (Affectation a) {
        /* La visite commence par une visite de la partie gauche de l’affectation pour
            fixer son type. Ensuite, le singleton Evaluateur est envoyé visiter l’expression
            source pour tenter son calcul : si l’expression est constante, la valeur remplace
            l’expression elle-même. La visite de la source lui attribue ensuite un type. Le test
            de conformité entre le type de la destination et celui de la source est délégué à
            l’opération booléenne estConforme de la classe Type. */

        a.destination().accepter(this);
        Type typeDest = a.destination().type();
        Object v = a.source().accepter(Evaluateur.getInstance());
        if (v != null) {
            a.setSource(new Nombre( (Integer)v, ligne() ) );
            a.source().accepter(this);
        }

        Type typeSource = a.source().type();

        if (!(typeSource.estConforme(typeDest)) ) {
            erreur(a, ncf);
        } else {
            a.setType(typeDest);
            return null;
        }
    }

    public Object visiter (Condition c) {
        /* Comme dans le cas de l’affectation, la visite de l’arbre abstrait d’une condi-
        tion commence par un essai d’optimisation. Le singleton visiteur Evaluateur est
        envoyé visiter la condition pour en calculer la valeur. Si cela est possible, cette
        valeur remplace définitivement l’expression. Sinon la visite de la condition par
        le visiteur AnalyseurSemantique doit lui attribuer le type booléen. Pour finir,
        les deux listes d’instructions formant les parties Alors et Sinon sont visitées par
        l’analyseur sémantique. */

        Object v = c.condition().accepter(Evaluateur.getInstance());
        if (v != null)
            c.setValeurCondition( ((Integer) v).intValue() );
        else {
            c.condition().accepter(this);
            if (c.condition().type() != TypeBooleen.getInstance())
                erreur(c, eb);
            } // if
            c.alors().accepter(this);
            c.sinon().accepter(this);
        return null;
    } // visiter;

    public Object visiter (Idf i) {
        /* Selon les règles sémantiques, l’identification d’une feuille Idf porte en priorité
        sur une variable locale ou un paramètre : cette recherche est déléguée à la méthode
        identifier de la classe TDS. En cas de recherche fructueuse, le symbole correspon-
        dant est attaché à l’identificateur, sinon le gestionnaire reçoit un message d’erreur. */

        // On cherche d’abord une variable locale ou un paramètre
        EntreeVarLocPar evlp = new EntreeVarLocPar(i);
        Symbole symb = tds.identifier(evlp);
        if (symb == null) {
            erreur (i, nd);
            i.setSymbole(symb);
        }
        return null;
    } // visiter;

    public Object visiter (Nombre n) {
        /* La visite d’une feuille Nombre se contente de décorer l’instance avec son type.
        Celui-ci est défini par l’instance unique de TypeEntier.  */

        n.setType( Int.getInstance());
        return null;
    } // visiter;

    public Object visiter (Arithmetique a) {
        /* Comme les règles sémantiques des quatre opérandes arithmétiques sont iden-
        tiques, le contrôle est factorisé dans la méthode visiter(Arithmetique a). Il
        se résume à la visite des deux opérandes, à la consultation de leur type calculé
        lors de la visite pour les comparer. La comparaison est déléguée à la méthode
        estConforme définie dans les sous-classes de Type. Si aucune erreur n’est détectée,
        le type des opérandes définit le type du noeud visité a. Le choix est fait ici de ne
        retourner aucun résultat, mais plutôt d’attacher une information au noeud visité
        pour décorer l’arbre. */
        
        a.gauche().accepter(this);
        Type tg = a.gauche().getType();
        a.droit().accepter(this);
        Type td = a.droit().getType();
        if (tg.estConforme(td)) {
            a.setType(tg);
        } else {
            erreur(a, ti);
        }
        return null;
    } // visiter;
}
