package com.example.prateek.myhome;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import static utilities.APICalls.ON_VALUE;


/**
 * A simple {@link Fragment} subclass.
 */
public class KitchennFragment extends Fragment {

    boolean flag=false;
    boolean flag1=false;
    boolean flag2=false;
    boolean flag3=false;
    ImageView iw,iw1;
    Button onn,onn1;


    public KitchennFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_kitchenn, container, false);
        onn = (Button) view.findViewById(R.id.button3);
        onn1 = (Button) view.findViewById(R.id.button4);
        iw =(ImageView) view.findViewById(R.id.imageView4) ;
        iw1 =(ImageView) view.findViewById(R.id.imageView5) ;

        onn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String val = (String) onn.getText();
                if (val.equals("ON"))
                    hitAPI("1");
                else
                    hitAPI("0");


                if (flag1==false)
                {
                    iw.setImageResource(R.drawable.bbb);
                    flag1=true;
                }


                else
                {
                    iw.setImageResource(R.drawable.offffffffffffffff);
                    flag1=false;
                }


                if(flag==false) {

                    onn.setText("OFF");
                    flag = true;
                }
                else {
                    onn.setText("ON");
                    flag = false;

                }

            }
        });
        onn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String val = (String) onn1.getText();
                if (val.equals("ON"))
                    hitAPI2("1");
                else
                    hitAPI2("0");


                if (flag2==false)
                {
                    iw1.setImageResource(R.drawable.bbb);
                    flag2=true;
                }


                else
                {
                    iw1.setImageResource(R.drawable.offffffffffffffff);
                    flag2=false;
                }


                if(flag3==false) {

                    onn1.setText("OFF");
                    flag3= true;
                }
                else {
                    onn1.setText("ON");
                    flag3 = false;

                }


            }
        });
        return view;


        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_kitchenn, container, false);
    }
    public  void hitAPI(String value) {
        ON_VALUE = value;
        new KitchennFragment.NetworkGAURAV().execute();
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
                URL myUrl = new URL("http://192.168.43.248:3000/bulb5/?on="+ON_VALUE);

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
        new KitchennFragment.NetworkPRATEEK().execute();
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
                URL myUrl = new URL("http://192.168.43.248:3000/bulb6/?on=" + ON_VALUE);

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
