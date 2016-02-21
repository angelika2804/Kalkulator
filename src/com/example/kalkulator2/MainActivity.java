package com.example.kalkulator2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("NewApi")
public class MainActivity extends ActionBarActivity {
	
	Button btn_0;
	Button btn_1;
	Button btn_2;
	Button btn_3;
	Button btn_4;
	Button btn_5;
	Button btn_6;
	Button btn_7;
	Button btn_8;
	Button btn_9;
	Button btn_dot;
	Button btn_C;
	Button btn_DEL;
	Button btn_equals;
	Button btn_add;
	Button btn_subtract;
	Button btn_multiply;
	Button btn_divide;
	TextView result;
	String temp="";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btn_0 = (Button) findViewById(R.id.button_0);
		btn_1 = (Button) findViewById(R.id.button_1);
		btn_2 = (Button) findViewById(R.id.button_2);
		btn_3 = (Button) findViewById(R.id.button_3);
		btn_4 = (Button) findViewById(R.id.button_4);
		btn_5 = (Button) findViewById(R.id.button_5);
		btn_6 = (Button) findViewById(R.id.button_6);
		btn_7 = (Button) findViewById(R.id.button_7);
		btn_8 = (Button) findViewById(R.id.button_8);
		btn_9 = (Button) findViewById(R.id.button_9);
		btn_dot = (Button) findViewById(R.id.button_dot);
		btn_C = (Button) findViewById(R.id.button_clear);
		btn_DEL = (Button) findViewById(R.id.button_delete);
		btn_equals = (Button) findViewById(R.id.button_equals);
		btn_add = (Button) findViewById(R.id.button_add);
		btn_subtract = (Button) findViewById(R.id.button_subtract);
		btn_multiply = (Button) findViewById(R.id.button_multiply);
		btn_divide = (Button) findViewById(R.id.button_divide);
		result = (TextView)findViewById(R.id.textView_result);
		
