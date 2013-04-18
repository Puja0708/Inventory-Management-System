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

public class frm_add_edit_salesrep extends JDialog{
	JButton JBUpdate = new JButton(new ImageIcon("images/save.png"));
	JButton JBReset = new JButton("Reset",new ImageIcon("images/reset.png"));
	JButton JBCancel = new JButton("Cancel",new ImageIcon("images/cancel.png"));

	JLabel JLPic1 = new JLabel();
	JLabel JLBanner = new JLabel("Please fill-up all the required fields.");

	JLabel JLId = new JLabel("Sales Rep. ID:");
	JLabel JLName = new JLabel("Name:");
	JLabel JLAddr = new JLabel("Address:");
	JLabel JLCity = new JLabel("City:");
	JLabel JLStateProv = new JLabel("State/Province:");
	JLabel JLZipCode = new JLabel("ZipCode:");
	JLabel JLContNo = new JLabel("Contact No:");
	JLabel JLEmerContName = new JLabel("Emer. Cont. Name:");
	JLabel JLEmerContNo = new JLabel("Emer. Contact No:");

	JTextField JTFId = new JTextField();
	JTextField JTFName = new JTextField();
	JTextField JTFAddr = new JTextField();
	JTextField JTFCity = new JTextField();
	JTextField JTFStateProv = new JTextField();
	JTextField JTFZipCode = new JTextField();
	JTextField JTFContNo = new JTextField();
	JTextField JTFEmerContName = new JTextField();
	JTextField JTFEmerContNo = new JTextField();

	Connection cnAES;
	Statement stAES;
	ResultSet rsAES;

	Dimension screen = 	Toolkit.getDefaultToolkit().getScreenSize();

	boolean ADDING_STATE;

