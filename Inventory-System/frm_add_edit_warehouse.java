/*
********************************************************************************
*																			   *
* Programmer: Philip V. Naparan                                                *
* Contact No.: 639186443161                                                    *
* E-mail Address: philipnaparan@yahoo.com                                      *
* Website: http://www.naparansoft.cjb.net                                      *
*    													   					   *
* "MABUHAY ANG MGA PINOY","PLEASE DON'T FORGET TO VOTE"                        *
*    													   					   *
* Note:																		   *
*      This is not intended to used in a big business because this system was  *
*      created for small business only. If you own a big business and planning *
*      to have a best software for your business then contact me. :-)          *
* 																			   *
********************************************************************************
*/

import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

public class frm_add_edit_warehouse extends JDialog{
	JButton JBUpdate = new JButton(new ImageIcon("images/save.png"));
	JButton JBReset = new JButton("Reset",new ImageIcon("images/reset.png"));
	JButton JBCancel = new JButton("Cancel",new ImageIcon("images/cancel.png"));

	JLabel JLPic1 = new JLabel();
	JLabel JLBanner = new JLabel("Please fill-up all the required fields.");

	JLabel JLId = new JLabel("Warehouse ID:");
	JLabel JLName = new JLabel("Warehouse Name:");
	JLabel JLCPerson = new JLabel("Contact Person:");
	JLabel JLCTitle = new JLabel("Contact Title:");
	JLabel JLAddr = new JLabel("Address:");
	JLabel JLCity = new JLabel("CityTown:");
	JLabel JLStateProv = new JLabel("State/Province:");
	JLabel JLZipCode = new JLabel("Zip Code:");
	JLabel JLPhone = new JLabel("Phone:");
	JLabel JLFax = new JLabel("Fax:");

	JTextField JTFId = new JTextField();
	JTextField JTFName = new JTextField();
	JTextField JTFCPerson = new JTextField();
	JTextField JTFCTitle = new JTextField();
	JTextField JTFAddr = new JTextField();
	JTextField JTFCity = new JTextField();
	JTextField JTFStateProv = new JTextField();
	JTextField JTFZipCode = new JTextField();
	JTextField JTFPhone = new JTextField();
	JTextField JTFFax = new JTextField();

	Connection cnAEW;
	Statement stAEW;
	ResultSet rsAEW;

	Dimension screen = 	Toolkit.getDefaultToolkit().getScreenSize();

	boolean ADDING_STATE;

