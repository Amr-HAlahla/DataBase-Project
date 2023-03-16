package com.example.demo2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;

public class HelloApplication extends Application {
    static Connection connection;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        String host = "localhost";
        String port = "3306";
        String dbName = "my_db";
        String username = "root";
        String password = "Host$452002";

        // Construct the JDBC URL
        String jdbcUrl = "jdbc:mysql://" + host + ":" + port + "/" + dbName;

        try {
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            initial(primaryStage);
            // add event handlers to buttons
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void initial(Stage primaryStage) {
        Button adminButton = new Button("SYSTEM ADMINISTRATION");
        adminButton.setStyle("-fx-background-color: #FFF0F5");
        adminButton.setPrefSize(400, 50);
        ImageView adminView = new ImageView(new Image("https://img.icons8.com/clouds/256/apple-settings--v2.png"));
        adminView.setFitHeight(50);
        adminView.setFitWidth(50);
        adminButton.setGraphic(adminView);
        adminButton.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        adminButton.setOnAction(event -> adminScene(primaryStage));

        Button usersButton = new Button("SYSTEM INFORMATION");
        usersButton.setStyle("-fx-background-color: #FFF0F5");
        usersButton.setPrefSize(400, 50);
        ImageView userView = new ImageView(new Image("https://img.icons8.com/external-itim2101-flat-itim2101/1x/external-admin-computer-and-laptop-itim2101-flat-itim2101.png"));
        userView.setFitHeight(50);
        userView.setFitWidth(50);
        usersButton.setGraphic(userView);
        usersButton.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        usersButton.setOnAction(e -> usersScene(primaryStage));

        Button exitBtn = new Button();
        exitBtn.setStyle("-fx-background-color: #FFF0F5");
        exitBtn.setPrefSize(400, 50);
        ImageView exitView = new ImageView(new Image("https://img.icons8.com/external-inipagistudio-lineal-color-inipagistudio/256/external-exit-theatre-show-inipagistudio-lineal-color-inipagistudio.png"));
        exitView.setFitHeight(50);
        exitView.setFitWidth(50);
        exitBtn.setGraphic(exitView);
        exitBtn.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));
        exitBtn.setOnAction(e -> primaryStage.close());

