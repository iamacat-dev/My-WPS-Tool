package com.iamacat.mywps;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.stericson.RootTools.RootTools;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private Button setupButton, pixieDust, bruteForce, customPin, wpsButton, macAttack, macAttack2;
    private TextView getVersion, getStatus;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setupButton = findViewById(R.id.setupButton);
        pixieDust = findViewById(R.id.pixieDust);
        bruteForce = findViewById(R.id.bruteForce);
        customPin = findViewById(R.id.customPin);
        wpsButton = findViewById(R.id.wps);
        macAttack = findViewById(R.id.macAttack);
        macAttack2 = findViewById(R.id.macAttack2);

        getVersion = findViewById(R.id.getVersion);
        getStatus = findViewById(R.id.getStatus);

        getVersion.setText(Build.VERSION.RELEASE);
        if (RootTools.isAccessGiven()) {
            getStatus.setText(getResources().getString(R.string.rooted));
        } else {
            getStatus.setText(getResources().getString(R.string.non_root));
        }

        // SharedPreferences সেটআপ
        sharedPreferences = getSharedPreferences("ButtonPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        setupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setupButton.setEnabled(false);
                Intent intent = new Intent(getPackageManager().getLaunchIntentForPackage("com.termux"));
                if (intent != null) {
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Termux Not Installed", Toast.LENGTH_SHORT).show();
                }
                editor.putBoolean("setupClicked", true);
                editor.apply();

                // ৫টি বাটন clickable করা
                setButtonsClickable(true);
                assetsFile(getApplicationContext(), "setup.sh");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        setupButton.setEnabled(true);
                    }
                }, 3000);
            }
        });

        pixieDust.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pixieDust.setEnabled(false);

                Intent intent = new Intent(getPackageManager().getLaunchIntentForPackage("com.termux"));
                if (intent != null) {
                    startActivity(intent);
                    assetsFile(getApplicationContext(), "pixieDust.sh");
                } else {
                    Toast.makeText(MainActivity.this, "Termux Not Installed", Toast.LENGTH_SHORT).show();
                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        pixieDust.setEnabled(true);
                    }
                }, 3000);
            }
        });
        bruteForce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bruteForce.setEnabled(false);
                Intent intent = new Intent(getPackageManager().getLaunchIntentForPackage("com.termux"));
                if (intent != null) {
                    startActivity(intent);
                    assetsFile(getApplicationContext(), "bruteForce.sh");
                } else {
                    Toast.makeText(MainActivity.this, "Termux Not Installed", Toast.LENGTH_SHORT).show();
                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        bruteForce.setEnabled(true);
                    }
                }, 3000);

            }
        });
        customPin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customPin.setEnabled(false);
                Intent intent = new Intent(getPackageManager().getLaunchIntentForPackage("com.termux"));
                if (intent != null) {
                    startActivity(intent);
                    assetsFile(getApplicationContext(), "customPin.sh");
                } else {
                    Toast.makeText(MainActivity.this, "Termux Not Installed", Toast.LENGTH_SHORT).show();
                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        customPin.setEnabled(true);
                    }
                }, 3000);

            }
        });
        wpsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wpsButton.setEnabled(false);
                Intent intent = new Intent(getPackageManager().getLaunchIntentForPackage("com.termux"));
                if (intent != null) {
                    startActivity(intent);
                    assetsFile(getApplicationContext(), "wps.sh");
                } else {
                    Toast.makeText(MainActivity.this, "Termux Not Installed", Toast.LENGTH_SHORT).show();
                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        wpsButton.setEnabled(true);
                    }
                }, 3000);
            }
        });
        macAttack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                macAttack.setEnabled(false);
                Intent intent = new Intent(getPackageManager().getLaunchIntentForPackage("com.termux"));
                if (intent != null) {
                    startActivity(intent);
                    assetsFile(getApplicationContext(), "Tenda_AE59A0.sh");
                } else {
                    Toast.makeText(MainActivity.this, "Termux Not Installed", Toast.LENGTH_SHORT).show();
                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        macAttack.setEnabled(true);
                    }
                }, 3000);
            }
        });
        macAttack2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                macAttack2.setEnabled(false);
                Intent intent = new Intent(getPackageManager().getLaunchIntentForPackage("com.termux"));
                if (intent != null) {
                    startActivity(intent);
                    assetsFile(getApplicationContext(), "TP-Link_6A0C.sh");
                } else {
                    Toast.makeText(MainActivity.this, "Termux Not Installed", Toast.LENGTH_SHORT).show();
                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        macAttack2.setEnabled(true);
                    }
                }, 3000);
            }
        });
    }
    public static void assetsFile(Context context, String fileName) {
        File scriptFile = new File(context.getCacheDir(), fileName);

        try {
            // Copy script from assets to /cache directory
            try (InputStream in = context.getAssets().open(fileName);
                 FileOutputStream out = new FileOutputStream(scriptFile)) {

                byte[] buffer = new byte[1024];
                int read;
                while ((read = in.read(buffer)) != -1) {
                    out.write(buffer, 0, read);
                }
            }

            // Make the script executable
            scriptFile.setExecutable(true);

            // Execute the script with root permissions
            Process process = Runtime.getRuntime().exec("su");
            DataOutputStream outputStream = new DataOutputStream(process.getOutputStream());

            outputStream.writeBytes(scriptFile.getAbsolutePath() + "\n");
            outputStream.writeBytes("exit\n");
            outputStream.flush();

            process.waitFor();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    private void setButtonsClickable(boolean clickable) {
        pixieDust.setClickable(clickable);
        bruteForce.setClickable(clickable);
        customPin.setClickable(clickable);
        wpsButton.setClickable(clickable);
        macAttack.setClickable(clickable);
        macAttack2.setClickable(clickable);
        if (!clickable) {
            pixieDust.setBackgroundColor(getResources().getColor(R.color.background));
            bruteForce.setBackgroundColor(getResources().getColor(R.color.background));
            customPin.setBackgroundColor(getResources().getColor(R.color.background));
            wpsButton.setBackgroundColor(getResources().getColor(R.color.background));
            macAttack.setBackgroundColor(getResources().getColor(R.color.background));
            macAttack2.setBackgroundColor(getResources().getColor(R.color.background));
        } else {
            pixieDust.setBackgroundColor(getResources().getColor(R.color.Turquoise_Surf));
            bruteForce.setBackgroundColor(getResources().getColor(R.color.Turquoise_Surf));
            customPin.setBackgroundColor(getResources().getColor(R.color.Turquoise_Surf));
            wpsButton.setBackgroundColor(getResources().getColor(R.color.Turquoise_Surf));
            macAttack.setBackgroundColor(getResources().getColor(R.color.Turquoise_Surf));
            macAttack2.setBackgroundColor(getResources().getColor(R.color.Turquoise_Surf));
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        RootTools.isAccessGiven();
        // SharedPreferences থেকে setupClicked মান রিড করা
        boolean isSetupClicked = sharedPreferences.getBoolean("setupClicked", false);

        if (isSetupClicked) {
            // যদি setup বাটন ক্লিক করা থাকে, তাহলে বাটনগুলো clickable হবে
            setButtonsClickable(true);
            setupButton.setClickable(false);
            setupButton.setBackgroundColor(getResources().getColor(R.color.background));
        } else {
            // যদি setup বাটন ক্লিক না করা থাকে, তাহলে বাটনগুলো disable থাকবে
            setButtonsClickable(false);

        }
    }

}