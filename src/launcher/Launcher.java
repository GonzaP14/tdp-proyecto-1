package launcher;

import entities.Student;
import gui.SimplePresentationScreen;

public class Launcher {
	public static void main(String [] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	Student me = new Student(129565, "Perez", "Gonzalo", "gonzalomartinperez2002@gmail.com", "https://github.com/GonzaP14/tdp-proyecto-1", "/images/FotoPerfil.jpg");
            	SimplePresentationScreen app = new SimplePresentationScreen(me);
            	app.setVisible(true);
            }
        });
    }
}