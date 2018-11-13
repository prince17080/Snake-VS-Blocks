package snake_vs_block;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text; 
import javafx.stage.Stage;

public class mainPage {
	static Scene mainScene;
	public mainPage(Stage window) {
		Button startButton = new Button("Start Game") ;
		startButton.setOnAction(e -> window.setScene(gamePage.s));
 		startButton.setStyle("-fx-background-color: #51190F");
		startButton.setTextFill(Color.WHITE);
		startButton.setPrefSize(400, 100);
		startButton.setFont(Font.font(30));
		startButton.setLayoutX(100);
		startButton.setLayoutY(125);
		
		Button resumeButton = new Button("Resume Last Game") ;
		resumeButton.setOnAction(e -> window.setScene(gamePage.s));
		resumeButton.setStyle("-fx-background-color: #51190F");
		resumeButton.setTextFill(Color.WHITE);
		resumeButton.setPrefSize(400, 100);
		resumeButton.setFont(Font.font(30));
		resumeButton.setLayoutX(100);
		resumeButton.setLayoutY(300);

		Button lbButton = new Button("View Leaderboard") ;
		lbButton.setOnAction(e -> window.setScene(leaderBoardPage.lbScene));
		lbButton.setStyle("-fx-background-color: #51190F");
		lbButton.setTextFill(Color.WHITE);
		lbButton.setPrefSize(400, 100);
		lbButton.setFont(Font.font(30));
		lbButton.setLayoutX(100);
		lbButton.setLayoutY(475);
		
		
		
		Text mainHead = new Text("Snake vs Block");
		mainHead.setFont(Font.font(50));
		mainHead.setLayoutX(120);
		mainHead.setLayoutY(60);
		
		

		
		Group gMain = new Group() ;
		gMain.getChildren().addAll(mainHead, startButton,resumeButton,lbButton) ;
		
		
		mainScene = new Scene(gMain,600,600) ;
		mainScene.setFill(Color.BEIGE);
	}
}
