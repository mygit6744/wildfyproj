node {
	stage('SCM Checkout') {
		git 'https://github.com/mygit6744/wildfyproj.git'
		
	}
	
	stage('Compile-Build-Deploy') {
		def mvnHome = tool name:'MAVEN_HOME',type:'maven'
		sh "${mvnHome}/bin/maven package"
		
	}
	
	
}
