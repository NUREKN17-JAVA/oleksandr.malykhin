package UM.malykhin.nure.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import UM.malykhin.nure.db.DatabaseException;
import UM.malykhin.nure.util.Messages;

public class BrowsePanel extends JPanel implements ActionListener {

	private static final String ADD_COMMAND = "add"; //$NON-NLS-1$
	private static final String EDIT_COMMAND = "edit"; //$NON-NLS-1$
	private static final String DELETE_COMMAND = "delete"; //$NON-NLS-1$
	private static final String DETAILS_COMMAND = "details"; //$NON-NLS-1$
	private static final String DETAILS_BUTTON_COMPONENT_NAME = "detailsButton"; //$NON-NLS-1$
	private static final String EDIT_BUTTON_COMPONENT_NAME = "editButton"; //$NON-NLS-1$
	private static final String DELETE_BUTTON_COMPONENT_NAME = "deleteButton"; //$NON-NLS-1$
	private static final String ADD_BUTTON_COMPONENT_NAME = "addButton"; //$NON-NLS-1$
	private static final String USER_TABLE_COMPONENT_NAME = "userTable"; //$NON-NLS-1$
	private static final String BROWSE_PANEL_COMPONENT_NAME = "browsePanel"; //$NON-NLS-1$
	
	private MainFrame parent;
	private JScrollPane tablePanel;
	private JTable userTable;
	private JPanel buttonsPanel;
	private JButton addButton;
	private JButton editButton;
	private JButton deleteButton;
	private JButton detailsButton;
	
	public BrowsePanel(MainFrame mainFrame) {
		parent = mainFrame;
		initialize();
	}
	private void initialize() {
		this.setName(BROWSE_PANEL_COMPONENT_NAME);
		this.setLayout(new BorderLayout());
		this.add(getTablePanel(), BorderLayout.CENTER);
		this.add(getButtonsPanel(), BorderLayout.SOUTH);
	}
	private JPanel getButtonsPanel() {
		if (buttonsPanel == null) {
			buttonsPanel = new JPanel();
			buttonsPanel.add(getAddButton(), null);
			buttonsPanel.add(getEditButton(), null);
			buttonsPanel.add(getDeleteButton(), null);
			buttonsPanel.add(getDetailsButton(), null);
		}
		return buttonsPanel;
	}
	private JButton getEditButton() {
		if (editButton == null) {
			editButton = new JButton();
			editButton.setText(Messages.getString("BrowsePanel.edit")); //localize //$NON-NLS-1$
			editButton.setName(EDIT_BUTTON_COMPONENT_NAME);
			editButton.setActionCommand(EDIT_COMMAND);
			editButton.addActionListener(this);
		}
		return editButton;
	}
	
	private JButton getDeleteButton() {
		if (deleteButton == null) {
			deleteButton = new JButton();
			deleteButton.setText(Messages.getString("BrowsePanel.delete")); //localize //$NON-NLS-1$
			deleteButton.setName(DELETE_BUTTON_COMPONENT_NAME);
			deleteButton.setActionCommand(DELETE_COMMAND);
			deleteButton.addActionListener(this);
		}
		return deleteButton;
	}
	
	private JButton getDetailsButton() {
		if (detailsButton == null) {
			detailsButton = new JButton();
			detailsButton.setText(Messages.getString("BrowsePanel.details")); //localize //$NON-NLS-1$
			detailsButton.setName(DETAILS_BUTTON_COMPONENT_NAME);
			detailsButton.setActionCommand(DETAILS_COMMAND);
			detailsButton.addActionListener(this);
		}
		return detailsButton;
	}
	
	private JButton getAddButton() {
		if (addButton == null) {
			addButton = new JButton();
			addButton.setText(Messages.getString("BrowsePanel.add")); //localize //$NON-NLS-1$
			addButton.setName(ADD_BUTTON_COMPONENT_NAME);
			addButton.setActionCommand(ADD_COMMAND);
			addButton.addActionListener(this);
		}
		return addButton;
	}
	private JScrollPane getTablePanel() {
		if (tablePanel == null) {
			tablePanel = new JScrollPane(getUserTable());
		}
		return tablePanel;
	}
	private JTable getUserTable() {
		if (userTable == null) {
			userTable = new JTable();
			userTable.setName(USER_TABLE_COMPONENT_NAME);
		}
//		UserTableModel model;
//		try {
//			model = new UserTableModel(parent.getDao().findAll());
//		}
//		catch(DataBaseException e) {
//			model = new UserTableModel(new ArrayList());
//			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//		}
//		userTable.setModel(model);
		return userTable;
	}
	
	public void initTable() {
		UserTableModel model;
		try {
			model = new UserTableModel(parent.getDao().findAll());
		} catch (DatabaseException e) {
			model = new UserTableModel(new ArrayList());
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		getUserTable().setModel(model);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if ("add".equalsIgnoreCase(actionCommand)) { //$NON-NLS-1$
			this.setVisible(false);
			parent.showAddPanel();
		}
		
	}
}