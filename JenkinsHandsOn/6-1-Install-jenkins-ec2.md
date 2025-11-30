# Installation guide for Jenkins in AWS EC2 instance 

This guide describes how to set up jenkins server remotely on EC2 AWS instance (Amazon Linux AMI).

We assume that Cloud9 environment has already been created and configured to run with instance type t3.small (2vCPU, 2G memory)

SSH connection for instance is opened

TCP 8080 is opened for all 0.0.0.0/0 (to be added as rule in EC2 security group ingress trafic)

- Connect with your IAM user to accountID: 672011295804
- Region = us-east-1
- Go to Cloud9 : environment lab-jenkins
- By starting Environment, you should be prompted to IDE that will allow you to create source code and connect to running ec2 instance attached to this environment.
- Follow these steps to install jenkins (same  README guide with Shell)

* Install open jdk 11
```
sudo yum install -y java-11-openjdk
```
* Install the Repo and Key, and Then Install/Start Jenkins
```
sudo yum install -y wget

sudo wget -O /etc/yum.repos.d/jenkins.repo https://pkg.jenkins.io/redhat-stable/jenkins.repo

sudo rpm --import https://pkg.jenkins.io/redhat-stable/jenkins.io-2023.key

sudo yum install -y jenkins

sudo systemctl enable jenkins

sudo systemctl start jenkins
```
- Go to browser, 
[https://<public_ec2_dns>:8080] 
Jenkins should be now accessible 

- Initial Admin password should be stored in `/var/lib/jenkins/secrets/initialAdminPassword`

- Create new admin and change password
admin name = "admin-jenkins"


