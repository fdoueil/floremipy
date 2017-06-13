package edd.floremipy.dto;

import java.io.Serializable;
import java.util.Date;

public class CommandListDTO implements Serializable {
	int id;
	String clientName;
	String adress;
	String commandReference;
	double totalCommand;
	Date 	deliveryDate;

	public CommandListDTO() {
		super();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClientName() {
		return this.clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getAdress() {
		return this.adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getCommandReference() {
		return this.commandReference;
	}

	public void setCommandReference(String commandReference) {
		this.commandReference = commandReference;
	}

	public double getTotalCommand() {
		return this.totalCommand;
	}

	public void setTotalCommand(double totalCommand) {
		this.totalCommand = totalCommand;
	}

	public Date getDeliveryDate() {
		return this.deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}



}
