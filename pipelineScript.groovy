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
 		    withMaven {
        		dir('maven-project'){
	                 	sh "mvn clean install"
				}
			}
            realtimeJUnit('**/target/surefire-reports/TEST-*.xml') {
                dir('maven-project'){
                    sh 'mvn -Dmaven.test.failure.ignore=true clean verify'
                }
            }
          }     
	     
        }
    }
}
