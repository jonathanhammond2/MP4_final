/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mp4_final;

//import static com.mycompany.miniproject4.Sorts.selectionSort;
//import static com.mycompany.miniproject4.Sorts.swapElements;
import java.util.Arrays;
import java.util.LinkedList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import java.util.Random;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 *
 * @author abw04
 */
public class AlgTab extends Tab{
    private Random rand = new Random();
    private TextField[] inputFields;
    private Text[] outputDisplay;
    private int numFields;
    private int[] userData;
    private Button randButton;
    private Button stepButton;
    private Button resetButton;
    private VBox outputBox;
    private BorderPane tabContent;
    private LinkedList<Text> quickText = new LinkedList<Text>();
    
    //the constructor will require a sorting algorithm as an argument
    //the algorithm choices are represented by the enum Algorithms
    public static enum Algorithms { 
        selection, insertion, quick, merge
    }
    
    
    public AlgTab(int numFields, String title, Algorithms alg) {
        super(title);
        this.numFields = numFields;
        
        inputFields = new TextField[numFields];
        randButton = new Button("Random Numbers");
        stepButton = new Button("Show Next Step");
        resetButton = new Button("Reset Data");
        
        
        randButton.setOnAction(this::processRandomButton);
        
        //decide which event handler to use depending on which algorithm is
        //selected in the constructor
        switch (alg) {
            case selection:
                stepButton.setOnAction(this::processSelectionStepButton);
                break;
            case insertion:
                stepButton.setOnAction(this::processInsertionStepButton);
                break;
            case quick:
                stepButton.setOnAction(this::processQuickStepButton);
                break;
            case merge:
                stepButton.setOnAction(this::processMergeStepButton);
                break;
            default:
                stepButton.setOnAction(this::processSelectionStepButton);
        }
        
        
        
        HBox fieldBox = new HBox();
        HBox buttonBox = new HBox();
        tabContent = new BorderPane();
        
        //arrange the TextFields in an HBox
        for (int i = 0; i < inputFields.length; i++) {
            inputFields[i] = new TextField();
            fieldBox.getChildren().add(inputFields[i]);
        }
        
        //arrange the buttons in an HBox as well
        buttonBox.getChildren().add(randButton);
        buttonBox.getChildren().add(stepButton);
        buttonBox.getChildren().add(resetButton);
        
        //FIXME: ARRANGE TEXT OBJECTS IN A VBOX TO DISPLAY
        //EACH STEP IN THE PROCESS
        
        
        
        tabContent.setTop(fieldBox);
        tabContent.setCenter(buttonBox);
        
        setContent(tabContent);
    }
    
    
    
    
    
    private void quickSortSwapElements(int[] a, int i, int  j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        quickText.add(new Text("Swapping indices [" + i + "," + j + "] " + Arrays.toString(userData)));
    }
    
    private void quickSortEnd(int[] a, int first, int last) {
        for (int i = first; i < last; i++) {
            int minValue = a[i];
            int minValIndex = i;
            
            for (int j = i + 1; j < last; j++) {
                if (a[j] < minValue) {
                    minValue = a[j];
                    minValIndex = j;
                    
                }
            }
            
            if (i != minValIndex) {
                quickSortSwapElements(a, i, minValIndex);
            }
            
            
        }
        System.out.println(Arrays.toString(a));
    }

    private void quickSortWorks(int[] a, int first, int last) {

        // Only do quicksort for more than three elements
        if ((last - first) > 3) {
            // Sort the first, middle and last elements into their positions
            int mid = first + (last - first) / 2;
            if (a[first] > a[mid]) {
                quickSortSwapElements(a, first, mid);
            }
            if (a[mid] > a[last]) {
                quickSortSwapElements(a, mid, last);
            }
            if (a[first] > a[mid]) {
                quickSortSwapElements(a, first, mid);
            }
//            System.out.println(first + " " + last + " " + mid);
//            System.out.println(Arrays.toString(a));
            // Move the pivot to the end
            quickSortSwapElements(a, mid, last - 1);
            int pivotValue = a[last - 1];

            // Now start from both sides and work inward
            int indexFromLeft = first + 1;
            int indexFromRight = last - 2;
            boolean done = false;
            while (!done) {
                // Find a place where the left hand side and the right hand
                // side each have a value that doesn't belong and swap them
                while (a[indexFromLeft] < pivotValue) {
                    indexFromLeft++;
                }
                while (a[indexFromRight] > pivotValue) {
                    indexFromRight--;
                }
                // When we're there, swap those elements and
                // keep doing that until the two counters cross
                if (indexFromLeft < indexFromRight) {
                    quickSortSwapElements(a, indexFromLeft, indexFromRight);
                    indexFromLeft++;
                    indexFromRight--;
                } else {
                    done = true;
                }
            }
            // Once they cross, we swap the pivot into its location
            quickSortSwapElements(a, last - 1, indexFromLeft);
//            System.out.println(Arrays.toString(a));
            // And then sort each side
            quickSortWorks(a, first, indexFromLeft - 1);
            quickSortWorks(a, indexFromLeft + 1, last);

        } else {
            // Just use a simpler sort if the number of elements is small
            quickSortEnd(a, first, last + 1);
        }
    }
    
