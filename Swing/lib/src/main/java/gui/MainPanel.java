package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private UserFormListener formListener;

	public MainPanel() {

		Color color = new Color(250,250,245);
		setBackground(color);

		var formLabel = new JLabel("Add User");
		formLabel.setFont(new Font("Sans Serif", Font.PLAIN, 35));
		
		setLayout(new GridBagLayout());
		var gc = new GridBagConstraints();
		
		gc.gridwidth = 2;
		
		gc.gridx = 0;
		gc.gridy = 0;		
		gc.weighty = 1;
		add(formLabel, gc);
		
		gc.gridy++;
		gc.gridx = 0;
		gc.weighty = 2;
		gc.anchor = GridBagConstraints.NORTH;
		add(createFormPanel(), gc);
				
	}
	public void setFormListener(UserFormListener formListener) {
		this.formListener = formListener;
	}
	
	private JPanel createFormPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.setBorder(BorderFactory.createEtchedBorder());
		
		var gc = new GridBagConstraints();

		var nameLabel = new JLabel("Name: ");
		var passLabel = new JLabel("Password: ");
		
		var nameField = new JTextField(20);
		var passField = new JTextField(20);
		var addButton = new JButton("Add");
		addButton.addActionListener(e -> {
			if (formListener != null) {
				formListener.formSubmitted(nameField.getText(), passField.getText());
			}
			nameField.setText("");
			passField.setText("");
		});
		
		gc.gridy = 0;
		gc.gridx = 0;
		gc.weighty = 1;
		gc.insets = new Insets(2,2,2,10);
		gc.anchor = GridBagConstraints.LINE_END;
		panel.add(nameLabel,gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(2,2,2,10);
		panel.add(nameField, gc);
		
		gc.gridy++;
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(2,2,2,10);
		panel.add(passLabel,gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(2,2,2,10);
		panel.add(passField, gc);
		
		gc.gridy++;
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.NORTHWEST;
		gc.insets = new Insets(20,160,2,0);
		panel.add(addButton, gc);

		return panel;
	}
}
