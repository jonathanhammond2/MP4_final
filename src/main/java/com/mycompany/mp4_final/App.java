package com.mycompany.mp4_final;

// import java.util.Arrays;
// import java.util.Random;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {
    //Added comment to make github work

    @Override
    public void start(Stage stage) {

        //Display the SortAlgPane
        SortAlgPane sortDisplay = new SortAlgPane();
        Scene scene = new Scene(sortDisplay, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        /*
        This extra code was used to test our sorting algorithms before
        We implemented them in the event handlers
        */

        // Random rand = new Random();
        
        
        
        // int[] a = {466, 722, 879, 123, 345, 256, 90, 23, 450, 321, 444};
        
        // for (int i = 0; i<11; i++){
        //     a[i] = rand.nextInt(1000);
        // }
        // Sorts.bubbleSort(a, 0, 10);
        
        // System.out.println(Arrays.toString(a));
        launch();
    }

}