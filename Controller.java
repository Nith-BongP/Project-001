import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private Button Button_result;

    @FXML
    private TextField Input_A;

    @FXML
    private TextField Input_B;

    @FXML
    private TextField Input_C;

    @FXML
    private Label result_x1;

    @FXML
    private Label result_x2;

    @FXML
    public void calculateResult(ActionEvent event) {

        System.out.println("Button clicked!");

        try {
            double a = Double.parseDouble(Input_A.getText());
            double b = Double.parseDouble(Input_B.getText());
            double c = Double.parseDouble(Input_C.getText());

            System.out.println("A = " + a);
            System.out.println("B = " + b);
            System.out.println("C = " + c);

            if (a == 0) {
                result_x1.setText("A cannot be 0");
                result_x2.setText("");
                return;
            }

            double delta = b * b - 4 * a * c;

            System.out.println("Delta = " + delta);

            if (delta > 0) {

                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);

                result_x1.setText(String.format("X1 = %.4f", x1));
                result_x2.setText(String.format("X2 = %.4f", x2));

            } else if (delta == 0) {

                double x = -b / (2 * a);

                result_x1.setText(String.format("X1 = %.4f", x));
                result_x2.setText(String.format("X2 = %.4f", x));

            } else {

                double real = -b / (2 * a);
                double imag = Math.sqrt(-delta) / (2 * a);

                result_x1.setText(
                        String.format("X1 = %.4f + %.4fi", real, imag));

                result_x2.setText(
                        String.format("X2 = %.4f - %.4fi", real, imag));
            }

            System.out.println(result_x1.getText());
            System.out.println(result_x2.getText());

        } catch (NumberFormatException e) {

            result_x1.setText("Invalid Input");
            result_x2.setText("Invalid Input");

            System.out.println("Invalid Input");
        }
    }
}