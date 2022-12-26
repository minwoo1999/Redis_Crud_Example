## Redis Crud 

#### 개발환경

* spring boot 2.7.2

* JPA

* Redis 

* Oracle

* H2


### Redis를 통해 알게된 것

* Jedis, Lettuce 둘 모두 몇천개의 Star를 가질만큼 유명한 오픈소스, Lettuce 방식이 더욱 효율성이 뛰어남

* Redis는 사용자의 데이터를 요청하게 되면, 로컬 캐시에 일정한 시간동안 저장을 해놓고 다시 같은 데이터를 가져왔을때 캐시에 저장해둔 데이터를 보냄


### cashe 구조 #1 Look aside cache (일반적으로 제일 많으쓰는 패턴)

* 1.web server는 데이터가 존재하는지 cache를 먼저확인

* 2.cache에 데이터가 있으면 cache 에서 가져온다

* 3.cache에 데이터가 없다면 DB에서 읽어온다.

* 4. DB에서 읽어온 데이터를 Cache에 다시 저장한다.
