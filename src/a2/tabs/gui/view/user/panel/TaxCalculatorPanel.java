package a2.tabs.gui.view.user.panel;

import a2.tabs.gui.model.User;
import a2.tabs.gui.util.FormFieldType;
import a2.tabs.gui.util.TaxCalculator;
import a2.tabs.gui.view.user.Dashboard;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

@SuppressWarnings("FieldCanBeLocal")
public class TaxCalculatorPanel extends JPanel {

    private final User user;
    private final Dashboard dashboard;

    private JButton calculateButton;
    private JLabel pgTaxCalcTitle;
    private JTextField pgTaxCalcBracket1Display;
    private JTextField pgTaxCalcBracket2Display;
    private JTextField pgTaxCalcBracket3Display;
    private JTextField pgTaxCalcBracket4Display;
    private JTextField pgTaxCalcBracket5Display;
    private JLabel pgTaxCalcBracket1Label;
    private JLabel pgTaxCalcBracket2Label;
    private JLabel pgTaxCalcBracket3Label;
    private JLabel pgTaxCalcBracket4Label;
    private JLabel pgTaxCalcBracket5Label;
    private JTextField pgTaxCalcSalaryInput;
    private JTextField pgTaxCalcTotalTaxedAmountInput;
    private JTextField pgTaxCalcEffectiveTaxAmountInput;
    private JLabel pgTaxCalcSalaryLabel;
    private JLabel pgTaxCalcTotalTaxedAmountLabel;
    private JLabel pgTaxCalcEffectiveTaxAmountLabel;

    public TaxCalculatorPanel(User user, Dashboard dashboard) {
        this.user = user;
        this.dashboard = dashboard;
        initComponents();
    }

