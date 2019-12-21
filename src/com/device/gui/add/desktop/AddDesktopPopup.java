package com.device.gui.add.desktop;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class AddDesktopPopup extends HBox {

    private Label labelName;
    private TextField fieldName;

    private Label labelType;
    private TextField fieldType;

    private Label labelScreenWidth;
    private TextField fieldScreenWidth;

    private GridPane gridPane;

    private void addToGrid(Node node,int col,int row){
        this.gridPane.add(node,col,row);
    }

    public AddDesktopPopup(){

        this.gridPane = new GridPane();
        this.gridPane.setHgap(5);
        this.gridPane.setVgap(5);
        this.gridPane.setPadding(new Insets((5)));

        this.labelName = new Label("Name");
        this.addToGrid(labelName,0,0);
        this.fieldName = new TextField();
        this.addToGrid(fieldName,1,0);

        this.labelType = new Label("Type");
        this.fieldType = new TextField();

        this.labelScreenWidth = new Label("screen width");
        this.fieldScreenWidth = new TextField();

    }

}
