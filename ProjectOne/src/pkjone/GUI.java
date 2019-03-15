package pkjone;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class GUI extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		ProjectOne account = new ProjectOne();

		primaryStage.setTitle("\t\t\tATM");

		/////////////////////////////////////// Scene one ////////////////////////////
		Label userNameLabel = new Label("User Name : ");
		TextField userNameField = new TextField();
		Label passwordLabel = new Label("Password : ");
		PasswordField passwordField = new PasswordField();
		Label validatepasswordLabel = new Label("");
		Label texttt = new Label();

		Button enter = new Button("enter");

		GridPane grid1 = new GridPane();
		grid1.add(userNameLabel, 0, 0);
		grid1.add(userNameField, 1, 0);
		grid1.add(passwordLabel, 0, 2);
		grid1.add(passwordField, 1, 2);
		grid1.add(enter, 1, 4);
		grid1.add(validatepasswordLabel, 1, 5);
		grid1.add(texttt, 1, 5);

		Scene scene1 = new Scene(grid1, 305, 200);

		//////////////////////////////// Scene two ///////////////////////////////////

		Label choice = new Label("click on your choice !");
		Label Design = new Label("**********************");

		Button deposit = new Button("Deposit");
		Button withdraw = new Button("Withdraw");
		Button balance = new Button("Balance Inquring");
		Button previouss = new Button("Previous");
		Button next = new Button("Next");

		GridPane grid2 = new GridPane();
		grid2.add(choice, 1, 0);
		grid2.add(Design, 1, 1);
		grid2.add(deposit, 0, 2);
		grid2.add(withdraw, 2, 2);
		grid2.add(next, 0, 3);
		grid2.add(previouss, 2, 3);
		grid2.add(balance, 1, 4);

		Scene scene2 = new Scene(grid2, 305, 200);

///////////////////////////////////////// Scene deposit ////////////////////////////////

		Label amountDeposit = new Label("Enter the amount : ");
		Label design2 = new Label("*******************");
		Label validateAmount = new Label();
		Label text = new Label();

		TextField amount = new TextField(); // 3shan ad5al el felos

		Button enterDeposit = new Button("Enter");

		GridPane gridDeposit = new GridPane();
		gridDeposit.add(amountDeposit, 0, 0);
		gridDeposit.add(design2, 0, 1);
		gridDeposit.add(amount, 1, 2);
		gridDeposit.add(enterDeposit, 1, 3);
		gridDeposit.add(validateAmount, 1, 4);
		gridDeposit.add(text, 1, 4);

		Scene sceneDeposit = new Scene(gridDeposit, 305, 200);

		/////////////////////////////////// Scene Withdraw ///////////////////////////

		Label amountWithdraw = new Label("Enter the amount :");
		Label design3 = new Label("******************");
		Label validateWithdrawAmount = new Label();
		Label textt = new Label();

		TextField amountt = new TextField(); // 3shan ad5al el felos

		Button enterWithdraw = new Button("Enter");

		GridPane gridWithdraw = new GridPane();
		gridWithdraw.add(amountWithdraw, 0, 0);
		gridWithdraw.add(design3, 0, 1);
		gridWithdraw.add(amountt, 1, 1);
		gridWithdraw.add(enterWithdraw, 1, 2);
		gridWithdraw.add(validateWithdrawAmount, 1, 6);
		gridWithdraw.add(textt, 1, 3);

		Scene sceneWithdraw = new Scene(gridWithdraw, 305, 200);

////////////////////////////////////// Scene Balance Inquring //////////////////////////////////////

		Label balanceInquringg = new Label("Your current balance is ");
		Label balanceAmount = new Label();

		Button then = new Button("Then");

		GridPane gridBalance = new GridPane();
		gridBalance.add(balanceInquringg, 0, 0);
		gridBalance.add(balanceAmount, 1, 0);
		gridBalance.add(then, 1, 1);

		Scene sceneBalance = new Scene(gridBalance, 305, 200);

/////// ///////////////////////// second choice scene //////////////////////////////

		Label menu = new Label("Another Choice ?");
		Label end = new Label("End ?");

		Button menuu = new Button("Menu");
		Button endd = new Button("End");

		GridPane secondChoice = new GridPane();
		secondChoice.add(menu, 0, 0);
		secondChoice.add(end, 0, 2);
		secondChoice.add(menuu, 1, 1);
		secondChoice.add(endd, 1, 3);

		Scene sceneChoice = new Scene(secondChoice, 305, 200);

		//////////////////////////// HANDEL SECOND CHOICE /////////////////////
		menuu.setOnAction(e -> {
			primaryStage.setScene(scene2);

		});

		endd.setOnAction(e -> {
			System.exit(0);

		});

