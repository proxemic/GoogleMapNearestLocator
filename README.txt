Prerequisite
============
1. Have JDK 1.6 and above installed.
2. Have Maven 3 and above installed.
3. Have JAVA_HOME set in environment variable.
4. Have MAVEN_HOME set in environment variable.

Step to run the test
=====================
1. Clone from test repo.
2. Start derby database by running /derby/start.cmd, or run "java -jar derbyrun.jar server start" in terminal/command prompt
3. Open another terminal/command prompt and go into /fsecure/ directory and Run "mvn install"
4. Start application server / web container (for eg:tomcat)
5. Deploy fsecure.war generated in /fsecure/target/ into web container or application server.
6. Access to <host>:<port>/fsecure

To test the functionality
==========================
Click on any part of the map and json data will populate on top of page.