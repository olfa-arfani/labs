# Make sure Java is installed in your machine or use openjdk11

## check .bash_profile or .bashrc depending on your environment settings

```
vi ~/.bash_profile
```

Depending on env

- C shell
```
setenv JAVA_HOME jdk-install-dir
setenv PATH $JAVA_HOME/bin:$PATH
export PATH=$JAVA_HOME/bin:$PATH
```
(jdk-install-dir  is the JDK installation)director, which should be something similar to /usr/java/jdk1.5.0_07/bin/java

- Bourne shell:

```
JAVA_HOME=<jdk-install-dir>
export JAVA_HOME
PATH=$JAVA_HOME/bin:$PATH
export PATH
```

- Korn and bash shells:

```
export JAVA_HOME=<jdk-install-dir>
export PATH=$JAVA_HOME/bin:$PATH
```
Type the following command to activate the new path settings immediately:

```
source ~/.bash_profile 
```
Verify new settings:$ echo $JAVA_HOME

``` 
echo $PATH
```

- Windows CMD

```
dir env:
$env:JAVA_HOME = <jdk-install-dir>
```

# Command line jenkins installation
There are many ways to install Jenkins:
- With package installer
- with wget with Redhat pkg
- (Mac) with brew example : `brew install jenkins-lts`

Here are steps to install on linux distribution using wget 
- INSTALL wget
- Download Jenkins repo
- Import required key
- Install Jenkins
- Enable Jenkins
- Start Jenkins


Example for Jenkins installation with wget 

```
sudo yum install -y wget

sudo wget -O /etc/yum.repos.d/jenkins.repo https://pkg.jenkins.io/redhat-stable/jenkins.repo

sudo rpm --import https://pkg.jenkins.io/redhat-stable/jenkins.io-2023.key

 sudo yum install -y jenkins

 sudo systemctl enable jenkins

 sudo systemctl start jenkins
 ```