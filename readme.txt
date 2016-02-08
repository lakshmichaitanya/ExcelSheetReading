1. mvn archetype:generate -DgroupId=xlreading -DartifactId=XlReader -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

> u got project, goto XlReader folder
> copu dipendancys to pom 
> copy your java files to xlreading package under src/main/java
then compile like as follow..

2. mvn compile

> run as follow

3.mvn exec:java -Dexec.mainClass="xlreading.XlReading" 
