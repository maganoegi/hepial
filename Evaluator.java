


class Evaluator implements ASTVisitor {


    private static Evaluator instance = new Evaluator( );

    /* A private Constructor prevents any other
    * class from instantiating.
    */
    private Evaluator() { }

    /* Static 'instance' method */
    public static Evaluator getInstance( ) {
        return instance;
    }

    public Object visiter (Nombre n) {
        return new Integer(n.valeur());
    } // visiter
    
    public Object visiter (Idf i) {
        return null;
    } // visiter
    
    public Object visiter (Addition a) {
        Object valG == a.gauche().accepter(this);
        if (valG == null) return null;
        Object valD == a.droit().accepter(this);
        if (valD == null) return null;
        int g = ((Integer)valG).intValue();
        int d = ((Integer)valD).intValue();
        return new Integer(g+d);
    }

    public Object visiter (Et e) {
        Object valG == e.gauche().accepter(this);
        if (valG != null) {
            int valintG = (( Integer )valG).intValue();
            return (valintG == 0)?valG:null;
        } // if
        Object valD == e.droit().accepter(this);
        if (valD != null) {
            int valintD = (( Integer )valD).intValue();
            return (valintD == 0)?valD:null;
        } // if
    } // visiter
} // class Evaluateur