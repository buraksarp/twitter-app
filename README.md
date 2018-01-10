Spring Boot Twitter App
=========================

Building the Application
---------------------
    $ git clone https://github.com/buraksarp/twitter-app.git
    $ cd twitter-app
    $ mvn clean install

This demo assumes you know how to run Docker.

Building the Container
----------------------
Nothing special if you already have Docker installed:

    $ docker build -t sarp/twitter-app .

Running the Container
---------------------
To run this container:

    $ docker run -ti sarp/twitter-app