		addButtonClickListener();
			
	}
	
	public String wynik(String temporary){
		if(result.getText().length()==0 || temporary.length()==0)
    		return "";
    	int znak=1; //1 to +, 2 to -, 3 to x, 4 to /
    	float wynik=0;
    	int i=0;
    	float liczba=0;
    	String wyraz="";
    	while(result.getText().length()>i){
    		if(result.getText().toString().charAt(i)=='+'){
    			if(wyraz.length()>0 )
	    			try {
	    				liczba=Float.parseFloat(wyraz);
	    			} catch (NumberFormatException e) {
	    		        liczba = 0;
	    		    }
    			else
    				liczba=0;
    			wyraz="";
    			if(znak==1)
    				wynik=wynik+liczba;
    			else if(znak==2)
    				wynik=wynik-liczba;
    			else if(znak==3)
    				wynik=wynik*liczba;
	    		else if(znak==4) {
	    			if(liczba==0){
	    				result.setText(R.string.divide_by_zero);
	    				temporary="";
	    				return "";
	    			}
	    			wynik=wynik/liczba;
	    		}			    			
    			znak=1;
    		}
    		else if(result.getText().toString().charAt(i)=='-'){
    			if(wyraz.length()>0)
    				try {
	    				liczba=Float.parseFloat(wyraz);
	    			} catch (NumberFormatException e) {
	    		        liczba = 0;
	    		    }
    			else
    				liczba=0;
    			wyraz="";
    			if(znak==1)
    				wynik=wynik+liczba;
    			else if(znak==2)
    				wynik=wynik-liczba;
    			else if(znak==3)
    				wynik=wynik*liczba;
	    		else if(znak==4) {
	    			if(liczba==0){
	    				result.setText(R.string.divide_by_zero);
	    				temporary="";
	    				return "";
	    			}
	    			wynik=wynik/liczba;
	    		}				    			
    			znak=2;
    		}
    		else if(result.getText().toString().charAt(i)=='x'){
    			if(wyraz.length()>0)
    				try {
	    				liczba=Float.parseFloat(wyraz);
	    			} catch (NumberFormatException e) {
	    		        liczba = 0;
	    		    }
    			else
    				liczba=0;
    			wyraz="";
    			if(znak==1)
    				wynik=wynik+liczba;
    			else if(znak==2)
    				wynik=wynik-liczba;
    			else if(znak==3)
    				wynik=wynik*liczba;
	    		else if(znak==4) {
	    			if(liczba==0){
	    				result.setText(R.string.divide_by_zero);
	    				temporary="";
	    				return "";
	    			}
	    			wynik=wynik/liczba;
	    		}					    			
    			znak=3;
    		}
    		else if(result.getText().toString().charAt(i)==':'){
    			if(wyraz.length()>0)
    				try {
	    				liczba=Float.parseFloat(wyraz);
	    			} catch (NumberFormatException e) {
	    		        liczba = 0;
	    		    }
    			else
    				liczba=0;
    			wyraz="";
    			if(znak==1)
    				wynik=wynik+liczba;
    			else if(znak==2)
    				wynik=wynik-liczba;
    			else if(znak==3)
    				wynik=wynik*liczba;
	    		else if(znak==4) {
	    			if(liczba==0){
	    				result.setText(R.string.divide_by_zero);
	    				temporary="";
	    				return "";
	    			}
	    			wynik=wynik/liczba;
	    		}				    			
    			znak=4;
    		}
    		else{
    			wyraz=wyraz+result.getText().toString().charAt(i);
    		}
    		i=i+1;
    	}
    	if(wyraz.length()>0){
    		if(wyraz.endsWith("."))
    			liczba=0;
    		else
    			try {
    				liczba=Float.parseFloat(wyraz);
    			} catch (NumberFormatException e) {
    		        liczba = 0;
    		    }
    		wyraz="";
    		if(znak==1)
    			wynik=wynik+liczba;
    		else if(znak==2)
    			wynik=wynik-liczba;
    		else if(znak==3)
    			wynik=wynik*liczba;
    		else if(znak==4) {
    			if(liczba==0){
    				result.setText(R.string.divide_by_zero);
    				temporary="";
    				return "";
    			}
    			wynik=wynik/liczba;
    		}
    	}
    	temporary=Float.toString(wynik);
    	result.setText(temporary);
    	return temporary;
	}
	
	public void addButtonClickListener(){
		
		btn_0.setOnClickListener(new View.OnClickListener(){
		    public void onClick(View v) {
		    	temp=temp.concat("0");
		        result.setText(temp);
		    } 
		});
		btn_1.setOnClickListener(new View.OnClickListener(){
		    public void onClick(View v) {
		    	temp=temp.concat("1");
		        result.setText(temp);
		    } 
		});
		btn_2.setOnClickListener(new View.OnClickListener(){
		    public void onClick(View v) {
		    	temp=temp.concat("2");
		        result.setText(temp);
		    } 
		});
		btn_3.setOnClickListener(new View.OnClickListener(){
		    public void onClick(View v) {
		    	temp=temp.concat("3");
		        result.setText(temp);
		    } 
		});
		btn_4.setOnClickListener(new View.OnClickListener(){
		    public void onClick(View v) {
		    	temp=temp.concat("4");
		        result.setText(temp);
		    } 
		});
		btn_5.setOnClickListener(new View.OnClickListener(){
		    public void onClick(View v) {
		    	temp=temp.concat("5");
		        result.setText(temp);
		    } 
		});
		btn_6.setOnClickListener(new View.OnClickListener(){
		    public void onClick(View v) {
		    	temp=temp.concat("6");
		        result.setText(temp);
		    } 
		});
		btn_7.setOnClickListener(new View.OnClickListener(){
		    public void onClick(View v) {
		    	temp=temp.concat("7");
		        result.setText(temp);
		    } 
		});
		btn_8.setOnClickListener(new View.OnClickListener(){
		    public void onClick(View v) {
		    	temp=temp.concat("8");
		        result.setText(temp);
		    } 
		});
		btn_9.setOnClickListener(new View.OnClickListener(){
		    public void onClick(View v) {
		    	temp=temp.concat("9");
		        result.setText(temp);
		    } 
		});
		
		//Dodawanie
				btn_add.setOnClickListener(new View.OnClickListener(){
				    public void onClick(View v) {
				    	if(result.getText().length()!=0 && 
				    			(result.getText().toString().charAt(result.getText().length()-1)=='+' ||
				    			result.getText().toString().charAt(result.getText().length()-1)=='-' ||
				    			result.getText().toString().charAt(result.getText().length()-1)=='.' ||
				    			result.getText().toString().charAt(result.getText().length()-1)=='x' ||
				    			result.getText().toString().charAt(result.getText().length()-1)==':'))
				    		return;
				    	temp=wynik(temp);
				    	if(result.getText().length()==0 || temp.length()!=0)
					    	{
				    			temp=temp.concat("+");
				    			result.setText(temp);
					    	}
				    } 
				});
				//Odejmowanie
				btn_subtract.setOnClickListener(new View.OnClickListener(){
				    public void onClick(View v) {
				    	if(result.getText().length()!=0 && 
				    			(result.getText().toString().charAt(result.getText().length()-1)=='+' ||
				    			result.getText().toString().charAt(result.getText().length()-1)=='-' ||
				    			result.getText().toString().charAt(result.getText().length()-1)=='.' ||
				    			result.getText().toString().charAt(result.getText().length()-1)=='x' ||
				    			result.getText().toString().charAt(result.getText().length()-1)==':'))
				    		return;
				    	temp=wynik(temp);
				    	if(result.getText().length()==0 || temp.length()!=0)
				    	{
				    		temp=temp.concat("-");
				    		result.setText(temp);
				    	}
				    } 
				});
				//Mno¿enie
				btn_multiply.setOnClickListener(new View.OnClickListener(){
				    public void onClick(View v) {
				    	if(result.getText().length()!=0 && 
				    			(result.getText().toString().charAt(result.getText().length()-1)=='+' ||
				    			result.getText().toString().charAt(result.getText().length()-1)=='-' ||
				    			result.getText().toString().charAt(result.getText().length()-1)=='.' ||
				    			result.getText().toString().charAt(result.getText().length()-1)=='x' ||
				    			result.getText().toString().charAt(result.getText().length()-1)==':'))
				    		return;
				    	temp=wynik(temp);
				    	if(result.getText().length()==0 || temp.length()!=0)
				    	{
				    		temp=temp.concat("x");
				    		result.setText(temp);
				    	}
				    } 
				});
				//Dzielenie
				btn_divide.setOnClickListener(new View.OnClickListener(){
				    public void onClick(View v) {
				    	if(result.getText().length()!=0 && 
				    			(result.getText().toString().charAt(result.getText().length()-1)=='+' ||
				    			result.getText().toString().charAt(result.getText().length()-1)=='-' ||
				    			result.getText().toString().charAt(result.getText().length()-1)=='.' ||
				    			result.getText().toString().charAt(result.getText().length()-1)=='x' ||
				    			result.getText().toString().charAt(result.getText().length()-1)==':'))
				    		return;
				    	temp=wynik(temp);
				    	if(result.getText().length()==0 || temp.length()!=0)
				    	{
				    		temp=temp.concat(":");
				    		result.setText(temp);
				    	}
				    } 
				});
				//Kropka
				btn_dot.setOnClickListener(new View.OnClickListener(){
				    public void onClick(View v) {
				    	int i=1;
				    	while(result.getText().length()>i-1 &&
				    			result.getText().toString().charAt(result.getText().length()-i)!='+' &&
				    			result.getText().toString().charAt(result.getText().length()-i)!='-' &&
				    			result.getText().toString().charAt(result.getText().length()-i)!='x' &&
				    			result.getText().toString().charAt(result.getText().length()-i)!=':')
				    			/*result.getText().subSequence(result.getText().length()-i, result.getText().length()-i+1).toString().compareTo("+")!=0 &&
				    			result.getText().subSequence(result.getText().length()-i, result.getText().length()-i+1).toString().compareTo("-")!=0 &&
				    			result.getText().subSequence(result.getText().length()-i, result.getText().length()-i+1).toString().compareTo("x")!=0 &&
				    			result.getText().subSequence(result.getText().length()-i, result.getText().length()-i+1).toString().compareTo(":")!=0)*/{
				    		if(result.getText().toString().charAt(result.getText().length()-i)=='.')
				    			return;
				    		i=i+1;
				    	}
				    	temp=temp.concat(".");
				    	result.setText(temp);
				    } 
				});
				//Delete
				btn_DEL.setOnClickListener(new View.OnClickListener(){
				    public void onClick(View v) {
				    	if(result.getText().length()==0 || temp.length()==0)
				    	{
				    		//Toast.makeText(getApplicationContext(), "Teraz:"+result.length(), Toast.LENGTH_SHORT).show();
				    		result.setText("");
				    		return;
				    	}
			    		temp=temp.substring(0, temp.length()-1);
				    	result.setText(temp);
				    } 
				});
				//Clear
				btn_C.setOnClickListener(new View.OnClickListener(){
				    public void onClick(View v) {
				    	temp="";
				    	result.setText("");
				    } 
				});
				//Wynik
				btn_equals.setOnClickListener(new View.OnClickListener(){
				    public void onClick(View v) {
				    	temp=wynik(temp);
				    } 
				});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
