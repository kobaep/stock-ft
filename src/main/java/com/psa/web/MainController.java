package com.psa.web;

import com.psa.database.Stockdata;
import com.psa.domain.Stock;
import com.psa.security.AppUser;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.psa.data.*;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.*;
import com.psa.process.Process;

@Controller
@RequestMapping("/main")
public class MainController {

	@RequestMapping(value = "/index", produces = "text/html")
    public String index(Model model) {
        List<Stock> stocks = Excel.getData();

        List<Stock> stocksLate1 = new ArrayList<Stock>();
        List<Stock> stocksLate2 = new ArrayList<Stock>();
        List<Stock> stocksLate3 = new ArrayList<Stock>();
        List<Stock> stocksLate4 = new ArrayList<Stock>();
        List<Stock> stocksLate5 = new ArrayList<Stock>();
        List<Stock> stocksLate6 = new ArrayList<Stock>();
        List<Stock> stocksLate7 = new ArrayList<Stock>();
        List<Stock> stocksLate8 = new ArrayList<Stock>();

        for(Stock s : stocks) {

            if(s.getOpen1() >= 0.01 && s.getOpen1() <= 1.99) {
                Double spread = (s.getLast() - s.getOpen1())/0.01;
                s.setSpread(spread.intValue());
                stocksLate1.add(s);
            }

            if(s.getOpen1() > 1.99 && s.getOpen1() <= 4.99) {
                Double spread = (s.getLast() - s.getOpen1())/0.02;
                s.setSpread(spread.intValue());
                stocksLate2.add(s);
            }

            if(s.getOpen1() > 5.00 && s.getOpen1() <= 9.99) {
                Double spread = (s.getLast() - s.getOpen1())/0.05;
                s.setSpread(spread.intValue());
                stocksLate3.add(s);
            }

            if(s.getOpen1() > 10.00 && s.getOpen1() <= 24.99) {
                Double spread = (s.getLast() - s.getOpen1())/0.10;
                s.setSpread(spread.intValue());
                stocksLate4.add(s);
            }

            if(s.getOpen1() > 25.00 && s.getOpen1() <= 99.99) {
                Double spread = (s.getLast() - s.getOpen1())/0.25;
                s.setSpread(spread.intValue());
                stocksLate5.add(s);
            }

            if(s.getOpen1() > 99.99 && s.getOpen1() <= 299.99) {
                Double spread = (s.getLast() - s.getOpen1())/0.5;
                s.setSpread(spread.intValue());
                stocksLate6.add(s);
            }

            if(s.getOpen1() > 299.99 && s.getOpen1() <= 399.99) {
                Double spread = (s.getLast() - s.getOpen1())/1.00;
                s.setSpread(spread.intValue());
                stocksLate7.add(s);
            }

            if(s.getOpen1() > 399.99) {
                Double spread = (s.getLast() - s.getOpen1())/2.00;
                s.setSpread(spread.intValue());
                stocksLate8.add(s);
            }

        }

//        Process.saveDataEcexl(stocks);
        model.addAttribute("stocksRate1",stocksLate1);
        model.addAttribute("stocksRate2",stocksLate2);
        model.addAttribute("stocksRate3",stocksLate3);
        model.addAttribute("stocksRate4",stocksLate4);
        model.addAttribute("stocksRate5",stocksLate5);
        model.addAttribute("stocksRate6",stocksLate6);
        model.addAttribute("stocksRate7",stocksLate7);
        model.addAttribute("stocksRate8",stocksLate8);

        return "stock/index";
    }

//    @RequestMapping(value = "/data", method = RequestMethod.POST, headers = "Accept=application/json")
//    @ResponseBody
//    public ResponseEntity<String> jsonData() {
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Content-Type", "application/json; charset=utf-8");
//        try {
//            List<Stock> stocks = Excel.getData();
//            List<Double> buyVols = new ArrayList();
//            int i = 0;
//            for (Stock s : stocks) {
//                buyVols.add(s.getBuyVol());
//            }
//
//            Collections.sort(buyVols);
//            for (Double d : buyVols) {
//                System.out.println(d);
//            }
//            Map<String, Object> map = new HashMap<String, Object>();
//            map.put("test",13);
//            JSONObject jsonObjectMap = new JSONObject(map);
//            return new ResponseEntity<String>(null, headers, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<String>("{\"ERROR\":"+e.getMessage()+"\"}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @RequestMapping(value = "/data", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> jsonData() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        try {

