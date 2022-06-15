# spring-boot-kotlin-guide
## 목표
**1차**
* spring boot + kotlin 공식문서 튜토리얼 따라하기 ([링크](https://spring.io/guides/tutorials/spring-boot-kotlin/))
* 간단한 CRUD 기능 구현
* 테스트 코드 작성

## 기술스택
* Kotlin
* Spring Boot
* Kotest
* H2

## 도메인
### User
* id
* login
* firstname
* lastname
* description

### Article
* id
* title
* headline
* content
* author_id
* addedAt

## 기능
### User
* 회원가입
* 회원정보 수정
* 내 게시물 목록조회

### Article
* 게시물 등록
* 게시물 수정
* 게시물 조회
