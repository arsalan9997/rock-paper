pipeline {
    agent any
    tools { jdk 'JDK17'; maven 'Maven3' }

    stages {
        stage('Checkout') { steps { checkout scm } }
        stage('Build') { steps { sh 'mvn -B clean compile' } }
        stage('Test') { steps { sh 'mvn -B test' } }
        stage('Package') { steps { sh 'mvn -B package -DskipTests' } }
        stage('Archive Artifact') {
            steps { archiveArtifacts artifacts: 'target/*.jar', fingerprint: true }
        }
    }
    post {
        success { echo 'Rock Paper Scissors CI build successful!' }
        failure { echo 'Pipeline failed. Check Jenkins console output.' }
    }
}
