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
		this.id = -9999;
		this.clientName = "Mon cLient 1";
		this.adress ="11 rue Berger Levrault - 31000 Toulouse";
		this.commandReference = "9999 - 99 -9999";
		this.totalCommand = 125.34d;
		this.deliveryDate = new Date();
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
