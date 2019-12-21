/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.device.gui;

import com.device.gui.add.desktop.AddDesktopPopup;
import com.device.gui.add.desktop.AddDesktopUI;
import com.device.model.Desktop;
import com.device.model.Laptop;
import com.device.model.Smartphone;
import com.device.model.Tablet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author farhi
 */
public class Devices extends BorderPane {
   
    private HBox deviceNames;
    private ComboBox<String> comboxDeviceNames;
    
    private void deviceNamesInList(ComboBox<String> comboBoxNames){
        
        ObservableList<String> devices = FXCollections.observableArrayList();
        devices.add(Tablet.class.getSimpleName());
        devices.add(Smartphone.class.getSimpleName());
        devices.add(Desktop.class.getSimpleName());
        devices.add(Laptop.class.getSimpleName());
        comboBoxNames.setItems(devices);
        
    }
    
    private void buildDevicesUI(){
        
        this.deviceNames = new HBox();
        this.setTop(this.deviceNames);
        
        this.comboxDeviceNames = new ComboBox<>();        
        this.deviceNames.getChildren().add(this.comboxDeviceNames);
        this.deviceNamesInList(this.comboxDeviceNames);

        Button addNewDeviceButton = new Button("Add device");
        this.deviceNames.getChildren().add((addNewDeviceButton));

        addNewDeviceButton.setOnAction(e -> {

            new AddDesktopUI(new AddDesktopPopup(), "add new desktop").showAndWait();

        });

        this.setTop(this.deviceNames);
    
    }

    public Devices() {
        this.buildDevicesUI();
    }
    
    
    
}