        VBox mainMenuLayout = new VBox(20);
        mainMenuLayout.setPadding(new Insets(20));
        mainMenuLayout.getChildren().add(adminButton);
        mainMenuLayout.getChildren().add(usersButton);
        mainMenuLayout.getChildren().add(exitBtn);
        mainMenuLayout.setPadding(new Insets(0, 300, 85, 0));
//        mainMenuLayout.getChildren().add(backgroundImg);
        mainMenuLayout.setAlignment(Pos.BOTTOM_RIGHT);
        Scene mainMenuScene = new Scene(mainMenuLayout, 1600, 900);
        mainMenuLayout.setBackground(new Background(
                new BackgroundImage(
                        new Image("C:\\Users\\amro7\\IdeaProjects\\demo2\\src\\images\\train2.jpg"),
                        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
                        new BackgroundPosition(Side.LEFT, 0, false, Side.BOTTOM, 0, false),
                        new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, true, true)
                )));

        primaryStage.setTitle("Main Menu");
        primaryStage.setScene(mainMenuScene);
        primaryStage.show();
    }

    private static void usersScene(Stage primaryStage) {

        Button displayInfoBtn = new Button("Display Information");
        displayInfoBtn.setPrefSize(300, 40);
        ImageView displayView = new ImageView(new Image("https://img.icons8.com/bubbles/1x/monitor.png"));
        displayView.setFitWidth(50);
        displayView.setFitHeight(50);
        displayInfoBtn.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        displayInfoBtn.setStyle("-fx-background-color: #3CB371");
        displayInfoBtn.setGraphic(displayView);
        displayInfoBtn.setAlignment(Pos.CENTER);

        Button searchForTrainBtn = new Button("Search For Train");
        searchForTrainBtn.setPrefSize(300, 40);
        ImageView searchView = new ImageView(new Image("https://img.icons8.com/clouds/1x/search.png"));
        searchView.setFitWidth(50);
        searchView.setFitHeight(50);
        searchForTrainBtn.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        searchForTrainBtn.setStyle("-fx-background-color: #3CB371");
        searchForTrainBtn.setGraphic(searchView);
        searchForTrainBtn.setAlignment(Pos.CENTER);

        Button viewAvailableSeatsBtn = new Button("View Available Seats");
        viewAvailableSeatsBtn.setPrefSize(300, 40);
        ImageView seatView = new ImageView(new Image("https://img.icons8.com/clouds/256/seat-heater.png"));
        seatView.setFitWidth(50);
        seatView.setFitHeight(50);
        viewAvailableSeatsBtn.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        viewAvailableSeatsBtn.setStyle("-fx-background-color: #3CB371");
        viewAvailableSeatsBtn.setGraphic(seatView);
        viewAvailableSeatsBtn.setAlignment(Pos.CENTER);

        Button costBtn = new Button("Train Cost");
        costBtn.setPrefSize(300, 40);
        ImageView costView = new ImageView(new Image("https://img.icons8.com/external-soft-fill-juicy-fish/1x/external-cost-business-management-soft-fill-soft-fill-juicy-fish.png"));
        costView.setFitWidth(50);
        costView.setFitHeight(50);
        costBtn.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        costBtn.setStyle("-fx-background-color: #3CB371");
        costBtn.setGraphic(costView);
        costBtn.setAlignment(Pos.CENTER);

        Button resStat = new Button("View Reservation Statistics");
        resStat.setPrefSize(300, 40);
        ImageView resView = new ImageView(new Image("https://img.icons8.com/clouds/1x/line-chart.png"));
        resView.setFitWidth(50);
        resView.setFitHeight(50);
        resStat.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        resStat.setStyle("-fx-background-color: #3CB371");
        resStat.setGraphic(resView);
        resStat.setAlignment(Pos.CENTER);

        Button searchTrain = new Button("View Trains By Location");
        searchTrain.setPrefSize(300, 40);
        ImageView trainView = new ImageView(new Image("https://img.icons8.com/clouds/1x/train.png"));
        trainView.setFitWidth(50);
        trainView.setFitHeight(50);
        searchTrain.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        searchTrain.setStyle("-fx-background-color: #3CB371");
        searchTrain.setGraphic(trainView);
        searchTrain.setAlignment(Pos.CENTER);

        Button detailedStatistics = new Button("View Detailed Statistics");
        detailedStatistics.setPrefSize(300, 40);
        ImageView statView = new ImageView(new Image("https://img.icons8.com/clouds/1x/line-chart.png"));
        statView.setFitWidth(50);
        statView.setFitHeight(50);
        detailedStatistics.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        detailedStatistics.setStyle("-fx-background-color: #3CB371");
        detailedStatistics.setGraphic(statView);
        detailedStatistics.setAlignment(Pos.CENTER);

        Button backButton = new Button("BACK");
        backButton.setPrefSize(300, 40);
        ImageView backView = new ImageView(new Image("https://img.icons8.com/clouds/1x/reply-arrow.png"));
        backView.setFitWidth(50);
        backView.setFitHeight(50);
        backButton.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        backButton.setStyle("-fx-background-color: #3CB371");
        backButton.setGraphic(backView);
        backButton.setAlignment(Pos.CENTER);

        displayInfoBtn.setOnAction(e -> viewInfoScene(primaryStage));
        searchForTrainBtn.setOnAction(e -> searchForTrainScene(primaryStage));
        viewAvailableSeatsBtn.setOnAction(e -> viewAvailableSeatsScene(primaryStage));
        costBtn.setOnAction(e -> viewCostScene(primaryStage));
        resStat.setOnAction(e -> viewReservationStatistics(primaryStage));
        searchTrain.setOnAction(e -> viewTrains(primaryStage));
        detailedStatistics.setOnAction(e -> detailedStatistics(primaryStage));
        backButton.setOnAction(event -> initial(primaryStage));

        GridPane pane = new GridPane();
        pane.setVgap(15);
        pane.setHgap(20);
        pane.add(displayInfoBtn, 0, 0);
        pane.add(viewAvailableSeatsBtn, 1, 0);
        pane.add(searchForTrainBtn, 0, 1);
        pane.add(costBtn, 1, 1);
        pane.add(detailedStatistics, 0, 2);
        pane.add(resStat, 1, 2);
        pane.add(searchTrain, 0, 3);
        pane.add(backButton, 1, 3);
        Scene userScene = new Scene(pane, 1600, 900);
        pane.setAlignment(Pos.CENTER);
//        vBox.setSpacing(15);
        pane.setStyle("-fx-background-color: #ADD8E6");
        primaryStage.setTitle("User");
        primaryStage.setScene(userScene);
        primaryStage.show();
    }

    private static void detailedStatistics(Stage primaryStage) {

        TextArea resultArea = new TextArea();
        resultArea.setEditable(false);
        resultArea.setMaxWidth(600);
        resultArea.setMinHeight(400);
        resultArea.setStyle("-fx-font: 12pt \"IMPACT\";");

        Label title = new Label("DETAILED INFO ABOUT RESERVATIONS");
        title.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        title.setStyle("-fx-background-color: #FA8072;");
        Label errorLabel = new Label();
        errorLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        errorLabel.setStyle("-fx-background-color: #FA8072;");

        Button backBtn = new Button("Back");
        ImageView backView = new ImageView(new Image("https://img.icons8.com/clouds/1x/reply-arrow.png"));
        backView.setFitWidth(50);
        backView.setFitHeight(50);
        backBtn.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        backView.setStyle("-fx-background-color: #3CB371");
        backBtn.setGraphic(backView);

        String sql = "SELECT ht.train_id, ht.source_location, ht.destination_location, COUNT(r.ticket_id) as reservations, SUM(ht.cost) as total_cost " +
                "FROM reserve r JOIN has_trains ht ON r.train_id = ht.train_id " +
                "GROUP BY ht.train_id, ht.source_location, ht.destination_location";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (!rs.next()) {
                resultArea.setText("No detailed reservation statistics found.");
            }
            do {
                int trainId = rs.getInt("train_id");
                String sourceLocation = rs.getString("source_location");
                String destinationLocation = rs.getString("destination_location");
                int reservations = rs.getInt("reservations");
                float totalCost = rs.getFloat("total_cost");
                resultArea.appendText("Train ID: " + trainId + "\n");
                resultArea.appendText("Source Location: " + sourceLocation + "\n");
                resultArea.appendText("Destination Location: " + destinationLocation + "\n");
                resultArea.appendText("Reservations: " + reservations + "\n");
                resultArea.appendText("Total Cost: " + totalCost + "\n");
                resultArea.appendText("===================================+=====================================\n");
            } while (rs.next());
        } catch (SQLException e) {
            errorLabel.setText("Error viewing detailed reservation statistics: " + e.getMessage());
        }
        backBtn.setOnAction(e -> usersScene(primaryStage));

        VBox vBox = new VBox(20);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(title, resultArea, errorLabel, backBtn);
        vBox.setStyle("-fx-background-color: #ADD8E6");
        Scene scene = new Scene(vBox, 1600, 900);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private static void viewTrains(Stage primaryStage) {
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(25, 25, 25, 25));

        Label stationLocationLabel = new Label("Station Location:");
        stationLocationLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        stationLocationLabel.setStyle("-fx-background-color: #3CB371;");
        TextField stationLocationField = new TextField();
        stationLocationField.setMaxWidth(300);

        Button viewTrainsButton = new Button("VIEW TRAINS");
        Button backBtn = new Button("BACK");
        Button viewStation = new Button("View Stations");

        ImageView viewTrain = new ImageView(new Image("https://img.icons8.com/clouds/1x/train.png"));
        viewTrain.setFitWidth(50);
        viewTrain.setFitHeight(50);
        viewTrainsButton.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        viewTrain.setStyle("-fx-background-color: #3CB371");
        viewTrainsButton.setGraphic(viewTrain);

        ImageView showView = new ImageView(new Image("https://img.icons8.com/bubbles/256/monitor.png"));
        showView.setFitWidth(50);
        showView.setFitHeight(50);
        viewStation.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        showView.setStyle("-fx-background-color: #3CB371");
        viewStation.setGraphic(showView);

        ImageView backView = new ImageView(new Image("https://img.icons8.com/clouds/1x/reply-arrow.png"));
        backView.setFitWidth(50);
        backView.setFitHeight(50);
        backBtn.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        backView.setStyle("-fx-background-color: #3CB371");
        backBtn.setGraphic(backView);


        Label trainsLabel = new Label();
        trainsLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        trainsLabel.setStyle("-fx-background-color: #3CB371;");
        Label errorLabel = new Label();
        errorLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        errorLabel.setStyle("-fx-background-color: #3CB371;");

        TextArea textArea = new TextArea();
        textArea.setEditable(false);
        textArea.setMaxWidth(600);

        // Add UI components to the root pane
        root.add(stationLocationLabel, 0, 0);
        root.add(stationLocationField, 1, 0);
        HBox hBox = new HBox(15);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(viewStation, viewTrainsButton, backBtn);

        backBtn.setOnAction(e -> usersScene(primaryStage));
        viewTrainsButton.setOnAction(e -> {
            textArea.clear();
            errorLabel.setText("");
            String sql = "SELECT * FROM " +
                    "has_trains, station " +
                    "WHERE has_trains.station_id = station.station_id " +
                    "AND station.location = ?";

            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, stationLocationField.getText());
                ResultSet rs = stmt.executeQuery();
                if (!rs.next()) {
                    errorLabel.setText("No trains found at station with location " + stationLocationField.getText());
                    return;
                }
                trainsLabel.setText("Trains:");
                textArea.setText("The Set Of Trains Exists In The Station At Location " + stationLocationField.getText() + ":");
                do {
                    int train_id = rs.getInt("train_id");
                    int capacity = rs.getInt("capacity");
                    double cost = rs.getDouble("cost");
                    Date leave_time = rs.getDate("leave_time");
                    String source_location = rs.getString("source_location");
                    String destination_location = rs.getString("destination_location");
                    textArea.appendText("\nTrain ID: " + train_id + ", Capacity: " + capacity + ", Cost: " + cost + ", Leave Time: " + leave_time + ", Source Location: " + source_location + ", Destination Location: " + destination_location);
                } while (rs.next());
            } catch (SQLException exception) {
                errorLabel.setText(exception.getMessage());
            }
        });
        viewStation.setOnAction(e -> {
            errorLabel.setText("");
            String q = "select * from station";
            try (PreparedStatement stmt = connection.prepareStatement(q)) {
                ResultSet rs = stmt.executeQuery();
                textArea.setText("Stations Recorded :");
                while (rs.next()) {
                    textArea.appendText("\nStation ID: " + rs.getInt("station_id"));
                    textArea.appendText("\nName: " + rs.getString("name"));
                    textArea.appendText("\nLocation: " + rs.getString("location"));
                }
            } catch (SQLException exception) {
                errorLabel.setText(exception.getMessage());
            }
        });

        VBox vBox = new VBox(15);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(root, errorLabel, trainsLabel, textArea, hBox);
        vBox.setStyle("-fx-background-color: #ADD8E6");
        Scene scene = new Scene(vBox, 1600, 900);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    private static void viewReservationStatistics(Stage primaryStage) {
        Label totalReservationsLabel = new Label("Total Reservations:");
        totalReservationsLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        totalReservationsLabel.setStyle("-fx-background-color: #3CB371;");
        TextField totalReservationsField = new TextField();
        totalReservationsField.setEditable(false);
        totalReservationsField.setMaxWidth(300);

        Label totalCostLabel = new Label("Total Cost:");
        totalCostLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        totalCostLabel.setStyle("-fx-background-color: #3CB371;");
        TextField totalCostField = new TextField();
        totalCostField.setEditable(false);
        totalCostField.setMaxWidth(300);

        Button calculate = new Button("CALCULATE");
        Button backBtn = new Button("BACK");

        ImageView showView = new ImageView(new Image("https://img.icons8.com/external-flaticons-lineal-color-flat-icons/1x/external-tax-calculate-human-resources-flaticons-lineal-color-flat-icons-2.png"));
        showView.setFitWidth(50);
        showView.setFitHeight(50);
        calculate.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        showView.setStyle("-fx-background-color: #3CB371");
        calculate.setGraphic(showView);

        ImageView backView = new ImageView(new Image("https://img.icons8.com/clouds/1x/reply-arrow.png"));
        backView.setFitWidth(50);
        backView.setFitHeight(50);
        backBtn.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        backView.setStyle("-fx-background-color: #3CB371");
        backBtn.setGraphic(backView);

        HBox hBox = new HBox(15);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(calculate, backBtn);

        TextArea textArea = new TextArea();
        textArea.setMaxWidth(600);
        textArea.setMinHeight(400);

        Label errorLabel = new Label();
        errorLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        errorLabel.setStyle("-fx-background-color: #FA8072;");

        VBox root = new VBox();
        root.setSpacing(15);
        root.getChildren().addAll(totalReservationsLabel, totalReservationsField,
                totalCostLabel, totalCostField, hBox, errorLabel);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #ADD8E6");
        backBtn.setOnAction(e -> usersScene(primaryStage));
        calculate.setOnAction(e -> {
            String sql = "SELECT COUNT(*) as total_reservations, SUM(cost) as total_cost " +
                    "FROM reserve r JOIN tickets_for t ON r.ticket_id = t.ticket_id JOIN has_trains ht ON r.train_id = ht.train_id";
            try (Statement stmt = connection.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {
                if (rs.next()) {
                    int totalReservations = rs.getInt("total_reservations");
                    float totalCost = rs.getFloat("total_cost");
                    totalReservationsField.setText(String.valueOf(totalReservations));
                    totalCostField.setText(String.valueOf(totalCost));
                } else {
                    errorLabel.setText("No reservation statistics found.");
                }
            } catch (SQLException exception) {
                errorLabel.setText("Error viewing reservation statistics: " + exception.getMessage());
            }
        });
        Scene scene = new Scene(root, 1600, 900);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    private static void viewCostScene(Stage primaryStage) {
        Label trainIDLabel = new Label("Train ID: ");
        trainIDLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        trainIDLabel.setStyle("-fx-background-color: #3CB371;");
        TextField trainIDTextField = new TextField();
        trainIDTextField.setMaxWidth(300);
        Label resultLabel = new Label();
        resultLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        resultLabel.setStyle("-fx-background-color: #3CB371;");

        Button submitButton = new Button("VIEW");
        Button backButton = new Button("BACK");

        ImageView showView = new ImageView(new Image("https://img.icons8.com/bubbles/256/monitor.png"));
        showView.setFitWidth(50);
        showView.setFitHeight(50);
        submitButton.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        showView.setStyle("-fx-background-color: #3CB371");
        submitButton.setGraphic(showView);

        ImageView backView = new ImageView(new Image("https://img.icons8.com/clouds/1x/reply-arrow.png"));
        backView.setFitWidth(50);
        backView.setFitHeight(50);
        backButton.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        backView.setStyle("-fx-background-color: #3CB371");
        backButton.setGraphic(backView);

        HBox hBox = new HBox(15);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(submitButton, backButton);

        TextArea textArea = new TextArea();
        textArea.setMaxWidth(600);


        submitButton.setOnAction(event -> {
            int train_id;
            try {
                train_id = Integer.parseInt(trainIDTextField.getText());
            } catch (NumberFormatException e) {
                resultLabel.setText("Invalid input. Please enter a valid train ID.");
                return;
            }
            String query = "SELECT cost FROM has_trains WHERE train_id = ?";
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setInt(1, train_id);
                ResultSet rs = stmt.executeQuery();
                if (!rs.next()) {
                    resultLabel.setText("Error: train with ID " + train_id + " not found.");
                } else {
                    resultLabel.setText("Cost of ticket for train ID " + train_id + " : " + rs.getFloat("cost"));
                }
            } catch (SQLException e) {
                resultLabel.setText("Error: " + e.getMessage());
            }
        });

        backButton.setOnAction(e -> usersScene(primaryStage));

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        gridPane.add(trainIDLabel, 0, 0);
        gridPane.add(trainIDTextField, 1, 0);
        VBox vBox = new VBox(15);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(gridPane, resultLabel, hBox);
        vBox.setStyle("-fx-background-color: #ADD8E6");
        Scene scene = new Scene(vBox, 1600, 900);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void viewAvailableSeatsScene(Stage primaryStage) {
        Label trainIdLabel = new Label("Train ID");
        trainIdLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        trainIdLabel.setStyle("-fx-background-color: #3CB371;");
        TextField trainIdField = new TextField();
        trainIdField.setMaxWidth(300);
        Label availableSeatsLabel = new Label();
        availableSeatsLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        availableSeatsLabel.setStyle("-fx-background-color: #3CB371;");

        Button viewBtn = new Button("SHOW");
        Button backBtn = new Button("BACK");

        ImageView showView = new ImageView(new Image("https://img.icons8.com/bubbles/256/monitor.png"));
        showView.setFitWidth(50);
        showView.setFitHeight(50);
        viewBtn.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        showView.setStyle("-fx-background-color: #3CB371");
        viewBtn.setGraphic(showView);

        ImageView backView = new ImageView(new Image("https://img.icons8.com/clouds/1x/reply-arrow.png"));
        backView.setFitWidth(50);
        backView.setFitHeight(50);
        backBtn.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        backView.setStyle("-fx-background-color: #3CB371");
        backBtn.setGraphic(backView);

        HBox hBox = new HBox(15);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(viewBtn, backBtn);

        TextArea textArea = new TextArea();
        textArea.setMaxWidth(600);

        viewBtn.setOnAction(e -> {
            if (trainIdField.getText().isEmpty()) {
                availableSeatsLabel.setText("Train ID is required!");
            } else {
                try {
                    int train_id = Integer.parseInt(trainIdField.getText());
                    String sql = "select * from has_trains where train_id = ?";
                    try (PreparedStatement statement = connection.prepareStatement(sql)) {
                        statement.setInt(1, train_id);
                        ResultSet rs = statement.executeQuery();
                        if (rs.next()) {
                            String query = "SELECT has_trains.capacity - COUNT(*) as available_seats " +
                                    "FROM has_trains, reserve " +
                                    "WHERE has_trains.train_id = reserve.train_id AND has_trains.train_id = ? " +
                                    "GROUP BY has_trains.train_id";

                            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                                stmt.setInt(1, train_id);
                                ResultSet rs2 = stmt.executeQuery();
                                if (!rs2.next()) {
                                    availableSeatsLabel.setText("Train ID: " + train_id + "\nAvailable seats: " + rs.getInt("capacity"));
                                } else {
                                    int available_seats = rs2.getInt("available_seats");
                                    availableSeatsLabel.setText("Train ID: " + train_id + "\nAvailable seats: " + available_seats);
                                }
                            }
                        } else {
                            availableSeatsLabel.setText("Train Not Found!");
                        }
                    }

                } catch (NumberFormatException | SQLException exception) {
                    availableSeatsLabel.setText(exception.getMessage());
                }
            }
            trainIdField.clear();
        });
        backBtn.setOnAction(e -> usersScene(primaryStage));

        HBox hbox = new HBox(10);
        hbox.setPadding(new Insets(10, 10, 10, 10));
        hbox.getChildren().addAll(trainIdLabel, trainIdField);
        hbox.setAlignment(Pos.CENTER);

        VBox vbox = new VBox(15);
        vbox.setPadding(new Insets(10, 10, 10, 10));
        vbox.getChildren().addAll(hbox, hBox, availableSeatsLabel);
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-background-color: #ADD8E6");

        Scene scene = new Scene(vbox, 1600, 900);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void searchForTrainScene(Stage primaryStage) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Label departureTimeLabel = new Label("Enter departure time (yyyy-mm-dd hh:mm:ss):");
        departureTimeLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        departureTimeLabel.setStyle("-fx-background-color: #3CB371;");
        TextField departureTimeField = new TextField();
        departureTimeField.setMaxWidth(300);

        Label sourceLocationLabel = new Label("Enter source location:");
        sourceLocationLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        sourceLocationLabel.setStyle("-fx-background-color: #3CB371;");
        TextField sourceLocationField = new TextField();
        sourceLocationField.setMaxWidth(300);

        Label destinationLocationLabel = new Label("Enter destination location:");
        destinationLocationLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        destinationLocationLabel.setStyle("-fx-background-color: #3CB371;");
        TextField destinationLocationField = new TextField();
        destinationLocationField.setMaxWidth(300);

        Button search = new Button("SEARCH");
        Button backBtn = new Button("BACK");

        ImageView searchView = new ImageView(new Image("https://img.icons8.com/clouds/1x/search.png"));
        searchView.setFitWidth(50);
        searchView.setFitHeight(50);
        search.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        searchView.setStyle("-fx-background-color: #3CB371");
        search.setGraphic(searchView);

        ImageView backView = new ImageView(new Image("https://img.icons8.com/clouds/1x/reply-arrow.png"));
        backView.setFitWidth(50);
        backView.setFitHeight(50);
        backBtn.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        backView.setStyle("-fx-background-color: #3CB371");
        backBtn.setGraphic(backView);

        HBox hBox = new HBox(15);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(search, backBtn);

        TextArea resultsTextArea = new TextArea();
        resultsTextArea.setMaxWidth(600);
        resultsTextArea.setEditable(false);

        search.setOnAction(event -> {
            try {
                java.util.Date departureTime = dateFormat.parse(departureTimeField.getText());
                java.sql.Timestamp departureTimestamp = new java.sql.Timestamp(departureTime.getTime());
                String sourceLocation = sourceLocationField.getText();
                String destinationLocation = destinationLocationField.getText();
                String query = "SELECT has_trains.train_id, has_trains.leave_time, has_trains.capacity, station.name " +
                        "FROM has_trains JOIN station ON has_trains.station_id = station.station_id " +
                        "WHERE has_trains.leave_time >= ? " +
                        "AND has_trains.source_location = ? " +
                        "AND has_trains.destination_location = ?";
                PreparedStatement stmt = connection.prepareStatement(query);
                stmt.setTimestamp(1, departureTimestamp);
                stmt.setString(2, sourceLocation);
                stmt.setString(3, destinationLocation);
                ResultSet rs = stmt.executeQuery();
                StringBuilder results = new StringBuilder();
                while (rs.next()) {
                    results.append("Train ID: ").append(rs.getInt("train_id")).append(" | Departure Time: ").append(rs.getString("leave_time")).append(" | Capacity: ").append(rs.getInt("capacity")).append(" | Station Name: ").append(rs.getString("name")).append("\n");
                }
                resultsTextArea.setText(results.toString());
            } catch (SQLException e) {
                resultsTextArea.setText(e.getMessage());
            } catch (ParseException e) {
                resultsTextArea.setText("Invalid date format. Please enter the date in yyyy-mm-dd hh:mm:ss format.");
            }
        });
        backBtn.setOnAction(e -> usersScene(primaryStage));

        VBox root = new VBox(10, departureTimeLabel, departureTimeField, sourceLocationLabel, sourceLocationField,
                destinationLocationLabel, destinationLocationField, hBox, resultsTextArea);
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #ADD8E6");
        Scene scene = new Scene(root, 1600, 900);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private static void viewInfoScene(Stage primaryStage) {
        Label showInfoLabel = new Label("Show Info:");
        showInfoLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        showInfoLabel.setStyle("-fx-background-color: #3CB371;");

        ComboBox<String> infoChoice = new ComboBox<>();
        infoChoice.setPromptText("Choose Option");
        infoChoice.setStyle("-fx-font: 12pt \"Impact\";");
        infoChoice.getItems().addAll("Customer Info", "Station Info", "Reservation Info",
                "Train Info", "Ticket Info");
        infoChoice.setOnAction(e -> {
            String selectedChoice = infoChoice.getValue();
            switch (selectedChoice) {
                case "Customer Info" -> customerInfoScene(primaryStage);
                case "Station Info" -> stationInfoScene(primaryStage);
                case "Reservation Info" -> reservationInfoScene(primaryStage);
                case "Train Info" -> trainInfoScene(primaryStage);
                case "Ticket Info" -> ticketsInfoScene(primaryStage);
            }
        });
        Button backButton = new Button("BACK");
        backButton.setPrefSize(300, 40);
        ImageView backView = new ImageView(new Image("https://img.icons8.com/clouds/1x/reply-arrow.png"));
        backView.setFitWidth(50);
        backView.setFitHeight(50);
        backButton.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        backButton.setStyle("-fx-background-color: #3CB371");
        backButton.setGraphic(backView);
        backButton.setAlignment(Pos.CENTER);
        backButton.setOnAction(e -> usersScene(primaryStage));

        VBox root = new VBox(showInfoLabel, infoChoice, backButton);
        root.setSpacing(20);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #ADD8E6");
        Scene scene = new Scene(root, 1600, 900);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Information Scene");
//        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    private static void trainInfoScene(Stage primaryStage) {
        Label idLabel = new Label("Train ID: ");
        idLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        idLabel.setStyle("-fx-background-color: #3CB371;");
        TextField idField = new TextField();
        idField.setPromptText("Enter Train id, leave it empty to display all.");
        idField.setMaxWidth(300);

        Label errorLabel = new Label();
        errorLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        errorLabel.setStyle("-fx-background-color: #FA8072;");

        Button show = new Button("SHOW");
        Button backButton = new Button("BACK");

        ImageView showView = new ImageView(new Image("https://img.icons8.com/bubbles/256/monitor.png"));
        showView.setFitWidth(50);
        showView.setFitHeight(50);
        show.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        showView.setStyle("-fx-background-color: #3CB371");
        show.setGraphic(showView);

        ImageView backView = new ImageView(new Image("https://img.icons8.com/clouds/1x/reply-arrow.png"));
        backView.setFitWidth(50);
        backView.setFitHeight(50);
        backButton.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        backView.setStyle("-fx-background-color: #3CB371");
        backButton.setGraphic(backView);

        HBox hBox = new HBox(15);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(show, backButton);

        TextArea textArea = new TextArea();
        textArea.setMaxWidth(600);
        textArea.setEditable(false);

        VBox layout = new VBox(20);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(idLabel, idField, hBox, errorLabel, textArea);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #ADD8E6");
        Scene deleteTrainScene = new Scene(layout, 1600, 900);

        show.setOnAction(e -> {
            String id = idField.getText();
            if (id.isEmpty()) {
                try {
                    String query = "SELECT ht.train_id, ht.leave_time, ht.capacity, ht.cost, ht.source_location, ht.destination_location, s.name " +
                            "FROM has_trains ht INNER JOIN station s ON ht.station_id = s.station_id";
                    try (PreparedStatement stmt = connection.prepareStatement(query)) {
                        ResultSet rs = stmt.executeQuery();
                        textArea.setText("Trains Information : ");
                        while (rs.next()) {
                            textArea.appendText("\nTrain ID: " + rs.getInt("train_id"));
                            textArea.appendText("\nLeave Time: " + rs.getTimestamp("leave_time"));
                            textArea.appendText("\nCapacity: " + rs.getInt("capacity"));
                            textArea.appendText("\nCost: " + rs.getInt("cost"));
                            textArea.appendText("\nSource Location: " + rs.getString("source_location"));
                            textArea.appendText("\nDestination Location: " + rs.getString("destination_location"));
                            textArea.appendText("\nStation Name: " + rs.getString("name"));
                            textArea.appendText("\n====================================================================\n");
                        }
                    }
                } catch (SQLException exception) {
                    errorLabel.setText(exception.getMessage());
                }
            } else {
                try {
                    int trainId = Integer.parseInt(id);
                    try {
                        String query = "SELECT ht.train_id, ht.leave_time, ht.capacity, ht.cost, ht.source_location, ht.destination_location, s.name " +
                                "FROM has_trains ht INNER JOIN station s ON ht.station_id = s.station_id WHERE ht.train_id = ?";
                        try (PreparedStatement stmt = connection.prepareStatement(query)) {
                            stmt.setInt(1, trainId);
                            ResultSet rs = stmt.executeQuery();
                            if (!rs.next()) {
                                errorLabel.setText("Error: Train with ID " + trainId + " not found.");
                            } else {
                                textArea.clear();
                                textArea.appendText("\nTrain ID: " + rs.getInt("train_id"));
                                textArea.appendText("\nLeave Time: " + rs.getTimestamp("leave_time"));
                                textArea.appendText("\nCapacity: " + rs.getInt("capacity"));
                                textArea.appendText("\nCost: " + rs.getInt("cost"));
                                textArea.appendText("\nSource Location: " + rs.getString("source_location"));
                                textArea.appendText("\nDestination Location: " + rs.getString("destination_location"));
                                textArea.appendText("\nStation Name: " + rs.getString("name"));
                                textArea.appendText("\n====================================================================\n");
                            }
                        }
                    } catch (SQLException exception) {
                        errorLabel.setText(exception.getMessage());
                    }
                } catch (InputMismatchException exception) {
                    errorLabel.setText("Input ID must be an integer");
                }
            }
        });
        backButton.setOnAction(e -> viewInfoScene(primaryStage));

        primaryStage.setScene(deleteTrainScene);
        primaryStage.setTitle("Display Train");
        primaryStage.show();
    }

    private static void ticketsInfoScene(Stage primaryStage) {
        Label idLabel = new Label("Ticket ID: ");
        idLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        idLabel.setStyle("-fx-background-color: #3CB371;");
        TextField idField = new TextField();
        idField.setPromptText("Enter Ticket id, leave it empty to display all.");
        idField.setMaxWidth(300);

        Label errorLabel = new Label();
        errorLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        errorLabel.setStyle("-fx-background-color: #FA8072;");

        Button show = new Button("SHOW");
        Button backButton = new Button("BACK");

        ImageView showView = new ImageView(new Image("https://img.icons8.com/bubbles/256/monitor.png"));
        showView.setFitWidth(50);
        showView.setFitHeight(50);
        show.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        showView.setStyle("-fx-background-color: #3CB371");
        show.setGraphic(showView);

        ImageView backView = new ImageView(new Image("https://img.icons8.com/clouds/1x/reply-arrow.png"));
        backView.setFitWidth(50);
        backView.setFitHeight(50);
        backButton.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        backView.setStyle("-fx-background-color: #3CB371");
        backButton.setGraphic(backView);

        HBox hBox = new HBox(15);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(show, backButton);

        TextArea textArea = new TextArea();
        textArea.setMaxWidth(600);
        textArea.setEditable(false);

        VBox layout = new VBox(20);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(idLabel, idField, hBox, errorLabel, textArea);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #ADD8E6");
        Scene deleteStationScene = new Scene(layout, 1600, 900);

        show.setOnAction(e -> {
            textArea.clear();
            String id = idField.getText();
            try {
                if (!id.isEmpty()) {
                    try {
                        int ticket_id = Integer.parseInt(id);
                        String query = "SELECT tickets_for.seat_number, has_trains.cost, has_trains.leave_time, has_trains.source_location, has_trains.destination_location " +
                                "FROM has_trains, tickets_for " +
                                "WHERE tickets_for.train_id = has_trains.train_id " +
                                "AND tickets_for.ticket_id = ?";
                        try (PreparedStatement stmt = connection.prepareStatement(query)) {
                            stmt.setInt(1, ticket_id);
                            ResultSet rs = stmt.executeQuery();
                            if (!rs.next()) {
                                errorLabel.setText("No tickets found for the ID " + ticket_id);
                            } else {
                                do {
                                    textArea.appendText("\n Seat: " + rs.getInt("seat_number"));
                                    textArea.appendText("\nTicket Cost: " + rs.getFloat("cost"));
                                    textArea.appendText("\nLeave Time: " + rs.getTimestamp("leave_time"));
                                    textArea.appendText("\nSource Location: " + rs.getString("source_location"));
                                    textArea.appendText("\nDestination Location: " + rs.getString("destination_location"));
                                    textArea.appendText("\n====================================================================\n");
                                } while (rs.next());
                            }
                        }
                    } catch (NumberFormatException | SQLException exception) {
                        errorLabel.setText(exception.getMessage());
                    }
                } else {
                    try {
                        String query = "SELECT tickets_for.ticket_id, tickets_for.seat_number, has_trains.cost, has_trains.leave_time, has_trains.source_location, has_trains.destination_location " +
                                "FROM has_trains, tickets_for " +
                                "WHERE tickets_for.train_id = has_trains.train_id ";
                        try (PreparedStatement stmt = connection.prepareStatement(query)) {
                            ResultSet rs = stmt.executeQuery();
                            textArea.setText("Tickets info : ");
                            while (rs.next()) {
                                textArea.appendText("\nTicket ID: " + rs.getInt("ticket_id"));
                                textArea.appendText("\nSeat : " + rs.getInt("seat_number"));
                                textArea.appendText("\nTicket Cost: " + rs.getFloat("cost"));
                                textArea.appendText("\nLeave Time: " + rs.getTimestamp("leave_time"));
                                textArea.appendText("\nSource Location: " + rs.getString("source_location"));
                                textArea.appendText("\nDestination Location: " + rs.getString("destination_location"));
                                textArea.appendText("\n====================================================================\n");
                            }
                        }
                    } catch (SQLException exception) {
                        errorLabel.setText(exception.getMessage());
                    }
                }
            } catch (NumberFormatException exception) {
                errorLabel.setText("Input ID must be an integer");
            }
        });
        backButton.setOnAction(e -> viewInfoScene(primaryStage));

        primaryStage.setScene(deleteStationScene);
        primaryStage.setTitle("Show Tickets");
        primaryStage.show();
    }

    private static void reservationInfoScene(Stage primaryStage) {
        Label idLabel = new Label("Customer ID: ");
        idLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        idLabel.setStyle("-fx-background-color: #3CB371;");
        TextField idField = new TextField();
        idField.setPromptText("Enter Customer id, leave it empty to display all.");
        idField.setMaxWidth(300);

        Label errorLabel = new Label();
        errorLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        errorLabel.setStyle("-fx-background-color: #FA8072;");

        Button show = new Button("SHOW");
        Button backButton = new Button("BACK");

        ImageView showView = new ImageView(new Image("https://img.icons8.com/bubbles/256/monitor.png"));
        showView.setFitWidth(50);
        showView.setFitHeight(50);
        show.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        showView.setStyle("-fx-background-color: #3CB371");
        show.setGraphic(showView);

        ImageView backView = new ImageView(new Image("https://img.icons8.com/clouds/1x/reply-arrow.png"));
        backView.setFitWidth(50);
        backView.setFitHeight(50);
        backButton.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        backView.setStyle("-fx-background-color: #3CB371");
        backButton.setGraphic(backView);

        HBox hBox = new HBox(15);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(show, backButton);

        TextArea textArea = new TextArea();
        textArea.setMaxWidth(600);
        textArea.setEditable(false);

        VBox layout = new VBox(20);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(idLabel, idField, hBox, errorLabel, textArea);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #ADD8E6");
        Scene deleteStationScene = new Scene(layout, 1600, 900);

        show.setOnAction(e -> {
            textArea.clear();
            String id = idField.getText();
            try {
                if (!id.isEmpty()) {
                    try {
                        int station_id = Integer.parseInt(id);
                        String query = "SELECT customers.name, reserve.ticket_id, has_trains.cost, has_trains.leave_time, has_trains.source_location, has_trains.destination_location " +
                                "FROM reserve, has_trains, customers " +
                                "WHERE reserve.train_id = has_trains.train_id " +
                                "AND customers.c_id = reserve.c_id " +
                                "AND reserve.c_id = ?";
                        try (PreparedStatement stmt = connection.prepareStatement(query)) {
                            stmt.setInt(1, station_id);
                            ResultSet rs = stmt.executeQuery();
                            if (!rs.next()) {
                                errorLabel.setText("No reservations found for customer ID " + station_id);
                            } else {
                                textArea.setText("The info of the reservations for the customer " + rs.getString("name"));
                                do {
                                    textArea.appendText("\nTicket ID: " + rs.getInt("ticket_id"));
                                    textArea.appendText("\nTicket Cost: " + rs.getFloat("cost"));
                                    textArea.appendText("\nLeave Time: " + rs.getTimestamp("leave_time"));
                                    textArea.appendText("\nSource Location: " + rs.getString("source_location"));
                                    textArea.appendText("\nDestination Location: " + rs.getString("destination_location"));
                                    textArea.appendText("\n====================================================================\n");
                                } while (rs.next());
                            }
                        }
                    } catch (NumberFormatException | SQLException exception) {
                        errorLabel.setText(exception.getMessage());
                    }
                } else {
                    try {
                        String query = "SELECT reserve.ticket_id, has_trains.cost, has_trains.leave_time, has_trains.source_location, has_trains.destination_location " +
                                "FROM reserve, has_trains " +
                                "WHERE reserve.train_id = has_trains.train_id ";
                        try (PreparedStatement stmt = connection.prepareStatement(query)) {
                            ResultSet rs = stmt.executeQuery();
                            textArea.setText("Reservations info : ");
                            while (rs.next()) {
                                textArea.appendText("\nTicket ID: " + rs.getInt("ticket_id"));
                                textArea.appendText("\nTicket Cost: " + rs.getFloat("cost"));
                                textArea.appendText("\nLeave Time: " + rs.getTimestamp("leave_time"));
                                textArea.appendText("\nSource Location: " + rs.getString("source_location"));
                                textArea.appendText("\nDestination Location: " + rs.getString("destination_location"));
                                textArea.appendText("\n====================================================================\n");
                            }
                        }
                    } catch (SQLException exception) {
                        errorLabel.setText(exception.getMessage());
                    }
                }
            } catch (NumberFormatException exception) {
                errorLabel.setText("Input ID must be an integer");
            }
        });
        backButton.setOnAction(e -> viewInfoScene(primaryStage));

        primaryStage.setScene(deleteStationScene);
        primaryStage.setTitle("Show Reservation");
        primaryStage.show();
    }

    private static void stationInfoScene(Stage primaryStage) {
        Label idLabel = new Label("Station ID: ");
        idLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        idLabel.setStyle("-fx-background-color: #3CB371;");
        TextField idField = new TextField();
        idField.setPromptText("Enter station id, leave it empty to display all.");
        idField.setMaxWidth(300);

        Label errorLabel = new Label();
        errorLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        errorLabel.setStyle("-fx-background-color: #FA8072;");

        Button show = new Button("SHOW");
        Button backButton = new Button("BACK");

        ImageView showView = new ImageView(new Image("https://img.icons8.com/bubbles/256/monitor.png"));
        showView.setFitWidth(50);
        showView.setFitHeight(50);
        show.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        showView.setStyle("-fx-background-color: #3CB371");
        show.setGraphic(showView);

        ImageView backView = new ImageView(new Image("https://img.icons8.com/clouds/1x/reply-arrow.png"));
        backView.setFitWidth(50);
        backView.setFitHeight(50);
        backButton.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        backView.setStyle("-fx-background-color: #3CB371");
        backButton.setGraphic(backView);

        HBox hBox = new HBox(15);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(show, backButton);

        TextArea textArea = new TextArea();
        textArea.setMaxWidth(600);
        textArea.setEditable(false);

        VBox layout = new VBox(20);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(idLabel, idField, hBox, errorLabel, textArea);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #ADD8E6");
        Scene deleteStationScene = new Scene(layout, 1600, 900);

        show.setOnAction(e -> {
            textArea.clear();
            String id = idField.getText();
            try {
                if (!id.isEmpty()) {
                    int station_id = Integer.parseInt(id);
                    try {
                        String query = "SELECT s.station_id, s.name, s.location, s.trains_count " +
                                "FROM station s WHERE s.station_id = ?";
                        try (PreparedStatement stmt = connection.prepareStatement(query)) {
                            stmt.setInt(1, station_id);
                            ResultSet rs = stmt.executeQuery();
                            if (!rs.next()) {
                                errorLabel.setText("Error: Station with ID " + station_id + " not found.");
                            } else {
                                textArea.setText("\nStation ID: " + rs.getInt("station_id"));
                                textArea.appendText("\nName: " + rs.getString("name"));
                                textArea.appendText("\nLocation: " + rs.getString("location"));
                                textArea.appendText("\nNumber Of Trains: " + rs.getInt("trains_count"));
                            }
                        }
                    } catch (SQLException exception) {
                        errorLabel.setText(exception.getMessage());
                    }
                } else {
                    try {
                        String query = "SELECT s.station_id, s.name, s.location, s.trains_count " +
                                "FROM station s";
                        try (PreparedStatement stmt = connection.prepareStatement(query)) {
                            ResultSet rs = stmt.executeQuery();
                            while (rs.next()) {
                                textArea.appendText("\nStation ID: " + rs.getInt("station_id"));
                                textArea.appendText("\nName: " + rs.getString("name"));
                                textArea.appendText("\nLocation: " + rs.getString("location"));
                                textArea.appendText("\nNumber Of Trains: " + rs.getInt("trains_count"));
                                textArea.appendText("\n-------------");
                            }
                        }
                    } catch (SQLException exception) {
                        errorLabel.setText(exception.getMessage());
                    }
                }
            } catch (NumberFormatException exception) {
                errorLabel.setText("Input ID must be an integer");
            }
        });
        backButton.setOnAction(e -> viewInfoScene(primaryStage));

        primaryStage.setScene(deleteStationScene);
        primaryStage.setTitle("Delete Station");
        primaryStage.show();
    }

    private static void customerInfoScene(Stage primaryStage) {
        Label idLabel = new Label("Customer ID: ");
        idLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        idLabel.setStyle("-fx-background-color: #3CB371;");
        TextField idField = new TextField();
        idField.setPromptText("Enter customer id, leave it empty to display all.");
        idField.setMaxWidth(300);

        Label errorLabel = new Label();
        errorLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        errorLabel.setStyle("-fx-background-color: #FA8072;");

        Button show = new Button("SHOW");
        Button backButton = new Button("BACK");

        ImageView showView = new ImageView(new Image("https://img.icons8.com/bubbles/256/monitor.png"));
        showView.setFitWidth(50);
        showView.setFitHeight(50);
        show.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        showView.setStyle("-fx-background-color: #3CB371");
        show.setGraphic(showView);

        ImageView backView = new ImageView(new Image("https://img.icons8.com/clouds/1x/reply-arrow.png"));
        backView.setFitWidth(50);
        backView.setFitHeight(50);
        backButton.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        backView.setStyle("-fx-background-color: #3CB371");
        backButton.setGraphic(backView);

        HBox hBox = new HBox(15);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(show, backButton);

        TextArea textArea = new TextArea();
        textArea.setMaxWidth(600);
        textArea.setEditable(false);

        VBox layout = new VBox(20);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(idLabel, idField, hBox, errorLabel, textArea);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #ADD8E6");
        Scene deleteCustomerScene = new Scene(layout, 1600, 900);

        show.setOnAction(e -> {
            textArea.clear();
            String id = idField.getText();
            try {
                if (id.isEmpty()) {
                    String query = "SELECT customers.c_id, customers.name, customers.address, customers.phone_number " +
                            "FROM customers";
                    try (PreparedStatement stmt = connection.prepareStatement(query)) {
                        ResultSet rs = stmt.executeQuery();
                        while (rs.next()) {
                            textArea.appendText("\n\nCustomer ID: " + rs.getInt("c_id"));
                            textArea.appendText("\nName: " + rs.getString("name"));
                            textArea.appendText("\nAddress: " + rs.getString("address"));
                            textArea.appendText("\nPhone Number: " + rs.getString("phone_number"));
                        }
                    } catch (SQLException exception) {
                        errorLabel.setText(exception.getMessage());
                    }
                } else {
                    int customer_id = Integer.parseInt(id);
                    try {
                        String query = "SELECT customers.c_id, customers.name, customers.address, customers.phone_number " +
                                "FROM customers where customers.c_id = ?";
                        try (PreparedStatement stmt = connection.prepareStatement(query)) {
                            stmt.setInt(1, customer_id);
                            ResultSet rs = stmt.executeQuery();
                            if (!rs.next()) {
                                errorLabel.setText("Error: Customer with ID " + customer_id + " not found.");
                            } else {
                                textArea.setText("\nCustomer ID: " + rs.getInt("c_id"));
                                textArea.appendText("\nName: " + rs.getString("name"));
                                textArea.appendText("\nAddress: " + rs.getString("address"));
                                textArea.appendText("\nPhone Number: " + rs.getString("phone_number"));
                            }
                        }
                    } catch (SQLException exception) {
                        errorLabel.setText(exception.getMessage());
                    }
                }
            } catch (NumberFormatException exception) {
                errorLabel.setText("Input ID must be a Number");
            }
        });

        backButton.setOnAction(e -> viewInfoScene(primaryStage));

        primaryStage.setScene(deleteCustomerScene);
        primaryStage.setTitle("View Customer Information");
        primaryStage.show();
    }

    public static void adminScene(Stage primaryStage) {

        Button btnInsertionInterface = new Button("Insertion Interface");
        btnInsertionInterface.setPrefSize(500, 60);
        btnInsertionInterface.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));
        btnInsertionInterface.setAlignment(Pos.CENTER);
        ImageView insertView = new ImageView(new Image("https://img.icons8.com/clouds/1x/insert-clip.png"));
        insertView.setFitHeight(50);
        insertView.setFitWidth(50);
        btnInsertionInterface.setGraphic(insertView);
        btnInsertionInterface.setStyle("-fx-background-color: #FDF5E6");

        Button btnDeleteInterface = new Button("Delete Interface");
        btnDeleteInterface.setPrefSize(500, 60);
        btnDeleteInterface.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));
        btnDeleteInterface.setAlignment(Pos.CENTER);
        ImageView deleteView = new ImageView(new Image("https://img.icons8.com/clouds/256/delete-forever.png"));
        deleteView.setFitHeight(50);
        deleteView.setFitWidth(50);
        btnDeleteInterface.setGraphic(deleteView);
        btnDeleteInterface.setStyle("-fx-background-color: #FDF5E6");

        Button btnUpdateInterface = new Button("Update Interface");
        btnUpdateInterface.setPrefSize(500, 60);
        btnUpdateInterface.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));
        btnUpdateInterface.setAlignment(Pos.CENTER);
        ImageView updateView = new ImageView(new Image("https://img.icons8.com/clouds/1x/available-updates.png"));
        updateView.setFitHeight(50);
        updateView.setFitWidth(50);
        btnUpdateInterface.setGraphic(updateView);
        btnUpdateInterface.setStyle("-fx-background-color: #FDF5E6");

        Button backButton = new Button("Back");
        backButton.setPrefSize(500, 60);
        backButton.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));
        backButton.setAlignment(Pos.CENTER);
        ImageView backView = new ImageView(new Image("https://img.icons8.com/clouds/1x/reply-arrow.png"));
        insertView.setFitHeight(50);
        insertView.setFitWidth(50);
        backButton.setGraphic(backView);
        backButton.setStyle("-fx-background-color: #FDF5E6");

        Label label = new Label("ADMINISTRATION ACTIONS");
        label.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 30));

        btnInsertionInterface.setOnAction(e -> insertionScene(primaryStage));
        btnDeleteInterface.setOnAction(e -> deletionScene(primaryStage));
        btnUpdateInterface.setOnAction(e -> updateScene(primaryStage));
        backButton.setOnAction(event -> initial(primaryStage));

        VBox vBox = new VBox(label, btnInsertionInterface, btnDeleteInterface, btnUpdateInterface, backButton);
        vBox.setSpacing(25);
        vBox.setAlignment(Pos.CENTER);
        vBox.setStyle("-fx-background-color: #CCCCFF");
        Scene adminScene = new Scene(vBox, 1600, 900);
        primaryStage.setTitle("Administrator");
