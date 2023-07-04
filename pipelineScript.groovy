
pipeline {
    agent any
    tools {
        maven 'maven3.5'
        jdk 'jdk11'
    }
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }

        stage ('Build') {
         steps {
                sh "cd maven-project"
 		withMaven {
                 
                 sh "mvn clean install"
              }  
	}	
	post {
                success {
                    junit 'maven-project/target/surefire-reports/**/*.xml' 
                }
            }
        }
    }
}
