import java.util.prefs.Preferences;

final class ClockPreference {
	private Preferences prefs = Preferences.userNodeForPackage(this.getClass());
	private int[] data = {100, 100, 200, 200, 0, 5, 0, 11};
	private static final String keyBase = ".yuusuke.oy.ohta";
	private static final String[] keys = {
			"clock.x", "clock.y", "dialog.x", "dialog.y",
			"font", "size", "foreground.color", "background.color"
	};
	static {
		for (int i = 0; i < keys.length; i++) {
			keys[i] += keyBase;
		}
	}
	private static final int CLOCK_X          = 0; 
	private static final int CLOCK_Y          = 1; 
	private static final int DIALOG_X         = 2; 
	private static final int DIALOG_Y         = 3; 
	private static final int FONT             = 4; 
	private static final int SIZE             = 5; 
	private static final int FOREGROUND_COLOR = 6; 
	private static final int BACKGROUND_COLOR = 7; 
	
	ClockPreference() {
		load();
	}
	
	void setClockPosition(int x, int y) {
		data[CLOCK_X] = x;
		data[CLOCK_Y] = y;
	}
	
	void setDialogPosition(int x, int y) {
		data[DIALOG_X] = x;
		data[DIALOG_Y] = y;
	}
	
	void setFont(int font, int size, int foregroundColor, int backgroundColor) {
		data[FONT] = font;
		data[SIZE] = size;
		data[FOREGROUND_COLOR] = foregroundColor;
		data[BACKGROUND_COLOR] = backgroundColor;
	}
	
	void save() {
		for(int i = 0; i < keys.length; i++) {
			prefs.putInt(keys[i], data[i]);
		}
	}
	
	private void load() {
		for(int i = 0; i < keys.length; i++) {
			data[i] = prefs.getInt(keys[i], data[i]);
		}
	}
	
	int getClockX() {
		return data[CLOCK_X];
	}
	
	int getClockY() {
		return data[CLOCK_Y];
	}
	
	int getDialogX() {
		return data[DIALOG_X];
	}
	
	int getDialogY() {
		return data[DIALOG_Y];
	}
	
	int getFont() {
		return data[FONT];
	}
	
	int getSize() {
		return data[SIZE];
	}
	
	int getForegroundColor() {
		return data[FOREGROUND_COLOR];
	}
	
	int getBackgroundColor() {
		return data[BACKGROUND_COLOR];
	}
}