pipeline {
  agent any
  stages {
    stage('Stage1') {
      parallel {
        stage('Stage1') {
          steps {
            echo 'Hello'
          }
        }

        stage('Test') {
          steps {
            sh 'echo "hello"'
          }
        }

      }
    }

    stage('Stage2') {
      steps {
        echo 'Hello2'
      }
    }

    stage('Stage3') {
      steps {
        echo 'Hello3'
      }
    }

    stage('Stage4') {
      steps {
        echo 'Hello4'
      }
    }

  }
}