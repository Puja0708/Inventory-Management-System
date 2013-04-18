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
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.*;
import java.awt.PrintJob;
import java.util.*;
import java.text.*;

public class FrmWarehouse extends JInternalFrame{

	/************************ Variable declaration start **********************/

	//Start form variables
	public static JScrollPane WrhTableJSP = new JScrollPane();

	public static JPanel JPContainer = new JPanel();

	public static JTable JTWrhTable;

	JLabel JLPicture1 = new JLabel(new ImageIcon("images/helper.png"));
	JLabel JLHelpText = new JLabel("To display a certain  \n record click the 'search button' and look for the record that you want.");

	JFrame JFParentFrame;

	JButton JBAddNew = new JButton("Add New",new ImageIcon("images/new.png"));
	JButton JBModify = new JButton("Modify",new ImageIcon("images/modify.png"));
	JButton JBSearch = new JButton("Search",new ImageIcon("images/search.png"));
	JButton JBPrint = new JButton("Print",new ImageIcon("images/print.png"));
	JButton JBDelete = new JButton("Delete",new ImageIcon("images/delete.png"));
	JButton JBReload = new JButton("Reload",new ImageIcon("images/reload.png"));

	Connection cnWrh;

	public static Statement stWrh;

	public static ResultSet rsWrh;

	public static String strSQL;
	public static String Content[][];

	public static int rowNum = 0;
	public static int total = 0;

	boolean goEOF;

	Dimension screen = 	Toolkit.getDefaultToolkit().getScreenSize();

	//End form variables

	/********************** End variable declaration start ********************/

	/********************* Start FrmWarehouse constructor **********************/
	public FrmWarehouse(Connection srcCN,JFrame getParentFrame) throws SQLException{
		//Set the form caption and some properties start
		super("Warehouse Records",false,true,false,true);
		//End set the form caption and some properties

		//Start initialize variables
		JPContainer.setLayout(null);

		JFParentFrame = getParentFrame;

		cnWrh = srcCN;
		stWrh = cnWrh.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		strSQL = "SELECT * FROM tblWarehouse WHERE WarehouseIndex = 0 ORDER BY WarehouseName ASC";

		//-- Add the JLPicture1
		JLPicture1.setBounds(5,5,48,48);
		JPContainer.add(JLPicture1);

		//-- Add the JLHelpText
		JLHelpText.setBounds(55,5,570,48);
		JLHelpText.setFont(new Font("Dialog", Font.PLAIN, 12));
		JPContainer.add(JLHelpText);

		//-- Add the WrhTable
		JTWrhTable=CreateTable();
		WrhTableJSP.getViewport().add(JTWrhTable);
		WrhTableJSP.setBounds(5,55,727,320);
		JPContainer.add(WrhTableJSP);

		//-- Add the JBAddNew
		JBAddNew.setBounds(5,382,105,25);
		JBAddNew.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBAddNew.setMnemonic(KeyEvent.VK_A);
		JBAddNew.addActionListener(JBActionListener);
		JBAddNew.setActionCommand("add");
		JPContainer.add(JBAddNew);

		//-- Add the JBModify
		JBModify.setBounds(112,382,99,25);
		JBModify.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBModify.setMnemonic(KeyEvent.VK_M);
		JBModify.addActionListener(JBActionListener);
		JBModify.setActionCommand("modify");
		JPContainer.add(JBModify);

		//-- Add the JBSearch
		JBSearch.setBounds(212,382,99,25);
		JBSearch.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBSearch.setMnemonic(KeyEvent.VK_S);
		JBSearch.addActionListener(JBActionListener);
		JBSearch.setActionCommand("search");
		JPContainer.add(JBSearch);

		//-- Add the JBPrint
		JBPrint.setBounds(312,382,99,25);
		JBPrint.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBPrint.setMnemonic(KeyEvent.VK_P);
		JBPrint.addActionListener(JBActionListener);
		JBPrint.setActionCommand("print");
		JPContainer.add(JBPrint);

		//-- Add the JBDelete
		JBDelete.setBounds(413,382,105,25);
		JBDelete.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBDelete.setMnemonic(KeyEvent.VK_D);
		JBDelete.addActionListener(JBActionListener);
		JBDelete.setActionCommand("delete");
		JPContainer.add(JBDelete);

		//-- Add the JBReload
		JBReload.setBounds(627,382,105,25);
		JBReload.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBReload.setMnemonic(KeyEvent.VK_R);
		JBReload.addActionListener(JBActionListener);
		JBReload.setActionCommand("reload");
		JPContainer.add(JBReload);

		//End initialize variables

		//Start set the form properties
		getContentPane().add(JPContainer);
		setSize(747,450);
		setLocation((screen.width - 747)/2,((screen.height-450)/2)-45);
		setFrameIcon(new ImageIcon("images/Warehouse.png"));
		//End set the form properties

	}
	/********************** FrmWarehouse constructor end ***********************/

