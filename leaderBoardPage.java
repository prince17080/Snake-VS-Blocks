package snake_vs_block;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class leaderBoardPage {
	static Scene lbScene ;
	
	public leaderBoardPage(Stage window) {
		Text lbHead = new Text("Leader Board");
		lbHead.setFont(Font.font(50));
		lbHead.setLayoutX(120);
		lbHead.setLayoutY(60);
		
		Button back = new Button("Home");
		back.setOnAction(e -> window.setScene(mainPage.mainScene));
		back.setStyle("-fx-background-color: #51190F");
		back.setTextFill(Color.WHITE);
		back.setPrefSize(400, 80);
		back.setFont(Font.font(30));
		back.setLayoutX(100);
		back.setLayoutY(500);
		
		Group gBoard = new Group() ;
		gBoard.getChildren().addAll(lbHead,back);
		
		lbScene = new Scene(gBoard, 600, 600);
		lbScene.setFill(Color.BEIGE);
		
	}

}
