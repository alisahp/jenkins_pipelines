node {
    properties([parameters([choice(choices: ['us-east-1', 'us-west-1'], description: 'add region', name: 'AMI_REGION')])])

    stage ("Pull Repo"){
        echo "hello"

}
    stage ("Build Image"){
        sh "packer version"

}
    stage ("Send Notification to Slack"){
        echo "Hello"

}
    stage ("Send Email"){
        echo "Hello"

}
