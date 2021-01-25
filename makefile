








JAVACUP=java-cup-11a.jar
CLASSPATH=.:$(JAVACUP)
JFLEX=jflex-1.7.0/lib/jflex-full-1.7.0.jar

all : 
	java -jar java-cup-11a.jar -parser parser hepial.cup
	java -jar jflex-1.7.0/lib/jflex-full-1.7.0.jar hepial.flex
	javac -cp .:java-cup-11a.jar *.java
	java -cp .:java-cup-11a.jar Hepialc test.hepial

clean :
	rm -rf *class TDS/*class ArbreAbstrait/*class *~ parser.java sym.java $(FILE_LEXER).java