/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._joinary_tablesaw_xchart;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import joinery.DataFrame;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.StringColumn;

/**
 *
 * @author AsmaaAbdelkader
 */
public class Joinary {
    
    public static void main(String[] args) {
        try {
            DataFrame<Object> df1 = DataFrame.readCsv("titanic.csv");
          
            // explaratory data analysis
            //System.out.println(df.describe());
            
           var df2 = DataFrame.readCsv("titanic_test.csv");
           
           var df = df1.join(df2);
            System.out.println(df.columns());
            
           int [] classes = new int[3];
           int index;
            List<Object> Pclass = df.col(0);
            for (var c : Pclass){
                index = Integer.parseInt(c.toString());
                classes[index-1]++;
            }
               
            System.out.println(classes[0]);
            
            
           PieChart chart = new PieChartBuilder().width(800).height(600).title("Pclass values").build();
 
            // Customize Chart
            Color[] sliceColors = new Color[] { new Color(224, 68, 14), new Color(230, 105, 62), new Color(236, 143, 110), new Color(243, 180, 159), new Color(246, 199, 182) };
            chart.getStyler().setSeriesColors(sliceColors);
 
            // Series
           
            chart.addSeries("Class 1", classes[0]);
            chart.addSeries("Class 2", classes[1]);
            chart.addSeries("Class 3", classes[2]);
           
 
            new SwingWrapper<>(chart).displayChart();

             
            
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(Joinary.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    
}

