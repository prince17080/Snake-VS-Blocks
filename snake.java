package snake_vs_block;

import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class snake {
	static int length;
	Group snake ;
	int radius;
	public snake() {
		length = 4;
		radius = 10;
		snake = new Group();
        Circle head = new Circle();
        head.setRadius(radius);
        head.setFill(Color.BLACK);
        head.setLayoutX(300);
        head.setLayoutY(400);
        
        
//        for(int i=1;i<=4;i++) {
//        		Circle body1 = new Circle();
//            body1.setRadius(radius);
//            body1.setFill(Color.SADDLEBROWN);
//            body1.setLayoutX(300);
//            body1.setLayoutY(body.get(body.size()-1).getLayoutY()+2*i*radius);
//            body.add(body1);
//        }

        Circle body1 = new Circle();
        body1.setRadius(radius);
        body1.setFill(Color.SADDLEBROWN);
        body1.setLayoutX(300);
        body1.setLayoutY(400+2*radius);

        Circle body2 = new Circle();
        body2.setRadius(radius);
        body2.setFill(Color.SADDLEBROWN);
        body2.setLayoutX(300);
        body2.setLayoutY(400+4*radius);

        Circle body3 = new Circle();
        body3.setRadius(radius);
        body3.setFill(Color.SADDLEBROWN);
        body3.setLayoutX(300);
        body3.setLayoutY(400 + 6*radius);
        
        Circle body4 = new Circle();
        body4.setRadius(radius);
        body4.setFill(Color.SADDLEBROWN);
        body4.setLayoutX(300);
        body4.setLayoutY(400 + 8*radius);

        snake.getChildren().addAll(head, body1, body2, body3, body4);

	}

}
