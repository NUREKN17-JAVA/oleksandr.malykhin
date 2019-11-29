package UM.malykhin.nure.gui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import UM.malykhin.nure.User;

public class UserTableModel extends AbstractTableModel {

	private static final String[] COLUMN_NAMES = {"ID", "Имя", "Фамилия"};
	private static final Class[] COLUMN_CLASSES = {Long.class, String.class, String.class,};
	private List users = null;
	
	public UserTableModel(Collection users)
	{
		this.users = new ArrayList(users);
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return COLUMN_NAMES.length;
	}

	@Override
	public int getRowCount() {
		return users.size();
	}
	

	@Override
	public Class getColumnClass(int columIndex) {
		// TODO Auto-generated method stub
		return COLUMN_CLASSES[columIndex];
	}

	@Override
	public String getColumnName(int colum) {
		return COLUMN_NAMES[colum];
	}

	@Override
	public Object getValueAt(int rowIndex, int columIndex) {
		User user = (User) users.get(rowIndex);
		switch (columIndex)
		{
		case 0:
			return user.getId();
		case 1:
			return user.getFirstName();
		case 2:
			return user.getLastName();
		}
		return null;
	}

}