	public frm_add_edit_warehouse(boolean ADD_STATE,JFrame OwnerForm,Connection srcCN,String srcSQL){
		super(OwnerForm,true);
		cnAEW = srcCN;
		ADDING_STATE = ADD_STATE;
		try{
			stAEW = cnAEW.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		}catch( SQLException sqlEx){

		}
		if(ADD_STATE==true){
			JLPic1.setIcon(new ImageIcon("images/bNew.png"));
			setTitle("Add New Warehouse");
			JBUpdate.setText("Update");
		}else{
			JLPic1.setIcon(new ImageIcon("images/bModify.png"));
			setTitle("Modify Warehouse");
			JBUpdate.setText("Save");
			try{
				rsAEW = stAEW.executeQuery(srcSQL);
				rsAEW.next();
					JTFId.setText("" + rsAEW.getString("WarehouseID"));
					JTFName.setText("" + rsAEW.getString("WarehouseName"));
					JTFCPerson.setText("" + rsAEW.getString("ContactPerson"));
					JTFCTitle.setText("" + rsAEW.getString("ContactTitle"));
					JTFAddr.setText("" + rsAEW.getString("Address"));
					JTFCity.setText("" + rsAEW.getString("CityTown"));
					JTFStateProv.setText("" + rsAEW.getString("StateProvince"));
					JTFZipCode.setText("" + rsAEW.getString("ZipCode"));
					JTFPhone.setText("" + rsAEW.getString("Phone"));
					JTFFax.setText("" + rsAEW.getString("Fax"));
			}catch(SQLException sqlEx){
				System.out.println(sqlEx.getMessage());
			}
		}
		JPanel JPContainer = new JPanel();
		JPContainer.setLayout(null);
		//-- Add the JLPic1
		JLPic1.setBounds(5,5,32,32);
		JPContainer.add(JLPic1);

		//-- Add the JLBanner
		JLBanner.setBounds(55,5,268,48);
		JLBanner.setFont(new Font("Dialog",Font.PLAIN,12));
		JPContainer.add(JLBanner);

		//******************** Start adding of input field
		//-- Add Id Input Field
		JLId.setBounds(5,50,105,20);
		JLId.setFont(new Font("Dialog",Font.PLAIN,12));

		JTFId.setBounds(110,50,200,20);
		JTFId.setFont(new Font("Dialog",Font.PLAIN,12));

		JPContainer.add(JLId);
		JPContainer.add(JTFId);

		//-- Add Name Input Field
		JLName.setBounds(5,72,105,20);
		JLName.setFont(new Font("Dialog",Font.PLAIN,12));

		JTFName.setBounds(110,72,200,20);
		JTFName.setFont(new Font("Dialog",Font.PLAIN,12));

		JPContainer.add(JLName);
		JPContainer.add(JTFName);

		//-- Add Contact Person Input Field
		JLCPerson.setBounds(5,94,105,20);
		JLCPerson.setFont(new Font("Dialog",Font.PLAIN,12));

		JTFCPerson.setBounds(110,94,200,20);
		JTFCPerson.setFont(new Font("Dialog",Font.PLAIN,12));

		JPContainer.add(JLCPerson);
		JPContainer.add(JTFCPerson);

		//-- Add Primary Address Input Field
		JLCTitle.setBounds(5,116,105,20);
		JLCTitle.setFont(new Font("Dialog",Font.PLAIN,12));

		JTFCTitle.setBounds(110,116,200,20);
		JTFCTitle.setFont(new Font("Dialog",Font.PLAIN,12));

		JPContainer.add(JLCTitle);
		JPContainer.add(JTFCTitle);

		//-- Add Secondary Address Input Field
		JLAddr.setBounds(5,138,105,20);
		JLAddr.setFont(new Font("Dialog",Font.PLAIN,12));

		JTFAddr.setBounds(110,138,200,20);
		JTFAddr.setFont(new Font("Dialog",Font.PLAIN,12));

		JPContainer.add(JLAddr);
		JPContainer.add(JTFAddr);

		//-- Add CityTown Input Field
		JLCity.setBounds(5,160,105,20);
		JLCity.setFont(new Font("Dialog",Font.PLAIN,12));

		JTFCity.setBounds(110,160,200,20);
		JTFCity.setFont(new Font("Dialog",Font.PLAIN,12));

		JPContainer.add(JLCity);
		JPContainer.add(JTFCity);

		//-- Add StateProvince Input Field
		JLStateProv.setBounds(5,182,105,20);
		JLStateProv.setFont(new Font("Dialog",Font.PLAIN,12));

		JTFStateProv.setBounds(110,182,200,20);
		JTFStateProv.setFont(new Font("Dialog",Font.PLAIN,12));

		JPContainer.add(JLStateProv);
		JPContainer.add(JTFStateProv);

		//-- Add Zip Code Input Field
		JLZipCode.setBounds(5,204,105,20);
		JLZipCode.setFont(new Font("Dialog",Font.PLAIN,12));

		JTFZipCode.setBounds(110,204,200,20);
		JTFZipCode.setFont(new Font("Dialog",Font.PLAIN,12));

		JPContainer.add(JLZipCode);
		JPContainer.add(JTFZipCode);

		//-- Add Contact Number Input Field
		JLPhone.setBounds(5,226,105,20);
		JLPhone.setFont(new Font("Dialog",Font.PLAIN,12));

		JTFPhone.setBounds(110,226,200,20);
		JTFPhone.setFont(new Font("Dialog",Font.PLAIN,12));

		JPContainer.add(JLPhone);
		JPContainer.add(JTFPhone);

		//-- Add E-mail Address Input Field
		JLFax.setBounds(5,248,105,20);
		JLFax.setFont(new Font("Dialog",Font.PLAIN,12));

		JTFFax.setBounds(110,248,200,20);
		JTFFax.setFont(new Font("Dialog",Font.PLAIN,12));

		JPContainer.add(JLFax);
		JPContainer.add(JTFFax);

		//******************** End adding of input field

		//-- Add the JBUpdate
		JBUpdate.setBounds(5,292,105,25);
		JBUpdate.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBUpdate.setMnemonic(KeyEvent.VK_A);
		JBUpdate.addActionListener(JBActionListener);
		JBUpdate.setActionCommand("update");
		JPContainer.add(JBUpdate);

		//-- Add the JBReset
		JBReset.setBounds(112,292,99,25);
		JBReset.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBReset.setMnemonic(KeyEvent.VK_R);
		JBReset.addActionListener(JBActionListener);
		JBReset.setActionCommand("reset");
		JPContainer.add(JBReset);

		//-- Add the JBCancel
		JBCancel.setBounds(212,292,99,25);
		JBCancel.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBCancel.setMnemonic(KeyEvent.VK_C);
		JBCancel.addActionListener(JBActionListener);
		JBCancel.setActionCommand("cancel");
		JPContainer.add(JBCancel);

		getContentPane().add(JPContainer);
		setSize(325,357);
		setResizable(false);
		setLocation((screen.width - 325)/2,((screen.height-357)/2));
	}
	private boolean RequiredFieldEmpty(){
		if(JTFId.getText().equals("") || JTFName.getText().equals("") || JTFCPerson.getText().equals("")){
			JOptionPane.showMessageDialog(null,"Some required fields is/are empty.\nPlease check it and try again.","Naparansoft Inventory System",JOptionPane.WARNING_MESSAGE);
			JTFId.requestFocus();
			return true;
		}else{
			return false;
		}
	}
	private void clearFields(){
		JTFId.setText("");
		JTFName.setText("");
		JTFCPerson.setText("");
		JTFCTitle.setText("");
		JTFAddr.setText("");
		JTFCity.setText("");
		JTFStateProv.setText("");
		JTFZipCode.setText("");
		JTFPhone.setText("");
		JTFFax.setText("");
	}

