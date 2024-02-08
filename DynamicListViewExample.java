package application;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;

public class DynamicListViewExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Dynamic ListView Example");

        ArrayList<DriverRequestBox> driverRequests = new ArrayList<>();
        driverRequests.add(new DriverRequestBox("John Doe", "HR", "Office A", "Client X", "Client X Dropoff", "City A", "Car"));
        driverRequests.add(new DriverRequestBox("Jane Smith", "Finance", "Office B", "Client Y", "Client Y Dropoff", "City B", "Taxi"));
        driverRequests.add(new DriverRequestBox("Bob Johnson", "IT", "Office C", "Client Z", "Client Z Dropoff", "City C", "Car"));

        ObservableList<DriverRequestBox> dataList = FXCollections.observableArrayList(driverRequests);

        ListView<DriverRequestBox> listView = new ListView<>(dataList);

        // Add a button to each row
        listView.setCellFactory(e -> new ButtonListCell(dataList));

        VBox root = new VBox(listView);
        root.setPadding(new Insets(10));

        primaryStage.setScene(new Scene(root, 300, 200));
        primaryStage.show();
    }

    // Custom ListCell with a button
    private static class ButtonListCell extends javafx.scene.control.ListCell<DriverRequestBox> {
        private final Button processButton = new Button("Process Request");
        private final ObservableList<DriverRequestBox> dataList;

        public ButtonListCell(ObservableList<DriverRequestBox> dataList) {
            this.dataList = dataList;

            processButton.setOnAction(event -> {
                int selectedIndex = getIndex();
                if (selectedIndex >= 0 && selectedIndex < dataList.size()) {
                    openNewStage(dataList.get(selectedIndex));
                    // You may perform any additional actions related to processing the request here
                   // dataList.remove(selectedIndex);
                }
            });
        }

        @Override
        protected void updateItem(DriverRequestBox item, boolean empty) {
            super.updateItem(item, empty);

            if (empty || item == null) {
                setGraphic(null);
            } else {
                setGraphic(processButton);
                setText(item.getName().toString());
            }
        }

        private void openNewStage(DriverRequestBox driverRequestBox) {
            Stage newStage = new Stage();
            newStage.initModality(Modality.APPLICATION_MODAL);
            newStage.setTitle("Details");

            // Add your content to the new stage as needed
            // For demonstration, just show the data in a label
            VBox vBox = new VBox();
            vBox.setPadding(new Insets(10));
            vBox.getChildren().add(new javafx.scene.control.Label("Data: " + driverRequestBox));

            Scene scene = new Scene(vBox, 200, 100);
            newStage.setScene(scene);

            newStage.showAndWait();
        }
    }
}
