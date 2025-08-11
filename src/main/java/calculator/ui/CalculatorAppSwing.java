/* Simplified without details section */
package calculator.ui;

import calculator.core.CalculatorCore;
import calculator.core.DomainException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CalculatorAppSwing extends JFrame {
    private JTextField inputField;
    private JRadioButton radBtn, degBtn;
    private JLabel resultLabel;

    public static final String VERSION = "1.0.0";


    public CalculatorAppSwing() {
        super("Arccos(x) Calculator v" + VERSION);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        setPreferredSize(new Dimension(500, 300));

        setUIStyles();

        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBackground(new Color(240, 245, 250));
        inputPanel.setBorder(new EmptyBorder(20, 20, 10, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel title = new JLabel("Arccos(x) Calculator", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 22));
        title.setForeground(new Color(30, 60, 130));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        inputPanel.add(title, gbc);

        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel prompt = new JLabel("Enter x (−1 ≤ x ≤ 1):");
        prompt.setForeground(new Color(50, 50, 70));
        inputPanel.add(prompt, gbc);
        inputField = new JTextField(10);
        gbc.gridx = 1;
        inputPanel.add(inputField, gbc);

        radBtn = new JRadioButton("Radians", true);
        degBtn = new JRadioButton("Degrees");
        radBtn.setBackground(new Color(240, 245, 250));
        degBtn.setBackground(new Color(240, 245, 250));
        ButtonGroup group = new ButtonGroup();
        group.add(radBtn);
        group.add(degBtn);
        JPanel units = new JPanel(new FlowLayout(FlowLayout.LEFT));
        units.setBackground(new Color(240, 245, 250));
        units.add(radBtn);
        units.add(degBtn);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        inputPanel.add(units, gbc);

        JButton calcBtn = new JButton("Calculate");
        calcBtn.setPreferredSize(new Dimension(160, 40));
        calcBtn.setBackground(new Color(30, 60, 130));
        calcBtn.setForeground(Color.WHITE);
        gbc.gridy = 3;
        inputPanel.add(calcBtn, gbc);

        add(inputPanel, BorderLayout.NORTH);

        resultLabel = new JLabel("Result: ", SwingConstants.CENTER);
        resultLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        resultLabel.setForeground(new Color(20, 40, 90));
        resultLabel.setBorder(new EmptyBorder(10, 0, 10, 0));
        add(resultLabel, BorderLayout.CENTER);

        inputField.getDocument().addDocumentListener(new SimpleDocumentListener() {
            public void update() {
                try {
                    Double.parseDouble(inputField.getText());
                    calcBtn.setEnabled(true);
                } catch (Exception e) {
                    calcBtn.setEnabled(false);
                }
            }
        });

        calcBtn.addActionListener((ActionEvent e) -> {
            try {
                double x = Double.parseDouble(inputField.getText());
                CalculatorCore.validateInput(x);
                double val = CalculatorCore.computeArccos(x);
                double displayVal = radBtn.isSelected() ? val : Math.toDegrees(val);
                resultLabel.setText(String.format("Result: %.6f %s", displayVal, radBtn.isSelected() ? "rad" : "°"));
            } catch (DomainException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Domain Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "An unexpected error occurred.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        pack();
        setLocationRelativeTo(null);
    }

    private void setUIStyles() {
        UIManager.getDefaults().entrySet().forEach(e -> {
            if (e.getValue() instanceof FontUIResource) {
                UIManager.put(e.getKey(), new FontUIResource("Segoe UI", Font.PLAIN, 14));
            }
            if (e.getValue() instanceof ColorUIResource) {
                ColorUIResource c = (ColorUIResource) e.getValue();
                if (c.equals(ColorUIResource.GRAY)) {
                    UIManager.put(e.getKey(), new ColorUIResource(240, 245, 250));
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalculatorAppSwing().setVisible(true));
    }
}