//        primaryStage.setMaximized(true);
        primaryStage.setScene(adminScene);
        primaryStage.show();
    }

    public static void updateScene(Stage primaryStage) {
        VBox grid = new VBox(20);
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setAlignment(Pos.CENTER);

        Button UpdateTrainBtn = new Button("Update Train");
        UpdateTrainBtn.setPrefSize(500, 60);
        UpdateTrainBtn.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));
        UpdateTrainBtn.setAlignment(Pos.CENTER);
        UpdateTrainBtn.setStyle("-fx-background-color: #9ACD32");
        Button UpdateStationBtn = new Button("Update Station");
        UpdateStationBtn.setPrefSize(500, 60);
        UpdateStationBtn.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));
        UpdateStationBtn.setAlignment(Pos.CENTER);
        UpdateStationBtn.setStyle("-fx-background-color: #9ACD32");
        Button UpdateReserveBtn = new Button("Update Reserve");
        UpdateReserveBtn.setPrefSize(500, 60);
        UpdateReserveBtn.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));
        UpdateReserveBtn.setAlignment(Pos.CENTER);
        UpdateReserveBtn.setStyle("-fx-background-color: #9ACD32");
        Button UpdateCustomerBtn = new Button("Update Customer");
        UpdateCustomerBtn.setPrefSize(500, 60);
        UpdateCustomerBtn.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));
        UpdateCustomerBtn.setAlignment(Pos.CENTER);
        UpdateCustomerBtn.setStyle("-fx-background-color: #9ACD32");
        Button UpdateTicketBtn = new Button("Update Ticket");
        UpdateTicketBtn.setPrefSize(500, 60);
        UpdateTicketBtn.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));
        UpdateTicketBtn.setAlignment(Pos.CENTER);
        UpdateTicketBtn.setStyle("-fx-background-color: #9ACD32");

        Button backButton = new Button("Back");
        backButton.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));
        backButton.setAlignment(Pos.CENTER);
        ImageView backView = new ImageView(new Image("https://img.icons8.com/clouds/1x/reply-arrow.png"));
        backView.setFitHeight(50);
        backView.setFitWidth(50);
        backButton.setGraphic(backView);


        grid.getChildren().addAll(UpdateTrainBtn, UpdateStationBtn, UpdateCustomerBtn, UpdateTicketBtn, backButton);
        grid.setAlignment(Pos.CENTER);
        grid.setStyle("-fx-background-color: #ADD8E6");
        UpdateCustomerBtn.setOnAction(e -> updateCustomerScene(primaryStage));
        UpdateStationBtn.setOnAction(e -> updateStationScene(primaryStage));
        UpdateTrainBtn.setOnAction(e -> updateTrainScene(primaryStage));
        UpdateTicketBtn.setOnAction(e -> updateTicketScene(primaryStage));

        backButton.setOnAction(e -> adminScene(primaryStage));

        Scene updateScene = new Scene(grid, 1600, 900);
        primaryStage.setScene(updateScene);
        primaryStage.show();

    }

    public static void updateTicketScene(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setAlignment(Pos.CENTER);

        Label errorLabel = new Label();
        errorLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 10));
        errorLabel.setTextFill(Color.RED);

        Label ticketIdLabel = new Label("Ticket ID: ");
        ticketIdLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        ticketIdLabel.setStyle("-fx-background-color: #3CB371;");
        TextField ticketIdField = new TextField();

        Label seatNumberLabel = new Label("Seat Number: ");
        seatNumberLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        seatNumberLabel.setStyle("-fx-background-color: #3CB371;");
        TextField seatNumberField = new TextField();


        Button updateBtn = new Button("Update");
        ImageView updateView = new ImageView(new Image("https://img.icons8.com/clouds/1x/available-updates.png"));
        updateView.setFitWidth(50);
        updateView.setFitHeight(50);
        updateBtn.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        updateView.setStyle("-fx-background-color: #3CB371");
        updateBtn.setGraphic(updateView);
        Button showBtn = new Button("Display");
        ImageView showView = new ImageView(new Image("https://img.icons8.com/clouds/1x/reply-arrow.png"));
        showView.setFitWidth(50);
        showView.setFitHeight(50);
        showBtn.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        showView.setStyle("-fx-background-color: #3CB371");
        showBtn.setGraphic(showView);

        Button backBtn = new Button("Back");
        ImageView backView = new ImageView(new Image("https://img.icons8.com/clouds/1x/reply-arrow.png"));
        backView.setFitWidth(50);
        backView.setFitHeight(50);
        backBtn.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        backView.setStyle("-fx-background-color: #3CB371");
        backBtn.setGraphic(backView);

        Button clear = new Button("Clear");
        ImageView clearView = new ImageView(new Image("https://img.icons8.com/clouds/1x/broom.png"));
        clearView.setFitWidth(50);
        clearView.setFitHeight(50);
        clear.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        clearView.setStyle("-fx-background-color: #3CB371");
        clear.setGraphic(clearView);

        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(updateBtn, showBtn, clear, backBtn);

        showBtn.setOnAction(e -> {
            if (ticketIdField.getText().isEmpty()) {
                errorLabel.setText("You must enter the ticket id first!");
            } else {
                String id = ticketIdField.getText();
                try {
                    int ticket_id = Integer.parseInt(id);
                    try {
                        String query = "SELECT * FROM tickets_for WHERE ticket_id = ?";
                        try (PreparedStatement stmt = connection.prepareStatement(query)) {
                            stmt.setInt(1, ticket_id);
                            ResultSet rs = stmt.executeQuery();
                            if (!rs.next()) {
                                errorLabel.setText("Error: Ticket with ID " + ticket_id + " not found.");
                            } else {
                                ticketIdField.setText(String.valueOf(rs.getInt("ticket_id")));
                                seatNumberField.setText(String.valueOf(rs.getInt("seat_number")));
                            }
                        }
                    } catch (SQLException exception) {
                        errorLabel.setText(exception.getMessage());
                    }
                } catch (NumberFormatException exception) {
                    errorLabel.setText("Input ID must be integer");
                }
            }
        });

        updateBtn.setOnAction(e -> {
            if (ticketIdField.getText().isEmpty() || seatNumberField.getText().isEmpty()) {
                errorLabel.setText("You must enter all the fields first!");
            } else {
                try {
                    int ticket_id = Integer.parseInt(ticketIdField.getText());
                    int seat_number = Integer.parseInt(seatNumberField.getText());
//                    int train_id = Integer.parseInt(trainIdField.getText());
                    try {
                        String query = "UPDATE tickets_for SET seat_number = ? WHERE ticket_id = ?";
                        try (PreparedStatement stmt = connection.prepareStatement(query)) {
                            stmt.setInt(1, seat_number);
//                            stmt.setInt(2, train_id);
                            stmt.setInt(2, ticket_id);
                            int rowsAffected = stmt.executeUpdate();
                            if (rowsAffected == 0) {
                                errorLabel.setText("The ticket with id " + ticket_id + " does not exist.");
                            } else {
                                errorLabel.setText("The ticket with id " + ticket_id + " has been updated successfully.");
                            }
                        }
                    } catch (SQLException ex) {
                        errorLabel.setText("An error occurred while trying to update the ticket. " + ex.getMessage());
                    }
                } catch (NumberFormatException ex) {
                    errorLabel.setText("Ticket ID, Seat Number, and Train ID must be integers.");
                }
            }
            ticketIdField.clear();
            seatNumberField.clear();
        });
        backBtn.setOnAction(e -> updateScene(primaryStage));
        clear.setOnAction(e -> {
            ticketIdField.clear();
            seatNumberField.clear();
//            trainIdField.clear();
            errorLabel.setText("");
        });

        grid.add(errorLabel, 0, 0, 2, 1);
        grid.add(ticketIdLabel, 0, 1);
        grid.add(ticketIdField, 1, 1);
        grid.add(seatNumberLabel, 0, 2);
        grid.add(seatNumberField, 1, 2);

        VBox vBox = new VBox(25);
        vBox.setStyle("-fx-background-color: #ADD8E6");
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(grid, hBox);
        Scene scene = new Scene(vBox, 1600, 900);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    private static void updateTrainScene(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        Label errorLabel = new Label();
        errorLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        errorLabel.setStyle("-fx-background-color: #3CB371;");

        Label idLabel = new Label("Train ID: ");
        idLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        idLabel.setStyle("-fx-background-color: #3CB371;");
        TextField idField = new TextField();

        Label locationLabel = new Label("Source Location : ");
        locationLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        locationLabel.setStyle("-fx-background-color: #3CB371;");
        TextField locationField = new TextField();

        Label destLocationLabel = new Label("Destination Location : ");
        destLocationLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        destLocationLabel.setStyle("-fx-background-color: #3CB371;");
        TextField destLocationField = new TextField();

        Label capacityLabel = new Label("Capacity: ");
        capacityLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        capacityLabel.setStyle("-fx-background-color: #3CB371;");
        TextField capacityField = new TextField();

        Label costLabel = new Label("Cost: ");
        costLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        costLabel.setStyle("-fx-background-color: #3CB371;");
        TextField costField = new TextField();

        Label leaveTimeLabel = new Label("Leave Time: ");
        leaveTimeLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        leaveTimeLabel.setStyle("-fx-background-color: #3CB371;");
        TextField leaveTimeField = new TextField();
        leaveTimeField.setPromptText("yy-mm-dd hh:mm:ss");

        Button updateBtn = new Button("Update");
        ImageView updateView = new ImageView(new Image("https://img.icons8.com/clouds/1x/available-updates.png"));
        updateView.setFitWidth(50);
        updateView.setFitHeight(50);
        updateBtn.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        updateView.setStyle("-fx-background-color: #3CB371");
        updateBtn.setGraphic(updateView);
        Button showBtn = new Button("Display");
        ImageView showView = new ImageView(new Image("https://img.icons8.com/clouds/1x/reply-arrow.png"));
        showView.setFitWidth(50);
        showView.setFitHeight(50);
        showBtn.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        showView.setStyle("-fx-background-color: #3CB371");
        showBtn.setGraphic(showView);

        Button backBtn = new Button("Back");
        ImageView backView = new ImageView(new Image("https://img.icons8.com/clouds/1x/reply-arrow.png"));
        backView.setFitWidth(50);
        backView.setFitHeight(50);
        backBtn.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        backView.setStyle("-fx-background-color: #3CB371");
        backBtn.setGraphic(backView);

        Button clear = new Button("Clear");
        ImageView clearView = new ImageView(new Image("https://img.icons8.com/clouds/1x/broom.png"));
        clearView.setFitWidth(50);
        clearView.setFitHeight(50);
        clear.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        clearView.setStyle("-fx-background-color: #3CB371");
        clear.setGraphic(clearView);

        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(updateBtn, showBtn, clear, backBtn);

        showBtn.setOnAction(e -> {
            if (idField.getText().isEmpty())
                errorLabel.setText("You must enter the train id first!");
            else {
                String id = idField.getText();
                try {
                    int train_id = Integer.parseInt(id);
                    try {
                        String query = "SELECT has_trains.train_id, has_trains.source_location, has_trains.destination_location, has_trains.capacity, has_trains.cost, has_trains.leave_time " +
                                "FROM has_trains where has_trains.train_id = ?";
                        try (PreparedStatement stmt = connection.prepareStatement(query)) {
                            stmt.setInt(1, train_id);
                            ResultSet rs = stmt.executeQuery();
                            if (!rs.next()) {
                                errorLabel.setText("Error: Train with ID " + train_id + " not found.");
                            } else {
                                idField.setText(String.valueOf(rs.getInt("train_id")));
                                locationField.setText(rs.getString("source_location"));
                                destLocationField.setText(rs.getString("destination_location"));
                                capacityField.setText(String.valueOf(rs.getInt("capacity")));
                                costField.setText(String.valueOf(rs.getDouble("cost")));
                                leaveTimeField.setText(String.valueOf(rs.getTimestamp("leave_time")));
                            }
                        }
                    } catch (SQLException exception) {
                        errorLabel.setText(exception.getMessage());
                    }
                } catch (NumberFormatException exception) {
                    errorLabel.setText("Input ID must be integer");
                }
            }
        });

        backBtn.setOnAction(e -> updateScene(primaryStage));

        clear.setOnAction(e -> {
            idField.clear();
            locationField.clear();
            destLocationField.clear();
            costField.clear();
            capacityField.clear();
            leaveTimeField.clear();
            errorLabel.setText("");
        });
        updateBtn.setOnAction(e -> {
            if (idField.getText().isEmpty() || locationField.getText().isEmpty() || destLocationField.getText().isEmpty() || capacityField.getText().isEmpty() || costField.getText().isEmpty() || leaveTimeField.getText().isEmpty())
                errorLabel.setText("All fields are required!");
            else {
                try {
                    int train_id = Integer.parseInt(idField.getText());
                    int capacity = Integer.parseInt(capacityField.getText());
                    double cost = Double.parseDouble(costField.getText());
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    dateFormat.setLenient(false);
                    dateFormat.parse(leaveTimeField.getText());
                    String query = "UPDATE has_trains SET source_location = ?, destination_location = ?, capacity = ?, cost = ?, leave_time = ? WHERE train_id = ?";
                    try (PreparedStatement stmt = connection.prepareStatement(query)) {
                        stmt.setString(1, locationField.getText());
                        stmt.setString(2, destLocationField.getText());
                        stmt.setInt(3, capacity);
                        stmt.setDouble(4, cost);
                        stmt.setString(5, leaveTimeField.getText());
                        stmt.setInt(6, train_id);
                        int result = stmt.executeUpdate();
                        if (result == 1) {
                            errorLabel.setText("Train updated successfully");
                        } else {
                            errorLabel.setText("Error: Train with ID " + train_id + " not found.");
                        }
                    }
                } catch (NumberFormatException | ParseException | SQLException exception) {
                    errorLabel.setText("Error: Invalid format of leave time. Required format: yyyy-MM-dd HH:mm:ss");
                }
            }
            idField.clear();
            locationField.clear();
            destLocationField.clear();
            costField.clear();
            capacityField.clear();
            leaveTimeField.clear();
        });

        grid.add(idLabel, 0, 0);
        grid.add(idField, 1, 0);

        grid.add(locationLabel, 0, 1);
        grid.add(locationField, 1, 1);

        grid.add(destLocationLabel, 0, 2);
        grid.add(destLocationField, 1, 2);

        grid.add(capacityLabel, 0, 3);
        grid.add(capacityField, 1, 3);

        grid.add(costLabel, 0, 4);
        grid.add(costField, 1, 4);

        grid.add(leaveTimeLabel, 0, 5);
        grid.add(leaveTimeField, 1, 5);
        grid.setAlignment(Pos.CENTER);

        VBox vBox = new VBox(20);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(grid, errorLabel, hBox);
        vBox.setStyle("-fx-background-color: #ADD8E6");
        Scene scene = new Scene(vBox, 1600, 900);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private static void updateStationScene(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setAlignment(Pos.CENTER);

        Label errorLabel = new Label();
        errorLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        errorLabel.setStyle("-fx-background-color: #3CB371;");

        Label idLabel = new Label("Station ID: ");
        idLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        idLabel.setStyle("-fx-background-color: #3CB371;");
        TextField idField = new TextField();

        Label nameLabel = new Label("Name: ");
        nameLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        nameLabel.setStyle("-fx-background-color: #3CB371;");
        TextField nameField = new TextField();

        Label locationLabel = new Label("Location : ");
        locationLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        locationLabel.setStyle("-fx-background-color: #3CB371;");
        TextField locationField = new TextField();

        Label countLabel = new Label("Trains Count: ");
        countLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        countLabel.setStyle("-fx-background-color: #3CB371;");
        TextField countField = new TextField();

        Button updateBtn = new Button("Update");
        ImageView updateView = new ImageView(new Image("https://img.icons8.com/clouds/1x/available-updates.png"));
        updateView.setFitWidth(50);
        updateView.setFitHeight(50);
        updateBtn.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        updateView.setStyle("-fx-background-color: #3CB371");
        updateBtn.setGraphic(updateView);
        Button showBtn = new Button("Display");
        ImageView showView = new ImageView(new Image("https://img.icons8.com/clouds/1x/reply-arrow.png"));
        showView.setFitWidth(50);
        showView.setFitHeight(50);
        showBtn.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        showView.setStyle("-fx-background-color: #3CB371");
        showBtn.setGraphic(showView);

        Button backBtn = new Button("Back");
        ImageView backView = new ImageView(new Image("https://img.icons8.com/clouds/1x/reply-arrow.png"));
        backView.setFitWidth(50);
        backView.setFitHeight(50);
        backBtn.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        backView.setStyle("-fx-background-color: #3CB371");
        backBtn.setGraphic(backView);

        Button clear = new Button("Clear");
        ImageView clearView = new ImageView(new Image("https://img.icons8.com/clouds/1x/broom.png"));
        clearView.setFitWidth(50);
        clearView.setFitHeight(50);
        clear.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        clearView.setStyle("-fx-background-color: #3CB371");
        clear.setGraphic(clearView);

        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(updateBtn, showBtn, clear, backBtn);

        showBtn.setOnAction(e -> {
            if (idField.getText().isEmpty())
                errorLabel.setText("You must enter the station id first!");
            else {
                String id = idField.getText();
                try {
                    int station_id = Integer.parseInt(id);
                    try {
                        String query = "SELECT station.station_id, station.name, station.location , station.trains_count " +
                                "FROM station where station.station_id = ?";
                        try (PreparedStatement stmt = connection.prepareStatement(query)) {
                            stmt.setInt(1, station_id);
                            ResultSet rs = stmt.executeQuery();
                            if (!rs.next()) {
                                errorLabel.setText("Error: Station with ID " + station_id + " not found.");
                            } else {
                                idField.setText(String.valueOf(rs.getInt("station_id")));
                                nameField.setText(rs.getString("name"));
                                locationField.setText(rs.getString("location"));
                                countField.setText(String.valueOf(rs.getString("trains_count")));
                            }
                        }
                    } catch (SQLException exception) {
                        errorLabel.setText(exception.getMessage());
                    }
                } catch (NumberFormatException exception) {
                    errorLabel.setText("Input ID must be integer");
                }
            }
        });

        backBtn.setOnAction(e -> updateScene(primaryStage));
        clear.setOnAction(e -> {
            idField.clear();
            nameField.clear();
            locationField.clear();
            countField.clear();
            errorLabel.setText("");
        });

        updateBtn.setOnAction(event -> {
            boolean validInput = true;

            // Validate Station ID
            if (idField.getText().isEmpty()) {
                errorLabel.setText("Please enter the station ID");
                validInput = false;
            }

            // Validate Name
            if (nameField.getText().isEmpty()) {
                errorLabel.setText("Please enter the station name");
                validInput = false;
            }

            // Validate Phone Number
            if (locationField.getText().isEmpty()) {
                errorLabel.setText("Please enter the station location field");
                validInput = false;
            }
            if (countField.getText().isEmpty()) {
                errorLabel.setText("Please enter the station trains-count field");
            }
            if (validInput) {
                int sid;
                int count;
                try {
                    sid = Integer.parseInt(idField.getText());
                    count = Integer.parseInt(countField.getText());
                } catch (NumberFormatException e) {
                    errorLabel.setText("Invalid Inputs : Station ID and Trains-Count must be numbers!");
                    return;
                }
                errorLabel.setText("");
                String checkSql = "SELECT * FROM station WHERE station_id = ?";
                try (PreparedStatement checkStmt = connection.prepareStatement(checkSql)) {
                    checkStmt.setInt(1, sid);
                    ResultSet checkRs = checkStmt.executeQuery();
                    if (!checkRs.next()) {
                        errorLabel.setText("Error: No station found with ID " + sid);
                        return;
                    }
                } catch (SQLException e) {
                    errorLabel.setText(e.getMessage());
                    return;
                }

                // Update the customer's information in the database
                String updateSql = "UPDATE station SET name = ?, location = ?, trains_count = ? WHERE station_id = ?";
                try (PreparedStatement updateStmt = connection.prepareStatement(updateSql)) {
                    connection.setAutoCommit(false);
                    updateStmt.setString(1, nameField.getText());
                    updateStmt.setString(2, locationField.getText());
                    updateStmt.setInt(3, count);
                    updateStmt.setInt(4, sid);
                    updateStmt.executeUpdate();
                    errorLabel.setText("Station information updated successfully.");
                    connection.commit();
                } catch (SQLException e) {
                    errorLabel.setText("Update Failed");
                    return;
                }
                // Clear the input fields after updating the customer information
                idField.clear();
                nameField.clear();
                locationField.clear();
                countField.clear();
            }
        });
        grid.add(idLabel, 0, 0);
        grid.add(idField, 1, 0);
        grid.add(nameLabel, 0, 1);
        grid.add(nameField, 1, 1);
        grid.add(locationLabel, 0, 2);
        grid.add(locationField, 1, 2);
        grid.add(countLabel, 0, 3);
        grid.add(countField, 1, 3);
        grid.setAlignment(Pos.CENTER);
        VBox vBox = new VBox(20);
        vBox.getChildren().addAll(grid, errorLabel, hBox);
        vBox.setAlignment(Pos.CENTER);
        vBox.setStyle("-fx-background-color: #ADD8E6");
        Scene scene = new Scene(vBox, 1600, 900);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private static void updateCustomerScene(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setAlignment(Pos.CENTER);

        Label errorLabel = new Label();
        errorLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        errorLabel.setStyle("-fx-background-color: #3CB371;");

        Label idLabel = new Label("Customer ID: ");
        idLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        idLabel.setStyle("-fx-background-color: #3CB371;");
        TextField idField = new TextField();

        Label nameLabel = new Label("Name: ");
        nameLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        nameLabel.setStyle("-fx-background-color: #3CB371;");
        TextField nameField = new TextField();

        Label phoneLabel = new Label("Phone Number: ");
        phoneLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        phoneLabel.setStyle("-fx-background-color: #3CB371;");
        TextField phoneField = new TextField();

        Label addressLabel = new Label("Address: ");
        addressLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        addressLabel.setStyle("-fx-background-color: #3CB371;");
        TextField addressField = new TextField();

        Button updateBtn = new Button("Update");
        ImageView updateView = new ImageView(new Image("https://img.icons8.com/clouds/1x/available-updates.png"));
        updateView.setFitWidth(50);
        updateView.setFitHeight(50);
        updateBtn.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        updateView.setStyle("-fx-background-color: #3CB371");
        updateBtn.setGraphic(updateView);
        Button showBtn = new Button("Display");
        ImageView showView = new ImageView(new Image("https://img.icons8.com/clouds/1x/reply-arrow.png"));
        showView.setFitWidth(50);
        showView.setFitHeight(50);
        showBtn.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        showView.setStyle("-fx-background-color: #3CB371");
        showBtn.setGraphic(showView);

        Button backBtn = new Button("Back");
        ImageView backView = new ImageView(new Image("https://img.icons8.com/clouds/1x/reply-arrow.png"));
        backView.setFitWidth(50);
        backView.setFitHeight(50);
        backBtn.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        backView.setStyle("-fx-background-color: #3CB371");
        backBtn.setGraphic(backView);

        Button clear = new Button("Clear");
        ImageView clearView = new ImageView(new Image("https://img.icons8.com/clouds/1x/broom.png"));
        clearView.setFitWidth(50);
        clearView.setFitHeight(50);
        clear.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        clearView.setStyle("-fx-background-color: #3CB371");
        clear.setGraphic(clearView);

        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(updateBtn, showBtn, clear, backBtn);

        showBtn.setOnAction(e -> {
            if (idField.getText().isEmpty())
                errorLabel.setText("You must enter the customer id first!");
            else {
                String id = idField.getText();
                try {
                    int customer_id = Integer.parseInt(id);
                    try {
                        String query = "SELECT customers.c_id, customers.name, customers.address , customers.phone_number " +
                                "FROM customers where customers.c_id = ?";
                        try (PreparedStatement stmt = connection.prepareStatement(query)) {
                            stmt.setInt(1, customer_id);
                            ResultSet rs = stmt.executeQuery();
                            if (!rs.next()) {
                                errorLabel.setText("Error: Customer with ID " + customer_id + " not found.");
                                idField.clear();
                                nameField.clear();
                                addressField.clear();
                                phoneField.clear();
                            } else {
                                idField.setText(String.valueOf(rs.getInt("c_id")));
                                nameField.setText(rs.getString("name"));
                                addressField.setText(rs.getString("address"));
                                phoneField.setText(rs.getString("phone_number"));

                            }
                        }
                    } catch (SQLException exception) {
                        errorLabel.setText(exception.getMessage());
                    }
                } catch (NumberFormatException exception) {
                    errorLabel.setText("Input ID must be integer");
                }
            }
        });

        backBtn.setOnAction(e -> updateScene(primaryStage));
        clear.setOnAction(e -> {
            idField.clear();
            nameField.clear();
            addressField.clear();
            phoneField.clear();
            clear.setText("");
        });

        updateBtn.setOnAction(event -> {
            boolean validInput = true;

            if (idField.getText().isEmpty() || nameField.getText().isEmpty() || addressField.getText().isEmpty() || phoneField.getText().isEmpty())
                validInput = false;
            // Update the customer information if the input is valid
            if (validInput) {
                int cid;
                try {
                    cid = Integer.parseInt(idField.getText());
                } catch (NumberFormatException e) {
                    errorLabel.setText("Input id must be a number!");
                    return;
                }
                errorLabel.setText("");
                String checkSql = "SELECT * FROM customers WHERE c_id = ?";
                try (PreparedStatement checkStmt = connection.prepareStatement(checkSql)) {
                    checkStmt.setInt(1, cid);
                    ResultSet checkRs = checkStmt.executeQuery();
                    if (!checkRs.next()) {
                        errorLabel.setText("Error: No customer found with ID " + cid);
                        return;
                    }
                } catch (SQLException e) {
                    errorLabel.setText(e.getMessage());
                    return;
                }

                // Update the customer's information in the database
                String updateSql = "UPDATE customers SET name = ?, phone_number = ?, address = ? WHERE c_id = ?";
                try (PreparedStatement updateStmt = connection.prepareStatement(updateSql)) {
                    updateStmt.setString(1, nameField.getText());
                    updateStmt.setString(2, phoneField.getText());
                    updateStmt.setString(3, addressField.getText());
                    updateStmt.setInt(4, cid);
                    updateStmt.executeUpdate();
                    errorLabel.setText("Customer information updated successfully.");
                    connection.commit();
                } catch (SQLException e) {
                    errorLabel.setText("Update Failed!");
                    return;
                }
                // Clear the input fields after updating the customer information
                idField.clear();
                nameField.clear();
                phoneField.clear();
                addressField.clear();
            }
        });

        grid.add(idLabel, 0, 0);
        grid.add(idField, 1, 0);
        grid.add(nameLabel, 0, 1);
        grid.add(nameField, 1, 1);
        grid.add(phoneLabel, 0, 2);
        grid.add(phoneField, 1, 2);
        grid.add(addressLabel, 0, 3);
        grid.add(addressField, 1, 3);

        VBox vBox = new VBox(20);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(grid, errorLabel, hBox);
        vBox.setStyle("-fx-background-color: #ADD8E6");
        Scene scene = new Scene(vBox, 1600, 900);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void deletionScene(Stage primaryStage) {
        VBox grid = new VBox(20);
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setStyle("-fx-background-color: #ADD8E6");

        Button deleteTrainBtn = new Button("Delete Train");
        deleteTrainBtn.setPrefSize(500, 60);
        deleteTrainBtn.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));
        deleteTrainBtn.setAlignment(Pos.CENTER);
        deleteTrainBtn.setStyle("-fx-background-color: #9ACD32");
        Button deleteStationBtn = new Button("Delete Station");
        deleteStationBtn.setPrefSize(500, 60);
        deleteStationBtn.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));
        deleteStationBtn.setAlignment(Pos.CENTER);
        deleteStationBtn.setStyle("-fx-background-color: #9ACD32");
        Button deleteReserveBtn = new Button("Delete Reserve");
        deleteReserveBtn.setPrefSize(500, 60);
        deleteReserveBtn.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));
        deleteReserveBtn.setAlignment(Pos.CENTER);
        deleteReserveBtn.setStyle("-fx-background-color: #9ACD32");
        Button deleteCustomerBtn = new Button("Delete Customer");
        deleteCustomerBtn.setPrefSize(500, 60);
        deleteCustomerBtn.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));
        deleteCustomerBtn.setAlignment(Pos.CENTER);
        deleteCustomerBtn.setStyle("-fx-background-color: #9ACD32");
        Button deleteTicketBtn = new Button("Delete Ticket");
        deleteTicketBtn.setPrefSize(500, 60);
        deleteTicketBtn.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));
        deleteTicketBtn.setAlignment(Pos.CENTER);
        deleteTicketBtn.setStyle("-fx-background-color: #9ACD32");

        Button backButton = new Button("Back");
