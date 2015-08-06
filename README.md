# Pokedex
For connection problem, we may need to install connection J.

mySQL:
	
Notes:
Do not use "" when copying the prompts!
This information is reference for using mySQL connected via CSNet

How to connect to mySQL via-terminal on MAC or PuTTy:
Type: “ssh -Y netID@build.tamu.edu”
Note: use netID PW
Type “mysql -h database2.cs.tamu.edu -u CSnetID -p”
Note: use CSnet PW
How to run a .SQL file:
Cd to the directory containing the SQL file
Connect to mySQL
Select your database
Type: "source fileName.sql"
How to select a database:
Type: "use `databaseName`;"
How to show all databases:
Type: "show databases;"

mySQL localhost
Due to the security reason, the department database server unable LOAD DATA LOCAL INFILE command which is necessary when importing data, therefore, I suggest we use our local MySQL database.

Note: [X] indicates that you can find a detail approach guiding you how to do this.

1. Install and configure MySQL database on your computer. [1]

2.  Set database root and password

3. In terminal, $ mysql --local-infile -uroot -pyourpassword yourdatabase   // Command not allowed problem fixed. This is to enable LOAD DATA LOCAL INFILE command which will be used in importing data

4. In terminal, $ mysql -u root -p -h localhost   // Access denied problem fixed. Authentication.

5. In mysql shell, $ use yourdatabase

6. Importing data:

a. from txt(field terminated by tab): 
$ LOAD DATA LOCAL INFILE './Learn.txt' INTO TABLE Learn LINES TERMINATED BY '\r\n' 
b. from csv:
$ LOAD DATA LOCAL INFILE './Trainers.csv' INTO TABLE Trainer FIELDS TERMINATED BY ','  ENCLOSED BY '"'  LINES TERMINATED BY '\r\n';

MySQL GUI (DBeaver)

Mason strongly recommends to install DBeaver[2],  a free universal database manager. It allows you to view/edit data in DB easily and offer a straightforward view for DB content. After installation, if you experience any difficulty in configuration, let Mason know.

Appendix:

If you use OS X system, you can try the following command lines as well at first.

[1] MySQL install for Ubuntu system
Installation
To install MySQL, run the following command from a terminal prompt:
sudo apt-get install mysql-server
As of Ubuntu 12.04, MySQL 5.5 is installed by default. Whilst this is 100% compatible with MySQL 5.1 should you need to install 5.1 (for example to be a slave to other MySQL 5.1 servers) you can install the mysql-server-5.1 package instead.
During the installation process you will be prompted to enter a password for the MySQL root user.
Once the installation is complete, the MySQL server should be started automatically. You can run the following command from a terminal prompt to check whether the MySQL server is running:
sudo netstat -tap | grep mysql
When you run this command, you should see the following line or something similar:
tcp        0      0 localhost:mysql         *:*                LISTEN      2556/mysqld


If the server is not running correctly, you can type the following command to start it:
sudo service mysql restart
Configuration
If you would like to change the MySQL root password, in a terminal enter:
sudo dpkg-reconfigure mysql-server-5.5
The MySQL daemon will be stopped, and you will be prompted to enter a new password.
Upgrade
sudo apt-get update
sudo apt-get upgrade
sudo apt-get install mysql-server-5.6
[2] DBeaver install for Ubuntu system.
Instructions for 32 bit systems:
$ sudo apt-get install gdebi
$ wget http://dbeaver.jkiss.org/files/dbeaver_3.4.2_i386.deb
$ sudo gdebi dbeaver_3.0.1_i386.deb

Instructions for 64 bit systems:
$ sudo apt-get install gdebi
$ wget http://dbeaver.jkiss.org/files/dbeaver_3.4.2_amd64.deb
$ sudo gdebi dbeaver_3.4.2_amd64.deb


GitHub
Notes:
It is strongly recommended that using git and github with terminal and commamd lines. Compared to modify files on the github web, you can modify multiple files at the same times with the terminal and command lines.

Do not use “” when copying prompts.
This information is reference for interacting with git Repositories using the terminal either locally or through a given server like CSNet.
How to connect to a specific repository on github, adding it’s directory to your system.
Change your current directory to wherever you wish to add the repository
Go to the github repository online and copy the “HTTPS clone URL”.
Type “git init” to initialize a repository
in your terminal, type “git clone copied_link”
How to update the repository on your local system
First ensure you’re connected to the repository using the above method.
type “git pull”

How to add a file to the repository via terminal.
first copy the file by typing “cp filename.extension ./paste_directory
type “git add .”
type “git commit -m “your comment”
type “git push” then login using your gitHub username and password.

