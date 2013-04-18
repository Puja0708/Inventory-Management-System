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

public class frm_add_edit_supplier extends JDialog{
	JButton JBUpdate = new JButton(new ImageIcon("images/save.png"));
	JButton JBReset = new JButton("Reset",new ImageIcon("images/reset.png"));
	JButton JBCancel = new JButton("Cancel",new ImageIcon("images/cancel.png"));
	
	JLabel JLPic1 = new JLabel();
	JLabel JLBanner = new JLabel("Please fill-up all the required fields.");
	
	JLabel JLId = new JLabel("Supplier ID:");
	JLabel JLName = new JLabel("Supplier Name:");
	JLabel JLContName = new JLabel("Contact Name:");
	JLabel JLContTitle = new JLabel("Contact Title:");
	JLabel JLAddr = new JLabel("Address:");
	JLabel JLCity = new JLabel("City/Town:");
	JLabel JLState = new JLabel("State/Province:");
	JLabel JLZipCode = new JLabel("Zip Code:");
	JLabel JLCountry = new JLabel("Country:");
	JLabel JLPhone = new JLabel("Phone:");
	JLabel JLFax = new JLabel("Fax:");
	JLabel JLWebsite = new JLabel("Website:");
	
	JTextField JTFId = new JTextField();
	JTextField JTFName = new JTextField();
	JTextField JTFContName = new JTextField();
	JTextField JTFContTitle = new JTextField();
	JTextField JTFAddr = new JTextField();
	JTextField JTFCity = new JTextField();
	JTextField JTFState = new JTextField();
	JTextField JTFZipCode = new JTextField();
	JComboBox  JCBCountry;
	JTextField JTFPhone = new JTextField();
	JTextField JTFFax = new JTextField();
	JTextField JTFWebsite = new JTextField();
	
	Connection cnAES;
	Statement stAES;
	ResultSet rsAES;
		
	Dimension screen = 	Toolkit.getDefaultToolkit().getScreenSize();
	
	boolean ADDING_STATE;
	