    private void quickSortPrint(int[] a, int first, int last) {
        if (last - first > 3) {
            int mid = first + (last - first) / 2;
            
            if (a[first] > a[mid]) {
                quickSortSwapElements(a, first, mid);
            }
            if (a[mid] > a[last - 1]) {
                quickSortSwapElements(a, mid, last);
            }
            if (a[first] > a[mid]) {
                quickSortSwapElements(a, first, mid);
            }
            
            quickSortSwapElements(a, mid, last - 1);
            int pivotValue = a[last - 1];
            
            int indexFromLeft = first + 1;
            int indexFromRight = last - 2;
            boolean done = false;
            
            while (!done) {
                while (a[indexFromLeft] < pivotValue) {
                    indexFromLeft++;
                }
                while (a[indexFromRight] > pivotValue) {
                    indexFromRight--;
                }
                if (indexFromLeft < indexFromRight) {
                    quickSortSwapElements(a, indexFromLeft, indexFromRight);
                    indexFromLeft++;
                    indexFromRight--;
                } else {
                    done = true;
                }
                
            }
            
            quickSortSwapElements(a, last - 1, indexFromLeft);
            
            quickSortPrint(a, first, indexFromLeft);
            quickSortPrint(a, indexFromLeft + 1, last);
            
            
        } else {
            quickSortEnd(a, first, last+1);
        }
        
        System.out.println(Arrays.toString(a));
    }
    
    //Generate random data in the TextFields
    private void processRandomButton(ActionEvent e) {
        for (TextField field : inputFields) {
            field.setText(Integer.toString(rand.nextInt(1000)));
        }
    }
    
    //Event handlers for each sorting algorithm
    //Which event handler is used will depend on which
    //sorting algorithm is selected in the constructor
    private void processSelectionStepButton(ActionEvent e) {
        userData = new int[numFields];
        outputDisplay = new Text[numFields];
        outputBox = new VBox();
        
        for (int i = 0; i < numFields; i++) {
            userData[i] = Integer.parseInt(inputFields[i].getText());
            
        }
        //Array of text objects to hold the updated userData array
        //after each step
        
        
        
        
        
        
//        System.out.println(Arrays.toString(userData));
//        
//        Sorts.selectionSort(userData, 0, numFields);
        for (int i = 0; i < numFields; i++) {
            int minValue = userData[i];
            int minValIndex = i;
            
            for (int j = i + 1; j < numFields; j++) {
                if (userData[j] < minValue) {
                    minValue = userData[j];
                    minValIndex = j;
                    
                }
            }
            
            if (i != minValIndex) {
                Sorts.swapElements(userData, i, minValIndex);
            }
            
            outputDisplay[i] = new Text("Step " + (i + 1) + " "
                    + "Swap indices " + i + " " + (minValIndex)+ " " + Arrays.toString(userData));
            outputBox.getChildren().add(outputDisplay[i]);
        }
        System.out.println(Arrays.toString(userData));
        
//        outputDisplay = new Text[numFields];
//        for (int i = 0; i < numFields; i++) {
//            outputDisplay[i] = new Text(Arrays.toString(userData));
//        }
        
        //System.out.println(Arrays.toString(outputDisplay));
        
//        for (int i = 0; i < numFields; i++) {
//            inputFields[i].setText(Integer.toString(userData[i]));
//        }
        
        tabContent.setBottom(outputBox);
    }
    
    private void processInsertionStepButton(ActionEvent e) {
        userData = new int[numFields];
        outputDisplay = new Text[numFields];
        outputBox = new VBox();
        
        for (int i = 0; i < numFields; i++) {
            userData[i] = Integer.parseInt(inputFields[i].getText());
            
        }
        
        for (int i = 1; i < numFields; i++) {
            int next = userData[i];
            
            int fillIndex = i - 1;
            int initialFillIndex = i - 1;
            while (fillIndex >= 0 && next < userData[fillIndex]) {
                userData[fillIndex + 1] = userData[fillIndex];
                fillIndex--;
            }
            
            userData[fillIndex + 1] = next;
            
            
            if (fillIndex == i - 1) {
                outputDisplay[i] = new Text("No change");
            } else {
                outputDisplay[i] = new Text("Step " + i + ": [Index " + i + " moved to index " + (fillIndex  + 1) + "] " + Arrays.toString(userData));
            }
            
            outputBox.getChildren().add(outputDisplay[i]);
        }
        
        tabContent.setBottom(outputBox);
    }
    
    private void processQuickStepButton(ActionEvent e) {
        userData = new int[numFields];
        outputBox = new VBox();
        
       
        
        for (int i = 0; i < numFields; i++) {
            userData[i] = Integer.parseInt(inputFields[i].getText());
            
        }
        
         quickSortWorks(userData,0,userData.length-1);
        
        for (int i=0;i<quickText.size();i++){
            outputBox.getChildren().add(quickText.get(i));
        }
        
        tabContent.setBottom(outputBox);
        
        
    }
    
    private void processMergeStepButton(ActionEvent e) {
        
    }
    
}
