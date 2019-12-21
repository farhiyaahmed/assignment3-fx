package com.device.utilities;

import java.util.ArrayList;
import java.util.Scanner;

import com.device.model.Desktop;
import com.device.model.Device;
import com.device.repository.RepositoryImplementation;

public class DesktopData extends RepositoryImplementation {

	private static ArrayList<Device> arrayListOfDesktops;

	public static ArrayList<Device> getArrayListOfDesktops() {
		return arrayListOfDesktops;
	}

	public static void setArrayListOfDesktops(ArrayList<Device> arrayListOfDesktops) {
		DesktopData.arrayListOfDesktops = arrayListOfDesktops;
	}

	private static void checkIfListIsNullOrEmpty() {

		if (DesktopData.getArrayListOfDesktops() == null || DesktopData.getArrayListOfDesktops().isEmpty()) {
			ArrayList<Device> tablets = new ArrayList<>();
			DesktopData.setArrayListOfDesktops(tablets);
		}

	}

	@Override
	public Device addAnItemToStock() {

		Desktop aDesktop = new Desktop();

		Scanner scanner = HandleUserInputs.getScanner();

		System.out.println("Add new \"desktop\"");

		aDesktop.setId(HandleUserInputs.getId());

		System.out.println("Enter desktop name: ");
		aDesktop.setName(scanner.nextLine());

		System.out.println("Enter desktop type: ");
		aDesktop.setType(scanner.nextLine());

		System.out.println("Enter screen width: ");
		aDesktop.setScreenWidth(scanner.next());

		// index / key of Desktop will be two (2) in the list

		// check if the ArrayList of Desktops is empty or null
		if (this.checkAvailableStock(2) <= 0) {

			DesktopData.checkIfListIsNullOrEmpty();
			DesktopData.getArrayListOfDesktops().add(aDesktop);
			this.findAllDevicesMappedToTheirIndicesInAList().put(2, DesktopData.getArrayListOfDesktops());

		}

		else {		// update the ArrayList holding Desktops in the Map

			this.findAllDevicesMappedToTheirIndicesInAList().get(2).add(aDesktop);

		}

		return aDesktop;
	}



}
