package Com.TSL.LineEditorUtilities;


public class AnEncapsulatorForQuit extends AnEncapsulatorForEdit {
	
	private enum AnErrorCode {
		SUCCESS
	}
	
	
	public void edit() {
		
		System.out.println("LineEditor is quitting.");
		System.exit(AnErrorCode.SUCCESS.ordinal());
		
	}
	
}
