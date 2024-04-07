# ☀️ 1인분이요~ - 혼밥러들을 위한 커뮤니티

---

**오르미 4기 2차 프로젝트**

## 👤 팀원소개

---

| [김용준](https://github.com/Allewis0201) | [권은아](https://github.com/827euni)                                                                                                        | [김소희](https://github.com/sohee99)                                                                                                                       | [박종호](https://github.com/penameyo)                                                            |
| --- |------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------|
| 사진 | 사진                                                                                                         | 사진                                                                                                                        | 사진(사랑해요)                                                       |
|• ERD 설계 <br/>• 에디터 적용 <br/>• 게시판 API/ UI <br/>• 게시글 API/UI <br/>• 게시글 추천 API/UI <br/>• 댓글 API/UI<br/>• 운영자 페이지 API/UI  | • 로그인/회원가입 API/UI <br/>• 마이페이지 API/UI <br/>• 운영자페이지 API/UI <br/>• 헤더 API/UI <br/>• 댓글 UI<br/> • 게시글 API/UI | • 화면설계<br/>• 로그인/회원가입 UI<br/> • 마이페이지 UI<br/> • 운영자페이지 UI<br/> • 헤더/메인페이지 UI<br/> • 게시판/게시글 UI<br/> • 댓글 UI<br/> • PPT 작성 | • ERD 구현<br/>• 순서도 작성<br/> • 게시글 API<br/> • 게시판 API<br/> • 댓글 API|

## 🗺️ 프로젝트 목표

---

1인 가족이 증가함에 따라, 1인이서 외식할 수 있는 식당을 사람들이 선호하게 되었으나, 몇몇의 식당에서는 1인 외식이 어려운 바, 직접 가능한 1인 식당의 별점과 리뷰를 남겨 다른 이들과 함께 공유하는 커뮤니티를 제작하였습니다.

## 📌 개발 기술과 환경, 개발 일정

---

### 개발 기술

![AMAZONAWS](https://img.shields.io/badge/amazonaws-232F3E?style=for-the-badge&logo=amazonaws&logoColor=white)
![H2](https://img.shields.io/badge/h2-1021FF?style=for-the-badge&logo=h2&logoColor=white)

![JAVA](https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white)
![HTML5](https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=HTML5&logoColor=white)
![CSS3](https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=CSS3&logoColor=white)
![Javascript](https://img.shields.io/badge/Javascript-F7DF1E?style=for-the-badge&logo=Javascript&logoColor=white)
![SpringBoot](https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)

### 개발 환경
![Github](https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white)
![DISCORD](https://img.shields.io/badge/Discord-5865F2?style=for-the-badge&logo=Discord&logoColor=white)
![Notion](https://img.shields.io/badge/Notion-000000?style=for-the-badge&logo=Notion&logoColor=white)
![Figma](https://img.shields.io/badge/Figma-F24E1E?style=for-the-badge&logo=Figma&logoColor=white)

### 개발 일정

2024년 3월 22일 ~ 2024년 4월 5일

## 📜 요구사항 및 기능 명세

---

| 분류     | 기능유형(기능/비기능) | 요구사항명          | 요구사항 내용                                              | 중요도(상/중/하) | 난이도(상/중/하) |
|--------| --- |----------------|------------------------------------------------------| --- |------------|
| 로그인    | 기능 | 로그인/로그아웃       | 사용자는 아이디와 비밀번호를 입력하여 로그인할 수 있으며, 로그아웃 역시도 할 수 있다.    | 상 | 하          |
| 로그인    | 기능 | 아이디 저장         | 사용자는 로그인을 할 당시 미리 아이디를 저장해놓을 수 있다.                   | 하 | 중          |
| 회원관리   | 기능 | 회원가입/회원탈퇴      | 사용자는 회원으로서 가입할 수 있으며, 역시 탈퇴할 수 있다.                   | 상 | 하          |
| 회원관리   | 기능 | 아이디/닉네임 중복확인   | 사용자는 회원으로서 가입할 때 아이디와 닉네임을 중복 체크하여 가입할 수 있다.         | 하 | 중          |
| 회원관리   | 기능 | 비밀번호 변경        | 사용자는 특정 페이지를 통해서 스스로의 닉네임과 비밀번호를 변경할 수 있다.           | 하 | 중          |
| 회원관리   | 기능 | 멤버 별 등급 권한 부여  | 운영자는 특정 페이지를 통해 각 사용자에게 등급을 부여할 수 있다.                | 상 | 하          |
| 회원관리   | 기능 | 멤버 관리          | 운영자는 특정한 페이지에서 멤버들의 등급을 수정할 수 있으며, 댓글수와 게시글 수를 확인할 수 있다. | 상 | 중          |
| 게시판 기능 | 기능 | 글 목록 조회        | 사용자는 특정 페이지를 통해 글 전체 목록을 확인할 수 있으며, 이를 통해 글을 작성할 수 있다. | 상 | 하          |
| 게시판 기능 | 기능 | 글 작성/수정/삭제/조회  | 사용자는 게시글을 작성, 수정, 삭제, 조회를 할 수 있다.                    | 상 | 하          |
| 게시판 기능 | 기능 | 댓글 작성/수정/삭제/조회 | 사용자는 댓글을 작성, 삭제, 조회를 할 수 있다.                         | 상 | 중          |
| 게시판 기능 | 기능 | 사진 첨부기능        | 사용자는 게시글마다 사진을 다중으로 첨부할 수 있다.                        | 중 | 상          |
| 게시판 기능 | 기능 | 멤버 별 등급 조회 권한  | 운영자는 각 게시판마다 조회, 글 작성의 등급을 설정할 수 있다.                 | 상 | 상          |
| 게시판 기능 | 기능 | 추천             | 사용자는 각 게시글에 한 번씩 추천을 할 수 있다                          | 하 | 중          |
| 게시판 기능 | 기능 | 조회수            | 사용자와 운영진은 각 게시글의 조회수를 확인할 수 있다                       | 하 | 중          |
| 게시판 기능 | 기능 | 페이징 기능         | 사용자와 운영진은 게시판을 조회할 때, 10개마다 페이징을 생성할 수 있다.           | 하 | 상          |

## ☁️ ERD 데이터베이스 모델링

---

![1인분이요](https://github.com/Allewis0201/for-1-person/assets/108185369/c2c00919-2095-4c35-abed-9cc2b97ca595)

## 🖼️화면 설계

---

[화면 설계 페이지 바로가기](https://www.figma.com/file/lNlUOz9i7DeSJYlpBNqI3H/Untitled?type=design&node-id=0%3A1&mode=design&t=kxDYq1mdbuRGTLdM-1)

| ![로그인](https://github.com/Allewis0201/for-1-person/assets/108185369/21ce8d67-1487-4fe6-ba64-47d415a4909c)<br/>로그인      | ![회원가입](https://github.com/Allewis0201/for-1-person/assets/108185369/887841bb-95ef-4f88-8b96-f939c0f96c17)<br/>회원가입      |
|------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------|
| ![일반 게시판](https://github.com/Allewis0201/for-1-person/assets/108185369/6ecf4a45-95a4-4e61-abce-aa0ed06b4b9f)<br/>일반게시판 | ![VIP 게시판](https://github.com/Allewis0201/for-1-person/assets/108185369/9c7714f0-4f18-4925-af98-70d0c166f1af)<br/>VIP게시판 |
| ![리뷰 게시판](https://github.com/Allewis0201/for-1-person/assets/108185369/0a62ab01-66ea-4675-a937-8e7bc6d6d334)<br/>리뷰게시판 | ![글 수정 삭제](https://github.com/Allewis0201/for-1-person/assets/108185369/7505dc28-a68e-4af5-88c8-a837e34794b4)<br/>글 추가/삭제                                                                                                                  |
| ![내 정보](https://github.com/Allewis0201/for-1-person/assets/108185369/cf80fa06-930b-4754-a40b-a8a68c99310f)<br/>계정정보    | ![관리 페이지](https://github.com/Allewis0201/for-1-person/assets/108185369/4e2f2da7-088f-4b46-a994-804f22c0d115)<br/>관리페이지                                                                                                                    |
| ![일반 게시판 글 상세 명세](https://github.com/Allewis0201/for-1-person/assets/108185369/49d4285f-6c70-4973-ab7e-832d800fcddf)<br/>글 상세 페이지                                                                                                               | ![메인 화면](https://github.com/Allewis0201/for-1-person/assets/108185369/6805f04c-23a5-4622-b02f-9a78e1d4c55f)<br/>메인화면                                                                                                                     |
## 🗒️API 명세서

---
현재 함수 이름이 아래 표에서 빠져있으며, 전문은 해당 [노션 링크](https://www.notion.so/oreumi/API-8dcf98b75b7d44858c79f9e4434798a6)에 있습니다.


| 기능설명 | url | http Method | 연결되는 HTML 파일 |
| --- | --- | --- | --- |
| 일반 게시판 게시글 목록 가져오기 | /api/common | GET | X |
| 리뷰 게시판 게시글 목록 가져오기 | /api/review | GET | X |
| Vip 게시판 게시글 목록 가져오기 | /api/vip | GET | X |
| 일반  게시판 목록 페이지로 가져오기 | /api/common2 | GET | X |
| 리뷰 게시판 목록 페이지로 가져오기 | /api/review | GET | X |
| VIP 게시판 목록 페이지로 가져오기 | /api/vip2 | GET | X |
| 일반 게시글 1개 가져오기 | /api/common/{article_id} | GET | X |
| 리뷰 게시글 1개 가져오기 | /api/review/{article_id} | GET | X |
| Vip 게시글 1개 가져오기 | /api/vip/{article_id} | GET | X |
| 일반 게시글 생성 | /api/common/{user_id} | POST | X |
| 리뷰 게시글 생성 | /api/review/{user_id} | POST | X |
| Vip 게시글 생성 | /api/vip/{user_id} | POST | X |
| 일반 게시글 수정 | /api/common/{article_id} | PUT | X |
| 리뷰 게시글 수정 | /api/review/{article_id} | PUT | X |
| Vip 게시글 수정 | /api/vip/{article_id} | PUT | X |
| 일반 게시글 삭제 | /api/common/{article_id} | DELETE | X |
| 리뷰 게시글 삭제 | /api/review/{article_id} | DELETE | X |
| Vip 게시글 삭제 | /api/vip/{article_id} | DELETE | X |
| 일반 게시글 좋아요 기능 | /api/common/like/{user_id}/{article_id} | GET | X |
| 리뷰 게시글 좋아요 기능 | /api/review/like/{user_id}/{article_id} | GET | X |
| Vip 게시글 좋아요 기능 | /api/vip/like/{user_id}/{article_id} | GET | X |
| 일반 게시글 추천 수 반환 | /api/common/like/{article_id} | GET | X |
| 리뷰 게시글 추천 수 반환 | /api/review/like/{article_id} | GET | X |
| VIP 게시글 추천 수 반환 | /api/vip/like/{article_id} | GET | X |
| 일반 게시판 모든 댓글 가져오기 | /api/comment/common | GET | X |
| 리뷰 게시판 모든 댓글 가져오기 | /api/comment/review | GET | X |
| Vip 게시판 모든 댓글 가져오기 | /api/comment/vip | GET | X |
| 일반 게시판 댓글 1개 가져오기 | /api/comment/common/{comment_id} | GET | X |
| 리뷰 게시판 댓글 1개 가져오기 | /api/comment/review/{comment_id} | GET | X |
| Vip 게시판 댓글 1개 가져오기 | /api/comment/vip/{comment_id} | GET | X |
| 일반 게시판 특정 게시글에 달린 모든 댓글 가져오기 | /api/comment/common/{article_id} | GET | X |
| 리뷰 게시판 특정 게시글에 달린 모든 댓글 가져오기 | /api/comment/review/{article_id} | GET | X |
| Vip 게시판 특정 게시글에 달린 모든 댓글 가져오기 | /api/comment/vip/{article_id} | GET | X |
| 일반 게시판 댓글 쓰기 | /api/comment/common/{article_id} | POST | X |
| 리뷰 게시판 댓글 쓰기 | /api/comment/review/{article_id} | POST | X |
| Vip 게시판 댓글 쓰기 | /api/comment/vip/{article_id} | POST | X |
| 일반 게시판 댓글 수정 | /api/comment/common/{article_id}/{comment_id} | PUT | X |
| 리뷰 게시판 댓글 수정 | /api/comment/review/{article_id}/{comment_id} | PUT | X |
| Vip 게시판 댓글 수정 | /api/comment/vip/{article_id}/{comment_id} | PUT | X |
| 일반 게시판 댓글 삭제 | /api/comment/common/{comment_id} | DELETE | X |
| 리뷰 게시판 댓글 삭제 | /api/comment/review/{comment_id} | DELETE | X |
| Vip 게시판 댓글 삭제 | /api/comment/vip/{comment_id} | DELETE | X |
| 일반 게시글 댓글 좋아요 기능 | /common/like/{user_id}/{article_id} | GET | X |
| 리뷰 게시글 댓글 좋아요 기능 | /review/like/{user_id}/{article_id} | GET | X |
| Vip 게시글 댓글 좋아요 기능 | /vip/like/{user_id}/{article_id} | GET | X |
| 일반 게시글 특정 댓글 추천 수 반환 | /api/common/recommend/{article_id} | GET | X |
| 리뷰 게시글 특정 댓글 추천 수 반환 | /api/review/recommend/{article_id} | GET | X |
| VIP 게시글 특정 댓글 추천 수 반환 | /api/vip/recommend/{article_id} | GET | X |
| 일반 게시글에 달린 댓글 수 반환 | /api/comment/common/count/{article_id} | GET | X |
| 리뷰 게시글에 달린 댓글 수 반환 | /api/comment/review/count/{article_id} | GET | X |
| VIP 게시글에 달린 댓글 수 반환 | /api/comment/vip/count/{article_id} | GET | X |
| 일반 게시판 전체 뷰 | /commons | GET | bulletinboard.html |
| 리뷰 게시판 뷰 | /reviews | GET | review-board.html |
| Vip 게시판 뷰 | /vips | GET | vip-board.html |
| 일반 게시판 글 작성 뷰 | /newArticleBulletin | GET | writeBulletin.html |
| 리뷰 게시판 글 작성 뷰 | /newArticleReview | GET | writeReview.html |
| Vip 게시판 글 작성 뷰 | /newArticleVip | GET | writeVip.html |
| 일반 게시판 게시글 상세 뷰 | /common/{articleId} | GET | detailCommon.html |
| 리뷰 게시판 게시글 상세 뷰 | /review/{articleId} | GET | detailReveiw.html |
| Vip 게시판 게시글 상세 뷰 | /vip/{articleId} | GET | detailVIP.html |
| 일반 게시글 수정 뷰 | /editArticleBulletin | GET | editBulletin.html |
| 리뷰 게시글 수정 뷰 | /editArticleReview | GET | editReview.html |
| VIP 게시글 수정 뷰 | /editArticleVip | GET | editVip.html |
| 일반 게시글 삭제 후 일반 게시판으로 이동 | /deleteArticleCommon | GET | redirect:commons |
| 리뷰 게시글 삭제 후 리뷰 게시판으로 이동 | /deleteArticleReview | GET | redirect:reviews |
| VIP 게시글 삭제 후 VIP 게시판으로 이동 | /deleteArticleVip | GET | redirect:vips |
| 일반 게시글 추천 처리 후 일반 게시글 상세로 이동 | /article/common/like/{user_id}/{article_id} | GET | redirect:/common/ + article_id |
| 리뷰 게시글 추천 처리 후 리뷰 게시글 상세로 이동 | /article/review/like/{user_id}/{article_id} | GET | redirect:/review/ + article_id |
| VIP 게시글 추천 처리 후 VIP 게시글 상세로 이동 | /article/vip/like/{user_id}/{article_id} | GET | redirect:/vip/ + article_id |
| 회원 가입 | /user | POST | redirect:/login |
| 회원 탈퇴 | /delete-account | POST | redirect:/logout |
| 로그아웃 | /logout | GET | redirect:/login |
| 아이디 중복 체크 | /checkUsername | GET | X |
| 닉네임 중복 체크 | /checkNickname | GET | X |
| 내 정보 수정 | /updateInfo | POST | redirect:/myInformation |
| 권한 수정 | /updateAuthor | POST | redirect:/admin |
| 로그인 뷰 | /login | GET | login.html |
| 회원가입 뷰 | /merbership | GET | membership.html |
| 메인 화면 뷰 | /mainScreen | GET | mainScreen.html |
| 내 정보 뷰 | /myInformaion | GET | myInformation.html |
| 관리 뷰 | /admin | GET | adminpage.html |

## 📂 프로젝트 구조

---

```java
📁1인분이요~
    ├─main
    │  ├─java
    │  │  └─com
    │  │      └─estsoft
    │  │          └─for1person
    │  │              │  For1PersonApplication.java
    │  │              │  
    │  │              ├─config
    │  │              │      LoginFailHandler.java
    │  │              │      SwaggerConfig.java
    │  │              │      WebSecurityConfig.java
    │  │              │      
    │  │              ├─controller
    │  │              │      ArticleController.java
    │  │              │      CommentController.java
    │  │              │      PageController.java
    │  │              │      UserController.java
    │  │              │      UserViewController.java
    │  │              │      
    │  │              ├─dto
    │  │              │      AddArticleRequest.java
    │  │              │      AddCommentRequest.java
    │  │              │      AddReviewRequest.java
    │  │              │      AddUserRequest.java
    │  │              │      AddVipRequest.java
    │  │              │      ArticleViewResponse.java
    │  │              │      CommentCommonViewResponse.java
    │  │              │      CommentReviewViewResponse.java
    │  │              │      CommentVipViewResponse.java
    │  │              │      CommonViewResponse.java
    │  │              │      ReviewViewResponse.java
    │  │              │      UserViewResponse.java
    │  │              │      VipViewResponse.java
    │  │              │      
    │  │              ├─entity
    │  │              │      Article.java
    │  │              │      ArticleLike.java
    │  │              │      ArticleRecommend.java
    │  │              │      CommentCommon.java
    │  │              │      CommentReview.java
    │  │              │      CommentVip.java
    │  │              │      Review.java
    │  │              │      ReviewLike.java
    │  │              │      ReviewRecommend.java
    │  │              │      User.java
    │  │              │      Vip.java
    │  │              │      VipLike.java
    │  │              │      VipRecommend.java
    │  │              │      
    │  │              ├─exception
    │  │              │      NotFoundException.java
    │  │              │      
    │  │              ├─repository
    │  │              │      ArticleLikeRepository.java
    │  │              │      ArticleRecommendRepository.java
    │  │              │      ArticleRepository.java
    │  │              │      CommentCommonRepository.java
    │  │              │      CommentReviewRepository.java
    │  │              │      CommentVipRepository.java
    │  │              │      ReviewLikeRepository.java
    │  │              │      ReviewRecommendRepository.java
    │  │              │      ReviewRepository.java
    │  │              │      UserRepository.java
    │  │              │      VipLikeRepository.java
    │  │              │      VipRecommendRepository.java
    │  │              │      VipRepository.java
    │  │              │      
    │  │              └─service
    │  │                      ArticleService.java
    │  │                      CommentService.java
    │  │                      UserDetailService.java
    │  │                      UserService.java
    │  │                      
    │  └─resources
    │      │  application.properties
    │      │  
    │      ├─static
    │      │  │  editorTest.html
    │      │  │  
    │      │  ├─css
    │      │  │      adminpage.css
    │      │  │      bulletinboard.css
    │      │  │      detailpage.css
    │      │  │      login.css
    │      │  │      mainScreen.css
    │      │  │      membership.css
    │      │  │      modal.css
    │      │  │      myInformation.css
    │      │  │      review-board.css
    │      │  │      write.css
    │      │  │      
    │      │  ├─Img
    │      │  │      icon1.png
    │      │  │      img.png
    │      │  │      img_1.png
    │      │  │      img_10.png
    │      │  │      img_11.png
    │      │  │      img_12.png
    │      │  │      img_13.png
    │      │  │      img_14.png
    │      │  │      img_15.png
    │      │  │      img_16.png
    │      │  │      img_17.png
    │      │  │      img_18.png
    │      │  │      img_19.png
    │      │  │      img_2.png
    │      │  │      img_20.png
    │      │  │      img_21.png
    │      │  │      img_22.png
    │      │  │      img_23.png
    │      │  │      img_3.png
    │      │  │      img_4.png
    │      │  │      img_5.png
    │      │  │      img_6.png
    │      │  │      img_7.png
    │      │  │      img_8.png
    │      │  │      img_9.png
    │      │  │      
    │      │  └─js
    │      │          admin.js
    │      │          bulletinboard.js
    │      │          detailCommon.js
    │      │          detailReview.js
    │      │          detailVip.js
    │      │          editCommon.js
    │      │          editReview.js
    │      │          editVip.js
    │      │          login.js
    │      │          membership.js
    │      │          modal.js
    │      │          myInformation.js
    │      │          write.js
    │      │          writeCommon.js
    │      │          writeReview.js
    │      │          writeVIP.js
    │      │          
    │      └─Templates
    │              adminpage.html
    │              bulletinboard.html
    │              detailCommon.html
    │              detailReview.html
    │              detailVIP.html
    │              editBulletin.html
    │              editReview.html
    │              editVIP.html
    │              header.html
    │              login.html
    │              mainScreen.html
    │              membership.html
    │              myInformation.html
    │              review-board.html
    │              vip-board.html
    │              writeBulletin.html
    │              writeReview.html
    │              writeVIP.html
    │              
    └─test
        └─java
            └─com
                └─estsoft
                    └─for1person
                            For1PersonApplicationTests.java
                            

```

## 🖥️UI

---

| ![스크린샷 2024-04-07 162506](https://github.com/Allewis0201/for-1-person/assets/108185369/2256fcfc-ef02-443e-8528-ce94a91ed9e4)<br/>로그인  | ![스크린샷 2024-04-07 162600](https://github.com/Allewis0201/for-1-person/assets/108185369/bc76f18d-635e-455f-9f3c-bca35b5bd487)<br/>회원가입      | ![스크린샷 2024-04-07 162623](https://github.com/Allewis0201/for-1-person/assets/108185369/362d385a-3ce8-4ff3-91b9-afd139a289ac)<br/>메인화면 |
|---------------------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------|
| ![스크린샷 2024-04-07 162806](https://github.com/Allewis0201/for-1-person/assets/108185369/8f1fc27c-c6f0-46ee-ab1c-bee306eba11c)<br/>일반게시판                                                                                                                                 | ![스크린샷 2024-04-07 162940](https://github.com/Allewis0201/for-1-person/assets/108185369/dea5c66f-6cc1-4e62-9081-6dd80f95aff3)<br/>리뷰게시판                                                                                                                                      | ![스크린샷 2024-04-07 163051](https://github.com/Allewis0201/for-1-person/assets/108185369/241f885b-2932-41d8-834b-4308204a35f5)<br/>VIP게시판                                                                                                                                |
| ![스크린샷 2024-04-07 162815](https://github.com/Allewis0201/for-1-person/assets/108185369/01afc807-b16e-4980-aaa7-228388e410cf)<br/>일반게시판 글 상세                                                                                                                            | ![스크린샷 2024-04-07 164338](https://github.com/Allewis0201/for-1-person/assets/108185369/73c7f3bd-0223-4d74-97b7-c3a980b81e63)<br/>리뷰게시판 글 상세                                                                                                                                 | ![스크린샷 2024-04-07 163100](https://github.com/Allewis0201/for-1-person/assets/108185369/93d05146-078b-4c2e-b6cf-4d08b2b2881c)<br/>VIP게시판 글 상세                                                                                                                           |
| ![스크린샷 2024-04-07 162759](https://github.com/Allewis0201/for-1-person/assets/108185369/aa6ab6c4-966d-401a-908f-acfca6f0aec3)<br/>일반게시판 글 추가/수정                                                                                                                         | ![스크린샷 2024-04-07 162929](https://github.com/Allewis0201/for-1-person/assets/108185369/928ab6f9-0761-4dd7-9e72-8a5cc16c5fe6)<br/>리뷰게시판 글 추가                                                                                                                                 | ![스크린샷 2024-04-07 163046](https://github.com/Allewis0201/for-1-person/assets/108185369/425d6363-eb4c-4ace-a6cf-66c25d35a66d)<br/>VIP게시판 글 추가                                                                                                                           |
| ![스크린샷 2024-04-07 162701](https://github.com/Allewis0201/for-1-person/assets/108185369/181a1c87-f521-435f-86c3-c537764406b2)<br/>계정정보 | ![스크린샷 2024-04-07 163139](https://github.com/Allewis0201/for-1-person/assets/108185369/f2d236c4-c59d-4025-9ff5-182882bd99ea)<br/>운영진 관리페이지 | ![스크린샷 2024-04-07 162656](https://github.com/Allewis0201/for-1-person/assets/108185369/bc99e4e0-f62e-44fb-9ea3-b33e3253a0af)<br/>헤더부분 |

## 📍 주요기능

---

### 메인 화면

- 로그인을 해서 들어오게 되면 처음으로 보이는 화면으로, 위의 헤더 부분을 이용하여 각 게시판으로 이동을 할 수 있으며, 우측 상단의 내 정보 아이콘을 통하여 내 정보 페이지로 이동할 수 있습니다.
- 현재 등급이 운영자(수저)라면, 모달창을 이용하여 운영자 페이지로 이동할 수 있습니다.

### 게시판
#### 게시판 공통기능

- 글 추가, 수정, 삭제, 조회를 할 수 있으며, 댓글 추가 및 삭제가 가능합니다. 글과 댓글을 작성한 대상자일 경우, 수정과, 삭제, 댓글 삭제가 가능합니다.
- 각 아이디 별로 한 번씩 추천할 수 있으며, 각 글은 조회수를 가질 수 있습니다.

#### 일반게시판

- 일반회원(준회원/쌀밥) 부터 사용할 수 있는 페이지로 가장 일반적인 게시판입니다. 헤더를 통해서 입장할 수 있습니다.
- 게시판에서는 글 번호, 제목, 작성자, 날짜, 조회수, 추천을 확인할 수 있으며, 글을 들어가 확인했을 때는 더해서 댓글 수,  글을 수정한 시간까지 알 수 있습니다.

#### 리뷰게시판

- 일반회원(준회원/쌀밥)부터 사용할 수 있는 페이지로, 헤더를 통해서 입장할 수 있습니다.
- 리뷰를 위한 게시판이므로, 별점을 매길 수 있으며 이는 추후 수정이 가능합니다.
- 게시판에서는 글 번호, 제목, 별점, 작성자, 날짜, 조회수, 추천을 확인할 수 있으며, 글을 들어가 확인했을 때는 더해서 댓글 수,  글을 수정한 시간까지 알 수 있습니다.

#### VIP 게시판

- VIP(오므라이스)부터 사용할 수 있는 페이지로, 해당 등급이 될 경우 헤더를 통해서 입장할 수 있습니다.
- 게시판에서는 글 번호, 제목, 작성자, 날짜, 조회수, 추천을 확인할 수 있으며, 글을 들어가 확인했을 때는 더해서 댓글 수,  글을 수정한 시간까지 알 수 있습니다.
- 만약 VIP보다 낮은 등급의 사용자가 접근하려고 할 경우 알림창과 함께 일반게시판으로 이동됩니다.

### 유저 관련 기본 기능

- 로그인 : 로그인이 된 이후에 서버에 전부 저장하여, 아이디 저장 기능을 제공하며, 내 정보를 확인하여 이후 서비스를 사용할 수 있게 하였습니다.
- 회원가입 기능 : 계정 생성을 위한 기능으로, 아이디, 닉네임이 중복되지는 않았는지, 비밀번호와 비밀번호 확인 란에 들어간 비밀번호가 동일한지를 확인하여 전부 만족하는 경우 회원가입이 처리 됩니다. 이 때 회원가입을 막 완료한 계정은 쌀밥(준회원)으로 자동 설정이 됩니다.
- 내 정보 페이지  : 메인 화면, 또는 게시판 화면 우측 상단의 아이콘을 통해 입장할 수 있으며 이곳에서 비밀번호 변경을 할 수 있습니다.
- 운영진 페이지 : 현재 등급이 수저(운영진)일 경우 우측 상단의 아이콘을 통해 입장할 수 있으며, 각 회원의 아이디, 닉네임, 회원등급, 게시글 수,  댓글 수를 확인할 수 있습니다. 더하여, 몇 몇의 회원을 선택하여 등급을 조정할 수 있습니다. 또한, 아이디, 닉네임으로 유저를 검색할 수 있습니다.