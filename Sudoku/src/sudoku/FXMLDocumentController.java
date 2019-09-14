/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;


import javafx.scene.paint.Color;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

public class FXMLDocumentController implements Initializable{
    
    @FXML Button button_one;
    @FXML Button button_two;
    @FXML Button button_three;
    @FXML Button button_four;
    @FXML Button button_five;
    @FXML Button button_six;
    @FXML Button button_seven;
    @FXML Button button_eight;
    @FXML Button button_nine;
    @FXML Button button_easy;
    @FXML Button button_medium;
    @FXML Button button_hard;
    @FXML Button button_new;
    @FXML Button button_hint;
    @FXML Canvas canvas;
    
    GameBoard gameboard;
    static int h=0;
    int p_s_r;
    int p_s_c;
    int n1 = 9;
    @Override
    public void initialize(URL arg0, ResourceBundle arg1)
    {
        p_s_r = p_s_c =0;
        gameboard = new GameBoard(n1,30);
        GraphicsContext context = canvas.getGraphicsContext2D();
        drawOnCanvas(context);
        
    }
    
    public void drawOnCanvas(GraphicsContext context)
    {
        int initial[][] = gameboard.getInitial();
        context.clearRect(0, 0, 450, 450);
        for(int row=0; row<9; row++)
        {
            for(int col=0; col<9; col++)
            {
                int pos_x = 50*col + 2;
                int pos_y = 50*row + 2;
                int width = 46;
                if(initial[row][col] == 0)
                {
                    context.setFill(Color.WHITE);
                    context.fillRoundRect(pos_x, pos_y, width, width, 10, 10);
                }
                else
                {
                    context.setFill(Color.BISQUE);
                    context.fillRoundRect(pos_x, pos_y, width, width, 10, 10);
                }
            }
        }
        context.setStroke(Color.ORANGERED);
        context.setLineWidth(3);
        context.strokeRoundRect(p_s_c*50+2, p_s_r*50+2, 46, 46, 10, 10); 
        
        
        for(int row=0; row<9; row++)
        {
            for(int col=0; col<9; col++)
            {
                int pos_x = 50*col + 18;
                int pos_y = 50*row + 33;
                context.setFill(Color.BLACK);
                context.setFont(new Font(23));
                if(initial[row][col] != 0)
                {
                    context.fillText(initial[row][col]+"", pos_x, pos_y);
                }
            }
        }
        
        int player[][] = gameboard.getPlayer();
        for(int row=0; row<9; row++)
        {
            for(int col=0; col<9; col++)
            {
                int pos_x = 50*col + 18;
                int pos_y = 50*row + 33;
                context.setFill(Color.PURPLE);
                context.setFont(new Font(23));
                if(player[row][col] != 0)
                {
                    context.fillText(player[row][col]+"", pos_x, pos_y);
                }
            }
        }
        
        if(gameboard.checkForSuccess() == true)
        {
            context.clearRect(0, 0, 450, 450);
            context.setFill(Color.GREEN);
            context.setFont(new Font(36));
            context.fillText("SUCCESS!", 150, 250);
        }
  
    }
    
    public void canvasMouseClicked(){
        canvas.setOnMouseClicked(new EventHandler<MouseEvent>(){
        
        @Override
        public void handle(MouseEvent event)
        {
            int mx = (int)event.getX();
            int my = (int)event.getY();
            p_s_c = (int)(mx/50);
            p_s_r = (int)(my/50);
            drawOnCanvas(canvas.getGraphicsContext2D());
        }
        });
    }
    
    
    //number button event handlers
    public void buttonOnePresssed()
    {
        gameboard.modifyPlayer(1, p_s_c, p_s_r);
        drawOnCanvas(canvas.getGraphicsContext2D());
    }
    
    public void buttonTwoPresssed()
    {
        gameboard.modifyPlayer(2, p_s_c, p_s_r);
        drawOnCanvas(canvas.getGraphicsContext2D());
    }
    
    public void buttonThreePresssed()
    {
        gameboard.modifyPlayer(3, p_s_c, p_s_r);
        drawOnCanvas(canvas.getGraphicsContext2D());
    }
    
    public void buttonFourPresssed()
    {
        gameboard.modifyPlayer(4, p_s_c, p_s_r);
        drawOnCanvas(canvas.getGraphicsContext2D());
    }
    
    public void buttonFivePresssed()
    {
        gameboard.modifyPlayer(5, p_s_c, p_s_r);
        drawOnCanvas(canvas.getGraphicsContext2D());
    }
    
    public void buttonSixPresssed()
    {
        gameboard.modifyPlayer(6, p_s_c, p_s_r);
        drawOnCanvas(canvas.getGraphicsContext2D());
    }
    
    public void buttonSevenPresssed()
    {
        gameboard.modifyPlayer(7, p_s_c, p_s_r);
        drawOnCanvas(canvas.getGraphicsContext2D());
    }
    
    public void buttonEightPresssed()
    {
        gameboard.modifyPlayer(8, p_s_c, p_s_r);
        drawOnCanvas(canvas.getGraphicsContext2D());
    }
    
    public void buttonNinePresssed()
    {
        gameboard.modifyPlayer(9, p_s_c, p_s_r);
        drawOnCanvas(canvas.getGraphicsContext2D());
    }
    
    public void buttonEasyPressed()
    {
        h=0;
        gameboard = new GameBoard(n1,30);
        GraphicsContext context = canvas.getGraphicsContext2D();
        drawOnCanvas(context);
    }
    
    public void buttonMediumPressed()
    {
        h=0;
        gameboard = new GameBoard(n1,40);
        GraphicsContext context = canvas.getGraphicsContext2D();
        drawOnCanvas(context);
    }
    
    public void buttonHardPressed()
    {
        h=0;
        gameboard = new GameBoard(n1,50);
        GraphicsContext context = canvas.getGraphicsContext2D();
        drawOnCanvas(context);
    }
    public void buttonNewPressed()
    {
        h=0;
        gameboard = new GameBoard(n1,30);
        GraphicsContext context = canvas.getGraphicsContext2D();
        drawOnCanvas(context);
    }
    
    public void buttonHintPressed()
    {
        h++;
        if(h<6)
        {
            int solution[][] = gameboard.getSolution();
            gameboard.modifyPlayer(solution[p_s_r][p_s_c], p_s_c, p_s_r);
            drawOnCanvas(canvas.getGraphicsContext2D());
        }
        else
        {
             Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("No. of Hints Exceeded");
            alert.setHeaderText("Please play by your own from now on!");
//            alert.setContentText("Please !");
            alert.showAndWait();
        }
       
    }
    
}
