cd framework/src
javac -d ../bin utils/*.java
javac -d ../bin etu1755/annotation/*.java
javac -d ../bin etu1755/framework/*.java
javac -d ../bin etu1755/framework/servlet/*.java
cd ..
cd bin
jar -cvf ../../fw.jar *
copy D:\ITUS4\Naina\framework\fw.jar C:\Apache\lib\fw.jar
copy D:\ITUS4\Naina\framework\fw.jar D:\ITUS4\Naina\framework\test-framework\WEB-INF\lib\fw.jar
cd ../../test-framework/src
javac -d ../WEB-INF/classes model/*.java
cd ..
jar -cvf C:\Apache\webapps\test-framework.war *