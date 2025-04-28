//version 3
pipeline {
    agent any

    environment {
        // Make sure PATH includes docker and other tools
        PATH = "/usr/local/bin:/usr/bin:/bin:/usr/sbin:/sbin:${env.PATH}"
    }

    stages {


        stage('Build JAR') {
            steps {
                sh '''
                    echo "Building Maven Project..."
                    mvn clean package
                '''
            }
        }

        stage('Archive JAR') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }

        stage('Docker Build') {
            steps {
                sh '''
                    echo "Building Docker Image..."
                    docker build -t article_app-backend:latest .
                '''
            }
        }

        stage('Docker Compose Deploy') {
            steps {
                sh '''
                    echo "Running Docker Compose..."
                    docker compose down || true
                    docker compose up -d --build
                '''
            }
        }
    }

    post {
        always {
            echo 'Cleaning up workspace...'
            cleanWs()
        }
    }
}

//version 2
// pipeline {
//     agent {
//            docker {
//                  image 'maven:3.8.7-eclipse-temurin-17'
//          }
//     }
//     environment {
//         IMAGE_NAME = 'article_app-backend'
//         IMAGE_TAG = 'latest'
//     }
//
//     stages {
// //         stage('Checkout') {
// //             steps {
// //                     git 'https://github.com/sriabhik/sample_deploy_blog_app'
// //             }
// //         }
//
//         stage('Build') {
//                  steps {
//                       script {
//                            sh 'mvn clean package -DskipTests'
//                       }
//                  }
//         }
//
//         stage('Build Docker Image') {
//             steps {
//                 sh '''
//                     docker build -t ${IMAGE_NAME}:${IMAGE_TAG} .
//                 '''
//             }
//         }
//         stage('Deploy') {
//             steps {
//                 sh '''
//                    docker compose down || true
//                    docker compose up -d --build
//                 '''
//             }
//         }
//
// //         stage('Push to Docker Hub (optional)') {
// //             when {
// //                 branch 'main'
// //             }
// //             steps {
// //                 withCredentials([usernamePassword(credentialsId: 'docker-hub-credentials-id', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
// //                     sh '''
// //                         echo "$DOCKER_PASS" | docker login -u "$DOCKER_USER" --password-stdin
// //                         docker tag ${IMAGE_NAME}:${IMAGE_TAG} $DOCKER_USER/${IMAGE_NAME}:${IMAGE_TAG}
// //                         docker push $DOCKER_USER/${IMAGE_NAME}:${IMAGE_TAG}
// //                     '''
// //                 }
// //             }
// //         }
//     }
//
//     post {
//         success {
//             echo 'Docker Image built successfully!'
//         }
//         failure {
//             echo 'Build failed.'
//         }
//     }
// }

//version 1
// pipeline {
//     agent {
//             docker {
//                 image 'maven:3.8.7-eclipse-temurin-17'
//             }
//         }
// //     environment {
// //             APP_NAME = "article_app-backend"
// //             RELEASE_NUMBER = "1.0"
// //             DOCKER_USER = "sriabhik"
// //             DOCKER_PASS = 'Abhi7631@'//This is a secret that will be set up and used to sign into docker. it will be setup in docker hub as an access token
// //             IMAGE_NAME = "${DOCKER_USER}" + "/" + "${APP_NAME}"
// //             IMAGE_TAG = "${RELEASE_NUMBER}"
// //
// //         }
//     stages {
// //         stage('Build') {
// //             steps {
// //                 script {
// //                     sh 'mvn clean package -DskipTests'
// //                 }
// //             }
// //         }
//
//         stage('Build Docker Image') {
//             steps {
//                 script {
//                     sh 'docker build -t article_app-backend:latest .'
//                 }
//             }
//         }
//
//         stage('Deploy') {
//             steps {
//                 script {
//                     sh 'docker-compose -f ../docker-compose.yml up -d article_app-backend'
//                 }
//             }
//         }
//     }
// }