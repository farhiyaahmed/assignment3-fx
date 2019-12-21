
package com.device.repository;

import com.device.model.Device;
import com.device.model.Sales;
import java.util.ArrayList;
import java.util.Map;

public interface Repository {

	public Device addAnItemToStock();

	public double checkAvailableStock(int deviceId);

	public Sales recordASale(Sales aSale);

	public void displayLowStocks();

	public void displayAvailableItemsAndGroupByCategory(int indexOfArrayListInMap);

	public void printAllSales();
	
	public Map<Integer,ArrayList<Device>> findAllDevicesMappedToTheirIndicesInAList();

}
