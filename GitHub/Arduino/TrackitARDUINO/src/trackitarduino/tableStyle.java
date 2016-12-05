package trackitarduino;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class tableStyle extends DefaultTableCellRenderer {

  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
    JLabel cell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    if (column == 3) {
      if (value.equals("Libre")) {
        cell.setBackground(Color.WHITE);
      }
      if (value.equals("Subió")) {
        cell.setBackground(Color.GREEN);
      }
      if (value.equals("Bajó")) {
        cell.setBackground(Color.RED);
      }
    }

    return cell;
  }
}