    private void initComponents() {
        pgTaxCalcTitle = new JLabel();
        pgTaxCalcSalaryLabel = new JLabel();
        pgTaxCalcSalaryInput = new JTextField();
        pgTaxCalcBracket1Label = new JLabel();
        pgTaxCalcBracket1Display = new JTextField();
        pgTaxCalcBracket2Label = new JLabel();
        pgTaxCalcBracket2Display = new JTextField();
        pgTaxCalcBracket3Label = new JLabel();
        pgTaxCalcBracket3Display = new JTextField();
        pgTaxCalcBracket4Label = new JLabel();
        pgTaxCalcBracket4Display = new JTextField();
        pgTaxCalcBracket5Label = new JLabel();
        pgTaxCalcBracket5Display = new JTextField();
        pgTaxCalcTotalTaxedAmountInput = new JTextField();
        pgTaxCalcTotalTaxedAmountLabel = new JLabel();
        pgTaxCalcEffectiveTaxAmountLabel = new JLabel();
        pgTaxCalcEffectiveTaxAmountInput = new JTextField();
        calculateButton = new JButton();

        setForeground(new Color(246, 247, 251));

        pgTaxCalcTitle.setFont(new Font("Bahnschrift", Font.BOLD, 36));
        pgTaxCalcTitle.setForeground(new Color(0, 100, 172));
        pgTaxCalcTitle.setText("Tax Calculator");

        pgTaxCalcSalaryLabel.setFont(new Font("Bahnschrift", Font.BOLD, 24));
        pgTaxCalcSalaryLabel.setForeground(new Color(153, 153, 153));
        pgTaxCalcSalaryLabel.setText("Salary To Check");

        pgTaxCalcSalaryInput.setBackground(new Color(204, 204, 204));
        pgTaxCalcSalaryInput.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
        pgTaxCalcSalaryInput.setForeground(new Color(102, 102, 102));
        pgTaxCalcSalaryInput.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
        pgTaxCalcSalaryInput.setCaretColor(new Color(102, 102, 102));
        pgTaxCalcSalaryInput.setOpaque(true);
        pgTaxCalcSalaryInput.setSelectionColor(new Color(252, 189, 27));
        pgTaxCalcSalaryInput.setText(String.valueOf(user.getSalary()));

        pgTaxCalcBracket1Label.setFont(new Font("Bahnschrift", Font.BOLD, 24));
        pgTaxCalcBracket1Label.setForeground(new Color(153, 153, 153));
        pgTaxCalcBracket1Label.setText("10.5%");

        pgTaxCalcBracket1Display.setBackground(new Color(204, 204, 204));
        pgTaxCalcBracket1Display.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
        pgTaxCalcBracket1Display.setForeground(new Color(102, 102, 102));
        pgTaxCalcBracket1Display.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
        pgTaxCalcBracket1Display.setCaretColor(new Color(102, 102, 102));
        pgTaxCalcBracket1Display.setOpaque(true);
        pgTaxCalcBracket1Display.setSelectionColor(new Color(252, 189, 27));
        pgTaxCalcBracket1Display.setEditable(false);

        pgTaxCalcBracket2Label.setFont(new Font("Bahnschrift", Font.BOLD, 24));
        pgTaxCalcBracket2Label.setForeground(new Color(153, 153, 153));
        pgTaxCalcBracket2Label.setText("17.5%");

        pgTaxCalcBracket2Display.setBackground(new Color(204, 204, 204));
        pgTaxCalcBracket2Display.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
        pgTaxCalcBracket2Display.setForeground(new Color(102, 102, 102));
        pgTaxCalcBracket2Display.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
        pgTaxCalcBracket2Display.setCaretColor(new Color(102, 102, 102));
        pgTaxCalcBracket2Display.setOpaque(true);
        pgTaxCalcBracket2Display.setSelectionColor(new Color(252, 189, 27));
        pgTaxCalcBracket2Display.setEditable(false);

        pgTaxCalcBracket3Label.setFont(new Font("Bahnschrift", Font.BOLD, 24));
        pgTaxCalcBracket3Label.setForeground(new Color(153, 153, 153));
        pgTaxCalcBracket3Label.setText("30%");

        pgTaxCalcBracket3Display.setBackground(new Color(204, 204, 204));
        pgTaxCalcBracket3Display.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
        pgTaxCalcBracket3Display.setForeground(new Color(102, 102, 102));
        pgTaxCalcBracket3Display.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
        pgTaxCalcBracket3Display.setCaretColor(new Color(102, 102, 102));
        pgTaxCalcBracket3Display.setOpaque(true);
        pgTaxCalcBracket3Display.setSelectionColor(new Color(252, 189, 27));
        pgTaxCalcBracket3Display.setEditable(false);

        pgTaxCalcBracket4Label.setFont(new Font("Bahnschrift", Font.BOLD, 24));
        pgTaxCalcBracket4Label.setForeground(new Color(153, 153, 153));
        pgTaxCalcBracket4Label.setText("33%");

        pgTaxCalcBracket4Display.setBackground(new Color(204, 204, 204));
        pgTaxCalcBracket4Display.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
        pgTaxCalcBracket4Display.setForeground(new Color(102, 102, 102));
        pgTaxCalcBracket4Display.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
        pgTaxCalcBracket4Display.setCaretColor(new Color(102, 102, 102));
        pgTaxCalcBracket4Display.setOpaque(true);
        pgTaxCalcBracket4Display.setSelectionColor(new Color(252, 189, 27));
        pgTaxCalcBracket4Display.setEditable(false);

        pgTaxCalcBracket5Label.setFont(new Font("Bahnschrift", Font.BOLD, 24));
        pgTaxCalcBracket5Label.setForeground(new Color(153, 153, 153));
        pgTaxCalcBracket5Label.setText("39%");

        pgTaxCalcBracket5Display.setBackground(new Color(204, 204, 204));
        pgTaxCalcBracket5Display.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
        pgTaxCalcBracket5Display.setForeground(new Color(102, 102, 102));
        pgTaxCalcBracket5Display.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
        pgTaxCalcBracket5Display.setCaretColor(new Color(102, 102, 102));
        pgTaxCalcBracket5Display.setOpaque(true);
        pgTaxCalcBracket5Display.setSelectionColor(new Color(252, 189, 27));
        pgTaxCalcBracket5Display.setEditable(false);

        pgTaxCalcTotalTaxedAmountInput.setBackground(new Color(204, 204, 204));
        pgTaxCalcTotalTaxedAmountInput.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
        pgTaxCalcTotalTaxedAmountInput.setForeground(new Color(102, 102, 102));
        pgTaxCalcTotalTaxedAmountInput.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
        pgTaxCalcTotalTaxedAmountInput.setCaretColor(new Color(102, 102, 102));
        pgTaxCalcTotalTaxedAmountInput.setOpaque(true);
        pgTaxCalcTotalTaxedAmountInput.setSelectionColor(new Color(252, 189, 27));
        pgTaxCalcTotalTaxedAmountInput.setEditable(false);

        pgTaxCalcTotalTaxedAmountLabel.setFont(new Font("Bahnschrift", Font.BOLD, 24));
        pgTaxCalcTotalTaxedAmountLabel.setForeground(new Color(153, 153, 153));
        pgTaxCalcTotalTaxedAmountLabel.setText("Total Taxed Amount");

        pgTaxCalcEffectiveTaxAmountLabel.setFont(new Font("Bahnschrift", Font.BOLD, 24));
        pgTaxCalcEffectiveTaxAmountLabel.setForeground(new Color(153, 153, 153));
        pgTaxCalcEffectiveTaxAmountLabel.setText("Effective Tax Rate");

        pgTaxCalcEffectiveTaxAmountInput.setBackground(new Color(204, 204, 204));
        pgTaxCalcEffectiveTaxAmountInput.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
        pgTaxCalcEffectiveTaxAmountInput.setForeground(new Color(102, 102, 102));
        pgTaxCalcEffectiveTaxAmountInput.setBorder(new LineBorder(new Color(204, 204, 204), 5, true));
        pgTaxCalcEffectiveTaxAmountInput.setCaretColor(new Color(102, 102, 102));
        pgTaxCalcEffectiveTaxAmountInput.setOpaque(true);
        pgTaxCalcEffectiveTaxAmountInput.setSelectionColor(new Color(252, 189, 27));
        pgTaxCalcEffectiveTaxAmountInput.setEditable(false);

        calculateButton.setIcon(new ImageIcon("C:\\Users\\Nathan\\Documents\\Files\\University\\Work\\2022\\Semester-1\\COMP603-12\\A2-TABS-GUI\\resources\\image\\TaxCalculatorPane-CalculateButton.png"));
        calculateButton.setBorder(null);
        calculateButton.setBorderPainted(false);
        calculateButton.setContentAreaFilled(false);

        calculateButton.addActionListener(evt -> {
            String input = pgTaxCalcSalaryInput.getText();
            FormFieldType ff = FormFieldType.DOUBLE;
            if (!ff.isValid(input)) {
                JOptionPane.showMessageDialog(null, "Please enter a valid salary", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double salary = Double.parseDouble(ff.getParsed(input));

            if (salary < 0 || salary > 10000000) {
                JOptionPane.showMessageDialog(null, "Please enter a non-zero positive salary", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            TaxCalculator calculator = new TaxCalculator(salary);

            pgTaxCalcBracket1Display.setText("$" + String.format("%.2f", calculator.getTax()[0]));
            pgTaxCalcBracket2Display.setText("$" + String.format("%.2f", calculator.getTax()[1]));
            pgTaxCalcBracket3Display.setText("$" + String.format("%.2f", calculator.getTax()[2]));
            pgTaxCalcBracket4Display.setText("$" + String.format("%.2f", calculator.getTax()[3]));
            pgTaxCalcBracket5Display.setText("$" + String.format("%.2f", calculator.getTax()[4]));

            pgTaxCalcTotalTaxedAmountInput.setText("$" + String.format("%.2f", calculator.getTotalTax()));
            pgTaxCalcEffectiveTaxAmountInput.setText(String.format("%.1f", calculator.getEffectiveTaxRate() * 100) + "%");
        });

        calculateButton.doClick();

        GroupLayout pgTaxCalculatorPanelLayout = new GroupLayout(this);
        setLayout(pgTaxCalculatorPanelLayout);
        pgTaxCalculatorPanelLayout.setHorizontalGroup(
                pgTaxCalculatorPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(pgTaxCalculatorPanelLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(pgTaxCalculatorPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(pgTaxCalcTitle, GroupLayout.PREFERRED_SIZE, 951, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(pgTaxCalcSalaryLabel, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(pgTaxCalculatorPanelLayout.createSequentialGroup()
                                                .addGroup(pgTaxCalculatorPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(pgTaxCalcTotalTaxedAmountLabel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(pgTaxCalcTotalTaxedAmountInput, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE))
                                                .addGap(18, 18, 18)
                                                .addGroup(pgTaxCalculatorPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(pgTaxCalcEffectiveTaxAmountLabel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(pgTaxCalcEffectiveTaxAmountInput, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(pgTaxCalculatorPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(GroupLayout.Alignment.LEADING, pgTaxCalculatorPanelLayout.createSequentialGroup()
                                                        .addComponent(pgTaxCalcSalaryInput, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(calculateButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGroup(GroupLayout.Alignment.LEADING, pgTaxCalculatorPanelLayout.createSequentialGroup()
                                                        .addGroup(pgTaxCalculatorPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(pgTaxCalcBracket1Label, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(pgTaxCalcBracket1Display, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
                                                        .addGap(18, 18, 18)
                                                        .addGroup(pgTaxCalculatorPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(pgTaxCalcBracket2Label, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(pgTaxCalcBracket2Display, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE))
                                                        .addGap(18, 18, 18)
                                                        .addGroup(pgTaxCalculatorPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(pgTaxCalcBracket3Label, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(pgTaxCalcBracket3Display, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE))
                                                        .addGap(18, 18, 18)
                                                        .addGroup(pgTaxCalculatorPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(pgTaxCalcBracket4Label, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(pgTaxCalcBracket4Display, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE))
                                                        .addGap(18, 18, 18)
                                                        .addGroup(pgTaxCalculatorPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(pgTaxCalcBracket5Label, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(pgTaxCalcBracket5Display, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pgTaxCalculatorPanelLayout.setVerticalGroup(
                pgTaxCalculatorPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(pgTaxCalculatorPanelLayout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(pgTaxCalcTitle, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pgTaxCalcSalaryLabel, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(pgTaxCalculatorPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(calculateButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(pgTaxCalcSalaryInput))
                                .addGroup(pgTaxCalculatorPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(pgTaxCalculatorPanelLayout.createSequentialGroup()
                                                .addGap(31, 31, 31)
                                                .addGroup(pgTaxCalculatorPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(pgTaxCalculatorPanelLayout.createSequentialGroup()
                                                                .addComponent(pgTaxCalcBracket1Label, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(pgTaxCalcBracket1Display, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(pgTaxCalculatorPanelLayout.createSequentialGroup()
                                                                .addComponent(pgTaxCalcBracket2Label, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(pgTaxCalcBracket2Display, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(pgTaxCalculatorPanelLayout.createSequentialGroup()
                                                                .addComponent(pgTaxCalcBracket3Label, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(pgTaxCalcBracket3Display, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(pgTaxCalculatorPanelLayout.createSequentialGroup()
                                                                .addComponent(pgTaxCalcBracket5Label, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(pgTaxCalcBracket5Display, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(pgTaxCalculatorPanelLayout.createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addComponent(pgTaxCalcBracket4Label, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(pgTaxCalcBracket4Display, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(41, 41, 41)))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(pgTaxCalcTotalTaxedAmountLabel, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(pgTaxCalcTotalTaxedAmountInput, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(pgTaxCalculatorPanelLayout.createSequentialGroup()
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(pgTaxCalcEffectiveTaxAmountLabel, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(pgTaxCalcEffectiveTaxAmountInput, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)))
                                .addGap(101, 101, 101))
        );
    }
}
