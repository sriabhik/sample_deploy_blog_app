pipeline {
    agent {
            docker {
                image 'maven:3.8.7-eclipse-temurin-17'
            }
        }
//     environment {
//             APP_NAME = "article_app-backend"
//             RELEASE_NUMBER = "1.0"
//             DOCKER_USER = "sriabhik"
//             DOCKER_PASS = 'Abhi7631@'//This is a secret that will be set up and used to sign into docker. it will be setup in docker hub as an access token
//             IMAGE_NAME = "${DOCKER_USER}" + "/" + "${APP_NAME}"
//             IMAGE_TAG = "${RELEASE_NUMBER}"
//
//         }
//     stages {
//         stage('Build') {
//             steps {
//                 script {
//                     sh 'mvn clean package -DskipTests'
//                 }
//             }
//         }

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