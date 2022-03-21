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
    private AlgTab[] theTabs;
    private int numTabs;
    
    //constructor -- create a SortAlgPane with numTabs tabs
    public SortAlgPane(int numTabs) {
        numTabs = numTabs;
        AlgTab selectTab = new AlgTab(11, "Selection", AlgTab.Algorithms.selection);
        AlgTab insertTab = new AlgTab(11, "Insertion", AlgTab.Algorithms.insertion);
        AlgTab quickTab = new AlgTab(11, "Quick", AlgTab.Algorithms.quick);
        
        getTabs().addAll(selectTab, insertTab, quickTab);
        
    }
    
}