//        backButton.setPrefSize(500, 60);
        backButton.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));
        backButton.setAlignment(Pos.CENTER);
        ImageView backView = new ImageView(new Image("https://img.icons8.com/clouds/1x/reply-arrow.png"));
        backView.setFitHeight(50);
        backView.setFitWidth(50);
        backButton.setGraphic(backView);
//        backButton.setStyle("-fx-background-color: #FF80E6");
        grid.getChildren().addAll(deleteTrainBtn, deleteStationBtn, deleteReserveBtn, deleteCustomerBtn, deleteTicketBtn, backButton);
        grid.setAlignment(Pos.CENTER);

        deleteCustomerBtn.setOnAction(e -> deleteCustomer(primaryStage));
        deleteStationBtn.setOnAction(e -> deleteStation(primaryStage));
        deleteTicketBtn.setOnAction(e -> deleteTicket(primaryStage));
        deleteTrainBtn.setOnAction(e -> deleteTrain(primaryStage));
        deleteReserveBtn.setOnAction(e -> deleteReserve(primaryStage));
        backButton.setOnAction(e -> adminScene(primaryStage));

        Scene deletionScene = new Scene(grid, 1600, 900);
        primaryStage.setScene(deletionScene);
        primaryStage.show();

    }

    public static void deleteCustomer(Stage primaryStage) {
        Label idLabel = new Label("Customer ID: ");
        idLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        idLabel.setStyle("-fx-background-color: #3CB371;");
        TextField idField = new TextField();
        idField.setPromptText("Enter the id of the customer you want to delete");
        idField.setMaxWidth(300);

        Label errorLabel = new Label();
        errorLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        errorLabel.setStyle("-fx-background-color: #FA8072;");

        Button submitButton = new Button("DELETE");
        Button show = new Button("SHOW");
        Button backButton = new Button("BACK");

        ImageView deleteView = new ImageView(new Image("https://img.icons8.com/clouds/1x/delete-forever.png"));
        deleteView.setFitWidth(50);
        deleteView.setFitHeight(50);
        submitButton.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        deleteView.setStyle("-fx-background-color: #3CB371");
        submitButton.setGraphic(deleteView);

        ImageView showView = new ImageView(new Image("https://img.icons8.com/bubbles/256/monitor.png"));
        showView.setFitWidth(50);
        showView.setFitHeight(50);
        show.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        showView.setStyle("-fx-background-color: #3CB371");
        show.setGraphic(showView);

        ImageView backView = new ImageView(new Image("https://img.icons8.com/clouds/1x/reply-arrow.png"));
        backView.setFitWidth(50);
        backView.setFitHeight(50);
        backButton.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        backView.setStyle("-fx-background-color: #3CB371");
        backButton.setGraphic(backView);

        HBox hBox = new HBox(15);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(submitButton, show, backButton);

        TextArea textArea = new TextArea();
        textArea.setMaxWidth(600);

        VBox layout = new VBox(20);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(idLabel, idField, hBox, errorLabel, textArea);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #ADD8E6");
        Scene deleteCustomerScene = new Scene(layout, 1600, 900);

        show.setOnAction(e -> {
            errorLabel.setText("");
            textArea.clear();
            if (idField.getText().isEmpty())
                errorLabel.setText("You must enter the customer id first!");
            else {
                String id = idField.getText();
                try {
                    int customer_id = Integer.parseInt(id);
                    try {
                        String query = "SELECT customers.c_id, customers.name, customers.address , customers.phone_number " +
                                "FROM customers where customers.c_id = ?";
                        try (PreparedStatement stmt = connection.prepareStatement(query)) {
                            stmt.setInt(1, customer_id);
                            ResultSet rs = stmt.executeQuery();
                            if (!rs.next()) {
                                errorLabel.setText("Error: Customer with ID " + customer_id + " not found.");
                            } else {
                                textArea.setText("\nCustomer ID: " + rs.getInt("c_id"));
                                textArea.appendText("\nName: " + rs.getString("name"));
                                textArea.appendText("\nAddress: " + rs.getString("address"));
                                textArea.appendText("\nPhone_Number: " + rs.getString("phone_number"));
                            }
                        }
                    } catch (SQLException exception) {
                        errorLabel.setText(exception.getMessage());
                    }
                } catch (NumberFormatException exception) {
                    errorLabel.setText("Input ID must be integer");
                }
            }
        });
        submitButton.setOnAction(e -> {
            errorLabel.setText("");
            textArea.clear();
            String id = idField.getText();
            if (id.isEmpty())
                errorLabel.setText("You must enter the train id first!");
            else {
                try {
                    int customer_id = Integer.parseInt(id);
                    try {
                        connection.setAutoCommit(false);
                        String sql = "DELETE FROM customers WHERE c_id = ?";
                        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                            stmt.setInt(1, customer_id);
                            int rowsDeleted = stmt.executeUpdate();
                            if (rowsDeleted > 0) {

                                errorLabel.setText("Customer deleted successfully.");
                                connection.commit();
                            } else {
                                errorLabel.setText("No matching Customer found");
                            }
                        }
                    } catch (SQLException exception) {
                        System.out.println(exception.getMessage());

                    }
                } catch (NumberFormatException exception) {
                    errorLabel.setText(exception.getMessage());
                }
            }
        });
        backButton.setOnAction(e -> deletionScene(primaryStage));

        primaryStage.setScene(deleteCustomerScene);
        primaryStage.setTitle("Delete Customer");
        primaryStage.show();
    }

    public static void deleteTrain(Stage primaryStage) {
        Label idLabel = new Label("Train ID ");
        idLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        idLabel.setStyle("-fx-background-color: #3CB371;");
        TextField idField = new TextField();
        idField.setPromptText("Enter the id of the train you want to delete");
        idField.setMaxWidth(300);

        Label errorLabel = new Label();
        errorLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        errorLabel.setStyle("-fx-background-color: #FA8072;");

        Button submitButton = new Button("DELETE");
        Button show = new Button("SHOW");
        Button backButton = new Button("BACK");

        ImageView deleteView = new ImageView(new Image("https://img.icons8.com/clouds/1x/delete-forever.png"));
        deleteView.setFitWidth(50);
        deleteView.setFitHeight(50);
        submitButton.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        deleteView.setStyle("-fx-background-color: #3CB371");
        submitButton.setGraphic(deleteView);

        ImageView showView = new ImageView(new Image("https://img.icons8.com/bubbles/256/monitor.png"));
        showView.setFitWidth(50);
        showView.setFitHeight(50);
        show.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        showView.setStyle("-fx-background-color: #3CB371");
        show.setGraphic(showView);

        ImageView backView = new ImageView(new Image("https://img.icons8.com/clouds/1x/reply-arrow.png"));
        backView.setFitWidth(50);
        backView.setFitHeight(50);
        backButton.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        backView.setStyle("-fx-background-color: #3CB371");
        backButton.setGraphic(backView);

        HBox hBox = new HBox(15);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(submitButton, show, backButton);

        TextArea textArea = new TextArea();
        textArea.setMaxWidth(600);

        VBox layout = new VBox(20);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(idLabel, idField, hBox, errorLabel, textArea);
        layout.setAlignment(Pos.CENTER);
        Scene deleteTrainScene = new Scene(layout, 1600, 900);
        layout.setStyle("-fx-background-color: #ADD8E6");

        show.setOnAction(e -> {
            if (idField.getText().isEmpty())
                errorLabel.setText("You must enter the train id first!");
            else {
                String id = idField.getText();
                try {
                    int train_id = Integer.parseInt(id);
                    try {
                        String query = "SELECT has_trains.train_id, has_trains.leave_time, has_trains.capacity,has_trains.cost, has_trains.source_location, has_trains.destination_location, station.name " +
                                "FROM has_trains ,station where has_trains.station_id = station.station_id AND has_trains.train_id = ?";
                        try (PreparedStatement stmt = connection.prepareStatement(query)) {
                            stmt.setInt(1, train_id);
                            ResultSet rs = stmt.executeQuery();
                            if (!rs.next()) {
                                errorLabel.setText("Error: Train with ID " + train_id + " not found.");
                            } else {
                                textArea.setText("\nTrain ID: " + rs.getInt("train_id"));
                                textArea.appendText("\nLeave Time: " + rs.getTimestamp("leave_time"));
                                textArea.appendText("\nCapacity: " + rs.getInt("capacity"));
                                textArea.appendText("\nCost: " + rs.getInt("cost"));
                                textArea.appendText("\nSource Location: " + rs.getString("source_location"));
                                textArea.appendText("\nDestination Location: " + rs.getString("destination_location"));
                                textArea.appendText("\nStation Name: " + rs.getString("name"));
                            }
                        }
                    } catch (SQLException exception) {
                        errorLabel.setText(exception.getMessage());
                    }
                } catch (NumberFormatException exception) {
                    errorLabel.setText("Input ID must be integer");
                }
            }
        });
        submitButton.setOnAction(e -> {
            String id = idField.getText();
            if (id.isEmpty())
                errorLabel.setText("You must enter the train id first!");
            else {
                try {
                    int train_id = Integer.parseInt(id);
                    try {
                        connection.setAutoCommit(false);
                        String sql = "DELETE FROM has_trains WHERE train_id = ?";
                        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                            stmt.setInt(1, train_id);
                            int rowsDeleted = stmt.executeUpdate();
                            if (rowsDeleted > 0) {
                                errorLabel.setText("Train deleted successfully.");
                                connection.commit();
                            } else {
                                errorLabel.setText("No matching train found");
                            }
                        }
                    } catch (SQLException exception) {
                        System.out.println(exception.getMessage());

                    }
                } catch (NumberFormatException exception) {
                    errorLabel.setText(exception.getMessage());
                }
            }
        });
        backButton.setOnAction(e -> deletionScene(primaryStage));

        primaryStage.setScene(deleteTrainScene);
        primaryStage.setTitle("Delete Train");
        primaryStage.show();
    }


    public static void deleteTicket(Stage primaryStage) {
        Label idLabel = new Label("Ticket ID ");
        idLabel.setStyle("-fx-background-color: #3CB371;");
        idLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        TextField idField = new TextField();
        idField.setPromptText("Enter the id of the ticket you want to delete");
        idField.setMaxWidth(300);

        Label errorLabel = new Label();
        errorLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        errorLabel.setStyle("-fx-background-color: #FA8072;");

        Button submitButton = new Button("DELETE");
        Button show = new Button("SHOW");
        Button backButton = new Button("BACK");

        ImageView deleteView = new ImageView(new Image("https://img.icons8.com/clouds/1x/delete-forever.png"));
        deleteView.setFitWidth(50);
        deleteView.setFitHeight(50);
        submitButton.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        deleteView.setStyle("-fx-background-color: #3CB371");
        submitButton.setGraphic(deleteView);

        ImageView showView = new ImageView(new Image("https://img.icons8.com/bubbles/256/monitor.png"));
        showView.setFitWidth(50);
        showView.setFitHeight(50);
        show.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        showView.setStyle("-fx-background-color: #3CB371");
        show.setGraphic(showView);

        ImageView backView = new ImageView(new Image("https://img.icons8.com/clouds/1x/reply-arrow.png"));
        backView.setFitWidth(50);
        backView.setFitHeight(50);
        backButton.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        backView.setStyle("-fx-background-color: #3CB371");
        backButton.setGraphic(backView);

        HBox hBox = new HBox(15);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(submitButton, show, backButton);

        TextArea textArea = new TextArea();
        textArea.setMaxWidth(600);

        VBox layout = new VBox(20);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(idLabel, idField, hBox, errorLabel, textArea);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #ADD8E6");
        Scene deleteTicketScene = new Scene(layout, 1600, 900);

        show.setOnAction(e -> {
            if (idField.getText().isEmpty())
                errorLabel.setText("You must enter the ticket id first!");
            else {
                String id = idField.getText();
                try {
                    int ticket_id = Integer.parseInt(id);
                    try {
                        String query = "SELECT t.ticket_id, t.seat_number, h.cost, h.source_location, h.destination_location " +
                                "FROM tickets_for t, has_trains h where t.train_id = h.train_id AND t.ticket_id = ?";
                        try (PreparedStatement stmt = connection.prepareStatement(query)) {
                            stmt.setInt(1, ticket_id);
                            ResultSet rs = stmt.executeQuery();
                            if (!rs.next()) {
                                errorLabel.setText("Error: Ticket with ID " + ticket_id + " not found.");
                            } else {
                                textArea.setText("\nTicket ID: " + rs.getInt("ticket_id"));
                                textArea.appendText("\nSeat Number : " + rs.getInt("seat_number"));
                                textArea.appendText("\nCost : " + rs.getFloat("cost"));
                                textArea.appendText("\nSource Location: " + rs.getString("source_location"));
                                textArea.appendText("\nDestination Location: " + rs.getString("destination_location"));
                            }
                        }
                    } catch (SQLException exception) {
                        errorLabel.setText(exception.getMessage());
                    }
                } catch (NumberFormatException exception) {
                    errorLabel.setText("Input ID must be integer");
                }
            }
        });
        submitButton.setOnAction(e -> {
            String id = idField.getText();
            if (id.isEmpty())
                errorLabel.setText("You must enter the ticket id first!");
            else {
                try {
                    int ticket_id = Integer.parseInt(id);
                    try {
                        connection.setAutoCommit(false);
                        String sql = "DELETE FROM tickets_for WHERE ticket_id = ?";
                        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                            stmt.setInt(1, ticket_id);
                            int rowsDeleted = stmt.executeUpdate();
                            if (rowsDeleted > 0) {
                                errorLabel.setText("Ticket deleted successfully.");
                                connection.commit();
                            } else {
                                errorLabel.setText("No matching Tickets found");
                            }
                        }
                    } catch (SQLException exception) {
                        System.out.println(exception.getMessage());

                    }
                } catch (NumberFormatException exception) {
                    errorLabel.setText(exception.getMessage());
                }
            }
        });
        backButton.setOnAction(e -> deletionScene(primaryStage));

        primaryStage.setScene(deleteTicketScene);
        primaryStage.setTitle("Delete Ticket");
        primaryStage.show();
    }

    public static void deleteStation(Stage primaryStage) {
        Label idLabel = new Label("Station ID ");
        idLabel.setStyle("-fx-background-color: #3CB371;");
        idLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        TextField idField = new TextField();
        idField.setPromptText("Enter the id of the train you want to delete");
        idField.setMaxWidth(300);

        Label errorLabel = new Label();
        errorLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        errorLabel.setStyle("-fx-background-color: #FA8072;");

        Button submitButton = new Button("DELETE");
        Button show = new Button("SHOW");
        Button backButton = new Button("BACK");

        ImageView deleteView = new ImageView(new Image("https://img.icons8.com/clouds/1x/delete-forever.png"));
        deleteView.setFitWidth(50);
        deleteView.setFitHeight(50);
        submitButton.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        deleteView.setStyle("-fx-background-color: #3CB371");
        submitButton.setGraphic(deleteView);

        ImageView showView = new ImageView(new Image("https://img.icons8.com/bubbles/256/monitor.png"));
        showView.setFitWidth(50);
        showView.setFitHeight(50);
        show.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        showView.setStyle("-fx-background-color: #3CB371");
        show.setGraphic(showView);

        ImageView backView = new ImageView(new Image("https://img.icons8.com/clouds/1x/reply-arrow.png"));
        backView.setFitWidth(50);
        backView.setFitHeight(50);
        backButton.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        backView.setStyle("-fx-background-color: #3CB371");
        backButton.setGraphic(backView);

        HBox hBox = new HBox(15);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(submitButton, show, backButton);

        TextArea textArea = new TextArea();
        textArea.setMaxWidth(600);

        VBox layout = new VBox(20);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(idLabel, idField, hBox, errorLabel, textArea);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #ADD8E6");
        Scene deleteStationScene = new Scene(layout, 1600, 900);

        show.setOnAction(e -> {
            if (idField.getText().isEmpty())
                errorLabel.setText("You must enter the customer id first!");
            else {
                String id = idField.getText();
                try {
                    int station_id = Integer.parseInt(id);
                    try {
                        String query = "SELECT s.station_id, s.name, s.location , s.trains_count " +
                                "FROM station s where s.station_id = ?";
                        try (PreparedStatement stmt = connection.prepareStatement(query)) {
                            stmt.setInt(1, station_id);
                            ResultSet rs = stmt.executeQuery();
                            if (!rs.next()) {
                                errorLabel.setText("Error: Station with ID " + station_id + " not found.");
                            } else {
                                textArea.setText("\nStation ID: " + rs.getInt("station_id"));
                                textArea.appendText("\nName: " + rs.getString("name"));
                                textArea.appendText("\nLocation: " + rs.getString("location"));
                                textArea.appendText("\nNumber Of Trains: " + rs.getInt("trains_count"));
                            }
                        }
                    } catch (SQLException exception) {
                        errorLabel.setText(exception.getMessage());
                    }
                } catch (NumberFormatException exception) {
                    errorLabel.setText("Input ID must be integer");
                }
            }
        });
        submitButton.setOnAction(e -> {
            String id = idField.getText();
            if (id.isEmpty())
                errorLabel.setText("You must enter the train id first!");
            else {
                try {
                    int station_id = Integer.parseInt(id);
                    try {
                        connection.setAutoCommit(false);
                        String sql = "DELETE FROM station WHERE station_id = ?";
                        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                            stmt.setInt(1, station_id);
                            int rowsDeleted = stmt.executeUpdate();
                            if (rowsDeleted > 0) {
                                errorLabel.setText("Station deleted successfully.");
                                connection.commit();
                            } else {
                                errorLabel.setText("No matching Station found");
                            }
                        }
                    } catch (SQLException exception) {
                        System.out.println(exception.getMessage());
                    }
                } catch (NumberFormatException exception) {
                    errorLabel.setText(exception.getMessage());
                }
            }
        });
        backButton.setOnAction(e -> deletionScene(primaryStage));

        primaryStage.setScene(deleteStationScene);
        primaryStage.setTitle("Delete Station");
        primaryStage.show();
    }

    public static void deleteReserve(Stage primaryStage) {
        Label customerIdLabel = new Label("Customer ID:");
        customerIdLabel.setStyle("-fx-background-color: #3CB371;");
        customerIdLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        TextField customerIdField = new TextField();
        Label ticketIdLabel = new Label("Ticket ID:");
        ticketIdLabel.setStyle("-fx-background-color: #3CB371;");
        ticketIdLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        TextField ticketIdField = new TextField();

        Label errorLabel = new Label();
        errorLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 10));
        errorLabel.setStyle("-fx-background-color: #FA8072;");

        Button deleteButton = new Button("DELETE");
        Button show = new Button("SHOW");
        Button backButton = new Button("BACK");

        ImageView deleteView = new ImageView(new Image("https://img.icons8.com/clouds/1x/delete-forever.png"));
        deleteView.setFitWidth(50);
        deleteView.setFitHeight(50);
        deleteButton.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        deleteView.setStyle("-fx-background-color: #3CB371");
        deleteButton.setGraphic(deleteView);

        ImageView showView = new ImageView(new Image("https://img.icons8.com/bubbles/256/monitor.png"));
        showView.setFitWidth(50);
        showView.setFitHeight(50);
        show.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        showView.setStyle("-fx-background-color: #3CB371");
        show.setGraphic(showView);

        ImageView backView = new ImageView(new Image("https://img.icons8.com/clouds/1x/reply-arrow.png"));
        backView.setFitWidth(50);
        backView.setFitHeight(50);
        backButton.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        backView.setStyle("-fx-background-color: #3CB371");
        backButton.setGraphic(backView);

        HBox hBox = new HBox(15);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(deleteButton, show, backButton);

        TextArea infoArea = new TextArea();
        infoArea.setMaxWidth(600);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.add(customerIdLabel, 0, 0);
        grid.add(customerIdField, 1, 0);
        grid.add(ticketIdLabel, 0, 1);
        grid.add(ticketIdField, 1, 1);
        VBox vBox = new VBox(10);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(grid, hBox, errorLabel, infoArea);
        grid.setAlignment(Pos.CENTER);
        vBox.setStyle("-fx-background-color: #ADD8E6");

        deleteButton.setOnAction(e -> {
            String customerIdText = customerIdField.getText();
            String ticketIdText = ticketIdField.getText();
            if (customerIdText.isEmpty() || ticketIdText.isEmpty()) {
                errorLabel.setText("Error: Please fill in the customer ID and ticket ID fields.");
                return;
            }
            try {
                int customerId = Integer.parseInt(customerIdText);
                int ticketId = Integer.parseInt(ticketIdText);
                connection.setAutoCommit(false);
                String sql = "DELETE FROM reserve WHERE c_id = ? AND ticket_id = ?";
                try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                    stmt.setInt(1, customerId);
                    stmt.setInt(2, ticketId);
                    int rowsDeleted = stmt.executeUpdate();
                    if (rowsDeleted > 0) {
                        errorLabel.setText("Reserve deleted successfully.");
                        connection.commit();
                    } else {
                        errorLabel.setText("No matching Reserve found");
                    }
                }
            } catch (NumberFormatException ex) {
                errorLabel.setText("Error: Invalid customer ID or ticket ID.");
            } catch (SQLException ex) {
                errorLabel.setText(ex.getMessage());
            }
        });

        show.setOnAction(e -> {
            String customerIdText = customerIdField.getText();
            String ticketIdText = ticketIdField.getText();
            if (customerIdText.isEmpty() || ticketIdText.isEmpty()) {
                errorLabel.setText("Error: Please fill in the customer ID and ticket ID fields.");
                return;
            }
            try {
                int customerId = Integer.parseInt(customerIdText);
                int ticketId = Integer.parseInt(ticketIdText);
                connection.setAutoCommit(false);
                String sql = "SELECT c.c_id, c.name, " +
                        "t.ticket_id, t.seat_number," +
                        "h.train_id, h.cost, h.leave_time, h.source_location, h.destination_location " +
                        "FROM reserve r " +
                        "JOIN customers c ON c.c_id = r.c_id " +
                        "JOIN tickets_for t ON t.ticket_id = r.ticket_id " +
                        "JOIN has_trains h ON h.train_id = r.train_id " +
                        "WHERE r.c_id = ? AND r.ticket_id = ?";
                try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                    stmt.setInt(1, customerId);
                    stmt.setInt(2, ticketId);
                    ResultSet rs = stmt.executeQuery();
                    if (!rs.next()) {
                        errorLabel.setText("Error: No matched reserve found.");
                    } else {
                        infoArea.setText("\nCustomer ID: " + rs.getInt("c_id"));
                        infoArea.appendText("\nCustomer Name: " + rs.getString("name"));
                        infoArea.appendText("\nTicket ID: " + rs.getInt("ticket_id"));
                        infoArea.appendText("\nSeat Number: " + rs.getInt("seat_number"));
                        infoArea.appendText("\nTrain ID: " + rs.getInt("train_id"));
                        infoArea.appendText("\nCost: " + rs.getDouble("cost"));
                        infoArea.appendText("\nLeave Time: " + rs.getTimestamp("leave_time"));
                        infoArea.appendText("\nSource Location: " + rs.getString("source_location"));
                        infoArea.appendText("\nDestination Location: " + rs.getString("destination_location"));
                    }
                }
            } catch (SQLException ex) {
                errorLabel.setText(ex.getMessage());
            } catch (NumberFormatException ex) {
                errorLabel.setText("Error: Invalid customer ID or ticket ID.");
            }
        });

        backButton.setOnAction(e -> deletionScene(primaryStage));

        Scene cancelReserveScene = new Scene(vBox, 1600, 900);
        primaryStage.setScene(cancelReserveScene);
        primaryStage.setTitle("Cancel Reserve");
        primaryStage.show();
    }

    public static void insertionScene(Stage primaryStage) {
        Button insertCustomerButton = new Button("Insert Customer");
        insertCustomerButton.setPrefSize(500, 60);
        insertCustomerButton.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));
        insertCustomerButton.setAlignment(Pos.CENTER);
        insertCustomerButton.setStyle("-fx-background-color: #9ACD32");
        ImageView customerView = new ImageView(new Image("https://img.icons8.com/clouds/1x/gender-neutral-user.png"));
        customerView.setFitHeight(50);
        customerView.setFitWidth(50);
        insertCustomerButton.setGraphic(customerView);

        Button insertStationButton = new Button("Insert Station");
        insertStationButton.setPrefSize(500, 60);
        insertStationButton.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));
        insertStationButton.setAlignment(Pos.CENTER);
        insertStationButton.setStyle("-fx-background-color: #9ACD32");
        ImageView stationView = new ImageView(new Image("https://img.icons8.com/office/1x/switch-tracks.png"));
        stationView.setFitHeight(50);
        stationView.setFitWidth(50);
        insertStationButton.setGraphic(stationView);

        Button insertTrainButton = new Button("Insert Train");
        insertTrainButton.setPrefSize(500, 60);
        insertTrainButton.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));
        insertTrainButton.setAlignment(Pos.CENTER);
        insertTrainButton.setStyle("-fx-background-color: #9ACD32");
        ImageView trainView = new ImageView(new Image("https://img.icons8.com/clouds/1x/train.png"));
        trainView.setFitHeight(50);
        trainView.setFitWidth(50);
        insertTrainButton.setGraphic(trainView);

        Button insertReserveButton = new Button("Insert Reserve");
        insertReserveButton.setPrefSize(500, 60);
        insertReserveButton.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));
        insertReserveButton.setAlignment(Pos.CENTER);
        insertReserveButton.setStyle("-fx-background-color: #9ACD32");
        ImageView reserveView = new ImageView(new Image("https://img.icons8.com/fluency/1x/reservation-2--v2.png"));
        reserveView.setFitWidth(50);
        reserveView.setFitHeight(50);
        insertReserveButton.setGraphic(reserveView);

        Button insertTicketButton = new Button("Insert Ticket");
        insertTicketButton.setPrefSize(500, 60);
        insertTicketButton.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));
        insertTicketButton.setAlignment(Pos.CENTER);
        insertTicketButton.setStyle("-fx-background-color: #9ACD32");
        ImageView ticketView = new ImageView(new Image("https://img.icons8.com/bubbles/256/ticket.png"));
        ticketView.setFitHeight(50);
        ticketView.setFitWidth(50);
        insertTicketButton.setGraphic(ticketView);

        Button backButton = new Button("Back");
