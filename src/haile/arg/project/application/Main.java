package haile.arg.project.application;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import haile.arg.project.model.House;
import haile.arg.project.service.AddHouse;
import haile.arg.project.service.DataService;
import haile.arg.project.service.ErrorValidation;
import haile.arg.project.service.Search;
import haile.arg.project.service.Sort;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * GUI Based Home Search Engine
 * 
 * This class extends the Application class in JavaFX. It implements a JavaFX
 * based GUI that will serve as a home search engine. The engine utilises mock
 * data provided and allows for the addition of additional House to the data.
 * 
 * @author Hail Arg
 * @version 30/04/2023
 *
 */
public class Main extends Application {
  @SuppressWarnings({ "unchecked", "rawtypes" })
  @Override
  public void start(Stage primaryStage) {
    try {
      List<House> houseData = DataService.readHomedataJSON();
      TableView tableView = new TableView();

      TableColumn<Map, String> streetAddressColumn = new TableColumn<>("Street Address");
      streetAddressColumn.setCellValueFactory(new MapValueFactory<>("street_address"));
      streetAddressColumn.setPrefWidth(170);
      TableColumn<Map, String> streetSuffixColumn = new TableColumn<>("Street Suffix");
      streetSuffixColumn.setCellValueFactory(new MapValueFactory<>("street_suffix"));

      TableColumn<Map, String> cityColumn = new TableColumn<>("City");
      cityColumn.setCellValueFactory(new MapValueFactory<>("city"));
      cityColumn.setPrefWidth(110);
      TableColumn<Map, String> stateColumn = new TableColumn<>("State");
      stateColumn.setCellValueFactory(new MapValueFactory<>("state"));

      TableColumn<Map, String> zipColumn = new TableColumn<>("zip");
      zipColumn.setCellValueFactory(new MapValueFactory<>("zip"));

      TableColumn<Map, String> bedroomsColumn = new TableColumn<>("Bedrooms");
      bedroomsColumn.setCellValueFactory(new MapValueFactory<>("bedrooms"));
      bedroomsColumn.setPrefWidth(70);
      TableColumn<Map, String> bathroomsColumn = new TableColumn<>("Bathrooms");
      bathroomsColumn.setCellValueFactory(new MapValueFactory<>("bathrooms"));
      bathroomsColumn.setPrefWidth(70);
      TableColumn<Map, String> sqftColumn = new TableColumn<>("SqFt");
      sqftColumn.setCellValueFactory(new MapValueFactory<>("sqFt"));

      TableColumn<Map, String> priceColumn = new TableColumn<>("Price");
      priceColumn.setCellValueFactory(new MapValueFactory<>("price"));

      tableView.getColumns().add(streetAddressColumn);
      tableView.getColumns().add(streetSuffixColumn);
      tableView.getColumns().add(cityColumn);
      tableView.getColumns().add(stateColumn);
      tableView.getColumns().add(zipColumn);
      tableView.getColumns().add(bedroomsColumn);
      tableView.getColumns().add(bathroomsColumn);
      tableView.getColumns().add(sqftColumn);
      tableView.getColumns().add(priceColumn);

      ObservableList<Map<String, Object>> items = FXCollections.<Map<String, Object>>observableArrayList();

      Pane paneForControllers = new Pane();

      Rectangle titleBar = new Rectangle(0, 0, Screen.getPrimary().getVisualBounds().getWidth(), 50);
      titleBar.setFill(Color.LIGHTBLUE);
      titleBar.setLayoutX(0);
      titleBar.setLayoutY(0);
      paneForControllers.getChildren().add(titleBar);

      Rectangle addBox = new Rectangle(520, 50, Screen.getPrimary().getVisualBounds().getWidth() / 2, 300);
      addBox.setFill(Color.WHITE);
      addBox.setLayoutX(0);
      addBox.setLayoutY(0);
      paneForControllers.getChildren().add(addBox);

      Label selected = new Label("");
      selected.setTranslateX(210);
      selected.setTranslateY(320);
      selected.setFont(Font.font("Arial", FontWeight.BOLD, 14));
      selected.setTextFill(Color.RED);
      selected.minWidth(200);

      Label messageLabel = new Label("");
      messageLabel.setTranslateX(620);
      messageLabel.setTranslateY(330);
      messageLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
      messageLabel.setTextFill(Color.RED);
      messageLabel.minWidth(200);

      paneForControllers.getChildren().addAll(selected, messageLabel);

      String search_methods[] = { "City/State/Zip", "Bedrooms and Bathrooms", "Min/Max Price", "SqFt" };
      Text searchMethodLabelText = new Text(20, 80, "Select Search Method");
      paneForControllers.getChildren().addAll(searchMethodLabelText);

      ComboBox combo_box = new ComboBox(FXCollections.observableArrayList(search_methods));
      combo_box.setTranslateX(200);
      combo_box.setTranslateY(70);
      combo_box.setPrefWidth(300);
      paneForControllers.getChildren().add(combo_box);

      Text city_state_zip_LabelText = new Text(20, 110, "Insert City/State/Zip");
      TextField cityStateZipText = new TextField();
      cityStateZipText.setPrefWidth(300);
      cityStateZipText.setTranslateX(200);
      cityStateZipText.setTranslateY(100);
      paneForControllers.getChildren().addAll(city_state_zip_LabelText, cityStateZipText);

      Text bedroom_LabelText = new Text(20, 140, "Insert  Bedroom");
      TextField bedroomText = new TextField();
      bedroomText.setPrefWidth(100);
      bedroomText.setTranslateX(200);
      bedroomText.setTranslateY(130);

      Text bathrooms_LabelText = new Text(320, 145, "Bathrooms");
      TextField bathroomsText = new TextField();
      bathroomsText.setPrefWidth(100);
      bathroomsText.setTranslateX(400);
      bathroomsText.setTranslateY(130);

      paneForControllers.getChildren().addAll(bedroom_LabelText, bedroomText, bathrooms_LabelText, bathroomsText);

      Text min_price_LabelText = new Text(20, 170, "Min Price");
      TextField minPriceText = new TextField();
      minPriceText.setPrefWidth(100);
      minPriceText.setTranslateX(200);
      minPriceText.setTranslateY(160);

      Text max_price_LabelText = new Text(320, 170, "Max Price");
      TextField maxPriceText = new TextField();
      maxPriceText.setPrefWidth(100);
      maxPriceText.setTranslateX(400);
      maxPriceText.setTranslateY(160);
      paneForControllers.getChildren().addAll(min_price_LabelText, minPriceText, max_price_LabelText, maxPriceText);

      Text sqFt_LabelText = new Text(20, 200, "Insert  SqFt");
      TextField SqFtText = new TextField();
      SqFtText.setPrefWidth(300);
      SqFtText.setTranslateX(200);
      SqFtText.setTranslateY(190);
      paneForControllers.getChildren().addAll(sqFt_LabelText, SqFtText);

      Button btnSearch = new Button("Search");
      btnSearch.setPrefWidth(130);
      btnSearch.setTranslateX(200);
      btnSearch.setTranslateY(250);
      paneForControllers.getChildren().addAll(btnSearch);

      Button btnExport = new Button("Export to CSV");
      btnExport.setPrefWidth(130);
      btnExport.setTranslateX(370);
      btnExport.setTranslateY(250);
      paneForControllers.getChildren().addAll(btnExport);

      Text streetAddressAddLabelText = new Text(550, 80, "Street Address");
      TextField streetAddressAddText = new TextField();
      streetAddressAddText.setPrefWidth(250);
      streetAddressAddText.setTranslateX(650);
      streetAddressAddText.setTranslateY(70);
      paneForControllers.getChildren().addAll(streetAddressAddLabelText, streetAddressAddText);

      Text streetSuffixAddLabelText = new Text(550, 110, "street Suffix");
      TextField streetSuffixAddText = new TextField();
      streetSuffixAddText.setPrefWidth(250);
      streetSuffixAddText.setTranslateX(650);
      streetSuffixAddText.setTranslateY(100);
      paneForControllers.getChildren().addAll(streetSuffixAddLabelText, streetSuffixAddText);

      Text cityAddLabelText = new Text(550, 140, "City");
      TextField cityAddText = new TextField();
      cityAddText.setPrefWidth(170);
      cityAddText.setTranslateX(650);
      cityAddText.setTranslateY(130);

      paneForControllers.getChildren().addAll(cityAddLabelText, cityAddText);
      Text stateAddLabelText = new Text(550, 170, "State");
      TextField stateAddText = new TextField();
      stateAddText.setPrefWidth(170);
      stateAddText.setTranslateX(650);
      stateAddText.setTranslateY(155);

      paneForControllers.getChildren().addAll(stateAddLabelText, stateAddText);
      Text zipAddLabelText = new Text(550, 200, "Zip");
      TextField zipAddText = new TextField();
      zipAddText.setPrefWidth(170);
      zipAddText.setTranslateX(650);
      zipAddText.setTranslateY(185);
      paneForControllers.getChildren().addAll(zipAddLabelText, zipAddText);

      Text bedroomAddLabelText = new Text(550, 230, "Bedroom");
      TextField bedroomAddText = new TextField();
      bedroomAddText.setPrefWidth(110);
      bedroomAddText.setTranslateX(650);
      bedroomAddText.setTranslateY(215);
      paneForControllers.getChildren().addAll(bedroomAddLabelText, bedroomAddText);

      Text bathroomsAddLabelText = new Text(770, 230, "Bathrooms");
      TextField bathroomsAddText = new TextField();
      bathroomsAddText.setPrefWidth(110);
      bathroomsAddText.setTranslateX(835);
      bathroomsAddText.setTranslateY(215);
      paneForControllers.getChildren().addAll(bathroomsAddLabelText, bathroomsAddText);

      Text sqFtAddLabelText = new Text(550, 260, "Insert  SqFt");
      TextField sqFtAddText = new TextField();
      sqFtAddText.setPrefWidth(170);
      sqFtAddText.setTranslateX(650);
      sqFtAddText.setTranslateY(243);
      paneForControllers.getChildren().addAll(sqFtAddLabelText, sqFtAddText);

      Text priceAddLabelText = new Text(550, 290, "Price");
      TextField priceAddText = new TextField();
      priceAddText.setPrefWidth(150);
      priceAddText.setTranslateX(650);
      priceAddText.setTranslateY(270);
      paneForControllers.getChildren().addAll(priceAddLabelText, priceAddText);

      Button btnAdd = new Button("Add");
      btnAdd.setPrefWidth(100);
      btnAdd.setTranslateX(700);
      btnAdd.setTranslateY(300);
      paneForControllers.getChildren().addAll(btnAdd);

      combo_box.setOnAction((e) -> {
        if (combo_box.getValue().toString().equalsIgnoreCase("City/State/Zip")) {
          cityStateZipText.setDisable(false);
          bedroomText.setDisable(true);
          bathroomsText.setDisable(true);
          minPriceText.setDisable(true);
          maxPriceText.setDisable(true);
          SqFtText.setDisable(true);
        } else if (combo_box.getValue().toString().equalsIgnoreCase("Bedrooms and Bathrooms")) {
          cityStateZipText.setDisable(true);
          bedroomText.setDisable(false);
          bathroomsText.setDisable(false);
          minPriceText.setDisable(true);
          maxPriceText.setDisable(true);
          SqFtText.setDisable(true);
        } else if (combo_box.getValue().toString().equalsIgnoreCase("Min/Max Price")) {
          cityStateZipText.setDisable(true);
          bedroomText.setDisable(true);
          bathroomsText.setDisable(true);
          minPriceText.setDisable(false);
          maxPriceText.setDisable(false);
          SqFtText.setDisable(true);
        } else if (combo_box.getValue().toString().equalsIgnoreCase("SqFt")) {
          cityStateZipText.setDisable(true);
          bedroomText.setDisable(true);
          bathroomsText.setDisable(true);
          minPriceText.setDisable(true);
          maxPriceText.setDisable(true);
          SqFtText.setDisable(false);
        }

      });

      btnSearch.setOnAction(e -> {

        tableView.getItems().clear();
        items.clear();
        selected.setText("");
        if (combo_box.getValue() == null || combo_box.getValue() == "") {
          selected.setText("Please select Search Method");

          return;
        }

        String search_parameter = combo_box.getValue().toString();

        String cityStateZip;
        Integer bedRoom, bathRoom;
        double minPrice, maxPrice, sqrft;

        if (combo_box.getValue().equals("City/State/Zip")) {
          if (cityStateZipText.getText().length() < 1) {
            selected.setText("Please specify City/State/Zip");

            return;
          }
          cityStateZip = cityStateZipText.getText();
        } else {
          cityStateZip = null;
        }

        if (combo_box.getValue().equals("Bedrooms and Bathrooms")) {

          if (ErrorValidation.validateBedroomBathrooms(bedroomText.getText(), bathroomsText.getText()).length() > 0) {
            selected.setText(ErrorValidation.validateBedroomBathrooms(bedroomText.getText(), bathroomsText.getText()));

            return;
          }
          if (bedroomText.getText().length() > 0) {
            bedRoom = Integer.parseInt(bedroomText.getText());
          } else {
            bedRoom = 0;
          }

          if (bathroomsText.getText().length() > 0) {
            bathRoom = Integer.parseInt(bathroomsText.getText());
          } else {
            bathRoom = 0;
          }

        } else {
          bedRoom = 0;
          bathRoom = 0;
        }

        if (combo_box.getValue().equals("Min/Max Price")) {
          if (ErrorValidation.validatePrice(minPriceText.getText(), maxPriceText.getText()).length() > 0) {
            selected.setText(ErrorValidation.validatePrice(minPriceText.getText(), maxPriceText.getText()));

            return;
          }
          minPrice = Double.parseDouble(minPriceText.getText());
          maxPrice = Double.parseDouble(maxPriceText.getText());
        } else {
          minPrice = 0;
          maxPrice = 0;
        }

        if (combo_box.getValue().equals("SqFt")) {
          if (ErrorValidation.validateSqFt(SqFtText.getText()).length() > 0) {
            selected.setText(ErrorValidation.validateSqFt(SqFtText.getText()));

            return;
          }
          sqrft = Double.parseDouble(SqFtText.getText());
        } else {
          sqrft = 0;
        }

        List<House> sortResultArrayList = new ArrayList<>();
        List<House> searchResultArrayList = new ArrayList<>();

        searchResultArrayList = Search.searchHouse(search_parameter, cityStateZip, bedRoom, bathRoom, minPrice,
            maxPrice, sqrft);
        if (searchResultArrayList.size() == 0) {
          selected.setText("The search query did not match any records in the database");
          return;
        }

        if (combo_box.getValue().equals("City/State/Zip")) {
          sortResultArrayList = Sort.bubbleSortArrayList2(searchResultArrayList);
        } else if (combo_box.getValue().equals("Bedrooms and Bathrooms")) {
          sortResultArrayList = Sort.mergeSortByPrice(searchResultArrayList);
        } else if (combo_box.getValue().equals("Min/Max Price")) {
          sortResultArrayList = Sort.bubbleSortArrayList2(searchResultArrayList);
        } else if (combo_box.getValue().equals("sqft")) {
          sortResultArrayList = Sort.mergeSortByPrice(searchResultArrayList);
        }

        int i = 0;
        for (House element : sortResultArrayList) {
          if (i < 23) {
            Map<String, Object> item3 = new HashMap<>();
            item3.put("street_address", element.getStreetAddress());
            item3.put("street_suffix", element.getStreetSuffix());
            item3.put("city", element.getCity());
            item3.put("state", element.getState());
            item3.put("zip", element.getZip());
            item3.put("bedrooms", element.getBedrooms());
            item3.put("bathrooms", element.getBathrooms());
            item3.put("sqFt", element.getSqft());
            item3.put("price", element.getPrice());
            items.add(item3);
          }
          i++;
        }
        tableView.getItems().addAll(items);

      });

      btnExport.setOnAction(e -> {
        String search_parameter = combo_box.getValue().toString();
        String cityStateZip;
        Integer bedRoom, bathRoom;
        double minPrice, maxPrice, sqrft;

        if (combo_box.getValue().equals("City/State/Zip")) {
          if (cityStateZipText.getText().length() < 1) {
            selected.setText("Please specify City/State/Zip");

            return;
          }
          cityStateZip = cityStateZipText.getText();
        } else {
          cityStateZip = null;
        }

        if (combo_box.getValue().equals("Bedrooms and Bathrooms")) {

          if (ErrorValidation.validateBedroomBathrooms(bedroomText.getText(), bathroomsText.getText()).length() > 0) {
            selected.setText(ErrorValidation.validateBedroomBathrooms(bedroomText.getText(), bathroomsText.getText()));

            return;
          }
          if (bedroomText.getText().length() > 0) {
            bedRoom = Integer.parseInt(bedroomText.getText());
          } else {
            bedRoom = 0;
          }

          if (bathroomsText.getText().length() > 0) {
            bathRoom = Integer.parseInt(bathroomsText.getText());
          } else {
            bathRoom = 0;
          }

        } else {
          bedRoom = 0;
          bathRoom = 0;
        }

        if (combo_box.getValue().equals("Min/Max Price")) {
          if (ErrorValidation.validatePrice(minPriceText.getText(), maxPriceText.getText()).length() > 0) {
            selected.setText(ErrorValidation.validatePrice(minPriceText.getText(), maxPriceText.getText()));

            return;
          }
          minPrice = Double.parseDouble(minPriceText.getText());
          maxPrice = Double.parseDouble(maxPriceText.getText());
        } else {
          minPrice = 0;
          maxPrice = 0;
        }

        if (combo_box.getValue().equals("sqft")) {
          if (ErrorValidation.validateSqFt(SqFtText.getText()).length() > 0) {
            selected.setText(ErrorValidation.validateSqFt(SqFtText.getText()));

            return;
          }
          sqrft = Double.parseDouble(SqFtText.getText());
        } else {
          sqrft = 0;
        }

        List<House> sortResultArrayList = new ArrayList<>();
        List<House> searchResultArrayList = Search.searchHouse(search_parameter, cityStateZip, bedRoom, bathRoom,
            minPrice, maxPrice, sqrft);

        if (combo_box.getValue().equals("City/State/Zip")) {
          sortResultArrayList = Sort.bubbleSortArrayList2(searchResultArrayList);
        } else if (combo_box.getValue().equals("Bedrooms and Bathrooms")) {
          sortResultArrayList = Sort.mergeSortByPrice(searchResultArrayList);
        } else if (combo_box.getValue().equals("Min/Max Price")) {
          sortResultArrayList = Sort.bubbleSortArrayList2(searchResultArrayList);
        } else if (combo_box.getValue().equals("sqft")) {
          sortResultArrayList = Sort.mergeSortByPrice(searchResultArrayList);
        }

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("street Address").append(",").append("Street Suffix").append(",").append("City")
            .append(",").append("state").append(",").append("zip").append(",").append("bedrooms").append(",")
            .append("bathrooms").append(",").append("sqft").append(",").append("price").append(",").append("\n");

        int i = 0;
        for (House element : sortResultArrayList) {
          if (i < 20) {
            stringBuilder.append(element.getStreetAddress()).append(",").append(element.getStreetSuffix()).append(",")
                .append(element.getCity()).append(",").append(element.getState()).append(",").append(element.getZip())
                .append(",").append(element.getBedrooms()).append(",").append(element.getBathrooms()).append(",")
                .append(element.getSqft()).append(",").append(element.getPrice()).append(",").append("\n");

          }
          i++;
        }

        try (FileWriter fileWriter = new FileWriter("search_matches.CSV")) {
          fileWriter.write(stringBuilder.toString());
        } catch (Exception ex) {
          ex.printStackTrace();
        }

      });

      btnAdd.setOnAction(e -> {
        messageLabel.setText("");
        String street_address, street_suffix, city, state, zip;
        Integer bedRoom, bathRoom;
        double price, sqrft;
        String error;
        if (ErrorValidation.valiadateStreeAdress(streetAddressAddText.getText()).length() > 0) {
          messageLabel.setText(ErrorValidation.valiadateStreeAdress(streetAddressAddText.getText()));

          return;
        }
        if (ErrorValidation.valiadateStreeSuffix(streetSuffixAddText.getText()).length() > 0) {
          messageLabel.setText(ErrorValidation.valiadateStreeSuffix(streetSuffixAddText.getText()));

          return;
        }

        if (ErrorValidation.valiadateCity(cityAddText.getText()).length() > 0) {
          messageLabel.setText(ErrorValidation.valiadateCity(cityAddText.getText()));

          return;
        }

        if (ErrorValidation.valiadateState(stateAddText.getText()).length() > 0) {
          messageLabel.setText(ErrorValidation.valiadateState(stateAddText.getText()));

          return;
        }
        if (ErrorValidation.valiadateZip(zipAddText.getText()).length() > 0) {
          messageLabel.setText(ErrorValidation.valiadateZip(zipAddText.getText()));

          return;
        }

        if (ErrorValidation.valiadateZip(zipAddText.getText()).length() > 0) {
          messageLabel.setText(ErrorValidation.valiadateZip(zipAddText.getText()));

          return;
        }

        if (ErrorValidation.validateBedroom(bedroomAddText.getText()).length() > 0) {
          messageLabel.setText(ErrorValidation.validateBedroom(bedroomAddText.getText()));

          return;
        }
        if (ErrorValidation.validateBathroom(bathroomsAddText.getText()).length() > 0) {
          messageLabel.setText(ErrorValidation.validateBathroom(bathroomsAddText.getText()));

          return;
        }

        if (ErrorValidation.validatePrice(priceAddText.getText()).length() > 0) {
          messageLabel.setText(ErrorValidation.validatePrice(priceAddText.getText()));

          return;
        }

        if (ErrorValidation.validateSqFt(sqFtAddText.getText()).length() > 0) {
          messageLabel.setText(ErrorValidation.validateSqFt(sqFtAddText.getText()));

          return;
        }

        street_address = streetAddressAddText.getText();
        street_suffix = streetSuffixAddText.getText();
        city = cityAddText.getText();
        state = stateAddText.getText();
        zip = zipAddText.getText();
        bedRoom = Integer.parseInt(bedroomAddText.getText());
        bathRoom = Integer.parseInt(bathroomsAddText.getText());
        price = Double.parseDouble(priceAddText.getText());
        sqrft = Double.parseDouble(sqFtAddText.getText());

        String result = AddHouse.AddNewHouse(houseData, street_address, street_suffix, city, state, zip, bedRoom,
            bathRoom, sqrft, price);
        if (result.equalsIgnoreCase("True")) {
          messageLabel.setText("House Added");

        } else {
          messageLabel.setText(result);
          return;

        }

      });

      tableView.setTranslateX(50);
      tableView.setTranslateY(350);
      tableView.setPrefWidth(Screen.getPrimary().getVisualBounds().getWidth() * 0.65);
      Text titleText = new Text("Home Search by Argaw");
      titleText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
      titleText.setX(Screen.getPrimary().getVisualBounds().getWidth() / 3 - 150);
      titleText.setY(35);
      titleText.setFill(Color.BLACK);

      paneForControllers.getChildren().add(titleText);
      paneForControllers.getChildren().add(tableView);

      BorderPane root = new BorderPane();
      root.getChildren().addAll(paneForControllers);
      Scene scene = new Scene(root, Screen.getPrimary().getVisualBounds().getWidth() * 0.75,
          Screen.getPrimary().getVisualBounds().getHeight());
      primaryStage.setScene(scene);
      primaryStage.show();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Launches the application.
   * 
   * @precondition none
   * @postcondition none
   * @param args not used
   */
  public static void main(String[] args) {
    launch(args);
  }
}