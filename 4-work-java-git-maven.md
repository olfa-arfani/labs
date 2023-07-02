Go to
- Administrer>Tools

- Configure JDK
- Configure Git
- Configure maven


- Git clone maven project
repo link : https://github.com/jleetutorial/maven-project

Try to build and install web app

```
mvn clean install
```

- Create our first maven project from freestyle project

- source code management Git : here we need to mention git repo URL

- localMaven : clean package
This step goes to maven different build phases(validate, compile, test, package, verify, install, deploy)

In order to have the Maven Project  type, you will need to install the Maven Project Plugin.

https://wiki.jenkins-ci.org/display/JENKINS/Maven+Project+Plugin If you are building a complicated maven project, definitely pick the maven project type here, this is a project template that Jenkins has reserved specifically for Maven-based projects.

If you got the below errors while putting the Github URL on Jenkins:

Failed to connect to repository : Error performing command: C:\Git\bin ls-remote -h https://github.com/jleetutorial/maven-project.git HEAD  

or 

Failed to connect to repository : Error performing command: C:\Users\mks7kor\AppData\Local\Programs\Git\cmd ls-remote -h https://github.com/jleetutorial/maven-project.git HEAD 

Solution:

Step 1: Find out where GIT is installed on your laptop (For Linux/Mac Users, you can run which git to find out the full path of GIT), 

Step 2: In the Path to Git executable  field on the below Global Tool Configuration  section, put the full path to GIT.

If you are using Windows, you might need to add exe extension to the end of git as well ( use git.exe  instead of git )