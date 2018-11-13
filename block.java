package snake_vs_block;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.Group;
import javafx.scene.image.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class block {
	int val;
	int x;
	int y;
	Group solid;
	Rectangle myRect;
	Text myText;

	public block(int d, int x, int y, Color c) {
		val = d ;
		if(d<11) {
			x =x ;y=y;
			Rectangle b1 = new Rectangle(120, 120);	
			Text t1 = new Text(Integer.toString(val));
			t1.setX(x+50);
	        t1.setY(15);
	        t1.setFill(Color.ANTIQUEWHITE);
	        t1.setFont(Font.font(30));
	        b1.setFill(c);
			b1.setX(x);
			b1.setY(y);
			myText = t1;
			myRect = b1 ;
			solid = new Group();
			solid.getChildren().addAll(b1, t1) ;
		}
		else {
			x =x ;y=y;
			Rectangle b1 = new Rectangle(30, 150);
	        b1.setFill(Color.BLACK);
	        b1.relocate(x+60, y+135);
//			b1.setX(x+60);
//			b1.setY(y+135);
			myRect = b1 ;
			solid = new Group();
			solid.getChildren().addAll(b1) ;
			
		}
	}
	
	public void setVisibility(boolean b) {
		solid.setVisible(b);
	}
	
	public void setText(int x) {
		solid.getChildren().get(1).setAccessibleText("a");
	}
	
	

}
