package com.chargingservice.electriccar.Controller;


import com.chargingservice.electriccar.DTO.ApiDto;


import lombok.Getter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

    @GetMapping(value = {"/data/{search}", "/data"})
//    @ResponseBody
    public static JSONObject ApiData(@PathVariable(required = false) String search) {
        JSONArray data = new JSONArray();
        JSONObject torres = new JSONObject();
        System.out.println("==========================="+search);
        try {

            if (search != null) {
            } else {
                search="";
            }
//            URLDecoder.decode((URLDecoder.decode(search, "8859_1")), "UTF-8"); //방법1
//            new String(search.getBytes("8859_1"), "utf-8"); //방법2
            String serviceKey = "FhXGRAzLpXSqfjaH9Pho%2BKNJ6g5937mSFmDQakHusvkBJd65CfTeyExGHTdH7g3J5GrDEPfBTLVlv6uRjhBNeQ%3D%3D";
            String url = "http://api.odcloud.kr/api/EvInfoServiceV2/v1/getEvSearchList";
            url += "?" + URLEncoder.encode("page", "UTF-8") + "=1";
            url += "&" + URLEncoder.encode("perPage", "UTF-8") + "=4000";
            url += "&" + URLEncoder.encode("returnType", "UTF-8") + "=json";
            url += "&" + URLEncoder.encode("cond[addr::LIKE]","UTF-8")+"="+ search;
            url += "&" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + serviceKey;

//            String testurl=URLEncoder.encode(url,"UTF-8");
            URL url1 = new URL(url);

            System.out.println(url1);
            String line = "";
            String result = "";

            BufferedReader br;
            br = new BufferedReader(new InputStreamReader(url1.openStream()));
            while ((line = br.readLine()) != null) {

                result = result.concat(line);
//            System.out.println(line);
            }

            JSONParser parser = new JSONParser();
            JSONObject obj = (JSONObject) parser.parse(result);
            JSONArray parse_listArr = (JSONArray) obj.get("data");

//            int kk=0;

            for (int i = 0; i < parse_listArr.size(); i++) {

                JSONObject object = new JSONObject();

                JSONObject ecCar = (JSONObject) parse_listArr.get(i);

                if(i==0){
                    object.put("csNm", ecCar.get("csNm"));
                    object.put("lat", ecCar.get("lat"));
                    object.put("longi", ecCar.get("longi"));
                    object.put("addr", ecCar.get("addr"));
                    data.add(object);
                }else{
                    JSONObject ecCar2 = (JSONObject) parse_listArr.get(i-1);
//                    System.out.println(ecCar.get("csNm")+" "+ecCar2.get("csNm"));
                    if(ecCar.get("csNm").equals(ecCar2.get("csNm"))){
//                        System.out.println("==당첨==");
                    }else{
                        object.put("csNm", ecCar.get("csNm"));
                        object.put("lat", ecCar.get("lat"));
                        object.put("longi", ecCar.get("longi"));
                        object.put("addr", ecCar.get("addr"));
                        data.add(object);
//                        kk=kk+1;
                    }
                }
            }
//            System.out.println(kk);

            torres.put("chargespot",data);

            br.close();


        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


        return torres;

    }

    @GetMapping("/testdata")
    public static void ApiDto() throws MalformedURLException {
        ApiDto data = new ApiDto();

        try {
            String serviceKey="FhXGRAzLpXSqfjaH9Pho%2BKNJ6g5937mSFmDQakHusvkBJd65CfTeyExGHTdH7g3J5GrDEPfBTLVlv6uRjhBNeQ%3D%3D";
            String url = "http://api.odcloud.kr/api/EvInfoServiceV2/v1/getEvSearchList";
            url += "?"+ URLEncoder.encode("page","UTF-8") +"=1";
            url += "&"+ URLEncoder.encode("perPage","UTF-8") +"=4000";
            url += "&"+ URLEncoder.encode("serviceKey","UTF-8") +"=" + serviceKey;
            URL url1 = new URL(url);
            String line = "";
            String result = "";
            
            BufferedReader br;
            br = new BufferedReader(new InputStreamReader(url1.openStream()));
            while ((line = br.readLine()) != null) {
                result = result.concat(line);
                System.out.println(line);
            }

            JSONParser parser = new JSONParser();
            JSONObject obj = (JSONObject)parser.parse(result);
            JSONArray parse_listArr = (JSONArray)obj.get("data");
            System.out.println("======================================================");
            for (int i=0;i< parse_listArr.size();i++) {
                ApiDto dto = new ApiDto();

                System.out.println("========================"+i+"===========================");
                JSONObject ecCar = (JSONObject) parse_listArr.get(i);
                dto.setCsId((Long)ecCar.get("csId"));
                dto.setCsNm((String)ecCar.get("csNm"));
                dto.setAddr((String)ecCar.get("addr"));
                dto.setLat((String)ecCar.get("lat"));
                dto.setLongi((String)ecCar.get("longi"));
                dto.setCpld((Long)ecCar.get("cpId"));
                dto.setCpNm((String)ecCar.get("cpNm"));
                dto.setChargeTp((String)ecCar.get("chargeTp"));
                dto.setCpTp((String)ecCar.get("cpTp"));
                dto.setStatUpdatetime((String)ecCar.get("statUpdatetime"));
                dto.setCpStat((String)ecCar.get("cpStat"));

                StringBuffer sb = new StringBuffer();
                sb.append("충전기ID : " + dto.getCsId() + ",\n"+
                        "충전소 명칭 : " + dto.getCsNm()  + ",\n"+
                        "충전소 주소 : "+ dto.getAddr() + ",\n"+
                        "위도 : " + dto.getLat() + ",\n"+
                        "경도 : " + dto.getLongi() + ",\n"+
                        "충전기ID : " + dto.getCpld() + ",\n"+
                        "충전기명칭 : " + dto.getCpNm() + ",\n"+
                        "충전기타입 : " + dto.getChargeTp() + ",\n"+
                        "충전방식 : " + dto.getCpTp() + ",\n"+
                        "갱신시간 : " + dto.getStatUpdatetime() + ",\n"+
                        "충전기상태 : " + dto.getCpStat());
                System.out.println(sb.toString());
            }

            br.close();

        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }


}
