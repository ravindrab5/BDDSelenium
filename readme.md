Cucumber BDD Framework
Uses cucumber to collect requirements in form of readable .feature files. Further definitions to those requirements would give use full fledged scripts.

Local Setup
Clone/pull the required files and open the gradle project in intellij.

Execution
Executing locally in IDE

Create run configuration for Runner.java and in command line argument use

-env localhost -tags @smoke
Arguments :-

-env - This will tell Runner which environment scripts should get executed.

-tags - This is label given to scenarios in .feature file . Say eg 'smoke' is given label . If all scenarios with label 'smoke' is to be executed then then pass this parameter -tags @smoke.

Executing using jar

Jar can be created by executing gradle

gradle shadowJar
Executable jar can be executed with parameters as below

C:\execution>java -jar BDDSelenium-1.0-SNAPSHOT-all.jar -env localhost -tags @smoke