package UI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.BorderLayout;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class Chart extends JFrame
{
    public void displayChart(JTable table) {
        // Lấy dữ liệu từ cột size
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int columnCount = model.getColumnCount();
        int rowCount = model.getRowCount();
        double[] data = new double[rowCount];
        for (int i = 0; i < rowCount; i++) {
            data[i] = Double.parseDouble(model.getValueAt(i, 3).toString());
        }
        
        // Tạo biểu đồ
        JFreeChart chart = ChartFactory.createBarChart("Size Chart", "Item", "Size", createDataset(data), PlotOrientation.VERTICAL, true, true, false);
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.BLACK);
        
        // Tạo giao diện hiển thị biểu đồ
        ChartPanel panel = new ChartPanel(chart);
        JFrame frame = new JFrame("Size Chart");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(panel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
    
    private CategoryDataset createDataset(double[] data) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < data.length; i++) {
            dataset.addValue(data[i], "Size", String.valueOf(i + 1));
        }
        return dataset;
    }
}