	/************************** Start event handling **************************/

	ActionListener JBActionListener = new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String srcObj = e.getActionCommand();
			//Add Record
			if(srcObj=="add"){
				JDialog JDAdd = new frm_add_edit_warehouse(true,JFParentFrame,cnWrh,"");
				JDAdd.show();
			//Modify Record
			}else if(srcObj=="modify"){
				if(total != 0){
					try{
							if(JTWrhTable.getValueAt(JTWrhTable.getSelectedRow(),JTWrhTable.getSelectedColumn()) != null){
								JDialog JDEdit = new frm_add_edit_warehouse(false,JFParentFrame,cnWrh,"SELECT * FROM tblWarehouse WHERE WarehouseIndex = " + JTWrhTable.getValueAt(JTWrhTable.getSelectedRow(),0));
								JDEdit.show();

							}
					}catch(Exception sqlE){
						if(sqlE.getMessage() != null){
							System.out.println(sqlE.getMessage());
						}else{
							JOptionPane.showMessageDialog(null,"Please select a record in the list to modify.","No Record Selected",JOptionPane.INFORMATION_MESSAGE);
						}

					}
				}
			//Search Record
			}else if(srcObj=="search"){
				JDialog JDSearchRec = new FrmSearchWarehouse(JFParentFrame);
				JDSearchRec.show(true);
			//Print Record
			}else if(srcObj=="print"){
				if(total != 0){
					try{
							if(JTWrhTable.getValueAt(JTWrhTable.getSelectedRow(),JTWrhTable.getSelectedColumn()) != null){
								clsPublicMethods PrintingClass = new clsPublicMethods();
								ResultSet rsPrint = stWrh.executeQuery("SELECT * FROM tblWarehouse WHERE WarehouseIndex = " + JTWrhTable.getValueAt(JTWrhTable.getSelectedRow(),0));
								if(rsPrint.next()==true){
									String RecordToPrint = "";
									java.util.Date CurrentDate = new java.util.Date();
									SimpleDateFormat SDFDateFormatter = new SimpleDateFormat("MMM. dd, yyyy",Locale.getDefault());

									RecordToPrint += "                         W A R E H O U S E   R E C O R D\n";
									RecordToPrint += "                              " + SDFDateFormatter.format(CurrentDate).toString() + "\n\n\n";


									RecordToPrint += "___________________________________________________________________________________\n\n\n";

									RecordToPrint += " Warehouse ID: " + rsPrint.getString("WarehouseID") + "                 Warehouse Name: " + rsPrint.getString("WarehouseName") + "\n";
									RecordToPrint += "___________________________________________________________________________________\n";
									RecordToPrint += "___________________________________________________________________________________\n\n";


									RecordToPrint += " Contact Person: " + rsPrint.getString("ContactPerson") + "\n";
									RecordToPrint += " Contact Title: " + rsPrint.getString("ContactTitle") + "\n";
									RecordToPrint += " CityTown: " + rsPrint.getString("CityTown") + "\n";
									RecordToPrint += " State/Province: " + rsPrint.getString("StateProvince") + "\n";
									RecordToPrint += " Zip Code: " + rsPrint.getString("ZipCode") + "\n";
									RecordToPrint += " Phone: " + rsPrint.getString("Phone") + "\n";
									RecordToPrint += " Fax: " + rsPrint.getString("Fax") + "\n\n";

									RecordToPrint += "___________________________________________________________________________________\n\n";

									PrintingClass.printRecord(RecordToPrint,JFParentFrame);

									CurrentDate=null;
									SDFDateFormatter=null;
									RecordToPrint=null;

								}else{
									JOptionPane.showMessageDialog(null,"The selected record has been change since last modified. Please click the 'Reload' button and try again!","No record to print",JOptionPane.WARNING_MESSAGE);
								}
								//Dispose the variable
								rsPrint=null;

							}
					}catch(Exception sqlE){
						if(sqlE.getMessage() != null){
							System.out.println(sqlE.getMessage());
						}else{
							JOptionPane.showMessageDialog(null,"Please select a record in the list to print.","No Record Selected",JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
			//Delete Record
			}else if(srcObj=="delete"){
				if(total != 0){
					try{
						if(JTWrhTable.getValueAt(JTWrhTable.getSelectedRow(),JTWrhTable.getSelectedColumn()) != null){
							String ObjButtons[] = {"Yes","No"};
							int PromptResult = JOptionPane.showOptionDialog(null,"Are you sure you want to delete the selected record?","Delete Record",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE,null,ObjButtons,ObjButtons[1]);
							if(PromptResult==0){
								stWrh.execute("DELETE * FROM tblWarehouse WHERE WarehouseIndex = " + JTWrhTable.getValueAt(JTWrhTable.getSelectedRow(),0));
								reloadRecord();
								JOptionPane.showMessageDialog(null,"Record has been successfully deleted.","Comfirm Delete",JOptionPane.INFORMATION_MESSAGE);
							}
						}
					}catch(Exception sqlE){
						if(sqlE.getMessage()!=null){
							JOptionPane.showMessageDialog(null,"You cannot delete this Warehouse because it already have an invoice transaction.\nIn order to delete this Warehouse, delete its invoice first.","Comfirm Delete",JOptionPane.WARNING_MESSAGE);
						}else{
							JOptionPane.showMessageDialog(null,"Please select a record in the list to deleted.","No Record Selected",JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
			//Reload Record
			}else if(srcObj=="reload"){
				reloadRecord();
			//Close the Form
			}
		}
	};
	/*************************** End event handling ***************************/

	/************************** Start Custom class ***************************/

	public static  JTable CreateTable(){
		String ColumnHeaderName[] = {
			"Index","Warehouse ID","Warehouse Name","Contact Person"
		};
		try{
			rsWrh = stWrh.executeQuery(strSQL);
			total = 0;
			//Move to the last record
			rsWrh.afterLast();
			//Get the current record position
			if(rsWrh.previous())total = rsWrh.getRow();
			//Move back to the first record;
			rsWrh.beforeFirst();
			if(total != 0){
				Content = new String[total][4];
				while(rsWrh.next()){
					Content[rowNum][0] = "" + rsWrh.getString("WarehouseIndex");
					Content[rowNum][1] = "" + rsWrh.getString("WarehouseID");
					Content[rowNum][2] = "" + rsWrh.getString("WarehouseName");
					Content[rowNum][3] = "" + rsWrh.getString("ContactPerson");
					rowNum++;
				}
			}else{
				Content = new String[0][4];
				Content[0][0] = " ";
				Content[0][1] = " ";
				Content[0][2] = " ";
				Content[0][3] = " ";
			}
		}catch(Exception eE){
		}
		JTable NewTable = new JTable (Content,ColumnHeaderName){
			public boolean isCellEditable (int iRows, int iCols) {
				return false;
			}
		};

		NewTable.setPreferredScrollableViewportSize(new Dimension(727, 320));
		NewTable.setBackground(Color.white);

		//Start resize the table column
		NewTable.getColumnModel().getColumn(0).setMaxWidth(0);
		NewTable.getColumnModel().getColumn(0).setMinWidth(0);
		NewTable.getColumnModel().getColumn(0).setWidth(0);
		NewTable.getColumnModel().getColumn(0).setPreferredWidth(0);
		NewTable.getColumnModel().getColumn(1).setPreferredWidth(100);
		NewTable.getColumnModel().getColumn(2).setPreferredWidth(300);
		NewTable.getColumnModel().getColumn(3).setPreferredWidth(200);
		//End resize the table column

		//Disposed variables
		ColumnHeaderName=null;
		Content=null;

		rowNum = 0;

		return NewTable;
	}

	/**************************** End Custom class ****************************/

	/************************** Start Custom method ***************************/

	public static void reloadRecord(String srcSQL){
				strSQL = srcSQL;
				WrhTableJSP.getViewport().remove(JTWrhTable);
				JTWrhTable=CreateTable();
				WrhTableJSP.getViewport().add(JTWrhTable);
				JPContainer.repaint();
	}

	public static void reloadRecord(){
				WrhTableJSP.getViewport().remove(JTWrhTable);
				JTWrhTable=CreateTable();
				WrhTableJSP.getViewport().add(JTWrhTable);
				JPContainer.repaint();
	}

	/*************************** End Custom method ****************************/

}