	public frm_add_edit_salesrep(boolean ADD_STATE,JFrame OwnerForm,Connection srcCN,String srcSQL){
		super(OwnerForm,true);
		cnAES = srcCN;
		ADDING_STATE = ADD_STATE;
		try{
			stAES = cnAES.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		}catch( SQLException sqlEx){

		}
		if(ADD_STATE==true){
			JLPic1.setIcon(new ImageIcon("images/bNew.png"));
			setTitle("Add New SalesRep ");
			JBUpdate.setText("Update");
		}else{
			JLPic1.setIcon(new ImageIcon("images/bModify.png"));
			setTitle("Modify SalesRep ");
			JBUpdate.setText("Save");
			try{
				rsAES = stAES.executeQuery(srcSQL);
				rsAES.next();
					JTFId.setText("" + rsAES.getString("SalesRepID"));
					JTFName.setText("" + rsAES.getString("Name"));
					JTFAddr.setText("" + rsAES.getString("Address"));
					JTFCity.setText("" + rsAES.getString("CityTown"));
					JTFStateProv.setText("" + rsAES.getString("StateProvince"));
					JTFZipCode.setText("" + rsAES.getString("ZipCode"));
					JTFContNo.setText("" + rsAES.getString("ContactNo"));
					JTFEmerContNo.setText("" + rsAES.getString("EmerContactNo"));
					JTFEmerContName.setText("" + rsAES.getString("EmerContactName"));
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
		//-- Add Primary Address Input Field
		JLAddr.setBounds(5,94,105,20);
		JLAddr.setFont(new Font("Dialog",Font.PLAIN,12));

		JTFAddr.setBounds(110,94,200,20);
		JTFAddr.setFont(new Font("Dialog",Font.PLAIN,12));

		JPContainer.add(JLAddr);
		JPContainer.add(JTFAddr);

		//-- Add Secondary Address Input Field
		JLCity.setBounds(5,116,105,20);
		JLCity.setFont(new Font("Dialog",Font.PLAIN,12));

		JTFCity.setBounds(110,116,200,20);
		JTFCity.setFont(new Font("Dialog",Font.PLAIN,12));

		JPContainer.add(JLCity);
		JPContainer.add(JTFCity);

		//-- Add StateProv Input Field
		JLStateProv.setBounds(5,138,105,20);
		JLStateProv.setFont(new Font("Dialog",Font.PLAIN,12));

		JTFStateProv.setBounds(110,138,200,20);
		JTFStateProv.setFont(new Font("Dialog",Font.PLAIN,12));

		JPContainer.add(JLStateProv);
		JPContainer.add(JTFStateProv);

		//-- Add ZipCode Input Field
		JLZipCode.setBounds(5,160,105,20);
		JLZipCode.setFont(new Font("Dialog",Font.PLAIN,12));

		JTFZipCode.setBounds(110,160,200,20);
		JTFZipCode.setFont(new Font("Dialog",Font.PLAIN,12));

		JPContainer.add(JLZipCode);
		JPContainer.add(JTFZipCode);

		//-- Add Zip Code Input Field
		JLContNo.setBounds(5,182,105,20);
		JLContNo.setFont(new Font("Dialog",Font.PLAIN,12));

		JTFContNo.setBounds(110,182,200,20);
		JTFContNo.setFont(new Font("Dialog",Font.PLAIN,12));

		JPContainer.add(JLContNo);
		JPContainer.add(JTFContNo);

		//-- Add Contact Number Input Field
		JLEmerContName.setBounds(5,204,105,20);
		JLEmerContName.setFont(new Font("Dialog",Font.PLAIN,12));

		JTFEmerContName.setBounds(110,204,200,20);
		JTFEmerContName.setFont(new Font("Dialog",Font.PLAIN,12));

		JPContainer.add(JLEmerContName);
		JPContainer.add(JTFEmerContName);

		//-- Add E-mail Address Input Field
		JLEmerContNo.setBounds(5,226,105,20);
		JLEmerContNo.setFont(new Font("Dialog",Font.PLAIN,12));

		JTFEmerContNo.setBounds(110,226,200,20);
		JTFEmerContNo.setFont(new Font("Dialog",Font.PLAIN,12));

		JPContainer.add(JLEmerContNo);
		JPContainer.add(JTFEmerContNo);

		//******************** End adding of input field

		//-- Add the JBUpdate
		JBUpdate.setBounds(5,270,105,25);
		JBUpdate.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBUpdate.setMnemonic(KeyEvent.VK_A);
		JBUpdate.addActionListener(JBActionListener);
		JBUpdate.setActionCommand("update");
		JPContainer.add(JBUpdate);

		//-- Add the JBReset
		JBReset.setBounds(112,270,99,25);
		JBReset.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBReset.setMnemonic(KeyEvent.VK_R);
		JBReset.addActionListener(JBActionListener);
		JBReset.setActionCommand("reset");
		JPContainer.add(JBReset);

		//-- Add the JBCancel
		JBCancel.setBounds(212,270,99,25);
		JBCancel.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBCancel.setMnemonic(KeyEvent.VK_C);
		JBCancel.addActionListener(JBActionListener);
		JBCancel.setActionCommand("cancel");
		JPContainer.add(JBCancel);

		getContentPane().add(JPContainer);
		setSize(325,335);
		setResizable(false);
		setLocation((screen.width - 325)/2,((screen.height-335)/2));
	}
	private boolean RequiredFieldEmpty(){
		if(JTFId.getText().equals("") || JTFName.getText().equals("") || JTFAddr.getText().equals("")){
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
		JTFAddr.setText("");
		JTFCity.setText("");
		JTFStateProv.setText("");
		JTFZipCode.setText("");
		JTFContNo.setText("");
		JTFEmerContName.setText("");
		JTFEmerContNo.setText("");
	}

	ActionListener JBActionListener = new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String srcObj = e.getActionCommand();
			if(srcObj=="update"){
				if(RequiredFieldEmpty()==false){
					if(ADDING_STATE == true){
						try{

							stAES.executeUpdate("INSERT INTO tblSalesRep (SalesRepID,Name,Address,CityTown,StateProvince,ZipCode,ContactNo,EmerContactNo,EmerContactName) " +
		   							   	        "VALUES ('" +
		   							   	        JTFId.getText() + "', '" +
		   							   	        JTFName.getText() + "', '" +
		   							   	        JTFAddr.getText() + "', '" +
		   							   	        JTFCity.getText() + "', '" +
		   							   	        JTFStateProv.getText() + "', '" +
		   							   	        JTFZipCode.getText() + "', '" +
		   							   	        JTFContNo.getText() + "', '" +
		   							   	        JTFEmerContNo.getText() + "', '" +
		   							   	        JTFEmerContName.getText() +
		   							   	        "')");
		   					// Start Display the new record
		   					int total =0;
		   					total = clsPublicMethods.getMaxNum("SELECT * FROM tblSalesRep ORDER BY SalesRepIndex ASC",cnAES,"SalesRepIndex");
		   					if(total != 0){
		   						FrmSalesRep.reloadRecord("SELECT * FROM tblSalesRep WHERE SalesRepIndex = " + total + " ORDER BY Name ASC");
		   					}else{
		   						FrmSalesRep.reloadRecord("SELECT * FROM tblSalesRep ORDER BY Name ASC");
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
							RowIndex = rsAES.getString("SalesRepIndex");
							stAES.executeUpdate("UPDATE tblSalesRep SET SalesRepID = '" +
		   							   	        JTFId.getText() + "', Name = '" +
		   							   	        JTFName.getText() + "', Address = '" +
		   							   	        JTFAddr.getText()  + "', CityTown = '" +
		   							   	        JTFCity.getText()  + "', StateProvince = '" +
		   							   	        JTFStateProv.getText()   + "', ZipCode = '" +
		   							   	        JTFZipCode.getText()   + "', ContactNo = '" +
		   							   	        JTFContNo.getText()   + "', EmerContactNo = '" +
		   							   	        JTFEmerContNo.getText()  + "', EmerContactName = '" +
		   							   	        JTFEmerContName.getText() +
		   							   	        "' WHERE SalesRepIndex = " + RowIndex);
		   					FrmSalesRep.reloadRecord("SELECT * FROM tblSalesRep WHERE SalesRepIndex = " + RowIndex +" ORDER BY Name ASC");
							JOptionPane.showMessageDialog(null,"Changes in the record has been successfully save.","Naparansoft Inventory System",JOptionPane.INFORMATION_MESSAGE);
							RowIndex="";
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