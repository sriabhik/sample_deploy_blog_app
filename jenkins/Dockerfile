FROM jenkins/jenkins:lts

USER root

RUN apt-get update && \
apt-get install -y docker.io && \
    apt-get clean

COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN jenkins-plugin-cli --plugin-file /usr/share/jenkins/ref/plugins.txt

ENTRYPOINT["/usr/local/bin/script.sh.copy"]