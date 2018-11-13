package snake_vs_block;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;



public class gamePage {
	static Scene s;
	static snake snake;
	static ArrayList<block> myBlocks = new ArrayList<block>();
	static ArrayList<Object> myShield = new ArrayList<Object>() ;
	static ArrayList<Object> myMagnet = new ArrayList<Object>() ;
	static ArrayList<Object> myBomb = new ArrayList<Object>() ;
	static rat myRat ;
	static int score ;

	public gamePage(Stage window) throws FileNotFoundException {
		Group gamePlay = new Group();
		Text myScore = new Text("0");
		myScore.setLayoutX(275);
		myScore.setLayoutY(50);
		myScore.setFont(Font.font(30));
		Color[] colorList = {Color.AQUA, Color.BLUEVIOLET, Color.DEEPPINK, Color.GREENYELLOW, Color.CADETBLUE, Color.ORANGE} ;
		Random r = new Random();
		
		int xCo = 0 ;
		for(int i=0;i<5;i++) {
			block b = new block(r.nextInt(10)+1,xCo,-60,colorList[r.nextInt(6)]);
			myBlocks.add(b);
			xCo += 120 ;
		}
		myShield.add(new shield(5,-480));
		myShield.add(new coin(120,-480));
		myShield.add(new coin(240,-480));
		myShield.add(new coin(360,-480));
		myShield.add(new coin(480,-480));
		
		myMagnet.add(new magnet(5, 0,-240));
		myMagnet.add(new coin(120,-240));
		myMagnet.add(new coin(240,-240));
		myMagnet.add(new coin(360,-240));
		myMagnet.add(new coin(480,-240));
		
		myBomb.add(new bomb(5,-600));
		myBomb.add(new coin(120,-600));
		myBomb.add(new coin(240,-600));
		myBomb.add(new coin(360,-600));
		myBomb.add(new coin(480,-600));
		
		myRat = new rat(0, -360);
		
		Group thisSnake = new snake().snake;
        Group blocks = new Group();
        Group shieldGroup = new Group() ;
        Group magnetGroup = new Group() ;
        Group bombGroup = new Group() ;

        for(int j=0;j<5;j++) {
        		blocks.getChildren().add(myBlocks.get(j).solid);
        }
        
        for(int j=0;j<5;j++) {
        		
    			if(j==0) {
    				shieldGroup.getChildren().add(((shield)myShield.get(j)).solid);
    				magnetGroup.getChildren().add(((magnet)myMagnet.get(j)).solid);
    				bombGroup.getChildren().add(((bomb)myBomb.get(j)).solid);

    			}
    			else if(j==2 || j==3) {
    				shieldGroup.getChildren().add(((coin)myShield.get(j)).solid);
    				magnetGroup.getChildren().add(((coin)myMagnet.get(j)).solid);
    				bombGroup.getChildren().add(((coin)myBomb.get(j)).solid);


    			}
    			else {
    				shieldGroup.getChildren().add(((coin)myShield.get(j)).solid);
    				magnetGroup.getChildren().add(((coin)myMagnet.get(j)).solid);
    				bombGroup.getChildren().add(((coin)myBomb.get(j)).solid);


    			}
        		
        }
        

        gamePlay.getChildren().addAll(myScore, thisSnake, blocks, shieldGroup, magnetGroup, bombGroup, myRat.solid);
        
        AnimationTimer translateTransition = new AnimationTimer() {
        		int speed = 4;
        		int g = 0;
            @Override
            public void handle(long now) {
            		boolean[] tf = {true,false} ;
            		
                blocks.setLayoutY(blocks.getLayoutY() + speed);
                shieldGroup.setLayoutY(shieldGroup.getLayoutY() + speed);
                magnetGroup.setLayoutY(magnetGroup.getLayoutY() + speed);
                myRat.solid.setLayoutY(myRat.solid.getLayoutY() + speed);
                myRat.solid.setLayoutX(myRat.solid.getLayoutX()+speed);
                bombGroup.setLayoutY(bombGroup.getLayoutY() + speed);
                

                if(magnetGroup.getLayoutY()>840) {
                		magnetGroup.relocate(0, blocks.getLayoutY()-180);

                }
                if(myRat.solid.getLayoutY()>600) {
            			myRat.solid.relocate(0, magnetGroup.getLayoutY()-360);
            		
                }
                if(shieldGroup.getLayoutY()>1080) {
                		shieldGroup.relocate(0, myRat.solid.getLayoutY()-160);
                }
                if(bombGroup.getLayoutY()>1200) {
            			bombGroup.relocate(0, myRat.solid.getLayoutY()-320);

                }
                
                if (blocks.getLayoutY() > 661) {
                		
                		blocks.setLayoutY(-60);
                    int xCur = 0;
                    for(int i=0;i<5;i++) {
                    		block newBlock = new block(r.nextInt(10)+1, xCur, -60, colorList[r.nextInt(6)] )  ;
                    		blocks.getChildren().set(i, newBlock.solid);
                    		myBlocks.set(i, newBlock);
                    		blocks.getChildren().get(i).setVisible(tf[r.nextInt(2)]);
                    		xCur += 120 ;

                    }
                    
                                
                }
                
                
               

                if(thisSnake.getChildren().get(0).getLayoutY()==blocks.getLayoutY()) {
                		
                		if(g==20)
                			stop();
                		System.out.println("Collided"+g);
                		System.out.println(myBlocks.get(1).myText);
                		g+=1;
                }
            }  
        };

        translateTransition.start();

        Scene gamePage = new Scene(gamePlay, 600, 600);
        gamePage.setFill(Color.BURLYWOOD);
        gamePage.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().toString().equals("LEFT")) {
                    thisSnake.setLayoutX(thisSnake.getLayoutX() - 40);
                }
                else if (event.getCode().toString().equals("RIGHT")) {
                	thisSnake.setLayoutX(thisSnake.getLayoutX() + 40);
                }
            }
        });
        s = gamePage ;
	}

   
}