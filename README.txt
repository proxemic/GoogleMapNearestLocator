Prerequisite
============
1. Have JDK 1.6 and above installed.
2. Have Maven 3 and above installed.
3. Have JAVA_HOME set in environment variable.
4. Have MAVEN_HOME set in environment variable.

Step to run the test
=====================
1. Clone from test repo.
2. Go into /fsecure/ directory and Run "mvn install"
3. Start derby database by running /derby/start.cmd, or run "java -jar derbyrun.jar server start" in terminal/command prompt
3. Deploy fsecure-1.0-SNAPSHOT.war generated in /fsecure/target/ into web container or application server. (Server must be started)
4. Access to <host>:<port>/fsecure

To test the functionality
==========================
Click on any part of the map and json data will populate on top of page.