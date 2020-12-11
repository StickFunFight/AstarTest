package sample;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import sample.json.*;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Main extends Application {


    //int[][] blocksArray;
    ArrayList<int[]> blocksArray;

    @Override
    public void start(Stage primaryStage) throws Exception {
        blocksArray = new ArrayList<>();
        FlowPane something = new FlowPane();
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(something, 300, 275));
        primaryStage.show();
        //haal de cordinaten op
        GetCords();

        Node initialNode = new Node(0, 0);
        Node finalNode = new Node(2, 5);
        int rows = 6;
        int cols = 7;
        AStar aStar = new AStar(rows, cols, initialNode, finalNode);
        //blocksArray = new int[][]{{1, 3}, {2, 3}, {3, 3}};
        aStar.setBlocks(blocksArray);
        List<Node> path = aStar.findPath();
        for (Node node : path) {
            System.out.println(node);
        }
    }

    public void GetCords() throws IOException, ParseException {
        try {

            URL oracle = new URL("https://bp6.adainforma.tk/helloworldbot/functions/datalayer/api/obstacle/?selector=ae026dd58cd57fd2&validator=4424bdd85905aa88646327911b6893598a279abb4f82466dca61a988041afb08&action=get");
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                JsonArray json = Json.parse(inputLine).asArray();

                for (Object o : json) {

                    JsonObject Cords = (JsonObject) o;
                    //haal de eerste coords op.
                    JsonValue Row = Cords.get("row1");
                    JsonValue Column = Cords.get("column1");
                    //haal de 2e coords op.
                    JsonValue Row2 = Cords.get("row2");
                    JsonValue Column2 = Cords.get("column2");

                    int iRow = Integer.parseInt(String.valueOf(Row));
                    int iColum = Integer.parseInt(String.valueOf(Column));
                    int iRow2 = Integer.parseInt(String.valueOf(Row2));
                    int iColum2 = Integer.parseInt(String.valueOf(Column2));

                    System.out.println(iRow);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        launch(args);


    }
}


