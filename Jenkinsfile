pipeline{
    agent any
    stages{
        stage('build'){
            steps{
              sh "mvn clean install"
              sh "mvn spring-boot:run"
            }
        }
    }
}
