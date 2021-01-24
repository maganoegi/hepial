



# JAVA=java
# JAVAC=javac
# JFLEX=./jflex-1.7.0/lib/jflex-full-1.7.0.jar
# JAVACUP=java-cup-11a.jar
# JAVACUP_RT=java-cup-11a-runtime.jar
# CLASSPATH=$(JAVACUP):.


# FILE_FLEX=hepial.flex
# FILE_CUP=hepial.cup
# FILE_JAVA_NAME=HepialLexer

# TEST_CLASS=Hepialc

# FILE=test.hepial

# PARSER_FILE=parser
# SYMBOLS_FILE=sym

# ifdef TESTFILE
# 	FILE=$(TESTFILE)
# endif

# all : $(FILE) $(PARSER_FILE).class $(SYMBOLS_FILE).class $(FILE_JAVA_NAME).class $(TEST_CLASS).class
# 	$(JAVA) -classpath $(JAVACUP_RT) $(PACKAGE).$(TEST_CLASS) $(FILE)

# $(FILE_JAVA_NAME).java : $(FILE_FLEX)
# 	$(JAVA) -jar $(JFLEX) $(FILE_FLEX)

# sym.java parser.java : $(FILE_CUP)
# 	$(JAVA) -cp $(JAVACUP_RT) -jar $(JAVACUP) -package hepial $(FILE_CUP)

# %.class : %.java
# 	$(JAVAC) -cp $(JAVACUP_RT) -sourcepath . $<

# clean :
# 	/bin/rm -rf $(PATH)*class *class *~ $(PARSER_FILE).java $(SYMBOLS_FILE).java $(FILE_JAVA_NAME).java












JAVACUP=java-cup-11a.jar
CLASSPATH=.:$(JAVACUP)
JFLEX=jflex-1.7.0/lib/jflex-full-1.7.0.jar

all : build

build : $(SRC) sym.class parser.class HepialLexer.class Hepialc.class
	java -classpath $(JAVACUP) $(TEST_CLASS) Hepialc test.hepial


%.class : %.java
	javac -cp $(CLASSPATH) *.java

sym.java parser.java : hepial.cup
	java -jar $(JAVACUP) -parser parser hepial.cup

HepialLexer.java: hepial.flex
	java -jar $(JFLEX) hepial.flex

clean:
	rm -rf *.class tds/*.class error_manager/*.class ast/*.class ast_visitors/*.class *~ parser.java HepialLexer.java sym.java


# JAVA=java
# JAVAC=javac
# JFLEX=jflex-1.7.0/lib/jflex-full-1.7.0.jar
# JAVACUP=java-cup-11a.jar
# JAVACUP_RT=java-cup-11a-runtime.jar
# CLASSPATH=$(JAVACUP):.:./TDS:./ArbreAbstrait
# CLASSPATH_RT=$(JAVACUP_RT):.:./TDS:./ArbreAbstrait
# PACKAGE=hepial

# FILE_FLEX=hepial.flex
# FILE_CUP=hepial.cup
# FILE_LEXER=HepialLexer
# TEST_CLASS=Hepialc
# FILE=test.hepial

# all : sym.class parser.class $(FILE_LEXER).class $(TEST_CLASS).class
# 	$(JAVA) -classpath $(JAVACUP_RT) $(TEST_CLASS)

# %.class : %.java
# 	$(JAVAC) -classpath  $(CLASSPATH) $<

# sym.java parser.java : $(FILE_CUP)
# 	$(JAVA) -jar $(JAVACUP) $(FILE_CUP)

# $(FILE_LEXER).java : $(FILE_FLEX)
# 	$(JFLEX) $(FILE_FLEX)


# clean :
# 	rm -rf *class TDS/*class ArbreAbstrait/*class *~ parser.java sym.java $(FILE_LEXER).java