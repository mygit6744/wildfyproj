pipeline{
    agent any
    tools{
        maven 'MAVEN_HOME'
    }
    stages{
        stage("SCM Checkout"){
            steps{
            git url: 'https://github.com/mygit6744/wildfyproj.git', branch: 'master'
            }
        }
        stage("Maven Build"){
            steps{
                bat 'mvn clean install'
            }
        }
    }
}
