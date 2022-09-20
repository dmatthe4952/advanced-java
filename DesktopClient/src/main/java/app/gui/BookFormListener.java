package app.gui;

@FunctionalInterface
public interface BookFormListener {
	void formSubmitted(String title, String author);
}
