pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
               
                git url: 'https://github.com/mygit6744/wildfyproj.git', branch: 'master'
                sh 'mvn clean package'
            }
        }
    }
}
