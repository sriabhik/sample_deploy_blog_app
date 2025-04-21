pipeline {
    agent any

       stage('Clone')
            steps{

                git 'https://github.com/sriabhik/sample_deploy_blog_app'
            }
    stages {
        stage('Build') {
            steps {
                script {
                    sh 'mvn clean package -DskipTests'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    sh 'docker build -t article_app-backend:latest .'
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    sh 'docker-compose -f ../docker-compose.yml up -d article_app-backend'
                }
            }
        }
    }
}