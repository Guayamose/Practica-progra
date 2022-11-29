limpiar:
	rm -rf bin 
	rm -rf *.jar
	rm -rf *.class
	rm -rf html
	rm -rf camisetas.txt

compilar:limpiar
	mkdir bin
	find src -name "*.java" | xargs javac -cp bin -d bin

jar:compilar
	jar cvfm catalogo.jar manifest.txt -C bin .

html:jar
	mkdir html
	find src -type f -name "*.java" | xargs javadoc -d html -encoding utf-8 -docencoding utf-8 -charset utf-8 
 
catalogo:html
	java -jar catalogo.jar	
