package com.example.prateek.myhome;


import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import utilities.APICalls;


public class HallFragment extends Fragment {
    private static String ON_VALUE;
    boolean flag=false;
    boolean flag1=false;
    boolean flag2=false;
    boolean flag3=false;
    ImageView bulbOne, bulbTwo;
    Button bulbOneBtn, bulbTwoBtn;
    TextView textView;



    public HallFragment() {



    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_hall, container, false);
        bulbOneBtn = (Button) view.findViewById(R.id.bulb_one_btn);
        bulbTwoBtn = (Button) view.findViewById(R.id.bulb_two_btn);
        bulbOne =(ImageView) view.findViewById(R.id.bulb_one) ;
        bulbTwo =(ImageView) view.findViewById(R.id.bulb_two) ;
        bulbOneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String val = (String) bulbOneBtn.getText();
                if(val.equals("ON"))
                    hitAPI("1");
                else
                    hitAPI("0");


                if (flag1 == false) {
                        bulbOne.setImageResource(R.drawable.bbb);
                        flag1 = true;
                    } else {
                        bulbOne.setImageResource(R.drawable.offffffffffffffff);
                        flag1 = false;
                    }



                    if (flag == false) {

                        bulbOneBtn.setText("OFF");
                        flag = true;
                    } else {
                        bulbOneBtn.setText("ON");
                        flag = false;

                    }
                }

        });

        bulbTwoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String val = (String) bulbTwoBtn.getText();
                if(val.equals("ON"))
                    hitAPI2("1");
                else
                    hitAPI2("0");

                if (flag2 == false) {
                    bulbTwo.setImageResource(R.drawable.bbb);
                    flag2 = true;
                } else {
                    bulbTwo.setImageResource(R.drawable.offffffffffffffff);
                    flag2 = false;
                }





                if (flag3 == false) {

                    bulbTwoBtn.setText("OFF");
                    flag3 = true;
                } else {
                    bulbTwoBtn.setText("ON");
                    flag3 = false;

                }
            }

        });
        return view;

    }

    public  void hitAPI(String value) {
        ON_VALUE = value;
        new NetworkGAURAV().execute();
    }

     class NetworkGAURAV extends AsyncTask<String,Void,String> {

        public static final String REQUEST_METHOD = "GET";
        public static final int READ_TIMEOUT = 15000;
        public static final int CONNECTION_TIMEOUT = 15000;

        @Override
        protected String doInBackground(String... strings) {
            String result = null;
            String inputLine;

            try {
                //Create a URL object holding our url
                URL myUrl = new URL("http://192.168.43.248:3000/bulb3/?on="+ON_VALUE);

                //Create a connection
                HttpURLConnection connection =(HttpURLConnection)
                        myUrl.openConnection();

                //Set methods and timeouts
                connection.setRequestMethod(REQUEST_METHOD);
                connection.setReadTimeout(READ_TIMEOUT);
                connection.setConnectTimeout(CONNECTION_TIMEOUT);

                //Connect to our url
                connection.connect();

                //Create a new InputStreamReader
                InputStreamReader streamReader = new
                        InputStreamReader(connection.getInputStream());

                //Create a new buffered reader and String Builder
                BufferedReader reader = new BufferedReader(streamReader);
                StringBuilder stringBuilder = new StringBuilder();

                //Check if the line we are reading is not null
                while((inputLine = reader.readLine()) != null){
                    stringBuilder.append(inputLine);
                }

                //Close our InputStream and Buffered reader
                reader.close();
                streamReader.close();

                //Set our result equal to our stringBuilder
                result = stringBuilder.toString();

            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return result;
        }

        @Override
        protected void onPostExecute (String s){

          //  Log.i("Gaurav", "onPostExecute: "+s);
            super.onPostExecute(s);

        }
    }
    public  void hitAPI2(String value) {
        ON_VALUE = value;
        new NetworkPRATEEK().execute();
    }


    class NetworkPRATEEK extends AsyncTask<String,Void,String> {

        public static final String REQUEST_METHOD = "GET";
        public static final int READ_TIMEOUT = 15000;
        public static final int CONNECTION_TIMEOUT = 15000;

        @Override
        protected String doInBackground(String... strings) {
            String result = null;
            String inputLine;

            try {
                //Create a URL object holding our url
                URL myUrl = new URL("http://192.168.43.248:3000/bulb4/?on=" + ON_VALUE);

                //Create a connection
                HttpURLConnection connection = (HttpURLConnection)
                        myUrl.openConnection();

                //Set methods and timeouts
                connection.setRequestMethod(REQUEST_METHOD);
                connection.setReadTimeout(READ_TIMEOUT);
                connection.setConnectTimeout(CONNECTION_TIMEOUT);

                //Connect to our url
                connection.connect();

                //Create a new InputStreamReader
                InputStreamReader streamReader = new
                        InputStreamReader(connection.getInputStream());

                //Create a new buffered reader and String Builder
                BufferedReader reader = new BufferedReader(streamReader);
                StringBuilder stringBuilder = new StringBuilder();

                //Check if the line we are reading is not null
                while ((inputLine = reader.readLine()) != null) {
                    stringBuilder.append(inputLine);
                }

                //Close our InputStream and Buffered reader
                reader.close();
                streamReader.close();

                //Set our result equal to our stringBuilder
                result = stringBuilder.toString();

            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return result;
        }

        @Override
        protected void onPostExecute(String s) {

           // Log.i("Gaurav", "onPostExecute: "+s);
            super.onPostExecute(s);

        }
    }
}
