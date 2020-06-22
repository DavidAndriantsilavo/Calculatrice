package mg.didavid.calculatrice;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Handler;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.os.Bundle;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Boolean pointTest=false;

    EditText editText;
    Button btLeft, btRight, btParaOpen, btParaClose, btSquare, btPow, btSqrt, btMod,
            btPi, btSin, btCos, btTan, btInv,
            btExp, btLog, btLog2, btLog10, btCbrt;
    Button bt0,bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,btPoint;
    Button btPlus,btMoins,btMul,btDiv,btEgal,btDel,btClear;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=findViewById(R.id.editText);
        editText.requestFocus();
        editText.setShowSoftInputOnFocus(false);

        btLeft=findViewById(R.id.btLeft);
            btLeft.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos=editText.getSelectionStart();
                    if(pos > 0){
                        editText.setSelection(pos-1);
                    }
                }
            });

        btRight=findViewById(R.id.btRight);
            btRight.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos=editText.getSelectionStart();
                    if(pos < editText.length()){
                        editText.setSelection(pos+1);
                    }
                }
            });
        btParaOpen=findViewById(R.id.btParaOpen);
            btParaOpen.setOnClickListener(this);

        btParaClose=findViewById(R.id.btParaClose);
            btParaClose.setOnClickListener(this);

        btSquare=findViewById(R.id.btSquare);
        btSquare.setText(Html.fromHtml("x<sup>2</sup>"));
        btSquare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos=editText.getSelectionStart();
                editText.getText().insert(pos,"^2");
                editText.setSelection(pos+2);
                pointTest = false;
            }
        });

        btPow=findViewById(R.id.btPow);
            btPow.setOnClickListener(this);

        btSqrt=findViewById(R.id.btSqrt);
            btSqrt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos=editText.getSelectionStart();
                    editText.getText().insert(pos,"sqrt()");
                    editText.setSelection(pos+5);
                    pointTest = false;
                }
            });

        btMod=findViewById(R.id.btMod);
            btMod.setOnClickListener(this);

        btPi=findViewById(R.id.btPi);
            btPi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos=editText.getSelectionStart();
                    editText.getText().insert(pos,"π");
                    editText.setSelection(pos+1);
                    pointTest = false;
                }
            });

        btSin=findViewById(R.id.btSin);
            btSin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos=editText.getSelectionStart();
                    editText.getText().insert(pos,"sin()");
                    editText.setSelection(pos+4);
                    pointTest = false;
                }
            });

        btCos=findViewById(R.id.btCos);
            btCos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos=editText.getSelectionStart();
                    editText.getText().insert(pos,"cos()");
                    editText.setSelection(pos+4);
                    pointTest = false;
                }
            });

        btTan=findViewById(R.id.btTan);
            btTan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos=editText.getSelectionStart();
                    editText.getText().insert(pos,"tan()");
                    editText.setSelection(pos+4);
                    pointTest = false;
                }
            });

        btInv=findViewById(R.id.btInv);
        btInv.setText(Html.fromHtml("x<sup>-1</sup>"));
            btInv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos=editText.getSelectionStart();
                    editText.getText().insert(pos,"^(-1)");
                    editText.setSelection(pos+5);
                    pointTest = false;
                }
            });

        btExp=findViewById(R.id.btExp);
            btExp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos=editText.getSelectionStart();
                    editText.getText().insert(pos,"exp()");
                    editText.setSelection(pos+4);
                    pointTest = false;
                }
            });

        btLog=findViewById(R.id.btLog);
            btLog.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos=editText.getSelectionStart();
                    editText.getText().insert(pos,"log()");
                    editText.setSelection(pos+4);
                    pointTest = false;
                }
            });

        btLog2=findViewById(R.id.btLog2);
            btLog2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos=editText.getSelectionStart();
                    editText.getText().insert(pos,"log2()");
                    editText.setSelection(pos+5);
                    pointTest = false;
                }
            });

        btLog10=findViewById(R.id.btLog10);
            btLog10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos=editText.getSelectionStart();
                    editText.getText().insert(pos,"log10()");
                    editText.setSelection(pos+6);
                    pointTest = false;
                }
            });

        btCbrt=findViewById(R.id.btCbrt);
        btCbrt.setText(Html.fromHtml("<sup>3</sup>√"));
            btCbrt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos=editText.getSelectionStart();
                    editText.getText().insert(pos,"cbrt()");
                    editText.setSelection(pos+5);
                    pointTest = false;
                }
            });

        bt0=findViewById(R.id.bt0);
            bt0.setOnClickListener(this);
        bt1=findViewById(R.id.bt1);
            bt1.setOnClickListener(this);
        bt2=findViewById(R.id.bt2);
            bt2.setOnClickListener(this);
        bt3=findViewById(R.id.bt3);
            bt3.setOnClickListener(this);
        bt4=findViewById(R.id.bt4);
            bt4.setOnClickListener(this);
        bt5=findViewById(R.id.bt5);
            bt5.setOnClickListener(this);
        bt6=findViewById(R.id.bt6);
            bt6.setOnClickListener(this);
        bt7=findViewById(R.id.bt7);
            bt7.setOnClickListener(this);
        bt8=findViewById(R.id.bt8);
            bt8.setOnClickListener(this);
        bt9=findViewById(R.id.bt9);
            bt9.setOnClickListener(this);

        btPoint=findViewById(R.id.btPoint);
            btPoint.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(!pointTest)
                    {
                        int pos=editText.getSelectionStart();
                        editText.getText().insert(pos,".");
                        editText.setSelection(pos+1);
                        pointTest=true;
                    }
                }
            });
        btPlus=findViewById(R.id.btPlus);
            btPlus.setOnClickListener(this);
        btMoins=findViewById(R.id.btMoins);
            btMoins.setOnClickListener(this);
        btMul=findViewById(R.id.btMul);
            btMul.setOnClickListener(this);
        btDiv=findViewById(R.id.btDiv);
            btDiv.setOnClickListener(this);
        btEgal=findViewById(R.id.btEgal);
            btEgal.setOnClickListener(new View.OnClickListener(){
                @SuppressLint("SetTextI18n")
                @Override
                public void onClick(View v) {
                    if (editText.getText().length() > 0) {
                        Expression e = new ExpressionBuilder(editText.getText().toString()).build();

                        try{
                            double result = e.evaluate();
                            editText.setText(String.format("%s", result));
                            editText.setSelection(editText.getText().length());
                        }
                        catch (Exception exep){
                            editText.setText("ERROR");
                            Runnable r =  new Runnable(){
                                @Override
                                public void run() {
                                    editText.setText("");
                                }
                            };

                            Handler h = new Handler();
                            h.postDelayed(r, 2000);
                        }
                    }
                }
            });

        btDel=findViewById(R.id.btDel);
            btDel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //String str = editText.getText().toString();
                    SpannableStringBuilder str=new SpannableStringBuilder(editText.getText());
                    int posStart= editText.getSelectionStart();
                    int posEnd=editText.getSelectionEnd();

                    if (str.length() > 0 && posEnd>0) {
                        try{
                            if(str.charAt(posEnd)=='.')
                            {
                                pointTest=false;
                            }
                        }
                        catch(Exception exc){

                        }

                        str.replace(posStart-1,posEnd,"");
                        editText.setText(str);
                        editText.setSelection(posEnd-1);
                    }
                }
            });

        btClear=findViewById(R.id.btClear);
            btClear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    pointTest = false;
                    SpannableStringBuilder str = new SpannableStringBuilder(editText.getText());

                    if (str.length() > 0) {
                        editText.setText("");
                    }
                }
            });
    }

    public void onClick(View v)
    {
        int pos=editText.getSelectionStart();
        Button b=(Button)v;

        int id = b.getId();
        if (id == R.id.btParaOpen) {
            pointTest = false;
        } else if (id == R.id.btParaClose) {
            pointTest = false;
        } else if (id == R.id.btPow) {
            pointTest = false;
        } else if (id == R.id.btMod) {
            pointTest = false;
        } else if (id == R.id.btPlus) {
            pointTest = false;
        } else if (id == R.id.btMoins) {
            pointTest = false;
        } else if (id == R.id.btMul) {
            pointTest = false;
        } else if (id == R.id.btDiv) {
            pointTest = false;
        }

        //editText.setText(editText.getText().toString() + b.getText().toString());
        editText.getText().insert(pos,b.getText().toString());
        editText.setSelection(pos+1);
    }
}
