/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mp4_final;

import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;

/**
 *
 * @author abw04
 */
public class SortAlgPane extends TabPane{
    
    //constructor -- create a SortAlgPane with one tab for each sorting algorithm
    public SortAlgPane() {
        
        
        AlgTab selectTab = new AlgTab(11, "Selection", AlgTab.Algorithms.selection);
        AlgTab insertTab = new AlgTab(11, "Insertion", AlgTab.Algorithms.insertion);
        AlgTab quickTab = new AlgTab(11, "Quick", AlgTab.Algorithms.quick);
        AlgTab bubbleTab = new AlgTab(11, "Bubble", AlgTab.Algorithms.bubble);
        
        getTabs().addAll(selectTab, insertTab, quickTab, bubbleTab);
        
    }
    
}
