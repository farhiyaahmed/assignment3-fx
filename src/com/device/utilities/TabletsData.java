package com.device.utilities;

import java.util.ArrayList;
import java.util.Scanner;

import com.device.model.Device;
import com.device.model.Tablet;
import com.device.repository.RepositoryImplementation;

public class TabletsData extends RepositoryImplementation {

	private static ArrayList<Device> arrayListOfTablets;

	public static ArrayList<Device> getArrayListOfTablets() {
		return arrayListOfTablets;
	}

	public static void setArrayListOfTablets(ArrayList<Device> arrayListOfTablets) {
		TabletsData.arrayListOfTablets = arrayListOfTablets;
	}

	private static void checkIfListIsNullOrEmpty() {

		if (TabletsData.getArrayListOfTablets() == null || TabletsData.getArrayListOfTablets().isEmpty()) {
			ArrayList<Device> tablets = new ArrayList<>();
			TabletsData.setArrayListOfTablets(tablets);
		}

	}

	@Override
	public Device addAnItemToStock() {

		Tablet aTablet = new Tablet();

		Scanner scanner = HandleUserInputs.getScanner();

		System.out.println("Add new \"tablet\"");

		aTablet.setId(HandleUserInputs.getId());

		System.out.println("Enter tablet name");
		aTablet.setName(scanner.nextLine());

		System.out.println("Enter tablet camera strength");
		aTablet.setCameraStrength(scanner.nextDouble());

		System.out.println("Enter tablet type");
		aTablet.setType(scanner.next());

		// index / key of tablets will be zero in the list

		// check if the ArrayList of Tablets is empty or null
		if (this.checkAvailableStock(0) <= 0) {

			TabletsData.checkIfListIsNullOrEmpty();
			TabletsData.getArrayListOfTablets().add(aTablet);
			this.findAllDevicesMappedToTheirIndicesInAList().put(0, TabletsData.getArrayListOfTablets());

		}

		else { // update the ArrayList holding Tablets in the Map

			this.findAllDevicesMappedToTheirIndicesInAList().get(0).add(aTablet);

		}

		return aTablet;

	}

}


