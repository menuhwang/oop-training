# OOP 연습

## 주자창 시스템 구현

### 객체
- Parking: 주차장
  ```
    chargePolicy: 요금 정책
    history: 입차 내역
    cashier: 캐셔
  ```
- ChargePolicy: 요금 정책
  ```
    basicTime: 기본 시간
    basicCharge: 기본 요금
    unitTime: 추가 시간 단위
    unitCharge: 추가 시간 당 요금
  ```
- Car: 차
  ```
    id: 차량 번호
  ```
- Time: 입출차 시간
  ```
    hour: 시
    minute: 분
  ```
- Cashier: 캐셔
  ```
    history: 주차장의 입차 내역
  ```

### 기능

#### 입차

- 입차 로그

#### 출차

- 출차 로그

#### 요금 계산

유료 주차장으로 전환!

- 기본 이용시간
- 기본 요금
- 추가 시간 단위
- 추가 시간 당 요금

### Log

- [2023.06.28] 입출차 관리 및 정산을 담당하는 캐셔 고용
- [2023.06.27] 요금 계산 시스템 추가
- [2023.06.27] Car 객체 생성, Parking 주차된 차량 저장
- [2023.06.27] 입차, 출차 기능 생성
- [2023.06.27] 프로젝트 생성