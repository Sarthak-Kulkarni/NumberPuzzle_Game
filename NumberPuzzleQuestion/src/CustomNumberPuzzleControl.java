import java.awt.*;

class CustomNumberPuzzleControl extends NumberPuzzleControl {
	public int getWidth() {
		return 300;
	}
	public int getHeight() {
		return 350;
	}
	public int getXPosition() {
		return 200;
	}
	public int getYPosition() {
		return 200;
	}
	public String getTitle(){
		return "Number Puzzle";
	}
	public int getShuffleButtonFontSize() {
		return 12;
	}
	public int getNumbersFontSize() {
		return 12;
	}
	public Color getEmptyButtonColor() {
		return Color.WHITE;
	}
	public String getWinnerMessage() {
		return "Congrats, you have won!";
	}

	// The following three methods have to be written by the participants...

	public int handleButtonClicked(NumberPuzzleGame game){
		int emptyCellId = game.getEmptyCellId();
		Button buttonClicked = game.getButtonClicked();
		Button[] buttons = game.getButtons();
		
		//Your logic here
		
		//Finding the ID of the button clicked
		int buttonClickedId=0;
		for(int i=0;i<=15;i++) {
			if(buttons[i].getLabel()==buttonClicked.getLabel()) {
				buttonClickedId=i;
				break;
			}
		}
		
		//Swapping only adjacent cells
		if(Math.abs(buttonClickedId-emptyCellId)==4 || Math.abs(buttonClickedId-emptyCellId)==1)		
			{swapButton(buttons[emptyCellId],buttonClicked);
			emptyCellId=buttonClickedId;
			}
		
		return emptyCellId;

	}
	public int[] getRandomNumbersForGrid() {
		int arr[] = new int[15];
		
		//Your logic here
		for(int i=0;i<15;i++) {
			int a = getRandomNumber();
			arr[i]=a%15+1; //Limiting numbers from 1 to 15
			//Checking for duplication
			for(int j=0;j<i;j++) {
				if(arr[i]==arr[j]) {
					i--;
					break;
				}
			}
		}
		
		
		return arr;
	}
	public boolean checkForWinner(Button[] buttons)
	{
		boolean winner = true;
		
		// Your Logic here
		int[] arr=getIntegerArrayOfButtonIds(buttons);
		for(int i=0;i<15;i++) {
			if(arr[i]!=i+1) {
				winner=false;
				break;
			}
		}

		return winner;
	}
}