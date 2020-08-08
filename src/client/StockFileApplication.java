package client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fileprocessors.StockFileData;
import fileprocessors.StockFileReader;

public class StockFileApplication {
	
	public static void main(String args[]) throws IOException{
		StockFileReader fr = new StockFileReader("table.csv");
		
		List<HashMap<String, Double>> dataResult = populateStockFileData(fr.getHeaders(), fr.readFileData());
		StockFileData fileData = new StockFileData();
		fileData.addData(dataResult);
		fileData.printData();
		System.out.println(dataResult.size());
	}
	public static List<HashMap<String, Double>> populateStockFileData(List<String> headers, List<String> lines){
		List<HashMap<String, Double>> dataResult = new ArrayList<>();
		HashMap<String, Double> harr = new HashMap<>();
		harr.put("Ölesine",12.0);
		dataResult.add(harr);
		try {
			for (String line : lines) {
				int count = 0;
				String values[] = line.split(",");
				for (String value : values) {
					harr.put(headers.get(count), Double.parseDouble(value));
					count++;
				}
				dataResult.add(harr);
			}
		}catch(NullPointerException e){
			System.out.println("Null Pointer was caught ! ");
		}
		return dataResult;
	}
	
	
}
