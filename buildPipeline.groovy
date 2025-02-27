node(){
    def sonarScanner = tool name: 'SonarScanner', type: 'hudson.plugins.sonar.SonarRunnerInstallation'
	def repoName = "https://github.com/Jyurashi/SonarQubeCoverageJava.git"
	stage('Code Checkout'){
		git changelog: false, credentialsId: 'GitHubCreds', poll: false, url: repoName
	}
	stage('Maven Build'){
		sh """
			ls -lart
			date
			mvn clean package
		"""
	}
	stage('Code Review'){
		withSonarQubeEnv(credentialsId: 'SonarQubeToken') {
		}
	}
	stage('Code Deployment'){
	
	}
}
