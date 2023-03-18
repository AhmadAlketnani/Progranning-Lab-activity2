import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class Activity2 extends Application {


    @Override

    public void start(Stage primaryStage) throws Exception {
        // listview to display the programming languages names

        ListView checkBoxListView = new ListView();
        checkBoxListView.setMaxSize(100, 150);

        // checkbox for programming languages

        CheckBox checkBox1 = new CheckBox("Java"),
                checkBox2 = new CheckBox("C"),
                checkBox3 = new CheckBox("C++"),
                checkBox4 = new CheckBox("C#"),
                checkBox5 = new CheckBox("PHP"),
                checkBox6 = new CheckBox("JS"),
                checkBox7 = new CheckBox("Python");

        // arr for departments names

        String[] departments = {"Computer Science", "Software Development", "IT", "Mobile Computing", "Multimedia"};

        // Gender choose

        Label genderLabel = new Label("Gender: ");

        RadioButton radioButton1 = new RadioButton("Male"),
                radioButton2 = new RadioButton("Female");

        ToggleGroup toggleGroup = new ToggleGroup();

        radioButton1.setToggleGroup(toggleGroup);
        radioButton2.setToggleGroup(toggleGroup);

        // HBox for Gender choose

        HBox genderHbox = new HBox(6, genderLabel, radioButton1, radioButton2);

        // Department choose

        Label comboBoxLabel = new Label("Department: ");

        ComboBox comboBox = new ComboBox();
        comboBox.getItems().addAll(departments);

        // HBox for Department choose

        HBox comboBoxhBox = new HBox(6, comboBoxLabel, comboBox);

        // HBox for gender and epartment

        HBox hBox1 = new HBox(25, genderHbox, comboBoxhBox);
        hBox1.setId("hbox");

        // ObservableList for add Department to listview
        ObservableList<String> observableList = FXCollections.observableArrayList(departments);

        // programming languages area

        Label checkBoxLabel = new Label("Programming languages: ");

        // event when check in checkBox

        MyEvent event = new MyEvent(checkBoxListView);
        checkBox1.setOnAction(event);
        checkBox2.setOnAction(event);
        checkBox3.setOnAction(event);
        checkBox4.setOnAction(event);
        checkBox5.setOnAction(event);
        checkBox6.setOnAction(event);
        checkBox7.setOnAction(event);

        // VBox for all checkBoxes

        VBox checkBoxes = new VBox(1, checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7);

        // HBox for programming languages area

        HBox checkBoxHbox = new HBox(6, checkBoxLabel, checkBoxes, checkBoxListView);
        checkBoxHbox.setId("checkBoxHbox");
        // area for listviews

        // for single selection

        ListView listView1 = new ListView();
        listView1.getItems().addAll(observableList);
        listView1.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
//        listView1.setMaxSize(165, 200);
        listView1.setPrefSize(172,200);

        // for Multiple selection

        ListView listView2 = new ListView();
        listView2.getItems().addAll(observableList);
        listView2.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        listView2.setMaxSize(172, 200);

        // HBox for listview area
        HBox hBox2 = new HBox(20, listView1, listView2);
        hBox2.setId("hbox");

        // Age area

        Label age = new Label("age: ");

        Slider slider = new Slider(15.0, 65.0, 25.0);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit(10.0);
        slider.setBlockIncrement(5.0);

        //Vbox for age area

        VBox ageSlider = new VBox(5, age, slider);
        ageSlider.setId("ageSlider");

        //textArea for display changes
        TextArea textArea = new TextArea("Ahmad_Alketnani  120200317");
        textArea.setEditable(false);
        textArea.setMaxHeight(80.0);

        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            textArea.setText("oldValue: " + oldValue + "\nnewValue: " + newValue);
        });

        //  menu bar area

        MenuBar menuBar = new MenuBar();

        Menu fileMenu = new Menu("File");

        MenuItem open = new MenuItem("Open");
        open.setOnAction(e->{
            FileChooser fileChooser = new FileChooser();
            File file=fileChooser.showOpenDialog(primaryStage);
            String filePath = file.getPath();
            String fileName = file.getName();
            textArea.setText("filePath: " + filePath + "\nFileName: " + fileName);
        });

        MenuItem save = new MenuItem("Save");

        SeparatorMenuItem separatorFile = new SeparatorMenuItem();

        Menu subMenu = new Menu("Sub Menu");

        MenuItem item1 = new MenuItem("Item 1");
        MenuItem item2 = new MenuItem("Item 2");

        subMenu.getItems().addAll(item1, item2);

        fileMenu.getItems().addAll(open, save, separatorFile, subMenu);

        Menu editMenu = new Menu("Edit");

        CheckMenuItem item1Edit = new CheckMenuItem("Item 1");
        CheckMenuItem item2Edit = new CheckMenuItem("Item 2");

        SeparatorMenuItem separatorEdit = new SeparatorMenuItem();

        ToggleGroup toggleGroup1 = new ToggleGroup();

        RadioMenuItem radioItem1Edit = new RadioMenuItem("Radio Item 1");
        RadioMenuItem radioItem2Edit = new RadioMenuItem("Radio Item 2");
        RadioMenuItem radioItem3Edit = new RadioMenuItem("Radio Item 3");

        radioItem1Edit.setToggleGroup(toggleGroup1);
        radioItem2Edit.setToggleGroup(toggleGroup1);
        radioItem3Edit.setToggleGroup(toggleGroup1);

        editMenu.getItems().addAll(item1Edit, item2Edit, separatorEdit, radioItem1Edit, radioItem2Edit, radioItem3Edit);

        menuBar.getMenus().addAll(fileMenu, editMenu);


        VBox allControls= new VBox(10,hBox1,checkBoxHbox,hBox2,ageSlider,textArea);

        BorderPane root= new BorderPane();
        root.setTop(menuBar);
        root.setCenter(allControls);

        Scene scene = new Scene(root, 550, 700);
        scene.getStylesheets().add(getClass().getResource("myStyle.css").toExternalForm());
        primaryStage.setTitle("Activity 2");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}