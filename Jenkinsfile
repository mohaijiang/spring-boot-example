pipeline {
  agent {
    kubernetes {
      //cloud 'kubernetes'
      yaml """
apiVersion: v1
kind: Pod
spec:
  containers:
  - name: docker
    image: docker:20
    command: ['cat']
    tty: true
    volumeMounts:
    - mountPath: /var/run/docker.sock
      name: docker
  - name: maven
    image: maven:3.6.3-jdk-8
    command:
    - sleep
    args:
    - infinity
  - name: kubectl
    image: boxboat/kubectl:1.22.3
    command: ['cat']
    tty: true
  volumes:
  - name: docker
    hostPath:
      path: /var/run/docker.sock
      type: Socket
"""
    }
  }
  stages {
    stage('image build'){
      steps{
        container('maven'){
          sh 'mvn clean package '
        }
      }
    }
  }
}
