
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.*;

/*
 * To run the code you need to have two csv files named AAPL.csv and MSFT.csv
 */

public class MarketGUI extends JFrame implements ActionListener {          

	JFrame f, f2;    
	JButton submit;
	JLabel title, startDate, endDate;
	JComboBox ticker, startDateBox, startMonthBox, startYearBox, endDateBox, endMonthBox, endYearBox;

	public MarketGUI(){   

		f = new JFrame("Stock Market");    

		title = new JLabel("Stock Market");
		title.setBounds(175,20,200,25);
		title.setFont(new Font("Serif", Font.PLAIN, 34));
		title.setForeground(Color.white);
		f.add(title);

		//Select Ticker Symbol
		String tickerSymbol[] = {"Select Symbol","AAPL","MSFT"};        
		ticker = new JComboBox(tickerSymbol);    
		ticker.setBounds(190,100,150,30);    
		f.add(ticker);        


		//Start Date Label
		startDate = new JLabel("Select Start Date");
		startDate.setBounds(190,180,180,20);
		startDate.setFont(new Font("Serif", Font.PLAIN, 24));
		startDate.setForeground(Color.white);
		f.add(startDate);

		//Start Month
		String startMonth[] = {"Select Month","1","2","3","4","5","6","7","8","9","10","11","12"};        
		startMonthBox = new JComboBox(startMonth);    
		startMonthBox.setBounds(20,230,150,30);    
		f.add(startMonthBox);

		//Start Date
		String startDate[] = {"Select Date","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};        
		startDateBox = new JComboBox(startDate);    
		startDateBox.setBounds(190,230,150,30);    
		f.add(startDateBox);

		//Start Year
		String startYear[] = {"Select Year","2013","2014","2015","2016","2017","2018"};        
		startYearBox = new JComboBox(startYear);    
		startYearBox.setBounds(360,230,150,30);    
		f.add(startYearBox);

		//End Date Label
		endDate = new JLabel("Select End Date");
		endDate.setBounds(190,320,180,20);
		endDate.setFont(new Font("Serif", Font.PLAIN, 24));
		endDate.setForeground(Color.white);
		f.add(endDate);

		//End Month
		String endMonth[] = {"Select Month","1","2","3","4","5","6","7","8","9","10","11","12"};        
		endMonthBox = new JComboBox(endMonth);    
		endMonthBox.setBounds(20,370,150,30);    
		f.add(endMonthBox);

		//End Date
		String endDate[] = {"Select Date","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};        
		endDateBox = new JComboBox(endDate);    
		endDateBox.setBounds(190,370,150,30);    
		f.add(endDateBox);        

		//End Year
		String endYear[] = {"Select Year","2013","2014","2015","2016","2017","2018"};        
		endYearBox = new JComboBox(endYear);    
		endYearBox.setBounds(360,370,150,30);    
		f.add(endYearBox);

		//Submit Button
		submit = new JButton("Submit");  
		submit.setBounds(210,500,100,40);
		submit.setBorder(BorderFactory.createLineBorder(Color.blue));
		f.add(submit);


		submit.addActionListener(this); 

		f.getContentPane().setBackground(Color.darkGray);
		f.setLayout(null);    
		f.setLocation(570,270);
		f.setSize(550,650);    
		f.setVisible(true);         
	}

	public void actionPerformed(ActionEvent event) {

		Object source = event.getSource();

		//getting data of combo box
		String symbol = (String)ticker.getSelectedItem();
		String startDate = (String)startDateBox.getSelectedItem();
		String startMonth = (String)startMonthBox.getSelectedItem();
		String startYear = (String)startYearBox.getSelectedItem();
		String endDate = (String)endDateBox.getSelectedItem();
		String endMonth = (String)endMonthBox.getSelectedItem();
		String endYear = (String)endYearBox.getSelectedItem();

		//removing 20 from 2018 to make format according to csv file
		startYear = startYear.replace("20", "");
		endYear = endYear.replace("20", "");

		// appending 0 to single digit
		if (startDate.length()==1) {
			startDate = "0" + startDate;
		}
		if (startMonth.length()==1)  {
			startMonth = "0" + startMonth;
		}
		if (endDate.length()==1) {
			endDate = "0" + endDate; 
		}
		if (endMonth.length()==1) {
			endMonth = "0" + endMonth;
		}

		//making date format in the form of mm/dd/yy
		String startingDate = startMonth + "/" + startDate + "/" + startYear;
		String endingDate = endMonth + "/" + endDate + "/" + endYear;

		
		/*
		 * List is used to store values from csv file 
		 * which can be later changed to integer when 
		 * required to plot the graph
		 */
		List<String> date = new ArrayList<String>();
		List<String> open = new ArrayList<String>();
		List<String> high = new ArrayList<String>();
		List<String> low = new ArrayList<String>();
		List<String> close = new ArrayList<String>();
		List<String> volume = new ArrayList<String>();

		/*
		 * I have used two ticker symbol
		 * AAPL and MSFT
		 */
		String fileName = "";
		if (symbol == "AAPL") {
			fileName = "AAPL.csv";
		}
		else if (symbol == "MSFT") {
			fileName = "MSFT.csv";
		}
		else {
			System.out.println("Please Select a ticker symbol");
		}
		
		File f = new File(fileName);
		try {
			//reading the csv file
			Scanner iStream = new Scanner(f);
			while(iStream.hasNext()) {
				String data = iStream.nextLine();

				//System.out.println(data);

				//splitting one line into components
				String[] parts = data.split(",");
				date.add(parts[0]);
				open.add(parts[1]);
				high.add(parts[2]);
				low.add(parts[3]);
				close.add(parts[4]);
				volume.add(parts[5]);
			}
			iStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int index = 0;
		index = date.indexOf(startingDate);			//index of start date
		
		if (source == submit) {		//Enter Button is pressed
			
			//System.out.println(startingDate);
			
			f2 = new JFrame();
//			
//			JLabel h = new JLabel("Open Value for Starting Date:");
//			h.setBounds(950,360,300,25);
//			h.setFont(new Font("Serif", Font.PLAIN, 24));
//			h.setForeground(Color.white);
//			f2.add(h);
//			
//			JLabel l = new JLabel(open.get(index));
//			l.setBounds(950,400,180,20);
//			l.setFont(new Font("Serif", Font.BOLD, 24));
//			l.setForeground(Color.white);
//			f2.add(l);
			
			f2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		    f2.getContentPane().add(new PlotGraph());
			f2.setSize(1200,650);
		    f2.setLocation(200,200);
		    f2.setVisible(true);	    
		}

		int dateInt = Integer.parseInt(startDate);
		int dateInt2 = Integer.parseInt(endDate);
		int monthInt = Integer.parseInt(startMonth);
		int monthInt2 = Integer.parseInt(endMonth);
		int yearInt = Integer.parseInt(startYear);
		int yearInt2 = Integer.parseInt(endYear);

		//Printing values from starting date till the ending date
		for (int i = yearInt; i <= yearInt2; i++) {			//loop to check year
			
			for (int j = monthInt; j <= monthInt2; j++) {			//loop to check month
				
				if (dateInt <= dateInt2){		//if starting date is less than ending date
					
					for (int k = dateInt; k <= dateInt2; k++) {			//loop to check date 
						System.out.println(date.get(index) + "," + open.get(index) + "," + high.get(index) + "," + low.get(index) + "," + close.get(index) + "," + volume.get(index));
						index--;
					} 					
				}
				else {				//if starting date is greater than ending date
					if (dateInt <= 31) {
						for (int k = dateInt; k <= 31; k++) {
							System.out.println(date.get(index) + "," + open.get(index) + "," + high.get(index) + "," + low.get(index) + "," + close.get(index) + "," + volume.get(index));
							index--;
						}
					}
					else {
						for (int k = 1; k <= dateInt2; k++) {
							System.out.println(date.get(index) + "," + open.get(index) + "," + high.get(index) + "," + low.get(index) + "," + close.get(index) + "," + volume.get(index));
							index--;
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) {  
		new MarketGUI();         
	}    
}
