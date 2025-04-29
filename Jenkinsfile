pipeline {
    agent {
                docker {
                      image 'maven:3.8.7-eclipse-temurin-17'
              }
         }

    environment {
        IMAGE_NAME = 'article_app-backend'  // Change as needed
        IMAGE_TAG = 'latest'
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/sriabhik/sample_deploy_blog_app.git'  // Replace with your repo URL
            }
        }

        stage('Build with Maven') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    def jarName = sh(script: "ls target/*.jar | grep -v 'original' | head -n 1", returnStdout: true).trim()
                    sh """
                        docker build -t ${IMAGE_NAME}:${IMAGE_TAG} --build-arg JAR_FILE=${jarName} .
                    """
                }
            }
        }
    }
}
