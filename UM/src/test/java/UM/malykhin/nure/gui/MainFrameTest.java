package UM.malykhin.nure.gui;

import java.awt.Component;
import java.awt.Window;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import junit.extensions.jfcunit.JFCTestCase;
import junit.extensions.jfcunit.JFCTestHelper;
import junit.extensions.jfcunit.finder.NamedComponentFinder;

class MainFrameTest extends JFCTestCase {

	private Window mainFrame;

	@BeforeEach
	protected void setUp() throws Exception {
		super.setUp();
		setHelper(new JFCTestHelper());
		mainFrame = new MainFrame();
		mainFrame.setVisible(true);
	}

	@AfterEach
	protected void tearDown() throws Exception {
		mainFrame.setVisible(false);
		getHelper().cleanUp(this);
		super.tearDown();
	}
	
	private Component find(Class componentClass, String name)
	{
		NamedComponentFinder finder;
		finder = new NamedComponentFinder(componentClass,name);
		Component component = finder.find(mainFrame, 0);
		assertNotNull("Could not find component '" + name +"'", component);
		return component;
	}
	
	
	
	
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
