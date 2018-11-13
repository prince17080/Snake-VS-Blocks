package snake_vs_block;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import javafx.scene.Group;


import javafx.scene.image.*;

public class coin {
	Image img;
	Group solid;
	public coin(int x, int y) throws FileNotFoundException {
		FileInputStream f = new FileInputStream("/Users/ananyabhatia/Desktop/coinImg.gif");
		img = new Image(f) ;
		ImageView iv = new ImageView(img);
		iv.setFitWidth(50);
		iv.setFitHeight(50);
		solid = new Group();
		solid.getChildren().addAll(iv) ;
		solid.relocate(x, y);
		
	}

}
