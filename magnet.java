package snake_vs_block;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.Group;


import javafx.scene.image.*;
public class magnet {
	int distance;
	Image img;
	Group solid;
	public magnet(int d, int x, int y) throws FileNotFoundException {
		distance = d ;
		FileInputStream f = new FileInputStream("/Users/ananyabhatia/Desktop/magnetImg.png");
		img = new Image(f) ;
		ImageView iv = new ImageView(img);
		iv.setFitWidth(50);
		iv.setFitHeight(50);
		solid = new Group();
		solid.getChildren().addAll(iv) ;
		solid.relocate(x, y);
	}

}
