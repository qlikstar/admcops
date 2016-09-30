1. Install aws cli using :  sudo apt install awscli

1.5. $ aws configure
AWS Access Key ID [None]: ***************
AWS Secret Access Key [None]: ***********************
Default region name [None]: us-west-1
Default output format [None]: json

2. sudo apt install python-pip

3. pip install boto

4. cd ~ && mkdir ansible && cd ansible
5. $ git clone git://github.com/ansible/ansible.git --recursive

Cloning into 'ansible'...
remote: Counting objects: 130113, done.
remote: Compressing objects: 100% (20/20), done.
remote: Total 130113 (delta 4), reused 0 (delta 0), pack-reused 130093
Receiving objects: 100% (130113/130113), 36.31 MiB | 13.07 MiB/s, done.
Resolving deltas: 100% (81583/81583), done.
Checking connectivity... done.
Submodule 'lib/ansible/modules/core' (https://github.com/ansible/ansible-modules-core) registered for path 'lib/ansible/modules/core'
Submodule 'lib/ansible/modules/extras' (https://github.com/ansible/ansible-modules-extras) registered for path 'lib/ansible/modules/extras'
Cloning into 'lib/ansible/modules/core'...
remote: Counting objects: 41023, done.
remote: Compressing objects: 100% (16/16), done.
remote: Total 41023 (delta 1), reused 0 (delta 0), pack-reused 41007
Receiving objects: 100% (41023/41023), 10.22 MiB | 9.62 MiB/s, done.
Resolving deltas: 100% (27335/27335), done.
Checking connectivity... done.
Submodule path 'lib/ansible/modules/core': checked out 'edf361a5d4b45f2e7c7df1a133d5a09391508db2'
Cloning into 'lib/ansible/modules/extras'...
remote: Counting objects: 36472, done.
remote: Compressing objects: 100% (27/27), done.
remote: Total 36472 (delta 7), reused 0 (delta 0), pack-reused 36445
Receiving objects: 100% (36472/36472), 8.39 MiB | 6.77 MiB/s, done.
Resolving deltas: 100% (24250/24250), done.
Checking connectivity... done.
Submodule path 'lib/ansible/modules/extras': checked out '8aa338ddfa8cd00f96b60391b0d8cd2ebc8c822b'

6. $ cd ./ansible
7. $ source ./hacking/env-setup

running egg_info
creating lib/ansible.egg-info
writing requirements to lib/ansible.egg-info/requires.txt
writing lib/ansible.egg-info/PKG-INFO
writing top-level names to lib/ansible.egg-info/top_level.txt
writing dependency_links to lib/ansible.egg-info/dependency_links.txt
writing manifest file 'lib/ansible.egg-info/SOURCES.txt'
reading manifest file 'lib/ansible.egg-info/SOURCES.txt'
reading manifest template 'MANIFEST.in'
no previously-included directories found matching 'v2'
no previously-included directories found matching 'docsite'
no previously-included directories found matching 'ticket_stubs'
no previously-included directories found matching 'packaging'
no previously-included directories found matching 'test'
no previously-included directories found matching 'hacking'
no previously-included directories found matching 'lib/ansible/modules/core/.git'
no previously-included directories found matching 'lib/ansible/modules/extras/.git'
writing manifest file 'lib/ansible.egg-info/SOURCES.txt'

Setting up Ansible to run out of checkout...

PATH=/home/ubuntu/ansible/bin:/home/ubuntu/hackathon/ansible/bin:/home/ubuntu/bin:/home/ubuntu/.local/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/games:/usr/local/games:/snap/bin
PYTHONPATH=/home/ubuntu/ansible/lib:/home/ubuntu/hackathon/ansible/lib:
MANPATH=/home/ubuntu/ansible/docs/man:/home/ubuntu/hackathon/ansible/docs/man:

Remember, you may wish to specify your host file with -i

Done!

8. $ sudo easy_install pip
8

sudo: unable to resolve host ip-172-30-0-239
Searching for pip
Best match: pip 8.1.2
Adding pip 8.1.2 to easy-install.pth file
Installing pip script to /usr/local/bin
Installing pip3.5 script to /usr/local/bin
Installing pip3 script to /usr/local/bin

Using /home/ubuntu/.local/lib/python2.7/site-packages
Processing dependencies for pip
Finished processing dependencies for pip

9. $ sudo pip install paramiko PyYAML Jinja2 httplib2 six

10. $ git pull --rebase

11. $ git submodule update --init --recursive

12. $ ansible --version
ansible 2.2.0 (devel 1c7890bf86) last updated 2016/09/25 22:27:28 (GMT +000)
  lib/ansible/modules/core: (detached HEAD edf361a5d4) last updated 2016/09/25 22:27:32 (GMT +000)
  lib/ansible/modules/extras: (detached HEAD 8aa338ddfa) last updated 2016/09/25 22:27:35 (GMT +000)
  config file =
  configured module search path = Default w/o overrides

13. $ cd /etc/ansible/
14. $ wget https://raw.githubusercontent.com/ansible/ansible/devel/contrib/inventory/ec2.py
15. $ wget https://raw.githubusercontent.com/ansible/ansible/devel/contrib/inventory/ec2.ini
16. edit the ec2.ini file to add "ap-south-1" to the list of excluded zones

17. $ ssh-add -L
The agent has no identities.

if this instruction throws an error “Could not open a connection to your authentication agent.” , run the below command
$ eval $(ssh-agent)
and then try ssh-add -L again

18. $ ssh-add ~/sanketm.pem
Identity added: /home/ubuntu/sanketm.pem (/home/ubuntu/sanketm.pem)

19. $ ssh-add -L
ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQCdgu2yy38eGuTLvYVqaLPB1dWKuHJMleIJBbSckwSx48K6SjFSOaqeqaPm5JVkHs/mTZzU49w31GOpgoP4LMWjQcgiWoqiBTlJafdhtuXMSc8D5/e1Peiu1g3efewkjfjwIW1P0Sa2/BlRtPOVWr/bHIP7+YYNAWEHz07HZZKUbQ4sY8WuzWH4wJoO/IEJtTivshog6KPKaHjbSzLVYQD/AJdmefjH6Tv59zLUEgcHU+pBQofYq8RTtJGsMkxd8Z1ttQRrIaJYRibS0MuVrVrraIw3Pq4u+NuiyAEj8C/YX/8D6e8tqc6tFQhAGcLTnyAeAYTVnm4ctD8QXEhrwYoX8nnGwc/0VBgsCZOPn /home/ubuntu/sanketm.pem

20. Command :

$ansible -u ubuntu tag_Name_sanketm_hackathon* -m ping

52.53.149.150 | SUCCESS => {
    "changed": false,
    "ping": "pong"
}
52.53.192.52 | SUCCESS => {
    "changed": false,
    "ping": "pong"
}
54.67.18.162 | SUCCESS => {
    "changed": false,
    "ping": "pong"
}

21. $ ansible-playbook -i non-prod site.yml

Some good links:

https://aws.amazon.com/blogs/apn/getting-started-with-ansible-and-dynamic-amazon-ec2-inventory-management/
setup ssh keys : https://developer.github.com/guides/using-ssh-agent-forwarding/