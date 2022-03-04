# Kafka-sample
kafka Sample / producer-consumer

# 실행방법
주키퍼 서버 실행 -> 카프카 서버 실행 -> 
producer(write), consumer(read)
------------------------------------------------------


kafka 가 있는 경로로 들어가서 주소창에 cmd를 입력하면 명령 프롬트가 뜬다
(E:\programs\kafka_2.13-3.1.0\bin\windows)
![image](https://user-images.githubusercontent.com/96602991/156690877-e1475d92-7934-440c-86ae-b0470d832d3c.png)

# 1. 주키퍼 서버 실행
.\zookeeper-server-start.bat ..\..\config\zookeeper.properties

# 2. 카프카 서버 실행
.\kafka-server-start.bat ..\..\config\server.properties

이클립스에서
# 3. kafka-producer-sample 프로젝트 실행
- dto 에 content , id 있음

![image](https://user-images.githubusercontent.com/96602991/156695867-4dc4cc12-4099-425d-84b3-383c2fafeaac.png)
POST 방식으로
http://localhost:8080/producer/messages 의 body에 내용 입력
![image](https://user-images.githubusercontent.com/96602991/156696045-703c411b-4e88-4daf-a265-0419d1ee1fd3.png)
kafka-producer-sample의 console 창에 내용을 write 한것을 출력했음


# 4. kafka-consumer-sample 프로젝트 실행
![image](https://user-images.githubusercontent.com/96602991/156696218-24f1fdf1-28cb-49c6-9cf3-b5ff44524385.png)
![image](https://user-images.githubusercontent.com/96602991/156696242-111ec718-c35f-4a59-aa5d-652bc1969f29.png)