	ActionListener JBActionListener = new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String srcObj = e.getActionCommand();
			if(srcObj=="update"){
				if(RequiredFieldEmpty()==false){
					if(ADDING_STATE == true){
						try{

							stAEW.executeUpdate("INSERT INTO tblWarehouse(WarehouseID,WarehouseName,ContactPerson,ContactTitle,Address,CityTown,StateProvince,ZipCode,Phone,Fax) " +
		   							   	        "VALUES ('" +
		   							   	        JTFId.getText() + "', '" +
		   							   	        JTFName.getText() + "', '" +
		   							   	        JTFCPerson.getText() + "', '" +
		   							   	        JTFCTitle.getText() + "', '" +
		   							   	        JTFAddr.getText() + "', '" +
		   							   	        JTFCity.getText() + "', '" +
		   							   	        JTFStateProv.getText() + "', '" +
		   							   	        JTFZipCode.getText() + "', '" +
		   							   	        JTFPhone.getText() + "', '" +
		   							   	        JTFFax.getText() +
		   							   	        "')");
		   					// Start Display the new record
		   					int total =0;
		   					total = clsPublicMethods.getMaxNum("SELECT * FROM tblWarehouse ORDER BY WarehouseIndex ASC",cnAEW,"WarehouseIndex");
		   					if(total != 0){
		   						FrmWarehouse.reloadRecord("SELECT * FROM tblWarehouse WHERE WarehouseIndex = " + total + " ORDER BY WarehouseName ASC");
		   					}else{
		   						FrmWarehouse.reloadRecord("SELECT * FROM tblWarehouse ORDER BY WarehouseName ASC");
		   					}
		   					total =0;
		   					// End Display the new record
		   					JOptionPane.showMessageDialog(null,"New record has been successfully added.","Naparansoft Inventory System",JOptionPane.INFORMATION_MESSAGE);
		   					String ObjButtons[] = {"Yes","No"};
							int PromptResult = JOptionPane.showOptionDialog(null,"Do you want add another record?","Naparansoft Inventory System",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,ObjButtons,ObjButtons[0]);
							if(PromptResult==0){
								clearFields();
								JTFId.requestFocus(true);
							}else{
								dispose();
							}
		   				}catch(SQLException sqlEx){
		   					System.out.println(sqlEx.getMessage());
		   				}
					}else{
						try{
							String RowIndex;
							RowIndex = rsAEW.getString("WarehouseIndex");
							stAEW.executeUpdate("UPDATE tblWarehouse SET WarehouseID = '" +
		   							   	        JTFId.getText() + "', WarehouseName = '" +
		   							   	        JTFName.getText() + "', ContactPerson = '" +
		   							   	        JTFCPerson.getText() + "', ContactTitle = '" +
		   							   	        JTFCTitle.getText()  + "', Address = '" +
		   							   	        JTFAddr.getText()  + "', CityTown = '" +
		   							   	        JTFCity.getText()   + "', StateProvince = '" +
		   							   	        JTFStateProv.getText()   + "', ZipCode = '" +
		   							   	        JTFZipCode.getText()   + "', Phone = '" +
		   							   	        JTFPhone.getText()  + "', Fax = '" +
		   							   	        JTFFax.getText() +
		   							   	        "' WHERE WarehouseIndex = " + RowIndex);
		   					FrmWarehouse.reloadRecord("SELECT * FROM tblWarehouse WHERE WarehouseIndex = " + RowIndex + " ORDER BY WarehouseName ASC");
							JOptionPane.showMessageDialog(null,"Changes in the record has been successfully save.","Naparansoft Inventory System",JOptionPane.INFORMATION_MESSAGE);
							dispose();
						}catch(SQLException sqlEx){
		   					System.out.println(sqlEx.getMessage());
		   				}
					}
				}
			}else if(srcObj=="reset"){
				clearFields();
			}else if(srcObj=="cancel"){
				dispose();
			}
		}
	};

}