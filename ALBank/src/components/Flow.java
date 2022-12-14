package components;

import java.util.Date;

public abstract class Flow {

	// 1.3.2 Creation of the Flow class

	private String comment;
	private int identifier;
	private double amount;
	private int targetAccountNumber;
	private Boolean effect;
	private Date dateOfFlow;

	protected Flow(String comment, int identifier, double amount, int targetAccountNumber, boolean effect,
			Date dateOfFlow) {
		this.comment = comment;
		this.identifier = identifier;
		this.amount = amount;
		this.targetAccountNumber = targetAccountNumber;
		this.effect = effect;
		this.dateOfFlow = dateOfFlow;

	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getIdentifier() {
		return identifier;
	}

	public void setIdentifier(int identifier) {
		this.identifier = identifier;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getTargetAccountNumber() {
		return targetAccountNumber;
	}

	public void setTargetAccountNumber(int targetAccountNumber) {
		this.targetAccountNumber = targetAccountNumber;
	}

	public Boolean getEffect() {
		return effect;
	}

	public void setEffect(Boolean effect) {
		this.effect = effect;
	}

	public Date getDateOfFlow() {
		return dateOfFlow;
	}

	public void setDateOfFlow(Date dateOfFlow) {
		this.dateOfFlow = dateOfFlow;
	}

	public String toString() {
		return "Comment : " + this.getComment() + " /  Identifier : " + this.getIdentifier() + " / Amount : "
				+ this.getAmount() + " Target Account : " + this.getTargetAccountNumber() + " Effect : "
				+ this.getEffect() + "/ Date : " + this.getDateOfFlow();
	}

}
