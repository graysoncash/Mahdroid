package com.example.mahdroid;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Game extends Activity {

	EditText suitField, valueField;
	TextView txt;
	Hand hand;
	ArrayList<Button> buttons;
	/////

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);

		buttons = new ArrayList<Button>();
		for (int i = 0x7f090001; i <= 0x7f09000e; i++) {
			buttons.add((Button)findViewById(i));
		}
		for (int i = 0; i <= 13; i++) {
			buttons.get(i).setOnClickListener(myListener);		
		}
		
		
		Button eatButton = (Button) findViewById(R.id.eatButton);
		eatButton.setOnTouchListener(functionOnTouch);
		
		Button doubleButton = (Button) findViewById(R.id.doubleButton);
		doubleButton.setOnTouchListener(functionOnTouch);
		
		Button tripleButton = (Button) findViewById(R.id.tripleButton);
		tripleButton.setOnTouchListener(functionOnTouch);
		
		Button winButton = (Button) findViewById(R.id.winButton);
		winButton.setOnTouchListener(functionOnTouch);
		
		//setupStuff();

	}

	public void setupStuff() {
		txt = (TextView) findViewById(R.id.textView1);
		txt.setMovementMethod(new ScrollingMovementMethod());
		
		//Button addButton = (Button) findViewById(R.id.addButton);
		//suitField = (EditText) findViewById(R.id.suitField);
		//valueField = (EditText) findViewById(R.id.valueField);

		/*addButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if(suitField.getText().length()==0){
                    suitField.setError("Field cannot be left blank.");
                }
				else if (valueField.getText().length()==0)
					valueField.setError("Field cannot be left blank.");
				else {
					int suit = Integer.parseInt(suitField.getText().toString());
					int value = Integer.parseInt(valueField.getText().toString());

					Tile temp = new Tile(suit,value);
					hand.add(temp);
					txt.setText("\n" + hand + "\n");
				}
			}
		});*/

		hand = new Hand();
		Tile tile111 = new Tile(1, 1);
		Tile tile112 = new Tile(3, 5);
		Tile tile113 = new Tile(1, 2);
		Tile tile14 = new Tile(2, 3);
		Tile tile15 = new Tile(1, 2);
		Tile tile16 = new Tile(2, 2);
		Tile tile17 = new Tile(2, 4);

		hand.add(tile111);
		hand.add(tile112);
		hand.add(tile113);
		hand.add(tile14);
		hand.add(tile15);
		hand.add(tile16);
		hand.add(tile17);
		Tile tile18 = new Tile(1, 2);
		hand.add(tile18);
		txt.append(hand.toString());



		Tile t = new Tile(1,2);
		if (Function.triple(hand, t))
			txt.append("true");
		else
			txt.append("false");
		txt.append("\n");

		hand.remove(tile113);
		if (Function.triple(hand, t))
			txt.append("true\n");
		else
			txt.append("false\n");
		txt.append("\n");

		Deck deck = new Deck();
		txt.append(deck.toString());

		ArrayList<Button> tilesInHand = new ArrayList<Button>();
		Button tile0 = (Button) findViewById(R.id.playerTile0);
		tilesInHand.add(tile0);
		Button tile1 = (Button) findViewById(R.id.playerTile1);
		tilesInHand.add(tile1);
		Button tile2 = (Button) findViewById(R.id.playerTile2);
		tilesInHand.add(tile2);
		Button tile3 = (Button) findViewById(R.id.playerTile3);
		tilesInHand.add(tile3);
		Button tile4 = (Button) findViewById(R.id.playerTile4);
		tilesInHand.add(tile4);
		Button tile5 = (Button) findViewById(R.id.playerTile5);
		tilesInHand.add(tile5);
		Button tile6 = (Button) findViewById(R.id.playerTile6);
		tilesInHand.add(tile6);
		Button tile7 = (Button) findViewById(R.id.playerTile7);
		tilesInHand.add(tile7);
		Button tile8 = (Button) findViewById(R.id.playerTile8);
		tilesInHand.add(tile8);
		Button tile9 = (Button) findViewById(R.id.playerTile9);
		tilesInHand.add(tile9);
		Button tile10 = (Button) findViewById(R.id.playerTile10);
		tilesInHand.add(tile10);
		Button tile11 = (Button) findViewById(R.id.playerTile11);
		tilesInHand.add(tile11);
		Button tile12 = (Button) findViewById(R.id.playerTile12);
		tilesInHand.add(tile12);

		deck = new Deck();
		for (int i = 0; i<tilesInHand.size(); i++) {
			Tile ti = deck.draw();
			tilesInHand.get(i).setText(ti.getSuit() + "\n" + ti.getValue());
		}

	}
	private OnClickListener myListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Button temp = (Button) v;
			if (temp.getText().equals("") || 
					temp.getText().equals("R")) {
				temp.setBackgroundColor(Color.GREEN);
				temp.setText("G");
			}
			else if (temp.getText().equals("G")) {
				temp.setBackgroundColor(Color.rgb(255, 105, 180));
				temp.setText("P");
			}
			else {
				temp.setText("R");
				temp.setBackgroundColor(Color.RED);
			}
			
		}
	};
	
	private OnTouchListener functionOnTouch = new OnTouchListener() {
		
		@Override
		public boolean onTouch(View v, MotionEvent event) {
			Button temp = (Button) v;
			ColorDrawable d = (ColorDrawable) temp.getBackground();
			switch(event.getAction()){
		    case MotionEvent.ACTION_DOWN:
		        temp.setTextColor(d.getColor());
		        break;

		    case MotionEvent.ACTION_MOVE:
		        break;

		    case MotionEvent.ACTION_UP:
		        temp.setTextColor(Color.WHITE);

		        float x = v.getX(),y = v.getY();
		       // if (Math.abs(x - event.getX()) > 550 ||
		        		//Math.abs(y - event.getY()) < 100  ) {
		        String funct = temp.getText() + "";

		        AlertDialog.Builder builder = new AlertDialog.Builder(Game.this);
		        builder.setTitle("Action performed: " + funct)
		        .setMessage("" + Math.abs(y - event.getY()));
		        builder.setPositiveButton("OK", null);

		        AlertDialog ad = builder.create();
		        ad.show();
		       // }
		        break;
		    }
		    return true;
		}
	};

}