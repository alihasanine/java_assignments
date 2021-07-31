/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._joinary_tablesaw_xchart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.StringColumn;
import tech.tablesaw.api.Table;
import tech.tablesaw.columns.Column;

/**
 *
 * @author AsmaaAbdelkader
 */
public class Tablesaw {
   
    public static void main(String[] args) {
        try {
            var df1  = Table.create();
            df1 = Table.read().csv("titanic.csv");
            
            var df2 = Table.create();
            df2 = Table.read().csv("titanic_test.csv");
            
            var df = df1.concat(df2);
            //Summary aboud data
            System.out.println(df.summary());
            
            //factorize sex column
            StringColumn sexColumn = df.stringColumn("sex") ;
            List<Number> sexNumerical = new ArrayList<>() ;
            for (String val:sexColumn) {
                if (val.equals("male"))
                    sexNumerical.add(0);
                else if (val.equals("female"))
                    sexNumerical.add(1);
             }
            
            var col = DoubleColumn.create("numerical Sex",sexNumerical);
            df.insertColumn(3, col);
            System.out.println(df.first(5));
            
            
            List xValues =  df.column(9).asList();
            List yValues =  df.column(5).asList();

     


        XYChart chart = new XYChartBuilder().width(600).height(500).title("Titanic").xAxisTitle("X").yAxisTitle("Y").build();

        chart.addSeries("Titanic",xValues,yValues);
        chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Scatter);
        chart.getStyler().setMarkerSize(8);

        new SwingWrapper<>(chart).displayChart();

            
           
        } catch (IOException ex) {
            Logger.getLogger(Tablesaw.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
