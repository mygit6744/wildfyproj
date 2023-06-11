pipeline{
    agent any
    tools{
        maven 'MAVEN_HOME'
    }
    stages{
        
        stage("Maven Build"){
            steps{
                bat 'mvn clean install'
            }
        }
    }
}