//        backButton.setPrefSize(500, 60);
        backButton.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));
        backButton.setAlignment(Pos.CENTER);
        ImageView backView = new ImageView(new Image("https://img.icons8.com/clouds/1x/reply-arrow.png"));
        backView.setFitHeight(50);
        backView.setFitWidth(50);
        backButton.setGraphic(backView);
//        backButton.setStyle("-fx-background-color: #FF80E6");

        VBox insertInterfaceLayout = new VBox(20);
        insertInterfaceLayout.setStyle("-fx-background-color: #ADD8E6");
        insertInterfaceLayout.setPadding(new Insets(20));
        insertInterfaceLayout.getChildren().addAll(insertCustomerButton, insertStationButton, insertTrainButton,
                insertReserveButton, insertTicketButton, backButton);
        insertInterfaceLayout.setAlignment(Pos.CENTER);
        Scene insertInterfaceScene = new Scene(insertInterfaceLayout, 1600, 900);

        insertCustomerButton.setOnAction(e -> insertCustomerScene(primaryStage));

        // Create button for inserting station
        insertStationButton.setOnAction(e -> insertStationScene(primaryStage));
        insertTicketButton.setOnAction(e -> insertTicketScene(primaryStage));
        insertTrainButton.setOnAction(e -> insertTrainScene(primaryStage));
        insertReserveButton.setOnAction(e -> insertReserve(primaryStage));
        backButton.setOnAction(e -> adminScene(primaryStage));

        primaryStage.setTitle("Insertion Interface");
        primaryStage.setScene(insertInterfaceScene);
        primaryStage.show();
    }

    public static void insertReserve(Stage primaryStage) {
        // Create new scene for inserting reservation
        BorderPane reserveInsertPane = new BorderPane();
        Scene reserveInsertScene = new Scene(reserveInsertPane, 1600, 900);

        // Create labels and text fields for customer id and ticket id
        Label customerIdLabel = new Label("Customer ID:");
        customerIdLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        customerIdLabel.setStyle("-fx-background-color: #3CB371;");
        TextField customerIdField = new TextField();
        customerIdField.setMaxWidth(250);

        Label ticketIdLabel = new Label("Ticket ID:");
        ticketIdLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        ticketIdLabel.setStyle("-fx-background-color: #3CB371;");
        TextField ticketIdField = new TextField();
        ticketIdField.setMaxWidth(250);

        Label errorLabel = new Label();
        errorLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 10));
