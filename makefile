JAVA=java
JAVAC=javac
JFLEX=jflex
JAVACUP=java-cup-11a.jar
CLASSPATH=$(JAVACUP):.:./TDS:./ArbreAbstrait

FILE_FLEX=hepial.flex
FILE_CUP=hepial.cup
FILE_JAVA_NAME=Hepialc
FILE_TEST_PRG_NAME=test

TEST_CLASS=test

FILE=test.txt
ifdef TESTFILE
	FILE=$(TESTFILE)
endif

all : $(FILE) sym.class parser.class $(FILE_JAVA_NAME).class $(FILE_TEST_PRG_NAME).class
	$(JAVA) -classpath $(CLASSPATH) $(TEST_CLASS) $(FILE)

$(FILE_JAVA_NAME).java : $(FILE_FLEX)
	$(JFLEX) $(FILE_FLEX)

sym.java parser.java : $(FILE_CUP)
	$(JAVA) -jar $(JAVACUP) $(FILE_CUP)

%.class : %.java
	$(JAVAC) -classpath $(CLASSPATH) $<

clean :
	rm -rf *class TDS/*class ArbreAbstrait/*class *~ parser.java sym.java