/////////////////// HANDEL ENTER OF PASSWORD  /////////////////////////////////////
		enter.setOnAction(e -> {

			try {

				Double.parseDouble(passwordField.getText());
			

			account.setPass(passwordField.getText());
			if (account.passValidate() == true) {
				validatepasswordLabel.setText("welcome to our ATM");
				texttt.setText("");
				// lets go to scene two
				primaryStage.setScene(scene2);
			} else {
				texttt.setText("");
				validatepasswordLabel.setText("INVALID PASSWORD ! ");
			}}
			catch (NumberFormatException z) {

				texttt.setText("INVALID ENTERING \n you have to enter a number");
			}

		});
//////////////////////////////////	HANDEL DEPOSIT BUTTON  ////////////////////////////////

		deposit.setOnAction(e -> {

			// awel lma ndos 3ala deposit yb2a let's do to scene deposit
			primaryStage.setScene(sceneDeposit);

		});

//////////////////////////// HANDEL ENTER IN DEPOSIT SCENE /////////////////////////////
		enterDeposit.setOnAction(e -> {

			try {
				Double.parseDouble(amount.getText());
			

			if (account.deposit(Double.parseDouble(amount.getText())) == false)
				validateAmount.setText("you have to enter a positive amount");
			else {
				validateAmount.setText("Done");
				primaryStage.setScene(sceneChoice);

			}}
			catch (NumberFormatException m) {
				text.setText("INVALID ENTRING \n you have to enter an amount");
				validateAmount.setText("");

			}

		});

////////////////////////////////// HANDEL WITHDRAW BUTTON  ///////////////////////////
		withdraw.setOnAction(e -> {
			// awel lma ndos 3ala deposit yb2a let's do to scene deposit
			primaryStage.setScene(sceneWithdraw);

		});

		//////////////////////// HANDEL ENTER IN WITHDRAW SCENE ////////////////////////
		enterWithdraw.setOnAction(e -> {
			try {
				Double.parseDouble(amountt.getText());
			

			if (account.withDraw(Double.parseDouble(amountt.getText())) == false) {
				validateWithdrawAmount.setText("your balance is not enough");
				textt.setText("");
			} else {
				validateWithdrawAmount.setText("Done");
				primaryStage.setScene(sceneChoice);
			}}
			catch (NumberFormatException m) {
				textt.setText("INVALID ENTRING \n you have to enter an amount");
				validateWithdrawAmount.setText("");
			}
		});

		/////////////////////////////// HANDEL BALANCE BUTTON //////////////////////////

		balance.setOnAction(e -> {

			balanceAmount.setText(" " + account.getBalance());
			primaryStage.setScene(sceneBalance);

		});

		then.setOnAction(e -> {
			primaryStage.setScene(sceneChoice);

		});

		/////////////////////////// scene previous /////////////////////////////////////

		Label prev = new Label();
		Label prevv = new Label();
		Label beginPrev = new Label();

		Button thenn = new Button("Then");

		GridPane gridprev = new GridPane();

		gridprev.add(prev, 0, 0);
		gridprev.add(prevv, 1, 0);
		gridprev.add(thenn, 0, 1);
		gridprev.add(beginPrev, 0, 0);

		Scene sceneprev = new Scene(gridprev, 305, 200);

		////////////////////////////////// HANDLING previous BUTTON////////////////////////////////// 
		previouss.setOnAction(e -> {
			primaryStage.setScene(sceneprev);
			if (account.getCount() <= 0)
				beginPrev.setText("No Transactions have been made");
			else {
				if (account.getCountHistory() > 4)
					prevv.setText("No other transacions");
				else {
					beginPrev.setText("");
					account.setCount((account.getCount() - 1));
					String previous = account.previous();
					prev.setText("the last transiction is ");
					prevv.setText(previous);
				}
			}
		});
		thenn.setOnAction(e -> {
			primaryStage.setScene(sceneChoice);
		});

		/////////////////////////// history scene next//////////////////////////////////////////////////

		Label nexthistory = new Label();
		Label nextt = new Label();
		Label beginNext = new Label();

		Button thennn = new Button("Then");

		GridPane gridnext = new GridPane();

		gridnext.add(nexthistory, 0, 0);
		gridnext.add(nextt, 1, 0);
		gridnext.add(thennn, 0, 1);
		gridnext.add(beginNext, 0, 0);

		Scene sceneNext = new Scene(gridnext, 305, 200);
		///////////////////////// handel next button /////////////////////////////////

		next.setOnAction(e -> {
			primaryStage.setScene(sceneNext);
			if (account.getCount() < 1)
				beginNext.setText("No next Transactions have been made");
			else {
				if (account.getCountHistory() > 4)
					nextt.setText("No other transacions ");
				else {
					beginNext.setText("");
					account.setCount((account.getCount() + 1));
					String nextstring = account.next();
					nexthistory.setText("The next transicion is ");
					nextt.setText(nextstring);
				}
			}
		});
		thennn.setOnAction(e -> {
			primaryStage.setScene(sceneChoice);
		});

		primaryStage.setScene(scene1);
		primaryStage.show();
	}
	/*
	 * public static void main (String[] args) { launch(args); }
	 */
}
