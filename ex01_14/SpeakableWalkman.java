
public class SpeakableWalkman extends WalkmanWith2Terminal {
	private Object communicationTool;
	
	public void setCommunicationTool(Object communicationTool) {
		this.communicationTool = communicationTool;
	}
	
	public Object getCommunicationTool() {
		return communicationTool;
	}
	
	SpeakableWalkman() {
		super();
	}
}
