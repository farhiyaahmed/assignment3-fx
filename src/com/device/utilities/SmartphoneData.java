package com.device.utilities;

import java.util.ArrayList;
import java.util.Scanner;

import com.device.model.Device;
import com.device.model.Smartphone;
import com.device.repository.RepositoryImplementation;

public class SmartphoneData extends RepositoryImplementation {

	private static ArrayList<Device> arrayListOfSmartphones;

	public static ArrayList<Device> getArrayListOfSmartphones() {
		return arrayListOfSmartphones;
	}

	public static void setArrayListOfSmartphones(ArrayList<Device> arrayListOfSmartphones) {
		SmartphoneData.arrayListOfSmartphones = arrayListOfSmartphones;
	}

	private static void checkIfListIsNullOrEmpty() {

		if (SmartphoneData.getArrayListOfSmartphones() == null || SmartphoneData.getArrayListOfSmartphones().isEmpty()) {
			ArrayList<Device> tablets = new ArrayList<>();
			SmartphoneData.setArrayListOfSmartphones(tablets);
		}

	}

	@Override
	public Device addAnItemToStock() {

		Smartphone aSmartphone = new Smartphone();

		Scanner scanner = HandleUserInputs.getScanner();

		System.out.println("Add new \"smartphone\"");

		
		aSmartphone.setId(HandleUserInputs.getId());

		System.out.println("Enter smartphone name");
		aSmartphone.setName(scanner.nextLine());

		System.out.println("Enter smartphonecamera strength");
		aSmartphone.setCameraStrength(scanner.nextDouble());

		System.out.println("Enter smartphone type");
		aSmartphone.setType(scanner.next());

		// index / key of smart phones will be one (1) in the list

		// check if the ArrayList of Samrtphones is empty or null
		if (this.checkAvailableStock(1) <= 0) {

			SmartphoneData.checkIfListIsNullOrEmpty();
			SmartphoneData.getArrayListOfSmartphones().add(aSmartphone);
			this.findAllDevicesMappedToTheirIndicesInAList().put(1, SmartphoneData.getArrayListOfSmartphones());

		}

		else {		// update the ArrayList holding Smartphones in the Map

			this.findAllDevicesMappedToTheirIndicesInAList().get(1).add(aSmartphone);

		}

		return aSmartphone;
	}



}
