node {
    properties([parameters([choice(choices: ['us-east-1', 'us-west-1', 'us-west-2'], description: 'please select a region', name: 'ami_region')])])
    stage ("Pull Repo"){
        git 'https://github.com/enver0173/packer.git'
    }
    stage ("Build Image"){
        sh "packer version"
        sh "packer build -var region=${AMI_REGION} tools/jenkins_example.json"
    }
    stage ("Send Notification to Slack"){
        slackSend channel: 'nagios_alerts', message: 'Golden AMI has been built'
    }
    stage ("Send Email"){
        mail bcc: '', body: '''Hello Ali,
Your AMI is ready in us-east-1
Thanks''', cc: '', from: '', replyTo: '', subject: 'Golden AMI has been built', to: 'alisevhp@gmail.com'
    }
}