	public frm_add_edit_supplier(boolean ADD_STATE,JFrame OwnerForm,Connection srcCN,String srcSQL){
		super(OwnerForm,true);
		cnAES = srcCN;
		ADDING_STATE = ADD_STATE;
		try{
			stAES = cnAES.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		}catch( SQLException sqlEx){
			System.out.println("\nERROR IN frm_add_edit_supplier(frm_add_edit_supplier):" + sqlEx + "\n");
		}
		
		JCBCountry = clsPublicMethods.fillCombo("SELECT * FROM tblCountry",cnAES,"Name");
		
		if(ADD_STATE==true){
			JLPic1.setIcon(new ImageIcon("images/bNew.png"));
			setTitle("Add New Supplier");
			JBUpdate.setText("Update");
			
		}else{
			JLPic1.setIcon(new ImageIcon("images/bModify.png"));
			setTitle("Modify Supplier");
			JBUpdate.setText("Save");
			try{
				rsAES = stAES.executeQuery(srcSQL);
				rsAES.next();					
					JTFId.setText("" + rsAES.getString("SupplierID"));
					JTFName.setText("" + rsAES.getString("CompanyName"));
					JTFContName.setText("" + rsAES.getString("ContactName"));
					JTFContTitle.setText("" + rsAES.getString("ContactTitle"));
					JTFAddr.setText("" + rsAES.getString("Address"));
					JTFCity.setText("" + rsAES.getString("CityTown"));
					JTFState.setText("" + rsAES.getString("StateProvince"));
					JTFZipCode.setText("" + rsAES.getString("ZipCode"));
					//searchInComboPos
					JCBCountry.setSelectedItem("" + rsAES.getString("Country"));
					JTFPhone.setText("" + rsAES.getString("Phone"));
					JTFFax.setText("" + rsAES.getString("Fax"));
					JTFWebsite.setText("" + rsAES.getString("Website"));
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
		//-- Add Contact Name Input Field
		JLContName.setBounds(5,94,105,20);
		JLContName.setFont(new Font("Dialog",Font.PLAIN,12));
		
		JTFContName.setBounds(110,94,200,20);
		JTFContName.setFont(new Font("Dialog",Font.PLAIN,12));
		
		JPContainer.add(JLContName);
		JPContainer.add(JTFContName);
		
		//-- Add Contact Title Input Field
		JLContTitle.setBounds(5,116,105,20);
		JLContTitle.setFont(new Font("Dialog",Font.PLAIN,12));
		
		JTFContTitle.setBounds(110,116,200,20);
		JTFContTitle.setFont(new Font("Dialog",Font.PLAIN,12));
		
		JPContainer.add(JLContTitle);
		JPContainer.add(JTFContTitle);
		
		//-- Add Address Input Field
		JLAddr.setBounds(5,138,105,20);
		JLAddr.setFont(new Font("Dialog",Font.PLAIN,12));
		
		JTFAddr.setBounds(110,138,200,20);
		JTFAddr.setFont(new Font("Dialog",Font.PLAIN,12));
		
		JPContainer.add(JLAddr);
		JPContainer.add(JTFAddr);
		
		//-- Add City Input Field
		JLCity.setBounds(5,160,105,20);
		JLCity.setFont(new Font("Dialog",Font.PLAIN,12));
		
		JTFCity.setBounds(110,160,200,20);
		JTFCity.setFont(new Font("Dialog",Font.PLAIN,12));
		
		JPContainer.add(JLCity);
		JPContainer.add(JTFCity);
		
		//-- Add State/Province Input Field
		JLState.setBounds(5,182,105,20);
		JLState.setFont(new Font("Dialog",Font.PLAIN,12));
		
		JTFState.setBounds(110,182,200,20);
		JTFState.setFont(new Font("Dialog",Font.PLAIN,12));
		
		JPContainer.add(JLState);
		JPContainer.add(JTFState);
		
		//-- Add Zip Code Input Field
		JLZipCode.setBounds(5,204,105,20);
		JLZipCode.setFont(new Font("Dialog",Font.PLAIN,12));
		
		JTFZipCode.setBounds(110,204,200,20);
		JTFZipCode.setFont(new Font("Dialog",Font.PLAIN,12));
		
		JPContainer.add(JLZipCode);
		JPContainer.add(JTFZipCode);
		
		//-- Add Country Input Field
		JLCountry.setBounds(5,226,105,20);
		JLCountry.setFont(new Font("Dialog",Font.PLAIN,12));
		
		JCBCountry.setBounds(110,226,200,20);
		JCBCountry.setFont(new Font("Dialog",Font.PLAIN,12));
		
		JPContainer.add(JLCountry);
		JPContainer.add(JCBCountry);
		
		//-- Add Phone Input Field
		JLPhone.setBounds(5,248,105,20);
		JLPhone.setFont(new Font("Dialog",Font.PLAIN,12));
		
		JTFPhone.setBounds(110,248,200,20);
		JTFPhone.setFont(new Font("Dialog",Font.PLAIN,12));
		
		JPContainer.add(JLPhone);
		JPContainer.add(JTFPhone);
		
		//-- Add Fax Input Field
		JLFax.setBounds(5,270,105,20);
		JLFax.setFont(new Font("Dialog",Font.PLAIN,12));
		
		JTFFax.setBounds(110,270,200,20);
		JTFFax.setFont(new Font("Dialog",Font.PLAIN,12));
		
		JPContainer.add(JLFax);
		JPContainer.add(JTFFax);
		
		//-- Add Website Input Field
		JLWebsite.setBounds(5,292,105,20);
		JLWebsite.setFont(new Font("Dialog",Font.PLAIN,12));
		
		JTFWebsite.setBounds(110,292,200,20);
		JTFWebsite.setFont(new Font("Dialog",Font.PLAIN,12));
		
		JPContainer.add(JLWebsite);
		JPContainer.add(JTFWebsite);
		
		//******************** End adding of input field
		
		//-- Add the JBUpdate
		JBUpdate.setBounds(5,340,105,25);
		JBUpdate.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBUpdate.setMnemonic(KeyEvent.VK_A);
		JBUpdate.addActionListener(JBActionListener);
		JBUpdate.setActionCommand("update");
		JPContainer.add(JBUpdate);
		
		//-- Add the JBReset
		JBReset.setBounds(112,340,99,25);
		JBReset.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBReset.setMnemonic(KeyEvent.VK_R);
		JBReset.addActionListener(JBActionListener);
		JBReset.setActionCommand("reset");
		JPContainer.add(JBReset);
		
		//-- Add the JBCancel
		JBCancel.setBounds(212,340,99,25);
		JBCancel.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBCancel.setMnemonic(KeyEvent.VK_C);
		JBCancel.addActionListener(JBActionListener);
		JBCancel.setActionCommand("cancel");
		JPContainer.add(JBCancel);
		
		getContentPane().add(JPContainer);
		setSize(325,405);
		setResizable(false);
		setLocation((screen.width - 325)/2,((screen.height-405)/2));
	}
	private boolean RequiredFieldEmpty(){
		if(JTFId.getText().equals("") || JTFName.getText().equals("")){
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
		JTFContName.setText("");
		JTFContTitle.setText("");
		JTFAddr.setText("");
		JTFCity.setText("");
		JTFState.setText("");
		JTFZipCode.setText("");
		JCBCountry.setSelectedIndex(0);
		JTFPhone.setText("");
		JTFFax.setText("");
		JTFWebsite.setText("");
	}
	
	ActionListener JBActionListener = new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String srcObj = e.getActionCommand();
			if(srcObj=="update"){
				if(RequiredFieldEmpty()==false){
					if(ADDING_STATE == true){
						try{
							
							stAES.executeUpdate("INSERT INTO tblSupplier(SupplierID,CompanyName,ContactName,ContactTitle,Address,CityTown,StateProvince,ZipCode,Country,Phone,Fax,Website) " +
		   							   	        "VALUES ('" + 		   							   	        
		   							   	        JTFId.getText() + "', '" +
		   							   	        JTFName.getText() + "', '" +
		   							   	        JTFContName.getText() + "', '" +
		   							   	        JTFContTitle.getText() + "', '" +
		   							   	        JTFAddr.getText() + "', '" +
		   							   	        JTFCity.getText() + "', '" +
		   							   	        JTFState.getText() + "', '" +
		   							   	        JTFZipCode.getText() + "', '" +
		   							   	        JCBCountry.getSelectedItem().toString() + "', '" +
		   							   	        JTFPhone.getText() + "', '" +
		   							   	        JTFFax.getText() + "', '" +
		   							   	        JTFWebsite.getText() +
		   							   	        "')");
		   					// Start Display the new record
		   					int total =0;
		   					total = clsPublicMethods.getMaxNum("SELECT * FROM tblSupplier ORDER BY SupplierIndex ASC",cnAES,"SupplierIndex");
		   					if(total != 0){
		   						FrmSupplier.reloadRecord("SELECT * FROM tblSupplier WHERE SupplierIndex = " + total + " ORDER BY CompanyName ASC");	
		   					}else{
		   						FrmSupplier.reloadRecord("SELECT * FROM tblSupplier ORDER BY CompanyName ASC");	
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
							RowIndex = rsAES.getString("SupplierIndex");	        
							stAES.executeUpdate("UPDATE tblSupplier SET SupplierID = '" +
		   							   	        JTFId.getText() + "', CompanyName = '" +
		   							   	        JTFName.getText() + "', ContactName = '" +
		   							   	        JTFContName.getText() + "', ContactTitle = '" +
		   							   	        JTFContTitle.getText() + "', Address = '" +
		   							   	        JTFAddr.getText() + "', CityTown = '" +
		   							   	        JTFCity.getText() + "', StateProvince = '" +
		   							   	        JTFState.getText() + "', ZipCode = '" +
		   							   	        JTFZipCode.getText() + "', Country = '" +
		   							   	        JCBCountry.getSelectedItem().toString() + "', Phone = '" +
		   							   	        JTFPhone.getText() + "', Fax = '" +
		   							   	        JTFFax.getText() + "', Website = '" +
		   							   	        JTFWebsite.getText() +
		   							   	        "' WHERE SupplierIndex = " + RowIndex);
		   					FrmSupplier.reloadRecord("SELECT * FROM tblSupplier WHERE SupplierIndex = " + RowIndex + " ORDER BY CompanyName ASC");	
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