package com.chargingservice.electriccar.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ApiDto {
    Long csId;
    //충전기ID
    String csNm;
    //충전소 명칭
    String addr;
    //충전소 주소
    String lat;
    //위도
    String longi;
    //경도
    Long cpld;
    //충전기ID
    String cpNm;
    //충전기명칭
    String chargeTp;
    //충전기타입(1:완속, 2: 급속)
    String cpTp;
    //충전방식(1:B타입(5핀),
    // 2: C타입(5핀),
    // 3:BC타입(5핀),
    // 4: BC타입(7핀),
    // 5: DC차 데모,
    // 6:AC 3상,
    // 7: DC콤보,
    // 8: DC차데모+DC콤보.
    // 9:DC차데모+AC3상,
    // 10: DC차데모+DC콤보, AC3상)

    String statUpdatetime;
    //
    String cpStat;
    //충전기 상태( 0: 상태확인불가, 1: 충전가능, 2: 충전중, 3:고장/점검, 4:통신장애, 5:통신미연결,9:충전예약)
}
