package com.device.utilities;

import java.util.ArrayList;
import java.util.Scanner;

import com.device.model.Device;
import com.device.model.Laptop;
import com.device.repository.RepositoryImplementation;

public class LaptopData extends RepositoryImplementation {

	private static ArrayList<Device> arrayListOfLaptops;

	public static ArrayList<Device> getArrayListOfLaptops() {
		return arrayListOfLaptops;
	}

	public static void setArrayListOfLaptops(ArrayList<Device> arrayListOfLaptops) {
		LaptopData.arrayListOfLaptops = arrayListOfLaptops;
	}

	private static void checkIfListIsNullOrEmpty() {

		if (LaptopData.getArrayListOfLaptops() == null || LaptopData.getArrayListOfLaptops().isEmpty()) {
			ArrayList<Device> tablets = new ArrayList<>();
			LaptopData.setArrayListOfLaptops(tablets);
		}

	}

	@Override
	public Device addAnItemToStock() {

		Laptop aLaptop = new Laptop();

		Scanner scanner = HandleUserInputs.getScanner();

		System.out.println("Add new \"laptop\"");

		aLaptop.setId(HandleUserInputs.getId());

		System.out.println("Enter laptop name: ");
		aLaptop.setName(scanner.nextLine());

		System.out.println("Enter laptop type: ");
		aLaptop.setType(scanner.nextLine());

		System.out.println("Enter laptop core: ");
		aLaptop.setCore(scanner.nextLine());

		// index / key of Laptop will be three (3) in the list

		// check if the ArrayList of Laptops is empty or null
		if (this.checkAvailableStock(3) <= 0) {

			LaptopData.checkIfListIsNullOrEmpty();
			LaptopData.getArrayListOfLaptops().add(aLaptop);
			this.findAllDevicesMappedToTheirIndicesInAList().put(3, LaptopData.getArrayListOfLaptops());

		}

		else {		// update the ArrayList holding Laptops in the Map

			this.findAllDevicesMappedToTheirIndicesInAList().get(3).add(aLaptop);

		}

		return aLaptop;
	}

}
