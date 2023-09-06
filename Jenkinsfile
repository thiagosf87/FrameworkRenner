def AGENT_LABEL = null
def mvn_version = 'M3'

node('AS2590'){
     stage('Set agent'){
        AGENT_LABEL = "AS2590"
   }
}
pipeline {

    agent {
       label "${AGENT_LABEL}"
    }

    stages {
        stage('Checkout') {
            steps {
                sh "rm -rf ./target"
                echo "Git clone! ${params.BRANCH}".replaceAll( 'origin/', '' )
                git branch : "${params.BRANCH}".replaceAll( 'origin/', '' ), url: 'http://gitlab.lojasrenner.com.br/dbserver/novo-cd-capacitacao.git', credentialsId: 'git-integration'
            }
        }
        stage ('Validate selenium grid'){
            steps {
                sh '''
                #!/bin/bash
                        
                set -e
                        
                while ! curl -sSL "http://localhost:4444/wd/hub/status" 2>&1 \
                    | jq -r '.value.ready' 2>&1 | grep "true" >/dev/null; do
                    echo 'Waiting for the Grid'
                    sleep 1
                done
                >&2 echo "Selenium Grid is up - executing tests"
                    
            '''
            }
        }    
        stage('Build and Test') {
            steps {
                sh "mvn clean compile"
                sh "mvn -s"./settings.xml -Drunner.class=Web -Dambiente=HML01 -Dnavegador=remote -Dcucumber.filter.tags=@cadastro -Dcucumber.plugin=json:target/cucumber.json clean test"
                #sh "mvn -s"./settings.xml -Drunner.class=Web -Dambiente=\"${params.AMBIENTE}\" -Dnavegador=remote -Dcucumber.filter.tags=\"${params.TAG}\" -Dcucumber.plugin=json:target/cucumber.json clean test"

           }

            post {
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
                always {
                cucumber buildStatus: 'UNSTABLE',
                failedFeaturesNumber: 1,
                failedScenariosNumber: 1,
                skippedStepsNumber: 1,
                failedStepsNumber: 1,
                reportTitle: 'My report',
                fileIncludePattern: '**/target/cucumber.json',
                sortingMethod: 'ALPHABETICAL',
                trendsLimit: 100
                 }
            }
        }
    }
}
