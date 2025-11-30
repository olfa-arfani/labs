# Guide to configure github polling on remote EC2 jenkins server

- Go to (administrer)Manage Jenkins > Credentials
![img manage_credentials](./captures/manage_credentials.png)

- Go to "global", store "jenkins" > Add Credentials

- By using Github PAT (Personal Access Token)
Choose in Jenkins 
* mode Username with password
* Scope: Global (Jenkins, nodes…)
* Username: give it a name (any name)
* Password: paste your PAT

- Enter OK

- Go back to dashboard and "New item"

- Create Pipeline  

- Put Description and some config

- Under "Build triggers" : choose Github hook trigger for GitSCM polling

- In Git block

* Def : Pipeline script from SCM
* SCM : Git
* Repo URL : [https://github.com/olfa-arfani/labs.git]
* Branch to build: keep it empty, it will then take default main branch configured in remote Github repo. If you want to test on specific branch then mention it in this field or put a regex ex : */feature-*
* (N/A) Add some behaviour if you want to work with submodules

- Go to your Github Repo
Settings > Webhooks > Add webhook

* In Payload URL add your Jenkins server address, adding /github-webhook/ at the final, to look like: http://{IP Jenkins Server}:8080/github-webhook/
* In Content type, choose application/json
* Leave Secret blank
* Choose in which events you want to trigger the webhook
* Check the Active checkbox
* Add webhook
* Kepp polling only on push event

- Add in Jenkins this groovy code to make mvn clean install anytime team member push change

```
pipeline {
    agent any
    tools {
        maven 'Maven 3.9.3'
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
                sh 'mvn -Dmaven.test.failure.ignore=true install' 
            }
            post {
                success {
                    junit 'target/surefire-reports/**/*.xml' 
                }
            }
        }
    }
}
```