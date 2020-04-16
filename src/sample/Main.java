package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {

        launch(args);
        System.out.println(sort_R(v1,1,4, 1,4));
    }


    static String v1 = "\t<variable name=\"R1 C1\" class=\"java.lang.Integer\" calculation=\"DistinctCount\">\n" +
            "\t\t<variableExpression><![CDATA[$V{R1} && $V{C1} ? $F{Идентификатор происшествия} : null]]></variableExpression>\n" +
            "\t</variable>";

    static String sort_C(String variable,int rStart, int rSize, int cStart, int cSize){
        String row = "", column = "", allResult = "";

        int c = cStart;
        while (c <= cSize) {
            column = variable.replace("C1", "C" + c);

            int r = rStart;
            while (r <= rSize){
                row = column.replace("R1", "R" + r);
                allResult = allResult + row + "\n";
                r++;
            }
            c++;
        }
        return(allResult);
    }


    static String sort_R(String variable, int rStart, int rSize, int cStart, int cSize){
        String row = "", column = "", allResult = "";

        for (int r = rStart; r <= rSize; r+=1) {
            row = variable.replace("R1", "R" + r);

            for (int c = cStart; c <= cSize; c+=1){
                column = row.replace("C1", "C" + c);
                allResult = allResult + column + "\n";
            }
        }
        return(allResult);
    }
}


