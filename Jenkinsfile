pipeline {
    agent {
        docker {
            label 'docker-node'
            image 'maven:3-alpine'
            args '-v $HOME/.m2:/root/.m2'
        }
     }

     environment {
        GIT_COMMITTER_NAME = 'jenkins'
     }

    options {
        timeout(6, HOURS)
    }

    stages {
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Archive') {
            when {
                branch '*/master'
            }
            steps {
                archive '*/target/**/*'
                junit '*/target/surefire-reports/*.xml'
            }
        }
    }

    post {
        always {
            deleteDir()
        }
    }
}