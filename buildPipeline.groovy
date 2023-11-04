node(){
    def sonarScanner = tool name: 'SonarScanner', type: 'hudson.plugins.sonar.SonarRunnerInstallation'
	def repoName = "https://github.com/Jyurashi/SonarQubeCoverageJava.git"
	def mavenHome = tool name: 'Maven', type: 'maven'
	stage('Code Checkout'){
		git changelog: false, credentialsId: 'GitHubCreds', poll: false, url: repoName
	}
	stage('Maven Build'){
		sh """
			ls -lart
			date
			${mavenHome}/bin/mvn clean install
		"""
	}
	stage('Code Review'){
		withSonarQubeEnv(credentialsId: 'SonarQubeToken') {
			sh "${sonarScanner}/bin/sonar-scanner"
		}
	}*/
	stage('Code Deployment'){
	
	}
}
