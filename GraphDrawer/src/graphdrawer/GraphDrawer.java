/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphdrawer;

import java.awt.Color; 
import java.awt.BasicStroke; 

import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.data.xy.XYDataset; 
import org.jfree.data.xy.XYSeries; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities; 
import org.jfree.chart.plot.XYPlot; 
import org.jfree.chart.ChartFactory; 
import org.jfree.chart.plot.PlotOrientation; 
import org.jfree.data.xy.XYSeriesCollection; 
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;

public class GraphDrawer extends ApplicationFrame {

   public GraphDrawer( String applicationTitle, String chartTitle ) {
      super(applicationTitle);
      JFreeChart xylineChart = ChartFactory.createXYLineChart(
         chartTitle ,
         "Category" ,
         "Score" ,
         createDataset() ,
         PlotOrientation.VERTICAL ,
         true , true , false);
         
      ChartPanel chartPanel = new ChartPanel( xylineChart );
      chartPanel.setPreferredSize( new java.awt.Dimension( 1024 , 600 ) );
      final XYPlot plot = xylineChart.getXYPlot( );
      
      XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
      renderer.setSeriesPaint( 0 , Color.RED );
      renderer.setSeriesPaint( 1 , Color.BLUE );
      renderer.setSeriesStroke( 0 , new BasicStroke( 3.0f ) );
      renderer.setSeriesStroke( 1 , new BasicStroke( 3.0f ) );
      plot.setRenderer( renderer ); 
      setContentPane( chartPanel ); 
   }
   
   private XYDataset createDataset( ) {
      final XYSeries Directed = new XYSeries( "Directed" );          
      Directed.add( 1.0 , 1.0 );          
      Directed.add( 2.0 , 4.0 );          
      Directed.add( 3.0 , 3.0 );          
      
      final XYSeries UnDirected = new XYSeries( "UnDirected" );          
      UnDirected.add( 1.0 , 4.0 );          
      UnDirected.add( 2.0 , 5.0 );          
      UnDirected.add( 3.0 , 6.0 );                    
      
      final XYSeriesCollection dataset = new XYSeriesCollection( );          
      dataset.addSeries( Directed );          
      dataset.addSeries( UnDirected );
      return dataset;
   }

   public static void main( String[ ] args ) {
      GraphDrawer chart = new GraphDrawer("GraphDrawer",
         "Graph");
      chart.pack( );          
      RefineryUtilities.centerFrameOnScreen( chart );          
      chart.setVisible( true ); 
   }
}