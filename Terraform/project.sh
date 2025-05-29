#!/bin/bash
echo "update logging configuration..."
sudo sh -c "echo '*.info;mail.none;authpriv.none;cron.none /dev/ttyS0' >> /etc/rsyslog.conf"
sudo systemctl restart rsyslog
echo "update logging configuration..."

whoami

sudo apt-get update -y

echo "installing MariaDB..."

sudo apt-get install mariadb-server -y
sudo systemctl start mariadb

sudo systemctl enable mariadb


echo "creating mysql_secure_installation.txt..."
touch mysql_secure_installation.txt
cat << `EOF` >> mysql_secure_installation.txt

n
Y
comsc
comsc
Y
Y
Y
Y
Y
`EOF`

echo "running mysql_secure_installation..."
sudo mysql_secure_installation < mysql_secure_installation.txt

cat << `EOF` >> gitlab_project_sem1.key
-----BEGIN OPENSSH PRIVATE KEY-----
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
-----END OPENSSH PRIVATE KEY-----
`EOF`

sudo chmod 400 gitlab_project_sem1.key

touch ~/.ssh/known_hosts
ssh-keyscan git.cardiff.ac.uk >> ~/.ssh/known_hosts
sudo chmod 644 ~/.ssh/known_hosts

sudo apt-get install git -y

ssh-agent bash -c 'ssh-add gitlab_project_sem1.key; git clone git@git.cardiff.ac.uk:c24004894/polish-community-website-group-14-vinay.git'

sudo mysql -u root -pcomsc < polish-community-website-group-14-vinay/src/main/resources/schema.sql
sudo mysql -u root -pcomsc < polish-community-website-group-14-vinay/src/main/resources/data.sql

sudo apt-get install openjdk-17-jdk -y
sudo apt-get install wget -y

wget https://services.gradle.org/distributions/gradle-7.6-bin.zip
sudo apt install unzip -y

sudo mkdir /opt/gradle

sudo unzip -d /opt/gradle gradle-7.6-bin.zip

export PATH=$PATH:/opt/gradle/gradle-7.6/bin

cd polish-community-website-group-14-vinay/
gradle bootrun

