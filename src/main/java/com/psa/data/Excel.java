package com.psa.data;

import com.psa.domain.Stock;

import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class Excel {
	public static List<Stock> getData() {
		try {
			FileInputStream file = new FileInputStream(new File("/Users/apichat/Workspace/WindowXp/SETbackup/15ForJava3.xlsm"));
			System.out.println("found file");
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			System.out.println("in workbook");
			XSSFSheet sheet = workbook.getSheetAt(0);
			List<Stock> stocks = new ArrayList<Stock>();
			for (int i = 1; i < 314; i++) {
				Stock stock = new Stock();
				XSSFRow row = sheet.getRow(i);
				if (row.getCell(0).getCellType() == Cell.CELL_TYPE_STRING) {
					stock.setSymbol(row.getCell(0).getStringCellValue());
				}
				if (row.getCell(0).getCellType() == Cell.CELL_TYPE_FORMULA) {
					stock.setSymbol(null);
				}
				if (row.getCell(1).getCellType() == Cell.CELL_TYPE_STRING) {
					stock.setClose(null);
				}
				if (row.getCell(1).getCellType() == Cell.CELL_TYPE_FORMULA) {
					stock.setClose(row.getCell(1).getNumericCellValue());
				}
				if (row.getCell(2).getCellType() == Cell.CELL_TYPE_STRING) {
					stock.setOpen1(null);
				}
				if (row.getCell(2).getCellType() == Cell.CELL_TYPE_FORMULA) {
					stock.setOpen1(row.getCell(2).getNumericCellValue());
				}
				if (row.getCell(3).getCellType() == Cell.CELL_TYPE_STRING) {
					stock.setOpen2(null);
				}
				if (row.getCell(3).getCellType() == Cell.CELL_TYPE_FORMULA) {
					stock.setOpen2(row.getCell(3).getNumericCellValue());
				}
				if (row.getCell(4).getCellType() == Cell.CELL_TYPE_STRING) {
					stock.setHigh(null);
				}
				if (row.getCell(4).getCellType() == Cell.CELL_TYPE_FORMULA) {
					stock.setHigh(row.getCell(4).getNumericCellValue());
				}
				if (row.getCell(5).getCellType() == Cell.CELL_TYPE_STRING) {
					stock.setLow(null);
				}
				if (row.getCell(5).getCellType() == Cell.CELL_TYPE_FORMULA) {
					stock.setLow(row.getCell(5).getNumericCellValue());
				}
				if (row.getCell(6).getCellType() == Cell.CELL_TYPE_STRING) {
					stock.setLast(null);
				}
				if (row.getCell(6).getCellType() == Cell.CELL_TYPE_FORMULA) {
					stock.setLast(row.getCell(6).getNumericCellValue());
				}
				if (row.getCell(7).getCellType() == Cell.CELL_TYPE_STRING) {
					stock.setBuyVol(null);
				}
				if (row.getCell(7).getCellType() == Cell.CELL_TYPE_FORMULA) {
					stock.setBuyVol(row.getCell(7).getNumericCellValue());
				}
				if (row.getCell(8).getCellType() == Cell.CELL_TYPE_STRING) {
					stock.setSellVol(null);
				}
				if (row.getCell(8).getCellType() == Cell.CELL_TYPE_FORMULA) {
					stock.setSellVol(row.getCell(8).getNumericCellValue());
				}
				if (row.getCell(9).getCellType() == Cell.CELL_TYPE_STRING) {
					stock.setBuyVal(null);
				}
				if (row.getCell(9).getCellType() == Cell.CELL_TYPE_FORMULA) {
					stock.setBuyVal(row.getCell(9).getNumericCellValue());
				}
				if (row.getCell(10).getCellType() == Cell.CELL_TYPE_STRING) {
					stock.setSellVal(null);
				}
				if (row.getCell(10).getCellType() == Cell.CELL_TYPE_FORMULA) {
					stock.setSellVal(row.getCell(10).getNumericCellValue());
				}
				if (row.getCell(11).getCellType() == Cell.CELL_TYPE_STRING) {
					stock.setTval(null);
				}
				if (row.getCell(11).getCellType() == Cell.CELL_TYPE_FORMULA) {
					stock.setTval(row.getCell(11).getNumericCellValue());
				}
				if (row.getCell(12).getCellType() == Cell.CELL_TYPE_STRING) {
					stock.setTvol(null);
				}
				if (row.getCell(12).getCellType() == Cell.CELL_TYPE_FORMULA) {
					stock.setTvol(row.getCell(12).getNumericCellValue());
				}
				if (row.getCell(13).getCellType() == Cell.CELL_TYPE_STRING) {
					stock.setAskV1(null);
				}
				if (row.getCell(13).getCellType() == Cell.CELL_TYPE_FORMULA) {
					stock.setAskV1(row.getCell(13).getNumericCellValue());
				}
				if (row.getCell(14).getCellType() == Cell.CELL_TYPE_STRING) {
					stock.setAskV2(null);
				}
				if (row.getCell(14).getCellType() == Cell.CELL_TYPE_FORMULA) {
					stock.setAskV2(row.getCell(14).getNumericCellValue());
				}
				if (row.getCell(15).getCellType() == Cell.CELL_TYPE_STRING) {
					stock.setBidV1(null);
				}
				if (row.getCell(15).getCellType() == Cell.CELL_TYPE_FORMULA) {
					stock.setBidV1(row.getCell(15).getNumericCellValue());
				}
				if (row.getCell(16).getCellType() == Cell.CELL_TYPE_STRING) {
					stock.setBidV2(null);
				}
				if (row.getCell(16).getCellType() == Cell.CELL_TYPE_FORMULA) {
					stock.setBidV2(row.getCell(16).getNumericCellValue());
				}
				stocks.add(stock);
			}
			return stocks;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}