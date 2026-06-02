import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

    @FXML private TextField Input_A;
    @FXML private TextField Input_B;
    @FXML private TextField Input_C;
    @FXML private Label Label_X1;
    @FXML private Label Label_X2;

    @FXML
    public void calculateResult() {

        try {

            double a = Double.parseDouble(Input_A.getText());
            double b = Double.parseDouble(Input_B.getText());
            double c = Double.parseDouble(Input_C.getText());

            if (a == 0) {
                Label_X1.setText("A cannot be 0");
                Label_X2.setText("");
                return;
            }
            double discriminant = b * b - 4 * a * c;

            // Two real roots
            if (discriminant > 0) {

                double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);

                Label_X1.setText(String.format("%.4f", x1));
                Label_X2.setText(String.format("%.4f", x2));

            }

            // One real root
            else if (discriminant == 0) {

                double x1 = -b / (2 * a);

                Label_X1.setText(String.format("%.4f", x1));
                Label_X2.setText("Same as X1");

            }

            // Complex roots
            else {

                double realPart = -b / (2 * a);
                double imagPart = Math.sqrt(-discriminant) / (2 * a);

                Label_X1.setText(
                    String.format("%.4f + %.4fi",
                    realPart, imagPart)
                );

                Label_X2.setText(
                    String.format("%.4f - %.4fi",
                    realPart, imagPart)
                );
            }

        } catch (NumberFormatException e) {

            Label_X1.setText("Invalid input");
            Label_X2.setText("Invalid input");
        }
    }
}