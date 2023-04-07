# ElectricCar
# ClickEvent(Sidebar)
![2023_04_07](https://user-images.githubusercontent.com/84373336/230613364-955c10fa-4110-490f-871d-015f67029379.JPG)
# SearchEvent
![2023_04_02_search](https://user-images.githubusercontent.com/84373336/229350983-045fd4c1-1d12-4b3e-9af2-11575720ae40.png)

##### 참고사항: 충전소 id로 검색불가-공식api테스트 결과 명세에는 가능하다 나오지만 ID로는 값을 반환하지 않음 -> 주소(ADDR사용)

#####  YJT진행중 : readme개선,서버배포
#####  KIM진행중 : 실행 시 Map 위치기반 초기값 설정(search포함),  Click Icon(Marker) z-index 수정(InfoWindow포함)<img src="https://img.shields.io/badge/(추가)검색 시 열려있는INFOWINDOW 제거-F05032?style=for-the-badge&logo=git&logoColor=white">
##### wishlist : (경로검색? 미정.)
##### 완료 :~~검색기능(검색 api 여러가지 테스트 결과 톰캣 내장encoding방식으로 request param값이 한글일 경우 URI로 인식을 하지않아 API통신에 실패한다. 영어테스트 시 통신하는것을 확인함. 추후 springboot 내장톰캣 설정을 바꿔야함.) api개선 완료(marker,markers 초기화 후 출력진행)  ,topbar우측 아이콘제거(이벤트포함), Navbar Close Marker기능,Sidebar 내용 별 기능 상세정의(Css),SideBar 충전기현황 UI(CSS)수정~~ ,위경도 값 위치사진(로드뷰)
