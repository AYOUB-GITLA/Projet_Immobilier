/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.util;

import java.awt.BorderLayout;
import java.sql.ResultSet;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;



/**
 *
 * @author Lenovo
 */
public class ChartUtil {

    // ================= PIE CHART =================
    public static void pieChart(JPanel panel, String titre, ResultSet rs) {
        try {
            DefaultPieDataset dataset = new DefaultPieDataset();

            while (rs.next()) {
                String label = rs.getString(1);
                double value = rs.getDouble(2);
                dataset.setValue(label, value);
            }

            JFreeChart chart = ChartFactory.createPieChart(
                    titre,
                    dataset,
                    true,
                    true,
                    false
            );

            ChartPanel cp = new ChartPanel(chart);

            panel.removeAll();
            panel.setLayout(new BorderLayout());
            panel.add(cp, BorderLayout.CENTER);
            panel.validate();
            panel.repaint();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ================= BAR CHART =================
    public static void barChart(
            JPanel panel,
            String titre,
            String axeX,
            String axeY,
            ResultSet rs
    ) {
        try {
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();

            while (rs.next()) {
                String categorie = rs.getString(1);
                double valeur = rs.getDouble(2);
                dataset.addValue(valeur, "Revenu", categorie);
            }

            JFreeChart chart = ChartFactory.createBarChart(
                    titre,
                    axeX,
                    axeY,
                    dataset
            );

            ChartPanel cp = new ChartPanel(chart);

            panel.removeAll();
            panel.setLayout(new BorderLayout());
            panel.add(cp, BorderLayout.CENTER);
            panel.validate();
            panel.repaint();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}