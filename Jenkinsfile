
// CODE_CHANGES = getGitChanges()

pipeline {
    agent any
    environment {
        NEW_VERSION = '1.3.0'
        SERVER_CREDENTIALS = credentials('') // This is the one which binds to jenkins credentials
        // two plugins => credentials and credentials binding
    }

    stages {
        stage("build") {
            when {
                expression {
//                     BRANCH_NAME == 'main' && CODE_CHANGES == true
                    BRANCH_NAME == 'main'
                }
            }
            steps {
                echo 'building the application .....'
                echo "build version ${NEW_VERSION}"
            }
        }

        stage("test") {
                when {
                    expression {
                        BRANCH_NAME == 'dev' || BRANCH_NAME == 'main'
                    }
                }
                    steps {
                        echo 'testing the application .....'
                    }
                }

        stage("deploy") {
                    steps {
                        echo 'deploying the application .....'
                    }
                }


    }

//     post{
//         always {
//             // This will be always executed
//         }
//         success {
//
//         }
//         failure {
//
//         }
//     }
}

// http://localhost:8080/env-vars.html/