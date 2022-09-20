package app.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CreateBookPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	public BookFormListener formListener;
	
	public CreateBookPanel() {
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
				
		gc.gridy = 0;
		gc.gridx = 0;
		gc.weightx=1;

		add(createFormPanel(), gc);
	}
	
	public void setFormListener(BookFormListener formListener) {
		this.formListener = formListener;
	}

	private JPanel createFormPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.setBorder(BorderFactory.createEtchedBorder());
		
		var gc = new GridBagConstraints();

		var titleLabel = new JLabel("Title: ");
		var authorLabel = new JLabel("Author: ");
		
		var titleField = new JTextField(60);
		var authorField = new JTextField(60);
		var addButton = new JButton("Add");
		addButton.addActionListener(e -> {
			if (formListener != null) {
				formListener.formSubmitted(titleField.getText(), authorField.getText());
			}
			titleField.setText("");
			authorField.setText("");
		});
		
		gc.gridy = 0;
		gc.gridx = 0;
		gc.weighty = 1;
		gc.insets = new Insets(2,2,2,10);
		gc.anchor = GridBagConstraints.LINE_END;
		panel.add(titleLabel,gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(2,2,2,10);
		panel.add(titleField, gc);
		
		gc.gridy++;
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(2,2,2,10);
		panel.add(authorLabel,gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(2,2,2,10);
		panel.add(authorField, gc);
		
		gc.gridy++;
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(20,170,5,12);
		panel.add(addButton, gc);

		return panel;
	}

	
}
