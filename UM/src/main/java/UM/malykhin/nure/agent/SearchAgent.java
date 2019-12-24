package UM.malykhin.nure.agent;

import UM.malykhin.nure.db.DaoFactory;
import UM.malykhin.nure.db.DatabaseException;
import jade.core.Agent;

import java.sql.SQLException;
import java.util.Collection;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

public class SearchAgent extends Agent {
	
	private AID[] aids;
	private SearchGui gui = null;
	
	protected void setup() {
		super.setup();
		System.out.println(getAID().getName() + " started");
	}
	
	protected void takeDown() {
		System.out.println(getAID().getName() + " terminated");
		super.takeDown();
	}
	
	public void search(String firstName, String lastName) throws SQLException {
		try {
			Collection users = DaoFactory.getInstance().getUserDao().find(firstName, lastName);
			if (users.size() > 0) {
				showUsers(users);
			} else {
				addBehaviour(new SearchRequestBehaviour(aids, firstName, lastName));
			}
		} catch (DatabaseException e) {
			throw new SQLException(e);
		}

	}
	
	void showUsers(Collection user) {
		gui.addUsers(user);
	}
	
}
