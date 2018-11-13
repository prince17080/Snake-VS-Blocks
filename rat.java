package snake_vs_block;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.Group;


import javafx.scene.image.*;
public class rat {
	Image img;
	Group solid;
	public rat(int x, int y) throws FileNotFoundException {
		FileInputStream f = new FileInputStream("/Users/ananyabhatia/Desktop/rat.gif");
		img = new Image(f) ;
		ImageView iv = new ImageView(img);
		iv.setFitWidth(100);
		iv.setFitHeight(50);
		solid = new Group();
		solid.getChildren().addAll(iv) ;
		solid.relocate(x, y);
	}

}