//        errorLabel.setStyle("-fx-background-color: #3CB371;");
        errorLabel.setTextFill(Color.RED);

        // Create submit button for inserting reservation
        Button submitBtn = new Button("INSERT");
        Button backButton = new Button("BACK");
        ImageView insertView = new ImageView(new Image("https://img.icons8.com/clouds/1x/insert-clip.png"));
        insertView.setFitWidth(50);
        insertView.setFitHeight(50);
        submitBtn.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        insertView.setStyle("-fx-background-color: #3CB371");
        ImageView backView = new ImageView(new Image("https://img.icons8.com/clouds/1x/reply-arrow.png"));
        backView.setFitWidth(50);
        backView.setFitHeight(50);
        backButton.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        backView.setStyle("-fx-background-color: #3CB371");
        submitBtn.setGraphic(insertView);
        backButton.setGraphic(backView);

        HBox hBox = new HBox(15);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(submitBtn, backButton);

        submitBtn.setOnAction(event -> {
            String customerId = customerIdField.getText();
            String ticketId = ticketIdField.getText();

            // Validation
            if (customerId.isEmpty() || ticketId.isEmpty()) {
                errorLabel.setText("Please fill both customer ID and ticket ID fields!");
            } else {
                try {
                    int cusId = Integer.parseInt(customerId);
                    int ticId = Integer.parseInt(ticketId);
                    // Insert reservation into database
                    String sql = "select * from tickets_for where ticket_id = ?";
                    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                        connection.setAutoCommit(false);
                        stmt.setInt(1, ticId);
                        ResultSet rs = stmt.executeQuery();
                        if (rs.next()) {
                            int train_id = rs.getInt("train_id");
                            sql = "insert into reserve (c_id, ticket_id, train_id) values(?, ?, ?)";
                            try (PreparedStatement stmt2 = connection.prepareStatement(sql)) {
                                stmt2.setInt(1, cusId);
                                stmt2.setInt(2, ticId);
                                stmt2.setInt(3, train_id);
                                stmt2.executeUpdate();
                                connection.commit();
                            }
                            errorLabel.setText("Data Inserted Into Reserve Table Successfully!");
                        } else {
                            errorLabel.setText("Error: Ticket with the entered id is not available");
                        }
                    } catch (SQLIntegrityConstraintViolationException e) {
                        Alert alert = new Alert(Alert.AlertType.ERROR, "INVALID INPUTS.");
                        alert.show();
                    } catch (SQLException e) {
                        errorLabel.setText(e.getMessage());
                    }
                } catch (NumberFormatException e) {
                    // If the input is not a valid integer, show an error message
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Input must be a valid integer.");
                    alert.show();
                }
            }
        });
        backButton.setOnAction(event2 -> insertionScene(primaryStage));

        // Add labels, text fields, and submit button to the reservation insert scene
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.getChildren().addAll(customerIdLabel, customerIdField, ticketIdLabel, ticketIdField, errorLabel, hBox);
        vbox.setAlignment(Pos.CENTER);
        reserveInsertPane.setCenter(vbox);
        reserveInsertPane.setStyle("-fx-background-color: #FFE4E1");

        // Show the reservation insert scene
        primaryStage.setTitle("Insert Reservation");
        primaryStage.setScene(reserveInsertScene);
        primaryStage.show();
    }

    private static void insertTicketScene(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(10));
        grid.setAlignment(Pos.CENTER);

        Label lblTicketId = new Label("Ticket ID:");
        lblTicketId.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        lblTicketId.setStyle("-fx-background-color: #3CB371;");
        TextField txtTicketId = new TextField();
        txtTicketId.setMaxWidth(50);

        Label lblSeatNumber = new Label("Seat Number:");
        lblSeatNumber.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        lblSeatNumber.setStyle("-fx-background-color: #3CB371;");
        TextField txtSeatNumber = new TextField();
        txtSeatNumber.setMaxWidth(250);

        Label lblTrainId = new Label("Train ID:");
        lblTrainId.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        lblTrainId.setStyle("-fx-background-color: #3CB371;");
        TextField txtTrainId = new TextField();
        txtTrainId.setMaxWidth(250);

        Button submitBtn = new Button("INSERT");
        Button backButton = new Button("BACK");
        ImageView insertView = new ImageView(new Image("https://img.icons8.com/clouds/1x/insert-clip.png"));
        insertView.setFitWidth(50);
        insertView.setFitHeight(50);
        submitBtn.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        insertView.setStyle("-fx-background-color: #3CB371");
        ImageView backView = new ImageView(new Image("https://img.icons8.com/clouds/1x/reply-arrow.png"));
        backView.setFitWidth(50);
        backView.setFitHeight(50);
        backButton.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        backView.setStyle("-fx-background-color: #3CB371");
        submitBtn.setGraphic(insertView);
        backButton.setGraphic(backView);

        HBox hBox = new HBox(15);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(submitBtn, backButton);


        grid.add(lblTicketId, 0, 0);
        grid.add(txtTicketId, 1, 0);
        grid.add(lblSeatNumber, 0, 1);
        grid.add(txtSeatNumber, 1, 1);
        grid.add(lblTrainId, 0, 2);
        grid.add(txtTrainId, 1, 2);
        grid.add(hBox, 1, 3);

        grid.setStyle("-fx-background-color: #FFE4E1");
        submitBtn.setOnAction(event -> {
            try {
                int ticketId = Integer.parseInt(txtTicketId.getText());
                int seatNumber = Integer.parseInt(txtSeatNumber.getText());
                int trainId = Integer.parseInt(txtTrainId.getText());
                try {
                    connection.setAutoCommit(false);
                    String sql = "INSERT INTO tickets_for (ticket_id, seat_number, train_id) VALUES (?,?,?)";
                    try (PreparedStatement stmt3 = connection.prepareStatement(sql)) {
                        stmt3.setInt(1, ticketId);
                        stmt3.setInt(2, seatNumber);
                        stmt3.setInt(3, trainId);
                        stmt3.executeUpdate();
                    }
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Ticket inserted successfully.");
                    alert.show();
                    connection.commit();
                } catch (SQLIntegrityConstraintViolationException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "INVALID ID INPUTS");
                    alert.show();
                } catch (SQLException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage());
                    alert.show();
                }
            } catch (NumberFormatException e) {
                // If the input is not a valid integer, show an error message
                Alert alert = new Alert(Alert.AlertType.ERROR, "Input must be a valid Numbers.");
                alert.show();
            }
        });
        backButton.setOnAction(event2 -> insertionScene(primaryStage));
        Scene scene = new Scene(grid, 1600, 900);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void insertTrainScene(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Label trainIdLabel = new Label("Train ID:");
        trainIdLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        trainIdLabel.setStyle("-fx-background-color: #3CB371;");
        grid.add(trainIdLabel, 0, 1);
        TextField trainIdField = new TextField();
        trainIdField.setMaxWidth(250);
        grid.add(trainIdField, 1, 1);

        Label stationIdLabel = new Label("Station ID:");
        stationIdLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        stationIdLabel.setStyle("-fx-background-color: #3CB371;");
        grid.add(stationIdLabel, 0, 2);
        TextField stationIdField = new TextField();
        stationIdField.setMaxWidth(250);
        grid.add(stationIdField, 1, 2);

        Label capacityLabel = new Label("Capacity:");
        capacityLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        capacityLabel.setStyle("-fx-background-color: #3CB371;");
        grid.add(capacityLabel, 0, 3);
        TextField capacityField = new TextField();
        capacityField.setMaxWidth(250);
        grid.add(capacityField, 1, 3);

        Label costLabel = new Label("Ticket Cost:");
        costLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        costLabel.setStyle("-fx-background-color: #3CB371;");
        grid.add(costLabel, 0, 4);
        TextField costField = new TextField();
        costField.setMaxWidth(250);
        grid.add(costField, 1, 4);

        Label leaveTimeLabel = new Label("Leave Time (yyyy-mm-dd hh:mm:ss):");
        leaveTimeLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        leaveTimeLabel.setStyle("-fx-background-color: #3CB371;");
        grid.add(leaveTimeLabel, 0, 5);
        TextField leaveTimeField = new TextField();
        leaveTimeField.setMaxWidth(250);
        grid.add(leaveTimeField, 1, 5);

        Label sourceLocationLabel = new Label("Source Location:");
        sourceLocationLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        sourceLocationLabel.setStyle("-fx-background-color: #3CB371;");
        grid.add(sourceLocationLabel, 0, 6);
        TextField sourceLocationField = new TextField();
        sourceLocationField.setMaxWidth(250);
        grid.add(sourceLocationField, 1, 6);

        Label destinationLocationLabel = new Label("Destination Location:");
        destinationLocationLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        destinationLocationLabel.setStyle("-fx-background-color: #3CB371;");
        grid.add(destinationLocationLabel, 0, 7);
        TextField destinationLocationField = new TextField();
        destinationLocationField.setMaxWidth(250);
        grid.add(destinationLocationField, 1, 7);

        HBox submitBackHBox = new HBox(10);
        submitBackHBox.setAlignment(Pos.BOTTOM_RIGHT);

        Button submitBtn = new Button("INSERT");
        Button backButton = new Button("BACK");
        ImageView insertView = new ImageView(new Image("https://img.icons8.com/clouds/1x/insert-clip.png"));
        insertView.setFitWidth(50);
        insertView.setFitHeight(50);
        submitBtn.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        insertView.setStyle("-fx-background-color: #3CB371");
        ImageView backView = new ImageView(new Image("https://img.icons8.com/clouds/1x/reply-arrow.png"));
        backView.setFitWidth(50);
        backView.setFitHeight(50);
        backButton.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        backView.setStyle("-fx-background-color: #3CB371");
        submitBtn.setGraphic(insertView);
        backButton.setGraphic(backView);
        submitBackHBox.getChildren().addAll(submitBtn, backButton);
        grid.add(submitBackHBox, 1, 8);

        submitBtn.setOnAction(event -> {
            int train_id;
            try {
                train_id = Integer.parseInt(trainIdField.getText());
            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid train ID. It should be an integer.");
                alert.show();
                return;
            }
            int station_id;
            try {
                station_id = Integer.parseInt(stationIdField.getText());
            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid station ID. It should be an integer.");
                alert.show();
                return;
            }
            int capacity;
            try {
                capacity = Integer.parseInt(capacityField.getText());
            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid capacity. It should be an integer.");
                alert.show();
                return;
            }
            float cost;
            try {
                cost = Float.parseFloat(costField.getText());
            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid cost. It should be a float value.");
                alert.show();
                return;
            }
            String leave_time = leaveTimeField.getText();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            sdf.setLenient(false);
            try {
                sdf.parse(leave_time);
            } catch (ParseException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid leave time format. Please use the correct format: yyyy-MM-dd HH:mm:ss");
                alert.show();
            }
            String source_location = sourceLocationField.getText();
            if (source_location.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Source location cannot be empty.");
                alert.show();
                return;
            }
            String dest_location = destinationLocationField.getText();
            if (dest_location.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Destination location cannot be empty.");
                alert.show();
                return;
            }
            String sql = "INSERT INTO has_trains (train_id, station_id, capacity, cost, leave_time, source_location, destination_location) VALUES (?,?,?,?,?,?,?)";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                connection.setAutoCommit(false);
                stmt.setInt(1, train_id);
                stmt.setInt(2, station_id);
                stmt.setInt(3, capacity);
                stmt.setFloat(4, cost);
                stmt.setString(5, leave_time);
                stmt.setString(6, source_location);
                stmt.setString(7, dest_location);
                stmt.executeUpdate();
                connection.commit();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Ticket inserted successfully.");
                alert.show();
            } catch (SQLIntegrityConstraintViolationException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "INVALID ID INPUTS");
                alert.show();
            } catch (SQLException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage());
                alert.show();
            }
        });

        backButton.setOnAction(event2 -> insertionScene(primaryStage));
        grid.setStyle("-fx-background-color: #FFE4E1;");
        Scene trainScene = new Scene(grid, 1600, 900);
        primaryStage.setTitle("Insert Train");
        primaryStage.setScene(trainScene);
        primaryStage.show();
    }

    public static void insertCustomerScene(Stage primaryStage) {

        Label customerIdLabel = new Label("Customer ID:");
        customerIdLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        customerIdLabel.setStyle("-fx-background-color: #3CB371;");
        TextField customerIdField = new TextField();
        customerIdField.setMaxWidth(200);

        Label customerNameLabel = new Label("Customer Name:");
        customerNameLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        customerNameLabel.setStyle("-fx-background-color: #3CB371;");
        TextField customerNameField = new TextField();
        customerNameField.setMaxWidth(200);

        Label customerPhoneLabel = new Label("Customer Phone:");
        customerPhoneLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        customerPhoneLabel.setStyle("-fx-background-color: #3CB371;");
        TextField customerPhoneField = new TextField();
        customerPhoneField.setMaxWidth(200);

        Label customerAddressLabel = new Label("Customer Address:");
        customerAddressLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        customerAddressLabel.setStyle("-fx-background-color: #3CB371;");
        TextField customerAddressField = new TextField();
        customerAddressField.setMaxWidth(200);

        Label errorLabel = new Label();
        customerAddressLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        customerAddressLabel.setStyle("-fx-background-color: #3CB371;");

        Button submitBtn = new Button("INSERT");
        Button backButton = new Button("BACK");
        ImageView insertView = new ImageView(new Image("https://img.icons8.com/clouds/1x/insert-clip.png"));
        insertView.setFitWidth(50);
        insertView.setFitHeight(50);
        submitBtn.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        insertView.setStyle("-fx-background-color: #3CB371");
        ImageView backView = new ImageView(new Image("https://img.icons8.com/clouds/1x/reply-arrow.png"));
        backView.setFitWidth(50);
        backView.setFitHeight(50);
        backButton.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        backView.setStyle("-fx-background-color: #3CB371");
        submitBtn.setGraphic(insertView);
        backButton.setGraphic(backView);

        HBox hBox = new HBox(50);
        hBox.getChildren().addAll(submitBtn, backButton);
        hBox.setAlignment(Pos.CENTER);

        submitBtn.setOnAction(event -> {
            int id;
            try {
                id = Integer.parseInt(customerIdField.getText());
            } catch (NumberFormatException e) {
                errorLabel.setText("Invalid customer ID");
                return;
            }
            String name = customerNameField.getText();
            if (name.isEmpty()) {
                errorLabel.setText("Customer name cannot be empty");
                return;
            }
            try {
                double nameAsNumber = Double.parseDouble(name);
                errorLabel.setText("Customer name must be a Text, not a number");
                return;
            } catch (NumberFormatException e) {
                // entered data is a string
            }
            String phone = customerPhoneField.getText();
            if (phone.isEmpty()) {
                errorLabel.setText("Customer phone cannot be empty");
                return;
            }
            String address = customerAddressField.getText();
            if (address.isEmpty()) {
                errorLabel.setText("Customer address cannot be empty");
                return;
            }
            try {
                double addressAsNumber = Double.parseDouble(address);
                errorLabel.setText("Customer address must be a Text, not a number");
                return;
            } catch (NumberFormatException e) {
                // entered data is a string
            }
            try {
                String sql = "INSERT INTO customers (c_id, name, phone_number, address) VALUES (?,?,?,?)";
                try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                    connection.setAutoCommit(false);
                    stmt.setInt(1, id);
                    stmt.setString(2, name);
                    stmt.setString(3, phone);
                    stmt.setString(4, address);
                    stmt.executeUpdate();
                    errorLabel.setText("Data inserted into Customers table successfully");
                    connection.commit();
                } catch (SQLIntegrityConstraintViolationException ex) {
                    connection.rollback();
                    errorLabel.setText("Error: Customer ID already exists");
                } catch (SQLException ex) {
                    errorLabel.setText(ex.getMessage());
                }
            } catch (SQLException exception) {
                errorLabel.setText(exception.getMessage());
            }
        });

        backButton.setOnAction(e -> insertionScene(primaryStage));

        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10));
        vbox.getChildren().addAll(customerIdLabel, customerIdField, customerNameLabel, customerNameField,
                customerPhoneLabel, customerPhoneField, customerAddressLabel, customerAddressField, hBox, errorLabel);
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-background-color: #FFE4E1;");
        Scene customerScene = new Scene(vbox, 1600, 900);
        primaryStage.setTitle("Insert Customer");
        primaryStage.setScene(customerScene);
        primaryStage.show();
    }

    public static void insertStationScene(Stage primaryStage) {

        Label stationNameLabel = new Label("Station Name:");
        stationNameLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        stationNameLabel.setStyle("-fx-background-color: #3CB371;");
        TextField stationNameField = new TextField();
        stationNameField.setMaxWidth(250);

        Label stationLocationLabel = new Label("Station Location:");
        stationLocationLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        stationLocationLabel.setStyle("-fx-background-color: #3CB371;");
        TextField stationLocationField = new TextField();
        stationLocationField.setMaxWidth(250);

        Label stationIdLabel = new Label("Station ID:");
        stationIdLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        stationIdLabel.setStyle("-fx-background-color: #3CB371;");
        TextField stationIdField = new TextField();
        stationIdField.setMaxWidth(250);

        Label stationCountLabel = new Label("Station Trains Count:");
        stationCountLabel.setFont(Font.font("impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
        stationCountLabel.setStyle("-fx-background-color: #3CB371;");
        TextField stationCountField = new TextField();
        stationCountField.setMaxWidth(250);

        Label errorLabel = new Label();
        errorLabel.setTextFill(Color.RED);

        Button submitBtn = new Button("INSERT");
        Button backButton = new Button("BACK");
        ImageView insertView = new ImageView(new Image("https://img.icons8.com/clouds/1x/insert-clip.png"));
        insertView.setFitWidth(50);
        insertView.setFitHeight(50);
        submitBtn.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        insertView.setStyle("-fx-background-color: #3CB371");
        ImageView backView = new ImageView(new Image("https://img.icons8.com/clouds/1x/reply-arrow.png"));
        backView.setFitWidth(50);
        backView.setFitHeight(50);
        backButton.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
        backView.setStyle("-fx-background-color: #3CB371");
        submitBtn.setGraphic(insertView);
        backButton.setGraphic(backView);

        HBox hBox = new HBox(50);
        hBox.getChildren().addAll(submitBtn, backButton);
        hBox.setAlignment(Pos.CENTER);

        submitBtn.setOnAction(event1 -> {
            String stationName = stationNameField.getText();
            String stationLocation = stationLocationField.getText();
            String stationId = stationIdField.getText();
            String stationCount = stationCountField.getText();

            if (stationName.isEmpty() || stationLocation.isEmpty() || stationId.isEmpty() || stationCount.isEmpty()) {
                errorLabel.setText("Please fill all fields!");
            } else {
                int id;
                int trains_count;
                try {
                    id = Integer.parseInt(stationId);
                    trains_count = Integer.parseInt(stationCount);
                } catch (NumberFormatException e) {
                    errorLabel.setText("Station ID and Station Trains Count must be a number!");
                    return;
                }
                try {
                    Double.parseDouble(stationName);
                    errorLabel.setText("The Name must be Text, not a numbers!");
                    return;
                } catch (NumberFormatException e) {
                    //
                }
                try {
                    Double.parseDouble(stationLocation);
                    errorLabel.setText("The Location must be Text, not a numbers!");
                    return;
                } catch (NumberFormatException e) {
                    //
                }
                try {
                    connection.setAutoCommit(false);
                    String sql = "INSERT INTO station (station_id, location, trains_count, name) VALUES (?,?,?,?)";
                    try (PreparedStatement stmt2 = connection.prepareStatement(sql)) {
                        stmt2.setInt(1, id);
                        stmt2.setString(2, stationLocation);
                        stmt2.setInt(3, trains_count);
                        stmt2.setString(4, stationName);
                        stmt2.executeUpdate();
                    }
                    connection.commit();
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Data inserted into Station table successfully");
                    alert.show();
                    errorLabel.setText("");
                } catch (SQLIntegrityConstraintViolationException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Station ID is already exist");
                    alert.show();
                } catch (SQLException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage());
                    alert.show();
                }
            }
        });


        backButton.setOnAction(event2 -> insertionScene(primaryStage));

        VBox vbox = new VBox(15);
        vbox.getChildren().addAll(
                stationIdLabel, stationIdField,
                stationNameLabel, stationNameField,
                stationLocationLabel, stationLocationField,
                stationCountLabel, stationCountField,
                hBox,
                errorLabel
        );
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-background-color: #FFE4E1;");
        Scene stationInsertScene = new Scene(vbox, 1600, 900);
        primaryStage.setTitle("Insert Station");
        primaryStage.setScene(stationInsertScene);
        primaryStage.show();
    }
}