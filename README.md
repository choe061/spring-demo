Spring Demo
======================
* IDE : IntelliJ
* 구성 : Spring + MyBatis + Gradle + Java Configuration
* WAS : Tomcat
* Library : Spring 4.x, mybatis, mysql-connector, log4j, lombok, jackson
* API 개발 (프론트 개발 X)

## 1. 구조
* <code>Controller</code>, <code>Service</code>, <code>Persistence</code>, config, domain으로 구성
* xml 기반 설정이 아닌 자바 코드 기반 설정
* JDBC 대신 persistence 프레임워크 <code>MyBatis</code> 사용
* User에 대한 CRUD를 수행하는 API 개발

#### 1-1. Controller
UserController는 JSON 기반의 Rest API 서비스를 제공한다. @Controller와 @ResponseBody의 기능을 합친 @RestController를 사용한다.

#### 1-2. Service
UserService는 User의 CRUD(회원가입, 유저 조회, 삭제)에 관한 독립적인 기능을 하는 <code>@Service</code> 컴포넌트이다. DAO(Persistence)에 DB의 CURD 처리를 위임하고, 그 결과를 Controller에 반환한다. Service 레이어에서는 <code>@Transactional</code> 어노테이션을 사용하여 간단한 트랜잭션 처리를 하고, 추가적으로 단순 읽기 작업에 대해선 <code>@Transactional(readOnly = true)</code>를 추가해준다.

#### 1-3. Persistence
퍼시스턴스 프레임워크 MyBatis를 사용한다. DAO역할의 UserMapper는 <code>@Repository</code> 컴포넌트이다. Mapper Interface 방식과 Annotation 방식을 이용하여 구현한다.

#### 1-4. config, domain
자바 코드 기반의 설정 방법을 사용하여 DatabaseConfig Class와 MyBatisConfig Class가 있다.
