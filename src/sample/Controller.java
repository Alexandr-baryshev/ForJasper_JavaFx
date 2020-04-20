package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller {

   @FXML
   private ResourceBundle resources;

   @FXML
   private URL location;

   @FXML
   private TextField rStart_p;

   @FXML
   private TextField rSize_p;

   @FXML
   private TextField cStart_p;

   @FXML
   private TextField cSize_p;

   @FXML
   private TextField sort_RC;

   @FXML
   private Button startButton;

   @FXML
   private TextArea inputTexField;

   @FXML
   private TextArea outText;

   @FXML
   void initialize() {
      startButton.setOnAction(event -> {
         int rStart = new Integer(rStart_p.getText());
         int rSize = new Integer(rSize_p.getText());
         int cStart = new Integer(cStart_p.getText());
         int cSize = new Integer(cSize_p.getText());
         String inputText = inputTexField.getText();

         if (sort_RC.getText().equals("R")) {
            outText.setText(sort_R(inputText, rStart, rSize, cStart, cSize));
         } else if (sort_RC.getText().equals("C")) {
            outText.setText(sort_C(inputText, rStart, rSize, cStart, cSize));
         } else {
            outText.setText("Введите приоритет сортировки R или C");
         }

      });
   }


   static String sort_C(String variable, int rStart, int rSize, int cStart, int cSize) {
      String row = "", column = "", allResult = "";

      int c = cStart;
      while (c <= cSize) {
         column = variable.replace("C1", "C" + c);

         int r = rStart;
         while (r <= rSize) {
            row = column.replace("R1", "R" + r);
            allResult = allResult + row + "\n";
            r++;
         }
         c++;
      }
      return (allResult);
   }


   static String sort_R(String variable, int rStart, int rSize, int cStart, int cSize) {
      String row = "", column = "", allResult = "";

      for (int r = rStart; r <= rSize; r += 1) {
         row = variable.replace("R1", "R" + r);

         for (int c = cStart; c <= cSize; c += 1) {
            column = row.replace("C1", "C" + c);
            allResult = allResult + column + "\n";
         }
      }
      return (allResult);
   }
}