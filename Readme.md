# to run this file in docker, run the following command

docker run -d -p 8080:8080 -v /<your own director>:/log --name <YourApplicationName> --link=mongo spring-boot-mongo:<imageversion>
