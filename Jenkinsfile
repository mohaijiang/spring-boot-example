pipeline {

    agent any
    parameters {
        string(defaultValue: "",description: 'remote host password', name: 'sshPassword')
    }

    stages {

        stage('Build') {
            agent {
                docker {
                    image 'maven:3.8.1-adoptopenjdk-11'
                    args '-v /root/.m2:/root/.m2'
                    reuseNode true
                }
            }
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }

        stage('build image'){

            steps {

                 script {
                         docker.withRegistry( '', 'my-docker-credentials' ) {
                             dockerImage = docker.build 'mohaijiang/spring-boot-example'
                             dockerImage.push("$BUILD_NUMBER")
                             dockerImage.push('latest')

                          }
                        }
            }
        }

        stage('Remote SSH') {
            steps {


               sh """
                sshpass -p ${params.sshPassword} ssh -o "StrictHostKeyChecking no"   root@192.168.0.254 -p 22 docker rm -f spring-boot-example
                sshpass -p ${params.sshPassword} ssh -o "StrictHostKeyChecking no"   root@192.168.0.254 -p 22 docker run -d -p 8080:8080 --name spring-boot-example mohaijiang/spring-boot-example:$BUILD_NUMBER
               """
            }
        }

    }


}
