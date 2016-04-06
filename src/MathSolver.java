import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * MathSolver created by Adam Howell
 * on 2016-04-05.
 */
public class MathSolver extends Application
{
	public static void main( String[] args )
	{
		launch( args );
	}


	public void start( Stage primaryStage )
	{
		double side_a;
		double side_b = 0.0;
		double side_c = 0.0;
		double angle_A = 0.0;
		double angle_B = 0.0;
		double angle_C = 0.0;
		double volume = 0.0;

		primaryStage.setTitle( "Math Solver" );

		// Create a new GridPane object to manipulate.
		GridPane grid = new GridPane();
		// Set the alignment to centered.
		grid.setAlignment( Pos.CENTER );
		// Set the gap between cells.
		grid.setHgap( 10 );
		grid.setVgap( 10 );
		// Set the padding around the outermost cells.
		grid.setPadding( new Insets( 25, 25, 25, 25 ) );

		Text sceneTitle = new Text( "Enter at least 3 values" );
		// Removing this line because we are using CSS now.
		//sceneTitle.setFont( Font.font( "Tahoma", FontWeight.NORMAL, 20 ) );
		// Create an ID for the sceneTitle so we can format it with CSS.
		sceneTitle.setId( "banner" );
		grid.add( sceneTitle, 0, 0, 2, 1 );
		Text sceneSubtext = new Text( "Triangle volume requires at least one side" );
		sceneSubtext.setId( "subText" );
		grid.add( sceneSubtext, 0, 5, 2, 1 );

		Label Side_a = new Label( "Side 'a'" );
		grid.add( Side_a, 0, 1 );

		TextField textField_a = new TextField();
		textField_a.setPrefWidth( 10.0 );
		grid.add( textField_a, 1, 1 );

		Label Angle_A = new Label( "Angle 'A'" );
		grid.add( Angle_A, 2, 1 );

		TextField textField_A = new TextField();
		grid.add( textField_A, 3, 1 );

		Label Side_b = new Label( "Side 'b'" );
		grid.add( Side_b, 0, 2 );

		TextField textField_b = new TextField();
		grid.add( textField_b, 1, 2 );

		Label Angle_B = new Label( "Angle 'B'" );
		grid.add( Angle_B, 2, 2 );

		TextField textField_B = new TextField();
		grid.add( textField_B, 3, 2 );

		Label Side_c = new Label( "Side 'c'" );
		grid.add( Side_c, 0, 3 );

		TextField textField_c = new TextField();
		grid.add( textField_c, 1, 3 );

		Label Angle_C = new Label( "Angle 'C'" );
		grid.add( Angle_C, 2, 3 );

		TextField textField_C = new TextField();
		grid.add( textField_C, 3, 3 );

		// Show grid lines for testing.
		//grid.setGridLinesVisible( true );

		// Create a button with the text "Calculate".
		Button btn = new Button( "Calculate" );
		// Create a HBox so we can use a different alignment from the other elements in the grid.
		HBox hbBtn = new HBox( 10 );
		hbBtn.setAlignment( Pos.BOTTOM_RIGHT );
		hbBtn.getChildren().add( btn );
		// Add the HBox button to row 1, column 4.
		grid.add( hbBtn, 3, 4 );

		// Add a text control to display the message.
		final Text actionTarget = new Text();
		grid.add( actionTarget, 1, 6 );
		// Create an ID for the actionTarget.
		actionTarget.setId( "actionTarget" );

		// Register an event handler to display text when the button is pressed.
		btn.setOnAction( e -> {
			// Removing this line because we are using CSS now.
			//actionTarget.setFill( Color.FIREBRICK );
			// Populate the subsection with whatever is in the fields.
			actionTarget.setText( textField_a.getText() + textField_b.getText() + textField_c.getText() + textField_A.getText() + textField_B.getText() + textField_C.getText() );
			// ToDo: Assign a field to a variable.
			//side_a = textField_a.getText();
			//side_a = Double.parseDouble( textField_a.getText() );
		} );

		// Create a scene measuring 300x275 and containing the 'grid' object.
		Scene scene = new Scene( grid, 500, 275 );
		primaryStage.setScene( scene );

		// Add a stylesheet to set the background.
		scene.getStylesheets().add( MathSolver.class.getResource( "MathSolver.css" ).toExternalForm() );

		primaryStage.show();
	}
}
