

import java.util.Vector;
import java.io.FileReader;
import java_cup.runtime.Symbol;

// make clean; java -jar java-cup-11a.jar -interface -parser parser hepial.cup ; java -jar jflex-1.7.0/lib/jflex-full-1.7.0.jar hepial.flex; javac -cp java-cup-11a-runtime.jar:. *.java
// make clean; java -jar java-cup-11a.jar -parser parser hepial.cup ; java -jar jflex-1.7.0/lib/jflex-full-1.7.0.jar hepial.flex; javac -cp java-cup-11a.jar:. *.java

// import ProgramDeclaration;

public class Hepialc {
    public static void main(String[] arg) {
            // parser myP = new parser(new HepialLexer(new FileReader(arg[1])));
            try { FileReader myFile = new FileReader(arg[0]);
                HepialLexer myLex = new HepialLexer(myFile);
                parser myP = new parser(myLex);
                try {
                    System.out.println("\n______________________ CREATING THE AST ______________________");
                    ProgramDeclaration program = (ProgramDeclaration)myP.parse().value;
                    if (program == null) { System.out.println("non-existing AST"); return; }

                    System.out.println("\n______________________ REGENERATION SOURCE CODE FROM AST ______________________");
                    SourceCodeGenerator generator = new SourceCodeGenerator();
                    program.accept(generator);
                    System.out.println(generator.getCode());

                    System.out.println("\n______________________ SEMANTIC ANALYSIS ______________________");
                    SemanticAnalyzer analyzer = new SemanticAnalyzer();
                    program.accept(analyzer);

                }
                catch (Exception e) {
                    System.out.println("parse error" + e);
                }
            }
            catch (Exception e){
                System.out.println("invalid file");
            }
    }
}