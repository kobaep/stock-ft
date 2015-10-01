package com.psa.process;

import com.psa.data.Excel;
import com.psa.database.Stockdata;
import com.psa.domain.Stock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by apichat on 9/14/2015 AD.
 */
public class Process {

    public static void saveDataEcexl(List<Stock> stocks) {
        for (Stock s : stocks) {
//            Stockdata stockdata = new Stockdata();
//            stockdata.setSymbol(s.getSymbol());
//            stockdata.persist();

            Stockdata stockdata = Stockdata.findBySymbol(s.getSymbol());
            stockdata.setCloseVal(s.getClose());
            stockdata.setOpen1(s.getOpen1());
            stockdata.setOpen2(s.getOpen2());
            stockdata.setHigh(s.getHigh());
            stockdata.setLow(s.getLow());
            stockdata.setLastVal(s.getLast());
            stockdata.setBuyVol(s.getBuyVol());
            stockdata.setSellVol(s.getSellVol());
            stockdata.setBuyVal(s.getBuyVal());
            stockdata.setSellVal(s.getSellVal());
            stockdata.setTval(s.getTval());
            stockdata.setTvol(s.getTvol());
            stockdata.setAskV1(s.getAskV1());
            stockdata.setAskV2(s.getAskV2());
            stockdata.setBidV1(s.getBidV1());
            stockdata.setBidV2(s.getBidV2());
            stockdata.persist();
        }
        return;
    }

    public static void comparLast(List<Stock> stocks, List<Stockdata> stockdatas) {
        for (Stock st : stocks) {
            for (Stockdata std : stockdatas) {
                if (st.getSymbol().equals(std.getSymbol()) && st.getBuyVol() > std.getBuyVol()) {
                    System.out.println("befor " + std.getSymbol() +"=== " + std.getBuyVol() + " < " + "after " + st.getSymbol() +"=== " + st.getBuyVol());
                }
            }
        }
        return;
    }
}
