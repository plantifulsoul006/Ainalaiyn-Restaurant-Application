import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.beans.binding.DoubleBinding;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.scene.layout.*;
import javafx.scene.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Ainalaiyn extends Application {
    private Scene homeScene;
    private Scene bookingScene;
    private Scene galleryScene;
    private Scene menuScene;
    private Scene contactScene;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Food Ordering");
        createHomeScene(primaryStage);
        createBookingScene(primaryStage);
        createGalleryScene(primaryStage);
        createMenuScene(primaryStage);
        createContactScene(primaryStage);
        
        primaryStage.setScene(homeScene);
        primaryStage.show();
    }

    private BorderPane createRootLayout(Stage primaryStage) {
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: rgb(236, 247, 223);");
        root.setPrefWidth(400);
        root.setPrefHeight(25);
        HBox leftHBox = new HBox();
        HBox rightHBox = new HBox();

        Button homeButton = new Button("Home");
        homeButton.setStyle("-fx-text-fill: black; -fx-font-weight: bold; -fx-background-color: transparent; -fx-border-color: transparent;");
        HBox.setHgrow(homeButton, javafx.scene.layout.Priority.ALWAYS);
        homeButton.setOnAction(e -> primaryStage.setScene(homeScene));

        Label label = new Label(" ~Ainalaiyn");
        Font font = Font.font("Brush Script MT", FontWeight.BOLD, FontPosture.REGULAR, 23);
        label.setFont(font);
        label.setTextFill(Color.GREEN);
        leftHBox.getChildren().add(label);

        Button menuButton = new Button("Menu");
        menuButton.setStyle("-fx-text-fill: black; -fx-background-color: transparent; -fx-border-color: transparent;");
        HBox.setHgrow(menuButton, javafx.scene.layout.Priority.ALWAYS);
        menuButton.setOnAction(e -> primaryStage.setScene(menuScene));

        Button bookingButton = new Button("Booking");
        bookingButton.setStyle("-fx-text-fill: black; -fx-font-weight: bold; -fx-background-color: transparent; -fx-border-color: transparent;");
        HBox.setHgrow(bookingButton, javafx.scene.layout.Priority.ALWAYS);
        bookingButton.setOnAction(e -> primaryStage.setScene(bookingScene));

        Button galleryButton = new Button("Gallery");
        galleryButton.setStyle("-fx-text-fill: black; -fx-font-weight: bold; -fx-background-color: transparent; -fx-border-color: transparent;");
        HBox.setHgrow(galleryButton, javafx.scene.layout.Priority.ALWAYS);
        galleryButton.setOnAction(e -> primaryStage.setScene(galleryScene));

        Button contactButton = new Button("Contact");
        contactButton.setStyle("-fx-text-fill: black; -fx-font-weight: bold; -fx-background-color: transparent; -fx-border-color: transparent;");
        HBox.setHgrow(contactButton, javafx.scene.layout.Priority.ALWAYS);
        contactButton.setOnAction(e -> primaryStage.setScene(contactScene));

        rightHBox.getChildren().addAll(homeButton, bookingButton, galleryButton, menuButton, contactButton);
        rightHBox.setSpacing(10);
        root.setLeft(leftHBox); 
        root.setRight(rightHBox);

        return root;
    }

    private void createHomeScene(Stage primaryStage) {
        BorderPane root = createRootLayout(primaryStage);

        VBox homeLayout = new VBox();
        homeLayout.setStyle("-fx-background-color: rgb(236, 247, 223);");
        homeLayout.setSpacing(90);

        Image image = new Image("file:Sandyq.jpg");
        ImageView imageView = new ImageView(image);
        imageView.fitWidthProperty().bind(primaryStage.widthProperty().multiply(1.0)); 
        imageView.setPreserveRatio(true);

        Text imageText = new Text("TRADITIONS IN OUR HEARTS");
        imageText.setFont(Font.font("Courier New", FontWeight.BOLD, 45));
        imageText.setFill(Color.WHITE);

        Text imageText2 = new Text("Kazakh National Food");
        imageText2.setFont(Font.font("Brush Script MT", FontPosture.ITALIC, 25));
        imageText2.setFill(Color.WHITE);

        StackPane imtStackPane = new StackPane();
        imtStackPane.getChildren().addAll(imageView, imageText, imageText2);
        StackPane.setAlignment(imageText, javafx.geometry.Pos.CENTER); 
        StackPane.setAlignment(imageText2, javafx.geometry.Pos.CENTER); 
        StackPane.setMargin(imageText2, new Insets(90, 0, 0, 0));

        Text welcomeText1 = new Text("WELCOME TO AINALAIYN RESTAURANT!");
        welcomeText1.setFont(Font.font("Courier New", FontWeight.BOLD, 35));
        welcomeText1.setWrappingWidth(600);
        welcomeText1.setTextAlignment(TextAlignment.CENTER);

        Text welcomeText = new Text("Immerse yourself in the rich traditions of Kazakh cuisine at 'Ainalaiyn' Restaurant. Discover a harmonious blend of authentic flavors and modern twists in every dish. From beloved classics to innovative creations, embark on a culinary journey unlike any other.");
        welcomeText.setFont(Font.font("Serif", FontPosture.ITALIC, 20));
        welcomeText.setWrappingWidth(600);
        welcomeText.setTextAlignment(TextAlignment.CENTER);
        
        VBox textPane = new VBox();
        textPane.setAlignment(Pos.CENTER);
        textPane.setSpacing(20);
        textPane.getChildren().addAll(welcomeText1, welcomeText);

        HBox menuPane = new HBox();
        menuPane.setAlignment(Pos.CENTER);
        menuPane.setSpacing(20);
        menuPane.setStyle("-fx-background-color: white;");

        Label titleLabel = new Label("DISCOVER OUR MENU");
        titleLabel.setFont(Font.font("Courier New", FontWeight.BOLD, 35));
        Label empty = new Label("   ");
        Label empty1 = new Label("   ");
        Label empty2 = new Label("   ");

        HBox dish1 = createDish("BESHBARMAQ", "Horsemeat, onion, bay leaf, eggs, plain flour, finely sliced chives.", "3990 tg", "Besh.jpg");
        HBox dish2 = createDish("TARY-CRUSTED CHICKEN TART", "Сhicken fillet, champignons, stracciatella, cherry tomatoes, onions, buckwheat bread.", "5490 tg", "tart.jpg");
        menuPane.getChildren().addAll(dish1, dish2);

        Button mainMenuButton = createMainMenuButton(primaryStage);
        mainMenuButton.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        mainMenuButton.setPrefWidth(150); 
        mainMenuButton.setPrefHeight(50); 
        mainMenuButton.setFont(Font.font("Arial", 20));
        mainMenuButton.setOnAction(e -> primaryStage.setScene(menuScene));
        
        HBox buttonContainer = new HBox(mainMenuButton);
        buttonContainer.setAlignment(Pos.CENTER);

        VBox menuContent = new VBox();
        menuContent.setAlignment(Pos.CENTER);
        menuContent.getChildren().addAll(empty1, titleLabel, menuPane); 
        menuContent.setStyle("-fx-background-color: white;");
        menuContent.setSpacing(50);

        VBox menuContainer = new VBox();
        menuContainer.getChildren().addAll(menuContent, buttonContainer, empty);
        menuContainer.setStyle("-fx-background-color: white;");
        menuContainer.setSpacing(50);

        Image table = new Image("file:Table.jpg");
        ImageView tableView = new ImageView(table);
        tableView.setFitWidth(500); 
        tableView.setFitHeight(600);
        tableView.setPreserveRatio(true);

        Text bookTable = new Text("BOOK YOUR TABLE");
        bookTable.setFont(Font.font("Courier New", FontWeight.BOLD, 35));
        bookTable.setWrappingWidth(350);
        bookTable.setTextAlignment(TextAlignment.CENTER);

        Button bookingButton = createBookingButton(primaryStage);
        bookingButton.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        bookingButton.setPrefWidth(150); 
        bookingButton.setPrefHeight(50); 
        bookingButton.setFont(Font.font("Arial", 20));
        bookingButton.setOnAction(e -> primaryStage.setScene(bookingScene));
        
        HBox bookingButtonContainer = new HBox(bookingButton);
        bookingButtonContainer.setAlignment(Pos.CENTER);

        Text bookingText = new Text("Since ancient times, the southern region of Kazakhstan has been famous for wood carving, pottery and carpet weaving, zerger and ustyk, mat weaving and felting, sewing and embroidery. We draw the attention of our visitors to the types of crafts that were once widely known outside the country - glassblowing and leatherwork, individual objects and details from which today decorate the restaurant’s halls.");
        bookingText.setFont(Font.font("Serif", FontPosture.ITALIC, 20));
        bookingText.setWrappingWidth(350);
        bookingText.setTextAlignment(TextAlignment.CENTER);

        VBox textWithButton = new VBox();
        textWithButton.getChildren().addAll(bookTable, bookingText, bookingButtonContainer);
        textWithButton.setSpacing(50);

        HBox mainBook = new HBox();
        mainBook.getChildren().addAll(tableView, textWithButton);
        mainBook.setSpacing(20);

        Text replyText = new Text("LEAVE A REPLY");
        replyText.setFont(Font.font("Courier New", FontWeight.BOLD, 25));
        replyText.setWrappingWidth(900);
        replyText.setTextAlignment(TextAlignment.CENTER);

        TextField commentField = new TextField();
        commentField.setPromptText("Enter your comment here");
        commentField.setPrefWidth(400); 
        commentField.setMaxWidth(800);
        commentField.setAlignment(Pos.CENTER); 

        VBox reply = new VBox();
        reply.getChildren().addAll(replyText, commentField, empty2);
        reply.setSpacing(50);
        reply.setAlignment(Pos.CENTER);

        homeLayout.getChildren().addAll(imtStackPane, textPane, menuContainer, mainBook, reply);

        ScrollPane scrollPane = new ScrollPane(homeLayout);
        scrollPane.setFitToWidth(true);
        
        homeScene = new Scene(new VBox(root, scrollPane), 900, 900);
    }

    private HBox createDish(String name, String description, String price, String imagePath) {
        HBox dish = new HBox();
        dish.setAlignment(Pos.CENTER);
        dish.setSpacing(14);
        
        Image image = new Image("file:" + imagePath);
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(180);
        imageView.setFitHeight(180);

        HBox coloredPane = new HBox();
        coloredPane.setStyle("-fx-background-color: rgb(236, 247, 223);"); 
        coloredPane.setPadding(new Insets(10)); 
        coloredPane.setSpacing(14);
        
        VBox detailsBox = new VBox();
        detailsBox.setAlignment(Pos.CENTER_LEFT);
        detailsBox.setSpacing(5);
        
        Text nameLabel = new Text(name);
        nameLabel.setFont(Font.font("Courier New", FontWeight.BOLD, 16));
        nameLabel.setWrappingWidth(170);
        
        Text descriptionLabel = new Text(description);
        descriptionLabel.setFont(Font.font("Serif", 14));
        descriptionLabel.setWrappingWidth(170);
        
        Text priceLabel = new Text(price);
        priceLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
       
        detailsBox.getChildren().addAll(nameLabel, descriptionLabel, priceLabel);
        
        coloredPane.getChildren().addAll(imageView, detailsBox); 
    
        dish.getChildren().add(coloredPane);
        
        return dish;
    }

    private void createMenuScene(Stage primaryStage) {
        BorderPane root = createRootLayout(primaryStage);

        VBox menuLayout = new VBox();
        menuLayout.setStyle("-fx-background-color: rgb(236, 247, 223);");
        menuLayout.setSpacing(30);
        menuLayout.setPadding(new Insets(20));

        VBox startersGroup = createDishGroup("Breakfasts~", createDish("Cottage cheese pancakes", "Homemade cottage cheese, eggs, semolina, raspberry jam.", "1990 tg", "image10.jpg"), createDish("Rice porridge", "Rice, milk, melted butter, raspberry jam.", "1990 tg", "kurish_kasha.jpg"), createDish("Maisok - the taste of childhood.", "Tary, butter, honey, cream.", "2190 tg", "maisok.jpg"), createDish("Homemade omelet with vegetables", "Milk, eggs, vegetables.", "1890 tg", "omlet.jpg"), createDish("Poached egg with spinach in cream sauce", "Spinach, butter, egg, brioche.", "1990 tg", "pashot.jpg"));
        VBox mainCoursesGroup = createDishGroup("Main dishes~", createDish("Beshbarmak", "Traditional Kazakh dish made with horsemeat, onions, and noodles.", "3990 tg", "Besh.jpg"), createDish("Kazan zhappa", "Zhaya, pepper, onion, flatbread, cherry tomatoes.", "4990 tg", "kazanZhappa.jpg"), createDish("Chicken tart in tary bread", "Chicken fillet, champignons, stracciatella, cherry tomatoes, onions, buckwheat bread.", "3990 tg", "tart.jpg"), createDish("Balgyn kuyrdak", "Zhaya, onions, potatoes, sour cream, wheat bread.", "4490 tg", "image1.jpg"), createDish("Craft burger", "Horse meat, onions, tomatoes, cheese, cheddar, sauce.", "3490 tg", "image3.jpg"), createDish("Horse meat in pepper sauce", "Horse meat, butter, cherry tomatoes, wheat, pepper sauce.", "4490 tg", "image4.jpg"));
        VBox dessertsGroup = createDishGroup("Desserts~", createDish("Ice cream with tary", " ", "1990 tg", "image9.jpg"), createDish("Tiramisu", " ", "2490 tg", "tiramisu.jpg"), createDish("Cheesecake with tary", " ", "2990 tg", "image2.jpg"));

        menuLayout.getChildren().addAll(startersGroup, mainCoursesGroup, dessertsGroup);

        ScrollPane scrollPane = new ScrollPane(menuLayout);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);

        menuScene = new Scene(new VBox(root, scrollPane), 900, 900);
    }

    private VBox createDishGroup(String groupName, Node... dishes) {
        VBox group = new VBox();
        group.setStyle("-fx-background-color: white");
        group.setSpacing(10);

        Label groupLabel = new Label(groupName);
        Font font = Font.font("Brush Script MT", FontWeight.BOLD, FontPosture.REGULAR, 30);
        groupLabel.setFont(font);
        group.getChildren().add(groupLabel);

        group.getChildren().addAll(dishes);

        return group;
    }

    private Button createMainMenuButton(Stage primaryStage) {
        Button mainMenuButton = new Button("Main Menu");
        mainMenuButton.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        mainMenuButton.setPrefWidth(150); 
        mainMenuButton.setPrefHeight(50); 
        mainMenuButton.setFont(Font.font("Arial", 20));
        mainMenuButton.setOnAction(e -> primaryStage.setScene(homeScene)); 
        return mainMenuButton;
    }

    private void createBookingScene(Stage primaryStage) {
        BorderPane roott = createRootLayout(primaryStage);
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: rgb(236, 247, 223);");

        VBox bookingLayout = new VBox();
        bookingLayout.setStyle("-fx-background-color: rgb(236, 247, 223);");
        bookingLayout.setSpacing(30);
        bookingLayout.setPadding(new Insets(20));

        TextField nameField = new TextField();
        nameField.setPromptText("Name");
        nameField.setMaxWidth(200);

        TextField emailField = new TextField();
        emailField.setPromptText("Email");
        emailField.setMaxWidth(200);

        TextField phoneField = new TextField();
        phoneField.setPromptText("Phone");
        phoneField.setMaxWidth(200);

        DatePicker datePicker = new DatePicker();
        datePicker.setPromptText("Date");

        TextField sizeField = new TextField();
        sizeField.setPromptText("Size");
        sizeField.setMaxWidth(200);

        TextArea specialRequestsArea = new TextArea();
        specialRequestsArea.setPromptText("Special Requests");

        Button submitButton = new Button("Submit Booking");
        submitButton.setOnAction(e -> {
            try {
                String name = validateInput(nameField, "Name");
                String email = validateEmail(emailField, "Email");
                String phone = validateInput(phoneField, "Phone");
                String date = validateInput(datePicker, "Date");
                String size = validateInput(sizeField, "Size");
                String specialRequests = specialRequestsArea.getText();

                String bookingInfo = String.format(
                        "Name: %s\nEmail: %s\nPhone: %s\nDate: %s\nSize: %s\nSpecial Requests: %s",
                        name, email, phone, date, size, specialRequests);

                displayConfirmation(primaryStage, bookingInfo);
            } catch (IllegalArgumentException ex) {
                showErrorAlert("Error", ex.getMessage());
            }
        });

        Label empty1 = new Label("   ");
        Label empty2 = new Label("   ");
        Label empty3 = new Label("   ");
        Label empty4 = new Label("   ");
        Label empty5 = new Label("   ");

        bookingLayout.getChildren().addAll(
                nameField, emailField, phoneField,
                datePicker, sizeField, specialRequestsArea,
                submitButton, empty1, empty2, empty3,
                empty4, empty5
        );

        bookingScene = new Scene(new VBox(roott, root, bookingLayout), 900, 800);
    }

    private String validateInput(TextField textField, String fieldName) {
        String input = textField.getText().trim();
        if (input.isEmpty()) {
            throw new IllegalArgumentException(fieldName + " field cannot be empty.");
        } 
        return input;
    }

    private String validateEmail(TextField textField, String fieldName) {
        String input = textField.getText().trim();
        if (input.isEmpty()) {
            throw new IllegalArgumentException(fieldName + " field cannot be empty.");
        } else if (!input.contains("@") || !input.contains(".")) {
            throw new IllegalArgumentException("Invalid " + fieldName + ". Please enter a valid email address.");
        }
        return input;
    }

    private String validateInput(DatePicker datePicker, String fieldName) {
        String input = datePicker.getValue().toString();
        if (input.isEmpty()) {
            throw new IllegalArgumentException(fieldName + " field cannot be empty.");
        }
        return input;
    }

    private void displayConfirmation(Stage primaryStage, String bookingInfo) {
        Stage confirmationStage = new Stage();
        VBox confirmationLayout = new VBox();
        confirmationLayout.setAlignment(Pos.CENTER);
        confirmationLayout.setSpacing(20);

        Label confirmationLabel = new Label("Booking Information:");
        confirmationLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        TextArea bookingInfoArea = new TextArea(bookingInfo);
        bookingInfoArea.setEditable(false);
        bookingInfoArea.setPrefRowCount(6);

        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> confirmationStage.close());

        confirmationLayout.getChildren().addAll(confirmationLabel, bookingInfoArea, closeButton);

        Scene confirmationScene = new Scene(confirmationLayout, 300, 250);
        confirmationStage.setScene(confirmationScene);
        confirmationStage.show();
    }

    private void showErrorAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private Button createBookingButton(Stage primaryStage) {
        Button bookingButton = new Button("Booking");
        bookingButton.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        bookingButton.setPrefWidth(150); 
        bookingButton.setPrefHeight(50); 
        bookingButton.setFont(Font.font("Arial", 20));
        bookingButton.setOnAction(e -> primaryStage.setScene(homeScene)); 
        return bookingButton;
    }

    private void createGalleryScene(Stage primaryStage) {
        BorderPane root = createRootLayout(primaryStage);

        GridPane gridPane = new GridPane();
        gridPane.setStyle("-fx-background-color: rgb(236, 247, 223);");
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        List<String> imageUrls = new ArrayList<>();
        imageUrls.add("file:kazann.jpg");
        imageUrls.add("file:tart.jpg");
        imageUrls.add("file:baursaki.jpg");
        imageUrls.add("file:image1.jpg");
        imageUrls.add("file:image2.jpg");
        imageUrls.add("file:image3.jpg");
        imageUrls.add("file:image4.jpg");
        imageUrls.add("file:image5.jpg");
        imageUrls.add("file:Besh.jpg");
        imageUrls.add("file:image7.jpg");
        imageUrls.add("file:image8.jpg");
        imageUrls.add("file:image9.jpg");
        imageUrls.add("file:image10.jpg");
        imageUrls.add("file:kurish_kasha.jpg");
        imageUrls.add("file:maisok.jpg");
        imageUrls.add("file:omlet.jpg");
        imageUrls.add("file:pashot.jpg");
        imageUrls.add("file:tiramisu.jpg");

        Collections.shuffle(imageUrls);

        int numCols = 3; 
        int numRows = 6; 

        double imageWidth = 300; 
        double imageHeight = 200; 

        Random random = new Random();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (!imageUrls.isEmpty()) {
                    String imageUrl = imageUrls.remove(0);
                    Image image = new Image(imageUrl);
                    ImageView imageView = new ImageView(image);
                    imageView.setFitWidth(imageWidth);
                    imageView.setFitHeight(imageHeight);
                    gridPane.add(imageView, j, i);
                }
            }
        }
        ScrollPane scrollPane = new ScrollPane(gridPane);
        scrollPane.setFitToWidth(true);

        VBox main = new VBox();
        main.getChildren().addAll(root, scrollPane);

        Scene scene = new Scene(main, 900, 900);
        galleryScene = scene;
    }

    private void createContactScene(Stage primaryStage) {
        BorderPane root = createRootLayout(primaryStage);

        VBox contactLayout = new VBox(30); 
        contactLayout.setStyle("-fx-background-color: rgb(236, 247, 223);");
        contactLayout.setPadding(new Insets(20)); 

        Label feedbackLabel = new Label("We value your feedback!");
        feedbackLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));

        TextArea feedbackArea = new TextArea();
        feedbackArea.setPromptText("Leave your feedback or opinion about our restaurant...");
        feedbackArea.setWrapText(true);

        Button submitFeedbackButton = new Button("Submit Feedback");
        submitFeedbackButton.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        submitFeedbackButton.setOnAction(e -> {
            String feedback = feedbackArea.getText().trim();
            if (!feedback.isEmpty()) {
                showAlert("Feedback Received", "Thank you for your feedback!");
                System.out.println("Received feedback: " + feedback);
                feedbackArea.clear();
            } else {
                showAlert("Feedback Error", "Please enter your feedback before submitting.");
            }
        });

        Label scheduleLabel = new Label("Visit Us");
        scheduleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));

        Label scheduleDetails = new Label("Monday - Friday: 9 AM - 10 PM\nSaturday - Sunday: 10 AM - 11 PM");
        scheduleDetails.setFont(Font.font("Arial", 18));

        Label empty1 = new Label("   ");
        Label empty2 = new Label("   ");
        Label empty3 = new Label("   ");
        Label empty4 = new Label("   ");
        Label empty5 = new Label("   ");
        Label empty6 = new Label("   ");

        contactLayout.getChildren().addAll(feedbackLabel, feedbackArea, submitFeedbackButton, new Separator(), scheduleLabel, scheduleDetails, empty1, empty2, empty3, empty4, empty5, empty6);
        VBox mainLayout = new VBox(root, contactLayout); 

        contactScene = new Scene(mainLayout, 900, 900);
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
