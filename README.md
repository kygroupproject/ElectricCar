# ElectricCar
#  Side Bar UI 작업진행중
![2023_03_14](https://user-images.githubusercontent.com/84373336/224666370-1d5e2b83-160f-453d-992b-fcdea4550201.png)
##### 참고사항: 충전소 id로 검색불가-공식api테스트 결과 명세에는 가능하다 나오지만 ID로는 값을 반환하지 않음 -> 주소(ADDR사용)

##### 진행중 : 검색기능(검색 api 여러가지 테스트 결과 톰캣 내장encoding방식으로 request param값이 한글일 경우 URI로 인식을 하지않아 API통신에 실패한다. 영어테스트 시 통신하는것을 확인함. 추후 springboot 내장톰캣 설정을 바꿔야함.) api개선 완료(marker,markers 초기화 후 출력진행)  , Navbar Close Marker기능
##### wishlist :실행 시 Map 위치기반 초기값 설정, topbar우측 아이콘제거(이벤트포함), Sidebar 내용 별 기능 상세정의(Css), Click Icon(Marker) z-index 수정(InfoWindow포함), SideBar 충전기현황 UI(CSS)수정, 서버배포
