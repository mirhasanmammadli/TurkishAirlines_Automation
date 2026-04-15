pipeline {
    agent any

    tools {
        maven 'Maven_3.9'
        jdk 'JDK_11'
    }

    environment {
        PROJECT_NAME = 'TurkishAirlines_Automation'
    }

    stages {

        stage('Checkout') {
            steps {
                echo 'Checking out source code from GitHub...'
                git branch: 'main', url: 'https://github.com/YOUR_USERNAME/TurkishAirlines_Automation.git'
            }
        }

        stage('Build') {
            steps {
                echo 'Building the project...'
                sh 'mvn clean compile'
            }
        }

        stage('Run Smoke Tests') {
            steps {
                echo 'Running @smoke tagged tests...'
                sh 'mvn test -Dcucumber.filter.tags="@smoke"'
            }
        }

        stage('Run Regression Tests') {
            steps {
                echo 'Running @regression tagged tests...'
                sh 'mvn test -Dcucumber.filter.tags="@regression"'
            }
        }

        stage('Publish Reports') {
            steps {
                echo 'Publishing test reports...'
                publishHTML([
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'target/cucumber-reports',
                    reportFiles: 'cucumber.html',
                    reportName: 'Cucumber HTML Report'
                ])
            }
        }
    }

    post {
        always {
            echo 'Pipeline completed. Archiving results...'
            archiveArtifacts artifacts: 'target/cucumber-reports/**', fingerprint: true
        }
        success {
            echo 'All tests passed successfully!'
        }
        failure {
            echo 'Some tests failed. Please check the reports.'
        }
    }
}
