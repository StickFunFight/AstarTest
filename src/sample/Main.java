package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

        Node initialNode = new Node(2, 1);
        Node finalNode = new Node(2, 5);
        int rows = 6;
        int cols = 7;
        AStar aStar = new AStar(rows, cols, initialNode, finalNode);
        int[][] blocksArray = new int[][]{{1, 3}, {2, 3}, {3, 3}};
        aStar.setBlocks(blocksArray);
        List<Node> path = aStar.findPath();
        for (Node node : path) {
            System.out.println(node);
        }
    }
    //Expected output without diagonals
    //Node [row=2, col=1]
    //Node [row=2, col=2]
    //Node [row=1, col=2]
    //Node [row=0, col=2]
    //Node [row=0, col=3]
    //Node [row=0, col=4]
    //Node [row=1, col=4]
    //Node [row=2, col=4]
    //Node [row=2, col=5]

    //Search Path without diagonals
    //      0   1   2   3   4   5   6
    // 0    -   -   *   *   *   -   -
    // 1    -   -   *   B   *   -   -
    // 2    -   I*  *   B   *  *F   -
    // 3    -   -   -   B   -   -   -
    // 4    -   -   -   -   -   -   -
    // 5    -   -   -   -   -   -   -




    public static void main(String[] args) {
        launch(args);



    }

}