            List<Stock> stocks = Excel.getData();

            List<Stock> stocksLate1 = new ArrayList<Stock>();
            List<Stock> stocksLate2 = new ArrayList<Stock>();
            List<Stock> stocksLate3 = new ArrayList<Stock>();
            List<Stock> stocksLate4 = new ArrayList<Stock>();
            List<Stock> stocksLate5 = new ArrayList<Stock>();
            List<Stock> stocksLate6 = new ArrayList<Stock>();
            List<Stock> stocksLate7 = new ArrayList<Stock>();
            List<Stock> stocksLate8 = new ArrayList<Stock>();

            JSONArray jsonArray1 = new JSONArray();
            JSONArray jsonArray2 = new JSONArray();
            JSONArray jsonArray3 = new JSONArray();
            JSONArray jsonArray4 = new JSONArray();
            JSONArray jsonArray5 = new JSONArray();
            JSONArray jsonArray6 = new JSONArray();
            JSONArray jsonArray7 = new JSONArray();
            JSONArray jsonArray8 = new JSONArray();

            for(Stock s : stocks) {

                if(s.getOpen1() >= 0.01 && s.getOpen1() <= 1.99) {
                    Double spread = (s.getLast() - s.getOpen1())/0.01;
                    s.setSpread(spread.intValue());

                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("symbol", s.getSymbol());
                    jsonObject.put("spread", s.getSpread());

                    jsonArray1.put(jsonObject);

                }

                if(s.getOpen1() > 1.99 && s.getOpen1() <= 4.99) {
                    Double spread = (s.getLast() - s.getOpen1())/0.02;
                    s.setSpread(spread.intValue());

                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("symbol", s.getSymbol());
                    jsonObject.put("spread", s.getSpread());

                    jsonArray2.put(jsonObject);

                }

                if(s.getOpen1() > 5.00 && s.getOpen1() <= 9.99) {
                    Double spread = (s.getLast() - s.getOpen1())/0.05;
                    s.setSpread(spread.intValue());

                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("symbol", s.getSymbol());
                    jsonObject.put("spread", s.getSpread());

                    jsonArray3.put(jsonObject);

                }

                if(s.getOpen1() > 10.00 && s.getOpen1() <= 24.99) {
                    Double spread = (s.getLast() - s.getOpen1())/0.10;
                    s.setSpread(spread.intValue());

                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("symbol", s.getSymbol());
                    jsonObject.put("spread", s.getSpread());

                    jsonArray4.put(jsonObject);

                }

                if(s.getOpen1() > 25.00 && s.getOpen1() <= 99.99) {
                    Double spread = (s.getLast() - s.getOpen1())/0.25;
                    s.setSpread(spread.intValue());

                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("symbol", s.getSymbol());
                    jsonObject.put("spread", s.getSpread());

                    jsonArray5.put(jsonObject);

                }

                if(s.getOpen1() > 99.99 && s.getOpen1() <= 299.99) {
                    Double spread = (s.getLast() - s.getOpen1())/0.5;
                    s.setSpread(spread.intValue());

                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("symbol", s.getSymbol());
                    jsonObject.put("spread", s.getSpread());

                    jsonArray6.put(jsonObject);

                }

                if(s.getOpen1() > 299.99 && s.getOpen1() <= 399.99) {
                    Double spread = (s.getLast() - s.getOpen1())/1.00;
                    s.setSpread(spread.intValue());

                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("symbol", s.getSymbol());
                    jsonObject.put("spread", s.getSpread());

                    jsonArray7.put(jsonObject);

                }

                if(s.getOpen1() > 399.99) {
                    Double spread = (s.getLast() - s.getOpen1())/2.00;
                    s.setSpread(spread.intValue());

                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("symbol", s.getSymbol());
                    jsonObject.put("spread", s.getSpread());

                    jsonArray8.put(jsonObject);

                }

            }

            JSONObject j1 = new JSONObject();
            j1.put("stocksLate1", jsonArray1);
            j1.put("stocksLate2", jsonArray2);
            j1.put("stocksLate3", jsonArray3);
            j1.put("stocksLate4", jsonArray4);
            j1.put("stocksLate5", jsonArray5);
            j1.put("stocksLate6", jsonArray6);
            j1.put("stocksLate7", jsonArray7);
            j1.put("stocksLate8", jsonArray8);

            return new ResponseEntity<String>(j1.toString(), headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"ERROR\":"+e.getMessage()+"\"}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}